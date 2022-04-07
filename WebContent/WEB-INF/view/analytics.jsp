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
				<h1>Analytics Dashboard</h1>
				<small>Monitor key metrics. Check reporting and revieew
					insights</small>
			</div>

			<!--  
			<div class="header-actions">
				<button>
					<span class="las la-file-export"></span> Export
				</button>
				<button>
					<span class="las la-tools"></span> Settings
				</button>
			</div>
			-->
		</div>

		<div class="cards">
			<div class="card-single">
				<div class="card-flex">
					<div class="card-info">
						<div class="card-head">
							<span>Sales</span> <small>Value of Total Sales</small>
						</div>

						<h2>LKR. ${report.sale}</h2>

						<small>2% more sales</small>
					</div>
					<div class="card-chart success">
						<span class="las la-chart-line"></span>
					</div>
				</div>
			</div>
			
			<div class="card-single">
				<div class="card-flex">
					<div class="card-info">
						<div class="card-head">
							<span>Shippings</span> <small>Total Number of shippings</small>
						</div>

						<h2>${report.ship}</h2>

						<small>23% less shippings</small>
					</div>
					<div class="card-chart danger">
						<span class="las la-chart-line"></span>
					</div>
				</div>
			</div>

			<div class="card-single">
				<div class="card-flex">
					<div class="card-info">
						<div class="card-head">
							<span>Shipping Budget</span> <small>Highest Shipping Zone Budget</small>
						</div>

						<h2>LKR.<br/>${report.budget}</h2>

						<small>${report.zone}</small>
					</div>
					<div class="card-chart neutral">
						<span class="las la-chart-line"></span>
					</div>
				</div>
			</div>
		</div>

		<div class="jobs-grid">
			<div class="analytics-card">
				<div class="analytics-head">
					<h3>Shipping Percentage</h3>

					<span class="las la-ellipse-h"></span>
				</div>

				<div class="analytics-chart">
					<div class="chart-circle">
						<h1>${report.shipPct}%</h1>
					</div>

					<div class="analytics-note">
						<small>Note: Need to enhance supplychain operations</small>
					</div>
				</div>

				<div>&nbsp;</div>

				<div class="analytics-btn">
					<a href="<%=request.getContextPath()%>/pendingOrder" style="text-decoration: none">
						<button>View Pending Orders</button>
					</a>
				</div>
			</div>

			<div class="jobs">
				<h2>
					New Orders <a href="<%=request.getContextPath()%>/newOrder"> <small>See all new orders <span
							class="las la-arrow-right"></span>
					</small>
					</a>
				</h2>

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
						<c:forEach var="myOrder" items="${report.newOrder}">
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
										<a href="<%=request.getContextPath()%>/newOrder"><button>
											<span class="las la-arrow-right"> Handle</span>
										</button></a>
									</div>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				</div>
			</div>
		</div>
	</main>
	</div>
	<script type="text/javascript"
		src="http://localhost:8080/AutoParts/js/myScript.js"></script>
</body>
</html>