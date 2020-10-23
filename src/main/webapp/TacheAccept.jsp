<%@ page import="TacheDataBase.TacheInterDB" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: woshi
  Date: 2020/10/22
  Time: 14:47
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
<p> Information sur ma tâche</p>
<div id="tache">
    <h1>Les Infos</h1>
    <table >
        <%
            TacheInterDB dbi=new TacheInterDB();
            String id= request.getParameter("id");


            List<Map<String,Object>> list=dbi.unTache(id);
            String etat=null;
            for (Map<String,Object> m:list
            ) {
                out.println("<tr><td>Nom Client:"+m.get("NomC")+"</td></tr>");
                out.println("<tr><td>Prenom Client:"+m.get("PrenomC")+"</td></tr>");
                out.println("<tr><td>Libelle LigneTache:"+m.get("liblLt")+"</td></tr>");
                out.println("<tr><td>Prix:"+m.get("PrixLT")+"</td></tr>");
                out.println("<tr><td>Nombre Personne:"+m.get("NbPersLT")+"</td></tr>");
                out.println("<tr><td>Duree:"+m.get("DureeT")+" Jours</td></tr>");
                out.println("<tr><td>Description Tache:"+m.get("DescriptionT")+"</td></tr>");
                out.println("<tr><td>Note Communication:"+m.get("noteC")+"</td></tr>");
                out.println("<tr><td>Note Rentablite:"+m.get("noteR")+"</td></tr>");
                 etat=(String)m.get("etat");
            }

        %>
    </table>
</div>
<div >
    <p>Souhaitez vous communiquer avec le Client ou le Service Réclamation? </p>
    <%
        if(etat.equals("terminee")){
            out.print( "<a href=####><input class='btnEchanger' type='button' value='Client'></a>");
        }else{
            out.print( "<a href='/PROJET_war/Forum.jsp?id="+id+"'><input class='btnEchanger' type='button' value='Client'></a>");
        }
    %>



</div>
<div id="Fin">
</div>
<br/>
<div>
    <label for="rendre">Rendre un document:</label>
    <br/>

    <%
        if(etat.equals("terminee")){
            out.print("<a href=###><input class='btn' type='button' value= 'deja Rendu'></a>");
        }else{
            out.print("<input type='file' id='rendre' name='rendre'>");
            out.print( "<a href='/PROJET_war/NoteCli.jsp?id="+id+"'><input class='btn' type='button' value='Rendre'></a>");
        }
    %>

</div>


</body>
</html>
