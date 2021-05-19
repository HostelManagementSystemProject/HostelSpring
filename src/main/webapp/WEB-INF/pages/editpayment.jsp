<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
</head>
<body>
Edit page
	<div class="container">
		<h3>Edit Details Here</h3>
		<div class="row">
			<div class="col-md-4">
				<form action="updatepayment" method="get">
					<div class="form-group">
						<label for="lblpid">Payment id</label> <input type="text"
							class="form-control" id="lblpid" name="payment_id"
							placeholder="Enter Payment id" value="${param.payment_id}" readonly/>
					</div>
					<div class="form-group">
						<label for="lbldue">Due date</label> <input type="date"
							class="form-control" id="lbldue" name="due_date"
							placeholder="Enter Due Date" value="${param.due_date}"/>
					</div>
					<div class="form-group">
						<label for="lbldate">Date of payment</label> <input type="date"
							class="form-control" id="lbldate" name="date_of_payment"
							placeholder="Enter date of Payment"  value="${param.date_of_payment}"/>
					</div>
					<div class="form-group">
						<label for="lblphone">Receipt Number</label> <input type="text"
							class="form-control" id="lblrno" name="receipt_no"
							placeholder="Enter Receipt Number" value="${param.receipt_no}"/>
					</div>
					<button type="submit" value="updatepayment" class="btn btn-primary">Update Payment</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>