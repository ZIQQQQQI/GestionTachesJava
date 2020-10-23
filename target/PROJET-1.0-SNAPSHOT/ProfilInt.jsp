<%@ page import="Compte.Intervenant" %>
<%@ page import="CompteDataBase.IntervenantDB" %>
<%@ page import="DonneeDataBase.CompetenceDB" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="Donnee.Competence" %><%--
  Created by IntelliJ IDEA.
  User: woshi
  Date: 2020/10/21
  Time: 16:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Mon Profil</title>
    <link rel="stylesheet" href="Style.css"/>
</head>
<body>

<H1> Ma plateforme </H1>

<div id="gauche">
    <ul>
        <li ><a >Mon Profil</a></li>
        <li ><a href="/PROJET_war/AccueilInter.jsp">Mes tâches</a></li>
    </ul>
</div>

<div>
    <p> Mes informations Personnelles</p>
</div>
<form action="/PROJET_war/ServletUpdateInter" method="post">

    <%
    IntervenantDB db=new IntervenantDB();
    Intervenant lui=db.unIntervenant((String)session.getAttribute("mail"));
    out.print("<h3>Hello! " +lui.getMailI()+"</h3>");
    out.print("<input type=hidden value="+lui.getMailI()+ " name=email><br/>");
    out.print("Nom:<input type=text value="+lui.getNom() +" name=raison><br/>");
    out.print("Nosiret:<input type=text value="+lui.getIdI()+ " name=noSiret><br/>");
    out.print("Adresse:<input type=text value=' "+lui.getAdresseI()+ " ' name=adresse><br/>");
    out.print("Disponibilite date debut:<input type=text value="+lui.getDateDebut()+ " name=DateDebut><br/>");
    out.print("Disponibilite date fin:<input type=text value="+lui.getDateFin()+ " name=DateFin><br/>");
    out.print("Mot de passe:<input type=text value="+lui.getMdpI()+ " name=password><br/>");
    out.print("Profession:<input type=text value="+lui.getProfession()+ " name=profession><br/>");
    out.print("Iban:<input type=text value="+lui.getIbanI()+ " name=iban><br/>");
    out.print("Bic:<input type=text value="+lui.getBicI()+ " name=bic><br/>");
    %>
    <br/>
    <select name="compInf" id="compInf" multiple>
        <option value="">Selectionner des compétences</option>
        <%
            CompetenceDB dbc=new CompetenceDB();
            ArrayList<Competence> list=dbc.tousCom();
            Competence possed=dbc.competenceInter(lui);
            Integer id=possed.getIdC();
            for (Competence c:list
                 ) {
                out.print("<option value="+c.getIdC()+">"+c.getNomComp()+"</option>");
            }

        %>
    </select>

    <br/>
    <input class="btnIns" type="submit" value="Modifier">

</form>
</body>

</html>
