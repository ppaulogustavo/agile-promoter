package com.involves.selecao.enums;

public enum RespostaEnum {

    PRODUTO_NA_GONDOLA("Produto esta na gondola"),
    PRODUTO_AUSENTE_NA_GONDULA("Produto ausente na gondola");

    private String resposta;

    RespostaEnum(String resposta) {
        this.resposta = resposta;
    }

    public String getResposta() {
        return resposta;
    }

    public boolean validarResposta(String resposta) {
        return this.getResposta().equals(resposta);
    }

}
