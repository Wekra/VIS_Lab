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
    <link href="http://s3.amazonaws.com/codecademy-content/courses/ltp/css/shift.css" rel="stylesheet">
    <s:head />
</head>
<body>
<div class="container">
    <h1>Sign up to MILKROAD</h1>
    <h3>-mmmh milky</h3>
    <h3>Please provide the following details about yourself.</h3>
    <s:form action="SignupSubmit">
        <s:textfield id="labelFirstname" key="firstname" name="userBean.firstname"/>
        <s:textfield id="labelLastname" key="lastname" name="userBean.lastname"/>
        <s:textfield id="labelEmail" key="email" name="userBean.email"/>
        <s:textfield id="labelStreet" key="street" name="userBean.street" />
        <s:textfield id="labelNumber" key="number" name="userBean.number" />
        <s:textfield id="labelZip" key="zip" name="userBean.zip" />
        <s:textfield id="labelCity" key="city" name="userBean.city" />
        <s:textfield id="labelCountry" key="country" name="userBean.country" />
        <s:password id="labelPassword" key="password" name="userBean.password" />
        <s:submit/>
    </s:form>
</div>

<div class="contact">
    <hr />
    <s:text name="contact" />
</div>

</body>
</html>
