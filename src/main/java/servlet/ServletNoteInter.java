package servlet;

import TacheDataBase.TacheInterDB;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ServletNoteInter")
public class ServletNoteInter extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String idc=request.getParameter("idc");
        String nosiret=request.getParameter("nosiret");
        String noteR=request.getParameter("rentabilite");
        String noteC=request.getParameter("communication");
        TacheInterDB db=new TacheInterDB();
        db.noteClient(idc,nosiret,noteR,noteC);
        response.addHeader ("refresh", "1;URL=/PROJET_war/AccueilInter.jsp");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
