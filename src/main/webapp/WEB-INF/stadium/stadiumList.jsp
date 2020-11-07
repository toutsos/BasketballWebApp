<%-- 
    Document   : stadiumList
    Created on : Nov 7, 2020, 9:36:11 AM
    Author     : atoutsios
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
    <html>
        <head>
            <title>Stadiums List</title>
        </head>
        <body>
            <div align=center>
                <a href="${pageContext.request.getContextPath()}/stadium/insert")> NEW STADIUM</a>
                <h1>Stadiums List</h1>
                <table border=\"1\">
                    <c:forEach items="${listOfStadiums}" var="stadium">
                        <tr>
                            <td>${stadium.name}</td>
                            <td><a href="${pageContext.request.getContextPath()}/stadium/delete?id=${stadium.id}">delete</a></td>
                        </tr>
                    </c:forEach>   
                </table>
                <a href="${request.getContextPath()}/BasketWebApp/menu/teamMenu.jsp"><input type=button value=Back></a>
            </div>
        </body>
    </html>
