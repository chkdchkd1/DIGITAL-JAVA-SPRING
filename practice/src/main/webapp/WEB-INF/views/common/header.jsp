<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<nav class="navbar navbar-expand-md bg-dark navbar-dark">
	<div class="container">
	  		<a class="navbar-brand" href="<%=request.getContextPath()%>/">HOME</a>
	  	<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
	    	<span class="navbar-toggler-icon"></span>
	  	</button>
	  	<div class="collapse navbar-collapse" id="collapsibleNavbar">
	    	<ul class="navbar-nav">
	    	<c:if test ="${user == null }">
		      	<li class="nav-item">
		        	<a class="nav-link" href="#">SIGN UP</a>
		      	</li>
		    </c:if>
		    <c:if test ="${user != null }">
		      	<li class="nav-item">
		        	<a class="nav-link" href="<%=request.getContextPath()%>/signout">SIGN OUT</a>
		      	</li>
		    </c:if>
		    
		      	<li class="nav-item">
		        	<a class="nav-link" href="<%=request.getContextPath()%>/board/list">BOARD</a>
		      	</li>
		      	<li class="nav-item">
		        	<a class="nav-link" href="#">MAIL</a>
		      	</li>    
	    	</ul>
		</div> 
	</div> 
</nav>