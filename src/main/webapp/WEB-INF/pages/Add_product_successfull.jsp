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
    <title>Added Product successfull</title>
</head>
<body>
<h2>Das Produkt wurde erfolgreich hinzugefügt</h2>
<p>Name: <s:property value="productBean.label"/></p>
<p>Beschreibung: <s:property value="productBean.description"/></p>
<p>Preis: <s:property value="productBean.price"/></p>
<p>Auf Lager: <s:property value="productBean.stock"/></p>

<p><a href="<s:url action="Access_menu"/>">Zum Hauptmenü</a>. </p>
</body>
</html>
