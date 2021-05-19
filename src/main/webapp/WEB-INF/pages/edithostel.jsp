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
				<form action="update" method="get">
					<div class="form-group">
						<label for="lblhid">Hostel id</label> <input type="text"
							class="form-control" id="lblhid" name="hostel_id"
							placeholder="Enter HOstel id" value="${param.hostel_id}" readonly/>
					</div>
					<div class="form-group">
						<label for="lblhname">Hostel Name</label> <input type="text"
							class="form-control" id="lblhname" name="hostel_name"
							placeholder="Enter Hostel Name" value="${param.hostel_name}"/>
					</div>
					<div class="form-group">
						<label for="lbladdress">Hostel Address</label> <input type="text"
							class="form-control" id="lbladdress" name="hostel_address"
							placeholder="Enter Hostel Address"  value="${param.hostel_address}"/>
					</div>
					<div class="form-group">
						<label for="lblphone">Hostel Phone Number</label> <input type="text"
							class="form-control" id="lblphone" name="phone_number"
							placeholder="Enter Phone Number" value="${param.phone_number}"/>
					</div>
					<button type="submit" value="update" class="btn btn-primary">Update Hostel</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>