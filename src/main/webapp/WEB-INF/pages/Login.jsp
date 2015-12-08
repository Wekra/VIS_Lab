<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>Sign On</title>
    <link href="${pageContext.request.contextPath}../../css/webshop.css" rel="stylesheet" type="text/css">
    <link href="http://s3.amazonaws.com/codecademy-content/courses/ltp/css/shift.css" rel="stylesheet">
    <link rel="stylesheet" href="http://s3.amazonaws.com/codecademy-content/courses/ltp/css/bootstrap.css">
    <s:head />
</head>

<body>
<div class="container">
        <s:form action="LoginSubmit">
            <s:textfield cssClass="myClass" key="email"/>
            <s:password cssClass="myClass" key="password" />
            <s:submit/>
        </s:form>
    <div class="contact">
        <hr />
        <s:text name="contact" />
    </div>
    </div>
</body>
</html>
