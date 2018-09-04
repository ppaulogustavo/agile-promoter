package com.involves.selecao.service.alerta;

import com.involves.selecao.entity.Pesquisa;
import com.involves.selecao.entity.Resposta;
import com.involves.selecao.entity.Alerta;
import com.involves.selecao.interfaces.IProcessadorAlerta;

import java.util.Optional;

public abstract class AbastractAlertaChain implements IProcessadorAlerta {

    private IProcessadorAlerta processadorAlerta;

    @Override
    public Optional<Alerta> processaAlerta(Pesquisa pesquisa, Resposta resposta) {
        return Optional.empty();
    }

    @Override
    public boolean verificaCriacaoAlerta(Pesquisa pesquisa, Resposta resposta) {
        return false;
    }

    public IProcessadorAlerta setProximaValidacao(IProcessadorAlerta processadorAlerta) {
        this.processadorAlerta = processadorAlerta;
        return this.processadorAlerta;
    }

    public Optional<Alerta> criarAlerta(Pesquisa pesquisa, Resposta resposta) {
        if (this.verificaCriacaoAlerta(pesquisa, resposta)) {
            return this.processaAlerta(pesquisa, resposta);
        } else if (processadorAlerta != null) {
            return processadorAlerta.criarAlerta(pesquisa, resposta);
        }

        return Optional.empty();
    }

}
