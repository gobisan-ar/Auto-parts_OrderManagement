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
	href="<%=request.getContextPath()%>/css/salesStyles.css">
<link rel="stylesheet" rel="stylesheet"
	href="https://maxst.icons8.com/vue-static/landings/line-awesome/line-awesome/1.3.0/css/line-awesome.min.css">
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/bootstrap/css/bootstrap.min.css">

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
				<a href="<%=request.getContextPath()%>/listOrder"><h1>Customer
						orders</h1></a> <small> Manage customer orders</small>
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
								</div>
							</th>
							<th><div>Order ID</div></th>
							<th><div>Customer ID</div></th>
							<th><div>Status</div></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="myOrder" items="${orderList}">
							<tr>
								<td><div>
										<span class="indicator"></span>
									</div></td>
								<td><div>${myOrder.orderID}</div></td>
								<td><div>${myOrder.customerID}</div></td>
								<c:choose>
    								<c:when test="${myOrder.orderStatus == 'shipped'}">
        								<td><div style="color: green ">${myOrder.orderStatus}</div></td>. 
    								</c:when>   
    								<c:when test="${myOrder.orderStatus == 'pending'}">
        								<td><div style="color: orange ">${myOrder.orderStatus}</div></td>. 
    								</c:when>  
    								<c:when test="${myOrder.orderStatus == 'new'}">
        								<td><div style="color: red ">${myOrder.orderStatus}</div></td>. 
    								</c:when> 
    								<c:otherwise>
        								<td><div>${myOrder.orderStatus}</div></td> 
    								</c:otherwise>
								</c:choose>
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
					<form action="shipOrder" method="get" id="#shipOrder">
						<div class="form-group">
							<label for="exampleFormControlInput1">Order ID</label> <input
								type="text" class="form-control" id="orderid"
								placeholder="Order ID" name="orderid" readonly>
						</div>
						<div>&nbsp;</div>

						<div class="form-group">
							<label for="exampleFormControlInput1">Shipper ID</label> <select
								type="text" class="form-control" id="shipperid"
								placeholder="shipper id" name="shipperid">
								<option value="na" selected="selected">NA</option>
								<option value="saab">2501</option>
								<option value="mercedes">2502</option>
								<option value="audi">2503</option>
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
					<form action="shipOrder" method="get" id="#shipOrder">
						<div class="form-group">
							<label for="exampleFormControlInput1">Order ID</label> <input
								type="text" class="form-control" id="orderid"
								placeholder="Order ID" name="orderid" readonly>
						</div>
						<div>&nbsp;</div>

						<div class="form-group">
							<label for="exampleFormControlInput1">Pending Reason</label> <select
								type="text" class="form-control" id="shipperid"
								placeholder="shipper id" name="shipperid">
								<option value="na">NA</option>
								<option value="ipay">Incomplete Payment</option>
								<option value="istock">Stock Unavailable</option>
								<option value="other">other</option>
							</select>
						</div>
						<div>&nbsp;</div>

						<div class="modal-footer">
							<button type="button" class="btn btn-secondary"
								data-dismiss="modal">Cancel</button>
							<button type="submit" class="btn btn-local">Set Status</button>
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