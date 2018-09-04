package com.involves.selecao.builder;

import com.involves.selecao.entity.Alerta;
import com.involves.selecao.enums.AlertaEnum;

import java.util.Optional;

public class AlertaBuilder {

    private Alerta alerta = new Alerta();

    public AlertaBuilder(String pontoDeVenda, String produto) {
        this.alerta.setPontoDeVenda(pontoDeVenda);
        this.alerta.setProduto(produto);
    }

    public AlertaBuilder margem(Integer margem) {
        this.alerta.setMargem(margem);
        return this;
    }

    private void setTipoAlerta(AlertaEnum alertaEnum) {
        this.alerta.setDescricao(alertaEnum.getDescricao());
        this.alerta.setFlTipo(alertaEnum.getFlTipo());
    }

    public AlertaBuilder ruptura() {
        this.setTipoAlerta(AlertaEnum.RUPTURA);
        return this;
    }

    public AlertaBuilder precoAcimaEstipulado() {
        this.setTipoAlerta(AlertaEnum.PRECO_ACIMA_ESTIPULADO);
        return this;
    }

    public AlertaBuilder precoInferiorEstipulado() {
        this.setTipoAlerta(AlertaEnum.PRECO_INFERIOR_ESTIPULADO);
        return this;
    }

    public AlertaBuilder participacaoAcimaEstipulado() {
        this.setTipoAlerta(AlertaEnum.PARTICIPACAO_ACIMA_ESTIPULADO);
        return this;
    }

    public AlertaBuilder participacaoInferiorEstipulado() {
        this.setTipoAlerta(AlertaEnum.PARTICIPACAO_INFERIOR_ESTIPULADO);
        return this;
    }

    public Optional<Alerta> build() {
        return Optional.of(this.alerta);
    }

}
