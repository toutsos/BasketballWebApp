/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kepyes.servlet.player;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import kepyes.dao.PlayerDao;
import kepyes.entities.Player;
import kepyes.service.PlayerService;

/**
 *
 * @author atoutsios
 */
@WebServlet (name = "PlayerList", urlPatterns = {"/playerlist"})
public class PlayerListSerlvet extends HttpServlet {

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PlayerService ps = new PlayerService();
        List<Player> listOfPlayers = ps.getPlayers();
        StringBuilder builder = new StringBuilder();
        builder.append("<!DOCTYPE html>")
                .append("<html>")
                .append("<head>")
                .append("<title>Player List</title>")
                .append("</head>")
                .append("<body>")
                .append("<a href=\"").append(request.getContextPath()).append("/player/insert").append("\"> NEW PLAYER</a>")
                .append("<h1>Player List</h1>")
                .append("<table border=\"1\">");
        for (Player p : listOfPlayers){
                builder.append("<tr>")
                .append("<td>").append(p.getName()).append("</td>")
                .append("<td>").append(p.getPhone()).append("</td>")
                .append("<td>").append("<a href=\"").append(request.getContextPath()).append("/player/delete?id=").append(p.getId()).append("\">delete</a>").append("</td>")
                .append("<tr>");
            }
        builder.append("</table>")
                .append("<button type=\"button\" name=\"back\" onclick=\"history.back()\">back</button>")
                .append("</body>")
                .append("</html>");
        PrintWriter out = response.getWriter();
        out.println(builder);
                
        }//doGet
        

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            doGet(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
