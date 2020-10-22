package servlet;

import Compte.Client;
import CompteDataBase.ClientDB;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/LoginClientServlet")
public class LoginClientServlet extends HttpServlet {
    @Override
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
