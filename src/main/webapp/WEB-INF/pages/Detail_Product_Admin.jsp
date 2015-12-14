<%--
  Created by IntelliJ IDEA.
  User: Marcel
  Date: 07.12.2015
  Time: 15:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
        <title>The MILKROAD - <s:property value="productBean.label"/> </title>
        <link href="${pageContext.request.contextPath}../../css/webshop.css" rel="stylesheet" type="text/css">
        <link href="http://s3.amazonaws.com/codecademy-content/courses/ltp/css/shift.css" rel="stylesheet">
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
                <h1><s:property value="productBean.label"/> </h1>
                <p/>
                <p/>
                <h3>Beschreibung:</h3>
                <p><b><s:property value="productBean.description"/></b></p>
                <p><s:property value="productBean.label"/> ist der Kategorie "<s:property value="categoryLabel"/>" zugeordnet.</p>
                <p><b>Preis:</b> <s:property value="productBean.price"/> Btc.</p>
                <p>Noch <s:property value="productBean.stock"/> auf Lager.</p>
                <p/>
                <p>
                    <a href="
                            <s:url action="Delete_Product">
                                <s:param name="specialId" value="productBean.product_id"/>
                        </s:url>">Löschen
                    </a>
                </p>
                <p>
                    <a href="
                        <s:url action="GoTo_Edit_Product">
                            <s:param name="specialId" value="productBean.product_id"/>
                    </s:url>">Editieren
                    </a>
                </p>
                <p>Zurück <a href="<s:url action="GoTo_Admin_Main"/>">zum Hauptmenü</a>. </p>
            </div>
        </div>
        <div class="contact">
            <hr />
            <s:text name="contact" />
        </div>
    </body>
</html>
