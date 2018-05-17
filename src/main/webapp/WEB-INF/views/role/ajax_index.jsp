<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<table style="width: 100%" class="table table-condensed table-striped table-bordered" id="role">
	<tr>
		<th align=center><spring:message code="role_id" /></th>
		<th align=center><spring:message code="role_role_name" /></th>
		<th align=center><spring:message code="role_description" /></th>
		<th align=center><spring:message code="action_edit" /></th>
		<th align=center><spring:message code="action_delete" /></th>
	</tr>
	<c:forEach var="item" items="${ajaxResponse}">
		<tr>
			<td align="left">${item.get("ID")}</td>
			<td align="left">${item.get("ROLE_NAME")}</td>
			<td align="left">${item.get("DESCRIPTION")}</td>
			<td align=left style="width: 25px"><button onclick="get_edit_dulieu_modal(this)" data-toggle="modal" data-target="#sua_dulieu_modal"><spring:message code="action_edit" /></button></td>
			<td align=left style="width: 25px"><button onclick="get_del_dulieu_modal(this)" data-toggle="modal" data-target="#xoa_dulieu_modal"><spring:message code="action_delete" /></button></td>
		</tr>
	</c:forEach>
</table>
<script>
	$(function() {	
	});
	
	function get_edit_dulieu_modal(obj){
		dataObj = $(obj).parent().parent();
		var length = dataObj.find('td').length;
		
        for(var i = 0; i < length - 2 ; i++){
			 $("#modal_update"+(i+1)).val(dataObj.find('td').eq(i).text());      	
        }
	}
	
	function get_del_dulieu_modal(obj){
		dataObj = $(obj).parent().parent();
		var length = dataObj.find('td').length;
		
        for(var i = 0; i < length - 2 ; i++){
			 $("#modal_delete"+(i+1)).val(dataObj.find('td').eq(i).text());      	
        }
	}
</script>
