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
    <title>Milkroad</title>
</head>
<body>
<s:iterator value="categoryList">
    <tr>
        <p>
        <td>
            <s:property value="label"/>

            <a href="
                     <s:url action="GoTo_Edit_Category">
                        <s:param name="id" value="category_id"/>
                    </s:url>
            ">Editieren    </a>

            <a href="
                     <s:url action="Delete_Category">
                        <s:param name="id" value="category_id"/>
                    </s:url>
            ">Löschen</a>
        </td>
        </p>
    </tr>
</s:iterator>
</body>
</html>
