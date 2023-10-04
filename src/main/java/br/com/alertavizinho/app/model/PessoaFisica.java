package br.com.alertavizinho.app.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "pessoaFisica")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PessoaFisica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CPF
    @NotNull
    private String cpf;

    @Size(max = 100)
    @NotNull
    private String nome;

    @Size(max = 11)
    private String numeroContato;

    @Email
    @NotNull
    private String email;

    @NotBlank
    private String senha;

    @NotBlank
    private String DataDeNascimento;

}
