<%-- 
    Document   : playerList
    Created on : Nov 6, 2020, 10:14:22 AM
    Author     : atoutsios
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Player List</title>
    </head>
    <body>
        <div align='center'>
            <h1>Player List</h1>
            <a href="${pageContext.request.getContextPath()}/player/insert"><h1>Insert New Player</h1></a>
            <table border=\"1\">
                <tr>
                    <th> Name </th>
                    <th> Phone </th>
                </tr>
                <c:forEach items="${listOfPlayers}" var="player">
                    <tr>
                        <td>${player.name}</td>
                        <td>${player.phone}</td>
                        <td><a href="${pageContext.request.getContextPath()}/player/delete?id=${player.id}">Delete</a></td>
                    </tr>
                </c:forEach>
                    
            </table>
            <a href="${request.getContextPath()}/BasketWebApp/menu/teamMenu.jsp"><input type=button value=Back></a>
        </div>
    </body>
</html>
