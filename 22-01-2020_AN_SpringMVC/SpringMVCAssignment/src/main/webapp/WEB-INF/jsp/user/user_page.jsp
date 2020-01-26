<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Page</title>
</head>
<body>
 <spring:url value="/user/add" var="addURL" />
 <a href="${addURL }">Add User</a>

 <h1>Users List</h1>
 <table width="100%" border="1">
  <tr>
   <th>ID</th>
   <th>Firstname</th>
   <th>Lastname</th>
   <th>Address</th>
   <th colspan="2">Action</th>
  </tr>
  <c:forEach items="${listUser }" var="user" >
   <tr>
    <td>${user.id }</td>
    <td>${user.firstname }</td>
    <td>${user.lastname }</td>
    <td>${user.address }</td>
    <td>
     <spring:url value="/user/update/${user.id }" var="updateURL" />
     <a href="${updateURL }">Update</a>
    </td>
    <td>
     <spring:url value="/user/delete/${user.id }" var="deleteURL" />
     <a href="${deleteURL }">Delete</a>
    </td>
   </tr>    
  </c:forEach>
 </table>
 
</body>
</html>