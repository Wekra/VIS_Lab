<%--
  Created by IntelliJ IDEA.
  User: Christian
  Date: 21.11.2015
  Time: 18:48
  To change this template use File | Settings | File Templates.
--%>
<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
    <title>Register</title>
    <s:head />
</head>
<body>
<h3>Register for a prize by completing this form.</h3>

<s:form action="register">
    <s:textfield key="personBean.firstName" name="personBean.firstName" />
    <s:textfield key="personBean.lastName" name="personBean.lastName"/>
    <s:textfield key="personBean.email" name="personBean.email" />
    <s:textfield key="personBean.age" name="personBean.age" />
    <s:submit />
</s:form>

</body>
</html>

