package com.barbearia.BarbeariaDoisIrmaos.model;


public class Estoque {
    
    //atributos
    private Integer id;
    private String nome;
    private String categoria;
    private Integer quantidade;
    private Double preco;
    private Double valor_total;
    private String data_compra;
    private String validade;
    private String observacao;

    public Estoque() {
    }

    public Estoque(Integer id, String nome, String categoria, Integer quantidade, Double preco, Double valor_total, String data_compra, String validade, String observacao) {
        this.id = id;
        this.nome = nome;
        this.categoria = categoria;
        this.quantidade = quantidade;
        this.preco = preco;
        this.valor_total = valor_total;
        this.data_compra = data_compra;
        this.validade = validade;
        this.observacao = observacao;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Double getValor_total() {
        return valor_total;
    }

    public void setValor_total(Double valor_total) {
        this.valor_total = valor_total;
    }

    public String getData_compra() {
        return data_compra;
    }

    public void setData_compra(String data_compra) {
        this.data_compra = data_compra;
    }

    public String getValidade() {
        return validade;
    }

    public void setValidade(String validade) {
        this.validade = validade;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
    
    
    
    
    
    
    
    
    
    
}
