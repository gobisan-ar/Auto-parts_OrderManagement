<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1, minimum-scale=1">

<title>Shipped Orders</title>

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
				<a href="<%=request.getContextPath()%>/shippedOrder"><h1>Shipped
						Orders</h1></a> <small>Track shipped orders</small>
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
							<th><div>Delivery ADRS</div></th>
							<th><div>Payment</div></th>
							<th><div>Shipper ID</div></th>
							<th><div>Shipped Date</div></th>
							<th><div class="btn-table">Action</div></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="myOrder" items="${shippedOrder}">
							<tr>
								<td><div>
										<span class="indicator"></span>
									</div></td>
								<td><div>${myOrder.orderID}</div></td>
								<td><div>${myOrder.customerID}</div></td>
								<td><div>${myOrder.deliveryAddress}</div></td>
								<td><div>${myOrder.payment}</div></td>
								<td><div>${myOrder.shipperID}</div></td>
								<td><div>${myOrder.shippedDate}</div></td>


								<td class="last-col">
									<div class="btn-table">
										<a href="<%=request.getContextPath()%>/generateInvoice?orderID=${myOrder.orderID}&payment=${myOrder.payment}&date=${myOrder.shippedDate}">
											<button>
												<span class="las la-money-check"> Invoice</span>
											</button>
										</a> <input type="hidden" id="orderid" value="${myOrder.orderID}">
										<input type="hidden" id="orderStatus"
											value="${myOrder.customerID}"> <input type="hidden"
											id="statusReason" value="${myOrder.deliveryAddress}">
										<input type="hidden" id="shipperid"
											value="${myOrder.shipperID}">
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

	<script type="text/javascript"
		src="http://localhost:8080/AutoParts/js/myScript.js"></script>
</body>
</html>