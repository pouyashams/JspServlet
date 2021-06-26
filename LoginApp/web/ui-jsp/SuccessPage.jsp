<%@ page import="dto.UserDetailsDTO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Success</title>
</head>
<body>

<h1>you are best</h1>
<%
    UserDetailsDTO userDetails = (UserDetailsDTO) request.getAttribute("user");
%>
name:<%=userDetails.getUser()%>
amount:<%=userDetails.getAmount()%>
</body>
</html>
