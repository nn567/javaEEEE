<%-- 
    Document   : AutFed
    Created on : 27 nov. 2018, 15:17:28
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
        <h1>Authentification</h1>
        <form method ="get" action="gestionF">

              
                <label for="mdp">Mot de passe<span class="requis">*</span></label> 
                <input type ="text" name="mdp" value="" size="20" maxlength="20"/>
                <input type ="hidden" name="action" value="authenF">

            <input type="submit" value="Valider"/>
            <input type="reset" value="Remettre à 0"/>               
        </form>
    </body>
</html>
