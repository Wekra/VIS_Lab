<%--
  Created by IntelliJ IDEA.
  User: Marcel
  Date: 07.12.2015
  Time: 15:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
    <title>MILKROAD</title>
</head>
<body>
<p><a href="<s:url action="GoTo_Search"/>">Suche</a>. </p>
<h3>Shop-stub</h3>

<p>Some paragraph.</p>
<p>Neues Produkt <a href="<s:url action="GoTo_add_product"/>">hinzufügen</a>. </p>
<p>Neue Kategory <a href="<s:url action="GoTo_Add_Category"/>">hinzufügen</a>. </p>


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