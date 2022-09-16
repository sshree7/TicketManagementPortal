<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page isELIgnored="false"%>
<!doctype html>
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">

<title>Login Form</title>
<style>
#container {
	position: fixed;
	top: 50%;
	left: 50%;
	width: 30em;
	height: 18em;
	margin-top: -9em; /*set to a negative number 1/2 of your height*/
	margin-left: -15em;
}
</style>
</head>
<body style="background-color: #ffffff;">
<div style="  color :azure; margin-top: 5px; margin-left: 7px; margin-right: 7px;
    height: 50px;
    background-color:#dc143c; ">
        <header>
            <div style="text-align: center; ">
                <h2 style="padding: 5px 0;"> Employee Portal </h2>
            </div>
        </header>
            <div style= " margin-right: 6px;"> 
           <a class="btn btn-danger" href="/register"  style="float:right;">Register</a></div>
    </div>

    </div>
  <div style="
    display:flex;">
    <form action="/user/welcome" method="post" style="margin:auto; padding-top: 120px; color:#dc143c; ">
      <h3> Welcome to your Ticket Corner :) </h3> <br>
      <div class="form-group">
        <label for="username">Username</label>
        <input type="text" class="form-control" id="username" name="username" placeholder="Enter your username" required>
      </div>
      <div class="form-group">
        <label for="password">Password</label>
        <input type="password" class="form-control" id="password" name="password" placeholder="Enter your password" required>
       
      </div>
      <button type="submit" class="btn btn-danger">Submit</button> &nbsp;
    </form>

  </div>
  
 <!-- <div if:"param.error"> Invalid username or password</div> --> 
</body>
</html>