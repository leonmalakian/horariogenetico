package ar.com.protean.horario.genetico.algoritmo;

import java.util.Collection;
import java.util.HashSet;

import ar.com.protean.horario.genetico.Materia;
import ar.com.protean.horario.genetico.MatrixCurso;
import ar.com.protean.horario.genetico.Profesor;
import ar.com.protean.horario.genetico.enums.DiaEnum;
import ar.com.protean.horario.genetico.enums.HorarioEnum;
import ar.com.protean.horario.genetico.enums.MateriaEnum;

public class Individuo implements Comparable<Individuo>, Cloneable{
	private MatrixCurso matrixCurso;
	private Integer peso;

	private Individuo(){
		super();
	}
	
	public Individuo(MatrixCurso matrixCurso, Collection<Profesor> profesores) {
		this.matrixCurso = matrixCurso;
		this.matrixCurso.randomize();
		for (int i = 0; i < DiaEnum.values().length; i++) {
			for (int j = 0; j < HorarioEnum.values().length; j++){
				Materia materia = this.matrixCurso.getMateria(DiaEnum.values()[i], HorarioEnum.values()[j]);
				this.getRandomProfesor(materia.getNombre(), profesores).asignoMateria(DiaEnum.values()[i], HorarioEnum.values()[j], materia);
			}
		}
	}

	public Individuo reproducir(Individuo papa) {
		int CORTE = 75;
		Individuo hijo = this.clone();
		int iteraciones = 0;
		Materia ultimaMateriaCambiada = null;
		
		while (iteraciones < CORTE){
			//este método modifica a la instancia de hijo y devuelve que materia se cambió
			ultimaMateriaCambiada = this.mezcloUnCromosoma(papa, hijo, ultimaMateriaCambiada);
			hijo.setPeso(hijo.calcularPesoActual());
			if (papa.peso.compareTo(hijo.peso) > 0 && this.peso.compareTo(hijo.peso) > 0){
				//si el hijo es mejor que los dos padres, corto iteración
				iteraciones = CORTE + 1; 
			}else{
				iteraciones++;
			}
			if (ultimaMateriaCambiada == null){
				//si no se cambia ninguna materia, quiere decir que tengo una solución optima o con un solo error
				/**
				 * TODO: Esto sucede ahora, ver si esto no cambia cuando cambien las formas de pesar o de reproducción
				 */
				iteraciones = CORTE + 1;
			}
		}
		return hijo;
	}
	
	private Materia mezcloUnCromosoma(Individuo papa, Individuo hijo, Materia ultimaCambiada) {
		Materia candidato = null;
		Materia materiaPapa;
		Materia materia;
		Boolean listo = false;
		//busco la falla del clon de mamá
		for (int i = 0; i < DiaEnum.values().length; i++){
			for (int j = 0; j < HorarioEnum.values().length; j++){
				candidato = hijo.matrixCurso.getMateria(DiaEnum.values()[i], HorarioEnum.values()[j]);
				if (!candidato.tieneDocenteAsignado()){
					if (ultimaCambiada == null || !ultimaCambiada.equals(candidato)){
						listo = true;
						break;
					}
				}
			}
			if (listo) { break; }
		}
		//Si listo es false, es porque el clon no tiene defectos o el único defecto es el que ya cambié anteriormente
		if (listo){
			//reemplazo la falla del clon de mamá por lo que tenga papá en dicha posición
			materiaPapa = papa.getMatrixCurso().getMateria(candidato.getDia(), candidato.getHora());
			hijo.matrixCurso.setMateria(candidato.getDia(), candidato.getHora(), materiaPapa.clone());
			
			//busco dónde estaba la materia que acabo de poner y ahí es dónde coloco el "fallo" del clon de mamá, quizás ahí si esté bien
			listo = false;
			for (int i = 0; i < DiaEnum.values().length; i++){
				for (int j = 0; j < HorarioEnum.values().length; j++){
					materia = hijo.matrixCurso.getMateria(DiaEnum.values()[i], HorarioEnum.values()[j]);
					if (materiaPapa.getNombre().equals(materia.getNombre()) && !(ultimaCambiada != null && materia.equals(ultimaCambiada))){
						hijo.matrixCurso.setMateria(DiaEnum.values()[i], HorarioEnum.values()[j], candidato);
						return candidato;
					}
				}
			}
		}
		return null;
	}

	private Profesor getRandomProfesor(MateriaEnum materia, Collection<Profesor> profesores) {
		Collection<Profesor> candidatos = new HashSet<Profesor>();
		for (Profesor profesor : profesores) {
			for (MateriaEnum materiaNombre : profesor.getMaterias()){
				if (materiaNombre.equals(materia)){
					candidatos.add(profesor);
				}
			}
		}
		int size = candidatos.size();
		if (size > 0){
			return (Profesor) candidatos.toArray()[RandomSingleton.getInstance().nextInt(size)];
		}else{
			return null;
		}
	}
	
	public MatrixCurso getMatrixCurso(){
		return this.matrixCurso;
	}

	public Integer getPeso() {
		return this.peso;
	}

	public void setPeso(Integer peso) {
		this.peso = peso;
	}

	public int compareTo(Individuo o) {
		return this.peso.compareTo(o.peso);
	}

	public Integer calcularPesoActual() {
		int peso = 0;
		for (int i = 0; i < DiaEnum.values().length; i++){
			for (int j = 0; j < HorarioEnum.values().length; j++){
				if (!this.matrixCurso.getMateria(DiaEnum.values()[i], HorarioEnum.values()[j]).tieneDocenteAsignado()){
					peso++;
				}
			}
		}
		return peso;
	}
	
	@Override
	protected Individuo clone() {
		Individuo i = new Individuo();
		i.matrixCurso = this.matrixCurso.clone();
		i.peso = this.peso;
		return i;
	}
}