<%--
  Created by IntelliJ IDEA.
  User: Christian
  Date: 21.11.2015
  Time: 19:00
  To change this template use File | Settings | File Templates.
--%>
<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
    <title>Registration Successful</title>
</head>
<body>

<h3>Thank you for registering for a prize.</h3>
<h3><s:text name="thankyou" /></h3>

<p>Your registration information: </p>
<p><s:property value="personBean" /> </p>

<p><a href="<s:url action='index' />" >Return to home page</a>.</p>

</body>
</html>

