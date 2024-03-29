package com.example.codechallenge;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "/TagAnObject")
public class TagAnObject extends HttpServlet {


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String OID = request.getParameter("ObjectID");
        String TID = request.getParameter("TagID");

        int ObjectID = Integer.parseInt(OID);
        int TagID = Integer.parseInt(TID);

        try {
            TagManager.TagAnObject(ObjectID, TagID , "user");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }
}
