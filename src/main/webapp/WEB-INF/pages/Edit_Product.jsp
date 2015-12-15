<%--
  Created by IntelliJ IDEA.
  User: Marcel
  Date: 10.12.2015
  Time: 11:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
        <title>The MILKROAD - Produkt bearbeiten</title>
        <link href="${pageContext.request.contextPath}../../css/webshop.css" rel="stylesheet" type="text/css">
        <link href="http://s3.amazonaws.com/codecademy-content/courses/ltp/css/shift.css" rel="stylesheet">
        <s:head/>
    </head>
    <body>
        <div class="container">
            <div class="header">
                <div class="nav">
                    <ul class="pull-left">
                        <li><a href="<s:url action="GoTo_Search_Admin"/>">Suche</a></li>
                        <li><a href="<s:url action="Logout"/>">Logout</a> </li>
                    </ul>
                </div>
            </div>
            <div class="content-container">
                <h1>Produkt bearbeiten</h1>
                <s:form action="Edit_Product" enctype="multipart/form-data">
                    <s:textfield key="productname" name="productBean.label" value="%{oldProductBean.label}"/>
                    <s:textarea key="description" name="productBean.description" value="%{oldProductBean.description}"/>
                    <s:select key="category" list="categoryLabelList" name="categoryLabel" value="%{oldCategoryLabel}"/>
                    <s:textfield key="price" name="productBean.price" value="%{oldProductBean.price}"/>
                    <s:textfield key="stock" name="productBean.stock" value="%{oldProductBean.stock}"/>
                    <s:hidden name="productBean.product_id" value="%{oldProductBean.product_id}"/>
                    <s:submit key="save"/>
                </s:form>
                <p/>
                <p>Zurück <a href="<s:url action="GoTo_Admin_Main"/>">zum Hauptmenü</a>. </p>
            </div>
            <div class="contact">
                <hr />
                <s:text name="contact" />
            </div>
        </div>
    </body>
</html>
