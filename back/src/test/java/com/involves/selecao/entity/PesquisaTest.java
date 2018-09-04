package com.involves.selecao.entity;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PesquisaTest {

    public Pesquisa pesquisa = new Pesquisa();

    @Before
    public void configuracaoInicial() {
        pesquisa.setId(1);
        pesquisa.setNotificante("Angeloni");
        pesquisa.setPonto_de_venda("Angeloni");
        pesquisa.setPreco_estipulado(100);
    }

        @Test
    public void precoEstaAbaixoEstipulado() {
        Resposta resposta = new Resposta();
        resposta.setResposta("99");
        assertTrue(pesquisa.precoEstaAbaixoEstipulado(resposta));
    }

    @Test
    public void precoEstaAcimaEstipulado() {
        Resposta resposta = new Resposta();
        resposta.setResposta("101");
        assertTrue(pesquisa.precoEstaAcimaEstipulado(resposta));
    }
}