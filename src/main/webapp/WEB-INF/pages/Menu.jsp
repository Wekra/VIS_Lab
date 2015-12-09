<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
        <title>The MILKROAD - Hauptmenü</title>
        <link href="${pageContext.request.contextPath}../../css/webshop.css" rel="stylesheet" type="text/css">
        <link href="http://s3.amazonaws.com/codecademy-content/courses/ltp/css/shift.css" rel="stylesheet">
    </head>
    <body>
        <div class="header">
            <div class="nav">
                <ul class="pull-left">
                    <li><a href="<s:url action="GoTo_Search"/>">Suche</a></li>
                    <li><a href="<s:url action="Logout"/>">Logout</a> </li>
                </ul>
            </div>
        </div>
        <div class="container">
            <h1>Shop-stub</h1>
            <p/>
            <h2>Produktübersicht</h2>

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
        </div>
        <div class="contact">
            <hr />
            <s:text name="contact" />
        </div>
    </body>
</html>