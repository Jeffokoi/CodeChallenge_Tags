<%--
  Created by IntelliJ IDEA.
  User: JEFF
  Date: 21/06/2022
  Time: 11:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Sevletmanger.MwInsertData </title>
</head>
<body>
<form action="./MwInsertData" method="post">
    <p>id:</p>
    <input type="text" name="ID"/>
    <br/>
    <p>IssueDate:</p>
    <input type="text" name="IssueDate"/>
    <br/>
    <p>IssueTime</p>
    <input type="text" name="IssueTime"/>
    <br/>
    <p>Amount</p>
    <input type="text" name="Amount"/>
    <br/>
    <p>IndexHoldersName</p>
    <input type="text" name="IndexHoldersName"/>
    <br/>
    <p>IndexHoldersWMID</p>
    <input type="text" name="IndexHoldersWMID"/>
    <br/>
    <p>ReceivingAgent</p>
    <input type="text" name="ReceivingAgent"/>
    <br/>
    <p>DiscountProfile</p>
    <input type="text" name="DiscountProfile"/>
    <br/><br/><br/>
    <input type="submit"/>
</form>
</body>
</html>