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

public class ProcessaAlertaParticipacaoInferiorEstipuladoChainTest {

    private Pesquisa pesquisa = new Pesquisa();
    private IProcessadorAlerta participacaoInferiorEstipulado = new ProcessaAlertaParticipacaoInferiorEstipuladoChain();
    private final String PARTICIPACAO_INFERIOR = "50";

    @Before
    public void configuracao() {
        pesquisa = PesquisaFactory.getPesquisa();
    }

    @Test
    public void verificaSeCriouAlertaParticipacaoInferiorEstipulado() {
        Resposta resposta = new Resposta(PerguntaEnum.SHARE.getPergunta(), PARTICIPACAO_INFERIOR);
        Alerta alerta = participacaoInferiorEstipulado.processaAlerta(pesquisa, resposta).get();
        assertEquals(alerta.getDescricao(), AlertaEnum.PARTICIPACAO_INFERIOR_ESTIPULADO.getDescricao());
        assertEquals(alerta.getFlTipo().intValue(), AlertaEnum.PARTICIPACAO_INFERIOR_ESTIPULADO.getFlTipo());
        assertEquals(alerta.getMargem().intValue(), 50);
    }

    @Test
    public void verificaSePodeCriarAlertaParticipacaoInferiorEstipuladoComRespostaInferior() {
        Resposta resposta = new Resposta(PerguntaEnum.SHARE.getPergunta(), PARTICIPACAO_INFERIOR);
        assertTrue(participacaoInferiorEstipulado.verificaCriacaoAlerta(pesquisa, resposta));
    }

    @Test
    public void verificaSePodeCriarAlertaParticipacaoInferiorEstipuladoComRespostaAcima() {
        Resposta resposta = new Resposta(PerguntaEnum.SHARE.getPergunta(), "101");
        assertFalse(participacaoInferiorEstipulado.verificaCriacaoAlerta(pesquisa, resposta));
    }

    @Test
    public void verificaSePodeCriarAlertaParticipacaoInferiorEstipuladoComPerguntaSituacaoProduto() {
        Resposta resposta = new Resposta(PerguntaEnum.SITUACAO_PRODUTO.getPergunta(), PARTICIPACAO_INFERIOR);
        assertFalse(participacaoInferiorEstipulado.verificaCriacaoAlerta(pesquisa, resposta));
    }

}