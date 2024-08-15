<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dto.Card" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>カード情報</title>
</head>
<body>
	<%
		String msg = (String) request.getAttribute("msg");
	%>
	<h2><%= msg %></h2>
	
	<%
		Card card = (Card) request.getAttribute("card");
	%>
	
	<%
		if (card.getCardId() != null) {
	%>
	
	<table>
		<tr>
			<td>ID</td>
			<td><%= card.getCardId() %></td>
		</tr>
		<tr>
			<td>なまえ</td>
			<td><%= card.getCardName() %></td>
		</tr>
		<tr>
			<td>タイプ</td>
			<td><%= card.getCardType() %></td>
		</tr>
		<tr>
			<td>HP</td>
			<td><%= card.getCardHp() %></td>
		</tr>
		<tr>
			<td>わざ①</td>
			<td><%= card.getSkill1() %></td>
		</tr>
		<tr>
			<td>わざ②</td>
			<td><%= card.getSkill2() %></td>
		</tr>
	</table>
	
	<% } %>
	
	<form action="card-list-servlet" method="post">
		<input type="submit" name="btn" value="BACK"> <!-- name="btn"にすることでサーブレットでのエラー回避 -->
	</form>

</body>
</html>