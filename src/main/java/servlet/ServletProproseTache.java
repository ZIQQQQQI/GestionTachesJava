package servlet;

import Donnee.Competence;
import Tache.Tache;
import Tache.LigneTache;
import TacheDataBase.ProposerTacheDB;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/ServletProproseTache")
public class ServletProproseTache extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("utf-8");
        String nomtache=req.getParameter("nom");
        String description=req.getParameter("story");
        Integer duree=Integer.valueOf(req.getParameter("duree"));

        Tache t =new Tache(null,description,null,nomtache,duree);

        ProposerTacheDB pdb=new ProposerTacheDB();
        pdb.ajouterTache(t);

        String[] idC= req.getParameterValues("Competence");
        System.out.println(idC.length);
        String[] prix=req.getParameterValues("prix");
        System.out.println(prix.length);
        String[] nbpersonne=req.getParameterValues("NbPersonne");
        System.out.println(nbpersonne.length);
        String[] libllt=req.getParameterValues("LiblLT");
        System.out.println(libllt.length);

        ArrayList<LigneTache> listLT =new ArrayList<>();
        for (int i=0;i<idC.length;i++){
            Competence c= new Competence();
            c.setIdC(Integer.valueOf(idC[i]));
            LigneTache lt=new LigneTache(c,null,t,libllt[i],Double.valueOf(prix[i]),null,Integer.valueOf(nbpersonne[i]));
            listLT.add(lt);
        }


        pdb.ajouterligneTache(listLT);

        resp.getWriter().write("<h1>Bravo Reussi!</h1>");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}
