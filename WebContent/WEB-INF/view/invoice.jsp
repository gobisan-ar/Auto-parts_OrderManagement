<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Invoice</title>
<link rel="stylesheet" type="text/css"
	href="http://localhost:8080/AutoParts/css/salesStyles.css">
<link rel="stylesheet" rel="stylesheet"
	href="https://maxst.icons8.com/vue-static/landings/line-awesome/line-awesome/1.3.0/css/line-awesome.min.css">
<link rel="stylesheet" type="text/css"
	href="http://localhost:8080/AutoParts/bootstrap/bootstrap-5.0.0-beta3-dist/css/bootstrap.min.css">
</head>
<body>
	<div class="container">
		<hr style="border: 10px solid black; width: 60%;">
		<div class="page-header" style="margin-left: 350px;">
			<h1>Invoice</h1>
		</div>
		<div class="container">
			<div class="row">
				<div class="col-md-6 col-md-offset-3 invoice-main">
					<div class="col-md-12">
						<div class="row">
							<div class="col-md-4 float-left">
								<img class="invoice-img" alt="logo"
									src="<%=request.getContextPath()%>/images/logoR.png" style="width: 250px;"/>
							</div>
							<div>&nbsp;</div>
							<div class="col-md-8 text-right float-right">
								<h4 style="color: #F81D2D;">
									<strong>Fozti Auto Parts</strong>
								</h4>
								<p>
									Malabe <br>
									+94 76 222 1133 <br>
									contact@fozti.lk
								</p>
							</div>
						</div>
						<br />
						<div class="row">
							<div class="col-md-12 text-center">
								<h2>INVOICE</h2>
								<h5>${invoice.invoiceID}</h5>
							</div>
						</div>
						<br />
						<div>
							<table class="table">
								<thead>
									<tr>
										<th>
											<h5>Order ID</h5>
										</th>
										<th>
											<h5>Amount</h5>
										</th>
									</tr>
								</thead>
								<tbody>
									<tr>
										<td class="col-md-9">${invoice.orderID}</td>
										<td class="col-md-3"><i class="fas fa-rupee-sign"
											area-hidden="true"></i> ${invoice.payment}</td>
									</tr>
										<td class="text-right">
											<p>
												<strong>Shipment and Taxes:</strong>
											</p>
											<p>
												<strong>Discount: </strong>
											</p>
										</td>
										<td>
											<p>
												<strong>${invoice.tax}</strong>
											</p>
											<p>
												<strong>${invoice.discount}</strong>
											</p>
										</td>
									</tr>
									<tr style="color: #F81D2D;">
										<td class="text-right">
											<h4>
												<strong>Total:</strong>
											</h4>
										</td>
										<td class="text-left">
											<h4>
												<strong>${invoice.total} </strong>
											</h4>
										</td>
									</tr>
								</tbody>
							</table>
						</div>
						<div>&nbsp;</div>
						<div>
							<div class="col-md-12">
								<p>
									<b>Date :</b> ${invoice.date}
								</p>
								<br />
								<p>
									<hr style="border: 1px dashed black; width: 25%;" />
									<b>Signature</b>
								</p>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>