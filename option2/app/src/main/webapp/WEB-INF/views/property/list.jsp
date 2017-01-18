<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Properties</title>
    </head>
    <body>
        <table>
            <a href="property/update">Reload and Update Tenant Connection!</a><br/>
            <a href="property/new">Add New Tenant</a>
            <c:forEach var="property" items="${properties}">
                <tr>
                    <td>#${property.id}</td>
                    <td>#${property.name}</td>
                    <td>#${property.driver}</td>
                    <td>#${property.url}</td>
                    <td>#${property.username}</td>
                    <td>#${property.password}</td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>