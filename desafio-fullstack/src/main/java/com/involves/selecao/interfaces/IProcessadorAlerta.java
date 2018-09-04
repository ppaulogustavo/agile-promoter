package com.involves.selecao.interfaces;

import com.involves.selecao.entity.Pesquisa;
import com.involves.selecao.entity.Resposta;
import com.involves.selecao.entity.Alerta;

import java.util.Optional;

public interface IProcessadorAlerta {

    Optional<Alerta> processaAlerta(Pesquisa pesquisa, Resposta resposta);

    boolean verificaCriacaoAlerta(Pesquisa pesquisa, Resposta resposta);

    IProcessadorAlerta setProximaValidacao(IProcessadorAlerta processadorAlerta);

    Optional<Alerta> criarAlerta(Pesquisa pesquisa, Resposta resposta);

}
