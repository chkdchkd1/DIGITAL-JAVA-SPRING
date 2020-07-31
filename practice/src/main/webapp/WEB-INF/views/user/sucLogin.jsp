<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div style="height: 800px">
<br>
  <c:if test ="${user != null}">
  <h1 class="display-2 text-center"> welcome <a class="info" href="<%=request.getContextPath()%>/userInfo">${user.id}</a>!</h1>
  </c:if>

