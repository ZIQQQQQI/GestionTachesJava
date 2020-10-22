package servlet;

import TacheDataBase.TacheInterDB;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/ServletAccpterTache")
public class ServletAccpterTache extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String nom=request.getParameter("action");
        String id= request.getParameter("id");

        Boolean accepter=nom.equals("oui") ? true:false;;
        HttpSession session = request.getSession(true);
        String mail=(String) session.getAttribute("mail");
        TacheInterDB db=new TacheInterDB();
        db.accepterTache(mail,id,accepter);
        response.addHeader ("refresh", "1;URL=/PROJET_war/AccueilInter.jsp");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
