<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="com.assignment9.model.Books"
    import="java.util.*"
    %>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<style>

  #bookTable{
    border: 1px solid black;
    border-collapse: collapse;
    margin-top:20px;
  }
  .btn-outline-danger{
    margin-left:14px;
  }
  #edit{
    width:25%;
  }
  .navbar{
    background-color:#DFF6FF;
  }
  .foot{
    background-color:#DFF6FF;
    height:50px;
  }

</style>

<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


  
  <% 
  
  
  response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");
  
  if(session.getAttribute("username")==null){
 	 response.sendRedirect("login.jsp");
  }
  
  List<Books> allBooks=(List<Books>)request.getAttribute("allBooks");
  
%>

<nav class="navbar">
  <div class="container-fluid d-flex justify-content-between">
    <span></span>
    <span class="navbar-brand mb-0 h1">Library Management System</span>
    <span><b style="margin-right:8px;">Welcome ${username }</b><a href="Logout"><button type="button" class="btn btn-outline-primary">Logout</button></a></span>
  </div>
</nav>

<div class="container d-flex justify-content-between" style="margin-top:30px">
 <div></div>
  <h3 class="text-center">Book Listing</h3>
  <a href="add"><button type="button" class="btn btn-primary">Add a book</button></a>
</div>


  <Table  id="bookTable" class="container table table-bordered" >
  <tr>
    <th>Book Code</th>
    <th>Book Name</th>
    <th>Author</th>
    <th>Date Added</th>
    <th>Actions</th>
  </tr>
  <%
      for(Books b: allBooks){
    	  
    	  out.println("<tr><td>"+ b.getId() +"</td><td>"+ b.getBookName() +"</td><td>"+ b.getAuthorName() +"</td><td>"+ b.getDate() +"</td><td><a href='edit?bookId="+ b.getId() +"&bookName="+ b.getBookName() +"&author="+ b.getAuthorName() +"&date="+ b.getDate() +"'><input type='button' value='Edit' id='edit' class='btn btn-outline-primary' ></a><a href='delete?bookId="+ b.getId() +"'><input type='button' value='Delete' class='btn btn-outline-danger' ></a></td><tr>");
    	  
      }
  %>   
  </Table> 
  
  <div class="container-fluid fixed-bottom p-0 foot"></div>
  

</body>
</html>