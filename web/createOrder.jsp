<%@page import="za.ac.tut.model.entity.StudentOrder"%>
<!--
Author:S Mazwi & T Mhlanga
-->
<!DOCTYPE html>
<html lang="en">
<head>
<title>Trace Order</title>
<!-- for-mobile-apps -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false);
		function hideURLbar(){ window.scrollTo(0,1); } </script>
<!-- //for-mobile-apps -->
<link href="css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
<link href="css/font-awesome.css" rel="stylesheet"> 
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
<!--web-fonts-->
<link href="//fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet">
<link href="//fonts.googleapis.com/css?family=Lato:300,400,700" rel="stylesheet">
<link href="//fonts.googleapis.com/css?family=Tangerine:400,700" rel="stylesheet">
<!--//web-fonts-->
</head>
<body>
<!-- banner -->
<div class="banner" id="home">
<!-- header -->
<div class="banner-top">
    <div class="social-bnr-agileits">
	<ul>
            <li><a href="#"><i class="fa fa-facebook" aria-hidden="true"></i></a></li>
            <li><a href="#"><i class="fa fa-twitter" aria-hidden="true"></i></a></li>
            <li><a href="#"><i class="fa fa-google-plus" aria-hidden="true"></i></a></li>
            <li><a href="#"><i class="fa fa-linkedin" aria-hidden="true"></i></a></li>					
	</ul>
    </div>
    <div class="contact-bnr-w3-agile">
        <ul>
            <li><i class="fa fa-envelope" aria-hidden="true"></i><a href="www.onlineCampusKiosk.co.za">onlineCampusKiosk.com</a></li>
            <li><i class="fa fa-phone" aria-hidden="true"></i>+27 83 529 3455</li>	
            <li>
    <div class="search">
	<input class="search_box" type="checkbox" id="search_box">
            <label class="icon-search" for="search_box"><span class="glyphicon glyphicon-search" aria-hidden="true"></span></label>
	<div class="search_form">
            <form action="#" method="post">
		<input type="search" name="Search" placeholder="Search..." required="" />
		<input type="submit" value="Send" />
            </form>
	</div>
    </div>
            </li>
	</ul>
</div>
<div class="clearfix"></div>
</div>
<header>
    <div class="container">

	<!-- navigation -->
<div class="w3_navigation">
        <nav class="navbar navbar-default">
		<div class="navbar-header navbar-left">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
			<span class="sr-only">Toggle navigation</span>
			<span class="icon-bar"></span>
			<span class="icon-bar"></span>
			<span class="icon-bar"></span>
                    </button>
			<div class="w3_navigation_pos">
				<h1><a href="index.html"><span>O</span>nline <span>K</span>iosk</a></h1>
			</div>
                </div>
<!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse navbar-right" id="bs-example-navbar-collapse-1">
            <nav class="menu menu--miranda">
		<ul class="nav navbar-nav menu__list">
                    <li ><a href="index.jsp" class="menu__link">Home</a></li>
                    <li ><a href="menu.jsp" class=" menu__link">Menu</a></li>
                    <li ><a href="traceOrder.jsp" class=" menu__link" class= "menu__item--current">TraceOrder</a></li>
                    <li ><a href="userLogin.jsp" class=" menu__link">Login</a></li>
                <!-- <li class="menu__item"><a href="management.html" class=" menu__link">Management</a></li>-->
                <li class="dropdown menu__item">
                    <a href="#" class="dropdown-toggle menu__link"  data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">User<span class="caret"></span></a>
		<ul class="dropdown-menu">
                    <li><a href="userLogin.jsp">Login</a></li>
                    <li><a href="signUp.jsp">SignUp</a></li>
		</ul>
		</li>
                    <li class="menu__item"><a href="contact.html" class=" menu__link">Contact</a></li>
		</ul>
            </nav>
	</div>
	</nav>	
</div>
 <%
     StudentOrder order = (StudentOrder)session.getAttribute("order");
     if(order==null){
         order = new StudentOrder();
     }
 %>
