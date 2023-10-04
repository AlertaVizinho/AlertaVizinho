package br.com.alertavizinho.app.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public record PessoaFisicaDto(Long id, String cpf, String nome, String numeroContato,
                              String email, String senha, String DataDenascimento) {

}
