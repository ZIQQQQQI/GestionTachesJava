package servlet;

import Compte.Client;
import CompteDataBase.ClientDB;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/LoginClientServlet") //  Cela permet de récupérer les informations d'un formmulaire
// Cette classe est similaire à celle de l'intervenant donc par souci de temps, nous en avons développé seulement une
public class LoginClientServlet extends HttpServlet {
    @Override
    // Méthode permettant de récupérer toutes les données du formulaire connexion
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String email=req.getParameter("username");
        String password=req.getParameter("password");

        Client loginclient = new Client();
        loginclient.setMail(email);
        loginclient.setMdp(password);

        ClientDB clientDB =new ClientDB();
        Client client=clientDB.login(loginclient);

        if(client==null){
            // Si le client n'existe pas alors
            resp.getWriter().write("Echec de la connexion");
            resp.addHeader ("refresh", "3;URL=/PROJET_war/login.html");


        }else{
            resp.addHeader ("refresh", "3;URL=/PROJET_war/index.jsp");

        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}
