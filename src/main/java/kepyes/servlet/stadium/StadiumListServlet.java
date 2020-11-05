/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kepyes.servlet.stadium;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import kepyes.service.StadiumService;
import kepyes.entities.Stadium;

/**
 *
 * @author atoutsios
 */
@WebServlet(name = "StadiumListServlet", urlPatterns = {"/stadiumlist"})
public class StadiumListServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        StadiumService ss = new StadiumService();
        List<Stadium> listOfStadiums = ss.getStadiums();
        StringBuilder builder = new StringBuilder();
        builder.append("<!DOCTYPE html>")
                .append("<html>")
                .append("<head>")
                .append("<title>Stadiums List</title>")
                .append("</head>")
                .append("<body>")
                .append("<a href=\"").append(request.getContextPath()).append("/stadium/insert").append("\"> NEW STADIUM</a>")
                .append("<h1>Stadiums List</h1>")
                .append("<table border=\"1\">");
        for (Stadium s : listOfStadiums){
                builder.append("<tr>")
                .append("<td>").append(s.getName()).append("</td>")
                .append("<td>").append("<a href=\"").append(request.getContextPath()).append("/stadium/delete?id=").append(s.getId()).append("\">delete</a>").append("</td>")
                .append("<tr>");
            }
        builder.append("</table>")
                .append("<a href="+request.getContextPath()+"/teamMenu.jsp><input type=button value=Back></a>")
                .append("</body>")
                .append("</html>");
        PrintWriter out = response.getWriter();
        out.println(builder);
                
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         doGet(request, response);
    }

}
