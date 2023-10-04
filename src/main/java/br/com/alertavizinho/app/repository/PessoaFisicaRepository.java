package br.com.alertavizinho.app.repository;

import br.com.alertavizinho.app.model.PessoaFisica;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaFisicaRepository extends JpaRepository<PessoaFisica, Long> {
}
