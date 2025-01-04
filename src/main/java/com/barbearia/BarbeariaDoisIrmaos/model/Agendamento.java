package com.barbearia.BarbeariaDoisIrmaos.model;

public class Agendamento {
    
    //atributos
    private Integer id;
    private String nome;
    private String telefone;
    private String data;
    private String hora;
    private String barbeiro_resp;
    private Boolean cabelo;
    private Boolean barba;
    private Boolean sobrancelha;
    private Boolean hidratacao;
    private Boolean tintura;

    public Agendamento() {
    }

    public Agendamento(Integer id, String nome, String telefone, String data, String hora, String barbeiro_resp, Boolean cabelo, Boolean barba, Boolean sobrancelha, Boolean hidratacao, Boolean tintura) {
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
        this.data = data;
        this.hora = hora;
        this.barbeiro_resp = barbeiro_resp;
        this.cabelo = cabelo;
        this.barba = barba;
        this.sobrancelha = sobrancelha;
        this.hidratacao = hidratacao;
        this.tintura = tintura;
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

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getBarbeiro_resp() {
        return barbeiro_resp;
    }

    public void setBarbeiro_resp(String barbeiro_resp) {
        this.barbeiro_resp = barbeiro_resp;
    }

    public Boolean getCabelo() {
        return cabelo;
    }

    public void setCabelo(Boolean cabelo) {
        this.cabelo = cabelo;
    }

    public Boolean getBarba() {
        return barba;
    }

    public void setBarba(Boolean barba) {
        this.barba = barba;
    }

    public Boolean getSobrancelha() {
        return sobrancelha;
    }

    public void setSobrancelha(Boolean sobrancelha) {
        this.sobrancelha = sobrancelha;
    }

    public Boolean getHidratacao() {
        return hidratacao;
    }

    public void setHidratacao(Boolean hidratacao) {
        this.hidratacao = hidratacao;
    }

    public Boolean getTintura() {
        return tintura;
    }

    public void setTintura(Boolean tintura) {
        this.tintura = tintura;
    }
    
     
    
    
    
}
