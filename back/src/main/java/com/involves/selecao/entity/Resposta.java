package com.involves.selecao.entity;

import com.involves.selecao.enums.PerguntaEnum;

public class Resposta {
	
	private String pergunta;
	private String resposta;

	public Resposta() {

	}

	public Resposta(String pergunta, String resposta) {
		this.pergunta = pergunta;
		this.resposta = resposta;
	}

	public String getPergunta() {
		return pergunta;
	}

	public void setPergunta(String pergunta) {
		this.pergunta = pergunta;
	}

	public String getResposta() {
		return resposta;
	}

	public void setResposta(String resposta) {
		this.resposta = resposta;
	}
}
