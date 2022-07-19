<%--
  Created by IntelliJ IDEA.
  User: JEFF
  Date: 28/06/2022
  Time: 06:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>TagManager</title>
</head>
<body>
<div>
    <form action="./CreateTag" method="post">
        <table width="400px" border="1">
            <tr>
                <td><h1>Create a Tag</h1></td>
            </tr>
            <tr>
                <td>TagName</td>
                <td><input type="text" name="TagName"></td>
            </tr>

            <tr>
                <td><input type="submit"></td>
            </tr>


        </table>

    </form>

</div>
<div>
    <form action ="./ViewTags" method="post">
        <input type="submit" value="Get All tags">
    </form>
    <form action ="./ViewAllUsers" method="post">
    <input type="submit" value="Get All Users">
    </form>
    <form action ="./ViewTagRelation" method="post">
        <input type="submit" value="View Tag Relation">
    </form>

</div>
<div>
    <form action="./ViewTagById">
        <table width="400px" border="1">
            <tr>
                <td><h1>Search for  a Tag</h1></td>
            </tr>
            <tr>
                <td>Enter Tag ID:</td>
                <td><input type="text" name="id"></td>
            </tr>
            <tr>
                <td><input type="submit" value="Search"></td>
            </tr>
        </table>
    </form>
</div>
<div>
    <form action="./DeleteTag">
        <table width="400px" border="1">
            <tr>
                <td><h1>Delete a Tag</h1></td>
            </tr>
            <tr>
                <td>Enter Tag ID :</td>
                <td><input type="text" name="id"></td>
            </tr>
            <tr>
                <td><input type="submit" value="Delete"></td>
            </tr>
        </table>
    </form>
</div>
<div>
    <form action="./parentTag">
        <table width="400px" border="1">
            <tr>
                <td><h1>Parent A Tag</h1></td>
            </tr>
            <tr>
                <td>Enter Parent Tag ID :</td>
                <td><input type="text" name="ParentTagID"></td>
            </tr>
            <tr>
                <td>Enter child Tag ID :</td>
                <td><input type="text" name="ChildTagID"></td>
            </tr>
            <tr>
                <td><input type="submit" value="submit"></td>
            </tr>

        </table>
    </form>
</div>
<div>
    <form action="./GetTagParentID">
        <table width="400px" border="1">
            <tr>
                <td><h1>Get Tag parent </h1></td>
            </tr>
            <tr>
                <td>Enter Child Tag ID :</td>
                <td><input type="text" name="TagID"></td>
            </tr>
            <tr>
                <td><input type="submit" value="submit"></td>
            </tr>
        </table>
    </form>
</div>
<div>
    <form action="./GetTagChildID">
        <table width="400px" border="1">
            <tr>
                <td><h1>GetTagChildID</h1></td>
            </tr>
            <tr>
                <td>Enter Tag ID :</td>
                <td><input type="text" name="TagID"></td>
            </tr>
            <tr>
                <td><input type="submit" value="submit"></td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
