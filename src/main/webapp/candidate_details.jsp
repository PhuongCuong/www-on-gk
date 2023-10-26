<%@ page import="fit.iuh.edu.vn.ongk.modules.Candidate" %>
<%@ page import="java.util.Optional" %>
<%@ page import="java.util.List" %>
<%@ page import="fit.iuh.edu.vn.ongk.modules.Experience" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: phuon
  Date: 10/26/2023
  Time: 4:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="webjars/bootstrap/4.6.0/css/bootstrap.min.css">

</head>
<body>
<div class="container">
    <ul class="nav">
        <li class="nav-item">
            <a class="nav-link" href="candidate.jsp">Candidate</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="report1.jsp">Report1</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="report2.jsp">Report2</a>
        </li>
    </ul>
</div>
<div>
    <%
        Optional<Candidate> candidate = (Optional<Candidate>) session.getAttribute("infocandidate");
        List<Experience> list = (List<Experience>) session.getAttribute("infoex");
        Map<Optional<Candidate>,List<Experience>> map = new HashMap<>();
        map.put(candidate,list);
    %>
    <h5>
        <%=map%>
    </h5>
</div>
<script src="webjars/bootstrap/4.6.0/js/bootstrap.min.js"></script>

</body>
</html>
