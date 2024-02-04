package com.remedios.projeto.services;

import com.remedios.projeto.dto.remedio.AtualizarRemedioDTO;
import com.remedios.projeto.dto.remedio.ListagemRemedioDTO;
import com.remedios.projeto.dto.remedio.RemedioDTO;
import com.remedios.projeto.domain.remedio.Remedio;
import com.remedios.projeto.repositories.RemedioRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RemedioServices {

    @Autowired
    RemedioRepository repository;

    public RemedioDTO cadastrarRemedio(RemedioDTO remedioDto) {
        Remedio remedio = new Remedio();
        BeanUtils.copyProperties(remedioDto, remedio);
        repository.save(remedio);
        return RemedioDTO.fromRemedio(remedio);
    }

    public List<ListagemRemedioDTO> listarRemedios() {
        List<Remedio> remedios = repository.findAllByAtivoTrue();
        List<ListagemRemedioDTO> dtoList = remedios.stream()
                .map(ListagemRemedioDTO::new).toList();
        return dtoList;
    }

    public RemedioDTO buscarPorId(Long id) {
        Optional<Remedio> remedioOptional = repository.findById(id);
        if (remedioOptional.isEmpty()) {
            throw new EntityNotFoundException("Remédio com Id: " + id + " não encontrado");
        }
        Remedio remedio = remedioOptional.get();
        return RemedioDTO.fromRemedio(remedio);
    }

    public RemedioDTO atualizarRemedios(@Valid AtualizarRemedioDTO dados, Long id) {
        Optional<Remedio> remedioOptional = repository.findById(id);
        if (remedioOptional.isEmpty()) {
            throw new EntityNotFoundException("Remédio com Id: " + id + " não encontrado");
        }
        Remedio remedio = remedioOptional.get();

        if (dados.nome() != null) {
            remedio.setNome(dados.nome());
        }
        if (dados.via() != null) {
            remedio.setVia(dados.via());
        }
        if (dados.laboratorio() != null) {
            remedio.setLaboratorio(dados.laboratorio());
        }

        repository.save(remedio);
        return RemedioDTO.fromRemedio(remedio);

    }

    public void deletarRemedio(Long id) {
        Optional<Remedio> remedioOptional = repository.findById(id);
        if (remedioOptional.isEmpty()) {
            throw new EntityNotFoundException("Remédio com Id: " + id + " não encontrado");
        }
        repository.deleteById(id);
    }

    public void inativarRemedio(Long id) {
        Optional<Remedio> remedioOptional = repository.findById(id);
        if (remedioOptional.isEmpty()) {
            throw new EntityNotFoundException("Remédio com Id: " + id + " não encontrado");
        }
        Remedio remedio = remedioOptional.get();
        remedio.setAtivo(false);
        repository.save(remedio);
    }

    public void ativarRemedio(Long id) {
        Optional<Remedio> remedioOptional = repository.findById(id);
        if (remedioOptional.isEmpty()) {
            throw new EntityNotFoundException("Remédio com Id: " + id + " não encontrado");
        }
        Remedio remedio = remedioOptional.get();
        remedio.setAtivo(true);
    }
}
