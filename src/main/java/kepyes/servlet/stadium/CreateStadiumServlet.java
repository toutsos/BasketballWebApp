/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kepyes.servlet.stadium;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import kepyes.service.StadiumService;
import kepyes.entities.Stadium;

/**
 *
 * @author atoutsios
 */
@WebServlet(name = "CreateStadiumServlet", urlPatterns = {"/stadium/insert"})
public class CreateStadiumServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CreateStadiumServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CreateStadiumServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       StringBuilder builder = new StringBuilder();
        String contextPath = request.getContextPath();
        builder.append("<!DOCTYPE html>")
                .append("<html>")
                .append("<head>")
                .append("<title>Insert Stadium</title>")
                .append("</head>")
                .append("<body>")
                .append("<h1>New Stadium</h1>")
                .append("<form action= \"").append(contextPath).append("/stadium/insert\" method= \"post\">")
                .append("Name:").append("<input type=\"text\" name=\"name\">")
                .append("<br/>")
                .append("<input type=\"submit\" value=\"Submit\">")
                .append("</form>")
                .append("<a href="+request.getContextPath()+"/stadiumlist><input type=button value=Back></a>")
                .append("</body>")
                .append("</html>");

        PrintWriter out = response.getWriter();
        out.println(builder);
        
    }

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
        StadiumService ss = new StadiumService();
        String name = request.getParameter("name");
        Stadium newStadium = new Stadium(name);
        ss.createStadium(newStadium);
        RequestDispatcher dispatcher = request.getRequestDispatcher("../stadiumlist");
        dispatcher.forward(request,response);
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
