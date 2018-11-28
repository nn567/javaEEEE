<%-- 
    Document   : MenuF
    Created on : 27 nov. 2018, 15:19:42
    Author     : anastasia.salari
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1></h1>
        <p> 
            <% String attribut = (String)request.getAttribute("message");
        out.println(attribut);
        %>
        </p>
        <a href ="CreerE.jsp">Créer équipe</a>
         <a href ="CreerA.jsp">Créer arbitre</a>
         <a href ="gestionF?action=creerMatch">Créer match</a>
    </body>
</html>
