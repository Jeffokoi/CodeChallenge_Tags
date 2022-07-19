package com.example.codechallenge;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(name = "/DeleteTag")
public class DeleteTag extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    int row;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/Html");
        PrintWriter out = response.getWriter();
        String id = request.getParameter("id");
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/thewealt_wealthmarketdb?characterEncoding=latin1", "root", "Favour2021");
            PreparedStatement stmt = con.prepareStatement("DELETE FROM tags where id =?");
            stmt.setString(1,id);
            row = stmt.executeUpdate();
            out.println("<font color='green> Record Deleted </font>");


        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
