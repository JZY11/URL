<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="commons/inc.jsp" %>
<html>
<head>
    <title>URL</title>
</head>
<body>
<h1>URL</h1>
<form action="" method="post">
    <input name="original" size="64" placeholder="Enter a long URL">
    <input type="submit" value="Make URL"><br>
    <input name="creation" placeholder="Custom alias (optional)">
</form>
<c:if test="${sessionScope.mapper ne null}">
    <p>Original URL:</p>
    <p>${sessionScope.mapper.original}</p>
    <p>Creation URL:</p>
    <p><a href="http://localhost:8080/${sessionScope.mapper.creation}" target="_blank">http://localhost:8080/${sessionScope.mapper.creation}</a></p>
</c:if>
</body>
</html>
