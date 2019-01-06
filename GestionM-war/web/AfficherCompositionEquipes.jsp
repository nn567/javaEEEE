<%@page import="Entites.HistoriqueJEquipe"%>
<%@page import="Entites.Equipe"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:useBean id="listeEquipe" scope="request" class = "java.util.List"></jsp:useBean>
        <jsp:useBean id="listeHistorique" scope="request" class = "java.util.List"></jsp:useBean>
            <link href="newcss1.css" rel="stylesheet" type="text/css">
            <title>JSP Page</title>
        </head>
        <body>
            <div class='bold-line'></div>
            <div class='container' >
                <div class='window' style='width : 100% !important'>
                    <div class='content'>
                        <div class='welcome'>Composition des équipes</div>
                    </div>
                    <div class='content'>
                    <%
                        List<Equipe> listeE = listeEquipe;
                        List<HistoriqueJEquipe> listeH = listeHistorique;
                        String attribut = (String) request.getAttribute("message");
                        if(listeE.isEmpty()){
                            out.println("<center>"+attribut+"</center>");
                        }
                        else{
                    %>
                        <table>
                            <tr>
                                <th>
                                    Equipe
                                </th>
                                <th>
                                    Joueurs
                                </th>
                            </tr>
                            <% 
                                for (Equipe e : listeE) { %>
                            <tr>
                                <td>
                                    <%=e.getNomE()%>
                                </td>
                                <td>
                                    <%for(HistoriqueJEquipe h : listeH){
                                        if(h.getEquipe().getId()==e.getId()){//Problème respect MVC ???
                                           out.println(h.getJoueur().getNom()+" "+h.getJoueur().getPrenom()+"</br>");
                                        }
                                    }
                                    %>
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
