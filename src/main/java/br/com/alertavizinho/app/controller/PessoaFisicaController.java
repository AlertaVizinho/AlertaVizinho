package br.com.alertavizinho.app.controller;

import br.com.alertavizinho.app.dto.PessoaFisicaDto;
import br.com.alertavizinho.app.service.PessoaFisicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.net.URI;

@RestController
@RequestMapping("/pessoas-fisicas")
public class PessoaFisicaController {

    @Autowired
    private PessoaFisicaService service;

    @PostMapping
    public ResponseEntity<PessoaFisicaDto> cadastrar(@RequestBody @Valid PessoaFisicaDto dto, UriComponentsBuilder uriBuilder) {
        PessoaFisicaDto pessoaFisica = service.cadastrar(dto);
        URI endereco = uriBuilder.path("/pessoas-fisicas/{id}").buildAndExpand(pessoaFisica.getId()).toUri();

        return ResponseEntity.created(endereco).body(pessoaFisica);
    }

    @GetMapping
    public Page<PessoaFisicaDto> listar(@PageableDefault(size = 10)Pageable paginacao) {
        return service.listarTodos(paginacao);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PessoaFisicaDto> listarPorId(@PathVariable @NotNull Long id) {
        PessoaFisicaDto dto = service.ListarPorId(id);

        return ResponseEntity.ok(dto);
    }

    @PutMapping("/id")
    public ResponseEntity atualizarDados(@PathVariable @NotNull Long id, @RequestBody @Valid PessoaFisicaDto dto) {
        PessoaFisicaDto pessoaFisicaDto = service.atualizarDados(id, dto);

        return ResponseEntity.ok(pessoaFisicaDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<PessoaFisicaDto> remover(@PathVariable @NotNull Long id) {
        service.deletarPorId(id);

        return ResponseEntity.noContent().build();
    }

}
