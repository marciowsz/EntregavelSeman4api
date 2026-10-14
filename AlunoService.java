package com.escola.api.service;

import com.escola.api.dto.AlunoRequest;
import com.escola.api.dto.AlunoResponse;
import com.escola.api.entity.Aluno;
import com.escola.api.exception.RecursoNaoEncontradoException;
import com.escola.api.repository.AlunoRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AlunoService {

    private final AlunoRepository alunoRepository;

    public AlunoService(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    // CREATE: AlunoRequest -> Entity -> salva -> AlunoResponse
    public AlunoResponse create(AlunoRequest request) {
        Aluno aluno = new Aluno();
        aluno.setNome(request.getNome());
        aluno.setRa(request.getRa());
        aluno.setEmail(request.getEmail());

        Aluno salvo = alunoRepository.save(aluno);
        return new AlunoResponse(salvo);
    }

    // READ (por id): Optional tratado com if/else
    public AlunoResponse getById(Long id) {
        Optional<Aluno> optional = alunoRepository.findById(id);

        if (optional.isPresent()) {
            return new AlunoResponse(optional.get());
        } else {
            throw new RecursoNaoEncontradoException("Aluno com id " + id + " não encontrado");
        }
    }

    // READ (todos)
    public List<AlunoResponse> getAll() {
        List<AlunoResponse> respostas = new ArrayList<>();
        for (Aluno aluno : alunoRepository.findAll()) {
            respostas.add(new AlunoResponse(aluno));
        }
        return respostas;
    }

    // UPDATE (PUT): findById().orElseThrow() resolve o Optional em uma linha
    // e lança a exceção automaticamente se o id não existir
    public void update(Long id, AlunoRequest request) {
        Aluno aluno = alunoRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Aluno com id " + id + " não encontrado"));

        aluno.setNome(request.getNome());
        aluno.setRa(request.getRa());
        aluno.setEmail(request.getEmail());

        alunoRepository.save(aluno);
    }

    // DELETE: existsById() + if (!exists), sem lambda
    public void deleteById(Long id) {
        boolean exists = alunoRepository.existsById(id);

        if (!exists) {
            throw new RecursoNaoEncontradoException("Aluno com id " + id + " não encontrado");
        }

        alunoRepository.deleteById(id);
    }
}
