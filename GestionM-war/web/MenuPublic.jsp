<%-- 
    Document   : MenuPublic
    Created on : 4 déc. 2018, 08:50:42
    Author     : 5151882
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
                out.println(attribut);
            %>
        </p>
        <nav>
            <ul>
                <li>
                    <a href ="gestionP?datedebut=&datefin=&action=afficherMatch">Afficher le classement</a>
                </li>
                <br>
                <li>
                    <a href ="gestionP?datedebut=&datefin=&action=afficherMatchDate">Rechercher des matchs par date</a>
                </li>
                <br>
                <li>
                    <a href ="gestionP?equipe=&action=afficherMatchEquipe">Rechercher des matchs par équipe</a>
                </li>
                <br>
                <li>
                    <a href ="gestionP?datedebut=&datefin=&action=afficherMatch">Afficher la composition des équipes</a>
                </li>
                <br>
                <br>
            </ul>
        </nav>



    </body>
</html>
