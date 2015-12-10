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
    <head><meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
        <title>The MILKROAD - Suchergebnis</title>
        <link href="${pageContext.request.contextPath}../../css/webshop.css" rel="stylesheet" type="text/css">
        <link href="http://s3.amazonaws.com/codecademy-content/courses/ltp/css/shift.css" rel="stylesheet">
    </head>
    <body>
        <div class="container">
            <div class="header">
                <div class="nav">
                    <ul class="pull-left">
                        <li><a href="<s:url action="GoTo_Search"/>">Suche</a></li>
                        <li><a href="<s:url action="Logout"/>">Logout</a> </li>
                    </ul>
                </div>
            </div>
            <div class="content-container">
                <h1>Suchergebnis</h1>

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
                <p/>
                <p>Zurück <a href="<s:url action="GoTo_Admin_Main"/>">zum Hauptmenü</a>. </p>
            </div>
        </div>
        <div class="contact">
            <hr />
            <s:text name="contact" />
        </div>
    </body>
</html>
