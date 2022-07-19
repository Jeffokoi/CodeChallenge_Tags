<%--
  Created by IntelliJ IDEA.
  User: JEFF
  Date: 30/06/2022
  Time: 01:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>TagANObject</title>
</head>
<body>
<form action="./TagAnObject" method="post">
    <table width="400px" border="1">
        <tr>
            <td><h1>Tag a User</h1></td>
        </tr>
        <tr>
            <td>Enter Tag Id </td>
            <td><input type="text" name="TagID"></td>
        </tr>
        <tr>
            <td>Enter user Id </td>
            <td><input type="text" name="ObjectID"></td>
        </tr>

        <tr>
            <td><input type="submit"></td>
        </tr>


    </table>

</form>
</body>
</html>
