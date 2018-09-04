package com.involves.selecao.service.alerta;

import com.involves.selecao.entity.Alerta;
import com.involves.selecao.entity.Pesquisa;
import com.involves.selecao.entity.PesquisaFactory;
import com.involves.selecao.entity.Resposta;
import com.involves.selecao.enums.AlertaEnum;
import com.involves.selecao.enums.PerguntaEnum;
import com.involves.selecao.interfaces.IProcessadorAlerta;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ProcessaAlertaPrecoInferiorEstipuladoChainTest {

    private Pesquisa pesquisa = new Pesquisa();
    private IProcessadorAlerta precoInferiorEstipulado = new ProcessaAlertaPrecoInferiorEstipuladoChain();
    private final String PRECO_INFERIOR = "50";

    @Before
    public void configuracao() {
        pesquisa = PesquisaFactory.getPesquisa();
    }

    @Test
    public void verificaSeCriouAlertaPrecoInferiorEstipulado() {
        Resposta resposta = new Resposta(PerguntaEnum.PRECO_PRODUTO.getPergunta(), PRECO_INFERIOR);
        Alerta alerta = precoInferiorEstipulado.processaAlerta(pesquisa, resposta).get();
        assertEquals(alerta.getDescricao(), AlertaEnum.PRECO_INFERIOR_ESTIPULADO.getDescricao());
        assertEquals(alerta.getFlTipo().intValue(), AlertaEnum.PRECO_INFERIOR_ESTIPULADO.getFlTipo());
        assertEquals(alerta.getMargem().intValue(), 50);
    }

    @Test
    public void verificaSePodeCriarAlertaPrecoInferiorEstipuladoComRespostaInferior() {
        Resposta resposta = new Resposta(PerguntaEnum.PRECO_PRODUTO.getPergunta(), PRECO_INFERIOR);
        assertTrue(precoInferiorEstipulado.verificaCriacaoAlerta(pesquisa, resposta));
    }

    @Test
    public void verificaSePodeCriarAlertaPrecoInferiorEstipuladoComRespostaAcima() {
        Resposta resposta = new Resposta(PerguntaEnum.PRECO_PRODUTO.getPergunta(), "101");
        assertFalse(precoInferiorEstipulado.verificaCriacaoAlerta(pesquisa, resposta));
    }

    @Test
    public void verificaSePodeCriarAlertaPrecoInferiorEstipuladoComPerguntaSituacaoProduto() {
        Resposta resposta = new Resposta(PerguntaEnum.SITUACAO_PRODUTO.getPergunta(), "101");
        assertFalse(precoInferiorEstipulado.verificaCriacaoAlerta(pesquisa, resposta));
    }

}