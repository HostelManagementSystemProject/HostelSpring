<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>PaymentList</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
</head>
<body>
	Added Successfully ${msg}
	<div class="container">
		<form action="signuppayment" method="get">

			<div class="form-group">
				<label for="lblpid">Payment id</label> <input type="text"
					class="form-control" id="lblpid" name="txtpid"
					placeholder="Enter Payment id" />
			</div>
			<button type="submit" class="btn btn-primary">Payment List</button>
		</form>
	</div>
</body>
</html>