<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Hostel</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<h3>Hostel</h3>
		<div class="row">
			<div class="col-md-4">
				<form action="addhostel" method="post">

					<div class="form-group">
						<label for="lblhid">Hostel id</label> <input type="text"
							class="form-control" id="lblhid" name="txthid"
							placeholder="Enter Hostel id" />
					</div>
					<div class="form-group">
						<label for="lblhname">Hostel Name</label> <input type="text"
							class="form-control" id="lblhname" name="txthname"
							placeholder="Enter Hostel Name" />
					</div>
					<div class="form-group">
						<label for="lbladdress">Hostel Address</label> <input type="text"
							class="form-control" id="lbladdress" name="txtaddress"
							placeholder="Enter Hostel Address" />
					</div>
					<div class="form-group">
						<label for="lblphone"> Hostel Phone Number</label> <input type="text"
							class="form-control" id="lblphone" name="txtphone"
							placeholder="Enter Phone Number" />
					</div>

					<button type="submit" class="btn btn-primary">Add Hostel</button>
				</form>
			</div>

		</div>

	</div>
</body>
</html>