<%--
  Created by IntelliJ IDEA.
  User: JEFF
  Date: 30/06/2022
  Time: 04:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>EditTag</title>
</head>
<body>
<div>
    <form action="./EditTag">
        <table width="400px" border="1">
            <tr>
                <td><h1>Edit Tag</h1></td>
            </tr>
            <tr>
                <td>Enter Tag ID :</td>
                <td><input type="text" name="id"></td>
            </tr>
            <tr>
                <td>Enter Tag Name :</td>
                <td><input type="text" name="name"></td>
            </tr>
            <tr>
                <td><input type="submit" value="Update"></td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
