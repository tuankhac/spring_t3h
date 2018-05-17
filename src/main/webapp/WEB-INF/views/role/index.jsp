<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>

<div class="box-header with-border">
    <h3 class="box-title">
        <b style="text-transform: uppercase;"> 
        	<spring:message	code="crud_search_button_message" />
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
                                <div class="col-sm-2 col-xs-4">
                                    <!-- /.description-block -->
                                </div>
                                <!-- /.col -->
                                <div class="col-sm-3 col-xs-4">
                                    <!-- /.description-block -->
                                </div>
                                <!-- /.col -->
                                <div class="col-sm-2 col-xs-4">
                                    <button id="doSearch" class="btn btn-block btn-primary"><spring:message	code="crud_search_button_message" /></button>
                                    <!-- /.description-block -->
                                </div>
                                <!-- /.col -->
                                <div class="col-sm-3 col-xs-4">
                                    <!-- /.description-block -->
                                </div>
                                <div class="col-sm-2 col-xs-4">
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

<section>
    <div class="row">
        <div class="col-sm-2">
            <div id="div_page_section1" class=""></div>
        </div>
        <!-- /.col -->
        <div class="col-sm-3">
            <!-- /.description-block -->
        </div>
        <!-- /.col -->
        <div class="col-sm-2">
            <!-- /.description-block -->
        </div>
        <!-- /.col -->
        <div class="col-sm-3">
            <!-- /.description-block -->
        </div>
        <div class="col-sm-2">
            <button class="btn btn-block btn-primary" id="goNew"><spring:message	code="crud_new_button_message" /></button>
            <!-- /.description-block -->
        </div>
    </div>

    <div class="box box-primary">
        <div class="no-padding" id='data-list' style="overflow: auto; margin: auto"></div>
        <div id="div_page_section2" class=""></div>
    </div>
</section>
<div class="modal fade" id="sua_dulieu_modal" role="dialog" tabindex="-1">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                <h4 class="modal-title"><spring:message	code="modal_title_edit" /></h4>
            </div>

            <div class="modal-body">
                <form class="form-horizontal" role="form">
                    <div class="form-group">
                        <label class="col-md-2 control-label" for="modal_role_id"><spring:message code="role_id" /></label>
                        <div class="col-md-3">
                            <input type="text" class="form-control" id="modal_update1" placeholder='<spring:message	code="crud_input" /> <spring:message code="role_id" />' />
                        </div>
                        <label class="col-md-3 control-label" for="modal_role_role_name"><spring:message code="role_role_name" /></label>
                        <div class="col-md-3">
                            <input type="text" class="form-control" id="modal_update2" placeholder='<spring:message	code="crud_input" /> <spring:message	code="role_role_name" />' />
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-2 control-label" for="modal_role_description"><spring:message	code="role_description" /></label>
                        <div class="col-md-3">
                            <input type="text" class="form-control" id="modal_update3" placeholder='<spring:message	code="crud_input" /> <spring:message code="role_description" />' />
                        </div>

                    </div>
				</form>
            </div>
            <div class="modal-footer">
                <span id="result_edit"></span>&nbsp;&nbsp;&nbsp;
                <button type="button" class="btn btn-primary" onclick="modal_update()" id="btn_modal_update"><spring:message code="crud_edit_button_message" /></button>
                <button type="button" class="btn btn-primary" onclick="modal_reset()" id="btn_modal_reset"><spring:message code="crud_reset_button_message" /></button>
            </div>
        </div>
    </div>
</div>

