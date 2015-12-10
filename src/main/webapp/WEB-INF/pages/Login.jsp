<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
    <head>
        <title>Sign On</title>
        <link href="${pageContext.request.contextPath}../../css/webshop.css" rel="stylesheet" type="text/css">
        <link href="http://s3.amazonaws.com/codecademy-content/courses/ltp/css/shift.css" rel="stylesheet">
        <s:head />
    </head>
    <body>
        <div class="container">
            <div class="content-container">
                <h2>Bitte geben Sie ihre Login-Daten unten ein.</h2>
                <s:form action="LoginSubmit">
                    <s:textfield cssClass="myClass" key="email"/>
                    <s:password cssClass="myClass" key="password" />
                    <s:submit key="loginButton"/>
                </s:form>
            </div>
        </div>
        <div class="contact">
            <hr />
            <s:text name="contact" />
        </div>
    </body>
</html>
