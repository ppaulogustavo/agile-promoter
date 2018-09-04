package com.involves.selecao.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class Pesquisa {

    private int id;
    private String rotulo;
    private String notificante;
    private String ponto_de_venda;
    private String produto;
    private Integer preco_estipulado;
    private List<Resposta> respostas;

    @JsonProperty("participacao_estipulada")
    private Integer participacaoEstipulada;

    public Pesquisa() {
        this.respostas = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRotulo() {
        return rotulo;
    }

    public void setRotulo(String rotulo) {
        this.rotulo = rotulo;
    }

    public String getNotificante() {
        return notificante;
    }

    public void setNotificante(String notificante) {
        this.notificante = notificante;
    }

    public String getPonto_de_venda() {
        return ponto_de_venda;
    }

    public void setPonto_de_venda(String ponto_de_venda) {
        this.ponto_de_venda = ponto_de_venda;
    }

    public List<Resposta> getRespostas() {
        return respostas;
    }

    public void setRespostas(List<Resposta> respostas) {
        this.respostas = respostas;
    }

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

    public Integer getPreco_estipulado() {
        return preco_estipulado;
    }

    public void setPreco_estipulado(Integer preco_estipulado) {
        this.preco_estipulado = preco_estipulado;
    }

    public Integer getParticipacaoEstipulada() {
        return participacaoEstipulada;
    }

    public void setParticipacaoEstipulada(Integer participacaoEstipulada) {
        this.participacaoEstipulada = participacaoEstipulada;
    }

    public void addResposta(Resposta resposta) {
        this.respostas.add(resposta);
    }

    public boolean precoEstaAbaixoEstipulado(Resposta resposta) {
        return Integer.parseInt(resposta.getResposta()) < this.preco_estipulado;
    }

    public boolean precoEstaAcimaEstipulado(Resposta resposta) {
        return Integer.parseInt(resposta.getResposta()) > this.preco_estipulado;
    }

    public boolean participacaoEstaAcimaEstipulado(Resposta resposta) {
        return Integer.parseInt(resposta.getResposta()) > this.participacaoEstipulada;
    }

    public boolean participacaoEstaAbaixoEstipulado(Resposta resposta) {
        return Integer.parseInt(resposta.getResposta()) < this.participacaoEstipulada;
    }

}
