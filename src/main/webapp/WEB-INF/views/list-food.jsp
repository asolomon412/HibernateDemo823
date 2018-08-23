<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Foods</title>
<!-- Link the bootstrap CSS -->
<!-- Or in this case, a variation theme... -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootswatch/4.1.3/sketchy/bootstrap.min.css" />
<!-- Custom CSS goes below Bootstrap CSS -->
<link rel="stylesheet" href="/style.css" />
</head>
<body>
	<!-- With boostrap, pages should generally be surrounded with a container element. -->
	<div class="container">
		<h1>Foods</h1>
		
		<form class="form-inline" action="/food" autocomplete="off">
		  <label class="sr-only" for="keyword">Keyword</label>
		   ******Fix this!
		  
		  <label class="sr-only" for="category">Category</label>
		  <select class="form-control mb-2 mr-sm-2" id="category" name="category"> <!-- // -->
		  	<option value="">Category</option>
          ******Fix this!
		</form>
		
		<table class="table">
			<thead>
			<tr>
				<th>Food</th><th>Category</th><th>Description</th><th>Action</th>
			</tr>
			</thead>
             ******Fix this!
		</table>
		
		 ******Fix this! Add button
	</div>
</body>
</html>