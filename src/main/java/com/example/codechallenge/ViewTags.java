package com.example.codechallenge;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(name = "/ViewTags")
public class ViewTags extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            response.setContentType("text/html");
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/thewealt_wealthmarketdb?characterEncoding=latin1", "root", "Favour2021");
            PreparedStatement stmt = con.prepareStatement("SELECT *FROM tags");
            ResultSet rs = stmt.executeQuery();
            PrintWriter out = response.getWriter();
            out.println("<Table><tr><td>ID</td><td>name</td><td>tag_group_id</td><td>edit</td><td>delete</td></tr>");
            while (rs.next()) {
                out.print("<tr><td>");
                out.println(rs.getInt(1));
                out.print("</td>");
                out.print("<td>");
                out.print(rs.getString(2));
                out.print("</td>");
                out.print("<td>");
                out.print(rs.getInt(3));
                out.print("</td>");
                out.print("<td>"  + "<a href='EditTag?id=" +  rs.getString("id")  + "'> Edit </a>" + "</td>");
                out.println("<td>"  + "<a href='DeleteTag?id=" +  rs.getString("id")  + "'> Delete </a>" + "</td>");
                out.print("</tr>");
            }
            out.print("</table>");


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
