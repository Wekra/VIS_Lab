<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Christian
  Date: 25.11.2015
  Time: 16:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <title>The MILKROAD - Sign Up</title>
        <link href="${pageContext.request.contextPath}../../css/webshop.css" rel="stylesheet" type="text/css">
        <link href="http://s3.amazonaws.com/codecademy-content/courses/ltp/css/shift.css" rel="stylesheet">
        <s:head />
    </head>
    <body>
        <div class="container">
            <h1>Für The MILKROAD registrieren</h1>
            <h3>-mmmh milky</h3>
            <h3>Um sich zu registrieren geben Sie bitte folgende Daten über sich an:</h3>
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
                <s:submit key="registerButton"/>
            </s:form>
        </div>
        <div class="contact">
            <hr />
            <s:text name="contact" />
        </div>
    </body>
</html>
