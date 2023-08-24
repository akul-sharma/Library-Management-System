<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

<style>

   .container{
     width:40%;
     height:175px;
     margin-top:150px;
     border:1px solid black;
   }
   .navbar{
    background-color:#DFF6FF;
  }
  .foot{
    background-color:#DFF6FF;
    height:50px;
  }
  #btn{
   width:100px;
  }

</style>

<script>

function formValidation() {
    var name = document.getElementById("name").value;
    var pass = document.getElementById("pass").value;
    
    if(name.length<5 || name.length>50 || pass.length<5 || pass.length>50){
    	alert("Username and Password should be min. 5 and max. 50 characters");
    	return false;
    }
    
   return true;
    
}

</script>

<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<nav class="navbar">
  <div class="container-fluid d-flex justify-content-between">
    <div></div>
    <div class="navbar-brand mb-0 h1">Library Management System</div>
    <div></div>
  </div>
</nav>

<div class="container">
<div style="margin:4px; color:blue;">
  Login
</div>
 <form  onsubmit="return formValidation()" action="login" method="post">
   <div class="d-flex justify-content-between" style="margin-top:10px">
     <div></div>
     <label for="username" style="background-color:#EAEAEA;">Username:</label>
     <input type="text"  name="username" class="form from-control" id="name">
     <div></div>
   </div>
   <div class="d-flex justify-content-between" style="margin-top:10px">
     <div></div>
     <label for="password" style="background-color:#EAEAEA;">Password:</label>
     <input type="password" name="password" class="form from-control" id="pass">
     <div></div>
   </div>
   <div class="d-flex justify-content-between">
     <div></div>
     <input style="margin-top:18px" type="submit" value="Login" id="btn">
     <div></div>
   </div>
 </form>
</div>


<div class="container-fluid fixed-bottom p-0 foot"></div>

</body>
</html>