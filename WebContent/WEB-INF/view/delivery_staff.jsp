<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1, minimum-scale=1">

<title>Delivery Staff</title>

<!-- Bootstrap CSS -->
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/bootstrap/css/bootstrap.min.css">
	
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/salesStyles.css">
	
<link rel="stylesheet" rel="stylesheet"
	href="https://maxst.icons8.com/vue-static/landings/line-awesome/line-awesome/1.3.0/css/line-awesome.min.css">

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.1/jquery.validate.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js"></script>
</head>
<body>
	<jsp:include page="/partials/_sidebar.jsp" />

	<main>
		<div class="page-header">
			<div>
				<a href="<%=request.getContextPath()%>/listStaff"><h1>Delivery
						Staffs</h1></a> <small>Manage delivery staffs</small>
			</div>

			<div class="header-actions">
				<button data-toggle="modal" data-target="#addStaff">
					<span class="las la-plus"></span> Register Delivery Staff
				</button>
			</div>
		</div>

		<div>&nbsp;</div>

		<div class="jobs">
			<div class="table-responsive">
				<table width="100%">
					<thead>
						<tr>
							<th><div>
									<span class="indicator"></span>
								</div></th>
							<th><div>Staff ID</div></th>
							<th><div>First Name</div></th>
							<th><div>Last Name</div></th>
							<th><div>NIC</div></th>
							<th><div>Email</div></th>
							<th><div>Mobile</div></th>
							<th><div>Status</div></th>
							<th><div class="btn-table">Action</div></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="myStaff" items="${staffList}">
							<tr>
								<td><div>
										<span class="indicator"></span>
									</div></td>
								<td><div>${myStaff.staffID}</div></td>
								<td><div>${myStaff.firstname}</div></td>
								<td><div>${myStaff.lastname}</div></td>
								<td><div>${myStaff.nic}</div></td>
								<td><div>${myStaff.email}</div></td>
								<td><div>${myStaff.mobile}</div></td>
								<td><div>${myStaff.status}</div></td>
								<td class="last-col">
									<div class="btn-table">
										<button class="updateStaff" data-toggle="modal"
											data-target="#updateStaff">
											</span> Update
										</button>
										<button class="deleteStaff" data-toggle="modal"
											data-target="#deleteStaff">Delete</button>

										<input type="hidden" id="sid" value="${myStaff.staffID}">
										<input type="hidden" id="fname" value="${myStaff.firstname}">
										<input type="hidden" id="lname" value="${myStaff.lastname}">
										<input type="hidden" id="nic" value="${myStaff.nic}">
										<input type="hidden" id="email" value="${myStaff.email}">
										<input type="hidden" id="mobile" value="${myStaff.mobile}">
										<input type="hidden" id="status" value="${myStaff.status}">
									</div>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</main>
	</div>

	<!--Create Modal start-->
	<div class="modal fade" id="addStaff" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Register
						Delivery Staff</h5>
				</div>
				<div class="modal-body">
					<form action="insertStaff" method="post" name="staffForm" id="#staffForm">
						<div class="form-group">
							<label for="exampleFormControlInput1">First name</label> <input
								type="text" class="form-control" id="fname"
								name="fname" placeholder="first name" >
						</div>
						<div>&nbsp;</div>

						<div class="form-group">
							<label for="exampleFormControlInput1">Last name</label> <input
								type="text" class="form-control" id="lname"
								name="lname" placeholder="last name" >
						</div>
						<div>&nbsp;</div>

						<div class="form-group">
							<label for="exampleFormControlInput1">NIC</label> <input
								type="text" class="form-control" id="nic"
								name="nic" placeholder="991112223V" >
						</div>
						<div>&nbsp;</div>

						<div class="form-group">
							<label for="exampleFormControlInput1">Work Email</label> <input
								type="text" class="form-control" id="email"
								name="email" placeholder="example@fozti.lk" >
						</div>
						<div>&nbsp;</div>

						<div class="form-group">
							<label for="exampleFormControlInput1">Work Mobile</label> <input
								type="text" class="form-control" id="mobile"
								name="mobile" placeholder="0771112223" >
						</div>
						<div>&nbsp;</div>

						<div class="modal-footer">
							<button type="button" class="btn btn-secondary"
								data-dismiss="modal">Cancel</button>
							<button type="submit" class="btn btn-local">Register
								Staff</button>
						</div>
					</form>
				</div>

			</div>
		</div>
	</div>
	<!--Create Modal end-->

	<!--Update Modal start-->
	<div class="modal fade" id="updateStaff" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Update Staff
						Details</h5>
				</div>
				<div class="modal-body">
					<form action="updateStaff" method="get" id="#staffForm">
						<div class="form-group">
							<label for="exampleFormControlInput1">Staff ID</label> <input
								type="text" class="form-control" id="sid" placeholder="Staff ID"
								name="sid"  readonly>
						</div>
						<div>&nbsp;</div>

						<div class="form-group">
							<label for="exampleFormControlInput1">First name</label> <input
								type="text" class="form-control" id="fname"
								placeholder="first name" name="fname">
						</div>
						<div>&nbsp;</div>

						<div class="form-group">
							<label for="exampleFormControlInput1">Last name</label> <input
								type="text" class="form-control" id="lname"
								placeholder="last name" name="lname">
						</div>
						<div>&nbsp;</div>

						<div class="form-group">
							<label for="exampleFormControlInput1">NIC</label> <input
								type="text" class="form-control" id="nic" placeholder="nic"
								name="nic">
						</div>
						<div>&nbsp;</div>

						<div class="form-group">
							<label for="exampleFormControlInput1">Work Email</label> <input
								type="text" class="form-control" id="email" placeholder="email"
								name="email">
						</div>
						<div>&nbsp;</div>

						<div class="form-group">
							<label for="exampleFormControlInput1">Work Mobile</label> <input
								type="text" class="form-control" id="mobile"
								placeholder="mobile" name="mobile">
						</div>
						<div>&nbsp;</div>

						<div class="form-group">
							<label for="exampleFormControlInput1">Status</label> <input
								type="text" class="form-control" id="status"
								placeholder="mobile" name="status"
								readonly="readonly">
						</div>
						<div>&nbsp;</div>

						<div class="modal-footer">
							<button type="button" class="btn btn-secondary"
								data-dismiss="modal">Cancel</button>
							<button type="submit" class="btn btn-local">Update</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	<!--Update Modal end-->

	<!-- Delete Modal Start-->
	<div class="modal fade" id="deleteStaff" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<form method="get"
					action="<%=request.getContextPath()%>/deleteStaff">
					<div class="modal-header">
						<h5 class="modal-title" id="exampleModalLabel">Are you sure?</h5>
					</div>
					<div class="modal-body">Are you sure you want to delete this
						record?</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary"
							data-dismiss="modal">Close</button>
						<button type="sub" class="btn btn-danger" id="staffDelete">Delete</button>
						<input type="hidden" name="sid" id="sid">
					</div>
				</form>
			</div>
		</div>
	</div>
	<!-- Delete Modal End -->
	
	<script type="text/javascript" src="http://localhost:8080/AutoParts/js/myScript.js"></script>
</body>
</html>