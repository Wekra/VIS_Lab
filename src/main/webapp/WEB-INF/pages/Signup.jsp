<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Christian
  Date: 25.11.2015
  Time: 16:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sign-up to MILKROAD</title>
    <link href="${pageContext.request.contextPath}../../css/webshop.css" rel="stylesheet" type="text/css">
    <!--link href="http://s3.amazonaws.com/codecademy-content/courses/ltp/css/shift.css" rel="stylesheet">
    <link rel="stylesheet" href="http://s3.amazonaws.com/codecademy-content/courses/ltp/css/bootstrap.css"-->
    <s:head />
</head>
<body>
    <h2>Sign up to MILKROAD</h2>
    <p>-mmmh milky</p>
    <p>Please provide the following details about yourself.</p>
    <s:form action="SignupSubmit">
        <s:textfield key="firstname" name="userBean.firstname"/>
        <s:textfield key="lastname" name="userBean.lastname"/>
        <s:textfield key="email" name="userBean.email"/>
        <s:textfield key="street" name="userBean.street" />
        <s:textfield key="number" name="userBean.number" />
        <s:textfield key="zip" name="userBean.zip" />
        <s:textfield key="city" name="userBean.city" />
        <s:textfield key="country" name="userBean.country" />
        <s:password key="password" name="userBean.password" />
        <s:submit/>
    </s:form>
    <hr />
    <s:text name="contact" />
</body>
</html>
