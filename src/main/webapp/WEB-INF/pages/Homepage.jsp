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
    <title>Welcome to MILKROAD</title>
    <link href="${pageContext.request.contextPath}../../css/webshop.css" rel="stylesheet" type="text/css">
</head>

<body>
<h1>Welcome to MILKROAD</h1>
<h2>This is our webshop. It is the milkiest webshop you'll find on the interwebz. </h2>
<h3>It's very good.</h3>
<p>If you want to visit our shop, please <a href="<s:url action="Login_input"/>">Log-in</a> or <a href="<s:url action="Signup_input"/>">Sign-up</a>.</p>
<!--
<ul>
    <li><a href="<s:url action="Login_input"/>">Sign On</a></li>
    <li><a href="<s:url action="Register"/>">Register</a></li>
</ul>
-->
<hr />
<s:text name="contact" />
</body>
</html>
