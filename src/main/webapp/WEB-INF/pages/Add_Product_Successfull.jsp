<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Marcel
  Date: 30.11.2015
  Time: 16:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
        <title>The MILKROAD - Neues Produkt</title>
        <link href="${pageContext.request.contextPath}../../css/webshop.css" rel="stylesheet" type="text/css">
        <link href="http://s3.amazonaws.com/codecademy-content/courses/ltp/css/shift.css" rel="stylesheet">
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
                <h1>Produkt erfolgreich hinzugefügt</h1>
                <p/>
                <h2><s:property value="productBean.label"/></h2>
                <p/>
                <h3>Beschreibung</h3>
                <p><s:property value="productBean.description"/></p>
                <p>Kategorie: <s:property value="category_label"/></p>
                <p>Preis: <s:property value="productBean.price"/> Btc</p>
                <p>Auf Lager: <s:property value="productBean.stock"/></p>
                <p/>
                <p><a href="<s:url action="GoTo_Admin_Main"/>">Zum Hauptmenü</a>. </p>
            </div>
        </div>
        <div class="contact">
            <hr />
            <s:text name="contact" />
        </div>
    </body>
</html>