<div class="modal fade" id="xoa_dulieu_modal" role="dialog" tabindex="-1">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                <h4 class="modal-title"><spring:message code="crud_delete_button_message" /></h4>
            </div>

            <div class="modal-body">
                <form class="form-horizontal" role="form">
                    <div class="form-group">
                        <label class="col-md-2 control-label" for="modal_role_id"><spring:message code="role_id" /></label>
                        <div class="col-md-3">
                            <input type="text" class="form-control" disabled="disabled" id="modal_delete1"/>
                        </div>
                        <label class="col-md-3 control-label" for="modal_role_role_name"><spring:message code="role_role_name" /></label>
                        <div class="col-md-3">
                            <input type="text" class="form-control" disabled="disabled" id="modal_delete2"  />
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-2 control-label" for="modal_role_description"><spring:message code="role_description" /></label>
                        <div class="col-md-3">
                            <input type="text" class="form-control" disabled="disabled" id="modal_delete3" />
                        </div>
                    </div>
				</form>            
            </div>
            <div class="modal-footer">
                <span id="result_delete"></span>&nbsp;&nbsp;&nbsp;
                <button type="button" class="btn btn-primary" onclick="modal_delete()" id="btn_modal_update"><spring:message code="action_delete" /></button>
                <button type="button" class="btn btn-primary" onclick="modal_goback()" id="btn_modal_reset"><spring:message code="action_back" /></button>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript">
    var record_per_page = 2,
        page = 1,
        nor = 0;
    var getData //= onGetData(page,record_per_page);
    var objPage1 = new pageTemplates('', 'div_page_section1', 'pClick', getData);
    var objPage = new pageTemplates('', 'div_page_section2', 'pClick', 'onGetData');
    objPage.setRecPerPage(record_per_page);
    objPage.setTypeTemplate('BOOTSTRAP');
    objPage1.setRecPerPage(record_per_page);
    objPage1.setTypeTemplate('BOOTSTRAP');
    $(function() {
        $('#doSearch').click(function() {
            $('#result').html('<spring:message code="crud_process_message" />');
            $.ajax({
                url: 'crud_exec?crud_type=role/ajax_get_nop_nor',
                method: 'GET',
                data: getParams(-1, record_per_page),
                success: function(data) {
                    eval('data=' + data);
                    nor = data.NOR * 1;
                    $('#data-list').html(data);
                    $('#result').html('');
                    onStartSearch(data.NOR);
                }
            });
        });
        $('#doSearch').click();
        $('#goNew').click(function() {
            window.location.href = 'crud?crud_type=role/new';
        });
    });

    function pClick(ps_page_id, ps_rec_per_page) {
        objPage.setCurrentPage(ps_page_id);
        objPage.setRecPerPage(ps_rec_per_page);
        objPage.returnDataCount(objPage.getTotalRec());
        objPage1.setCurrentPage(ps_page_id);
        objPage1.setRecPerPage(ps_rec_per_page);
        objPage1.returnDataCount(objPage.getTotalRec());
    }
    //Ham nay tu dong duoc goi sau khi click vao cac so...:
    function onGetData(page, size) {
        $.ajax({
            url: 'crud_exec?crud_type=role/ajax_index',
            data: getParams(page, record_per_page),
            method: 'GET',
            success: function(data) {
                if (data != '') {
                    $('#data-list').html(data);
                    $('#result').html('');
                }
                if (nor == 0 && data != '') {
                    $('#result').html('<spring:message code="no_data" />');
                }
            }
        });
    }
    //Ham tra ve chuoi parameters, truyen vao ajax de lay nop, nor va du lieu hien thi
    function getParams(page, record_per_page) {
        var exec = {
            "query": "ref",
            "queryString": "crud_search_role_service",
            "id": $('#id').val(),
            "role_name": $('#role_name').val(),
            "description": $('#description').val(),
            "record_per_page": record_per_page,
            "page_index": page,
            "userID": "",
            "userIP": ""
        };
        return exec;
    }

    function onStartSearch(total) {
        objPage.setCurrentPage(1);
        objPage.returnDataCount(total);
        objPage1.setCurrentPage(1);
        objPage1.returnDataCount(total);
    }

    function modal_update() {
        var param = {
            "query": "valueInt",
            "queryString": "crud_edit_role_service",
            "id": $('#modal_update1').val(),
            "role_name": $('#modal_update2').val(),
            "description": $('#modal_update3').val(),
            "userID": "",
            "userIP": ""
        }
        if (!confirm('<spring:message code="crud_confirm_message" />')) {
            return;
        }
        $.ajax({
            url: 'crud_exec?crud_type=role/ajax_exec',
            data: param,
            success: function(data) {
                if (data == "1.0" || data == "1") {
                    $('#result_edit').html('<spring:message code="crud_edit_message" />');
                } else {
                    $('#result_edit').html(data);
                }
                console.log(data.replace("\r\n", ""));
            }
        });
    }

    function modal_reset() {
        dataObj = $("#role");
        var length = dataObj.find('td').length;

        for (var i = 0; i < length - 2; i++) {
            $("#modal_update" + (i + 1)).val(dataObj.find('td').eq(i).text());
        }
    }

    function modal_delete() {
        var param = {
            "query": "valueInt",
            "queryString": "crud_delete_role_service",
            "id": $('#modal_delete1').val(),
            "userID": "",
            "userIP": ""
        }
        if (!confirm('<spring:message code="crud_confirm_message" />')) {
            return;
        }
        $.ajax({
            url: 'crud_exec?crud_type=role/ajax_exec',
            data: param,
            success: function(data) {

                if (data == "1.0" || data == "1") {
                    $('#result_delete').html('<spring:message code="crud_delete_message" />');
                } else {
                    $('#result_delete').html(data);
                }
                console.log(data.replace("\r\n", ""));
            }
        });
    }

    function modal_goback() {
        $("#xoa_dulieu_modal").modal('toggle');
    }
    $(document).ready(function() {

    });
    $.ajaxSetup({
	    beforeSend: function () {
	       $(".modal").show();
	       console.log("show");
	    },
	    complete: function () {
	    	$(".modal").hide();
	    	console.log("hide");
	    }
    });
</script>