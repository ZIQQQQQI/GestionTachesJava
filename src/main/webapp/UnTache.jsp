<%--
  Created by IntelliJ IDEA.
  User: woshi
  Date: 2020/10/22
  Time: 9:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Tache Proposée</title>
    <link rel="stylesheet" href="Style.css"/>
</head>
<body>

<H1> Ma plateforme </H1>

<div id="gauche">
    <ul>

        <li ><a href="/PROJET_war/ProfilInt.jsp">Mon Profil</a></li>
        <li ><a href="/PROJET_war/AccueilInter.jsp">Mes tâches</a></li>
    </ul>
</div>
<p> Information sur la tâche</p>
<div id="tache">
    <p>Les Infos</p>
</div>

<form name='form1' action = 'test' method = 'post' id="form1">
    <input name="action" type="hidden" value="oui">
    <input class="btn" type="submit" value="Accepter">
</form>
<form name = "form2" action = "test" method = "post" id="form2">
    <input name="action" type="hidden" value="non">
    <input class="btn" type="button" value="Refuser">
</form>


</body>
</html>



