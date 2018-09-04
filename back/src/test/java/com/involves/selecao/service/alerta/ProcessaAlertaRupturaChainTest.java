package com.involves.selecao.service.alerta;

import com.involves.selecao.entity.Alerta;
import com.involves.selecao.entity.Pesquisa;
import com.involves.selecao.entity.PesquisaFactory;
import com.involves.selecao.entity.Resposta;
import com.involves.selecao.enums.AlertaEnum;
import com.involves.selecao.enums.PerguntaEnum;
import com.involves.selecao.enums.RespostaEnum;
import com.involves.selecao.interfaces.IProcessadorAlerta;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ProcessaAlertaRupturaChainTest {

    private Pesquisa pesquisa = new Pesquisa();
    private IProcessadorAlerta ruptura = new ProcessaAlertaRupturaChain();

    @Before
    public void configuracao() {
        pesquisa = PesquisaFactory.getPesquisa();
    }

    @Test
    public void verificaSeCriouAlertaRuptura() {
        Resposta resposta = new Resposta(PerguntaEnum.SITUACAO_PRODUTO.getPergunta(), RespostaEnum.PRODUTO_AUSENTE_NA_GONDULA.getResposta());
        Alerta alerta = ruptura.processaAlerta(pesquisa, resposta).get();

        assertEquals(alerta.getDescricao(), AlertaEnum.RUPTURA.getDescricao());
        assertEquals(alerta.getFlTipo().intValue(), AlertaEnum.RUPTURA.getFlTipo());
    }

    @Test
    public void verificaSePodeCriarAlertaRupturaProdutoAusenteGondola() {
        Resposta resposta = new Resposta(PerguntaEnum.SITUACAO_PRODUTO.getPergunta(), RespostaEnum.PRODUTO_AUSENTE_NA_GONDULA.getResposta());
        assertTrue(ruptura.verificaCriacaoAlerta(pesquisa, resposta));
    }

    @Test
    public void verificaSePodeCriarAlertaRupturaProdutoNaGondola() {
        Resposta resposta = new Resposta(PerguntaEnum.SITUACAO_PRODUTO.getPergunta(), RespostaEnum.PRODUTO_NA_GONDOLA.getResposta());
        assertFalse(ruptura.verificaCriacaoAlerta(pesquisa, resposta));
    }

    @Test
    public void verificaSePodeCriarAlertaRupturaPerguntaPreco() {
        Resposta resposta = new Resposta(PerguntaEnum.PRECO_PRODUTO.getPergunta(), RespostaEnum.PRODUTO_AUSENTE_NA_GONDULA.getResposta());
        assertFalse(ruptura.verificaCriacaoAlerta(pesquisa, resposta));
    }

    @Test
    public void verificaSePodeCriarAlertaRupturaPerguntaShare() {
        Resposta resposta = new Resposta(PerguntaEnum.SHARE.getPergunta(), RespostaEnum.PRODUTO_AUSENTE_NA_GONDULA.getResposta());
        assertFalse(ruptura.verificaCriacaoAlerta(pesquisa, resposta));
    }

}