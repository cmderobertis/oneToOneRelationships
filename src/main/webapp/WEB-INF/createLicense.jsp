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
<h1>New License</h1>
<div class="row justify-content-center">
  <div class="col-auto">
    <div class="card">
      <div class="card-body">
        <%--@elvariable id="license" type=""--%>
        <form:form action="/licenses" method="post" modelAttribute="license">
          <p class="form-control d-flex flex-column">
            <form:label path="number">Number</form:label>
            <form:errors path="number" cssClass="text-danger"/>
            <form:input path="number"/>
          </p>
          <p class="form-control d-flex flex-column">
            <form:label path="expirationDate">Expiration Date</form:label>
            <form:errors path="expirationDate" cssClass="text-danger"/>
            <form:input type="date" path="expirationDate"/>
          </p>
          <p class="form-control d-flex flex-column">
            <form:label path="state">State</form:label>
            <form:errors path="state" cssClass="text-danger"/>
            <form:input path="state"/>
          </p>
          <p class="form-control d-flex flex-column">
            <form:label path="person">Person</form:label>
            <form:errors path="person" cssClass="text-danger"/>
            <form:select path="person">
              <c:forEach var="onePerson" items="${persons}">
                <!--- Each option VALUE is the id of the person --->
                <form:option value="${onePerson.id}">
                  <!--- This is what shows to the user as the option --->
                  <c:out value="${onePerson.firstName}"/>
                  <c:out value="${onePerson.lastName}"/>
                </form:option>
              </c:forEach>
            </form:select>
          </p>
          <input class="mt-3 btn btn-primary" type="submit" value="Submit">
        </form:form>
      </div>
    </div>
  </div>
  <a class="btn btn-secondary" href="/licenses">Cancel</a>
</div>
</body>
</html>