package com.example.codechallenge;



import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "/ViewTagRelation")
public class ViewTagRelation extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            response.setContentType("text/html");

            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/thewealt_wealthmarketdb?characterEncoding=latin1", "root", "Favour2021");
            PreparedStatement Ancestors = null;
            PreparedStatement Descendants = null;
            String TagID = request.getParameter("TagID");

            String Ancestor =
                    "select t.*\n" +
                            "From tags AS t\n" +
                            "Join TagClosureTable AS c  on  t.id = c.Ancestor\n" +
                            "where Descendant = 847;";
            String Descendant =
                    "select t.*\n" +
                            "From tags AS t\n" +
                            "Join TagClosureTable AS c  on  t.id = c.Descendant\n" +
                            "where Ancestor = 846";

            Ancestors = con.prepareStatement(Ancestor);
            Descendants = con.prepareStatement(Descendant);

            ResultSet As = Ancestors.executeQuery();
            ResultSet Ds = Descendants.executeQuery();


            PrintWriter out = response.getWriter();
            out.println("<html>\n" +
                    "  <head>    \n" +
                    "    <link href=\"https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.css\" rel=\"stylesheet\" type=\"text/css\"/>\n" +
                    "  </head>");


                while (As.next()){


            out.print("<nav class=\"tree-nav\"><body>\n" +
                    "    <details class=\"tree-nav__item is-expandable\">\n" +
                    "      <summary class=\"tree-nav__item-title\">" + As.getString(2) + "</summary>\n");

            while (Ds.next()){

              out.print("<div class=\"tree-nav__item\">");
              out.print("<ul>");
              out.print("<li>");
              out.print(Ds.getString(2));
              out.print("</li>");
              out.print("</ul> </div>");}
              out.print("</details></nav></body></html>");}

              /*  out.println(As.getInt(1));
                out.print("</td>");
                out.print("<td>");
                out.print(As.getString(2 ));
                out.print("</td>");
                out.print("<td>");
                out.print(As.getInt(3));
                out.print("</td>");
                out.print("</tr>");
                out.print("</table>");*/

        }catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        }
    }
}











