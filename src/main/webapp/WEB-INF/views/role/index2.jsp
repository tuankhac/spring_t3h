<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<%
	request.setAttribute("list_layds_menu_theo_nguoidung", "list_layds_menu_theo_nguoidung");
%>
<table id="role" class='table table-condensed'>
	<tr>
		<th colspan='4'><b><spring:message
					var="crud_search_button_message" code="crud_search_button_message" />
				<c:out value="${fn:toUpperCase(crud_search_button_message)}" /></b></th>
	</tr>
	<tr>
		<td title="" id="id_label"><spring:message code="role_id" /></td>
		<td><input type="text" class="form-control" name="id" id="id"><span
			id="id_msg"></span></td>
		<td title="" id="role_name_label"><spring:message
				code="role_role_name" /></td>
		<td><input type="text" class="form-control" name="role_name"
			id="role_name"><span id="role_name_msg"></span></td>
	</tr>
	<tr>
		<td title="" id="description_label"><spring:message
				code="role_description" /></td>
		<td><input type="text" class="form-control" name="description"
			id="description"><span id="description_msg"></span></td>
		<td></td>
		<td></td>
	<tr id='control'>
		<td colspan='4' align='center'><font id="result"></font>
			<button name="doSearch" id="doSearch" class="btn btn-primary">
				<i class="fa fa-search"></i>
				<spring:message code="crud_search_button_message" />
			</button>&nbsp;
			<button class="btn btn-primary" name="goNew" id="goNew">
				<i class="fa fa-plus-square"></i>
				<spring:message code="crud_new_button_message" />
				&gt;
			</button>&nbsp;
			<button class="btn btn-primary" name="goDelete" id="goDelete">
				<i class="fa fa-trash"></i>
				<spring:message code="crud_delete_button_message" />
				&gt;
			</button>&nbsp;
			<button class="btn btn-primary" name="goEdit" id="goEdit">
				<i class="fa fa-edit"></i>
				<spring:message code="crud_edit_button_message" />
				&gt;
			</button>&nbsp;</td>
	</tr>
</table>
<section class="content">
	<div class="box box-primary">
		<div class="box-body no-padding" id='data-list'
			style="overflow: auto; margin: auto"></div>
	</div>
</section>
<script type="text/javascript">
$(function() {
    $('#doSearch')
        .click(
            function() {
                $('#result').html('${n.i18n.crud_process_message}');
                $.ajax({
                   url: 'crud_exec?crud_type=role/ajax_index',
                   method:'GET',
                   success: function(data) {
                     alert("abc");
                     $('#data-list').html(data);
                     $('#result').html('');
                   }
                 });
            });
    $('#doSearch').click();
    $('#goNew').click(function() {
        window.location.href = 'crud?crud_type=role/new';
    });
    $('#goEdit')
        .click(
            function() {
                if ($(':radio:checked').parent().parent().children(
                        "[name='id']").length >= 1) {
                    window.location.href = 'crud?crud_type=role/edit.html&id=' +
                        $(':radio:checked').parent().parent()
                        .children("[name='id']").text();
                } else {
                    alert('${n.i18n.crud_alert_select_one}');
                }
            });
    $('#goDelete')
        .click(
            function() {
                if ($(':radio:checked').parent().parent().children(
                        "[name='id']").length >= 1) {
                    window.location.href = 'crud?crud_type=role/delete.html&id=' +
                        $(':radio:checked').parent().parent()
                        .children("[name='id']").text();
                } else {
                    alert('${n.i18n.crud_alert_select_one}');
                }
            });
});
$(document).ready(function() {});
</script>