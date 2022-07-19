package com.example.codechallenge;

import com.example.codechallenge.TagManager;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "CreateTag", value = "/CreateTag")
public class CreateTag extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            TagManager.CreateNewTag(request.getParameter("TagName"));
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }


    }


}


