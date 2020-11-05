/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kepyes.servlet.training;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import kepyes.dao.PlayerTrainingDao;
import kepyes.service.PlayerService;
import kepyes.entities.Player;
import kepyes.entities.Training;
import kepyes.entities.PlayerTraining;
import kepyes.service.TrainingService;

/**
 *
 * @author atoutsios
 */
@WebServlet(name = "AddPlayersTraining", urlPatterns = {"/insertplayers"})
public class AddPlayersTraining extends HttpServlet {

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        StringBuilder builder = new StringBuilder();
        String contextPath = request.getContextPath();
        String id = request.getParameter("id");
        builder.append("<!DOCTYPE html>")
                .append("<html>")
                .append("<head>")
                .append("<title>Insert Player</title>")
                .append("</head>")
                .append("<body>")
                .append("<h1>New Player</h1>")
                .append("<form action= \"").append(contextPath).append("/insertplayers").append("\"method= \"post\">")
                .append("Name:").append("<input type=\"text\" name=\"name\">")
                .append("<br/>")
                .append("Rank:").append("<input type=\"text\" name=\"rank\">")
                .append("<br/>")
                .append("<input type=\"hidden\" name=\"passId\" value="+id+">")
                .append("<input type=\"submit\" value=\"Submit\">")
                .append("<a href="+request.getContextPath()+"/traininglist><input type=button value=Back></a>")
                .append("</form>")
                .append("</body>")
                .append("</html>");

        PrintWriter out = response.getWriter();
        out.println(builder);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
         
         String ids = request.getParameter("passId");
         int id = Integer.parseInt(ids);
         TrainingService ts = new TrainingService();
         PlayerTrainingDao ptd = new PlayerTrainingDao();
         Training training = ts.findTraining(id);
         String name = request.getParameter("name");
         String srank = request.getParameter("rank");
         int rank = Integer.parseInt(srank);
         PlayerService ps = new PlayerService();
         Player player = ps.findPlayerFromName(name);
         PlayerTraining newpt = new PlayerTraining(rank, player, training);
         ptd.save(newpt);
         RequestDispatcher dispatcher = request.getRequestDispatcher("../traininglist");
         dispatcher.forward(request,response);
    }

}
