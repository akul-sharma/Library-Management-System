<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="com.assignment9.model.Authors"
    import="java.util.*"
 %>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

<style>

  .container{
    width:50%;
  }

  .field{
    width:60%;
  }
  .data{
   justify-content:space-between;
   margin-top:30px;
  }
  .otherField{
     margin-top:30px;
  }
  .first{
    margin-top:30px;
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
	
	List<Authors> allAuthors=(List<Authors>) request.getAttribute("allAuthors"); %>

<nav class="navbar">
  <div class="container-fluid d-flex justify-content-between">
    <span></span>
    <span class="navbar-brand mb-0 h1">Library Management System</span>
    <span><b style="margin-right:8px;">Welcome ${username }</b><button type="button" class="btn btn-outline-primary">Logout</button></span>
  </div>
</nav>

  <h3 class="text-center" style="margin-top:30px;">Edit Book Details</h3>

<div class="container align-left">

  <form action="update" method="post">
  
    <div class="first">
      <label for="bookCode">Book Code</label>
      <span style="margin-left:260px;"> ${bookId} </span>  
      <input type="hidden" name="bookId" value=${bookId }>
    </div>
     <div class="d-flex data">
      <label for="bookName">Book Name</label>
      <input type="text" name="bookName" class="form-control field" value="${bookName }">
    </div>
     <div class="d-flex justify-content-space-between data">
      <label for="author">Author</label>
      <select class="form-select field"  name="author" value="${author }">
		  <option selected>${author }</option>
		   <%
		     for(Authors author: allAuthors){
		    	 
		    	 out.println("<option value='"+ author.getAuthorName() +"'>"+ author.getAuthorName() +"</option>");
		    	 
		     }
		 %>
	</select>
    </div>
    <div class="otherField">
      <label for="date">Added on</label>
      <span id="showDate" class="field" style="margin-left:260px;"> ${date } </span>
      <input type="hidden" value="${date }" name="date">
    </div>
    
    <div class="otherField">
	    <button type="submit" class="btn btn-primary">Submit</button>
	    <a href="/books"><button type="button" class="btn btn-danger" style="margin-left:30px;">Cancle</button></a>
    </div>
    
  </form>
  
 </div>
  
  <div class="container-fluid fixed-bottom p-0 foot"></div>
  
</body>
</html>