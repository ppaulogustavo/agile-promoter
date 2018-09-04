package com.involves.selecao.service.alerta;

import com.involves.selecao.entity.Pesquisa;
import com.involves.selecao.entity.Resposta;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class AlertaServiceTest {

    public Pesquisa pesquisa = new Pesquisa();
    public AlertaService alertaService = new AlertaService();

    @Before
    public void configurar() {
        pesquisa.setId(1);
        pesquisa.setRotulo("Campanha de pascoa");
        pesquisa.setNotificante("João");
        pesquisa.setPonto_de_venda("Angeloni Capoeiras");
        pesquisa.setProduto("Ovo de pascoa Kinder 48");
        pesquisa.setPreco_estipulado(100);

        pesquisa.setRespostas(Arrays.asList(
                new Resposta("Qual a situação do produto?", "Produto ausente na gondola"),
                new Resposta("Qual o preço do produto?", "105")
        ));
    }

    @Test
    public void deveCriarAlertas() {
        assertEquals(alertaService.criarAlertas(pesquisa).size(), 2);
    }

    @Test
    public void deveAceitarPesquisaVazia() {
        assertEquals(alertaService.criarAlertas(new Pesquisa()).size(), 0);
    }

}