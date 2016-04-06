<%--
  Created by IntelliJ IDEA.
  User: jiangyongming
  Date: 4/6/16
  Time: 15:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.yongming.model.poetoryModel" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Iterator" %>


<!DOCTYPE html>

<html>
<head>
    <meta charset="UTF-8">

    <title>display</title>
</head>


<body>
<%
    List stus = (List) session.getAttribute("poetories");
    // out.print(stus.size());
    Iterator iter = stus.iterator();
%>
<div>
    <table>
        <ul>
            <%
                int i = 0;
                while (iter.hasNext()) {
                    poetoryModel poetory = (poetoryModel) iter.next();
            %>
            <li><%=poetory.getTitle()%>
            </li>
            <%
                    i++;
                }%>
        </ul>

    </table>
</div>

</body>
</html>
