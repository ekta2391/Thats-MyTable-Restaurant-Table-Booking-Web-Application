<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<html lang="en">

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Add Your Tables</title>

    <!-- Bootstrap Core CSS -->
    <link href="resources/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="resources/css/business-casual.css" rel="stylesheet">

    <!-- Fonts -->
    <link href="http://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800" rel="stylesheet" type="text/css">
    <link href="http://fonts.googleapis.com/css?family=Josefin+Slab:100,300,400,600,700,100italic,300italic,400italic,600italic,700italic" rel="stylesheet" type="text/css">



</head>

<body>

    <div class="brand"><h1>Add  ${myRestaurant.restName}'s Table availability:</h1>
    </div>
    <div class="address-bar">${myRestaurant.restCity}</div>

    <!-- Navigation -->
    <nav class="navbar navbar-default" role="navigation">
        <div class="container">
            <!-- Brand and toggle get grouped for better mobile display -->
            
            <!-- Collect the nav links, forms, and other content for toggling -->
            
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container -->
    </nav>

    <div class="container">

        <div class="row">
            <div class="box">
                <div class="col-lg-12">
                  
                </div>
                <div class="col-md-6">
                    <img class="img-responsive img-border-left" src="resources/img/slide-9.jpg" alt="">
                </div>
                <div class="col-md-6">
                <hr>
                    <h2 class="intro-text text-center">
                        <strong>Add a Table</strong>
                    </h2>
                    <hr>
                    <form:form action="addTable.htm" commandName="addingTable" method="post" >
                  
                  
                  
                  <table>
                   <tr>
                   <td>Please Add a Table to the System</td><br>
                   </tr>
                   <tr><td></td></tr>
                   <tr>
                  <td> Table Number:</td>
                  </tr>
                  <tr>
                  <td><input type="number" size="8" name="tableNo" required ></td>
                  </tr>
                
                
                
                
                
                  </table>
                
                  
                 
                  <input type="hidden" name="restName" value="${myRestaurant.restName}" /> 
                  <input type="submit" value="Add Table"/><br><br>
                  
                 </form:form>
                 
                 
                 
                 
                
                </div>
                <div class="clearfix"></div>
            </div>
        </div>

       

    </div>
    <!-- /.container -->
    
    
<!--     Occupied Table Container -->
    <div class="container">

        <div class="row">
            <div class="box">
                <div class="col-lg-12">
                  
                </div>
                <div class="col-md-6">
                    <img class="img-responsive img-border-left" src="resources/img/slide-10.jpg" alt="">
                </div>
                <div class="col-md-6">
                  <hr>
                    <h2 class="intro-text text-center">
                        <strong>Occupied Table</strong>
                    </h2>
                    <hr>
                 
                 <form:form action="deleteTable.htm" commandName="deletingTable" method="post">
                  
                  Please indicate if the table has been Occupied:<br>
                  
                  <table>
                   <tr> 
                  <td> Table Number:</td></tr>
                  <tr>
                  <td><input type="number"  size="8" name="tableNo" required></td></tr>
                  
                  
                  
                  </table>
                  
                  
                  <input type="radio" name="tableStatus" value="occupied" required/>Occupied<br> <br> 
                  <input type="hidden" name="restName" value="${myRestaurant.restName}" /> 
                 
                  <input type="submit" value="Occupied Table"/><br><br>
                  
                 </form:form>
                 
                 
                 
                </div>
                <div class="clearfix"></div>
            </div>
        </div>

       

    </div>
    
<!--     Update Vacancy Container -->

<div class="container">

        <div class="row">
            <div class="box">
                <div class="col-lg-12">
                  
                </div>
                <div class="col-md-6">
                    <img class="img-responsive img-border-left" src="resources/img/slide-8.jpg" alt="">
                </div>
                <div class="col-md-6">
                    
                 <hr>
                    <h2 class="intro-text text-center">
                        <strong>Update Table's Vacancy</strong>
                    </h2>
                    <hr>
                
                 
                 <form:form action="updateVacancy.htm" commandName="updatingTableVacancy" method="post">
                  
                  Please update the Table's vacancy below:<br>
                  
                  <table>
                   <tr> 
                  <td> Table Number:</td></tr>
                  <tr>
                  <td><input type="number" size="8" name="tableNo" required/>
                  
                  </tr>
                  
                  </table>
                  
                  
                  <input type="radio" name="tableStatus" value="vacant" required/>Vacant<br> <br> 
                  <input type="hidden" name="restName" value="${myRestaurant.restName}" /> 
                 
                  <input type="submit" value="Vacant Table"/><br><br>
                  
                 </form:form>
                </div>
                <div class="clearfix"></div>
            </div>
        </div>

       

    </div>

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


