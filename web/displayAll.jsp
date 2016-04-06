<%@ page import="java.util.List" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="com.yongming.model.poetoryModel" %>
<%--
  Created by IntelliJ IDEA.
  User: jiangyongming
  Date: 4/6/16
  Time: 17:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">

    <title>Display All</title>
</head>
<body>
<%
    List stus = (List) session.getAttribute("poetoriesAll");
    // out.print(stus.size());
    Iterator iter = stus.iterator();
%>

<table>
    <tr>
        <td>id</td>
        <td>题目</td>
        <td>作者</td>
        <td>内容</td>
    </tr>
    <%
        int i = 0;
        while (iter.hasNext()) {
            poetoryModel poetory = (poetoryModel) iter.next();
    %>
    <tr>
        <td><%=poetory.getId()  %>
        </td>
        <td><%=poetory.getTitle() %>
        </td>
        <td><%=poetory.getName() %>
        </td>
        <td><%=poetory.getContent() %>
        </td>
    </tr>
    <%
            i++;
        }
    %>
</table>
</body>
</html>
