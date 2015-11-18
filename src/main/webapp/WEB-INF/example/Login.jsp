<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>Sign On</title>
</head>

<body>
<s:form action="User_Login" focusElement="username">
    <s:textfield name="username" key="username"/>
    <s:password name="password" key="password" />

    <s:textfield name="username" key="prompt.username" size="20"/>
    <s:password name="password" key="prompt.password" size="20"/>

    <s:submit method="execute" label="Login" align="center"/>
</s:form>


<font color="red">
    <s:actionerror label="label"/>
</font>
</body>
</html>
