package com.involves.selecao.service.alerta;

import com.involves.selecao.entity.Pesquisa;
import com.involves.selecao.entity.Resposta;
import com.involves.selecao.entity.Alerta;
import com.involves.selecao.enums.AlertaEnum;
import org.junit.Before;
import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.*;

public class ProcessadorAlertaChainTest {

    public ProcessadorAlertaChain processadorAlertaChain = new ProcessadorAlertaChain();
    public Pesquisa pesquisa = new Pesquisa();


    @Before
    public void configuracaoInicial() {
        pesquisa.setId(1);
        pesquisa.setNotificante("Angeloni");
        pesquisa.setPonto_de_venda("Angeloni");
        pesquisa.setPreco_estipulado(100);
        pesquisa.setParticipacaoEstipulada(48);
    }

    @Test
    public void deveCriarAlertaRuptura() {
        Resposta resposta = new Resposta();
        resposta.setPergunta("Qual a situação do produto?");
        resposta.setResposta("Produto ausente na gondola");

        Optional<Alerta> alerta = processadorAlertaChain.criarAlerta(pesquisa, resposta);
        assertEquals(alerta.get().getDescricao(), AlertaEnum.RUPTURA.getDescricao());
    }

    @Test
    public void deveCriarAlertaPrecoAcimaEstipulado() {
        Resposta resposta = new Resposta();
        resposta.setPergunta("Qual o preço do produto?");
        resposta.setResposta("200");

        Optional<Alerta> alerta = processadorAlertaChain.criarAlerta(pesquisa, resposta);
        assertEquals(alerta.get().getDescricao(), AlertaEnum.PRECO_ACIMA_ESTIPULADO.getDescricao());
    }

    @Test
    public void deveCriarAlertaPrecoInferiorEstipulado() {
        Resposta resposta = new Resposta();
        resposta.setPergunta("Qual o preço do produto?");
        resposta.setResposta("50");

        Optional<Alerta> alerta = processadorAlertaChain.criarAlerta(pesquisa, resposta);
        assertEquals(alerta.get().getDescricao(), AlertaEnum.PRECO_INFERIOR_ESTIPULADO.getDescricao());
    }

    @Test
    public void deveCriarAlertaParticipacaoAcimaEstipulado() {
        Resposta resposta = new Resposta();
        resposta.setPergunta("%Share");
        resposta.setResposta("50");

        Optional<Alerta> alerta = processadorAlertaChain.criarAlerta(pesquisa, resposta);
        assertEquals(alerta.get().getDescricao(), AlertaEnum.PARTICIPACAO_ACIMA_ESTIPULADO.getDescricao());
    }

    @Test
    public void deveCriarAlertaParticipacaoInferiorEstipulado() {
        Resposta resposta = new Resposta();
        resposta.setPergunta("%Share");
        resposta.setResposta("47");

        Optional<Alerta> alerta = processadorAlertaChain.criarAlerta(pesquisa, resposta);
        assertEquals(alerta.get().getDescricao(), AlertaEnum.PARTICIPACAO_INFERIOR_ESTIPULADO.getDescricao());
    }

    @Test
    public void deveTratarMargemZero() {
        Resposta resposta = new Resposta();
        resposta.setPergunta("Qual o preço do produto?");
        resposta.setResposta("100");

        Optional<Alerta> alerta = processadorAlertaChain.criarAlerta(pesquisa, resposta);
        assertEquals(alerta.isPresent(), false);
    }

}