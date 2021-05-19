<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Payment</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<h3>Payment</h3>
		<div class="row">
			<div class="col-md-4">
				<form action="addpayment" method="post">

					<div class="form-group">
						<label for="lblpid">Payment id</label> <input type="text"
							class="form-control" id="lblpid" name="txtpid"
							placeholder="Enter Payment id" />
					</div>
					<div class="form-group">
						<label for="lbldue">Due Date</label> <input type="date"
							class="form-control" id="lbldue" name="txtdue"
							placeholder="Enter Due Date" />
					</div>
					<div class="form-group">
						<label for="lbldate">Date of Payment</label> <input type="date"
							class="form-control" id="lbldate" name="txtdate"
							placeholder="Enter Date of Payment" />
					</div>
					<div class="form-group">
						<label for="lblrno"> Receipt Number </label> <input type="text"
							class="form-control" id="lblrno" name="txtrno"
							placeholder="Enter Receipt Number" />
					</div>

					<button type="submit" class="btn btn-primary">Add Payment</button>
				</form>
			</div>

		</div>

	</div>
</body>
</html>