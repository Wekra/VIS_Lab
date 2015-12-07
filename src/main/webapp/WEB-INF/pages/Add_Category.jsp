<%--
  Created by IntelliJ IDEA.
  User: Marcel
  Date: 07.12.2015
  Time: 16:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>Kategory hinzufügen</title>
</head>
<body>
<s:form action="Add_Category">
    <s:textfield label="label" name="categoryBean.label"/>
    <s:submit/>
</s:form>
</body>
</html>
