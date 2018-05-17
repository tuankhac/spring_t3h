<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.Map"%>
<!DOCTYPE html>

<html>
<head>
<%-- <meta http-equiv="refresh"
	content="<%=session.getMaxInactiveInterval()%>"> --%>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="IE=8" />
<title><spring:message code="app_title">
	</spring:message></title>
<meta
	content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no'
	name='viewport'>
<!-- Bootstrap 3.3.4 -->
<link href="assets/bootstrap/css/bootstrap.min.css" rel="stylesheet"
	type="text/css" />
<!-- FontAwesome 4.3.0 -->
<link
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css"
	rel="stylesheet" type="text/css" />
<!-- Ionicons 2.0.0 -->
<link
	href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css"
	rel="stylesheet" type="text/css" />
<!-- Theme style -->
<link href="assets/lte/dist/css/AdminLTE.min.css" rel="stylesheet"
	type="text/css" />
<!-- AdminLTE Skins. Choose a skin from the css/skins 
         folder instead of downloading all of them to reduce the load. -->
<link href="assets/lte/dist/css/skins/_all-skins.min.css"
	rel="stylesheet" type="text/css" />
<!-- iCheck -->
<link href="assets/lte/plugins/iCheck/flat/blue.css" rel="stylesheet"
	type="text/css" />
<!-- Morris chart -->
<link href="assets/lte/plugins/morris/morris.css" rel="stylesheet"
	type="text/css" />
<!-- jvectormap -->
<link href="assets/lte/plugins/jvectormap/jquery-jvectormap-1.2.2.css"
	rel="stylesheet" type="text/css" />
<!-- Date Picker -->
<link href="assets/lte/plugins/datepicker/datepicker3.css"
	rel="stylesheet" type="text/css" />
<!-- Daterange picker -->
<link href="assets/lte/plugins/daterangepicker/daterangepicker-bs3.css"
	rel="stylesheet" type="text/css" />
<!-- bootstrap wysihtml5 - text editor -->
<link
	href="assets/lte/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.min.css"
	rel="stylesheet" type="text/css" />
	
<link href="assets/lte/plugins/iCheck/flat/_all.css" rel="stylesheet" type="text/css" />
<link href="assets/bootstrap/lte/css/AdminLTE.min.css" rel="stylesheet" type="text/css" />
<link href="assets/bootstrap/lte/css/skins/skin-blue-light.min.css" rel="stylesheet" type="text/css" />
<link href="assets/bootstrap/plugins/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
<link href="assets/bootstrap/plugins/datepicker/datepicker3.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="assets/bootstrap/plugins/icomoon/style.css">	
 <!--LTE-->
<link href="assets/lte/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
	
<script src="assets/bootstrap/plugins/jQuery/jQuery-2.1.4.min.js"></script>
<script src="assets/bootstrap/js/bootstrap.min.js"
	type="text/javascript"></script>
<script src="assets/bootstrap/lte/js/app.min.js" type="text/javascript"></script>
<script src="assets/bootstrap/plugins/chartjs/Chart.min.js"
	type="text/javascript"></script>
<script
	src="assets/bootstrap/plugins/datepicker/bootstrap-datepicker.js"
	type="text/javascript"></script>
<script type="text/javascript"
	src="assets/bootstrap/plugins/ckeditor/ckeditor.js"></script>


<!-- phan trang -->
<link rel="stylesheet" type="text/css" media="screen"
	href="style/page_template/page_templates.css" />
<script type="text/javascript"
	src="style/page_template/page_templates.js"></script>
<script src="style/chosen.jquery.min.js"></script>
<script>
	function Go(l) {
		document.location.href = l;
	}
