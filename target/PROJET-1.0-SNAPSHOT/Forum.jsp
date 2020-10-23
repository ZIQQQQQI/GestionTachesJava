<%@ page import="DonneeDataBase.MessageDB" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>
<%@ page import="CompteDataBase.IntervenantDB" %><%--
  Created by IntelliJ IDEA.
  User: woshi
  Date: 2020/10/22
  Time: 14:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>communiquer tache en cours</title>
    <link rel="stylesheet" href="Style.css"/>
</head>

<body>
<%
    String mail=(String)session.getAttribute("mail");
    IntervenantDB dbi=new IntervenantDB();
    Integer nosiret= dbi.unIntervenant(mail).getIdI();
    String idLT=request.getParameter("id");


%>
<div id="gauche">
    <ul>
        <li ><a href="/PROJET_war/ProfilInt.jsp">Mon Profil</a></li>
        <li ><a href="/PROJET_war/AccueilInter.jsp">Mes tâches</a></li>
    </ul>
</div>

<div id="centre">
    <H1> Tâche en cours </H1>

    <form action="/PROJET_war/ServletMessageEnvoInter" method="get" >

			   <textarea id="message" name="MessageEnvoyer" rows="4" cols="40">

			   </textarea>

        <input type="hidden" name="nosiret" value="<%out.print(nosiret);%>">
        <input type="hidden" name="idLT" value="<%out.print(idLT);%>">
        <br/><input type="submit" value="envoyer"/>

    </form >

    <table border="1">
        <tr>
            <th>Message</th>
            <th>Date</th>
            <th>Nom</th>
        </tr>

        <%
            String id= request.getParameter("id");
            MessageDB db=new MessageDB();
            List<Map<String,Object>> list=db.tousMsg(id);
            for (Map<String,Object> m:list
                 ) {
                out.print("<td>"+m.get("contenuemsg")+"</td>");
                out.print("<td>"+m.get("dateMsg")+"</td>");
                out.print("<td>"+m.get("Nom")+"</td></tr>");
            }
        %>




    </table>

</div>


</body>
</html>