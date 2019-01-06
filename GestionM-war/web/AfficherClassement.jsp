<%@page import="Entites.Equipe"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:useBean id="listeEquipe" scope="request" class = "java.util.List"></jsp:useBean>
            <link href="newcss1.css" rel="stylesheet" type="text/css">
            <title>JSP Page</title>
        </head>
        <body>
            <div class='bold-line'></div>
            <div class='container' >
                <div class='window' style='width : 100% !important'>
                    <div class='content'>
                        <div class='welcome'>Classement général</div>
                    </div>
                    <div class='content'>
                    <%
                        List<Equipe> listeE = listeEquipe;
                        String attribut = (String) request.getAttribute("message");
                        if(listeE.isEmpty()){
                            out.println("<center>"+attribut+"</center>");
                        }
                        else{
                    %>
                        <table>
                            <tr>
                                <th>
                                    Classement
                                </th>
                                <th>
                                    Equipe
                                </th>
                                <th>
                                    Score
                                </th>
                            </tr>
                            <% 
                                int i=0;
                                int dernierscore = listeE.get(0).getPoints()+1;
                                for (Equipe e : listeE) {
                                    if(dernierscore>e.getPoints()){
                                        i++;
                                        dernierscore=e.getPoints();
                                    }%>
                            <tr>
                                <td>
                                    <%=i%>
                                </td>
                                <td>
                                    <%=e.getNomE()%>
                                </td>
                                <td>
                                    <%=e.getPoints()%>
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
