<%--
  Created by IntelliJ IDEA.
  User: HASEE
  Date: 2019/12/7
  Time: 12:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <form action="upload" enctype="multipart/form-data" method="post">
    姓名：<input type="text" name="name"/><br/>
    文件：<input type="file" name="file"><br/>
    <input type="submit" value="提交"/>
  </form>
  </body>
</html>
