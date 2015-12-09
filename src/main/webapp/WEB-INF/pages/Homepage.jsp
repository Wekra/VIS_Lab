<%--
  Created by IntelliJ IDEA.
  User: Christian
  Date: 25.11.2015
  Time: 16:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <META http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>The MILKROAD - Willkommen</title>
    <link href="${pageContext.request.contextPath}../../css/webshop.css" rel="stylesheet" type="text/css">
    <link href="http://s3.amazonaws.com/codecademy-content/courses/ltp/css/shift.css" rel="stylesheet">
</head>

<body>
<div class="container">
        <h1>Welcome to the MILKROAD</h1>
        <h2>Hier finden Sie unseren VIS-Webshop.</h2>
        <p> </p>
        <h3>Sollten Sie unseren Shop betreten wollen, <a href="<s:url action="Login_input"/>">loggen</a> Sie sich
            bitte ein oder <a href="<s:url action="Signup_input"/>">registrieren</a> Sie sich.</h3>
        <p>This is the milkiest webshop you'll find on the interwebz. </p>
</div>

<div class="contact">
    <hr />
    <s:text name="contact" />
</div>

</body>
</html>
