package servlet;

import Compte.Intervenant;
import CompteDataBase.IntervenantDB;

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
        String proffesopn=request.getParameter("profession");
        Integer iban=Integer.parseInt(request.getParameter("iban"));
        Integer bic=Integer.parseInt(request.getParameter("bic"));
        Intervenant in=new Intervenant(1,adresse,mail,iban,bic,mdp,debut,fin);
        in.entrepreise(nom,debut,fin,proffesopn);
        IntervenantDB db=new IntervenantDB();
        db.addIntervenant(in);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
