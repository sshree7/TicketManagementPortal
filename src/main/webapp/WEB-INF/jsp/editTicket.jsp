<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ page import="java.util.*"%>
<%@ page import="org.springframework.ui.Model"%>
<%@ page import="org.springframework.http.ResponseEntity"%>
<%@page import="java.util.ArrayList"%><%@page import="com.nagarro.training.TicketManagementPortal.service.TicketServiceImpl"%>
<%@page import="com.nagarro.training.TicketManagementPortal.dto.TicketDto"%>
<%@page import="com.nagarro.training.TicketManagementPortal.domain.User"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<title>Add Book</title>
</head>
<body style="background-color: #ffffff;">
  <div style="  color :azure; margin-top: 5px; margin-left: 7px; margin-right: 7px;
    height: 50px;
    background-color:#dc143c; ">
    <header>
      <div style="text-align: center; ">
        <h2 style="padding: 5px 0;"> Ticket Management Portal </h2>
      </div>
    </header>
  </div> 
  <div style="
    display:flex;">
    <form action="editTicket" method="POST" style="margin:auto; padding-top: 40px; color:#dc143c; ">
      <h4 style="text-align: center;"> Edit Ticket </h4> <br>
       <div class="form-group">
        <label for="id">Id</label>
        <input type="text" class="form-control" id="id" name="id" value="${ticket.getId()}" readonly>
      </div>
      <div class="form-group">
        <label for="department">Department</label>
        <input type="text" class="form-control" id="department" name="department" value="${ticket.getDepartment()}">
      </div>
      <div class="form-group">
        <label for="title">Title</label>
        <input type="text" class="form-control" id="title" name="title" value="${ticket.getTitle()}">
      </div>

      <div class="form-group">
        <label for="description">Description</label>
        <input style="width: 5in;" type="text" class="form-control" id="description" name="description"
         value="${ticket.getDescription()}">
      </div>
        <div class="form-group">
        <label for="status">Status</label>
        <input style="width: 5in;" type="text" class="form-control" id="status" name="status"
          value="${ticket.getStatus()}">
      </div>
      <button type="submit" class="btn btn-danger">Submit</button> 
    </form>

  </div>
</body>
</html>