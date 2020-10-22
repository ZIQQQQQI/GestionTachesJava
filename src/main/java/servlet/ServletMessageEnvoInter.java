package servlet;

import DonneeDataBase.CompetenceDB;
import DonneeDataBase.MessageDB;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ServletMessageEnvoInter")
public class ServletMessageEnvoInter extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String contenu=request.getParameter("MessageEnvoyer");
        String idlt=request.getParameter("idLT");
        String nosiret=request.getParameter("nosiret");
        MessageDB db=new MessageDB();
        db.envoyerMsgInter(contenu,nosiret,idlt);
        response.addHeader ("refresh", "0;URL=/PROJET_war/Forum.jsp?id="+idlt);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
