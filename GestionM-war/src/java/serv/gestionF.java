/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serv;

import Entites.Arbitre;
import Entites.Equipe;
import gestion.gestionFederationLocal;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author anastasia.salari
 */
@WebServlet(name = "gestionF", urlPatterns = {"/gestionF"})
public class gestionF extends HttpServlet {

    @EJB
    private gestionFederationLocal gestionFederation;
    
    private String user="";

    protected void ajoutArbitre(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException           
    {
        String nom = request.getParameter("nomA");
        String prenom = request.getParameter("prenomA");
        String login = request.getParameter("logA");
        String mdp = request.getParameter("mdpA");
       
        String message = "";
        if (nom.trim().isEmpty() || prenom.isEmpty() || login.isEmpty() || mdp.isEmpty())
        {
            message = "Erreur, vous n'avez pas rempli tous les champs" + "<br><a href=\"CreerA.jsp\">Cliquez ici</a> pour accéder au formulaire de création d'un arbitre";
        }
        else {
            
            gestionFederation.creerArbitre(nom, prenom, login, mdp);
            message = "Arbitre créé avec succès !";          
        }
        request.setAttribute("message", message);
        
    }
    
    protected void ajoutMatch(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException           
    {
        String E1 = request.getParameter("nomE1");
        String idA = request.getParameter("idA");
        String E2 = request.getParameter("nomE2");
        String date = request.getParameter("date");
        Date d = Date.valueOf(date);
        Date today = (Date) new java.util.Date();
//        String heure = request.getParameter("heure");
       
        String message = "";
        if (E1.trim().isEmpty() || E2.isEmpty() || date.isEmpty() || idA.isEmpty())
        {
           
            message = "Erreur, vous n'avez pas rempli tous les champs" + "<br><a href=\"CreerA.jsp\">Cliquez ici</a> pour accéder au formulaire de création d'un arbitre";
        }
        else if (d.before(today)){
            message = "La date n'est pas supérieure à aujourd'hui";
        }
        else {
             long id = Long.valueOf(idA);
          
     
            gestionFederation.creerMatch(E1, E2, id, date);
            message = "Match créé avec succès !";          
        }
        request.setAttribute("message", message);
        
    }
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
        
        HttpSession sess = request.getSession(true);
        
      
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
        
        else if (act.equals("authenF"))
        {
            
            String mdp = request.getParameter("mdp");
            if (mdp.equals("toto"))
            {
                jspClient = "/MenuF.jsp";
                user = "fed";
            }
            else {
                request.setAttribute("message", "pas d'infos");
                jspClient = "/MenuGlobal.jsp";
            }
        }
        
        else if (act.equals("CreerE") && user.equals("fed"))
        {
             String nom = request.getParameter("nomE");
                         
             if (nom.trim().isEmpty())
             {
                  message = "Erreur, vous avez pas rempli les champs";
                  request.setAttribute("message", message);
             }
             else {
                 jspClient = "/MenuF.jsp";
                 gestionFederation.creerEquipe(nom);
                 message = "Equipe créée avec succèss";
                 request.setAttribute("message", message);
             }
        }
        
        else if (act.equals("CreerA") && user.equals("fed"))
        {
            jspClient = "/MenuF.jsp";
            ajoutArbitre(request,response);
        }
        
         else if (act.equals("creerMatch"))
        {            
            jspClient="/CreerM.jsp";     
            List <Equipe> list = gestionFederation.recupEquipes();
            request.setAttribute("listeEquipes", list);
            List <Arbitre> listA = gestionFederation.recupArbitres();
            request.setAttribute("listeArbitres", listA);
           
        }
        
          else if (act.equals("CreerM"))
        {            
           jspClient = "/MenuF.jsp";
           ajoutMatch(request,response);
        }
        
        Rd = getServletContext().getRequestDispatcher(jspClient);
        Rd.forward(request, response);
        
        
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet gestionF</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet gestionF at " + request.getContextPath() + "</h1>");
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
