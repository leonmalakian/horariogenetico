package ar.com.protean.horario.genetico.algoritmo2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import ar.com.protean.horario.genetico.Materia;
import ar.com.protean.horario.genetico.MatrixCurso;
import ar.com.protean.horario.genetico.Profesor;
import ar.com.protean.horario.genetico.algoritmo.RandomSingleton;
import ar.com.protean.horario.genetico.enums.CursoEnum;
import ar.com.protean.horario.genetico.enums.DiaEnum;
import ar.com.protean.horario.genetico.enums.HorarioEnum;
import ar.com.protean.horario.genetico.enums.MateriaEnum;

public class TurnoGenetico {
	private final int CANT_MAXIMA_INDIVIDUOS = 1000;
	private final int CANT_MINIMA_INDIVIDUOS = 500;
	private final int CANT_NO_EVOLUCION_MAXIMA = 50;
	private final int CANT_MUTANTES_X_GENERACION = 10;
	
	private List<TurnoIndividuo> poblacion;
	private Collection<Profesor> profesores;

	private int ultimoMejorEstado = 0;
	private int cantGeneracionesSinEvolucionar = 0;
	private TurnoIndividuo mejorIndividuo;
	
	public TurnoGenetico(Map<CursoEnum, MatrixCurso> cursos, Collection<Profesor> profesores){
		this.profesores = profesores;
		this.poblacion = this.generarPoblacionInicial(cursos);
	}
	
	private TurnoGenetico(){}

	public Map<CursoEnum, MatrixCurso> getMejorSolucion(){
		while(this.existeEvolution()) {
    		this.seleccion();
    		this.cruzamiento();
    		this.mutacion();
    		System.out.println("Ultimo mejor estado: " + this.ultimoMejorEstado);
    	}
		return this.mejorIndividuo.getCursos();
	}

	private void mutacion() {
		int INTENTOS = 25;
		for (int i = 0; i < this.CANT_MUTANTES_X_GENERACION; i++){
			int j = 0;
			TurnoIndividuo mutante = this.poblacion.get(RandomSingleton.getInstance().nextInt(this.poblacion.size()));
			CursoEnum curso = CursoEnum.values()[RandomSingleton.getInstance().nextInt(CursoEnum.values().length)];
			Materia materia = mutante.getMateria(curso, DiaEnum.values()[RandomSingleton.getInstance().nextInt(DiaEnum.values().length)], HorarioEnum.values()[RandomSingleton.getInstance().nextInt(HorarioEnum.values().length)]);
			while (materia.tieneDocenteAsignado() || j < INTENTOS){
				curso = CursoEnum.values()[RandomSingleton.getInstance().nextInt(CursoEnum.values().length)];
				materia = mutante.getMateria(curso, DiaEnum.values()[RandomSingleton.getInstance().nextInt(DiaEnum.values().length)], HorarioEnum.values()[RandomSingleton.getInstance().nextInt(HorarioEnum.values().length)]);
				j++;
			}
			Materia reemplazada = mutante.getMateria(curso, DiaEnum.values()[RandomSingleton.getInstance().nextInt(DiaEnum.values().length)], HorarioEnum.values()[RandomSingleton.getInstance().nextInt(HorarioEnum.values().length)]);
			
			mutante.getCursos().get(curso).setMateria(reemplazada.getDia(), reemplazada.getHora(), materia);
			mutante.getCursos().get(curso).setMateria(materia.getDia(), materia.getHora(), reemplazada);
		}
	}

	private void cruzamiento() {
		int hijosBobos = 0;
		int buenos = 0;
		int normales = 0;
		for (int i = 0; i < CANT_MAXIMA_INDIVIDUOS; i = i + 2){
			TurnoIndividuo mama = this.poblacion.get(RandomSingleton.getInstance().nextInt(this.poblacion.size()));
			TurnoIndividuo papa = this.poblacion.get(RandomSingleton.getInstance().nextInt(this.poblacion.size()));
			TurnoIndividuo hijo = mama.cruzar(papa);
			hijo.setEstado(hijo.calcularEstado());
			if (hijo.getEstado() <= mama.getEstado() && hijo.getEstado() <= papa.getEstado()){
				hijosBobos++;
				i--;
			}else{
				this.poblacion.add(hijo);
				if (hijo.getEstado() > mama.getEstado() && hijo.getEstado() > papa.getEstado()){
					buenos++;
				}else{
					normales++;
				}
			}
		}
		System.out.println("hijos bobos: " + hijosBobos);
		System.out.println("hijos buenos: " + buenos);
		System.out.println("hijos normales: " + normales);
	}

