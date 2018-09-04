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

public class ProcessaAlertaParticipacaoAcimaEstipuladoChainTest {

    private Pesquisa pesquisa;
    private IProcessadorAlerta participacaoAcimaEstipulado = new ProcessaAlertaParticipacaoAcimaEstipuladoChain();
    private final String PARTICIPACAO_ACIMA = "150";

    @Before
    public void configuracao() {
        pesquisa = PesquisaFactory.getPesquisa();
    }

    @Test
    public void verificaSeCriouAlertaParticipacaoAcimaEstipulado() {
        Resposta resposta = new Resposta(PerguntaEnum.SHARE.getPergunta(), PARTICIPACAO_ACIMA);
        Alerta alerta = participacaoAcimaEstipulado.processaAlerta(pesquisa, resposta).get();
        assertEquals(alerta.getDescricao(), AlertaEnum.PARTICIPACAO_ACIMA_ESTIPULADO.getDescricao());
        assertEquals(alerta.getFlTipo().intValue(), AlertaEnum.PARTICIPACAO_ACIMA_ESTIPULADO.getFlTipo());
        assertEquals(alerta.getMargem().intValue(), -50);
    }

    @Test
    public void verificaSePodeCriarAlertaParticipacaoAcimaEstipuladoComRespostaAcima() {
        Resposta resposta = new Resposta(PerguntaEnum.SHARE.getPergunta(), PARTICIPACAO_ACIMA);
        assertTrue(participacaoAcimaEstipulado.verificaCriacaoAlerta(pesquisa, resposta));
    }

    @Test
    public void verificaSePodeCriarAlertaParticipacaoAcimaEstipuladoComRespostaInferior() {
        Resposta resposta = new Resposta(PerguntaEnum.SHARE.getPergunta(), "99");
        assertFalse(participacaoAcimaEstipulado.verificaCriacaoAlerta(pesquisa, resposta));
    }

    @Test
    public void verificaSePodeCriarAlertaParticipacaoAcimaEstipuladoComPerguntaSituacaoProduto() {
        Resposta resposta = new Resposta(PerguntaEnum.SITUACAO_PRODUTO.getPergunta(), PARTICIPACAO_ACIMA);
        assertFalse(participacaoAcimaEstipulado.verificaCriacaoAlerta(pesquisa, resposta));
    }

}