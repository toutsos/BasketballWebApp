<%-- 
    Document   : trainingPlayersList
    Created on : Nov 7, 2020, 10:37:21 AM
    Author     : atoutsios
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Training Players</title>
    </head>
    <body>
       
        <div align='center'>
            <h1>Training Players</h1>
            <table border=\"1\">
                <tr>
                    <th> Name </th>
                    <th> Rank </th>
                </tr>
                
                <c:forEach items="${playerTrainings}" var="playerTraining">
                    <tr>
                        <td>${playerTraining.player.name}</td>
                        <td>${playerTraining.rank}</td>
                    </tr>
                </c:forEach>
                    
            </table>
            <a href="${request.getContextPath()}/BasketWebApp/traininglist"><input type=button value=Back></a>
        </div>
   
    </body>
</html>
