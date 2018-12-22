<%@page import="Entites.Equipe"%>
<%@page import="Entites.FauteComise"%>
<%@page import="Entites.Joueur"%>
<%@page import="java.util.List"%>
<%@page import="Entites.Match1"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:useBean id="listeMatch" scope="request" class = "java.util.List"></jsp:useBean>
        <jsp:useBean id="listeEquipe" scope="request" class = "java.util.List"></jsp:useBean>
            <link href="newcss1.css" rel="stylesheet" type="text/css">
            <title>JSP Page</title>
        </head>
        <body>
            <div class='bold-line'></div>
            <div class='container' >
                <div class='window' style='width : 100% !important'>
                    <div class='content'>
                        <div class='welcome'>Rechercher les matchs d'une Equipe</div>
                        <div class='input-fields'>
                            <form  method ="get" action="gestionP">
                                <center>
                                    Sélectionner une équipe
                                    <select>
                                    <% List<Equipe> listeE = listeEquipe;
                                    for (Equipe e : listeE){
                                    %>
                                    <option name ="equipe" value="<%e.getNomE();%>"> <%e.getNomE();%> </option>
                                    <%}%>
                                    </select>
                                </center>
                                <input type ="hidden" name="action" value="afficherMatchEquipe">
                                <button class='ghost-round full-width'>Valider</button>
                            </form>
                        </div>
                    </div>
                    <div class='content'>
                    <%
                        List<Match1> listeM = listeMatch;
                        String attribut = (String) request.getAttribute("message");
                        if(listeMatch.isEmpty()){
                            out.println("<center>"+attribut+"</center>");
                        }
                        else{
                    %>
                        <table>
                            <tr>
                                <th>
                                    Date
                                </th>
                                <th>
                                    Arbitre
                                </th>
                                <th>
                                    Equipe 1
                                </th>
                                <th>
                                    Equipe 2
                                </th>
                                <th>
                                    Résultat
                                </th>
                                <th>
                                    Fautes
                                </th>
                            </tr>
                            <% for (Match1 m : listeM) {%>
                            <tr>
                                <td>
                                    <%out.println(m.getDate().getDay()+"/"+m.getDate().getMonth()+"/"+m.getDate().getYear()+"  à "+m.getHeureMinute());%>
                                </td>
                                <td>
                                    <%out.println(m.getArbitre().getNom());%> <%out.println(m.getArbitre().getPrenom());%>
                                </td>
                                <td>
                                    <%out.println(m.getEquipe1().getNomE());%></br></br>
                                    <% List<Joueur> listeJ = m.getCompoE1();
                                        for (Joueur j : listeJ) {
                                            out.println(j.getNom());%> <%out.println(j.getPrenom());%></br><%}%>
                                </td>
                                <td>
                                    <%out.println(m.getEquipe1().getNomE());%></br></br>
                                    <% List<Joueur> listeJJ = m.getCompoE2();
                                        for (Joueur j : listeJJ) {
                                            out.println(j.getNom());%> <%out.println(j.getPrenom());%></br><%}%>
                                </td>
                                <td>
                                    <%out.println(m.getButsE1());%> - <%out.println(m.getButsE2());%>
                                </td>
                                <td>
                                    <% List<FauteComise> listeF = m.getFautes();
                                        for (FauteComise f : listeF) {
                                            out.println("Carton " + f.getFaute() + " - " + f.getJoueur().getNom() + " " + f.getJoueur().getPrenom());%></br><%}%>
                                </td>
                            </tr>
                            <%}%>
                        </table>
                        <%}%>
                    </div>
                </div>
            </div>
    </body>
</html>
