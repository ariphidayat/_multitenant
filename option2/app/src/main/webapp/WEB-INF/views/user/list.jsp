<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User</title>
    </head>
    <body>
        <a href="user/new?tenant=${pageContext.request.getParameter('tenant')}">New User!</a>
        <table>
            <c:forEach var="user" items="${users}">
                <tr>
                    <td>#${user.id}</td>
                    <td>#${user.name}</td>
                    <td>#${user.address}</td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>