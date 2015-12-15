<%--
  Created by IntelliJ IDEA.
  User: Marcel
  Date: 10.12.2015
  Time: 14:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
        <title>The MILKROAD - Übersicht Kategorien</title>
        <link href="${pageContext.request.contextPath}../../css/webshop.css" rel="stylesheet" type="text/css">
        <link href="http://s3.amazonaws.com/codecademy-content/courses/ltp/css/shift.css" rel="stylesheet">
        <s:head/>
    </head>
    <body>
        <div class="container">
            <div class="header">
                <div class="nav">
                    <ul class="pull-left">
                        <li><a href="<s:url action="GoTo_Search_Admin"/>">Suche</a></li>
                        <li><a href="<s:url action="Logout"/>">Logout</a> </li>
                    </ul>
                </div>
            </div>
            <div class="content-container">
                <h1>Kategorien bearbeiten</h1>
                <s:iterator value="categoryList">
                    <table >
                        <tr>
                            <th style="width:150px" align="center">
                                <p>Kategorie</p>
                            </th>

                            <th colspan="2" style="width:200px" align="center">
                                <p>Funktionen</p>
                            </th>
                        </tr>
                        <tr>
                            <td style="width:150px" align="center">
                                <s:property value="label"/>
                            </td>
                            <td style="width:100px" align="center">
                                <a href="
                                         <s:url action="GoTo_Edit_Category">
                                            <s:param name="specialId" value="category_id"/>
                                        </s:url>
                                ">Editieren</a>
                            </td>
                            <td style="width:100px" align="center">
                                <a href="
                                         <s:url action="Delete_Category">
                                            <s:param name="id" value="category_id"/>
                                        </s:url>
                                ">Löschen</a>
                            </td>
                            </p>
                        </tr>
                    </table>
                </s:iterator>
                </p>
                <p/>
                <p>Zurück <a href="<s:url action="GoTo_Admin_Main"/>">zum Hauptmenü</a>. </p>
            </div>
        </div>
        <div class="contact">
            <hr />
            <s:text name="contact" />
        </div>
        <font color="red">
            <s:actionerror />
        </font>
    </body>
</html>
