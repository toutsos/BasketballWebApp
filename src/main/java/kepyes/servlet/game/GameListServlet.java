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
        StringBuilder builder = new StringBuilder();
        PlayerGameDao pgd = new PlayerGameDao();
        builder.append("<!DOCTYPE html>")
                .append("<html>")
                .append("<head>")
                .append("<title>Games List</title>")
                .append("</head>")
                .append("<body>")
                .append("<h1>Game List</h1>")
                .append("<table border=\"1\">");
        for (Game g : listOfGames){
            List<PlayerGame> list = pgd.findAllPlayersGames();
            boolean flag = false;
            for (PlayerGame pg:list){
                if(pg.getGame().getId() == g.getId()){
                    flag=true;
                    break;
                }
            }
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String formatDateTime = g.gameDateTime.format(formatter);
                builder.append("<tr>")
                .append("<td>").append(formatDateTime).append("</td>")
                .append("<td>").append(g.gameStadium.getName()).append("</td>")
                .append("<td>").append(g.opponent).append("</td>")
                .append("<td>").append("<a href=\"").append(request.getContextPath()).append("/game/information?id=").append(g.getId()).append("\">Information</a>").append("</td>");
                if(flag == false){
                    builder.append("<td>").append("<a href=\"").append(request.getContextPath()).append("/game/generate?id=").append(g.getId()).append("\">Generate Players</a>").append("</td>");
                    
                }
                builder.append("<tr>");
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
