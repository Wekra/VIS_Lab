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
    <s:form action="Add_Product" enctype="multipart/form-data">
        <s:textfield key="productname" name="productBean.label"/>
        <s:textarea key="description" name="productBean.description"/>
        <s:select key="category" list="categoryLabelList" name="category_label"/>
        <s:textfield key="price" name="productBean.price"/>
        <s:textfield key="stock" name="productBean.stock" />
        <s:submit/>
    </s:form>
    <hr />
    <s:text name="contact" />
</body>
</html>
