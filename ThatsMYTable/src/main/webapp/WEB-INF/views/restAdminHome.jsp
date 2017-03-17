<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html lang="en">


<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Restaurant Admin Home Page</title>

    <!-- Bootstrap Core CSS -->
    <link href="resources/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="resources/css/business-casual.css" rel="stylesheet">

    <!-- Fonts -->
    <link href="http://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800" rel="stylesheet" type="text/css">
    <link href="http://fonts.googleapis.com/css?family=Josefin+Slab:100,300,400,600,700,100italic,300italic,400italic,600italic,700italic" rel="stylesheet" type="text/css">



</head>

<body>

    <div class="brand">Hello ${logPerson.username }</div>
    <div class="address-bar">Welcome to your Page, Restaurant Manager!</div>

    <!-- Navigation -->
    <nav class="navbar navbar-default" role="navigation">
        <div class="container">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <!-- navbar-brand is hidden on larger screens, but visible when the menu is collapsed -->
                <a class="navbar-brand" href="index.html">Add Your Restaurants to Our System</a>
            </div>
          
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container -->
    </nav>

    <div class="container">

        <div class="row">
            <div class="box">
                <div class="col-lg-12">
                    <hr>
                    
                    <hr>
                </div>
                <div class="col-md-6">
                    <img class="img-responsive img-border-left" src="resources/img/slide-5.jpg" alt="">
                </div>
                <div class="col-md-6">
                    <p>Welcome to your home page. Thank you for loging in to  'That's MYTable!'</p>
                    <p>You can add you restaurants to the system and help users reserve their tables online.</p>
                    <p>This is a one stop place for Restaurants to interact with their potential as well as regular clients helping them reach a broader customer base as well as helping the customers save their time by booking Restaurant tables before hand</p>
                </div>
                <div class="clearfix"></div>
            </div>
        </div>

        <div class="row">
            <div class="box">
                <div class="col-lg-12">
                    <hr>
                    <h2 class="intro-text text-center"><strong>Add your Restaurant</strong></h2>
                    <hr>
<form:form action="addRestaurant.htm" commandName="restAdd" method="post">

Please Enter your Restaurant's Name : 
<input name="restName" size="30" required/><br><br>

Please Enter your Restaurant's City:
 <input type="text" name="restCity" required/><br><br>





Please Enter your Restaurant's Zip Code: 
<input type="number" size="5" name="zipCode" required/><br><br>






<input type="submit" value="Add Restaurant">

</form:form>
<br><br>

<a href="viewRestaurant.htm">View My Restaurant</a>
                    
                </div>
                
               
               
                <div class="clearfix"></div>
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
