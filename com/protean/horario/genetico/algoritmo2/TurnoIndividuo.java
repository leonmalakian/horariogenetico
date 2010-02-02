package ar.com.protean.horario.genetico.algoritmo2;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import ar.com.protean.horario.genetico.Materia;
import ar.com.protean.horario.genetico.MatrixCurso;
import ar.com.protean.horario.genetico.Profesor;
import ar.com.protean.horario.genetico.algoritmo.RandomSingleton;
import ar.com.protean.horario.genetico.enums.CursoEnum;
import ar.com.protean.horario.genetico.enums.DiaEnum;
import ar.com.protean.horario.genetico.enums.HorarioEnum;

public class TurnoIndividuo implements Comparable<TurnoIndividuo>, Cloneable{
	private static final int PESO_X_DOCENTE_ASIGNADO = 1;
	private static final int PESO_X_OCUPAR_HORAS = 5;
	private static int probabilidadAcumulada;
	private Map<CursoEnum, MatrixCurso> cursos;
	private Integer estado;
	private Collection<Profesor> profesores;
	
	public TurnoIndividuo(Collection<Profesor> profesores){
		this.profesores = profesores;
	}
	
	public void addCurso(CursoEnum curso, MatrixCurso matrixCurso) {
		this.getCursos().put(curso, matrixCurso);
	}

	protected Map<CursoEnum, MatrixCurso> getCursos() {
		if (this.cursos == null){
			this.cursos = new HashMap<CursoEnum, MatrixCurso>();
		}
		return this.cursos;
	}

	public int calcularEstado() {
		int estado = 0;
		Map<Profesor, Integer> horasPorProfesor = new HashMap<Profesor, Integer>();
		for(int i = 0; i < CursoEnum.values().length; i++){
			MatrixCurso mc = cursos.get(CursoEnum.values()[i]);
			for (int dia = 0; dia < DiaEnum.values().length; dia++){
				estado = estado + this.calcularEstadoDia(mc.getHorarioDia(DiaEnum.values()[dia]));
				for (int hora = 0; hora < HorarioEnum.values().length; hora++){
					Materia m = mc.getMateria(DiaEnum.values()[dia], HorarioEnum.values()[hora]);
					estado = estado + this.calcularEstadoMateria(m);
					// cuento las horas que se le asignaron a cada profesor
					if (horasPorProfesor.get(m.getDictador()) == null){
						horasPorProfesor.put(m.getDictador(), new Integer("1"));
					}else{
						horasPorProfesor.put(m.getDictador(), horasPorProfesor.get(m.getDictador()) + 1);
					}
				}
			}
		}
		for(Profesor profesor : this.profesores){
			Integer horasOcupadas = horasPorProfesor.get(profesor);
			if (horasOcupadas != null){
				int dif = horasOcupadas - profesor.getHorasACubrir();
				if (dif >= 0){
					estado = estado + PESO_X_OCUPAR_HORAS;
				}
			}
		}
		return estado;
	}

	private int calcularEstadoDia(Map<HorarioEnum, Materia> horarioDia) {
		// TODO: Asignar peso según la distribución de las materias y de los prfesores
		return 0;
	}

	private int calcularEstadoMateria(Materia materia) {
		if (materia.getNombre() == null){
			//si la hora libre está al final de la mañana es tan bueno como tener un profesor asignado
			//si la hora libre no está en la última hora de la mañana, es peor que no tener un docente asignado
			if (materia.getHora().equals(HorarioEnum.QuintaOPreHora)){
				return PESO_X_DOCENTE_ASIGNADO;
			}else{
				return -1 * PESO_X_DOCENTE_ASIGNADO;
			}
		}
		if (materia.tieneDocenteAsignado()){
			return PESO_X_DOCENTE_ASIGNADO;
		}else{
			return 0;
		}
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}
	
	public Integer getEstado(){
		return this.estado;
	}

	/**
	 * Los mejores son los de mayor estado, por eso comparo alrevez
	 */
	public int compareTo(TurnoIndividuo o) {
		return o.getEstado().compareTo(this.getEstado());
	}
	
	public Double getProbabilidadSupervivencia(){
		return (this.getEstado().doubleValue() / probabilidadAcumulada);
	}

	public static void setProbabilidadAcumulada(int acumulado) {
		probabilidadAcumulada = acumulado;
	}

