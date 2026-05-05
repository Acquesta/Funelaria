package br.com.funilaria.controllers;

import br.com.funilaria.DTOs.ErroDeNaoEncontrado;
import br.com.funilaria.DTOs.ErroDeValidacaoDTO;
import br.com.funilaria.exceptions.RecursoNaoEncontradoException;
import br.com.funilaria.exceptions.RegraDeNegocioException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class TratadorDeErros {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<ErroDeValidacaoDTO>> tratarErrosDeFormulario(MethodArgumentNotValidException ex) {

        List<FieldError> errosDoSpring = ex.getFieldErrors();

        List<ErroDeValidacaoDTO> listaDeErrosLimpos = errosDoSpring.stream()
                .map(erro -> new ErroDeValidacaoDTO(erro.getField(), erro.getDefaultMessage()))
                .collect(Collectors.toList());

        return ResponseEntity.badRequest().body(listaDeErrosLimpos);
    }

    @ExceptionHandler(RegraDeNegocioException.class)
    public ResponseEntity<ErroDeValidacaoDTO> tratarErrosDeChaveUni(RegraDeNegocioException ex) {

        ErroDeValidacaoDTO erro = new ErroDeValidacaoDTO(ex.getCampo(), ex.getMessage());

        return ResponseEntity.badRequest().body(erro);
    }

    @ExceptionHandler(RecursoNaoEncontradoException.class)
    public ResponseEntity<ErroDeNaoEncontrado> tratarErrosDeNaoEcontrado(RecursoNaoEncontradoException ex) {

        ErroDeNaoEncontrado erro = new ErroDeNaoEncontrado(ex.getMessage());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
    }


}