	private void seleccion() {
		int pasaron = 0;
		List<TurnoIndividuo> nuevaGeneracion = new ArrayList<TurnoIndividuo>();
		Double umbral;
		while(nuevaGeneracion.size() < CANT_MINIMA_INDIVIDUOS){
			umbral = RandomSingleton.getInstance().nextDouble();
			System.out.println("el umbral es de " + umbral);
			for (TurnoIndividuo individuo : this.poblacion){
				System.out.println("probabilidad " + individuo.getProbabilidadSupervivencia());
				if (individuo.getProbabilidadSupervivencia() >= umbral){
					pasaron++;
					nuevaGeneracion.add(individuo);
				}
			}
//			System.out.println("Van pasando: " + pasaron);
		}
	}

	private boolean existeEvolution() {
		this.calcularEstado();
		Collections.sort(this.poblacion);
		this.mejorIndividuo = this.poblacion.get(0);
		System.out.println("mejor " + this.mejorIndividuo.getEstado());
		if (this.ultimoMejorEstado < this.mejorIndividuo.getEstado()){
			this.ultimoMejorEstado = this.mejorIndividuo.getEstado();
		}else{
			this.cantGeneracionesSinEvolucionar++;
		}
		return CANT_NO_EVOLUCION_MAXIMA > cantGeneracionesSinEvolucionar;
	}

	private void calcularEstado() {
		int acumulado = 0;
		for (TurnoIndividuo individuo : this.poblacion){
			individuo.setEstado(individuo.calcularEstado());
			acumulado = acumulado + individuo.getEstado();
		}
		TurnoIndividuo.setProbabilidadAcumulada(acumulado / CANT_MAXIMA_INDIVIDUOS);
	}

	private List<TurnoIndividuo> generarPoblacionInicial(Map<CursoEnum, MatrixCurso> cursos) {
		List<TurnoIndividuo> poblacion = new ArrayList<TurnoIndividuo>();
		TurnoIndividuo individuo = new TurnoIndividuo(this.profesores);
		for (int j = 0; j < CANT_MAXIMA_INDIVIDUOS; j++){
			for (int i = 0; i < CursoEnum.values().length; i++){
				MatrixCurso matrixCurso = cursos.get(CursoEnum.values()[i]).clone();
				matrixCurso.randomize();
				for (int dia = 0; dia < DiaEnum.values().length; dia++){
					for (int hora = 0; hora < HorarioEnum.values().length; hora++){
						Materia materia = matrixCurso.getMateria(DiaEnum.values()[dia], HorarioEnum.values()[hora]);
						Profesor p = null;
						if (materia != null){
							p = this.getRandomProfesor(materia.getNombre());
						}
						if (p != null){
							p.asignoMateria(DiaEnum.values()[dia], HorarioEnum.values()[hora], materia);
						}
					}
				}
				individuo.addCurso(CursoEnum.values()[i], matrixCurso);
			}
			poblacion.add(individuo);
		}
		return poblacion;
	}

	private Profesor getRandomProfesor(MateriaEnum nombreMateria) {
		Collection<Profesor> candidatos = new HashSet<Profesor>();
		for (Profesor p : this.profesores){
			for (MateriaEnum materia : p.getMaterias()){
				if (materia.equals(nombreMateria)){
					candidatos.add(p);
				}
			}
		}
		if (candidatos.size() > 0){
			return (Profesor) candidatos.toArray()[RandomSingleton.getInstance().nextInt(candidatos.size())];
		}
		return null;
	}
}