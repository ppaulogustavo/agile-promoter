package com.involves.selecao.enums;

public enum PerguntaEnum {

    SITUACAO_PRODUTO("Qual a situação do produto?"),
    PRECO_PRODUTO("Qual o preço do produto?"),
    SHARE("%Share");

    private String pergunta;

    PerguntaEnum(String pergunta) {
        this.pergunta = pergunta;
    }

    public String getPergunta() {
        return pergunta;
    }

    public boolean validarPergunta(String pergunta) {
        return this.getPergunta().equals(pergunta);
    }
}
