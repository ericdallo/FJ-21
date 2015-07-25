<%@ tag language="java" pageEncoding="UTF-8" %>
<%@ attribute name="name" required="true"%>
<%@ attribute name="label" required="true"%>

<label>${label}</label>
<input type="text" name="${name}" id="${name }">

<script>
	$('#${name}').datepicker();
</script>
