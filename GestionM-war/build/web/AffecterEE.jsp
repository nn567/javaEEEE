<%-- 
    Document   : AffecterEE
    Created on : 4 déc. 2018, 08:32:01
    Author     : anastasia.salari
--%>
<%@page import="java.util.List"%>
<%@page import="Entites.Equipe"%>
<%@page import="Entites.Entraineur"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link href="newcss1.css" rel="stylesheet" type="text/css">
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
          <jsp:useBean id="listeEquipes" scope="request" class = "java.util.List"> </jsp:useBean>
          <jsp:useBean id="listeEntraineurs" scope="request" class = "java.util.List"> </jsp:useBean>
        <title>JSP Page</title>
    </head>
    <body>

        <% List<Equipe> listeE = listeEquipes;%>
        <% List<Entraineur> listeEn = listeEntraineurs;%>

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
                           
                            <label for="idE">Entraineur<span class="requis">*</span></label>

                            <select name="idA" class='input-line full-width'>
                                <% for (Entraineur a : listeEn){%>
                                <option value="<%=a.getId()%>"><%=a.getNom()%> <%=a.getPrenom()%></option>
                                <%}%>
                            </select>

                           
                            <input type ="hidden" name="action" value="AffecterEE">
                            </div>

                            <div><button class='ghost-round full-width'>Valider</button></div>
                        </form>

                    </div>
                </div>
            </div>   

    </body>
</html>
