<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Marcel
  Date: 30.11.2015
  Time: 16:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Produkt</title>
</head>
<body>
    <h2>Please fill in</h2>
    <s:form action="Add_product" enctype="multipart/form-data">
        <s:textfield label="label" name="productBean.label"/>
        <s:textfield label="description" name="productBean.description"/>
        <s:textfield label="price" name="productBean.price"/>
        <s:textfield label="stock" name="productBean.stock" />
        <s:submit/>
    </s:form>
    <hr />
    <s:text name="contact" />
</body>
</html>
