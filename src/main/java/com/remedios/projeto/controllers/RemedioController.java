package com.remedios.projeto.controllers;

import com.remedios.projeto.dto.remedio.AtualizarRemedioDTO;
import com.remedios.projeto.dto.remedio.ListagemRemedioDTO;
import com.remedios.projeto.dto.remedio.RemedioDTO;
import com.remedios.projeto.services.RemedioServices;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/remedios")
public class RemedioController {

    @Autowired
    private RemedioServices services;

    @PostMapping
    @Transactional
    public ResponseEntity<RemedioDTO> cadastrar(@RequestBody @Valid RemedioDTO remedioDto) {
        RemedioDTO remedio = services.cadastrarRemedio(remedioDto);
        var uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(remedio.id()).toUri();
        return ResponseEntity.created(uri).body(remedio);
    }

    @GetMapping
    public ResponseEntity<List<ListagemRemedioDTO>> listar() {
        List<ListagemRemedioDTO> dtoList = services.listarRemedios();
        return ResponseEntity.status(HttpStatus.OK).body(dtoList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> buscarPorId(@PathVariable(value = "id") Long id) {
        RemedioDTO remedioDto = services.buscarPorId(id);
        return ResponseEntity.status(HttpStatus.OK).body(remedioDto);
    }


    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<RemedioDTO> atualizar(
            @PathVariable(value = "id") Long id,
            @RequestBody @Valid AtualizarRemedioDTO dados) {

        RemedioDTO remedioDto = services.atualizarRemedios(dados, id);
        return ResponseEntity.status(HttpStatus.OK).body(remedioDto);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> deletar(@PathVariable(value = "id") Long id) {
        services.deletarRemedio(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("inativar/{id}")
    @Transactional
    public ResponseEntity<Void> inativar(@PathVariable(value = "id") Long id) {
        services.inativarRemedio(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("ativar/{id}")
    @Transactional
    public ResponseEntity<Object> ativar(@PathVariable(value = "id") Long id) {
        services.ativarRemedio(id);
        return ResponseEntity.status(HttpStatus.OK).body("Remédio ativado");
    }
}