</script>
</head>
<body class="skin-blue sidebar-mini">
    <div class="wrapper">
        <header class="main-header">

            <!-- Logo -->
            <a href="index" class="logo">
                <!-- mini logo for sidebar mini 50x50 pixels -->
                <span class="logo-mini"><b>A</b>LT</span>
                <!-- logo for regular state and mobile devices -->
                <span class="logo-lg"><b>Spring</b>DEMO</span>
            </a>

            <!-- Header Navbar: style can be found in header.less -->
            <nav class="navbar navbar-static-top" role="navigation">
                <!-- Sidebar toggle button-->
                <a href="#" class="sidebar-toggle" data-toggle="offcanvas" role="button"> <span class="sr-only">Toggle navigation</span>
				</a>
                <!-- Navbar Right Menu -->
                <div class="navbar-custom-menu">
                    <ul class="nav navbar-nav">
                        <!-- Messages: style can be found in dropdown.less-->
                        <li class="dropdown messages-menu"><a href="#" class="dropdown-toggle" data-toggle="dropdown"> <i
								class="fa fa-envelope-o"></i> <span class="label label-success">4</span>
						</a>
                            <ul class="dropdown-menu">
                                <li class="header">You have 4 messages</li>
                                <li>
                                    <!-- inner menu: contains the actual data -->
                                    <div class="slimScrollDiv" style="position: relative; overflow: hidden; width: auto; height: 200px;">
                                        <ul class="menu" style="overflow: hidden; width: 100%; height: 200px;">
                                            <li>
                                                <!-- start message -->
                                                <a href="#">
                                                    <div class="pull-left">
                                                        <img src="assets/lte/dist/img/user2-160x160.jpg" class="img-circle" alt="User Image">
                                                    </div>
                                                    <h4>
                                                        Support Team <small><i class="fa fa-clock-o"></i>
															5 mins</small>
                                                    </h4>
                                                    <p>Why not buy a new awesome theme?</p>
                                                </a>
                                            </li>
                                            <!-- end message -->
                                            <li>
                                                <a href="#">
                                                    <div class="pull-left">
                                                        <img src="assets/lte/dist/img/user3-128x128.jpg" class="img-circle" alt="user image">
                                                    </div>
                                                    <h4>
                                                        AdminLTE Design Team <small><i
															class="fa fa-clock-o"></i> 2 hours</small>
                                                    </h4>
                                                    <p>Why not buy a new awesome theme?</p>
                                                </a>
                                            </li>
                                            <li>
                                                <a href="#">
                                                    <div class="pull-left">
                                                        <img src="assets/lte/dist/img/user4-128x128.jpg" class="img-circle" alt="user image">
                                                    </div>
                                                    <h4>
                                                        Developers <small><i class="fa fa-clock-o"></i>
															Today</small>
                                                    </h4>
                                                    <p>Why not buy a new awesome theme?</p>
                                                </a>
                                            </li>
                                            <li>
                                                <a href="#">
                                                    <div class="pull-left">
                                                        <img src="assets/lte/dist/img/user3-128x128.jpg" class="img-circle" alt="user image">
                                                    </div>
                                                    <h4>
                                                        Sales Department <small><i class="fa fa-clock-o"></i>
															Yesterday</small>
                                                    </h4>
                                                    <p>Why not buy a new awesome theme?</p>
                                                </a>
                                            </li>
                                            <li>
                                                <a href="#">
                                                    <div class="pull-left">
                                                        <img src="assets/lte/dist/img/user4-128x128.jpg" class="img-circle" alt="user image">
                                                    </div>
                                                    <h4>
                                                        Reviewers <small><i class="fa fa-clock-o"></i> 2
															days</small>
                                                    </h4>
                                                    <p>Why not buy a new awesome theme?</p>
                                                </a>
                                            </li>
                                        </ul>
                                        <div class="slimScrollBar" style="background: rgb(0, 0, 0); width: 3px; position: absolute; top: 0px; opacity: 0.4; display: block; border-radius: 7px; z-index: 99; right: 1px;"></div>
                                        <div class="slimScrollRail" style="width: 3px; height: 100%; position: absolute; top: 0px; display: none; border-radius: 7px; background: rgb(51, 51, 51); opacity: 0.2; z-index: 90; right: 1px;"></div>
                                    </div>
                                </li>
                                <li class="footer"><a href="#">See All Messages</a></li>
                            </ul>
                        </li>
                        <!-- Notifications: style can be found in dropdown.less -->
                        <li class="dropdown notifications-menu"><a href="#" class="dropdown-toggle" data-toggle="dropdown"> <i
								class="fa fa-bell-o"></i> <span class="label label-warning">10</span>
						</a>
                            <ul class="dropdown-menu">
                                <li class="header">You have 10 notifications</li>
                                <li>
                                    <!-- inner menu: contains the actual data -->
                                    <div class="slimScrollDiv" style="position: relative; overflow: hidden; width: auto; height: 200px;">
                                        <ul class="menu" style="overflow: hidden; width: 100%; height: 200px;">
                                            <li><a href="#"> <i class="fa fa-users text-aqua"></i>
													5 new members joined today
											</a></li>
                                            <li><a href="#"> <i
													class="fa fa-warning text-yellow"></i> Very long
													description here that may not fit into the page and may
													cause design problems
											</a></li>
                                            <li><a href="#"> <i class="fa fa-users text-red"></i>
													5 new members joined
											</a></li>

                                            <li><a href="#"> <i
													class="fa fa-shopping-cart text-green"></i> 25 sales made
											</a></li>
                                            <li><a href="#"> <i class="fa fa-user text-red"></i>
													You changed your username
											</a></li>
                                        </ul>
                                        <div class="slimScrollBar" style="background: rgb(0, 0, 0); width: 3px; position: absolute; top: 0px; opacity: 0.4; display: block; border-radius: 7px; z-index: 99; right: 1px;"></div>
                                        <div class="slimScrollRail" style="width: 3px; height: 100%; position: absolute; top: 0px; display: none; border-radius: 7px; background: rgb(51, 51, 51); opacity: 0.2; z-index: 90; right: 1px;"></div>
                                    </div>
                                </li>
                                <li class="footer"><a href="#">View all</a></li>
                            </ul>
                        </li>
                        <!-- Tasks: style can be found in dropdown.less -->
                        <li class="dropdown tasks-menu"><a href="#" class="dropdown-toggle" data-toggle="dropdown"> <i
								class="fa fa-flag-o"></i> <span class="label label-danger">9</span>
						</a>
                            <ul class="dropdown-menu">
                                <li class="header">You have 9 tasks</li>
                                <li>
                                    <!-- inner menu: contains the actual data -->
                                    <div class="slimScrollDiv" style="position: relative; overflow: hidden; width: auto; height: 200px;">
                                        <ul class="menu" style="overflow: hidden; width: 100%; height: 200px;">
                                            <li>
                                                <!-- Task item -->
                                                <a href="#">
                                                    <h3>
                                                        Design some buttons <small class="pull-right">20%</small>
                                                    </h3>
                                                    <div class="progress xs">
                                                        <div class="progress-bar progress-bar-aqua" style="width: 20%" role="progressbar" aria-valuenow="20" aria-valuemin="0" aria-valuemax="100">
                                                            <span class="sr-only">20% Complete</span>
                                                        </div>
                                                    </div>
                                                </a>
                                            </li>
                                            <!-- end task item -->
                                            <li>
                                                <!-- Task item -->
                                                <a href="#">
                                                    <h3>
                                                        Create a nice theme <small class="pull-right">40%</small>
                                                    </h3>
                                                    <div class="progress xs">
                                                        <div class="progress-bar progress-bar-green" style="width: 40%" role="progressbar" aria-valuenow="20" aria-valuemin="0" aria-valuemax="100">
                                                            <span class="sr-only">40% Complete</span>
                                                        </div>
                                                    </div>
                                                </a>
                                            </li>
                                            <!-- end task item -->
                                            <li>
                                                <!-- Task item -->
                                                <a href="#">
                                                    <h3>
                                                        Some task I need to do <small class="pull-right">60%</small>
                                                    </h3>
                                                    <div class="progress xs">
                                                        <div class="progress-bar progress-bar-red" style="width: 60%" role="progressbar" aria-valuenow="20" aria-valuemin="0" aria-valuemax="100">
                                                            <span class="sr-only">60% Complete</span>
                                                        </div>
                                                    </div>
                                                </a>
                                            </li>
                                            <!-- end task item -->
                                            <li>
                                                <!-- Task item -->
                                                <a href="#">
                                                    <h3>
                                                        Make beautiful transitions <small class="pull-right">80%</small>
                                                    </h3>
                                                    <div class="progress xs">
                                                        <div class="progress-bar progress-bar-yellow" style="width: 80%" role="progressbar" aria-valuenow="20" aria-valuemin="0" aria-valuemax="100">
                                                            <span class="sr-only">80% Complete</span>
                                                        </div>
                                                    </div>
                                                </a>
                                            </li>
                                            <!-- end task item -->
                                        </ul>
                                        <div class="slimScrollBar" style="background: rgb(0, 0, 0); width: 3px; position: absolute; top: 0px; opacity: 0.4; display: block; border-radius: 7px; z-index: 99; right: 1px;"></div>
                                        <div class="slimScrollRail" style="width: 3px; height: 100%; position: absolute; top: 0px; display: none; border-radius: 7px; background: rgb(51, 51, 51); opacity: 0.2; z-index: 90; right: 1px;"></div>
                                    </div>
                                </li>
                                <li class="footer"><a href="#">View all tasks</a></li>
                            </ul>
                        </li>
                        <!-- User Account: style can be found in dropdown.less -->
                        <li class="dropdown user user-menu"><a href="#" class="dropdown-toggle" data-toggle="dropdown"> <img
								src="assets/lte/dist/img/user2-160x160.jpg" class="user-image"
								alt="User Image"> <span class="hidden-xs">
								<%--  <%=request.getUserPrincipal().getName()%> --%>
								</span>
						</a>
                            <ul class="dropdown-menu">
                                <!-- User image -->
                                <li class="user-header"><img src="assets/lte/dist/img/user2-160x160.jpg" class="img-circle" alt="User Image">
                                   <%--  <p>
                                        <%=request.getUserPrincipal().getName()%>
                                            - Java Developer <small>NEO Member</small>
                                    </p> --%>
                                </li>
                                <!-- Menu Body -->
                                <li class="user-body">
                                    <div class="col-xs-4 text-center">
                                        <a href="#">Followers</a>
                                    </div>
                                    <div class="col-xs-4 text-center">
                                        <a href="#">Sales</a>
                                    </div>
                                    <div class="col-xs-4 text-center">
                                        <a href="#">Friends</a>
                                    </div>
                                </li>
                                <!-- Menu Footer-->
                                <li class="user-footer">
                                    <div class="pull-left">
                                        <a href="#" class="btn btn-default btn-flat">Profile</a>
                                    </div>
                                    <div class="pull-right">
                                        <a href="logout" class="btn btn-default btn-flat">Sign out</a>
                                    </div>
                                </li>
                            </ul>
                        </li>
                        <!-- Control Sidebar Toggle Button -->
                        <li><a href="#" data-toggle="control-sidebar"><i
								class="fa fa-gears"></i></a></li>
                    </ul>
                </div>

            </nav>
        </header>