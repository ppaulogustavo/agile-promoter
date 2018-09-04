package com.involves.selecao.helper;

import com.involves.selecao.entity.Pesquisa;
import com.involves.selecao.entity.Resposta;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MargemHelperTest {

    public MargemHelper margemHelper = new MargemHelper();
    public Pesquisa pesquisa = new Pesquisa();

    @Before
    public void configuracaoInicial() {
        pesquisa.setId(1);
        pesquisa.setNotificante("Angeloni");
        pesquisa.setPonto_de_venda("Angeloni");
        pesquisa.setPreco_estipulado(100);
    }

    @Test
    public void deveCalcularMargemSimplesPositiva() {
        Resposta resposta = new Resposta();
        resposta.setResposta("50");
        Integer valorEsperado = 50;
        assertEquals(margemHelper.calculaMargemSimples(pesquisa, resposta), valorEsperado);
    }

    @Test
    public void deveCalcularMargemSimplesNegativa() {
        Resposta resposta = new Resposta();
        resposta.setResposta("150");
        Integer valorEsperado = -50;
        assertEquals(margemHelper.calculaMargemSimples(pesquisa, resposta), valorEsperado);
    }

    @Test
    public void deveTratarLetras() {
        Resposta resposta = new Resposta();
        resposta.setResposta("You shall not pass");
        assertNull(margemHelper.calculaMargemSimples(pesquisa, resposta));
    }

}