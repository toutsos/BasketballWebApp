<%-- 
    Document   : gamePlayerList
    Created on : Nov 7, 2020, 12:49:23 PM
    Author     : atoutsios
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Player List</title>
    </head>
    <body>
        <div align='center'>
            <h1>Date of Game:${game.gameDateTime} ,Opponent:${game.opponent}</h1>
            <h1> Player List</h1>
            <table border=\"1\">
                <c:forEach items="${listOfPlayersGames}" var="playerGame">
                    <c:if test="${playerGame.game.id == game.id}">
                        <tr>
                            <td>${playerGame.player.name}</td>
                            <td>${playerGame.points}</td>
                            <c:if test="${playerGame.points == 0}">
                                <td><a href="${request.getContextPath()}/BasketWebApp/game/addpoints?id=${playerGame.id}">Add points</a></td>
                            </c:if>
                        </tr>
                    </c:if>
                </c:forEach>
            </table>
            <a href="${request.getContextPath()}/BasketWebApp/gamelist"><input type=button value=Back></a>
        </div>
    </body>
</html>


