<%--
  Created by IntelliJ IDEA.
  User: Marcel
  Date: 10.12.2015
  Time: 14:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
    <title>The MILKROAD - Kategorien bearbeiten</title>
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
                <s:form action="Edit_Category" enctype="multipart/form-data">
                    <s:textfield key="category" name="categoryBean.label" value="%{oldCategoryBean.label}"/>
                    <s:hidden name="categoryBean.category_id" value="%{oldCategoryBean.category_id}"/>
                    <s:submit key="edit"/>
                </s:form>
                </p>
                <p>Zurück <a href="<s:url action="GoTo_Category_View"/>">zur Kategorieübersicht</a>. </p>
                </p>
                <p>Zurück <a href="<s:url action="GoTo_Admin_Main"/>">zum Hauptmenü</a>. </p>
            </div>
            <div>
                <hr />
                <s:text name="contact" />
            </div>
        </div>
    </body>
</html>
