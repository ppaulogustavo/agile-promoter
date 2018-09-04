package com.involves.selecao.helper;

import com.involves.selecao.entity.Pesquisa;
import com.involves.selecao.entity.Resposta;

public class MargemHelper {

    private boolean isNumero(String numero) {
        return numero.chars().allMatch( Character::isDigit );
    }

    public Integer calculaMargemSimples(Pesquisa pesquisa, Resposta resposta) {
        if (!isNumero(resposta.getResposta()))
            return null;

        return pesquisa.getPreco_estipulado() - Integer.parseInt(resposta.getResposta());
    }

    public Integer calcularMargemParticipacaoEstipulada(Pesquisa pesquisa, Resposta resposta) {
        if (!isNumero(resposta.getResposta()))
            return null;

        return pesquisa.getParticipacaoEstipulada() - Integer.parseInt(resposta.getResposta());
    }

}
