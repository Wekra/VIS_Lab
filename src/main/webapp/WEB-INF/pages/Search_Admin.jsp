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
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
        <title>The MILKROAD - Suche</title>
        <link href="${pageContext.request.contextPath}../../css/webshop.css" rel="stylesheet" type="text/css">
        <link href="http://s3.amazonaws.com/codecademy-content/courses/ltp/css/shift.css" rel="stylesheet">
    </head>
    <body>
        <div class="container">
            <div class="header">
                <div class="nav">
                    <ul class="pull-left">
                        <li><a href="<s:url action="Logout"/>">Logout</a> </li>
                    </ul>
                </div>
            </div>
            <div class="content-container">
                <h1>Suche</h1>
                <s:form action="Search_Result">
                    <!--s:text name="searchString"/-->
                    <s:textfield key="search" name="searchText"/>
                    <!--s:text name="priceRange"/-->
                    <s:textfield key="minPrice" name="minPrice"/>
                    <s:textfield key="maxPrice" name="maxPrice"/>
                    <s:submit key="searchButton"/>
                </s:form>
                <p/>
                <p>Zurück <a href="<s:url action="Access_menu"/>">zum Hauptmenü</a>. </p>
            </div>
        </div>
        <div class="contact">
            <hr />
            <s:text name="contact" />
        </div>
    </body>
</html>
