package com.involves.selecao.service.alerta;

import com.involves.selecao.entity.Pesquisa;
import com.involves.selecao.entity.Resposta;
import com.involves.selecao.builder.AlertaBuilder;
import com.involves.selecao.entity.Alerta;
import com.involves.selecao.enums.PerguntaEnum;
import com.involves.selecao.enums.RespostaEnum;

import java.util.Optional;

public class ProcessaAlertaRupturaChain extends AbastractAlertaChain {

    @Override
    public Optional<Alerta> processaAlerta(Pesquisa pesquisa, Resposta resposta) {
        return new AlertaBuilder(pesquisa.getPonto_de_venda(), pesquisa.getProduto())
                .ruptura()
                .build();
    }

    @Override
    public boolean verificaCriacaoAlerta(Pesquisa pesquisa, Resposta resposta) {
        return PerguntaEnum.SITUACAO_PRODUTO.validarPergunta(resposta.getPergunta())
                && RespostaEnum.PRODUTO_AUSENTE_NA_GONDULA.validarResposta(resposta.getResposta());
    }

}
