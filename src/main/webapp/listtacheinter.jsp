<%@ page import="TacheDataBase.TacheInterDB" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="Tache.LigneTache" %><%--
  Created by IntelliJ IDEA.
  User: silu
  Date: 22/10/2020
  Time: 06:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Liste tache Intervenant</title>
</head>
<body>
<h1>Liste de Tâche</h1>
<%
    TacheInterDB tacheinterdb=new TacheInterDB();
    ArrayList<LigneTache> list =  tacheinterdb.getLigneTache("shaimaa@yahoo.fr");
%>

<table border="1">
    <tr>
        <td>Code Ligne Tache</td>
        <td>Liblle </td>
        <td>Competence</td>
        <td>Prix</td>
        <td>Etat</td>
        <td>Operation</td>
    </tr>

    <%
        for (LigneTache lt:list){

            out.println("<tr><td>"+lt.getIdLT()+"</td>");
            out.println("<td>"+lt.getLibLT()+"</td>");
            out.println("<td>"+lt.getCompetence().getNomComp()+"</td>");
            out.println("<td>"+lt.getPrixLT()+"</td>");
            out.println("<td>"+lt.getEtatLT()+"</td>");
            out.println("<td><a href=''>Consulter</a></td></tr>");
        }
    %>
</table>

</body>
</html>
