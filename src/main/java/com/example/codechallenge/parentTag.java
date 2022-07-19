package com.example.codechallenge;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "/parentTag")
public class parentTag extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String PID = request.getParameter("ParentTagID");
        String CID = request.getParameter("ChildTagID");

        int ParentTagID = Integer.parseInt(PID);
        int ChildTagID = Integer.parseInt(CID);

        try {
            TagManager.ParentATag(ParentTagID,ChildTagID);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
