<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Create User</title>
</head>
    <body>
        <form:form action="new?tenant=${pageContext.request.getParameter('tenant')}" method="post" modelAttribute="user">
            <div><form:input path="id" type="number" placeholder="Id"/></div>
            <div><form:input path="name" placeholder="Name"/></div>
            <div><form:input path="address" placeholder="Address"/></div>
            <div><input type="submit" value="Save"></div>
        </form:form>
    </body>
</html>