	/**
	 * Tomo una materia al azar del hijo y una al azar del padre, piso la materia del hijo con la
	 * obtenida del padre, luego busco dónde está la análoga obtenida del padre dentro del hijo y 
	 * pongo en dicha posición la que acabo de pisar en el hijo.
	 * @param papa
	 * @return
	 */
	public TurnoIndividuo cruzar(TurnoIndividuo papa) {
		TurnoIndividuo hijo = this.clone();
		CursoEnum nombreCurzoAlAzar = CursoEnum.values()[RandomSingleton.getInstance().nextInt(CursoEnum.values().length)];
		MatrixCurso cursoAlAzar = hijo.getCurso(nombreCurzoAlAzar);
		MatrixCurso mismoCursoDelPadre = papa.getCurso(nombreCurzoAlAzar);
		
		Materia materiaHijo = cursoAlAzar.getMateria(DiaEnum.values()[RandomSingleton.getInstance().nextInt(DiaEnum.values().length)], HorarioEnum.values()[RandomSingleton.getInstance().nextInt(HorarioEnum.values().length)]);		
		Materia materiaPadre = mismoCursoDelPadre.getMateria(DiaEnum.values()[RandomSingleton.getInstance().nextInt(DiaEnum.values().length)], HorarioEnum.values()[RandomSingleton.getInstance().nextInt(HorarioEnum.values().length)]);
//		while (materiaHijo.getNombre() == null || materiaPadre.getNombre() == null){
//			materiaHijo = cursoAlAzar.getMateria(DiaEnum.values()[RandomSingleton.getInstance().nextInt(DiaEnum.values().length)], HorarioEnum.values()[RandomSingleton.getInstance().nextInt(HorarioEnum.values().length)]);		
//			materiaPadre = mismoCursoDelPadre.getMateria(DiaEnum.values()[RandomSingleton.getInstance().nextInt(DiaEnum.values().length)], HorarioEnum.values()[RandomSingleton.getInstance().nextInt(HorarioEnum.values().length)]);
//		}

		// Si voy a poner una hora libre, la pongo en la hora del mediodía
		if (materiaPadre.getNombre() == null){
			cursoAlAzar.setMateria(materiaHijo.getDia(), HorarioEnum.QuintaOPreHora, materiaPadre);
			Materia duplicada = cursoAlAzar.getMateria(DiaEnum.values()[RandomSingleton.getInstance().nextInt(DiaEnum.values().length)], HorarioEnum.values()[RandomSingleton.getInstance().nextInt(HorarioEnum.values().length)]);
			while (duplicada.getNombre() != null){
				duplicada = cursoAlAzar.getMateria(DiaEnum.values()[RandomSingleton.getInstance().nextInt(DiaEnum.values().length)], HorarioEnum.values()[RandomSingleton.getInstance().nextInt(HorarioEnum.values().length)]);
			}
			cursoAlAzar.setMateria(duplicada.getDia(), duplicada.getHora(), materiaHijo);
		}else{
			cursoAlAzar.setMateria(materiaHijo.getDia(), materiaHijo.getHora(), materiaPadre);
			Materia duplicada = cursoAlAzar.getMateria(DiaEnum.values()[RandomSingleton.getInstance().nextInt(DiaEnum.values().length)], HorarioEnum.values()[RandomSingleton.getInstance().nextInt(HorarioEnum.values().length)]);
			while (!materiaPadre.getNombre().equals(duplicada.getNombre())){
				duplicada = cursoAlAzar.getMateria(DiaEnum.values()[RandomSingleton.getInstance().nextInt(DiaEnum.values().length)], HorarioEnum.values()[RandomSingleton.getInstance().nextInt(HorarioEnum.values().length)]);
			}
			cursoAlAzar.setMateria(duplicada.getDia(), duplicada.getHora(), materiaHijo);
		}
		return hijo;
	}
	
	@Override
	protected TurnoIndividuo clone(){
		TurnoIndividuo clon = new TurnoIndividuo(this.profesores);
		for (int i = 0; i < CursoEnum.values().length; i++){
			clon.addCurso(CursoEnum.values()[i], this.getCurso(CursoEnum.values()[i]).clone());
		}
		return clon;
	}

	private MatrixCurso getCurso(CursoEnum curso) {
		return this.cursos.get(curso);
	}

	public Materia getMateria(CursoEnum curso, DiaEnum dia, HorarioEnum hora) {
		return this.cursos.get(curso).getMateria(dia, hora);
	}
}