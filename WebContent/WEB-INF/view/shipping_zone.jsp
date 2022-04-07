<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1, minimum-scale=1">
<title>Shipping Zone</title>

<!-- Bootstrap CSS -->
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/bootstrap/css/bootstrap.min.css">
	
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/salesStyles.css">
	
<link rel="stylesheet" rel="stylesheet"
	href="https://maxst.icons8.com/vue-static/landings/line-awesome/line-awesome/1.3.0/css/line-awesome.min.css">
	
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
	integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js"
	integrity="sha384-vFJXuSJphROIrBnz7yo7oB41mKfc8JzQZiCq4NCceLEaO4IHwicKwpJf9c9IpFgh"
	crossorigin="anonymous"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js"
	integrity="sha384-alpBpkh1PFOepccYVYDB4do5UnbKysX5WZXm3XxPqe5iKTfUKjNkCk9SaVuEZflJ"
	crossorigin="anonymous"></script>
</head>
<body>
	<jsp:include page="/partials/_sidebar.jsp" />

	<main>
		<div class="page-header">
			<div>
				<a href="<%=request.getContextPath()%>/listZone"><h1>Delivery
						Zones</h1></a> <small>Manage delivery zone geography and rates</small>
			</div>

			<div class="header-actions">
				<button data-toggle="modal" data-target="#addZone">
					<span class="las la-plus"></span> Create Delivery Zone
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
							<th><div>Zone ID</div></th>
							<th><div>Name</div></th>
							<th><div>Area</div></th>
							<th><div>Budget</div></th>
							<th><div class="btn-table">Action</div></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="myZone" items="${zoneList}">
							<tr>
								<td><div>
										<span class="indicator"></span>
									</div></td>
								<td><div>${myZone.zoneID}</div></td>
								<td><div>${myZone.name}</div></td>
								<td><div>${myZone.area}</div></td>
								<td><div>${myZone.budget}</div></td>
								<td class="last-col">
									<div class="btn-table">
										<button class="updateZone" data-toggle="modal" data-target="#updateZone"><span class="la la-arrow-circle-up"></span> Update</button>
										<button class="deleteZone" data-toggle="modal" data-target="#deleteZone"><span class="la la-remove"></span> Delete</button>
										
										<input type="hidden" id="zid" value="${myZone.zoneID}">
										<input type="hidden" id="name" value="${myZone.name}">
										<input type="hidden" id="area" value="${myZone.area}">
										<input type="hidden" id="budget" value="${myZone.budget}">
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
	<div class="modal fade" id="addZone" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Create Delivery
						Zone</h5>
				</div>
				<div class="modal-body">
					<form action="insertZone" method="post">
						<div class="form-group">
							<label for="exampleFormControlInput1">Zone name</label> <input
								type="text" class="form-control" id="exampleFormControlInput1"
								placeholder="Zone name" name="name" required="required">
						</div>
						<div>&nbsp;</div>

						<div class="form-group">
							<label for="exampleFormControlInput1">Area Covered (SQ
								KM)</label> <input type="text" class="form-control"
								id="exampleFormControlInput1" placeholder="1.5" name="area">
						</div>
						<div>&nbsp;</div>

						<div class="form-group">
							<label for="exampleFormControlInput1">Budget (LKR)</label> <input
								type="text" class="form-control" id="exampleFormControlInput1"
								placeholder="250000" name="budget">
						</div>
						<div>&nbsp;</div>

						<div class="modal-footer">
							<button type="button" class="btn btn-secondary"
								data-dismiss="modal">Cancel</button>
							<button type="submit" class="btn btn-local">Create Zone</button>
						</div>
					</form>
				</div>

			</div>
		</div>
	</div>
	<!--Create Modal end-->
	
	<!--Update Modal start-->
	<div class="modal fade" id="updateZone" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Update Delivery
						Zone</h5>
				</div>
				<div class="modal-body">
					<form action="updateZone" method="get">
						<div class="form-group">
							<label for="exampleFormControlInput1">Zone ID</label> <input
								type="text" class="form-control" id="zid"
								placeholder="Zone ID" name="zid" required="required" readonly>
						</div>
						<div>&nbsp;</div>
						
						<div class="form-group">
							<label for="exampleFormControlInput1">Zone name</label> <input
								type="text" class="form-control" id="name"
								placeholder="Zone name" name="name" required="required">
						</div>
						<div>&nbsp;</div>

						<div class="form-group">
							<label for="exampleFormControlInput1">Area Covered (SQ
								KM)</label> <input type="text" class="form-control"
								id="area" placeholder="1.5" name="area">
						</div>
						<div>&nbsp;</div>

						<div class="form-group">
							<label for="exampleFormControlInput1">Budget (LKR)</label> <input
								type="text" class="form-control" id="budget"
								placeholder="250000" name="budget">
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
	<div class="modal fade" id="deleteZone" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
			<form method="get" action="deleteZone">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Are you sure?</h5>
				</div>
				<div class="modal-body">Are you sure you want to delete this
					record?</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal">Close</button>
					<button type="sub" class="btn btn-danger" id="zoneDelete">Delete</button>
					<input type="hidden" name="zid" id="zid">
				</div>
			</form>
			</div>
		</div>
	</div>
	<!-- Delete Modal End -->
	
	<script type="text/javascript" src="http://localhost:8080/AutoParts/js/myScript.js"></script>
</body>
</html>