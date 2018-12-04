<%-- 
    Document   : MenuF
    Created on : 27 nov. 2018, 15:19:42
    Author     : anastasia.salari
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link href="newcss.css" rel="stylesheet" type="text/css">
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1></h1>
        <p> 
            <% String attribut = (String) request.getAttribute("message");
               if (attribut != null) 
                   out.println(attribut);
               else out.println("");
            %>
        </p>
        <nav>
            <ul>
                <li>
                    <a href ="CreerE.jsp">Créer équipe</a>
                </li>
                <br>
                <li>
                    <a href ="CreerA.jsp">Créer arbitre</a>
                </li>
                <br>
                <li>
                    <a href ="gestionF?action=creerMatch">Créer match</a>
                </li>
                <br>
                <li>
                    <a href ="gestionF?action=SanctJ">Sanctionner joueur</a>
                </li>
                <br>
                <li>
                    <a href ="CreerJ.jsp">Créer joueur</a>
                </li>
                <br>
                <li>
                    <a href ="CreerEnt.jsp">Créer entraineur</a>
                </li>
            </ul>
        </nav>



    </body>
</html>