<div class="banner-text">
       <h2>FABULOUS KOTA & CHIPS AT AFFORDABLE PRICES!</h2><br> 
       
       <p>
           Makunyiwe</br></br>
           <%=order.toString() %>           
       </p>
</div>


<!-- mail -->
<div class="mail">
    <div class="mail-grid1">
	<div class="container">	
            <h3 class="tittle-w3">Contact <span>Info</span></h3>
		<div class="col-md-4 mail-agileits-w3layouts">
		<i class="glyphicon glyphicon-earphone" aria-hidden="true"></i>
		<div class="contact-right">
                    <p>Phone</p><span>+27 83 676 8890</span>
		</div>
		</div>
                <div class="col-md-4 mail-agileits-w3layouts">
		<i class="glyphicon glyphicon-envelope" aria-hidden="true"></i>
		<div class="contact-right">
                    <p>Email</p><a href="www.onlineCampusKiosk.co.za">onlineCampusKiosk.co.za</a>
		</div>
		</div>
		<div class="col-md-4 mail-agileits-w3layouts">
		<i class="glyphicon glyphicon-map-marker" aria-hidden="true"></i>
		<div class="contact-right">
                    <p>Address</p><span>M17:103, Sosh 4, TUT South Campus, Soshanguve.</span>
		</div>
		</div>
		<div class="clearfix"></div>
        </div>
    </div>
<div class="copyright-wthree">
    <p>&copy; 2017 Online Campus Kiosk . All Rights Reserved | Design by S Mazwi & T Mhlanga</p>
</div>
<!-- //Footer -->

	<a href="#home" class="scroll" id="toTop" style="display: block;"> <span id="toTopHover" style="opacity: 1;"> </span></a>
<!-- //smooth scrolling -->
<script type="text/javascript" src="js/jquery-2.1.4.min.js"></script>
<script type="text/javascript" src="js/numscroller-1.0.js"></script>
<script src="js/particles.js"></script>
<script src="js/app.js"></script>
<!--gallery-->
<script type="text/javascript">
							$(window).load(function() {
								$("#flexiselDemo1").flexisel({
									visibleItems:4,
									animationSpeed: 1000,
									autoPlay: true,
									autoPlaySpeed: 3000,    		
									pauseOnHover: true,
									enableResponsiveBreakpoints: true,
									responsiveBreakpoints: { 
										portrait: { 
											changePoint:480,
											visibleItems: 1
										}, 
										landscape: { 
											changePoint:640,
											visibleItems:2
										},
										tablet: { 
											changePoint:768,
											visibleItems: 3
										}
									}
								});
								
							});
					</script>
					<script type="text/javascript" src="js/jquery.flexisel.js"></script>

 <!-- start-smoth-scrolling -->
<script type="text/javascript" src="js/move-top.js"></script>
<script type="text/javascript" src="js/easing.js"></script>
<script type="text/javascript">
	jQuery(document).ready(function($) {
		$(".scroll").click(function(event){		
			event.preventDefault();
			$('html,body').animate({scrollTop:$(this.hash).offset().top},1000);
		});
	});
</script>
<!-- start-smoth-scrolling -->
<!-- here stars scrolling icon -->
	<script type="text/javascript">
		$(document).ready(function() {
			/*
				var defaults = {
				containerID: 'toTop', // fading element id
				containerHoverID: 'toTopHover', // fading element hover id
				scrollSpeed: 1200,
				easingType: 'linear' 
				};
			*/
								
			$().UItoTop({ easingType: 'easeOutQuart' });
								
			});
	</script>
<!-- //here ends scrolling icon -->
<!--js for bootstrap working-->
	<script src="js/bootstrap.js"></script>
<!-- //for bootstrap working -->
<!-- script-for-menu -->
					<script>					
						$("span.menu").click(function(){
							$(".top-nav ul").slideToggle("slow" , function(){
							});
						});
					</script>
					<!-- script-for-menu -->
</body>
</html>
