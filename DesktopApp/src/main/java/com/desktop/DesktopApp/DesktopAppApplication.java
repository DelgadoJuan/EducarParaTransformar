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
		Login login = new Login(usuarioRepository, estudianteRepository, profesorRepository,
				cursoRepository, pagoRepository, titularRepository, materiaRepository, horarioRepository);
		login.setVisible(true);
		login.setLocationRelativeTo(null);
	}

}
