package com.escola.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Lançada quando um ID não existe no banco.
 * É uma RuntimeException; o @ResponseStatus faz o Spring responder
 * 404 Not Found em vez de um erro genérico 500.
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class RecursoNaoEncontradoException extends RuntimeException {

    public RecursoNaoEncontradoException(String mensagem) {
        super(mensagem);
    }
}
