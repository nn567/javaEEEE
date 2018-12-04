<%-- 
    Document   : SanctionnerJ
    Created on : 3 déc. 2018, 21:34:56
    Author     : anastasia.salari
--%>
<%@page import="java.util.List"%>
<%@page import="Entites.Joueur"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link href="newcss1.css" rel="stylesheet" type="text/css">

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <jsp:useBean id="listeJoueurs" scope="request" class = "java.util.List"> </jsp:useBean>
            <title>JSP Page</title>
        </head>
        <body>
        <% List<Joueur> listeJ = listeJoueurs;%>
        <div class='bold-line'></div>
        <div class='container'>
            <div class='window'>
                <div class='overlay'></div>
                <div class='content'>
                    <div class='welcome'>Saisir informations interdictions</div>
                    <div class='input-fields'>
                        <form  method ="get" action="gestionF">
                            <label for="idJ">Joueur<span class="requis">*</span></label>
                            <select name="idJ" class='input-line full-width'>
                                <% for (Joueur a : listeJ) {%>
                                <option value="<%=a.getId()%>"><%=a.getNom()%> <%=a.getPrenom()%></option>
                                <%}%>                           
                            </select>
                            <label for="date">Date d'interdiction<span class="requis"></span></label> 
                            <input type="date" name="date" class ="input-line full-width" value="" size="20" maxlength="20"/>
                            <input type ="hidden" name="action" value="CreerInter">
                            </div>
                            <div><button class='ghost-round full-width'>Valider</button></div>
                        </form>
                    </div>
                </div>
            </div>   
    </body>
</html>
