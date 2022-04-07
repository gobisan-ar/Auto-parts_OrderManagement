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

<!-- Bootstrap CSS -->
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/bootstrap/css/bootstrap.min.css">
	
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/salesStyles.css">

<link rel="stylesheet" rel="stylesheet"
	href="https://maxst.icons8.com/vue-static/landings/line-awesome/line-awesome/1.3.0/css/line-awesome.min.css">

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
				<a href="<%=request.getContextPath()%>/pendingOrder"><h1>New Orders
				</h1></a> <small>Handle new orders</small>
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
							<th><div>Payment Status</div></th>
							<th><div>Stock Status</div></th>
							<th><div class="btn-table">Action</div></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="myOrder" items="${newOrder}">
							<tr>
								<td><div>
										<span class="indicator"></span>
									</div></td>
								<td><div>${myOrder.orderID}</div></td>
								<td><div>${myOrder.customerID}</div></td>
								<td><div>${myOrder.paymentStatus}</div></td>
								<td><div>${myOrder.stockStatus}</div></td>

								<td class="last-col">
									<div class="btn-table">
										<button class="shipOrder" data-toggle="modal"
											data-target="#shipOrder">
											<span class="las la-truck"> Ship</span>
										</button>

										<button class="holdOrder" data-toggle="modal"
											data-target="#holdOrder">
											<span class="las la-hourglass"> Hold</span>
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

	<!--Ship Modal start-->
	<div class="modal fade" id="shipOrder" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Assign Shipper</h5>
				</div>
				<div class="modal-body">
					<form action="shipOrder" method="get" id="shipOrder">
						<div class="form-group">
							<label for="exampleFormControlInput1">Order ID</label> <input
								type="text" class="form-control" id="oid"
								placeholder="Order ID" name="oid" readonly>
						</div>
						<div>&nbsp;</div>

						<div class="form-group">
							<label for="exampleFormControlInput1">Shipper ID</label> <select
								type="text" class="form-control" id="sid"
								placeholder="shipper id" name="sid">
								<option value="na" selected="selected">NA</option>
								<option value="2500">2500</option>
								<option value="2501">2501</option>
								<option value="2502">2502</option>
								<option value="2503">2503</option>
								<option value="2504">2504</option>
								<option value="2505">2505</option>
							</select>
						</div>
						<div>&nbsp;</div>

						<div class="modal-footer">
							<button type="button" class="btn btn-secondary"
								data-dismiss="modal">Cancel</button>
							<button type="submit" class="btn btn-local">Assign</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	<!--Ship Modal end-->
	
	<!--Hold Modal start-->
	<div class="modal fade" id="holdOrder" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Assign Shipper</h5>
				</div>
				<div class="modal-body">
					<form action="holdOrder" method="get" id="holdOrder">
						<div class="form-group">
							<label for="exampleFormControlInput1">Order ID</label> <input
								type="text" class="form-control" id="oid"
								placeholder="Order ID" name="oid" readonly>
						</div>
						<div>&nbsp;</div>
						
						<div class="form-group">
							<label for="exampleFormControlInput1">Pending Reason</label> <input
								type="text" class="form-control" id="preason"
								placeholder="peding reason" name="preason" list="reason">
							<datalist id="reason">
								<option>NA</option>
								<option>Out of Stock</option>
								<option>Incomplete Payment</option>
								<option>Shipper Un-available</option>
							</datalist>
						</div>
						<div>&nbsp;</div>
						

						<div class="modal-footer">
							<button type="button" class="btn btn-secondary"
								data-dismiss="modal">Cancel</button>
							<button type="submit" class="btn btn-local">Hold</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	<!--Hold Modal end-->


	<script type="text/javascript"
		src="http://localhost:8080/AutoParts/js/myScript.js"></script>
</body>
</html>