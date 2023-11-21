package com.apiMobile.ApiMobileEducarParaTransformar.Service;

import com.apiMobile.ApiMobileEducarParaTransformar.Entity.*;
import com.apiMobile.ApiMobileEducarParaTransformar.Repository.*;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlumnosService {
    private EstudianteRepository estudianteRepository;
    private CursoRepository cursoRepository;
    private MateriaRepository materiaRepository;
    private ProfesorRepository profesorRepository;
    private HorarioRepository horarioRepository;

    @Autowired
    public AlumnosService(EstudianteRepository estudianteRepository, CursoRepository cursoRepository, MateriaRepository materiaRepository, ProfesorRepository profesorRepository, HorarioRepository horarioRepository) {
        this.estudianteRepository = estudianteRepository;
        this.cursoRepository = cursoRepository;
        this.materiaRepository = materiaRepository;
        this.profesorRepository = profesorRepository;
        this.horarioRepository = horarioRepository;
    }

    public List<ProfesorEntity> obtenerProfesores() {
        return profesorRepository.findAll();
    }

    public List<EstudianteEntity> alumnosCurso(Long idMateria) {
        MateriaEntity materia = materiaRepository.findById(idMateria).orElseThrow(EntityNotFoundException::new);
        return materia.getCurso().getAlumnosInscriptos();
    }

    public List<MateriaEntity> obtenerMateriasProfesor(Long idProfesor) {
        ProfesorEntity profesor = profesorRepository.findById(idProfesor).orElseThrow(EntityNotFoundException::new);
        return profesor.getMaterias();
    }

    public List<HorarioEntity> horariosMateria() {
        return horarioRepository.findAll();
    }

}
