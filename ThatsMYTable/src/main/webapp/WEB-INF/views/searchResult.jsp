<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Restaurant Search Result</title>

    <!-- Bootstrap Core CSS -->
    <link href="resources/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="resources/css/business-casual.css" rel="stylesheet">

    <!-- Fonts -->
    <link href="http://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800" rel="stylesheet" type="text/css">
    <link href="http://fonts.googleapis.com/css?family=Josefin+Slab:100,300,400,600,700,100italic,300italic,400italic,600italic,700italic" rel="stylesheet" type="text/css">

</head>

<body>

    <div class="brand">We Found Some Restaurants For You!</div>
   

  

    <div class="container">

        <div class="row">
            <div class="box">
                <div class="col-lg-12">
                    <hr>
                    <h2 class="intro-text text-center">
                       
                    </h2>
                    <hr>
                </div>
                <div class="col-lg-12 text-center">
                    <img class="img-responsive img-border img-full" src="resources/img/slide-7.jpg" alt=""><br>
                   
<h1>Your search result is as follows:<br></h1><br>
<c:forEach items="${restList }" var="restaurant">
<td><p><strong>${restaurant.restName }, ${restaurant.restCity }, ${restaurant.zipCode}</strong></p></td>
<p>Availability of Tables are:</p>
	<table align="center" border=1>
			<tr>
			<th>Table Number</th>
		
			<th>Reserve Table</th>
			<th>Confirm Booking</th>
	
	</tr>
	<c:forEach items="${restaurant.restTable }" var="table">
	
	<c:if test = "${table.tableStatus == 'vacant'}">
			
			
			
			
			
			<tr>
			<td>${table.tableNo }</td>
			
			
			
			<form:form action ="bookTable.htm" commandName="reserve" method="post"  >
			<td><input type="radio" name="tableStatus" value="Reserved" required/></td>
			<td><input type="submit" value="Book Table"/></td>
			
			<input type="hidden" name="tableNo" value="${table.tableNo }"/>
			<input type="hidden" name="restName" value="${restaurant.restName}" /> 
			</form:form>
			</tr>
			
			</c:if>
  	</c:forEach>
  			
	
	</table>
	
	<br><br><br><br>
	
	

  
      
    

</c:forEach>



                    

                    <hr>
                </div>
                </div>
                </div>
                </div>
                
    <!-- /.container -->

    <footer>
        <div class="container">
            <div class="row">
                <div class="col-lg-12 text-center">
                    <p>Copyright &copy; Your Website 2014</p>
                </div>
            </div>
        </div>
    </footer>

    <!-- jQuery -->
    <script src="resources/js/jquery.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="resources/js/bootstrap.min.js"></script>

</body>

</html>









