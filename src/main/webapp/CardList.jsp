<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="dto.Card" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CARD LIST</title>
</head>
<body>
	<%
		String msg = (String) request.getAttribute("msg");
	%>
	<h2><%= msg %></h2>
	
	<table>
        <thead>
            <tr>
                <th>ID</th>
                <th>カード名</th>
            </tr>
        </thead>
        <tbody>
            <%
            	List<Card> cardList = (List<Card>) request.getAttribute("cardList");
                for (Card card : cardList) {
            %>
                <tr>
                    <td><%= card.getCardId() %></td>
                    <td><%= card.getCardName() %></td>
                </tr>
            <%
                }
            %>
        </tbody>
    </table>
    
    <form action="card-info-servlet" method="post">
    	<input type="submit" value="ID SEARCH > ">
    	<input type="text" name="id">
    </form>
    
    <form action="Menu.html" method="get">
    	<input type="submit" value="BACK">
    </form>

</body>
</html>