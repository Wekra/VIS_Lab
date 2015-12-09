<%--
  Created by IntelliJ IDEA.
  User: Marcel
  Date: 08.12.2015
  Time: 15:12
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Erweiterte Suche</title>
</head>
<body>

<s:form action="Search_Result">
    <s:textfield key="search" name="searchText"/>
    <s:textfield key="minPrice" name="minPrice"/>
    <s:textfield key="maxPrice" name="maxPrice"/>
    <s:submit/>
</s:form>

</body>
</html>
