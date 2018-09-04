package com.involves.selecao.service.alerta;

import com.involves.selecao.entity.Pesquisa;
import com.involves.selecao.entity.Resposta;
import com.involves.selecao.builder.AlertaBuilder;
import com.involves.selecao.entity.Alerta;
import com.involves.selecao.enums.PerguntaEnum;
import com.involves.selecao.helper.MargemHelper;

import java.util.Optional;

public class ProcessaAlertaPrecoAcimaEstipuladoChain extends AbastractAlertaChain {

    private MargemHelper margemHelper = new MargemHelper();

    @Override
    public Optional<Alerta> processaAlerta(Pesquisa pesquisa, Resposta resposta) {
        return new AlertaBuilder(pesquisa.getPonto_de_venda(), pesquisa.getProduto())
                .margem(margemHelper.calculaMargemSimples(pesquisa, resposta))
                .precoAcimaEstipulado()
                .build();
    }

    @Override
    public boolean verificaCriacaoAlerta(Pesquisa pesquisa, Resposta resposta) {
        return PerguntaEnum.PRECO_PRODUTO.validarPergunta(resposta.getPergunta()) && pesquisa.precoEstaAcimaEstipulado(resposta);
    }
}
