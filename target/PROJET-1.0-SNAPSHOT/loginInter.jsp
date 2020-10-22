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
</head>
<body>
<h1 style="text-align: center">Se Connecter</h1>
<form action="/PROJET_war/LoginIntervenantServlet" method="get" style="text-align: center" >
    Identifiant:<input type="text" name="username"> <br>
    Mot de Passe:<input type="password" name="password"><br>

    <input type="submit" value="Se connecter">

</form>

</body>
</html>