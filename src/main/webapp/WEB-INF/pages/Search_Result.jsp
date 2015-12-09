<%--
  Created by IntelliJ IDEA.
  User: Marcel
  Date: 08.12.2015
  Time: 15:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>Suchergebnis</title>
</head>
<body>

<p><a href="<s:url action="GoTo_Admin_Main"/>">Hauptmenü</a>. </p>

<s:iterator value="productList">
    <tr>
        <td><a href="
            <s:url action="GoTo_Detail_Product">
                <s:param name="id" value="product_id"/>
            </s:url>"><s:property value="label"/></a>
        </td>
        <p>Preis: <td><s:property value="price"/></td></p>
    </tr>
</s:iterator>

</body>
</html>
