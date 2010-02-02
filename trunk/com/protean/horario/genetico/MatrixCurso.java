package ar.com.protean.horario.genetico;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import ar.com.protean.horario.genetico.algoritmo.RandomSingleton;
import ar.com.protean.horario.genetico.enums.DiaEnum;
import ar.com.protean.horario.genetico.enums.HorarioEnum;
import ar.com.protean.horario.genetico.enums.MateriaEnum;

public class MatrixCurso implements Cloneable{
	private Map<DiaEnum, Map<HorarioEnum, Materia>> horario;
	
	public MatrixCurso(Map<MateriaEnum, Integer> asignaturas) {
		int dia = 0;
		int hora = 0;
		this.horario = new HashMap<DiaEnum, Map<HorarioEnum, Materia>>();
		for (MateriaEnum materia: asignaturas.keySet()) {
			for (int i = 0; i < asignaturas.get(materia); i++){
				Map<HorarioEnum, Materia> value = new HashMap<HorarioEnum, Materia>();
				Materia m = new Materia();
				m.setNombre(materia);
				value.put(HorarioEnum.values()[hora], m);
				this.horario.put(DiaEnum.values()[dia], value);
				if (hora < HorarioEnum.values().length - 1){
					hora++;
				}else{
					hora = 0;
					dia++;
				}
			}
		}
	}
	
	public MatrixCurso(){
		this.horario = new HashMap<DiaEnum, Map<HorarioEnum,Materia>>();
		for(int i = 0; i < DiaEnum.values().length; i++){
			Map<HorarioEnum, Materia> value = null;
			for (int j = 0; j < HorarioEnum.values().length; j++){
				value = new HashMap<HorarioEnum, Materia>();
				value.put(HorarioEnum.values()[j], new Materia());
			}
			this.horario.put(DiaEnum.values()[i], value);
		}
	}

	/**
	 * La materia es colocada en el día y hora indicado. También setea estas coordenadas
	 * a la materia en si, manteniendo la referencia cruzada
	 * @param dia
	 * @param hora
	 * @param materia
	 */
	@SuppressWarnings("deprecation")
	public void setMateria(DiaEnum dia, HorarioEnum hora, Materia materia){
		if (this.horario == null){
			this.horario = new HashMap<DiaEnum, Map<HorarioEnum, Materia>>();
		}
		Map<HorarioEnum, Materia> horaDia = this.horario.get(dia);
		if (horaDia == null){
			horaDia = new HashMap<HorarioEnum, Materia>();
		}
		materia.setHorario(dia, hora);
		horaDia.put(hora, materia);
		this.horario.put(dia, horaDia);
	}
	
	public Materia getMateria(DiaEnum dia, HorarioEnum hora){
		Materia materia = this.horario.get(dia).get(hora);
		if (materia == null){
			materia = new Materia();
		}
		return materia;
	}
	
	public void randomize(){
		Collection<String> coordenadas = new HashSet<String>();
		for (Integer i = 1; i <= DiaEnum.values().length; i++){
			for (Integer j = 1; j <= HorarioEnum.values().length; j++){
				coordenadas.add(i.toString() + "," +j.toString());
			}
		}
		//tomo coordenadas al azar
		String xy = (String) coordenadas.toArray()[RandomSingleton.getInstance().nextInt(coordenadas.size())];
		coordenadas.remove(xy);
		int diaX_ini = new Integer(xy.substring(0, xy.indexOf(",")));
		int horaY_ini = new Integer(xy.substring(xy.indexOf(",") + 1));
		//guardo el elemento que voy a mover a otro lado
		Materia mover = this.horario.get(DiaEnum.values()[diaX_ini - 1]).get(HorarioEnum.values()[horaY_ini - 1]);
		while (!coordenadas.isEmpty()){
			//tomo coordenadas al azar
			xy = (String) coordenadas.toArray()[RandomSingleton.getInstance().nextInt(coordenadas.size())];
			coordenadas.remove(xy);
			int diaX = new Integer(xy.substring(0, xy.indexOf(",")));
			int horaY = new Integer(xy.substring(xy.indexOf(",") + 1));
			//guardo el que voy a pisar para reasignarlo luego en otro lugar
			Materia pisoEste = this.horario.get(DiaEnum.values()[diaX - 1]).get(HorarioEnum.values()[horaY - 1]);
			this.setMateria(DiaEnum.values()[diaX - 1], HorarioEnum.values()[horaY - 1], mover);
			mover = pisoEste;
			//this.horario.put(key, value)
		}
		this.setMateria(DiaEnum.values()[diaX_ini - 1], HorarioEnum.values()[horaY_ini - 1], mover);
	}
	
	@Override
	public MatrixCurso clone(){
		MatrixCurso mc = new MatrixCurso();
		for (Integer i = 0; i < DiaEnum.values().length; i++){
			for (Integer j = 0; j < HorarioEnum.values().length; j++){
				Materia materia = this.getMateria(DiaEnum.values()[i], HorarioEnum.values()[j]);
				if (materia != null){
					mc.setMateria(DiaEnum.values()[i], HorarioEnum.values()[j], materia.clone());
				}
			}
		}
		return mc;
	}

	public Map<HorarioEnum, Materia> getHorarioDia(DiaEnum dia) {
		return this.horario.get(dia);
	}
}