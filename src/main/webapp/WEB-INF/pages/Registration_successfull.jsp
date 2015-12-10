<%--
  Created by IntelliJ IDEA.
  User: Christian
  Date: 30.11.2015
  Time: 15:13
  To change this template use File | Settings | File Templates.
--%>
<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
        <title>The MILKROAD - Success!</title>
        <link href="${pageContext.request.contextPath}../../css/webshop.css" rel="stylesheet" type="text/css">
        <link href="http://s3.amazonaws.com/codecademy-content/courses/ltp/css/shift.css" rel="stylesheet">
    </head>
    <body>
        <div class="container">
            <div class="content-container">
                <h1>Die Registrierung war erfolgreich!</h1>
                <h3>Sie haben Folgendes bei Ihrer Registration angegeben</h3>
                <p><s:property value="userBean" /> </p>

                <p>Um zum Hauptmenü zu gelangen, klicken Sie bitte <a href="<s:url action="Access_menu"/>">hier</a>. </p>
            </div>
        </div>
        <div class="contact">
            <hr />
            <s:text name="contact" />
        </div>
    </body>
</html>
