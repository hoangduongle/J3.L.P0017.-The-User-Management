<%-- 
    Document   : historypromotion
    Created on : Jun 16, 2021, 8:41:17 AM
    Author     : Asus
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <table border="1">
            <thead>
                <tr>
                    <th>Date Added</th>
                    <th>Promotion</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <c:forEach items="${requestScope.HISTORY}" var="o">
                        <td>${o.getAdddate()}</td>
                        <td>${o.getPro().getProName()}</td>
                    </c:forEach>
                </tr>
            </tbody>
        </table>

    </body>
</html>
