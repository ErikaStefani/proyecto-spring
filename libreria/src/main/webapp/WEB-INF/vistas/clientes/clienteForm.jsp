<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>

<jsp:include page="/WEB-INF/vistas/template-superior.jsp"></jsp:include>

	<script type="text/javascript">
		$(document).ready(function() {
			$('#form-cliente').validate();
		});
	</script>

	<h1>Registrar Cliente</h1>

	<form:form method="post" action="/clientes/guardar" modelAttribute="clienteForm" id="form-cliente">

		<div class="form-group">
			<label>Id</label>
			<form:input path="id" readonly="true" cssClass="form-control"/>
		</div>

		<div class="form-group">
			<label>Nombre</label>
			<form:input path="nombre" cssClass="form-control required" />
			<form:errors path="nombre" cssClass="error"/>
		</div>

		<div class="form-group">
			<label>Apellido</label>
			<form:input path="apellido" cssClass="form-control required" />
			<form:errors path="apellido" cssClass="error"/>
		</div>
		<div class="form-group">
			<label>Telefono</label>
			<form:input path="telefono" cssClass="form-control required" />
			<form:errors path="telefono" cssClass="error"/>
		</div>
		<div class="form-group">
			<label>Email</label>
			<form:input path="email" cssClass="form-control required" />
			<form:errors path="email" cssClass="error"/>
		</div>

		<button type="submit" class="btn btn-primary">Enviar datos</button>
	</form:form>

<jsp:include page="/WEB-INF/vistas/template-inferior.jsp"></jsp:include>