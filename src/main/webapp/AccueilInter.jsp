<%@ page import="TacheDataBase.TacheInterDB" %>
<%@ page import="Tache.LigneTache" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="CompteDataBase.IntervenantDB" %>
<%@ page import="Compte.Intervenant" %><%--
  Created by IntelliJ IDEA.
  User: woshi
  Date: 2020/10/22
  Time: 8:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Accueil Intervenant</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="Style.css"/>
</head>
<body>

<H1> Ma plateforme </H1>

<div id="gauche">
    <ul>
        <li ><a href="/PROJET_war/ProfilInt.jsp">Mon Profil</a></li>
        <li ><a>Mes tâches</a></li>
    </ul>
</div>
<div id="centre">
    <%
        IntervenantDB db=new IntervenantDB();
        Intervenant lui=db.unIntervenant((String)session.getAttribute("mail"));
        out.print("<h2>Hello! " +lui.getMailI()+"</h2>");
    %>
    <div> <p> Les tâches qui vous sont proposées:</p>

        <%
            String mail=(String)session.getAttribute("mail");
            TacheInterDB tacheinterdb=new TacheInterDB();
            ArrayList<LigneTache> listP =  tacheinterdb.getLigneTachePro(mail);
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
                for (LigneTache lt:listP){

                    out.println("<tr><td>"+lt.getIdLT()+"</td>");
                    out.println("<td>"+lt.getLibLT()+"</td>");
                    out.println("<td>"+lt.getCompetence().getNomComp()+"</td>");
                    out.println("<td>"+lt.getPrixLT()+"</td>");
                    out.println("<td>"+lt.getEtatLT()+"</td>");
                    out.println("<td><a href='UnTache.jsp?id="+lt.getIdLT()+"'>Consulter</a></td></tr>");
                }
            %>
        </table>


    </div>
    <div> <p> Les tâches que vous avez déjà acceptée:</p>
        <%

            ArrayList<LigneTache> listA =  tacheinterdb.getLigneTacheAcp(mail);
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
                for (LigneTache lt:listA){

                    out.println("<tr><td>"+lt.getIdLT()+"</td>");
                    out.println("<td>"+lt.getLibLT()+"</td>");
                    out.println("<td>"+lt.getCompetence().getNomComp()+"</td>");
                    out.println("<td>"+lt.getPrixLT()+"</td>");
                    out.println("<td>"+lt.getEtatLT()+"</td>");
                    out.println("<td><a href='TacheAccept.jsp?id="+lt.getIdLT()+"'>Consulter</a></td></tr>");
                }
            %>
        </table>
    </div>

</div>


</body>
</html>