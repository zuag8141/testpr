<%-- 
    Document   : list
    Created on : Oct 31, 2025, 3:19:13 AM
    Author     : trant
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
        <h1>Hello ${sessionScope.ACCOUNT.lastName} ${sessionScope.ACCOUNT.firstName} !</h1>
        <a href="MainController?action=Logout">Logout</a>
        <form action ="MainController">
            <input type="text" name="txtSearch" value="">
            <input type="submit" name="action" value="Search">
        </form>
        <c:if test="${requestScope.LIST_RESULT != null && !requestScope.LIST_RESULT.isEmpty()}">
            <table border="1">
                <thead>
                    <tr>
                        <th>productImage</th>
                        <th>productId</th>
                        <th>productName</th>
                        <th>brief</th>
                        <th>account</th>
                        <th>unit</th>
                        <th>postedDate</th>
                        <th>typeId</th>
                        <th>price</th>
                        <th>discount</th>
                        <th>action</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${requestScope.LIST_RESULT}" var="p">
                    <form action="MainController">
                        <tr>
                            <td>${p.productImage}</td>
                            <td>${p.productId}</td>
                            <td>${p.productName}</td>
                            <td>${p.brief}</td>
                            <td>${p.account}</td>
                            <td>${p.unit}</td>
                            <td>${p.postedDate}</td>
                            <td>${p.typeId}</td>
                            <td>${p.price}</td>
                            <td>${p.discount}</td>
                            <td><button type="submit" name="action" value="Delete">Delete</td>
                        </tr>
                    </form>
                </c:forEach>
            </tbody>
        </table>
    </c:if>
</body>
</html>
