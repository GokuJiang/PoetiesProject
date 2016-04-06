<%--
  Created by IntelliJ IDEA.
  User: jiangyongming
  Date: 4/5/16
  Time: 18:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
  <head>
      <meta charset="UTF-8">
      <title>indexPage</title>
  </head>
  <body>
    <form action="/searchServlet" name="search">
      <input type="radio" value = "title" name="method">题目
      <input type="radio" value = "author" name="method">作者
      <input type="radio" value = "content" name="method">内容
      <input type="text" name="content"><br/>
      <input type="submit">
    </form>
  </body>
</html>

