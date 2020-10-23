<%--
  Created by IntelliJ IDEA.
  User: woshi
  Date: 2020/10/21
  Time: 20:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="Style.css"/>
</head>
<body id="bodyIns">


<h1>Se Connecter</h1>
<div id="centreIns">
    <form action="/PROJET_war/LoginIntervenantServlet" method="get" style="text-align: center" >
        Identifiant:<br/>
        <input type="text" name="username" placeholder="id"> <br>
        Mot de Passe:<br/>
        <input type="password" name="password" placeholder="mdp"><br>


        <input class= "btn" type="submit" value="Se connecter">

    </form>
</div>


</body>
</html>