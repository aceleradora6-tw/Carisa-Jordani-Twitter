package br.com.aceleradora.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.SessionScoped;

@Component
@SessionScoped
public class BancoDeDados{
	private List<Tweet> todosTweets;
	private List<Pessoa> usuarios;
	
	public BancoDeDados(){
		todosTweets = new ArrayList<Tweet>();
		usuarios = new ArrayList<Pessoa>();
	}
	
	public void adicionaTweet(Pessoa pessoa, Tweet tweet){
		if (!(usuarios.contains(pessoa)))
			usuarios.add(pessoa);
		int posicao=usuarios.indexOf(pessoa);
		usuarios.get(posicao).adicionaTweetUsuario(tweet);
		todosTweets.add(0, tweet);
	}
	
	public void removeTweet(Pessoa pessoa, Tweet tweet){
		int posicao=usuarios.indexOf(pessoa);
		usuarios.get(posicao).removeTweetUsuario(tweet);
		int posicaoTweet=todosTweets.indexOf(tweet);
		todosTweets.remove(posicaoTweet);		
	}
	
	public List<Pessoa> listaTweets(){
		return usuarios;
	}

	public void editeTweet(Pessoa pessoa, Tweet tweet){
		int posicao=usuarios.indexOf(pessoa);
		usuarios.get(posicao).editeTweetUsuario(tweet);
		int posicaoTweet=todosTweets.indexOf(tweet);
		todosTweets.get(posicaoTweet).setMensagem(tweet.getMensagem());
		todosTweets.get(posicaoTweet).setData(new Date());
	}
	
	public int quantidadeTweetsPorUsuario(Pessoa pessoa){
		int posicao=usuarios.indexOf(pessoa);
		return usuarios.get(posicao).quantidadeTweetsUsuario();
	}
}
