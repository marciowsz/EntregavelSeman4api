package com.escola.api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * DTO de ENTRADA (POST e PUT). Não tem "id": quem gera o id é o banco.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AlunoRequest {

    private String nome;
    private String ra;
    private String email;
}
