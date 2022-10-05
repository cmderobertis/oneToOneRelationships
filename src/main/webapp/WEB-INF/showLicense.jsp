<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Formatting (dates) -->
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Tacos</title>
  <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
  <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
  <script src="/webjars/jquery/jquery.min.js"></script>
  <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
<table class="table">
  <thead class="thead-dark">
  <tr>
    <th>Number</th>
    <th>State</th>
    <th>Exp Date</th>
    <th>Person</th>
  </tr>
  </thead>
  <tbody>
  <tr>
    <td><c:out value="${license.number}"/></td>
    <td><c:out value="${license.state}"/></td>
    <td><c:out value="${license.expirationDate}"/></td>
    <td>
      <c:out value="${license.person.firstName} ${license.person.lastName}"/>
    </td>
  </tr>
  </tbody>
</table>
<a href="/licenses">Back</a>
</body>
</html>