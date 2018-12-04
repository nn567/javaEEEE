<%-- 
    Document   : CreerM
    Created on : 27 nov. 2018, 16:14:20
    Author     : anastasia.salari
--%>
<%@page import="java.util.List"%>
<%@page import="Entites.Equipe"%>
<%@page import="Entites.Arbitre"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link href="newcss1.css" rel="stylesheet" type="text/css">
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:useBean id="listeEquipes" scope="request" class = "java.util.List"> </jsp:useBean>
        <jsp:useBean id="listeArbitres" scope="request" class = "java.util.List"> </jsp:useBean>
            <title>JSP Page</title>
        </head>
        <body>

        <% List<Equipe> listeE = listeEquipes;%>
        <% List<Arbitre> listeA = listeArbitres;%>

        <div class='bold-line'></div>
        <div class='container'>
            <div class='window'>
                <div class='overlay'></div>
                <div class='content'>
                    <div class='welcome'>Saisir informations match</div>
                    <div class='input-fields'>
                        <form  method ="get" action="gestionF">

                            <label for="nomE1">Equipe 1<span class="requis">*</span></label>
                            <select name="nomE1" class='input-line full-width'>
                                <% for (Equipe e : listeE ){%>
                                <option value="<%=e.getNomE()%>"><%=e.getNomE()%> </option>
                                <%}%>
                            </select>
                            <label for="nomE2">Equipe 2<span class="requis">*</span></label>
                            <select name="nomE2" class='input-line full-width'>
                                <% for (Equipe e : listeE ){%>
                                <option value="<%=e.getNomE()%>"><%=e.getNomE()%> </option>
                                <%}%>
                            </select> 
                            <label for="idA">Arbitre<span class="requis">*</span></label>

                            <select name="idA" class='input-line full-width'>
                                <% for (Arbitre a : listeA){%>
                                <option value="<%=a.getId()%>"><%=a.getNom()%> <%=a.getPrenom()%></option>
                                <%}%>
                            </select>

                            <label for="dateH">Date du match<span class="requis"></span></label> 
                            <input type="datetime-local" name="date" class ="input-line full-width" value="" size="20" maxlength="20"/>

                            <input type ="hidden" name="action" value="CreerM">
                            </div>

                            <div><button class='ghost-round full-width'>Valider</button></div>
                        </form>

                    </div>
                </div>
            </div>   

    </body>
</html>
