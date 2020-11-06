/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kepyes.servlet.game;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import kepyes.dao.PlayerGameDao;
import kepyes.entities.PlayerGame;

/**
 *
 * @author atoutsios
 */
@WebServlet(name = "AddPointsServlet", urlPatterns = {"/game/addpoints"})
public class AddPointsServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        StringBuilder builder = new StringBuilder();
        String contextPath = request.getContextPath();
        int id = Integer.parseInt(request.getParameter("id"));
//        int idGame = Integer.parseInt(request.getParameter("passId"));
        PlayerGameDao pgd = new PlayerGameDao();
        PlayerGame playerGame = pgd.find(id);
        builder.append("<!DOCTYPE html>")
                .append("<html>")
                .append("<head>")
                .append("<title>Insert Points</title>")
                .append("</head>")
                .append("<body>")
                .append("<form action= \"").append(contextPath).append("/game/addpoints\" method= \"post\">")
                .append("Give points of:").append(playerGame.getPlayer().getName()).append(" ,at Game VS ").append(playerGame.getGame().getOpponent())
                .append("<br/>")
                .append("<input type=\"text\" name=\"points\">")
                .append("<br/>")
                .append("<input type=\"submit\" value=\"Submit\">")
                .append("<br/>")
//                .append("<input type=\"hidden\" name=\"passGameId\" value="+idGame+">")
                .append("<input type=\"hidden\" name=\"passPlayerGameId\" value="+id+">")
                .append("</form>")
                .append("<a href="+request.getContextPath()+"/trainingMenu.jsp><input type=button value=Back></a>")
                .append("</body>")
                .append("</html>");

        PrintWriter out = response.getWriter();
        out.println(builder);
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
            int idPlayerGame = Integer.parseInt(request.getParameter("passPlayerGameId"));
            
            PlayerGameDao pgd = new PlayerGameDao();
            PlayerGame playerGame = pgd.find(idPlayerGame);
            
            int points = Integer.parseInt(request.getParameter("points"));
            
            playerGame.setPoints(points);
            pgd.update(playerGame);
            
            RequestDispatcher dispatcher = request.getRequestDispatcher("../gamelist");
            dispatcher.forward(request,response);
    }


}
