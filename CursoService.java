package com.escola.api.service;

import com.escola.api.entity.Curso;
import com.escola.api.exception.RecursoNaoEncontradoException;
import com.escola.api.repository.CursoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CursoService {

    private final CursoRepository cursoRepository;

    public CursoService(CursoRepository cursoRepository) {
        this.cursoRepository = cursoRepository;
    }

    public List<Curso> listarTodos() {
        return cursoRepository.findAll();
    }

    public List<Curso> buscarPorTurno(String turno) {
        return cursoRepository.findByTurnoIgnoreCase(turno);
    }

    public Curso buscarPorId(Long id) {
        Optional<Curso> optional = cursoRepository.findById(id);
        if (optional.isPresent()) {
            return optional.get();
        } else {
            throw new RecursoNaoEncontradoException("Curso com id " + id + " não encontrado");
        }
    }

    public Curso salvar(Curso curso) {
        curso.setId(null);
        return cursoRepository.save(curso);
    }

    public Curso atualizar(Long id, Curso dados) {
        Curso curso = buscarPorId(id);
        curso.setDescricao(dados.getDescricao());
        curso.setTurno(dados.getTurno());
        return cursoRepository.save(curso);
    }

    public void excluir(Long id) {
        Curso curso = buscarPorId(id);
        cursoRepository.delete(curso);
    }
}
