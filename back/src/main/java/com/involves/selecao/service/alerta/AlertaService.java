package com.involves.selecao.service.alerta;

import com.involves.selecao.entity.Pesquisa;
import com.involves.selecao.entity.Alerta;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AlertaService {

    private ProcessadorAlertaChain processadorAlertaChain = new ProcessadorAlertaChain();

    public List<Alerta> criarAlertas(Pesquisa pesquisa) {
        return pesquisa.getRespostas()
                .stream()
                .map(resposta -> processadorAlertaChain.criarAlerta(pesquisa, resposta))
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toList());
    }

}