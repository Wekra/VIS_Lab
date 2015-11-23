<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <META http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Basic Struts 2 Application - Welcome</title>
</head>

<body>
<h1>Welcome to Struts 2!</h1>
<p><a href="<s:url action='hello'/>">Hello World</a></p>
<!--Using struts 2 tags -->
<s:url action="hello" var="helloLink">
    <s:param name="userName">Bruce Phillips</s:param>
</s:url>
<p><a href="${helloLink}">Hello Bruce Phillips</a> </p>

<p>Get your own personal hello by filling out and submitting this form.</p>
<s:form action="hello">
    <s:textfield name="userName" label="Your Name" />
    <s:submit value="Submit" />
</s:form>

<s:url action="registerInput" var="registerInputLink" />
<p><a href="${registerInputLink}">Please register</a> for our prize drawing.</p>

<h3>Auf Deutsch registrieren</h3>
<s:url action="registerInput" var="registerInputLinkDE">
    <s:param name="request_locale">de</s:param>
</s:url>
<p><a href="${registerInputLinkDE}">Bitte registrieren Sie sich hier</a>, um an unserem Gewinnspiel teilzunehmen.</p>

<hr />
<s:text name="contact" />
</body>
</html>
