<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>


<jsp:include page="/WEB-INF/vistas/template-superior.jsp"></jsp:include>


<div class="card">
  <h5 class="card-header">Cliente id: ${cliente.id}</h5>
  <div class="card-body">
    <h5 class="card-title">${cliente.nombre} ${cliente.apellido}</h5>
    <p class="card-text">Telefono: ${cliente.telefono}</p>  
    <p class="card-text">Email: ${cliente.email} </p>    
   
  </div>
</div>


<jsp:include page="/WEB-INF/vistas/template-inferior.jsp"></jsp:include>