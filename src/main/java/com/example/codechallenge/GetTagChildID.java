package com.example.codechallenge;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(name = "/GetTagChildID")
public class GetTagChildID extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/Html");
        PrintWriter out = response.getWriter();
        String TagID = request.getParameter("TagID");
        out.print("<h1>Display Record</h1>");
        out.print("<Table><tr><th>ID</th><th>name</th><th>groupid</th></tr>");

        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection( "jdbc:mysql://localhost:3306/thewealt_wealthmarketdb?characterEncoding=latin1","root","Favour2021");
            Statement stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery("Select t.*\n" +
                    "From tags AS t\n" +
                    "Join TagClosureTable AS c  on  t.id = c.descendant\n" +
                    "Where c.ancestor = "+TagID+" ");
            while(rs.next())
            {
                out.print("<tr><td>");
                out.println(rs.getInt(1));
                out.print("</td>");
                out.print("<td>");
                out.print(rs.getString(2));
                out.print("</td>");
                out.print("<td>");
                out.print(rs.getInt(3));
                out.print("</td>");
                out.print("</tr>");
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        out.print("</table>");


    }
}


