package com.involves.selecao.service.alerta;

import com.involves.selecao.entity.Pesquisa;
import com.involves.selecao.entity.Resposta;
import com.involves.selecao.entity.Alerta;
import com.involves.selecao.interfaces.IProcessadorAlerta;

import java.util.Optional;

public class ProcessadorAlertaChain {

    private IProcessadorAlerta processadorAlerta;

    public ProcessadorAlertaChain() {
        this.processadorAlerta = new ProcessaAlertaRupturaChain();
        this.processadorAlerta
                .setProximaValidacao(new ProcessaAlertaPrecoInferiorEstipuladoChain())
                .setProximaValidacao(new ProcessaAlertaPrecoAcimaEstipuladoChain())
                .setProximaValidacao(new ProcessaAlertaParticipacaoAcimaEstipuladoChain())
                .setProximaValidacao(new ProcessaAlertaParticipacaoInferiorEstipuladoChain());
    }

    public Optional<Alerta> criarAlerta(Pesquisa pesquisa, Resposta resposta) {
        return processadorAlerta.criarAlerta(pesquisa, resposta);
    }

}
