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
import kepyes.service.TrainingService;

/**
 *
 * @author atoutsios
 */
@WebServlet(name = "GeneratePlayersServlet", urlPatterns = {"/game/generate"})
public class GeneratePlayersServlet extends HttpServlet {

    
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int id = Integer.parseInt(request.getParameter("id"));
        PlayerGameDao pgd = new PlayerGameDao();
        GameService gs = new GameService();
        Game game = gs.findGame(id);
        TrainingService ts = new TrainingService();
       
        List<Player> playerSorted = ts.sortTraining();
        if(playerSorted.size()<10){
            for(int i = 0; i<playerSorted.size()-1;i++){
                PlayerGame pg  = new PlayerGame(playerSorted.get(i), game);
                pgd.save(pg);
            }//for
        }else{
            for (int i=0; i<10;i++){
                PlayerGame pg  = new PlayerGame(playerSorted.get(i), game);
                pgd.save(pg);
            }//for
        }//else
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("../gamelist");
        dispatcher.forward(request,response);
        
    }//doGet

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

}
