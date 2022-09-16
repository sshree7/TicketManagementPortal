<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@page import = "java.util.*" %>
	<%@page isELIgnored="false"%>
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
    <form action="addTicket" method="POST" style="margin:auto; padding-top: 40px; color:#dc143c; ">
      <h4 style="text-align: center;"> Generate New Ticket </h4> <br>
      <div class="form-group">
        <label for="department">Department</label>
        <input type="text" class="form-control" id="department" name="department" placeholder="Enter the Department">
      </div>
      <div class="form-group">
        <label for="title">Title</label>
        <input type="text" class="form-control" id="title" name="title" placeholder="Enter the Title">
      </div>

      <div class="form-group">
        <label for="description">Description</label>
        <input style="width: 5in;" type="text" class="form-control" id="description" name="description"
          placeholder="Enter the Description">
      </div>
        <div class="form-group">
        <label for="status">Status</label>
        <input style="width: 5in;" type="text" class="form-control" id="status" name="status"
          placeholder="Enter the Status">
      </div>
      <button type="submit" class="btn btn-danger">Submit</button> 
    </form>

  </div>
</body>
</html>