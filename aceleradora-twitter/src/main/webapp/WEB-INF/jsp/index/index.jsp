<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Delicia de título cara</title>
	<script type="text/javascript">
		function editar(id){
			document.getElementById("idForm"+id).style.visibility="";
		}
	</script>
</head>
<body>
	<form action="${linkTo[IndexController].twittar}" method="post">
		<label>Autor: </label>
		<!--<input type="text" name="tweet.autor" value="${autorAnterior}">-->
		<input name="pessoa.nome">
		<br />
		<label>Tweets: </label>
		<textarea name="tweet.mensagem"></textarea>
		<br />
		<input type="submit" value="Enviar">
	</form>
	
	<c:forEach items="${tweetList}" var="pessoa">
		<p>Autor: ${pessoa.nome} Tweet: ${pessoa.verTweetsUsuario} Data:	${tweet.data}</p>
		<!--<p>Quantidade de tweets do autor: ${bancodedadosquantidadeTweetsPorUsuario}</p>-->
		<form action="${linkTo[IndexController].delete}" method="post">
		<!--<input type="text" name="id" value="${tweetList.indexOf(tweet)}" hidden />-->
			<input type="submit" value="Deletar" />
		</form>
<!--
		<button onclick="editar(${tweetList.indexOf(tweet)})">Editar</button>
		<form action="${linkTo[IndexController].edite}" method="post" id="idForm${tweetList.indexOf(tweet)}" style="visibility:hidden">
			<label>Tweets: </label>
			<input type="text" name="id" value="${tweetList.indexOf(tweet)}" hidden />
			<textarea name="mensagem">${tweet.mensagem}</textarea>
			<input type="submit" value="Enviar">
		</form>
	</c:forEach>-->
</body>
</html> 
