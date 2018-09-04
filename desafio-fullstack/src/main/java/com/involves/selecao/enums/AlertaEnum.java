package com.involves.selecao.enums;

public enum AlertaEnum {

    RUPTURA ("Ruptura detectada!", 1),
    PRECO_ACIMA_ESTIPULADO("Preço acima do estipulado", 2),
    PRECO_INFERIOR_ESTIPULADO("Preço abaixo do estipulado", 3),
    PARTICIPACAO_ACIMA_ESTIPULADO("Participação acima do estipulado", 4),
    PARTICIPACAO_INFERIOR_ESTIPULADO("Participação inferior do estipulado", 5);

    private String descricao;
    private int flTipo;
    private String label;

    AlertaEnum(String descricao, int flTipo) {
        this.descricao = descricao;
        this.flTipo = flTipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public int getFlTipo() {
        return flTipo;
    }

}
