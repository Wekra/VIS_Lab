<%--
  Created by IntelliJ IDEA.
  User: Marcel
  Date: 10.12.2015
  Time: 11:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>Milkroad</title>
</head>
<body>
    <s:form action="Edit_Product" enctype="multipart/form-data">
        <s:textfield key="productname" name="productBean.label" value="%{oldProductBean.label}"/>
        <s:textarea key="description" name="productBean.description" value="%{oldProductBean.description}"/>
        <s:select key="category" list="categoryLabelList" name="productBean.category" value="%{oldProductBean.category}"/>
        <s:textfield key="price" name="productBean.price" value="%{oldProductBean.price}"/>
        <s:textfield key="stock" name="productBean.stock" value="%{oldProductBean.stock}"/>
        <s:hidden name="productBean.product_id" value="%{oldProductBean.product_id}"/>
    <s:submit key="edit"/>
</s:form>

</body>
</html>
