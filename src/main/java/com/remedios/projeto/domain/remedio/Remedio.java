package com.remedios.projeto.domain.remedio;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "remedio")
public class Remedio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    @Enumerated(EnumType.STRING)
    private Via via;
    private String lote;
    private int quantidade;
    private LocalDate validade;
    @Enumerated(EnumType.STRING)
    private Laboratorio laboratorio;
    private Boolean ativo;

    public Remedio() {
        this.ativo = true;
    }

    public Remedio(Long id, String nome, Via via, String lote, int quantidade, LocalDate validade, Laboratorio laboratorio) {
        this.id = id;
        this.nome = nome;
        this.via = via;
        this.lote = lote;
        this.quantidade = quantidade;
        this.validade = validade;
        this.laboratorio = laboratorio;
        this.ativo = true;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Via getVia() {
        return via;
    }

    public void setVia(Via via) {
        this.via = via;
    }

    public String getLote() {
        return lote;
    }

    public void setLote(String lote) {
        this.lote = lote;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public LocalDate getValidade() {
        return validade;
    }

    public void setValidade(LocalDate validade) {
        this.validade = validade;
    }

    public Laboratorio getLaboratorio() {
        return laboratorio;
    }

    public void setLaboratorio(Laboratorio laboratorio) {
        this.laboratorio = laboratorio;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Remedio remedio = (Remedio) o;
        return Objects.equals(id, remedio.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Remedio{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", via=" + via +
                ", lote='" + lote + '\'' +
                ", quantidade='" + quantidade + '\'' +
                ", validade='" + validade + '\'' +
                ", laboratorio=" + laboratorio +
                '}';
    }
}
