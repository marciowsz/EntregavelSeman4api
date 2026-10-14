package com.escola.api.controller;

import com.escola.api.dto.AlunoRequest;
import com.escola.api.dto.AlunoResponse;
import com.escola.api.service.AlunoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    // ===== DESAFIO DA SEMANA 02: troque pelos seus dados =====
    private static final String MEU_NOME = "Seu Nome";
    private static final String MEU_RA = "000000";

    private final AlunoService alunoService;

    public AlunoController(AlunoService alunoService) {
        this.alunoService = alunoService;
    }

    // POST /alunos -> 201 Created
    @PostMapping
    public ResponseEntity<AlunoResponse> create(@RequestBody AlunoRequest request) {
        AlunoResponse response = alunoService.create(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    // GET /alunos -> 200 OK
    @GetMapping
    public ResponseEntity<List<AlunoResponse>> getAll() {
        return ResponseEntity.ok(alunoService.getAll());
    }

    // GET /alunos/ra -> desafio da Semana 02
    @GetMapping("/ra")
    public String meuRa() {
        return "O RA do aluno " + MEU_NOME + " é " + MEU_RA;
    }

    // GET /alunos/{id} -> 200 OK (ou 404 via exceção)
    @GetMapping("/{id}")
    public ResponseEntity<AlunoResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(alunoService.getById(id));
    }

    // PUT /alunos/{id} -> 204 No Content (ou 404 via exceção)
    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable Long id, @RequestBody AlunoRequest request) {
        alunoService.update(id, request);
        return ResponseEntity.noContent().build();
    }

    // DELETE /alunos/{id} -> 204 No Content (ou 404 via exceção)
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        alunoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
