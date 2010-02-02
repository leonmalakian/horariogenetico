package ar.com.protean.horario.genetico.test;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import junit.framework.TestCase;
import ar.com.protean.horario.genetico.Materia;
import ar.com.protean.horario.genetico.MatrixCurso;
import ar.com.protean.horario.genetico.Profesor;
import ar.com.protean.horario.genetico.algoritmo2.TurnoGenetico;
import ar.com.protean.horario.genetico.enums.CursoEnum;
import ar.com.protean.horario.genetico.enums.DiaEnum;
import ar.com.protean.horario.genetico.enums.HorarioEnum;
import ar.com.protean.horario.genetico.enums.MateriaEnum;

public class HorarioGeneticoUnitTest extends TestCase {
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
	}
	public void testTurnoGenetico(){
		TurnoGenetico tg = new TurnoGenetico(this.levantoRequerimiento(), this.getProfesores());
		this.visualizarCursos(tg.getMejorSolucion());
	}

	private Map<CursoEnum, MatrixCurso> levantoRequerimiento() {
		Map<CursoEnum, MatrixCurso> requerimiento = new HashMap<CursoEnum, MatrixCurso>();
		Map<MateriaEnum, Integer> asignaturas = new HashMap<MateriaEnum, Integer>();
		asignaturas.put(MateriaEnum.C_de_C, 2);
		asignaturas.put(MateriaEnum.Ciencias_Naturales, 4);
		asignaturas.put(MateriaEnum.Ciencias_Sociales, 4);
		asignaturas.put(MateriaEnum.Educacion_Artistica, 2);
		asignaturas.put(MateriaEnum.Ingles, 2);
		asignaturas.put(MateriaEnum.Matematica, 4);
		asignaturas.put(MateriaEnum.Practicas_del_Lenguaje, 4);
		MatrixCurso primeroA = new MatrixCurso(asignaturas);
		requerimiento.put(CursoEnum.Primero_A, primeroA );
		//las materias de primeroB sin iguales a las de primeroA
		MatrixCurso primeroB = new MatrixCurso(asignaturas);
		requerimiento.put(CursoEnum.Primero_B, primeroB );
		
		asignaturas.clear();
		asignaturas.put(MateriaEnum.DDHH, 2);
		asignaturas.put(MateriaEnum.Cu_y_Co, 2);
		asignaturas.put(MateriaEnum.Fisica, 2);
		asignaturas.put(MateriaEnum.Geografia, 3);
		asignaturas.put(MateriaEnum.Historia, 3);
		asignaturas.put(MateriaEnum.Ingles, 2);
		asignaturas.put(MateriaEnum.Lengua_y_Lit, 2);
		asignaturas.put(MateriaEnum.Matematica, 4);
		asignaturas.put(MateriaEnum.Salud_y_Adol, 2);
		asignaturas.put(MateriaEnum.T_I_C, 2);
		MatrixCurso primeroH = new MatrixCurso(asignaturas);
		requerimiento.put(CursoEnum.Primero_H, primeroH );
		
		asignaturas.clear();
		asignaturas.put(MateriaEnum.DDHH, 2);
		asignaturas.put(MateriaEnum.Fisica, 2);
		asignaturas.put(MateriaEnum.Geografia, 2);
		asignaturas.put(MateriaEnum.Historia, 2);
		asignaturas.put(MateriaEnum.Ingles, 2);
		asignaturas.put(MateriaEnum.Lengua_y_Lit, 2);
		asignaturas.put(MateriaEnum.Matematica, 4);
		asignaturas.put(MateriaEnum.S_I_C, 4);
		asignaturas.put(MateriaEnum.Salud_y_Adol, 2);
		asignaturas.put(MateriaEnum.T_I_C, 2);
		MatrixCurso primeroPrimeroE = new MatrixCurso(asignaturas);
		requerimiento.put(CursoEnum.Primero_Primero_E, primeroPrimeroE);
		
		asignaturas.clear();
		asignaturas.put(MateriaEnum.Biologia, 2);
		asignaturas.put(MateriaEnum.C_de_C, 2);
		asignaturas.put(MateriaEnum.Educacion_Artistica, 2);
		asignaturas.put(MateriaEnum.Fisico_Quimica, 2);
		asignaturas.put(MateriaEnum.Geografia, 2);
		asignaturas.put(MateriaEnum.Historia, 2);
		asignaturas.put(MateriaEnum.Ingles, 2);
		asignaturas.put(MateriaEnum.Matematica, 4);
		asignaturas.put(MateriaEnum.Practicas_del_Lenguaje, 4);
		MatrixCurso segundoA = new MatrixCurso(asignaturas);
		requerimiento.put(CursoEnum.Segundo_A, segundoA);
		//las materias de segundoB son las mismas que de segundoA
		MatrixCurso segundoB = new MatrixCurso(asignaturas);
		requerimiento.put(CursoEnum.Segundo_B, segundoB);
		
		asignaturas.clear();
		asignaturas.put(MateriaEnum.Historia, 3);
		asignaturas.put(MateriaEnum.Quimica, 2);
		asignaturas.put(MateriaEnum.Filosofia, 2);
		asignaturas.put(MateriaEnum.Matematica, 4);
		asignaturas.put(MateriaEnum.Lengua_y_Lit, 2);
		asignaturas.put(MateriaEnum.Ingles, 2);
		asignaturas.put(MateriaEnum.Geografia, 3);
		asignaturas.put(MateriaEnum.Psicologia, 2);
		asignaturas.put(MateriaEnum.E_C_I__Microemp, 2);
		asignaturas.put(MateriaEnum.E_C_I__I_P_C, 2);
		MatrixCurso segundoH = new MatrixCurso(asignaturas);
		requerimiento.put(CursoEnum.Segundo_H, segundoH );
		
		asignaturas.clear();
		asignaturas.put(MateriaEnum.Derecho, 3);
		asignaturas.put(MateriaEnum.Filosofia, 2);
		asignaturas.put(MateriaEnum.Geografia, 2);
		asignaturas.put(MateriaEnum.Historia, 2);
		asignaturas.put(MateriaEnum.Ingles, 2);
		asignaturas.put(MateriaEnum.Lengua_y_Lit, 2);
		asignaturas.put(MateriaEnum.Matematica, 4);
		asignaturas.put(MateriaEnum.Quimica, 2);
		asignaturas.put(MateriaEnum.S_I_C, 2);
		asignaturas.put(MateriaEnum.Teoria_de_las_Org, 2);
		asignaturas.put(MateriaEnum.E_C_I__Microemp, 2);
		MatrixCurso segundoPrimeroE = new MatrixCurso(asignaturas);
		requerimiento.put(CursoEnum.Segundo_Primero_E, segundoPrimeroE);
		//las materias de segundoSegundoE son iguales a las de segundoPrimeroE
		MatrixCurso segundoSegundoE = new MatrixCurso(asignaturas);
		requerimiento.put(CursoEnum.Segundo_Segundo_E, segundoSegundoE);

		asignaturas.clear();
		asignaturas.put(MateriaEnum.Biologia, 2);
		asignaturas.put(MateriaEnum.C_de_C, 2);
		asignaturas.put(MateriaEnum.Educacion_Artistica, 2);
		asignaturas.put(MateriaEnum.Fisico_Quimica, 2);
		asignaturas.put(MateriaEnum.Geografia, 2);
		asignaturas.put(MateriaEnum.Historia, 2);
		asignaturas.put(MateriaEnum.Ingles, 2);
		asignaturas.put(MateriaEnum.Matematica, 4);
		asignaturas.put(MateriaEnum.Practicas_del_Lenguaje, 4);
		MatrixCurso terceroA = new MatrixCurso(asignaturas);
		requerimiento.put(CursoEnum.Tercero_A, terceroA);
		//las materias de terceroA son iguales a las de terceroB
		MatrixCurso terceroB = new MatrixCurso(asignaturas);
		requerimiento.put(CursoEnum.Tercero_B, terceroB);
		
		asignaturas.clear();
		asignaturas.put(MateriaEnum.Biologia, 2);
		asignaturas.put(MateriaEnum.C_E_C, 2);
		asignaturas.put(MateriaEnum.Economia, 2);
		asignaturas.put(MateriaEnum.Ingles, 2);
		asignaturas.put(MateriaEnum.Lengua_y_Lit, 3);
		asignaturas.put(MateriaEnum.Matematica, 2);
		asignaturas.put(MateriaEnum.Proy_De_Inv, 3);
		asignaturas.put(MateriaEnum.Sociologia, 3);
		asignaturas.put(MateriaEnum.E_C_I__Per_Mu_Co, 2);
		asignaturas.put(MateriaEnum.E_C_I__S_I_L, 2);
		MatrixCurso terceroH = new MatrixCurso(asignaturas);
		requerimiento.put(CursoEnum.Tercero_H, terceroH);
		
		asignaturas.clear();
		asignaturas.put(MateriaEnum.Biologia, 2);
		asignaturas.put(MateriaEnum.C_E_C, 2);
		asignaturas.put(MateriaEnum.Economia, 3);
		asignaturas.put(MateriaEnum.Ingles, 2);
		asignaturas.put(MateriaEnum.Lengua_y_Lit, 3);
		asignaturas.put(MateriaEnum.Matematica, 2);
		asignaturas.put(MateriaEnum.Tecnologia_de_Gest, 3);
		asignaturas.put(MateriaEnum.E_C_I__Per_Mu_Co, 2);
		asignaturas.put(MateriaEnum.E_C_I__S_I_C, 3);
		MatrixCurso terceroPrimeroE = new MatrixCurso(asignaturas);
		requerimiento.put(CursoEnum.Tercero_Primero_E, terceroPrimeroE);
		//las materias de terceroPrimeroE son iguales a las de terceroSegundoE
		MatrixCurso terceroSegundoE = new MatrixCurso(asignaturas);
		requerimiento.put(CursoEnum.Tercero_Segundo_E, terceroSegundoE);
		
		return requerimiento;
	}

	private Collection<Profesor> getProfesores() {
		Collection<Profesor> profesores = new HashSet<Profesor>();
		
		Profesor albarez = new Profesor();
		albarez.setNombre("Albarez");
		albarez.addMateria(MateriaEnum.Practicas_del_Lenguaje);
		albarez.setHorasACubrir(8);//estoy cargando solo lo de la mañana
		
		albarez.asignoMateria(DiaEnum.Lunes, HorarioEnum.ManianaPrimera, Materia.NO_DISPONIBLE);
		albarez.asignoMateria(DiaEnum.Lunes, HorarioEnum.ManianaSegunda, Materia.NO_DISPONIBLE);
		albarez.asignoMateria(DiaEnum.Lunes, HorarioEnum.ManianaTercera, Materia.NO_DISPONIBLE);
		albarez.asignoMateria(DiaEnum.Lunes, HorarioEnum.ManianaCuarta, Materia.NO_DISPONIBLE);
		albarez.asignoMateria(DiaEnum.Lunes, HorarioEnum.QuintaOPreHora, Materia.NO_DISPONIBLE);
		
		albarez.asignoMateria(DiaEnum.Miercoles, HorarioEnum.ManianaPrimera, Materia.NO_DISPONIBLE);
		albarez.asignoMateria(DiaEnum.Miercoles, HorarioEnum.ManianaSegunda, Materia.NO_DISPONIBLE);
		albarez.asignoMateria(DiaEnum.Miercoles, HorarioEnum.ManianaTercera, Materia.NO_DISPONIBLE);
		albarez.asignoMateria(DiaEnum.Miercoles, HorarioEnum.ManianaCuarta, Materia.NO_DISPONIBLE);
		albarez.asignoMateria(DiaEnum.Miercoles, HorarioEnum.QuintaOPreHora, Materia.NO_DISPONIBLE);
		
		albarez.asignoMateria(DiaEnum.Jueves, HorarioEnum.ManianaPrimera, Materia.NO_DISPONIBLE);
		albarez.asignoMateria(DiaEnum.Jueves, HorarioEnum.ManianaSegunda, Materia.NO_DISPONIBLE);
		albarez.asignoMateria(DiaEnum.Jueves, HorarioEnum.ManianaTercera, Materia.NO_DISPONIBLE);
		albarez.asignoMateria(DiaEnum.Jueves, HorarioEnum.ManianaCuarta, Materia.NO_DISPONIBLE);
		albarez.asignoMateria(DiaEnum.Jueves, HorarioEnum.QuintaOPreHora, Materia.NO_DISPONIBLE);
		
		albarez.asignoMateria(DiaEnum.Viernes, HorarioEnum.QuintaOPreHora, Materia.NO_DISPONIBLE);
		profesores.add(albarez);
		
		Profesor andrada = new Profesor();
		andrada.setNombre("Andrada");
		andrada.addMateria(MateriaEnum.Cu_y_Co);
		andrada.addMateria(MateriaEnum.E_C_I__Microemp);
		andrada.addMateria(MateriaEnum.E_C_I__Per_Mu_Co);
		andrada.addMateria(MateriaEnum.Proy_De_Inv);
		andrada.addMateria(MateriaEnum.Sociologia);
		andrada.setHorasACubrir(18);
		
		andrada.asignoMateria(DiaEnum.Lunes, HorarioEnum.ManianaTercera, Materia.NO_DISPONIBLE);
		andrada.asignoMateria(DiaEnum.Lunes, HorarioEnum.ManianaCuarta, Materia.NO_DISPONIBLE);
		andrada.asignoMateria(DiaEnum.Lunes, HorarioEnum.QuintaOPreHora, Materia.NO_DISPONIBLE);
		
		andrada.asignoMateria(DiaEnum.Martes, HorarioEnum.ManianaCuarta, Materia.NO_DISPONIBLE);
		andrada.asignoMateria(DiaEnum.Martes, HorarioEnum.QuintaOPreHora, Materia.NO_DISPONIBLE);
		
		andrada.asignoMateria(DiaEnum.Miercoles, HorarioEnum.ManianaPrimera, Materia.NO_DISPONIBLE);
		andrada.asignoMateria(DiaEnum.Miercoles, HorarioEnum.ManianaSegunda, Materia.NO_DISPONIBLE);
		profesores.add(andrada);
		
		Profesor benary = new Profesor();
		benary.setNombre("Benary");
		benary.addMateria(MateriaEnum.S_I_C);
		benary.addMateria(MateriaEnum.Tecnologia_de_Gest);
		benary.addMateria(MateriaEnum.E_C_I__S_I_C);
		benary.setHorasACubrir(24);
		
		benary.asignoMateria(DiaEnum.Lunes, HorarioEnum.QuintaOPreHora, Materia.NO_DISPONIBLE);
		profesores.add(benary);
		
		Profesor bongiovanni = new Profesor();
		bongiovanni.setNombre("Bongiovanni");
		bongiovanni.addMateria(MateriaEnum.Educacion_Artistica);
		bongiovanni.setHorasACubrir(6);
		
		bongiovanni.asignoMateria(DiaEnum.Lunes, HorarioEnum.ManianaPrimera, Materia.NO_DISPONIBLE);
		bongiovanni.asignoMateria(DiaEnum.Lunes, HorarioEnum.ManianaSegunda, Materia.NO_DISPONIBLE);
		bongiovanni.asignoMateria(DiaEnum.Lunes, HorarioEnum.ManianaTercera, Materia.NO_DISPONIBLE);
		bongiovanni.asignoMateria(DiaEnum.Lunes, HorarioEnum.ManianaCuarta, Materia.NO_DISPONIBLE);
		bongiovanni.asignoMateria(DiaEnum.Lunes, HorarioEnum.QuintaOPreHora, Materia.NO_DISPONIBLE);
		
		bongiovanni.asignoMateria(DiaEnum.Martes, HorarioEnum.ManianaPrimera, Materia.NO_DISPONIBLE);
		bongiovanni.asignoMateria(DiaEnum.Martes, HorarioEnum.ManianaSegunda, Materia.NO_DISPONIBLE);
		bongiovanni.asignoMateria(DiaEnum.Martes, HorarioEnum.ManianaTercera, Materia.NO_DISPONIBLE);
		bongiovanni.asignoMateria(DiaEnum.Martes, HorarioEnum.ManianaCuarta, Materia.NO_DISPONIBLE);
		bongiovanni.asignoMateria(DiaEnum.Martes, HorarioEnum.QuintaOPreHora, Materia.NO_DISPONIBLE);
		
		bongiovanni.asignoMateria(DiaEnum.Miercoles, HorarioEnum.ManianaPrimera, Materia.NO_DISPONIBLE);
		bongiovanni.asignoMateria(DiaEnum.Miercoles, HorarioEnum.ManianaSegunda, Materia.NO_DISPONIBLE);
		bongiovanni.asignoMateria(DiaEnum.Miercoles, HorarioEnum.ManianaTercera, Materia.NO_DISPONIBLE);
		bongiovanni.asignoMateria(DiaEnum.Miercoles, HorarioEnum.ManianaCuarta, Materia.NO_DISPONIBLE);
		bongiovanni.asignoMateria(DiaEnum.Miercoles, HorarioEnum.QuintaOPreHora, Materia.NO_DISPONIBLE);
		
		bongiovanni.asignoMateria(DiaEnum.Viernes, HorarioEnum.ManianaPrimera, Materia.NO_DISPONIBLE);
		bongiovanni.asignoMateria(DiaEnum.Viernes, HorarioEnum.ManianaSegunda, Materia.NO_DISPONIBLE);
		bongiovanni.asignoMateria(DiaEnum.Viernes, HorarioEnum.ManianaTercera, Materia.NO_DISPONIBLE);
		bongiovanni.asignoMateria(DiaEnum.Viernes, HorarioEnum.ManianaCuarta, Materia.NO_DISPONIBLE);
		bongiovanni.asignoMateria(DiaEnum.Viernes, HorarioEnum.QuintaOPreHora, Materia.NO_DISPONIBLE);
		profesores.add(bongiovanni);
		
		Profesor bratschi = new Profesor();
		bratschi.setNombre("Bratschi");
		bratschi.addMateria(MateriaEnum.Ciencias_Naturales);
		bratschi.addMateria(MateriaEnum.Fisico_Quimica);
		bratschi.addMateria(MateriaEnum.Biologia);
		bratschi.setHorasACubrir(20);
		
		bratschi.asignoMateria(DiaEnum.Martes, HorarioEnum.QuintaOPreHora, Materia.NO_DISPONIBLE);
		
		bratschi.asignoMateria(DiaEnum.Jueves, HorarioEnum.QuintaOPreHora, Materia.NO_DISPONIBLE);
		profesores.add(bratschi);
		
		Profesor bruno = new Profesor();
		bruno.setNombre("Bruno");
		bruno.addMateria(MateriaEnum.Ingles);
		bruno.setHorasACubrir(6);
		
		bruno.asignoMateria(DiaEnum.Lunes, HorarioEnum.ManianaPrimera, Materia.NO_DISPONIBLE);
		bruno.asignoMateria(DiaEnum.Lunes, HorarioEnum.ManianaSegunda, Materia.NO_DISPONIBLE);
		bruno.asignoMateria(DiaEnum.Lunes, HorarioEnum.ManianaTercera, Materia.NO_DISPONIBLE);
		bruno.asignoMateria(DiaEnum.Lunes, HorarioEnum.ManianaCuarta, Materia.NO_DISPONIBLE);
		bruno.asignoMateria(DiaEnum.Lunes, HorarioEnum.QuintaOPreHora, Materia.NO_DISPONIBLE);
		
		bruno.asignoMateria(DiaEnum.Martes, HorarioEnum.ManianaPrimera, Materia.NO_DISPONIBLE);
		bruno.asignoMateria(DiaEnum.Martes, HorarioEnum.ManianaSegunda, Materia.NO_DISPONIBLE);
		bruno.asignoMateria(DiaEnum.Martes, HorarioEnum.ManianaTercera, Materia.NO_DISPONIBLE);
		bruno.asignoMateria(DiaEnum.Martes, HorarioEnum.ManianaCuarta, Materia.NO_DISPONIBLE);
		bruno.asignoMateria(DiaEnum.Martes, HorarioEnum.QuintaOPreHora, Materia.NO_DISPONIBLE);
		
		bruno.asignoMateria(DiaEnum.Miercoles, HorarioEnum.ManianaPrimera, Materia.NO_DISPONIBLE);
		bruno.asignoMateria(DiaEnum.Miercoles, HorarioEnum.ManianaSegunda, Materia.NO_DISPONIBLE);
		bruno.asignoMateria(DiaEnum.Miercoles, HorarioEnum.ManianaTercera, Materia.NO_DISPONIBLE);
		bruno.asignoMateria(DiaEnum.Miercoles, HorarioEnum.ManianaCuarta, Materia.NO_DISPONIBLE);
		bruno.asignoMateria(DiaEnum.Miercoles, HorarioEnum.QuintaOPreHora, Materia.NO_DISPONIBLE);
		
		bruno.asignoMateria(DiaEnum.Jueves, HorarioEnum.ManianaPrimera, Materia.NO_DISPONIBLE);
		bruno.asignoMateria(DiaEnum.Jueves, HorarioEnum.ManianaSegunda, Materia.NO_DISPONIBLE);
		bruno.asignoMateria(DiaEnum.Jueves, HorarioEnum.ManianaTercera, Materia.NO_DISPONIBLE);
		bruno.asignoMateria(DiaEnum.Jueves, HorarioEnum.ManianaCuarta, Materia.NO_DISPONIBLE);
		bruno.asignoMateria(DiaEnum.Jueves, HorarioEnum.QuintaOPreHora, Materia.NO_DISPONIBLE);
		
		bruno.asignoMateria(DiaEnum.Viernes, HorarioEnum.ManianaPrimera, Materia.NO_DISPONIBLE);
		bruno.asignoMateria(DiaEnum.Viernes, HorarioEnum.ManianaSegunda, Materia.NO_DISPONIBLE);
		bruno.asignoMateria(DiaEnum.Viernes, HorarioEnum.ManianaTercera, Materia.NO_DISPONIBLE);
		bruno.asignoMateria(DiaEnum.Viernes, HorarioEnum.ManianaCuarta, Materia.NO_DISPONIBLE);
		bruno.asignoMateria(DiaEnum.Viernes, HorarioEnum.QuintaOPreHora, Materia.NO_DISPONIBLE);
		profesores.add(bruno);
		
		Profesor delupi = new Profesor();
		delupi.setNombre("Delupi");
		delupi.addMateria(MateriaEnum.Ingles);
		delupi.setHorasACubrir(6);
		
		delupi.asignoMateria(DiaEnum.Lunes, HorarioEnum.ManianaPrimera, Materia.NO_DISPONIBLE);
		delupi.asignoMateria(DiaEnum.Lunes, HorarioEnum.ManianaSegunda, Materia.NO_DISPONIBLE);
		delupi.asignoMateria(DiaEnum.Lunes, HorarioEnum.ManianaTercera, Materia.NO_DISPONIBLE);
		delupi.asignoMateria(DiaEnum.Lunes, HorarioEnum.ManianaCuarta, Materia.NO_DISPONIBLE);
		delupi.asignoMateria(DiaEnum.Lunes, HorarioEnum.QuintaOPreHora, Materia.NO_DISPONIBLE);
		
		delupi.asignoMateria(DiaEnum.Martes, HorarioEnum.ManianaPrimera, Materia.NO_DISPONIBLE);
		delupi.asignoMateria(DiaEnum.Martes, HorarioEnum.ManianaSegunda, Materia.NO_DISPONIBLE);
		delupi.asignoMateria(DiaEnum.Martes, HorarioEnum.ManianaTercera, Materia.NO_DISPONIBLE);
		delupi.asignoMateria(DiaEnum.Martes, HorarioEnum.ManianaCuarta, Materia.NO_DISPONIBLE);
		delupi.asignoMateria(DiaEnum.Martes, HorarioEnum.QuintaOPreHora, Materia.NO_DISPONIBLE);
		
		delupi.asignoMateria(DiaEnum.Miercoles, HorarioEnum.ManianaPrimera, Materia.NO_DISPONIBLE);
		delupi.asignoMateria(DiaEnum.Miercoles, HorarioEnum.ManianaSegunda, Materia.NO_DISPONIBLE);
		delupi.asignoMateria(DiaEnum.Miercoles, HorarioEnum.ManianaTercera, Materia.NO_DISPONIBLE);
		delupi.asignoMateria(DiaEnum.Miercoles, HorarioEnum.ManianaCuarta, Materia.NO_DISPONIBLE);
		delupi.asignoMateria(DiaEnum.Miercoles, HorarioEnum.QuintaOPreHora, Materia.NO_DISPONIBLE);
		
		delupi.asignoMateria(DiaEnum.Jueves, HorarioEnum.QuintaOPreHora, Materia.NO_DISPONIBLE);
		
		delupi.asignoMateria(DiaEnum.Viernes, HorarioEnum.ManianaPrimera, Materia.NO_DISPONIBLE);
		delupi.asignoMateria(DiaEnum.Viernes, HorarioEnum.ManianaSegunda, Materia.NO_DISPONIBLE);
		delupi.asignoMateria(DiaEnum.Viernes, HorarioEnum.ManianaTercera, Materia.NO_DISPONIBLE);
		delupi.asignoMateria(DiaEnum.Viernes, HorarioEnum.ManianaCuarta, Materia.NO_DISPONIBLE);
		delupi.asignoMateria(DiaEnum.Viernes, HorarioEnum.QuintaOPreHora, Materia.NO_DISPONIBLE);
		profesores.add(delupi);
		
		Profesor destefano = new Profesor();
		destefano.setNombre("Destéfano");
		destefano.addMateria(MateriaEnum.Historia);
		destefano.setHorasACubrir(4);
		
		destefano.asignoMateria(DiaEnum.Lunes, HorarioEnum.ManianaPrimera, Materia.NO_DISPONIBLE);
		destefano.asignoMateria(DiaEnum.Lunes, HorarioEnum.ManianaSegunda, Materia.NO_DISPONIBLE);
		destefano.asignoMateria(DiaEnum.Lunes, HorarioEnum.ManianaTercera, Materia.NO_DISPONIBLE);
		destefano.asignoMateria(DiaEnum.Lunes, HorarioEnum.ManianaCuarta, Materia.NO_DISPONIBLE);
		destefano.asignoMateria(DiaEnum.Lunes, HorarioEnum.QuintaOPreHora, Materia.NO_DISPONIBLE);
		
		destefano.asignoMateria(DiaEnum.Martes, HorarioEnum.ManianaCuarta, Materia.NO_DISPONIBLE);
		destefano.asignoMateria(DiaEnum.Martes, HorarioEnum.QuintaOPreHora, Materia.NO_DISPONIBLE);
		
		destefano.asignoMateria(DiaEnum.Miercoles, HorarioEnum.ManianaPrimera, Materia.NO_DISPONIBLE);
		destefano.asignoMateria(DiaEnum.Miercoles, HorarioEnum.ManianaSegunda, Materia.NO_DISPONIBLE);
		destefano.asignoMateria(DiaEnum.Miercoles, HorarioEnum.ManianaTercera, Materia.NO_DISPONIBLE);
		destefano.asignoMateria(DiaEnum.Miercoles, HorarioEnum.ManianaCuarta, Materia.NO_DISPONIBLE);
		destefano.asignoMateria(DiaEnum.Miercoles, HorarioEnum.QuintaOPreHora, Materia.NO_DISPONIBLE);
		
		destefano.asignoMateria(DiaEnum.Jueves, HorarioEnum.ManianaTercera, Materia.NO_DISPONIBLE);
		destefano.asignoMateria(DiaEnum.Jueves, HorarioEnum.ManianaCuarta, Materia.NO_DISPONIBLE);
		destefano.asignoMateria(DiaEnum.Jueves, HorarioEnum.QuintaOPreHora, Materia.NO_DISPONIBLE);
		
		destefano.asignoMateria(DiaEnum.Viernes, HorarioEnum.ManianaPrimera, Materia.NO_DISPONIBLE);
		destefano.asignoMateria(DiaEnum.Viernes, HorarioEnum.ManianaSegunda, Materia.NO_DISPONIBLE);
		destefano.asignoMateria(DiaEnum.Viernes, HorarioEnum.ManianaTercera, Materia.NO_DISPONIBLE);
		destefano.asignoMateria(DiaEnum.Viernes, HorarioEnum.ManianaCuarta, Materia.NO_DISPONIBLE);
		destefano.asignoMateria(DiaEnum.Viernes, HorarioEnum.QuintaOPreHora, Materia.NO_DISPONIBLE);
		profesores.add(destefano);
		
		Profesor frete = new Profesor();
		frete.setNombre("Frete");
		frete.addMateria(MateriaEnum.Practicas_del_Lenguaje);
		frete.addMateria(MateriaEnum.Lengua_y_Lit);
		frete.setHorasACubrir(18);
		
		frete.asignoMateria(DiaEnum.Martes, HorarioEnum.ManianaPrimera, Materia.NO_DISPONIBLE);
		frete.asignoMateria(DiaEnum.Martes, HorarioEnum.ManianaSegunda, Materia.NO_DISPONIBLE);
		
		frete.asignoMateria(DiaEnum.Miercoles, HorarioEnum.ManianaTercera, Materia.NO_DISPONIBLE);
		frete.asignoMateria(DiaEnum.Miercoles, HorarioEnum.ManianaCuarta, Materia.NO_DISPONIBLE);
		frete.asignoMateria(DiaEnum.Miercoles, HorarioEnum.QuintaOPreHora, Materia.NO_DISPONIBLE);
		
		frete.asignoMateria(DiaEnum.Jueves, HorarioEnum.QuintaOPreHora, Materia.NO_DISPONIBLE);
		
		frete.asignoMateria(DiaEnum.Viernes, HorarioEnum.QuintaOPreHora, Materia.NO_DISPONIBLE);
		profesores.add(frete);
		
		Profesor gagliardi = new Profesor();
		gagliardi.setNombre("Gagliardi");
		gagliardi.addMateria(MateriaEnum.T_I_C);
		gagliardi.setHorasACubrir(2);
		
		gagliardi.asignoMateria(DiaEnum.Lunes, HorarioEnum.ManianaPrimera, Materia.NO_DISPONIBLE);
		gagliardi.asignoMateria(DiaEnum.Lunes, HorarioEnum.ManianaSegunda, Materia.NO_DISPONIBLE);
		gagliardi.asignoMateria(DiaEnum.Lunes, HorarioEnum.ManianaTercera, Materia.NO_DISPONIBLE);
		gagliardi.asignoMateria(DiaEnum.Lunes, HorarioEnum.ManianaCuarta, Materia.NO_DISPONIBLE);
		gagliardi.asignoMateria(DiaEnum.Lunes, HorarioEnum.QuintaOPreHora, Materia.NO_DISPONIBLE);
		
		gagliardi.asignoMateria(DiaEnum.Martes, HorarioEnum.ManianaPrimera, Materia.NO_DISPONIBLE);
		gagliardi.asignoMateria(DiaEnum.Martes, HorarioEnum.ManianaSegunda, Materia.NO_DISPONIBLE);
		gagliardi.asignoMateria(DiaEnum.Martes, HorarioEnum.ManianaTercera, Materia.NO_DISPONIBLE);
		gagliardi.asignoMateria(DiaEnum.Martes, HorarioEnum.ManianaCuarta, Materia.NO_DISPONIBLE);
		gagliardi.asignoMateria(DiaEnum.Martes, HorarioEnum.QuintaOPreHora, Materia.NO_DISPONIBLE);
		
		gagliardi.asignoMateria(DiaEnum.Miercoles, HorarioEnum.ManianaTercera, Materia.NO_DISPONIBLE);
		gagliardi.asignoMateria(DiaEnum.Miercoles, HorarioEnum.ManianaCuarta, Materia.NO_DISPONIBLE);
		gagliardi.asignoMateria(DiaEnum.Miercoles, HorarioEnum.QuintaOPreHora, Materia.NO_DISPONIBLE);
		
		gagliardi.asignoMateria(DiaEnum.Jueves, HorarioEnum.ManianaPrimera, Materia.NO_DISPONIBLE);
		gagliardi.asignoMateria(DiaEnum.Jueves, HorarioEnum.ManianaSegunda, Materia.NO_DISPONIBLE);
		gagliardi.asignoMateria(DiaEnum.Jueves, HorarioEnum.ManianaTercera, Materia.NO_DISPONIBLE);
		gagliardi.asignoMateria(DiaEnum.Jueves, HorarioEnum.ManianaCuarta, Materia.NO_DISPONIBLE);
		gagliardi.asignoMateria(DiaEnum.Jueves, HorarioEnum.QuintaOPreHora, Materia.NO_DISPONIBLE);
		
		gagliardi.asignoMateria(DiaEnum.Viernes, HorarioEnum.ManianaPrimera, Materia.NO_DISPONIBLE);
		gagliardi.asignoMateria(DiaEnum.Viernes, HorarioEnum.ManianaSegunda, Materia.NO_DISPONIBLE);
		gagliardi.asignoMateria(DiaEnum.Viernes, HorarioEnum.ManianaTercera, Materia.NO_DISPONIBLE);
		gagliardi.asignoMateria(DiaEnum.Viernes, HorarioEnum.ManianaCuarta, Materia.NO_DISPONIBLE);
		gagliardi.asignoMateria(DiaEnum.Viernes, HorarioEnum.QuintaOPreHora, Materia.NO_DISPONIBLE);
		profesores.add(gagliardi);
		
		Profesor gonzalez = new Profesor();
		gonzalez.setNombre("Gonzalez");
		gonzalez.addMateria(MateriaEnum.Biologia);
		gonzalez.addMateria(MateriaEnum.Fisico_Quimica);
		gonzalez.addMateria(MateriaEnum.Salud_y_Adol);
		gonzalez.addMateria(MateriaEnum.Fisica);
		gonzalez.setHorasACubrir(16);
		
		gonzalez.asignoMateria(DiaEnum.Martes, HorarioEnum.ManianaPrimera, Materia.NO_DISPONIBLE);
		gonzalez.asignoMateria(DiaEnum.Martes, HorarioEnum.ManianaSegunda, Materia.NO_DISPONIBLE);
		gonzalez.asignoMateria(DiaEnum.Martes, HorarioEnum.ManianaTercera, Materia.NO_DISPONIBLE);
		gonzalez.asignoMateria(DiaEnum.Martes, HorarioEnum.ManianaCuarta, Materia.NO_DISPONIBLE);
		gonzalez.asignoMateria(DiaEnum.Martes, HorarioEnum.QuintaOPreHora, Materia.NO_DISPONIBLE);
		
		gonzalez.asignoMateria(DiaEnum.Miercoles, HorarioEnum.QuintaOPreHora, Materia.NO_DISPONIBLE);
		
		gonzalez.asignoMateria(DiaEnum.Jueves, HorarioEnum.QuintaOPreHora, Materia.NO_DISPONIBLE);
		
		gonzalez.asignoMateria(DiaEnum.Viernes, HorarioEnum.QuintaOPreHora, Materia.NO_DISPONIBLE);
		profesores.add(gonzalez);
		
		Profesor jimenez = new Profesor();
		jimenez.setNombre("Jimenez");
		jimenez.addMateria(MateriaEnum.C_de_C);
		jimenez.addMateria(MateriaEnum.Geografia);
		jimenez.addMateria(MateriaEnum.Historia);
		jimenez.setHorasACubrir(20);
		
		profesores.add(jimenez);
		
		Profesor leiva = new Profesor();
		leiva.setNombre("Leiva");
		leiva.addMateria(MateriaEnum.Ingles);
		leiva.setHorasACubrir(24);
		profesores.add(leiva);
		
		Profesor loforte = new Profesor();
		loforte.setNombre("Loforte");
		loforte.addMateria(MateriaEnum.Fisica);
		loforte.setHorasACubrir(2);
		
		loforte.asignoMateria(DiaEnum.Lunes, HorarioEnum.ManianaPrimera, Materia.NO_DISPONIBLE);
		loforte.asignoMateria(DiaEnum.Lunes, HorarioEnum.ManianaSegunda, Materia.NO_DISPONIBLE);
		loforte.asignoMateria(DiaEnum.Lunes, HorarioEnum.ManianaTercera, Materia.NO_DISPONIBLE);
		loforte.asignoMateria(DiaEnum.Lunes, HorarioEnum.ManianaCuarta, Materia.NO_DISPONIBLE);
		loforte.asignoMateria(DiaEnum.Lunes, HorarioEnum.QuintaOPreHora, Materia.NO_DISPONIBLE);
		
		loforte.asignoMateria(DiaEnum.Martes, HorarioEnum.ManianaTercera, Materia.NO_DISPONIBLE);
		loforte.asignoMateria(DiaEnum.Martes, HorarioEnum.ManianaCuarta, Materia.NO_DISPONIBLE);
		loforte.asignoMateria(DiaEnum.Martes, HorarioEnum.QuintaOPreHora, Materia.NO_DISPONIBLE);
		
		loforte.asignoMateria(DiaEnum.Miercoles, HorarioEnum.ManianaPrimera, Materia.NO_DISPONIBLE);
		loforte.asignoMateria(DiaEnum.Miercoles, HorarioEnum.ManianaSegunda, Materia.NO_DISPONIBLE);
		loforte.asignoMateria(DiaEnum.Miercoles, HorarioEnum.ManianaTercera, Materia.NO_DISPONIBLE);
		loforte.asignoMateria(DiaEnum.Miercoles, HorarioEnum.ManianaCuarta, Materia.NO_DISPONIBLE);
		loforte.asignoMateria(DiaEnum.Miercoles, HorarioEnum.QuintaOPreHora, Materia.NO_DISPONIBLE);
		
		loforte.asignoMateria(DiaEnum.Jueves, HorarioEnum.ManianaPrimera, Materia.NO_DISPONIBLE);
		loforte.asignoMateria(DiaEnum.Jueves, HorarioEnum.ManianaSegunda, Materia.NO_DISPONIBLE);
		loforte.asignoMateria(DiaEnum.Jueves, HorarioEnum.ManianaTercera, Materia.NO_DISPONIBLE);
		loforte.asignoMateria(DiaEnum.Jueves, HorarioEnum.ManianaCuarta, Materia.NO_DISPONIBLE);
		loforte.asignoMateria(DiaEnum.Jueves, HorarioEnum.QuintaOPreHora, Materia.NO_DISPONIBLE);
		
		loforte.asignoMateria(DiaEnum.Viernes, HorarioEnum.ManianaPrimera, Materia.NO_DISPONIBLE);
		loforte.asignoMateria(DiaEnum.Viernes, HorarioEnum.ManianaSegunda, Materia.NO_DISPONIBLE);
		loforte.asignoMateria(DiaEnum.Viernes, HorarioEnum.ManianaTercera, Materia.NO_DISPONIBLE);
		loforte.asignoMateria(DiaEnum.Viernes, HorarioEnum.ManianaCuarta, Materia.NO_DISPONIBLE);
		loforte.asignoMateria(DiaEnum.Viernes, HorarioEnum.QuintaOPreHora, Materia.NO_DISPONIBLE);
		profesores.add(loforte);
		
		Profesor machado_m = new Profesor();
		machado_m.setNombre("Machado, M");
		machado_m.addMateria(MateriaEnum.Geografia);
		machado_m.setHorasACubrir(7);
		profesores.add(machado_m);
		
		Profesor machado_y = new Profesor();
		machado_y.setNombre("Machado, Y");
		machado_y.addMateria(MateriaEnum.Matematica);
		machado_y.setHorasACubrir(24);
		profesores.add(machado_y);
		
		Profesor maeso = new Profesor();
		maeso.setNombre("Maeso");
		maeso.addMateria(MateriaEnum.C_de_C);
		maeso.addMateria(MateriaEnum.Derecho);
		maeso.setHorasACubrir(10);
		profesores.add(maeso);
		
		Profesor maidana = new Profesor();
		maidana.setNombre("Maidana");
		maidana.addMateria(MateriaEnum.Practicas_del_Lenguaje);
		maidana.addMateria(MateriaEnum.Lengua_y_Lit);
		maidana.setHorasACubrir(17);
		profesores.add(maidana);
		
		Profesor mancinelli = new Profesor();
		mancinelli.setNombre("Mancinelli");
		mancinelli.addMateria(MateriaEnum.Ciencias_Sociales);
		mancinelli.addMateria(MateriaEnum.Historia);
		mancinelli.setHorasACubrir(13);
		
		mancinelli.asignoMateria(DiaEnum.Lunes, HorarioEnum.ManianaPrimera, Materia.NO_DISPONIBLE);
		mancinelli.asignoMateria(DiaEnum.Lunes, HorarioEnum.ManianaSegunda, Materia.NO_DISPONIBLE);
		mancinelli.asignoMateria(DiaEnum.Lunes, HorarioEnum.ManianaTercera, Materia.NO_DISPONIBLE);
		mancinelli.asignoMateria(DiaEnum.Lunes, HorarioEnum.ManianaCuarta, Materia.NO_DISPONIBLE);
		mancinelli.asignoMateria(DiaEnum.Lunes, HorarioEnum.QuintaOPreHora, Materia.NO_DISPONIBLE);
	
		mancinelli.asignoMateria(DiaEnum.Jueves, HorarioEnum.QuintaOPreHora, Materia.NO_DISPONIBLE);
		
		mancinelli.asignoMateria(DiaEnum.Viernes, HorarioEnum.ManianaPrimera, Materia.NO_DISPONIBLE);
		mancinelli.asignoMateria(DiaEnum.Viernes, HorarioEnum.ManianaSegunda, Materia.NO_DISPONIBLE);
		mancinelli.asignoMateria(DiaEnum.Viernes, HorarioEnum.ManianaTercera, Materia.NO_DISPONIBLE);
		mancinelli.asignoMateria(DiaEnum.Viernes, HorarioEnum.ManianaCuarta, Materia.NO_DISPONIBLE);
		mancinelli.asignoMateria(DiaEnum.Viernes, HorarioEnum.QuintaOPreHora, Materia.NO_DISPONIBLE);
		profesores.add(mancinelli);
		
		Profesor perez = new Profesor();
		perez.setNombre("Perez");
		perez.addMateria(MateriaEnum.Teoria_de_las_Org);
		perez.addMateria(MateriaEnum.Economia);
		perez.addMateria(MateriaEnum.E_C_I__S_I_L);
		perez.setHorasACubrir(11);
		
		perez.asignoMateria(DiaEnum.Miercoles, HorarioEnum.ManianaPrimera, Materia.NO_DISPONIBLE);
		perez.asignoMateria(DiaEnum.Miercoles, HorarioEnum.ManianaSegunda, Materia.NO_DISPONIBLE);
		perez.asignoMateria(DiaEnum.Miercoles, HorarioEnum.ManianaTercera, Materia.NO_DISPONIBLE);
		perez.asignoMateria(DiaEnum.Miercoles, HorarioEnum.ManianaCuarta, Materia.NO_DISPONIBLE);
		perez.asignoMateria(DiaEnum.Miercoles, HorarioEnum.QuintaOPreHora, Materia.NO_DISPONIBLE);
		
		perez.asignoMateria(DiaEnum.Viernes, HorarioEnum.ManianaPrimera, Materia.NO_DISPONIBLE);
		perez.asignoMateria(DiaEnum.Viernes, HorarioEnum.ManianaSegunda, Materia.NO_DISPONIBLE);
		perez.asignoMateria(DiaEnum.Viernes, HorarioEnum.ManianaTercera, Materia.NO_DISPONIBLE);
		perez.asignoMateria(DiaEnum.Viernes, HorarioEnum.ManianaCuarta, Materia.NO_DISPONIBLE);
		perez.asignoMateria(DiaEnum.Viernes, HorarioEnum.QuintaOPreHora, Materia.NO_DISPONIBLE);
		profesores.add(perez);
		
		Profesor pingitore = new Profesor();
		pingitore.setNombre("Pingitore");
		pingitore.addMateria(MateriaEnum.Historia);
		pingitore.setHorasACubrir(8);
		
		pingitore.asignoMateria(DiaEnum.Lunes, HorarioEnum.ManianaPrimera, Materia.NO_DISPONIBLE);
		pingitore.asignoMateria(DiaEnum.Lunes, HorarioEnum.ManianaSegunda, Materia.NO_DISPONIBLE);
		pingitore.asignoMateria(DiaEnum.Lunes, HorarioEnum.ManianaTercera, Materia.NO_DISPONIBLE);
		pingitore.asignoMateria(DiaEnum.Lunes, HorarioEnum.ManianaCuarta, Materia.NO_DISPONIBLE);
		pingitore.asignoMateria(DiaEnum.Lunes, HorarioEnum.QuintaOPreHora, Materia.NO_DISPONIBLE);
		
		pingitore.asignoMateria(DiaEnum.Martes, HorarioEnum.QuintaOPreHora, Materia.NO_DISPONIBLE);
		
		pingitore.asignoMateria(DiaEnum.Miercoles, HorarioEnum.ManianaPrimera, Materia.NO_DISPONIBLE);
		pingitore.asignoMateria(DiaEnum.Miercoles, HorarioEnum.ManianaSegunda, Materia.NO_DISPONIBLE);
		pingitore.asignoMateria(DiaEnum.Miercoles, HorarioEnum.ManianaTercera, Materia.NO_DISPONIBLE);
		pingitore.asignoMateria(DiaEnum.Miercoles, HorarioEnum.ManianaCuarta, Materia.NO_DISPONIBLE);
		pingitore.asignoMateria(DiaEnum.Miercoles, HorarioEnum.QuintaOPreHora, Materia.NO_DISPONIBLE);
		
		pingitore.asignoMateria(DiaEnum.Jueves, HorarioEnum.ManianaPrimera, Materia.NO_DISPONIBLE);
		pingitore.asignoMateria(DiaEnum.Jueves, HorarioEnum.ManianaSegunda, Materia.NO_DISPONIBLE);
		pingitore.asignoMateria(DiaEnum.Jueves, HorarioEnum.ManianaTercera, Materia.NO_DISPONIBLE);
		pingitore.asignoMateria(DiaEnum.Jueves, HorarioEnum.ManianaCuarta, Materia.NO_DISPONIBLE);
		pingitore.asignoMateria(DiaEnum.Jueves, HorarioEnum.QuintaOPreHora, Materia.NO_DISPONIBLE);
		
		pingitore.asignoMateria(DiaEnum.Viernes, HorarioEnum.QuintaOPreHora, Materia.NO_DISPONIBLE);
		profesores.add(pingitore);
		
		Profesor ponce = new Profesor();
		ponce.setNombre("Ponce");
		ponce.addMateria(MateriaEnum.Matematica);
		ponce.setHorasACubrir(8);
		
		ponce.asignoMateria(DiaEnum.Lunes, HorarioEnum.QuintaOPreHora, Materia.NO_DISPONIBLE);
		
		ponce.asignoMateria(DiaEnum.Martes, HorarioEnum.ManianaPrimera, Materia.NO_DISPONIBLE);
		ponce.asignoMateria(DiaEnum.Martes, HorarioEnum.ManianaSegunda, Materia.NO_DISPONIBLE);
		ponce.asignoMateria(DiaEnum.Martes, HorarioEnum.ManianaTercera, Materia.NO_DISPONIBLE);
		ponce.asignoMateria(DiaEnum.Martes, HorarioEnum.ManianaCuarta, Materia.NO_DISPONIBLE);
		ponce.asignoMateria(DiaEnum.Martes, HorarioEnum.QuintaOPreHora, Materia.NO_DISPONIBLE);
		
		ponce.asignoMateria(DiaEnum.Miercoles, HorarioEnum.QuintaOPreHora, Materia.NO_DISPONIBLE);
		
		ponce.asignoMateria(DiaEnum.Jueves, HorarioEnum.ManianaPrimera, Materia.NO_DISPONIBLE);
		ponce.asignoMateria(DiaEnum.Jueves, HorarioEnum.ManianaSegunda, Materia.NO_DISPONIBLE);
		ponce.asignoMateria(DiaEnum.Jueves, HorarioEnum.ManianaTercera, Materia.NO_DISPONIBLE);
		ponce.asignoMateria(DiaEnum.Jueves, HorarioEnum.ManianaCuarta, Materia.NO_DISPONIBLE);
		ponce.asignoMateria(DiaEnum.Jueves, HorarioEnum.QuintaOPreHora, Materia.NO_DISPONIBLE);
		
		ponce.asignoMateria(DiaEnum.Viernes, HorarioEnum.ManianaPrimera, Materia.NO_DISPONIBLE);
		ponce.asignoMateria(DiaEnum.Viernes, HorarioEnum.ManianaSegunda, Materia.NO_DISPONIBLE);
		ponce.asignoMateria(DiaEnum.Viernes, HorarioEnum.ManianaTercera, Materia.NO_DISPONIBLE);
		ponce.asignoMateria(DiaEnum.Viernes, HorarioEnum.ManianaCuarta, Materia.NO_DISPONIBLE);
		ponce.asignoMateria(DiaEnum.Viernes, HorarioEnum.QuintaOPreHora, Materia.NO_DISPONIBLE);
		profesores.add(ponce);
		
		Profesor ripoll = new Profesor();
		ripoll.setNombre("Ripoll");
		ripoll.addMateria(MateriaEnum.Matematica);
		ripoll.setHorasACubrir(10);
		
		profesores.add(ripoll);
		
		Profesor roberto = new Profesor();
		roberto.setNombre("Roberto");
		roberto.addMateria(MateriaEnum.Quimica);
		roberto.setHorasACubrir(6);
		
		roberto.asignoMateria(DiaEnum.Lunes, HorarioEnum.QuintaOPreHora, Materia.NO_DISPONIBLE);
		
		roberto.asignoMateria(DiaEnum.Martes, HorarioEnum.ManianaPrimera, Materia.NO_DISPONIBLE);
		roberto.asignoMateria(DiaEnum.Martes, HorarioEnum.ManianaSegunda, Materia.NO_DISPONIBLE);
		roberto.asignoMateria(DiaEnum.Martes, HorarioEnum.ManianaTercera, Materia.NO_DISPONIBLE);
		roberto.asignoMateria(DiaEnum.Martes, HorarioEnum.ManianaCuarta, Materia.NO_DISPONIBLE);
		roberto.asignoMateria(DiaEnum.Martes, HorarioEnum.QuintaOPreHora, Materia.NO_DISPONIBLE);
		
		roberto.asignoMateria(DiaEnum.Miercoles, HorarioEnum.ManianaPrimera, Materia.NO_DISPONIBLE);
		roberto.asignoMateria(DiaEnum.Miercoles, HorarioEnum.ManianaSegunda, Materia.NO_DISPONIBLE);
		roberto.asignoMateria(DiaEnum.Miercoles, HorarioEnum.ManianaTercera, Materia.NO_DISPONIBLE);
		
		roberto.asignoMateria(DiaEnum.Jueves, HorarioEnum.ManianaPrimera, Materia.NO_DISPONIBLE);
		roberto.asignoMateria(DiaEnum.Jueves, HorarioEnum.ManianaSegunda, Materia.NO_DISPONIBLE);
		roberto.asignoMateria(DiaEnum.Jueves, HorarioEnum.ManianaTercera, Materia.NO_DISPONIBLE);
		roberto.asignoMateria(DiaEnum.Jueves, HorarioEnum.ManianaCuarta, Materia.NO_DISPONIBLE);
		roberto.asignoMateria(DiaEnum.Jueves, HorarioEnum.QuintaOPreHora, Materia.NO_DISPONIBLE);
		
		roberto.asignoMateria(DiaEnum.Viernes, HorarioEnum.ManianaPrimera, Materia.NO_DISPONIBLE);
		roberto.asignoMateria(DiaEnum.Viernes, HorarioEnum.ManianaSegunda, Materia.NO_DISPONIBLE);
		roberto.asignoMateria(DiaEnum.Viernes, HorarioEnum.ManianaTercera, Materia.NO_DISPONIBLE);
		roberto.asignoMateria(DiaEnum.Viernes, HorarioEnum.ManianaCuarta, Materia.NO_DISPONIBLE);
		roberto.asignoMateria(DiaEnum.Viernes, HorarioEnum.QuintaOPreHora, Materia.NO_DISPONIBLE);
		profesores.add(roberto);
		
		Profesor sala = new Profesor();
		sala.setNombre("Sala");
		sala.addMateria(MateriaEnum.Economia);
		sala.setHorasACubrir(3);
		
		sala.asignoMateria(DiaEnum.Lunes, HorarioEnum.ManianaPrimera, Materia.NO_DISPONIBLE);
		sala.asignoMateria(DiaEnum.Lunes, HorarioEnum.ManianaSegunda, Materia.NO_DISPONIBLE);
		sala.asignoMateria(DiaEnum.Lunes, HorarioEnum.ManianaTercera, Materia.NO_DISPONIBLE);
		
		sala.asignoMateria(DiaEnum.Martes, HorarioEnum.ManianaPrimera, Materia.NO_DISPONIBLE);
		sala.asignoMateria(DiaEnum.Martes, HorarioEnum.ManianaSegunda, Materia.NO_DISPONIBLE);
		sala.asignoMateria(DiaEnum.Martes, HorarioEnum.ManianaTercera, Materia.NO_DISPONIBLE);
		sala.asignoMateria(DiaEnum.Martes, HorarioEnum.ManianaCuarta, Materia.NO_DISPONIBLE);
		sala.asignoMateria(DiaEnum.Martes, HorarioEnum.QuintaOPreHora, Materia.NO_DISPONIBLE);
		
		sala.asignoMateria(DiaEnum.Miercoles, HorarioEnum.ManianaPrimera, Materia.NO_DISPONIBLE);
		sala.asignoMateria(DiaEnum.Miercoles, HorarioEnum.ManianaSegunda, Materia.NO_DISPONIBLE);
		sala.asignoMateria(DiaEnum.Miercoles, HorarioEnum.ManianaTercera, Materia.NO_DISPONIBLE);
		sala.asignoMateria(DiaEnum.Miercoles, HorarioEnum.ManianaCuarta, Materia.NO_DISPONIBLE);
		sala.asignoMateria(DiaEnum.Miercoles, HorarioEnum.QuintaOPreHora, Materia.NO_DISPONIBLE);
		
		sala.asignoMateria(DiaEnum.Jueves, HorarioEnum.ManianaPrimera, Materia.NO_DISPONIBLE);
		sala.asignoMateria(DiaEnum.Jueves, HorarioEnum.ManianaSegunda, Materia.NO_DISPONIBLE);
		sala.asignoMateria(DiaEnum.Jueves, HorarioEnum.ManianaTercera, Materia.NO_DISPONIBLE);
		sala.asignoMateria(DiaEnum.Jueves, HorarioEnum.ManianaCuarta, Materia.NO_DISPONIBLE);
		sala.asignoMateria(DiaEnum.Jueves, HorarioEnum.QuintaOPreHora, Materia.NO_DISPONIBLE);
		
		sala.asignoMateria(DiaEnum.Viernes, HorarioEnum.ManianaPrimera, Materia.NO_DISPONIBLE);
		sala.asignoMateria(DiaEnum.Viernes, HorarioEnum.ManianaSegunda, Materia.NO_DISPONIBLE);
		sala.asignoMateria(DiaEnum.Viernes, HorarioEnum.ManianaTercera, Materia.NO_DISPONIBLE);
		profesores.add(sala);
		
		Profesor soria = new Profesor();
		soria.setNombre("Soria");
		soria.addMateria(MateriaEnum.Educacion_Artistica);
		soria.setHorasACubrir(4);
		
		soria.asignoMateria(DiaEnum.Lunes, HorarioEnum.ManianaPrimera, Materia.NO_DISPONIBLE);
		soria.asignoMateria(DiaEnum.Lunes, HorarioEnum.ManianaSegunda, Materia.NO_DISPONIBLE);
		soria.asignoMateria(DiaEnum.Lunes, HorarioEnum.ManianaTercera, Materia.NO_DISPONIBLE);
		soria.asignoMateria(DiaEnum.Lunes, HorarioEnum.ManianaCuarta, Materia.NO_DISPONIBLE);
		soria.asignoMateria(DiaEnum.Lunes, HorarioEnum.QuintaOPreHora, Materia.NO_DISPONIBLE);
		
		soria.asignoMateria(DiaEnum.Martes, HorarioEnum.ManianaPrimera, Materia.NO_DISPONIBLE);
		soria.asignoMateria(DiaEnum.Martes, HorarioEnum.ManianaSegunda, Materia.NO_DISPONIBLE);
		soria.asignoMateria(DiaEnum.Martes, HorarioEnum.ManianaTercera, Materia.NO_DISPONIBLE);
		soria.asignoMateria(DiaEnum.Martes, HorarioEnum.ManianaCuarta, Materia.NO_DISPONIBLE);
		soria.asignoMateria(DiaEnum.Martes, HorarioEnum.QuintaOPreHora, Materia.NO_DISPONIBLE);
		
		soria.asignoMateria(DiaEnum.Miercoles, HorarioEnum.QuintaOPreHora, Materia.NO_DISPONIBLE);
		
		soria.asignoMateria(DiaEnum.Jueves, HorarioEnum.ManianaPrimera, Materia.NO_DISPONIBLE);
		soria.asignoMateria(DiaEnum.Jueves, HorarioEnum.ManianaSegunda, Materia.NO_DISPONIBLE);
		soria.asignoMateria(DiaEnum.Jueves, HorarioEnum.ManianaTercera, Materia.NO_DISPONIBLE);
		soria.asignoMateria(DiaEnum.Jueves, HorarioEnum.ManianaCuarta, Materia.NO_DISPONIBLE);
		soria.asignoMateria(DiaEnum.Jueves, HorarioEnum.QuintaOPreHora, Materia.NO_DISPONIBLE);
		
		soria.asignoMateria(DiaEnum.Viernes, HorarioEnum.ManianaPrimera, Materia.NO_DISPONIBLE);
		soria.asignoMateria(DiaEnum.Viernes, HorarioEnum.ManianaSegunda, Materia.NO_DISPONIBLE);
		soria.asignoMateria(DiaEnum.Viernes, HorarioEnum.ManianaTercera, Materia.NO_DISPONIBLE);
		soria.asignoMateria(DiaEnum.Viernes, HorarioEnum.ManianaCuarta, Materia.NO_DISPONIBLE);
		soria.asignoMateria(DiaEnum.Viernes, HorarioEnum.QuintaOPreHora, Materia.NO_DISPONIBLE);
		profesores.add(soria);
		
		Profesor staniscia = new Profesor();
		staniscia.setNombre("Staniscia");
		staniscia.addMateria(MateriaEnum.C_de_C);
		staniscia.addMateria(MateriaEnum.DDHH);
		staniscia.addMateria(MateriaEnum.Filosofia);
		staniscia.addMateria(MateriaEnum.Psicologia);
		staniscia.addMateria(MateriaEnum.E_C_I__I_P_C);
		staniscia.addMateria(MateriaEnum.E_C_I__Per_Mu_Co);
		staniscia.setHorasACubrir(20);
		
		profesores.add(staniscia);
		
		Profesor torres = new Profesor();
		torres.setNombre("Torres");
		torres.addMateria(MateriaEnum.Matematica);
		torres.setHorasACubrir(8);
		
		torres.asignoMateria(DiaEnum.Lunes, HorarioEnum.ManianaPrimera, Materia.NO_DISPONIBLE);
		torres.asignoMateria(DiaEnum.Lunes, HorarioEnum.ManianaSegunda, Materia.NO_DISPONIBLE);
		torres.asignoMateria(DiaEnum.Lunes, HorarioEnum.ManianaTercera, Materia.NO_DISPONIBLE);
		torres.asignoMateria(DiaEnum.Lunes, HorarioEnum.ManianaCuarta, Materia.NO_DISPONIBLE);
		torres.asignoMateria(DiaEnum.Lunes, HorarioEnum.QuintaOPreHora, Materia.NO_DISPONIBLE);
		
		torres.asignoMateria(DiaEnum.Martes, HorarioEnum.QuintaOPreHora, Materia.NO_DISPONIBLE);
		
		torres.asignoMateria(DiaEnum.Miercoles, HorarioEnum.ManianaPrimera, Materia.NO_DISPONIBLE);
		torres.asignoMateria(DiaEnum.Miercoles, HorarioEnum.ManianaSegunda, Materia.NO_DISPONIBLE);
		torres.asignoMateria(DiaEnum.Miercoles, HorarioEnum.ManianaTercera, Materia.NO_DISPONIBLE);
		torres.asignoMateria(DiaEnum.Miercoles, HorarioEnum.ManianaCuarta, Materia.NO_DISPONIBLE);
		torres.asignoMateria(DiaEnum.Miercoles, HorarioEnum.QuintaOPreHora, Materia.NO_DISPONIBLE);
		
		torres.asignoMateria(DiaEnum.Jueves, HorarioEnum.QuintaOPreHora, Materia.NO_DISPONIBLE);
		
		torres.asignoMateria(DiaEnum.Viernes, HorarioEnum.ManianaPrimera, Materia.NO_DISPONIBLE);
		torres.asignoMateria(DiaEnum.Viernes, HorarioEnum.ManianaSegunda, Materia.NO_DISPONIBLE);
		torres.asignoMateria(DiaEnum.Viernes, HorarioEnum.ManianaTercera, Materia.NO_DISPONIBLE);
		torres.asignoMateria(DiaEnum.Viernes, HorarioEnum.ManianaCuarta, Materia.NO_DISPONIBLE);
		torres.asignoMateria(DiaEnum.Viernes, HorarioEnum.QuintaOPreHora, Materia.NO_DISPONIBLE);
		profesores.add(torres);
		
		Profesor tupone = new Profesor();
		tupone.setNombre("Tupone");
		tupone.addMateria(MateriaEnum.Educacion_Artistica);
		tupone.addMateria(MateriaEnum.C_E_C);
		tupone.setHorasACubrir(10);
		
		tupone.asignoMateria(DiaEnum.Lunes, HorarioEnum.ManianaPrimera, Materia.NO_DISPONIBLE);
		tupone.asignoMateria(DiaEnum.Lunes, HorarioEnum.ManianaSegunda, Materia.NO_DISPONIBLE);
		tupone.asignoMateria(DiaEnum.Lunes, HorarioEnum.ManianaTercera, Materia.NO_DISPONIBLE);
		tupone.asignoMateria(DiaEnum.Lunes, HorarioEnum.ManianaCuarta, Materia.NO_DISPONIBLE);
		tupone.asignoMateria(DiaEnum.Lunes, HorarioEnum.QuintaOPreHora, Materia.NO_DISPONIBLE);
		
		tupone.asignoMateria(DiaEnum.Martes, HorarioEnum.ManianaPrimera, Materia.NO_DISPONIBLE);
		tupone.asignoMateria(DiaEnum.Martes, HorarioEnum.ManianaSegunda, Materia.NO_DISPONIBLE);
		tupone.asignoMateria(DiaEnum.Martes, HorarioEnum.ManianaTercera, Materia.NO_DISPONIBLE);
		
		tupone.asignoMateria(DiaEnum.Jueves, HorarioEnum.ManianaPrimera, Materia.NO_DISPONIBLE);
		tupone.asignoMateria(DiaEnum.Jueves, HorarioEnum.ManianaSegunda, Materia.NO_DISPONIBLE);
		tupone.asignoMateria(DiaEnum.Jueves, HorarioEnum.ManianaTercera, Materia.NO_DISPONIBLE);
		tupone.asignoMateria(DiaEnum.Jueves, HorarioEnum.ManianaCuarta, Materia.NO_DISPONIBLE);
		tupone.asignoMateria(DiaEnum.Jueves, HorarioEnum.QuintaOPreHora, Materia.NO_DISPONIBLE);
		profesores.add(tupone);
		
		Profesor venerus = new Profesor();
		venerus.setNombre("Venerus");
		venerus.addMateria(MateriaEnum.T_I_C);
		venerus.setHorasACubrir(2);
		
		venerus.asignoMateria(DiaEnum.Lunes, HorarioEnum.ManianaPrimera, Materia.NO_DISPONIBLE);
		venerus.asignoMateria(DiaEnum.Lunes, HorarioEnum.ManianaSegunda, Materia.NO_DISPONIBLE);
		venerus.asignoMateria(DiaEnum.Lunes, HorarioEnum.ManianaTercera, Materia.NO_DISPONIBLE);
		venerus.asignoMateria(DiaEnum.Lunes, HorarioEnum.ManianaCuarta, Materia.NO_DISPONIBLE);
		venerus.asignoMateria(DiaEnum.Lunes, HorarioEnum.QuintaOPreHora, Materia.NO_DISPONIBLE);
		
		venerus.asignoMateria(DiaEnum.Martes, HorarioEnum.ManianaPrimera, Materia.NO_DISPONIBLE);
		
		venerus.asignoMateria(DiaEnum.Miercoles, HorarioEnum.ManianaPrimera, Materia.NO_DISPONIBLE);
		venerus.asignoMateria(DiaEnum.Miercoles, HorarioEnum.ManianaSegunda, Materia.NO_DISPONIBLE);
		venerus.asignoMateria(DiaEnum.Miercoles, HorarioEnum.ManianaTercera, Materia.NO_DISPONIBLE);
		venerus.asignoMateria(DiaEnum.Miercoles, HorarioEnum.ManianaCuarta, Materia.NO_DISPONIBLE);
		venerus.asignoMateria(DiaEnum.Miercoles, HorarioEnum.QuintaOPreHora, Materia.NO_DISPONIBLE);
		
		venerus.asignoMateria(DiaEnum.Jueves, HorarioEnum.ManianaPrimera, Materia.NO_DISPONIBLE);
		venerus.asignoMateria(DiaEnum.Jueves, HorarioEnum.ManianaSegunda, Materia.NO_DISPONIBLE);
		venerus.asignoMateria(DiaEnum.Jueves, HorarioEnum.ManianaTercera, Materia.NO_DISPONIBLE);
		venerus.asignoMateria(DiaEnum.Jueves, HorarioEnum.ManianaCuarta, Materia.NO_DISPONIBLE);
		venerus.asignoMateria(DiaEnum.Jueves, HorarioEnum.QuintaOPreHora, Materia.NO_DISPONIBLE);
		
		venerus.asignoMateria(DiaEnum.Viernes, HorarioEnum.ManianaPrimera, Materia.NO_DISPONIBLE);
		venerus.asignoMateria(DiaEnum.Viernes, HorarioEnum.ManianaSegunda, Materia.NO_DISPONIBLE);
		venerus.asignoMateria(DiaEnum.Viernes, HorarioEnum.ManianaTercera, Materia.NO_DISPONIBLE);
		venerus.asignoMateria(DiaEnum.Viernes, HorarioEnum.ManianaCuarta, Materia.NO_DISPONIBLE);
		venerus.asignoMateria(DiaEnum.Viernes, HorarioEnum.QuintaOPreHora, Materia.NO_DISPONIBLE);
		
		profesores.add(venerus);
		
		return profesores;
	}

	private void visualizarCursos(Map<CursoEnum, MatrixCurso> mejorSolucion) {
		for (int i = 0; i < CursoEnum.values().length; i++){
			System.out.println("*********************************");
			System.out.println("Para el curso: " + CursoEnum.values()[i].toString());
			for (int j = 0; j < DiaEnum.values().length; j++){
				System.out.println("En el día " + DiaEnum.values()[j].toString());
				for (int k = 0; k < HorarioEnum.values().length; k++){
					Materia m = mejorSolucion.get(CursoEnum.values()[i]).getMateria(DiaEnum.values()[j], HorarioEnum.values()[k]);
					System.out.print(m.getNombre() + ": " + m.getDictador().getNombre() + ": " + m.tieneDocenteAsignado() + " || ");
				}
				System.out.println();
			}
		}
	}
}