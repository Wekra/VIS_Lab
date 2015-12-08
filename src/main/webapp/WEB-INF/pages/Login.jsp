<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>Sign On</title>
    <link href="../css/webshop.css" rel="stylesheet" type="text/css">
    <s:head />
</head>

<body>
<s:form action="LoginSubmit">
    <s:textfield key="email"/>
    <s:password key="password" />
    <s:submit/>
</s:form>
</body>
</html>
