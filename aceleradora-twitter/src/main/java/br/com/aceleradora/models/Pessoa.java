package br.com.aceleradora.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Pessoa {

	private String nome;
	private List<Tweet> tweets;
	
	public Pessoa(){
		tweets = new ArrayList<Tweet>();
	}
	
public void adicionaTweetUsuario(Tweet tweet){
		tweets.add(0, tweet);
	}
	
	public void removeTweetUsuario(Tweet tweet){
		int posicao = tweets.indexOf(tweet);
		tweets.remove(posicao);
	}
	
	public List<Tweet> verTweetsUsuario(){
		return tweets;
	}

	public void editeTweetUsuario(Tweet tweet) {
		int posicao = tweets.indexOf(tweet);
		tweets.get(posicao).setMensagem(tweet.getMensagem());
		tweets.get(posicao).setData(new Date());
	}
	
	public int quantidadeTweetsUsuario(){
		return  tweets.size();
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}


	
	
	
}
