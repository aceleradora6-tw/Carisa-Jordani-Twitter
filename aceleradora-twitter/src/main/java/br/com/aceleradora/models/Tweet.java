package br.com.aceleradora.models;

import java.util.Date;

public class Tweet{
	private String mensagem;
//	private String autor;
	private Date data;
	
	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	
//	public String getAutor() {
//		return autor;
//	}
//
//	public void setAutor(String autor) {
//		this.autor = autor;
//	}
	
	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}
}
