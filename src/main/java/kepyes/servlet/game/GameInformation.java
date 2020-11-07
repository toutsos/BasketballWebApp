/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kepyes.servlet.game;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import kepyes.dao.PlayerGameDao;
import kepyes.entities.Game;
import kepyes.entities.Player;
import kepyes.entities.PlayerGame;
import kepyes.service.GameService;

/**
 *
 * @author atoutsios
 */
@WebServlet(name = "GameInformation", urlPatterns = {"/game/information"})
public class GameInformation extends HttpServlet {


    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        PlayerGameDao pgd = new PlayerGameDao();
        List<PlayerGame> listOfPlayersGames = pgd.findAllPlayersGames();
        GameService gs = new GameService();
        Game game = gs.findGame(id);
        request.setAttribute("listOfPlayersGames", listOfPlayersGames);
        request.setAttribute("game", game);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/game/gamePlayerList.jsp");
        dispatcher.forward(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
             doGet(request, response);
    }


}
