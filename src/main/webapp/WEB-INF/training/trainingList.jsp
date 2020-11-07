<%-- 
    Document   : trainingList
    Created on : Nov 7, 2020, 10:16:19 AM
    Author     : atoutsios
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Training List</title>
    </head>
    <body>
        <div align='center'>
            <h1>Training List</h1>
            <table border=\"1\">
                <tr>
                    <th>Date</th>
                    <th>Stadium</th>
                </tr>
                <c:forEach items="${listOfTrainings}" var="training">
                    <tr>
                        <td>${training.trainingDateTime}</td>
                        <td>${training.trainingStadium}</td>
                        <td><a href="${request.getContextPath()}/BasketWebApp/participatedplayers?id=${training.id}">players</a></td>
                        <td><a href="${request.getContextPath()}/BasketWebApp/insertplayers?id=${training.id}">insert</a></td>
                    </tr>
                </c:forEach>
            </table>
            <a href="${request.getContextPath()}/BasketWebApp/menu/trainingMenu.jsp"><input type=button value=Back></a>
        </div>
    </body>
</html>
