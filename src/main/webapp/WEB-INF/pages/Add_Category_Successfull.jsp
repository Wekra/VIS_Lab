<%--
  Created by IntelliJ IDEA.
  User: Marcel
  Date: 07.12.2015
  Time: 17:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>Category erfolgreich hinzugefügt</title>
</head>
<body>
    <p>Kategory wurde erfolgreich hinzugefügt</p>
    <p>Name: <s:property value="categoryBean.label"/></p>
    <p><a href="<s:url action="GoTo_Admin_Main"/>">Zum Hauptmenü</a>. </p>
</body>
</html>
