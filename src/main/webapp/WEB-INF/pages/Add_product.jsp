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

        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
        <title>The MILKROAD - Neues Produkt</title>
        <link href="${pageContext.request.contextPath}../../css/webshop.css" rel="stylesheet" type="text/css">
        <link href="http://s3.amazonaws.com/codecademy-content/courses/ltp/css/shift.css" rel="stylesheet">
        <s:head />
    </head>
    <body>
        <div class="container">
            <div class="header">
                <div class="nav">
                    <ul class="pull-left">
                        <li><a href="<s:url action="GoTo_Search"/>">Suche</a></li>
                        <li><a href="<s:url action="Logout"/>">Logout</a> </li>
                    </ul>
                </div>
            </div>
            <div class="content-container">
                <h1>Produkt hinzufügen</h1>
                <h3>Um ein neues Produkt hinzuzufügen, füllen Sie bitte die folgenden Felder aus:</h3>
                <s:form action="Add_Product" enctype="multipart/form-data">
                    <s:textfield key="productname" name="productBean.label"/>
                    <s:textarea key="description" name="productBean.description"/>
                    <s:select key="category" list="categoryLabelList" name="category_label"/>
                    <s:textfield key="price" name="productBean.price"/>
                    <s:textfield key="stock" name="productBean.stock" />
                    <s:submit key="addProductButton"/>
                </s:form>
                <p/>
                <p>Zurück <a href="<s:url action="GoTo_Admin_Main"/>">zum Hauptmenü</a>. </p>
            </div>
        </div>
        <div class="contact">
            <hr />
            <s:text name="contact" />
        </div>

    </body>
</html>
