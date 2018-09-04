package com.involves.selecao.entity;

public class PesquisaFactory {

    public static Pesquisa getPesquisa() {
        Pesquisa pesquisa = new Pesquisa();
        pesquisa.setId(1);
        pesquisa.setNotificante("Angeloni");
        pesquisa.setPonto_de_venda("Angeloni");
        pesquisa.setPreco_estipulado(100);
        pesquisa.setParticipacaoEstipulada(100);
        return pesquisa;
    }

}
