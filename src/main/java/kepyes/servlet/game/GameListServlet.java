/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kepyes.servlet.game;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import kepyes.dao.PlayerGameDao;
import kepyes.service.GameService;
import kepyes.entities.Game;
import kepyes.entities.PlayerGame;

/**
 *
 * @author atoutsios
 */
@WebServlet(name = "GameListServlet", urlPatterns = {"/gamelist"})
public class GameListServlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        GameService gs = new GameService();
        List<Game> listOfGames = gs.getGames();
        PlayerGameDao pgd = new PlayerGameDao();
        List<Game> games = pgd.findGeneratedGames();
        request.setAttribute("listOfGames",listOfGames);
        request.setAttribute("generatedGames", games);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/game/gameList.jsp");
        dispatcher.forward(request, response);
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
          doGet(request, response);
    }

    
}
