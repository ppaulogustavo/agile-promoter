package com.involves.selecao.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.involves.selecao.entity.Alerta;
import com.involves.selecao.service.BuscaAlertasService;
import com.involves.selecao.service.ProcessadorAlertas;

@CrossOrigin
@RestController
@RequestMapping("/alertas")
public class AlertaController {

    @Autowired
    private BuscaAlertasService buscaAlertasService;

    @Autowired
    private ProcessadorAlertas processador;

    @GetMapping
    public List<Alerta> alertas() {
        return buscaAlertasService.buscarTodos();
    }

    @GetMapping("/processar")
    public void processar() {
        processador.processa();
    }
}
