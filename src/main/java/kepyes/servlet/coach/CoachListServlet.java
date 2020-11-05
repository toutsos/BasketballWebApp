/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kepyes.servlet.coach;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import kepyes.entities.Coach;
import kepyes.service.CoachService;
import kepyes.service.PlayerService;

/**
 *
 * @author atoutsios
 */
@WebServlet(name = "CoachListServlet", urlPatterns = {"/previouscoaches"})
public class CoachListServlet extends HttpServlet {

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        CoachService cs = new CoachService();
        List<Coach> listOfCoaches = cs.getCoaches();
        StringBuilder builder = new StringBuilder();
        builder.append("<!DOCTYPE html>")
                .append("<html>")
                .append("<head>")
                .append("<title>Coaches List</title>")
                .append("</head>")
                .append("<body>")
                .append("<h1>Coach History</h1>")
                .append("<table border=\"1\">");
        for (Coach c : listOfCoaches){
                builder.append("<tr>")
                .append("<td>").append(c.getName()).append("</td>")
                .append("<td>").append(c.getStart()).append("</td>")
                .append("<tr>");
            }
        builder.append("</table>")
                .append("<a href="+request.getContextPath()+"/coachMenu.jsp><input type=button value=Back></a>")
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
