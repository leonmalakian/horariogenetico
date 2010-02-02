package ar.com.protean.horario.genetico.algoritmo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import ar.com.protean.horario.genetico.Materia;
import ar.com.protean.horario.genetico.MatrixCurso;
import ar.com.protean.horario.genetico.Profesor;
import ar.com.protean.horario.genetico.enums.DiaEnum;
import ar.com.protean.horario.genetico.enums.HorarioEnum;
import ar.com.protean.horario.genetico.enums.MateriaEnum;

public class HorarioGenetico {
	private final int CANT_NO_EVOLUCION_MAXIMA = 50;
	private final int CANT_INDIVIDUOS = 1000;
	private final int CANT_MUTANTES_X_GENERACION = 10;
	
	private MatrixCurso matrixCurso;
	private Collection<Profesor> profesores;
	private List<Individuo> poblacion;
	private int ultimoMejorPeso = 999999999;
	private int cantGeneracionesSinEvolucionar = 0;
	private Individuo mejorIndividuo;
	
	public HorarioGenetico(MatrixCurso matrixCurso, Collection<Profesor> profesores){
		this.matrixCurso = matrixCurso;
		this.profesores = profesores;
	}
	
	public MatrixCurso getMejorSolucion(){
		this.poblacion = this.generarPoblacionInicial();
		this.calcularPeso();
		while(this.existeEvolution() && !this.existeIndividuoPerfecto()) {
    		this.seleccion();
    		this.cruzamiento();
    		this.mutacion();
    		this.calcularPeso();
    		System.out.println("Ultimo mejor peso: " + this.ultimoMejorPeso);
    	}
		return this.mejorIndividuo.getMatrixCurso();
	}

	private void mutacion() {
		for (int k = 0; k < this.CANT_MUTANTES_X_GENERACION; k++){
			Individuo mutante = this.poblacion.get(RandomSingleton.getInstance().nextInt(this.poblacion.size()));
			for (int i = 0; i < DiaEnum.values().length; i++){
				for (int j = 0; j < HorarioEnum.values().length; j++){
					Materia materia = mutante.getMatrixCurso().getMateria(DiaEnum.values()[i], HorarioEnum.values()[j]);
					if (!materia.tieneDocenteAsignado()){
						if (RandomSingleton.getInstance().nextBoolean()){
							this.cambiarElDictador(DiaEnum.values()[i], HorarioEnum.values()[j], materia);
						}else{
							this.intercambiarXYAlAzar(mutante, i, j);
						}
					}
				}
			}
		}
	}

	private void intercambiarXYAlAzar(Individuo mutante, int i, int j) {
		Materia pisada = mutante.getMatrixCurso().getMateria(DiaEnum.values()[i], HorarioEnum.values()[j]);
		int iAzar = RandomSingleton.getInstance().nextInt(DiaEnum.values().length);
		int jAzar = RandomSingleton.getInstance().nextInt(HorarioEnum.values().length);
		mutante.getMatrixCurso().setMateria(DiaEnum.values()[i], HorarioEnum.values()[j], mutante.getMatrixCurso().getMateria(DiaEnum.values()[iAzar], HorarioEnum.values()[jAzar]));
		mutante.getMatrixCurso().setMateria(DiaEnum.values()[iAzar], HorarioEnum.values()[jAzar], pisada);
	}

	private void cambiarElDictador(DiaEnum dia, HorarioEnum hora, Materia materia) {
		Boolean listo = false;
		for (Profesor profesor : this.profesores) {
			for (MateriaEnum m : profesor.getMaterias()){
				if (m.equals(materia.getNombre()) && !profesor.equals(materia.getDictador())){
					profesor.asignoMateria(dia, hora, materia);
					listo = true;
					break;
				}
			}
			if (listo) { break; }
		}
	}

	private void cruzamiento() {
		int evolucionados = 0;
		int normales = 0;
		int bobos = 0;
		for (int i = 0; i < this.CANT_INDIVIDUOS; i = i + 2){
			Individuo mama = this.poblacion.get(RandomSingleton.getInstance().nextInt(this.CANT_INDIVIDUOS));
			Individuo papa = this.poblacion.get(RandomSingleton.getInstance().nextInt(this.CANT_INDIVIDUOS));
			Individuo hijo = mama.reproducir(papa);
			if (mama.getPeso() > hijo.getPeso() && papa.getPeso() > hijo.getPeso()){
				evolucionados++;
				this.poblacion.add(hijo);
			}else {
				if (mama.getPeso() > hijo.getPeso() || papa.getPeso() > hijo.getPeso()){
					normales++;
					this.poblacion.add(hijo);
				}else{
					i--;
					bobos++;
				}
			}
		}
		System.out.println("hijos bobos: " + bobos);
		System.out.println("hijos normales: " + normales);
		System.out.println("hijos evolucionados: " + evolucionados);
	}

	private void seleccion() {
		int cantDeUnos = 10;
		int cantProxima = cantDeUnos - 1;
		int j = 0;
		List<Individuo> nuevaGeneracion = new ArrayList<Individuo>();
		for (int i = 0; i < this.CANT_INDIVIDUOS; i++){
			if (cantDeUnos - i > 0){
				nuevaGeneracion.add(this.poblacion.get(j));
			}else{
				j++;
				cantDeUnos = cantDeUnos + (cantProxima);
				cantProxima--;
				if (cantProxima >= 0){
					nuevaGeneracion.add(this.poblacion.get(j));
				}else{
					nuevaGeneracion.add(this.poblacion.get(RandomSingleton.getInstance().nextInt(this.poblacion.size())));
				}
			}
		}
		this.poblacion = nuevaGeneracion;
	}

	private boolean existeIndividuoPerfecto() {
		if (this.mejorIndividuo.getPeso() == 0){
			System.out.println("Enorabuena! existe un individuo perfecto!");
			return true;
		}
		return false;
	}

	private boolean existeEvolution() {
		this.mejorIndividuo = this.seleccionarMejorIndividuo();
		if (this.mejorIndividuo.getPeso() < this.ultimoMejorPeso){
			this.ultimoMejorPeso = this.mejorIndividuo.getPeso();
			this.cantGeneracionesSinEvolucionar = 0;
		}else{
			this.cantGeneracionesSinEvolucionar++;
		}
		return (cantGeneracionesSinEvolucionar < this.CANT_NO_EVOLUCION_MAXIMA);
	}

	private Individuo seleccionarMejorIndividuo() {
		Collections.sort(this.poblacion);
		return this.poblacion.get(0);
	}

	private void calcularPeso() {
		for (Individuo individuo : this.poblacion) {
			individuo.setPeso(individuo.calcularPesoActual());
		}
	}

	private List<Individuo> generarPoblacionInicial() {
		List<Individuo> poblacion = new ArrayList<Individuo>();
		for (int i = 0; i < CANT_INDIVIDUOS; i++){
			Individuo individuo = new Individuo(this.matrixCurso.clone(), this.profesores);
			poblacion.add(individuo);
		}
		return poblacion;
	}
}