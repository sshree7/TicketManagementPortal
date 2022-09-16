<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ page import="java.util.*"%>
<%@ page import="org.springframework.ui.Model"%>
<%@ page import="org.springframework.http.ResponseEntity"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.nagarro.training.TicketManagementPortal.service.TicketServiceImpl"%>
<%@page import="com.nagarro.training.TicketManagementPortal.dto.TicketDto"%>
<%@page import="com.nagarro.training.TicketManagementPortal.domain.User"%>
<!DOCTYPE html>

<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
        integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>

<body style="background-color: #ffffff;">
    <div style="  color :azure; margin-top: 5px; margin-left: 7px; margin-right: 7px;
    height: 50px;
    background-color:#dc143c; ">
        <header>
            <div style="text-align: center; ">
          
                <h2 style="padding: 5px 0;"> Ticket Management Portal  
                 </h2>

            </div>

        </header>
        <div style= " margin-right: 6px;"> 
           <a class="btn btn-outline-dark" href="/logout"  style="float:right;">Log Out</a></div>
    </div>
 
    <%  User user = (User)session.getAttribute("user");
    int userId= user.getId();
    
    TicketServiceImpl ticketServiceImpl = new TicketServiceImpl ();
    //final List<TicketDto> ticketList = ticketServiceImpl.getAllTicketsOfAnEmployee(user.getId());
    List<TicketDto> ticketList = (List<TicketDto>) session.getAttribute("ticketList");
  

%> 

     <div class="container mb-5 mt-5">

        <div style="text-align: right; padding-right: 30px;">
           	<div style="position:absolute; left:100px; padding-right: 30px;">
			<form action="addTicketForm" method="post" >

				<input type="submit" class="btn btn-outline-dark" value="Create New Ticket">

			</form>
		</div> <br>
            

        </div> <br> <br>
        <div class="container mb-5 mt-1">
            <div class="table-responsive">
                <table class="table table-striped">
                    <thead>
                        <tr>
                            <th style="text-align: center" scope="col">Id</th>
                            <th style="text-align: center" scope="col">Department</th>
                            <th style="text-align: center" scope="col">Title</th>
                            <th style="text-align: center" scope="col">Description</th>
                            <th style="text-align: center" scope="col">Status</th>
                            <th style="text-align: center" scope="col">Action</th>
                        </tr>
                    </thead>
                    <tbody>

                        <%  if(ticketList.size()>0){
                        
                        for(TicketDto ticketDto : ticketList ){ %>


                            <tr>
                                <td style="text-align: center">
                                    <%= ticketDto.getId()%>
                                </td>
                                <td style="text-align: center">
                                    <%= ticketDto.getDepartment()%>
                                </td>
                                 <td style="text-align: center">
                                    <%=ticketDto.getTitle()%>
                                </td>
                                <td style="text-align: center">
                                    <%= ticketDto.getDescription()%>
                                </td>
                                <td style="text-align: center">
                                    <%=ticketDto.getStatus()%>
                                </td>
                                <td style="text-align: center">
                                    <a href="editTicketForm?id=<%=ticketDto.getId()%>" style="line-height: 10px;"
                                        class="btn btn-outline-dark">Edit</a> 
                                    <a href="delete?id=<%=ticketDto.getId()%>" style="line-height: 10px;"
                                        class="btn btn-outline-danger">Delete</a>
                                </td>
                            </tr>
                            <% } }%>
                    </tbody>
                </table>
            </div>


        </div>

    </div>
</body>

</html>