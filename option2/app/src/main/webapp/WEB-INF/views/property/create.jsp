<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Create Property</title>
</head>
    <body>
        <form:form action="new" method="post" modelAttribute="property">
            <div><form:input path="id" type="number" placeholder="Id"/></div>
            <div><form:input path="name" placeholder="Name"/></div>
            <div><form:input path="driver" placeholder="Database Driver" /></div>
            <div><form:input path="url" placeholder="Database URL"/></div>
            <div><form:input path="username" placeholder="Database Username"/></div>
            <div><form:password path="password" placeholder="Database Password"/></div>
            <div><input type="submit" value="Save"></div>
        </form:form>
    </body>
</html>
