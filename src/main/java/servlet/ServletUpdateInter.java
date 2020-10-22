package servlet;

import Compte.Intervenant;
import CompteDataBase.IntervenantDB;
import Donnee.Competence;
import DonneeDataBase.CompetenceDB;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/ServletUpdateInter")
public class ServletUpdateInter extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String nom=request.getParameter("nom");
        Integer siret= Integer.parseInt(request.getParameter("noSiret"));
        String adresse=request.getParameter("adresse");
        String debut=request.getParameter("DateDebut");
        String fin=request.getParameter("DateFin");
        String mail=request.getParameter("email");
        String mdp=request.getParameter("password");
        Integer idc=Integer.parseInt(request.getParameter("compInf"));
        String proffesopn=request.getParameter("profession");
        Integer iban=Integer.parseInt(request.getParameter("iban"));
        Integer bic=Integer.parseInt(request.getParameter("bic"));
        Intervenant in=new Intervenant(siret,adresse,mail,iban,bic,mdp,debut,fin);
        in.entrepreise(nom,debut,fin,proffesopn);
        IntervenantDB up=new IntervenantDB();
        up.updateIntevenant(in);
        CompetenceDB dbc=new CompetenceDB();

        dbc.updateIne(idc,in.getIdI());
        HttpSession session = request.getSession(true);
        session.setAttribute("mail",mail);
        response.addHeader ("refresh", "3;URL=/PROJET_war/ProfilInt.jsp");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
