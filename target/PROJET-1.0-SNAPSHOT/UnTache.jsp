<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>
<%@ page import="TacheDataBase.TacheInterDB" %>
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
    <h1>Les Infos</h1>
    <table >
    <%
        TacheInterDB dbi=new TacheInterDB();
        String id= request.getParameter("id");


        List<Map<String,Object>> list=dbi.unTache(id);
        for (Map<String,Object> m:list
        ) {
            out.println("<tr><td>NomClient:"+m.get("NomC")+"</td></tr>");
            out.println("<tr><td>PrenomClient:"+m.get("PrenomC")+"</td></tr>");
            out.println("<tr><td>LibelleLigneTache:"+m.get("liblLt")+"</td></tr>");
            out.println("<tr><td>Prix:"+m.get("PrixLT")+"</td></tr>");
            out.println("<tr><td>NombrePersonne:"+m.get("NbPersLT")+"</td></tr>");
            out.println("<tr><td>Duree:"+m.get("DureeT")+" Jours</td></tr>");
            out.println("<tr><td>DescriptionTahce:"+m.get("DescriptionT")+"</td></tr>");
            out.println("<tr><td>NoteCommunication:"+m.get("noteC")+"</td></tr>");
            out.println("<tr><td>NoteRentablite:"+m.get("noteR")+"</td></tr>");

        }

    %>
    </table>

</div>

<form name='form1' action = '/PROJET_war/ServletAccpterTache' method = 'get' id="form1">
    <input name="action" type="hidden" value="oui">
    <input name="id" type="hidden" value=<%out.print(id);%>>
    <input class="btn" type="submit" value="Accepter">
</form>
<form name = "form1" action = '/PROJET_war/ServletAccpterTache' method = "get" id="form2">
    <input name="action" type="hidden" value="non">
    <input name="id" type="hidden" value=<%out.print(id);%>>
    <input class="btn" type="submit" value="Refuser">
</form>


</body>
</html>



