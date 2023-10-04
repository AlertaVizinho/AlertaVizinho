package br.com.alertavizinho.app.service;

import br.com.alertavizinho.app.dto.PessoaFisicaDto;
import br.com.alertavizinho.app.model.PessoaFisica;
import br.com.alertavizinho.app.repository.PessoaFisicaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

public class PessoaFisicaService {

    @Autowired
    private PessoaFisicaRepository repository;

    @Autowired
    private ModelMapper modelMapper;

    public PessoaFisicaDto cadastrar(PessoaFisicaDto dto) {
        PessoaFisica pessoaFisica = modelMapper.map(dto, PessoaFisica.class);
        repository.save(pessoaFisica);

        return modelMapper.map(pessoaFisica, PessoaFisicaDto.class);
    }

    public Page<PessoaFisicaDto> listarTodos(Pageable paginacao) {
        return repository
                .findAll(paginacao)
                .map(id -> modelMapper.map(id, PessoaFisicaDto.class));
    }

    public PessoaFisicaDto ListarPorId(Long id) {
        PessoaFisica pessoaFisica = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException());

        PessoaFisicaDto dto = modelMapper.map(pessoaFisica, PessoaFisicaDto.class);
        return dto;
    }

    public PessoaFisicaDto atualizarDados(Long id, PessoaFisicaDto dto) {
        PessoaFisica pessoaFisica = modelMapper.map(dto, PessoaFisica.class);
        pessoaFisica.setId(id);
        pessoaFisica = repository.save(pessoaFisica);
        return modelMapper.map(pessoaFisica, PessoaFisicaDto.class);

    }

    public void deletarPorId(Long id) {
        repository.deleteById(id);
    }

}
