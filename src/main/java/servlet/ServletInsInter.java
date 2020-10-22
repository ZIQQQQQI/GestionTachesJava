package servlet;

import Compte.Intervenant;
import CompteDataBase.IntervenantDB;
import DonneeDataBase.CompetenceDB;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ServletInsInter")
public class ServletInsInter extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String nom=request.getParameter("nom");
        String prenom=request.getParameter("Prenom");
        Integer siret= Integer.parseInt(request.getParameter("noSiret"));
        String adresse=request.getParameter("adresse");
        String debut=request.getParameter("DateDebut");
        String fin=request.getParameter("DateFin");
        String mail=request.getParameter("mail");
        String mdp=request.getParameter("password");
        Integer idc=Integer.parseInt(request.getParameter("compInf"));
        String proffesopn=request.getParameter("profession");
        Integer iban=Integer.parseInt(request.getParameter("iban"));
        Integer bic=Integer.parseInt(request.getParameter("bic"));
        Intervenant in=new Intervenant(siret,adresse,mail,iban,bic,mdp,debut,fin);
        in.entrepreise(nom,debut,fin,proffesopn);
        IntervenantDB db=new IntervenantDB();
        db.addIntervenant(in);



        Intervenant newIntervenant = db.newIntevenant();
        Integer idI=newIntervenant.getIdI();
        CompetenceDB dbc=new CompetenceDB();
        dbc.ajouterCompetenceIntervenant(idc,idI);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
