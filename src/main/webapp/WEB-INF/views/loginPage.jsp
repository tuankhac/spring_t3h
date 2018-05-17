<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><spring:message code="title_login">
	</spring:message></title>
<meta
	content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no'
	name='viewport'>
<link href="assets/bootstrap/css/bootstrap.min.css" rel="stylesheet"
	type="text/css" />
<link href="assets/bootstrap/lte/css/AdminLTE.min.css" rel="stylesheet"
	type="text/css" />
<link href="assets/bootstrap/lte/css/skins/skin-blue-light.min.css"
	rel="stylesheet" type="text/css" />
<link
	href="assets/bootstrap/plugins/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" type="text/css" />
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
        <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->

<link rel="stylesheet" href="assets/bootstrap/plugins/icomoon/style.css">
</head>

<script src="assets/bootstrap/plugins/jQuery/jQuery-2.1.4.min.js"></script>
<script src="assets/bootstrap/js/bootstrap.min.js"
	type="text/javascript"></script>
<script src="assets/bootstrap/plugins/chartjs/Chart.min.js"
	type="text/javascript"></script>
</head>

<body class="login-page">
	<div class="login-box">

		<div class="login-logo">
			<a
				href="http://ichef-1.bbci.co.uk/news/660/cpsprodpb/17A21/production/_85310869_85310700.jpg"><img
				src="https://www.google.com/images/icons/material/product/1x/analytics_64dp.png"
				alt="My Ad Cubes"></a>
		</div>
		<!-- /.login-logo -->
		<div class="login-box-body">
			<p class="login-box-msg">
				<b>Sign in to System</b>
			</p>
			<form name="f"
				action="${pageContext.request.contextPath}/j_spring_security_check"
				method='POST'>
				<div class="form-group has-feedback">
					<input type="text" class="form-control input-lg"
						placeholder="User name" name="username" id="username" /> <span
						class="glyphicon glyphicon-user form-control-feedback"></span> <a
						href="javascript:sendotp()"> <font
						style="font-size: 9px; font-color: darkblue; text-decoration: none">${n.i18n.app_name_get_otp}</font></a>
				</div>
				<div class="form-group has-feedback">
					<input type="password" class="form-control input-lg"
						placeholder="Password" name="password" /> <span
						class="glyphicon glyphicon-lock form-control-feedback"></span>
				</div>
				<div class="row">
					<div class="col-xs-8">
						<!-- /login?error=true -->
						<c:if test="${param.error == 'true'}">
							<div style="color: red; margin: 10px 0px;">
								Login Failed!!!<br /> Reason :
								${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}
							</div>
						</c:if>
					</div>
					<!-- /.col -->
					<div class="col-xs-4">
						<button type="submit" class="btn btn-success btn-block btn-flat">Sign
							In</button>
					</div>
					<!-- /.col -->
				</div>
			</form>

		</div>
		<!-- /.login-box-body -->
	</div>
	<!-- /.login-box -->

	<!-- jQuery 2.1.4 -->
	<script src="assets/bootstrap/plugins/jQuery/jQuery-2.1.4.min.js"></script>
	<!-- Bootstrap 3.3.2 JS -->
	<script src="assets/bootstrap/js/bootstrap.min.js"
		type="text/javascript"></script>
	<!-- iCheck -->
	<script src="assets/bootstrap/plugins/iCheck/icheck.min.js"
		type="text/javascript"></script>
	<script>
		$(function() {
			$('input').iCheck({
				checkboxClass : 'icheckbox_square-blue',
				radioClass : 'iradio_square-blue',
				increaseArea : '20%' // optional
			});
		});
	</script>
</body>
</html>