package com.desktop.DesktopApp;

import com.desktop.DesktopApp.Entity.*;
import com.desktop.DesktopApp.Repository.*;
import com.desktop.DesktopApp.UI.Login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

@SpringBootApplication
public class DesktopAppApplication {

	private static EstudianteRepository estudianteRepository;
	private static UsuarioRepository usuarioRepository;
	private static ProfesorRepository profesorRepository;
	private static CursoRepository cursoRepository;
	private static MateriaRepository materiaRepository;
	private static PagoRepository pagoRepository;
	private static TitularRepository titularRepository;
	private static HorarioRepository horarioRepository;
	private static final BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

	@Autowired
	public DesktopAppApplication(TitularRepository titularRepository, PagoRepository pagoRepository,
								 MateriaRepository materiaRepository, EstudianteRepository estudianteRepository,
								 UsuarioRepository usuarioRepository, ProfesorRepository profesorRepository,
								 CursoRepository cursoRepository, HorarioRepository horarioRepository) {
		DesktopAppApplication.titularRepository = titularRepository;
		DesktopAppApplication.pagoRepository = pagoRepository;
		DesktopAppApplication.estudianteRepository = estudianteRepository;
		DesktopAppApplication.usuarioRepository = usuarioRepository;
		DesktopAppApplication.profesorRepository = profesorRepository;
		DesktopAppApplication.cursoRepository = cursoRepository;
		DesktopAppApplication.materiaRepository = materiaRepository;
		DesktopAppApplication.horarioRepository = horarioRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(DesktopAppApplication.class, args);
		System.setProperty("java.awt.headless", "false");

		//usuarioRepository.save(new UsuarioEntity("43348071", "Juan Delgado", "juandelgado@live.com.ar",
		//		bCryptPasswordEncoder.encode("asd123"), LocalDate.of(2001, 5, 24), Roles.Admin));
		//usuarioRepository.save(new UsuarioEntity("12345678", "Anvincula", "anvincula@live.com.ar",
		//		bCryptPasswordEncoder.encode("asd123"), LocalDate.of(2001, 5, 24), Roles.Personal));
		CursoEntity curso = cursoRepository.save(new CursoEntity("5to", Nivel.Secundario));
		//EstudianteEntity estudiante = new EstudianteEntity("45566778", "Nico", "asd@gmail.com",
		//		bCryptPasswordEncoder.encode("asd123"), LocalDate.of(2001, 5, 24), Roles.Estudiante, curso);
		MateriaEntity materia = new MateriaEntity("Matematica", curso);
		materia.getHorarios().add(new HorarioEntity(materia, Dia.Lunes, LocalTime.of(8, 0), LocalTime.of(10, 0)));
		materia.getHorarios().add(new HorarioEntity(materia, Dia.Miercoles, LocalTime.of(10, 0), LocalTime.of(12, 0)));
		materiaRepository.save(materia);
		//estudiante.getCalificaciones().add(new CalificacionEntity( 6, "Examen 1", estudiante, materia));
		//estudiante.getCalificaciones().add(new CalificacionEntity( 10, "Examen 2", estudiante, materia));
		//estudianteRepository.save(estudiante);
		//titularRepository.save(new TitularEntity("26000000", "Roberto", "djuan7180@gmail.com",
		//		bCryptPasswordEncoder.encode("asd123"), LocalDate.of(1980,3, 14), Roles.Titular, estudiante));
		//profesorRepository.save(new ProfesorEntity("31000000", "Roberto", "robertito@gmail.com",
		//		bCryptPasswordEncoder.encode("asd123"), LocalDate.of(1980,3, 14), Roles.Profesor));
		Login login = new Login(usuarioRepository, estudianteRepository, profesorRepository,
				cursoRepository, pagoRepository, titularRepository, materiaRepository, horarioRepository);
		login.setVisible(true);
		login.setLocationRelativeTo(null);
	}

}
