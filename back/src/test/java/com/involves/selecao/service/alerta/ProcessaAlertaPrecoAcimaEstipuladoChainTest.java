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

public class ProcessaAlertaPrecoAcimaEstipuladoChainTest {

    private Pesquisa pesquisa = new Pesquisa();
    private IProcessadorAlerta precoAcimaEstipulado = new ProcessaAlertaPrecoAcimaEstipuladoChain();
    private final String PRECO_ACIMA = "150";

    @Before
    public void configuracao() {
        pesquisa = PesquisaFactory.getPesquisa();
    }

    @Test
    public void verificaSeCriouAlertaPrecoAcimaEstipulado() {
        Resposta resposta = new Resposta(PerguntaEnum.PRECO_PRODUTO.getPergunta(), PRECO_ACIMA);
        Alerta alerta = precoAcimaEstipulado.processaAlerta(pesquisa, resposta).get();
        assertEquals(alerta.getDescricao(), AlertaEnum.PRECO_ACIMA_ESTIPULADO.getDescricao());
        assertEquals(alerta.getFlTipo().intValue(), AlertaEnum.PRECO_ACIMA_ESTIPULADO.getFlTipo());
        assertEquals(alerta.getMargem().intValue(), -50);
    }

    @Test
    public void verificaSePodeCriarAlertaPrecoAcimaEstipuladoComRespostaAcima() {
        Resposta resposta = new Resposta(PerguntaEnum.PRECO_PRODUTO.getPergunta(), PRECO_ACIMA);
        assertTrue(precoAcimaEstipulado.verificaCriacaoAlerta(pesquisa, resposta));
    }

    @Test
    public void verificaSePodeCriarAlertaPrecoAcimaEstipuladoComRespostaInferior() {
        Resposta resposta = new Resposta(PerguntaEnum.PRECO_PRODUTO.getPergunta(), "99");
        assertFalse(precoAcimaEstipulado.verificaCriacaoAlerta(pesquisa, resposta));
    }

    @Test
    public void verificaSePodeCriarAlertaPrecoAcimaEstipuladoComPerguntaSituacaoProduto() {
        Resposta resposta = new Resposta(PerguntaEnum.SITUACAO_PRODUTO.getPergunta(), PRECO_ACIMA);
        assertFalse(precoAcimaEstipulado.verificaCriacaoAlerta(pesquisa, resposta));
    }

}