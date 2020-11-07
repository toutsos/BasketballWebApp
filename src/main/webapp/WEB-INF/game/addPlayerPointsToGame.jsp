<%-- 
    Document   : addPlayerPointsToGame
    Created on : Nov 7, 2020, 1:11:03 PM
    Author     : atoutsios
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Insert Points</title>
    </head>
    <body>
        <div align='center'>
            <form action= "${request.contextPath()}/BasketWebApp/game/addpoints" method= "post">
                Give points of: ${PlayerGame.player.name} ,at Game VS ${PlayerGame.game.opponent}
                <br/>
                <input type="text" name="points">
                <br/>
                <input type="submit" value="Submit">
                <br/>
                <input type="hidden" name="passPlayerGameId" value="${PlayerGame.id}">
            </form>
            <a  href="${request.getContextPath()}/BasketWebApp/game/information?id=${PlayerGame.game.id}"><input type=button value=Back></a>
           
        </div>
    </body>
</html>;