<%-- 
    Document   : gameList
    Created on : Nov 7, 2020, 11:17:05 AM
    Author     : atoutsios
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>

<html>
    <head>
        <title>Game List</title>
    </head>
    <body>
        <div align='center'>
            <h1>Game List</h1>
            <table border='1'>
                <tr>
                    <th>Date</th>
                    <th>Stadium</th>
                    <th>Opponent</th>
                    <th>Game Info</th>
                    <th>Generate</th>
                </tr>
                    <c:forEach items="${listOfGames}" var="game">
                        <c:set var="flag" value="false"></c:set>
                        <tr>
                             <td>${game.gameDateTime}</td>
                             <td>${game.gameStadium.name}</td>
                             <td>${game.opponent}</td>
                             <c:forEach items="${generatedGames}" var="generatedGame">
                                <c:if test="${generatedGame.id == game.id}">
                                    <c:set var="flag" value="true"></c:set>
                                </c:if>
                             </c:forEach>
                                <c:if test="${flag == 'false'}">
                                     <td></td>
                                     <td><a href="${request.getContextPath()}/BasketWebApp/game/generate?id=${game.id}">Generate</a></td>
                                </c:if>
                                <c:if test="${flag == 'true'}">
                                    <td><a href="${request.getContextPath()}/BasketWebApp/game/information?id=${game.id}">Information</a></td>
                                    <td></td>
                                </c:if>     
                        </tr>   
                    </c:forEach>
            </table>
            <a href="${pageContext.request.getContextPath()}/menu/gameMenu.jsp"><input type=button value=back></a>
        </div>
    </body>    
</html> 

