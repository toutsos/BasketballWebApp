/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kepyes.servlet.player;

import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import kepyes.entities.Player;
import kepyes.service.PlayerService;

/**
 *
 * @author atoutsios
 */
@WebServlet (name = "CreatePlayerServlet", urlPatterns = {"/player/insert"})
public class CreatePlayerServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        StringBuilder builder = new StringBuilder();
        String contextPath = request.getContextPath();
        builder.append("<!DOCTYPE html>")
                .append("<html>")
                .append("<head>")
                .append("<title>Insert Player</title>")
                .append("</head>")
                .append("<body>")
                .append("<h1>New Player</h1>")
                .append("<form action= \"").append(contextPath).append("/player/insert\" method= \"post\">")
                .append("Name:").append("<input type=\"text\" name=\"name\">")
                .append("<br/>")
                .append("Age:").append("<input type=\"text\" name=\"age\">")
                .append("<br/>")
                .append("Phone:").append("<input type=\"text\" name=\"phone\">")
                .append("<br/>")
                .append("Height:").append("<input type=\"text\" name=\"height\">")
                .append("<br/>")
                .append("Weight:").append("<input type=\"text\" name=\"weight\">")
                .append("<br/>")
                .append("<input type=\"submit\" value=\"Submit\">")
                .append("</form>")
                .append("</body>")
                .append("</html>");

        PrintWriter out = response.getWriter();
        out.println(builder);
        
    }//doGet
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PlayerService ps = new PlayerService();
        String pname = request.getParameter("name");
        String age = request.getParameter("age");
        int page = Integer.parseInt(age);
        
        String pphone = request.getParameter("phone");
       
        String height = request.getParameter("height");
        int pheight = Integer.parseInt(height);
        String weight = request.getParameter("weight");
        double pweight = Double.parseDouble(weight);
        Player newPlayer = new Player(pname,page,pphone,pheight,pweight);
        ps.createPlayer(newPlayer);
        RequestDispatcher dispatcher = request.getRequestDispatcher("../playerlist");
        dispatcher.forward(request,response);
        
    }//doPost
    
    
    
}
