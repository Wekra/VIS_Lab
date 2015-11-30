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
    <title>Registration successfull.</title>
</head>
<body>
<h3>Your registration was successfull.</h3>
<p>Your registration information: <s:property value="userBean" /> </p>

<p>To continue to the menu, please <a href="<s:url action="Access_menu"/>">click here</a>. </p>

</body>
</html>
