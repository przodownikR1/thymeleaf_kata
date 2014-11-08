<%@ include file="/WEB-INF/templates/includes.jsp"%>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href='${pageContext.request.contextPath}/favicon.ico' rel='icon' type='image/x-icon'/>

<title>Country </title>
</head>
<body>
<table border="1">
<tr><th>Name</th><th>Edit</th><th>Delete</th></tr>
<c:forEach items="${countryList}" var="country">

     <spring:url value="/country/{id}" var="countryEdit">
           <spring:param name="id" value="${country.id}"></spring:param>
       </spring:url>
        <spring:url value="/country/delete/{id}" var="countryDelete">
           <spring:param name="id" value="${country.id}"></spring:param>
       </spring:url>

  <tr><td><c:out value="${country.name}"/></td>
  <td><a href="${countryEdit}">Edit</a></td>
  <td><a href="${countryDelete}">Delete</a></td>
  </tr>
</c:forEach>
</table>

 <spring:url value="/country" var="countryAdd"/>
          
 <a href ="${countryAdd}">Add country</a>


</body>
</html>