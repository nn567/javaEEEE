<%-- 
    Document   : CreerE
    Created on : 4 déc. 2018, 09:25:00
    Author     : Guillaume
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
                    <div class='welcome'>Saisir informations entraineur</div>
                    <div class='input-fields'>
                        <form  method ="get" action="gestionF">
                            <input type='text' placeholder='Nom' name ="nomEnt" class='input-line full-width'></input>
                            <input type='text' placeholder='Prénom' name ="prenomEnt" class='input-line full-width'></input>
                            <input type='text' placeholder='Login' name ="logEnt" class='input-line full-width'></input>
                            <input type='text' placeholder='Mdp' name ="mdpEnt" class='input-line full-width'></input>
                            <input type ="hidden" name="action" value="CreerEnt">
                            </div>

                            <div><button class='ghost-round full-width'>Valider</button></div>
                        </form>

                    </div>
                </div>
            </div>   
    </body>
</html>
