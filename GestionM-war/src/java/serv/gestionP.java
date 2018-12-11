/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serv;

import gestion.gestionPublicLocal;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.Collections;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Meiji
 */
@WebServlet(name = "gestionP", urlPatterns = {"/gestionP"})
public class gestionP extends HttpServlet {

    @EJB
    private gestionPublicLocal gestionPublic;

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
        String message="";
        
        response.setContentType("text/html;charset=UTF-8");
        String jspClient = null;
        RequestDispatcher Rd;
        
        String act = request.getParameter("action");
        if (act == null)
        {
            jspClient = "/MenuGlobal.jsp";
            request.setAttribute("message", "pas d'infos");
        }
        
        else if (act.equals("afficherMatch"))
        {  
            request.setAttribute("message", "Veuillez sélectionner au moins une date");
            String datedebutstring = request.getParameter("datedebut");
            String datefinstring = request.getParameter("datefin");
            List list = Collections.emptyList();
            if (datedebutstring.trim().isEmpty()){
                request.setAttribute("listeMatch", list);
                jspClient = "/AfficherMatch.jsp";
            }
            else{
              if(datefinstring.trim().isEmpty()){
                    list = gestionPublic.afficherMatchDate(Date.valueOf(datedebutstring));
                    request.setAttribute("listeMatch", list);
                    if(list.isEmpty()){
                        request.setAttribute("message", "Il n'y a pas de match prévu à ces dates");
                    }
                }
                else{
                    if (Date.valueOf(datedebutstring).compareTo(Date.valueOf(datefinstring)) > 0){
                        request.setAttribute("message", "Veuillez sélectionner une intervalle correcte");
                        request.setAttribute("listeMatch", list);
                    }
                    else{
                        list = gestionPublic.afficherMatchIntervalleDate(Date.valueOf(datedebutstring), Date.valueOf(datefinstring));
                        request.setAttribute("listeMatch", list);
                        if(list.isEmpty()){
                            request.setAttribute("message", "Il n'y a pas de match prévu à ces dates");
                        }
                    }
                }
            } 
            jspClient="/AfficherMatch.jsp";   
        }
        
        Rd = getServletContext().getRequestDispatcher(jspClient);
        Rd.forward(request, response);
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet gestionP</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet gestionP at " + request.getContextPath() + "</h1>");
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
        processRequest(request, response);
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
        processRequest(request, response);
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
