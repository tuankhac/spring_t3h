<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isELIgnored="false"%>

<%@include file="../basefragments/header.jsp"%>

<!-- MENU -->
<aside id="sidebar" class="main-sidebar">
    <div id="dragbar"></div>
    <!-- sidebar: style can be found in sidebar.less -->
    <section class="sidebar">
        <!-- search form -->
        <form method="GET" class="sidebar-form" name="frmAgent">
            <div class="input-group">
                <input type="text" name="q" class="form-control" placeholder="Search..." /> <span class="input-group-btn">
					<button type='submit' name='search' id='search-btn'
						class="btn btn-flat">
						<i class="fa fa-search"></i>
					</button>
				</span>
            </div>
        </form>
        <!-- /.search form -->
        <!-- sidebar menu: : style can be found in sidebar.less -->
        <ul class="sidebar-menu">
            <%@include file="../basefragments/menu.jsp"%>
        </ul>
    </section>
    <!-- /.sidebar -->
</aside>

<!--value="${sessionScope.lang}" -->
<!-- Content Wrapper. Contains page content -->
<div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="main content-header">
        <h1>
            <spring:message code="${param.crud_type}">
            </spring:message>
        </h1>
    </section>
    <section class="main content">
        <div class="row">
            <div class="col-md-12">
                <!-- Block buttons -->
                <div class="box box-primary">
                    <div class="box">
                        <!-- can chinh sua tai day -->
                        <jsp:include flush="true" page="include.jsp"></jsp:include>
                    </div>
                    <!-- /.box-body -->
                </div>
                <!-- /.box -->
            </div>
            <!-- /.col -->
        </div>
        <!-- /. row -->
    </section>
</div>
<!-- /.content-wrapper -->

<%@include file="../basefragments/footer.jsp"%>