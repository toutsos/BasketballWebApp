/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kepyes.servlet.game;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
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
            List<PlayerGame> listOfPlayers = pgd.findAllPlayersGames();
            GameService gs = new GameService();
            Game game = gs.findGame(id);
            StringBuilder builder = new StringBuilder();
            builder.append("<!DOCTYPE html>")
                .append("<html>")
                .append("<head>")
                .append("<title>Player List</title>")
                .append("</head>")
                .append("<body>")
                .append("<h1>Date of Game: ").append(game.getGameDateTime()).append(" ,Opponent: ").append(game.getOpponent())
                .append("<h1>Player List</h1>")
//                .append("<input type=\"hidden\" name=\"passId\" value="+id+">")
                .append("<table border=\"1\">");
        for (int i = 0;i<listOfPlayers.size();i++){
                if(listOfPlayers.get(i).getGame().getId() == id){
                builder.append("<tr>")
                .append("<td>").append(listOfPlayers.get(i).getPlayer().getName()).append("</td>")
                .append("<td>").append(listOfPlayers.get(i).getPoints()).append("</td>");
                if(listOfPlayers.get(i).getPoints()== 0){
                     builder.append("<td>").append("<a href=\"").append(request.getContextPath()).append("/game/addpoints?id=").append(listOfPlayers.get(i).getId()).append("&passId=").append(id).append("\">Add points</a>").append("</td>");
                }
                builder.append("<tr>");
                }
            }
        builder.append("</table>")
                .append("<a href="+request.getContextPath()+"/gameMenu.jsp><input type=button value=Back></a>")
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
