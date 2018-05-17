<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>

<div class="box-header with-border">
    <h3 class="box-title">
        <b style="text-transform: uppercase;"> 
        	<spring:message	code="crud_new_button_message" />
		</b>
    </h3>
    <div class="box-tools pull-right">
        <button class="btn btn-box-tool" data-widget="collapse">
			<i class="fa fa-minus"></i>
		</button>
        <div class="btn-group">
            <button class="btn btn-box-tool dropdown-toggle" data-toggle="dropdown">
				<i class="fa fa-wrench"></i>
			</button>
            <ul class="dropdown-menu" role="menu">
                <li><a href="#">Action</a></li>
                <li><a href="#">Another action</a></li>
                <li><a href="#">Something else here</a></li>
                <li class="divider"></li>
                <li><a href="#">Separated link</a></li>
            </ul>
        </div>
        <button class="btn btn-box-tool" data-widget="remove">
			<i class="fa fa-times"></i>
		</button>
    </div>
</div>
<div class="box-body">
    <div id="main">
        <div id="managerment_wrapper">
            <div id="parameters">
                <div class="panel panel-primary">
                    <div class="panel-body">
                        <div id="controlPanelClass">
                            <form id="criteria" role="form" class="form-horizontal" method="post">
                                <div class="form-group">
                                    <div id="policyIdParam" class="">
                                        <label for="policy" class="control-label col-sm-2" title="Click to select a policy"> <spring:message
												code="role_id" /></label>
                                        <div class="col-sm-4">
                                            <input type="text" class="form-control" name="id" id="id"><span id="id_msg"></span>
                                        </div>
                                    </div>
                                    <div id="messageTypes">
                                        <label for='<spring:message	code="role_role_name" />' 
                                        class="control-label col-sm-2" title='Click to select a <spring:message	code="role_role_name" />'>
											<spring:message code="role_role_name" />
										</label>
                                        <div class="col-sm-4">
                                            <input type="text" class="form-control" name="role_name" id="role_name"><span id="role_name_msg"></span>
                                        </div>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div id="policyIdParam" class="">
                                        <label for="policy" class="control-label col-sm-2" title="Click to select a policy"> <spring:message
												code="role_description" />
										</label>
                                        <div class="col-sm-4">
                                            <input type="text" class="form-control" name="description" id="description"><span id="description_msg"></span>
                                        </div>
                                    </div>
                                    <div id="messageTypes"></div>
                                </div>
                            </form>
                        </div>

                        <div class="row">
                            <div class="col-sm-12">
                                <div class="col-sm-3 col-xs-4">
                                    <!-- /.description-block -->
                                </div>
                                <!-- /.col -->
                                <div class="col-sm-2 col-xs-4">
                                <button id="doNew" class="btn btn-block btn-primary"><spring:message	code="crud_new_button_message" /></button>
                                    <!-- /.description-block -->
                                </div>
                                <!-- /.col -->
                                <div class="col-sm-2 col-xs-4">
                                    <button id="doClear" class="btn btn-block btn-primary"><spring:message	code="crud_reset_button_message" /></button>
                                    <!-- /.description-block -->
                                </div>
                                <!-- /.col -->
                                <div class="col-sm-2 col-xs-4">
                                <button id="goSearch" class="btn btn-block btn-primary"><spring:message	code="crud_back_button_message" /></button>
                                    <!-- /.description-block -->
                                </div>
                                <div class="col-sm-3 col-xs-4">
                                    <!-- /.description-block -->
                                </div>
                            </div>
                        </div>
                        <!-- /.row -->
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!--  -->
</div>

<script type="text/javascript">
	$(function(){
		$('#doNew').click(function(){
			if(!checkID()) return;
			if( !confirm('<spring:message code="crud_confirm_message" />') ){return;}
			var param = {
		            "query": "valueInt",
		            "queryString": "crud_new_role_service",
		            "id": $('#id').val(),
		            "role_name": $('#role_name').val(),
		            "description": $('#description').val(),
		            "userID": "",
		            "userIP": ""
		    };
			$('#result').html('<spring:message code="crud_process_message" />');
			$.ajax({
				url: 'crud_exec?crud_type=role/ajax_exec',
				data: param,
				success: function(data){ 
					if (data == "1.0" || data == "1"){
						alert('<spring:message code="crud_new_message" />');
						//$('#result').html('<spring:message code="crud_new_message" />'); 
					}else{
						$('#result').html(data);
					}
				}
			});
		});
		$('#doClear').click(function(){
			$("input:text").each(function(){$(this).val('')});
			$("textarea").each(function(){$(this).val('')});
			$("select").each(function(){$(this).attr('selectedIndex', 0);});
		});
		$('#goSearch').click(function(){
			window.location.href='crud?crud_type=role/index';
		});
		$('#id').focus(function(){
			$('#id_msg').html('');
		});
		$('#id').blur(function(){
			if ($('#id').val()!=''){
				$('#id_msg').html('');
				$('#id_msg').attr('style','display:none');
			}else{
				$('#id_msg').html('<font color="red">${n.i18n.crud_required_message} ${n.i18n.role_id}</font>');
				$('#id_msg').attr('style','display:block');
				return false;
			}
			checkID();
		});
	});
	$(document).ready(function(){
	});
	function validateID(id ){
		var par=/^[A-Za-z]+/;
		return par.test(id);
	}

	function setDate(){
		var today = new Date();
		var value = (today.getDate() + '/' + (today.getMonth() + 1)  + '/' +  today.getFullYear())
		$('#created_date').val(value);
		$('#modified_date').val(value);
	}
	function checkID(){
		if(!validateID($('#id').val())){
			$('#id_msg').html('<font color = "red">${n.i18n.validate_roleID}</font>');
			$('#id_msg').attr('style', 'display:block');
			return false;
		}
		return true;
	}
</script>