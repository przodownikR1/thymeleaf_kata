<%@ include file="/WEB-INF/templates/includes.jsp"%>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href='${pageContext.request.contextPath}/favicon.ico' rel='icon' type='image/x-icon'/>
 <link rel="shortcut icon" href="${pageContext.request.contextPath}/favicon.ico"/>

<title>Country </title>
</head>
<body>

<form:form modelAttribute="country"  method="post">
 <form:hidden path="id"/>
      <fieldset>		
				<legend>Country</legend>
				<p>
					<form:label	for="name" path="name">Name</form:label><br/>
					<form:input path="name" />		
					<form:errors path="name" cssClass="errorMessage"/>
				</p>
				
				
			</fieldset>  
			 
             <input type="submit" value="Save Changes" />

</form:form>

</body>
</html>