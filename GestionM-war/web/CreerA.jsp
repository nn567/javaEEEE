<%-- 
    Document   : CreerA
    Created on : 27 nov. 2018, 16:02:43
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
        <h1>Saisir informations arbitre</h1>
        <form method ="get" action="gestionF">   
            <table>
                <tr>
                    <td>
                        <label for="nomA">Nom<span class="requis">*</span></label> 
                    </td>
                    <td>
                        <input type ="text" name="nomA" value="" size="20" maxlength="20"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label for="prenomA">Prénom<span class="requis">*</span></label> 
                    </td>
                    <td>
                        <input type ="text" name="prenomA" value="" size="20" maxlength="20"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label for="logA">Login<span class="requis">*</span></label> 
                    </td>
                    <td>
                        <input type ="text" name="logA" value="" size="20" maxlength="20"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label for="mdpA">Mot de passe<span class="requis">*</span></label> 
                    </td>
                    <td>
                        <input type ="password" name="mdpA" value="" size="20" maxlength="20"/>
                    </td>
                </tr>
            </table>
                <input type ="hidden" name="action" value="CreerA">
        
            <input type="submit" value="Valider"/>
            <input type="reset" value="Remettre à 0"/>               
        </form>
    </body>
</html>
