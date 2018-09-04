package com.involves.selecao.service.alerta;

import com.involves.selecao.entity.Pesquisa;
import com.involves.selecao.entity.Resposta;
import com.involves.selecao.entity.Alerta;
import com.involves.selecao.interfaces.IProcessadorAlerta;

import java.util.Optional;

public class ProcessadorAlertaChain {

    private IProcessadorAlerta processadorAlerta;

    public ProcessadorAlertaChain() {
        this.processadorAlerta = new ProcessaAlertaRuptura();
        this.processadorAlerta
                .setProximaValidacao(new ProcessaAlertaPrecoInferiorEstipulado())
                .setProximaValidacao(new ProcessaAlertaPrecoAcimaEstipulado())
                .setProximaValidacao(new ProcessaAlertaParticipacaoAcimaEstipulado())
                .setProximaValidacao(new ProcessaAlertaParticipacaoInferiorEstipulado());
    }

    public Optional<Alerta> criarAlerta(Pesquisa pesquisa, Resposta resposta) {
        return processadorAlerta.criarAlerta(pesquisa, resposta);
    }

}
