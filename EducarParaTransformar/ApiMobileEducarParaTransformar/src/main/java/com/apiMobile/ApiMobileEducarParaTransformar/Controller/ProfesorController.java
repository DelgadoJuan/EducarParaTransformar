package com.apiMobile.ApiMobileEducarParaTransformar.Controller;

import com.apiMobile.ApiMobileEducarParaTransformar.Service.AlumnosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class ProfesorController {

    private final AlumnosService alumnosService;

    @Autowired
    public ProfesorController(AlumnosService alumnosService) {
        this.alumnosService = alumnosService;
    }

    @GetMapping("/materias/{idProfesor}")
    public ResponseEntity<?> obtenerMaterias(@PathVariable("idProfesor") Long id) {
        return new ResponseEntity<>(alumnosService.obtenerMateriasProfesor(id), HttpStatus.OK);
    }

    @GetMapping("/alumnos/{idMateria}")
    public ResponseEntity<?> obtenerAlumnosMateria(@PathVariable("idMateria") Long id) {
        return new ResponseEntity<>(alumnosService.alumnosCurso(id), HttpStatus.OK);
    }

    @GetMapping("/profesores")
    public ResponseEntity<?> obtenerProfesores() {
        return new ResponseEntity<>(alumnosService.obtenerProfesores(), HttpStatus.OK);
    }

    @GetMapping("/horarios")
    public ResponseEntity<?> obtenerHorariosMateria() {
        return new ResponseEntity<>(alumnosService.horariosMateria(), HttpStatus.OK);
    }
}
