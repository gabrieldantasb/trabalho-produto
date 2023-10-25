package com.example.trabalhoproduto;

import jakarta.persistence.*;

@Entity
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigo;

    @Column
    private String descricao;

    @Column
    private Double preco;

    @Column
    private Integer qtde;

    public Produto(Integer codigo, String descricao, Double preco, Integer qtde) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.preco = preco;
        this.qtde = qtde;
    }

    public Produto(String descricao, Double preco, Integer qtde) {
        this.descricao = descricao;
        this.preco = preco;
        this.qtde = qtde;
    }

    public Produto() {
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Integer getQtde() {
        return qtde;
    }

    public void setQtde(Integer qtde) {
        this.qtde = qtde;
    }
}
