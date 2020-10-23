<%@ page import="TacheDataBase.TacheInterDB" %>
<%@ page import="Compte.Intervenant" %>
<%@ page import="CompteDataBase.IntervenantDB" %><%--
  Created by IntelliJ IDEA.
  User: woshi
  Date: 2020/10/22
  Time: 14:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Evaluation</title>
    <link rel="stylesheet" href="Style.css"/>
</head>
<body id="bodyIns">
<%
    String mail=(String)session.getAttribute("mail");
    TacheInterDB dbi=new TacheInterDB();
    String id= request.getParameter("id");
    dbi.terminerTache(id);
    Integer i=dbi.getidClient(id);
    IntervenantDB dbinc=new IntervenantDB();
    Integer nosiret=dbinc.unIntervenant(mail).getIdI();
%>

<H1> Evaluation du Client </H1>

<div id="gauche">
    <ul>
        <li ><a href="/PROJET_war/ProfilInt.jsp">Mon Profil</a></li>
        <li ><a href="/PROJET_war/AccueilInter.jsp">Mes tâches</a></li>
    </ul>
</div>

<p> Veuillez évaluer le client sur l'ensemble des critères ci-dessous</p>
<div id="centreIns">
    <p>Sur une échelle allant de 1 à 5, êtes vous satisfait ? </p>

    <form name='note' action = '/PROJET_war/ServletNoteInter' method ='get'>
        <table>
            <tr>
                <td>
                    <label for="name">Rentabilité:</label>
                </td>
                <td>
                    <input type="hidden" name="idc" value="<%out.print(i);%>">
                    <input type="hidden" name="nosiret" value="<%out.print(nosiret);%>">
                    <input type="number"  name="rentabilite"
                           min="1" max="5">
                </td>
            </tr>
            <tr>
                <td>
                    <label for="name">Qualité des échanges:</label>
                </td>
                <td>
                    <input type="number"  name="communication"
                           min="1" max="5">
                </td>
            </tr>
            <tr>
                <td>
                    <input class="btn" type="submit" value="Envoyer">
                </td>
            </tr>
        </table>

    </form>

</body>
</html>