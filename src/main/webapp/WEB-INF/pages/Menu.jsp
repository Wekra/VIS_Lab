<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
    <title>MILKROAD</title>
    <link href="${pageContext.request.contextPath}../../css/webshop.css" rel="stylesheet" type="text/css">
    <link href="http://s3.amazonaws.com/codecademy-content/courses/ltp/css/shift.css" rel="stylesheet">
</head>
<body>

<div class="container">
    <h3>Shop-stub</h3>
    <p>Some paragraph.</p>
    <s:iterator value="productList">
        <tr>
            <td><s:property value="label"/></td>
            <p>Preis: </p><td><s:property value="price"/></td>
        </tr>
    </s:iterator>
</div>

<div class="contact">
    <hr />
    <s:text name="contact" />
</div>

<s:iterator value="productList">
    <tr>
        <td><s:property value="label"/></td>
        <p>Preis: </p><td><s:property value="price"/></td>
    </tr>
</s:iterator>

</body>
</html>