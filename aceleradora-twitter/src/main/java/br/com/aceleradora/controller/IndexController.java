package br.com.aceleradora.controller;

import java.util.Date;
import java.util.List;

import br.com.aceleradora.models.BancoDeDados;
import br.com.aceleradora.models.Pessoa;
import br.com.aceleradora.models.Tweet;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;

@Resource
public class IndexController {
	private BancoDeDados bd;

	public IndexController(BancoDeDados bd) {
		this.bd = bd;
	}

	@Path("/")
	public List<Pessoa> index(Result result) {
		if(bd.listaTweets().size() != 0){
			//result.included();
//			result.include("autorAnterior", bd.usuarios().get(bd.todosTweets().size() - 1).g);
		}
		return bd.listaTweets();
	}
	
	public void twittar(Pessoa pessoa, Tweet tweet, Result result) {
		tweet.setData(new Date());
		bd.adicionaTweet(pessoa, tweet);
		result.include("quantidade", bd.quantidadeTweetsPorUsuario(pessoa));
		result.forwardTo(this).index(result);
	}

	public void delete(Pessoa pessoa, Tweet tweet, Result result) {
		bd.removeTweet(pessoa, tweet);
		result.forwardTo(this).index(result);
	}
	
	public void edite(Pessoa pessoa, Tweet tweet, Result result) {
//		System.out.println(id + " " + mensagem);
		bd.editeTweet(pessoa, tweet);
		result.forwardTo(this).index(result);
	}
}
