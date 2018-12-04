<%-- 
    Document   : CreerA
    Created on : 27 nov. 2018, 16:02:43
    Author     : anastasia.salari
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link href="newcss1.css" rel="stylesheet" type="text/css">
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div class='bold-line'></div>
        <div class='container'>
            <div class='window'>
                <div class='overlay'></div>
                <div class='content'>
                    <div class='welcome'>Saisir informations arbitre</div>
                    <div class='input-fields'>
                        <form  method ="get" action="gestionF">
                            <input type='text' placeholder='Nom' name ="nomA" class='input-line full-width'></input>
                            <input type='text' placeholder='Prénom' name ="prenomA" class='input-line full-width'></input>
                            <input type='text' placeholder='Nom' name ="logA" class='input-line full-width'></input>
                            <input type='text' placeholder='Nom' name ="mdpA" class='input-line full-width'></input>
                            <input type ="hidden" name="action" value="CreerA">
                            </div>

                            <div><button class='ghost-round full-width'>Valider</button></div>
                        </form>

                    </div>
                </div>
            </div>   

    </body>
</html>
