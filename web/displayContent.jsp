<%--
  Created by IntelliJ IDEA.
  User: jiangyongming
  Date: 4/6/16
  Time: 16:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.yongming.model.poetoryModel" %>


<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">

    <title>Display Content</title>
</head>
<body>
<%
    poetoryModel poetory = (poetoryModel) session.getAttribute("poetoriesContent");
    out.print(poetory.getContent());
%>

<span>
    <%= poetory.getContent()%>
</span>

</body>
</html>
