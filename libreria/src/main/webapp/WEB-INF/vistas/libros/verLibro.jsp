<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>


<jsp:include page="/WEB-INF/vistas/template-superior.jsp"></jsp:include>


<div class="card">
  <h5 class="card-header">Libro id: ${libro.id}</h5>
  <div class="card-body">
    <h5 class="card-title">${libro.nombre}</h5>
    <p class="card-text">Precio: <fmt:formatNumber type="number" value="${libro.precio}" /> </p>    
    <c:if test="${not empty libro.temaLibro}">
	    <p class="card-text">Tema: <c:out value="${libro.temaLibro.nombre}" default="Sin categoria" /></p>
 	</c:if>
 	 <c:if test="${not empty libro.autor}">
	    <p class="card-text">Autor: <c:out value="${libro.autor.nombre}" default="Sin autor" /></p>
 	</c:if>
 	 <c:if test="${not empty libro.editorial}">
	    <p class="card-text">Editorial: <c:out value="${libro.editorial.nombre}" default="Sin editorial" /></p>
 	</c:if>
  </div>
</div>


<jsp:include page="/WEB-INF/vistas/template-inferior.jsp"></jsp:include>