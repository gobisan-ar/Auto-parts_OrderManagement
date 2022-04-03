<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<label for="sidebar-toggle" class="body-label"></label>
<input type="checkbox" name="" id="sidebar-toggle">


<div class="sidebar">
	<div class="sidebar-brand">
		<div class="brand-flex">
			<img src="<%=request.getContextPath()%>/images/logoW.png" width="150px"
				alt="logo">

			<div class="brand-icons">
				<a href="<%=request.getContextPath()%>/logout" style="text-decoration: none; color: red; font-weight: bold">
					<span class="la la-sign-out"></span>
				</a>
				
			</div>
		</div>
	</div>

	<div class="sidebar-main">
		<div class="sidebar-user">
			<img src="<%=request.getContextPath()%>/images/profile.png"
				alt="profile-pic">
			<div>&nbsp;</div>
			<div>
				<h3>Gobisan</h3>
				<span>Sales Manager</span>
			</div>
		</div>
		<div class="sidebar-menu">
			<div class="menu-head">
				<span>Dashboard</span>
			</div>
			<ul>
				<li><a href="<%=request.getContextPath()%>/analyticsReport"> <span
						class="las la-chart-line"></span> Analytics
				</a></li>
			</ul>

			<div class="menu-head">
				<span>Orders</span>
			</div>
			<ul>
				<li><a href="<%=request.getContextPath()%>/listOrder"> <span
						class="las la-box"></span> All Orders
				</a></li>
				<li><a href="<%=request.getContextPath()%>/newOrder"> <span
						class="las la-bell"></span> New Orders
				</a></li>
				<li><a href="<%=request.getContextPath()%>/pendingOrder"> <span class="las la-hourglass"></span>
						Pending Orders
				</a></li>
				<li><a href="<%=request.getContextPath()%>/shippedOrder"> <span class="las la-truck"></span> Shipped
						Orders
				</a></li>
			</ul>
			<div class="menu-head">
				<span>Shipment</span>
			</div>
			<ul>
				<li><a href="<%=request.getContextPath()%>/listZone"> <span class="las la-map-marker"></span>
						Delivery Zones
				</a></li>
				<li><a href="<%=request.getContextPath()%>/listStaff"> <span class="las la-person-booth"></span>
						Delivery Staffs
				</a></li>
			</ul>
		</div>
	</div>
</div>

<div class="main-content">
	<header>
		<div class="menu-toggle">
			<label for="sidebar-toggle"> <span class="las la-bars"></span>
			</label>
		</div>

		<div class="page-path">
			<small>Fozti Auto Parts - Sales Management</small>
		</div>

		<div class="search-container">
			<form action="/action_page.php">
				<input type="text" placeholder="Search.." name="search">
				<button type="submit">
					<i class="las la-search"></i>
				</button>
			</form>
		</div>
	</header>
