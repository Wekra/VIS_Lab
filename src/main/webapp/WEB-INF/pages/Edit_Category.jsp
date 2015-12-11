<%--
  Created by IntelliJ IDEA.
  User: Marcel
  Date: 10.12.2015
  Time: 14:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>Milkroad</title>
</head>
<body>
<s:form action="Edit_Category" enctype="multipart/form-data">
    <s:textfield key="category" name="categoryBean.label" value="%{oldCategoryBean.label}"/>
    <s:hidden name="categoryBean.category_id" value="%{oldCategoryBean.category_id}"/>
    <s:submit key="edit"/>
</s:form>
</body>
</html>
