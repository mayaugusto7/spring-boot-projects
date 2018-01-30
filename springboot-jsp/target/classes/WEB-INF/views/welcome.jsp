<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
<head>
 	<meta charset="UTF-8">
<!-- 	<link rel="stylesheet" href="/webjars/bootstrap/3.3.7-1/css/bootstrap.min.css" /> -->
	<link rel="stylesheet" href="/webjars/Semantic-UI/2.2.10/semantic.min.css" />
	
	<c:url value="/css/main.css" var="jstlCss"/>
	<link href="${jstlCss}" rel="stylesheet" />          
	
</head>

<body>

		<div class="ui pointing menu">
		  <a class="active item">
		    Home
		  </a>
		  <a class="item">
		    Messages
		  </a>
		  <a class="item">
		    Friends
		  </a>
		  <div class="right menu">
		    <div class="item">
		      <div class="ui transparent icon input">
		        <input type="text" placeholder="Search...">
		        <i class="search link icon"></i>
		      </div>
		    </div>
		  </div>
		</div>
	
<!-- 	<nav class="navbar navbar-inverse">
		<div class="container">
			<div class="navbar-header">
				<a href="#" class="navbar-brand">Spring Boots</a>
			</div>
		</div>
		<div id="navbar" class="collapse navbar-collapse">
			<ul class="nav navbar-nav">
				<li class="active"><a href="#">Home</a></li>
				<li><a href="#about">About</a></li>
			</ul>
		</div>
	</nav> -->
	
	<div class="ui container">
		<div class="starter-template">
			<h1>Spring Boot Web JSP Example</h1>
			<h2>Message: ${message}</h2>
		</div>
		<br/>
		<div>
			<button class="ui primary basic button">Primary</button>
			<button class="ui secondary basic button">Secondary</button>
			<button class="ui positive basic button">Positive</button>
			<button class="ui negative basic button">Negative</button>
		</div>
	</div>
	
<!-- 	<script type="text/javascript" src="/webjars/bootstrap/3.3.7-1/js/bootstrap.min.js"></script> -->
	<script type="text/javascript" src="/webjars/Semantic-UI/2.2.10/semantic.min.js"></script>
	<script type="text/javascript" src="/webjars/jquery/3.1.1/jquery.min.js"></script>
</body>
</html>