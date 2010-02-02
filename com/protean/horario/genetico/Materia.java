package ar.com.protean.horario.genetico;

import ar.com.protean.horario.genetico.enums.DiaEnum;
import ar.com.protean.horario.genetico.enums.HorarioEnum;
import ar.com.protean.horario.genetico.enums.MateriaEnum;

public class Materia implements Cloneable{
	public static final Materia NO_DISPONIBLE = generarNoDisponible();
	private MateriaEnum nombre;
	private Profesor dictador;
	private DiaEnum dia;
	private HorarioEnum hora;

	public Profesor getDictador() {
		if (dictador == null) {
			Profesor nullDictador = new Profesor();
			nullDictador.setNombre("NO ASIGNADO");
			return nullDictador;
		}
		return dictador;
	}

	protected void setDictador(Profesor dictador) {
		this.dictador = dictador;
	}

	public MateriaEnum getNombre() {
		return nombre;
	}

	public void setNombre(MateriaEnum nombre) {
		this.nombre = nombre;
	}
	
	public DiaEnum getDia() {
		return this.dia;
	}

	private void setDia(DiaEnum dia) {
		this.dia = dia;
	}

	public HorarioEnum getHora() {
		return this.hora;
	}

	private void setHora(HorarioEnum hora) {
		this.hora = hora;
	}
	
	@Override
	public Materia clone() {
		Materia materia = new Materia();
		//Todas las materias apuntan al mismo profe, así vemos actualizada
		//su disponibilidad en cada una de las horas.
		materia.setDictador(this.dictador);
		materia.setDia(this.dia);
		materia.setHora(this.hora);
		materia.setNombre(this.nombre);
		return materia;
	}

	/**
	 * @deprecated Si el objetivo es vincular una hora de un profesor
	 * a una materia, utilice Profesor.asignarMateria
	 */
	protected void setHorario(DiaEnum dia, HorarioEnum hora) {
		this.setDia(dia); 
		this.setHora(hora);
	}
	
	private static Materia generarNoDisponible(){
		Materia m = new Materia();
		m.setNombre(MateriaEnum.NO_DISPONIBLE);
		return m;
	}

	public boolean tieneDocenteAsignado() {
		if (this.getNombre() == null){
			return true;
		}
		if (this.getNombre().equals(Materia.NO_DISPONIBLE.getNombre())){
			return false;
		}
		Materia materiaDelProfe = this.getDictador().getMateria(this.getDia(), this.getHora());
		return (materiaDelProfe != null && this.getNombre().equals(materiaDelProfe.getNombre()));
	}
}