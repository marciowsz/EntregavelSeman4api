package com.escola.api.dto;

import com.escola.api.entity.Aluno;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * DTO de SAÍDA: o que a API devolve. A Entity nunca é exposta diretamente.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AlunoResponse {

    private Long id;
    private String nome;
    private String ra;
    private String email;

    // Converte a Entity em DTO de resposta
    public AlunoResponse(Aluno aluno) {
        this.id = aluno.getId();
        this.nome = aluno.getNome();
        this.ra = aluno.getRa();
        this.email = aluno.getEmail();
    }
}
