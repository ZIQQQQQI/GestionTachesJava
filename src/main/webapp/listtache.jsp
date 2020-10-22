<%@ page import="TacheDataBase.TacheClientDB" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="Tache.LigneTache" %>
<%@ page import="javax.print.attribute.standard.MediaSize" %>
<%@ page import="TacheDataBase.TacheClientDB" %><%--
  Created by IntelliJ IDEA.
  User: silu
  Date: 21/10/2020
  Time: 16:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Liste de Tache</title>
</head>
<body>
<h1>Liste de Tâche</h1>
<%
    TacheClientDB tachedb=new TacheClientDB();
    ArrayList<LigneTache> list=tachedb.getLigneTache("Samuel@yahoo.fr");
%>
<table>
    <tr>
        <td>Code Ligne Tache</td>
        <td>Liblle </td>
        <td>Prix</td>
        <td>Etat</td>
    </tr>

    <%
        for (LigneTache lt:list){

            out.println("<tr><td>"+lt.getIdLT()+"</td>");
            out.println("<td>"+lt.getLibLT()+"</td>");
            out.println("<td>"+lt.getPrixLT()+"</td>");
            out.println("<td>"+lt.getEtatLT()+"</td></tr>");
        }
    %>
</table>


</body>
</html>
