<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1, minimum-scale=1">

<title>All Orders</title>

<link rel="stylesheet" type="text/css"
	href="http://localhost:8080/AutoParts/css/salesStyles.css">
<link rel="stylesheet" rel="stylesheet"
	href="https://maxst.icons8.com/vue-static/landings/line-awesome/line-awesome/1.3.0/css/line-awesome.min.css">
<link rel="stylesheet" type="text/css"
	href="http://localhost:8080/AutoParts/bootstrap/bootstrap-5.0.0-beta3-dist/css/bootstrap.min.css">

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.1/jquery.validate.min.js"></script>
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
				<a href="<%=request.getContextPath()%>/pendingOrder"><h1>Pending
						orders</h1></a> <small>Manage pending orders</small>
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
							<th><div>Order ID</div></th>
							<th><div>Customer ID</div></th>
							<th><div>Pending Reason</div></th>
							<th><div class="btn-table">Action</div></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="myOrder" items="${pendingOrder}">
							<tr>
								<td><div>
										<span class="indicator"></span>
									</div></td>
								<td><div>${myOrder.orderID}</div></td>
								<td><div>${myOrder.customerID}</div></td>
								<td><div>${myOrder.reason}</div></td>

								<td class="last-col">
									<div class="btn-table">
										<button class="acceptOrder" data-toggle="modal"
											data-target="#acceptOrder">
											<span class="las la-check"> Accept</span>
										</button>

										<button class="deleteOrder" data-toggle="modal"
											data-target="#deleteOrder">
											<span class="la la-close"> Reject</span>
										</button>

										<input type="hidden" id="oid" value="${myOrder.orderID}">
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

	<!--Accept Modal start-->
	<div class="modal fade" id="acceptOrder" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<form method="get"
					action="<%=request.getContextPath()%>/acceptOrder">
					<div class="modal-header">
						<h5 class="modal-title" id="exampleModalLabel">Are you sure?</h5>
					</div>
					<div class="modal-body">Are you sure you want to accept this
						order?</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary"
							data-dismiss="modal">Cancel</button>
						<button type="sub" class="btn btn-primary" id="orderAccept">Accept</button>
						<input type="hidden" name="oid" id="oid">
					</div>
				</form>
			</div>
		</div>
	</div>
	<!-- Accept Modal End -->
	
	<!-- Delete Modal Start-->
	<div class="modal fade" id="deleteOrder" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<form method="get"
					action="<%=request.getContextPath()%>/deleteOrder">
					<div class="modal-header">
						<h5 class="modal-title" id="exampleModalLabel">Are you sure?</h5>
					</div>
					<div class="modal-body">Are you sure you want to reject this
						order?</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary"
							data-dismiss="modal">Cancel</button>
						<button type="sub" class="btn btn-danger" id="orderDelete">Reject</button>
						<input type="hidden" name="oid" id="oid">
					</div>
				</form>
			</div>
		</div>
	</div>
	<!-- Delete Modal End -->


	<script type="text/javascript"
		src="http://localhost:8080/AutoParts/js/myScript.js"></script>
</body>
</html>