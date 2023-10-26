<%@ page import="java.util.List" %>
<%@ page import="fit.iuh.edu.vn.ongk.modules.Candidate" %>
<%@ page import="fit.iuh.edu.vn.ongk.services.CandidateService" %><%--
  Created by IntelliJ IDEA.
  User: phuon
  Date: 10/26/2023
  Time: 4:06 PM
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
    <div>
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
    <div class="row d-flex mt-3">
        <div>
            <table class="table">
                <thead>
                    <tr>
                        <th>id</th>
                        <th>fullName</th>
                        <th>email</th>
                        <th>phone</th>
                        <th>view</th>
                    </tr>
                </thead>
                <tbody>
                <%

                    CandidateService service = new CandidateService();
                    List<Candidate> dscan = service.getAllCandidate();
                    for (Candidate can:dscan) {

                %>
                    <tr>
                        <td><%=can.getId()%></td>
                        <td><%=can.getFullName()%></td>
                        <td><%=can.getEmail()%></td>
                        <td><%=can.getPhone()%></td>
                        <td>
                            <form action="control" method="get">
                                <input name="actions" value="View" type="hidden">
                                <input name="action" value="<%=can.getId()%>" type="hidden">
                                <button class="btn btn-primary">View</button>
                            </form>
                        </td>
                    </tr>
                <%
                    }
                %>
                </tbody>
            </table>
        </div>
    </div>
</div>
<script src="webjars/bootstrap/4.6.0/js/bootstrap.min.js"></script>

</body>
</html>
