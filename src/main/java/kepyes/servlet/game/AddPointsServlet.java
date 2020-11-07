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
        int id = Integer.parseInt(request.getParameter("id"));
        PlayerGameDao pgd = new PlayerGameDao();
        PlayerGame playerGame = pgd.find(id);
        request.setAttribute("PlayerGame", playerGame);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/game/addPlayerPointsToGame.jsp");
        dispatcher.forward(request, response);
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
            
            response.sendRedirect("/BasketWebApp/game/information?id="+playerGame.getGame().getId());        
    }


}
