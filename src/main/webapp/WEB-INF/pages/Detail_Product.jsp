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
    <title>Deteiansicht: <s:property value="productBean.label"/> </title>
</head>
<body>
    <h2><s:property value="productBean.label"/></h2>
    <p>Beschreibung: <s:property value="productBean.description"/></p>
    <p>Kategory: <s:property value="productBean.category"/></p>
    <p>Preis: <s:property value="productBean.price"/> Btc</p>
    <p>Nur noch <s:property value="productBean.stock"/> auf Lager</p>

</body>
</html>
