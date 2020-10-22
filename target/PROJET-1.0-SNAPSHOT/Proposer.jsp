<%@ page import="org.springframework.jdbc.core.JdbcTemplate" %>
<%@ page import="Utils.JDBCUtils" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: woshi
  Date: 2020/10/22
  Time: 23:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Formulaire proposition tache</title>
</head>

<body>
<H1>Proposer une tâche</H1>
<script type="text/Javascript" >


    function ajout(element){
        var formulaire = window.document.formulaireDynamique;
        // On clone le bouton d'ajout
        var ajout = element.cloneNode(true);
        // Crée un nouvel élément de type "input"

        // Les valeurs encodée dans le formulaire seront stockées dans un tableau



        var prix = document.createElement("input");
        // Les valeurs encodée dans le formulaire seront stockées dans un tableau
        prix.name = "prix";
        prix.type = "text";
        prix.required = true;
        var NbPersonne = document.createElement("input");
        // Les valeurs encodée dans le formulaire seront stockées dans un tableau
        NbPersonne.name = "NbPersonne";
        NbPersonne.type = "text";
        NbPersonne.required = true;
        //Create array of options to be added
        var LiblLT = document.createElement("input");
        // Les valeurs encodée dans le formulaire seront stockées dans un tableau
        LiblLT.name = "LiblLT";
        LiblLT.type = "text";
        LiblLT.required = true;


        var array = ["python","Java","vb","uml","merise","up","bpmn","schema ea","integration","power_bi","racle","php","css","html","anglais", "espagnol"];

        var selectList = document.createElement("select");
        selectList.name = "Competence";
        for (var i = 0; i < array.length; i++) {
            var option = document.createElement("option");
            option.value = i+1;
            option.text = array[i];
            selectList.appendChild(option);
        }


        var sup = document.createElement("input");
        sup.value = "supprimer cette ligne";
        sup.type = "button";
        // Ajout de l'événement onclick
        sup.onclick = function onclick(event)
        {suppression(this);};

        // On crée un nouvel élément de type "p" et on insère le champ l'intérieur.
        var bloc = document.createElement("p");

        bloc.appendChild(selectList);
        bloc.appendChild(prix);
        bloc.appendChild(NbPersonne);
        bloc.appendChild(LiblLT);
        //bloc.appendChild(NbClient);

        //formulaire.insertBefore(ajout,element);
        formulaire.insertBefore(sup, element);
        formulaire.insertBefore(bloc, element);

    }

    function suppression(element){
        var formulaire = window.document.formulaireDynamique;

        // Supprime le bouton d'ajout
        //formulaire.removeChild(element.previousSibling);
        // Supprime le champ
        formulaire.removeChild(element.nextSibling);
        // Supprime le bouton de suppression
        formulaire.removeChild(element);
    }
</script>
<form name="formulaireDynamique" action="/PROJET_war/ServletProproseTache" method="get">

    <table><tr><td>
        <label for="nom">nom :</label>
    </td><td>
        <input type="text" id="nom" name="nom" required>
    </td><td>

				<textarea id="story" name="story"
                          rows="4" cols="20" >
				Description...
				</textarea></td></tr>
        <tr><td>
            <label for="Competence">Compétences :</label>
        </td><td>
            <label for="Prix">Prix :</label></td>
            <td>
                <label for="NbPersonne">Nombre Personnes :</label></td><td>
                <label for="LiblLT">à faire :</label></td>
            <td></tr><tr><td>
            <select  name=Competence id="NomC">
                <%
                    JdbcTemplate template=new JdbcTemplate(JDBCUtils.getDataSource());
                    String sql="select * from competence";
                    List<Map<String,Object>> list=template.queryForList(sql);

                    for(Map<String,Object> m:list){
                        out.println("<option value="+(Integer)m.get("IdC")+">"+(String)m.get("NomC")+"</option>");
                    }
                %>


            </select>

        </td><td>



            <input type="text" id="prix" name=prix required>

        </td><td>

            <input type="text" id="NbP" name="NbPersonne" required>
        </td><td>

            <input type="text" id="LiblLT" name=LiblLT required>
        </td></tr></table>

    <input type="button" onclick="ajout(this);" value="ajouter une ligne de tache"/>
    <br /><br />
    <table><tr><td>
        <label for="duree">duree :</label>
    </td><td>
        <input type="text" id="duree" name="duree" required>
    </td></tr></table>
    <input type="submit" value="soumettre"/>
</form>

<input type=button onclick=window.location.href="pageAccueilClient.html"; value=Annuler />

</body>
</html>
