<%-- 
    Document   : CreerM
    Created on : 27 nov. 2018, 16:14:20
    Author     : anastasia.salari
--%>
<%@page import="java.util.List"%>
<%@page import="Entites.Equipe"%>
<%@page import="Entites.Arbitre"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:useBean id="listeEquipes" scope="request" class = "java.util.List"> </jsp:useBean>
         <jsp:useBean id="listeArbitres" scope="request" class = "java.util.List"> </jsp:useBean>
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
         <% List<Equipe> listeE = listeEquipes;%>
           <% List<Arbitre> listeA = listeArbitres;%>
        <form method ="get" action="gestionF">
                
              <label for="nomE1">Equipe 1<span class="requis">*</span></label>
              <select name="nomE1">
                   <% for (Equipe e : listeE ){%>
                   <option value="<%=e.getNomE()%>"><%=e.getNomE()%> </option>
                   <%}%>
               </select> 
               <br>
               <label for="nomE2">Equipe 1<span class="requis">*</span></label>
               <select name="nomE2">
                   <% for (Equipe e : listeE ){%>
                   <option value="<%=e.getNomE()%>"><%=e.getNomE()%> </option>
                   <%}%>
               </select> 
               <br>
               <label for="nomA">Equipe 1<span class="requis">*</span></label>
               <select name="idA">
                   <% for (Arbitre a : listeA){%>
                   <option value="<%=a.getId()%>"><%=a.getNom()%> <%=a.getPrenom()%></option>
                   <%}%>
               </select> 
               <br>
                <label for="dateH">Date du match<span class="requis">*</span></label> 
                <input type="date" name="date" value="" size="20" maxlength="20"/>
                 
                 <br>
                <input type ="hidden" name="action" value="CreerM">
        
            <input type="submit" value="Valider"/>
            <input type="reset" value="Remettre à 0"/>               
        </form>
    </body>
</html>
