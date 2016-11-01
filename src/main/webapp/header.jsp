<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Eee-Rock Music Shop</title>
<body>
<div align="center">
    <div>
        <table>
            <tr>
                <td><a href='index.jsp'>About</a></td>
                <td><a href='products?page=1'>Home</a></td>
                <%if (session.getAttribute("role") == null) {%>
                <td><a href='/login'>Login</a></td>
                <%} else {%>
                <td><a href='/logout'>Logout</a></td>
                <%}%>
            </tr>
        </table>
    </div>
</div>

