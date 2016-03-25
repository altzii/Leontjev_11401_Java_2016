<%--
  Created by IntelliJ IDEA.
  User: Alexander
  Date: 23/03/2016
  Time: 16:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form action="/process" method="POST">
    <textarea name="text">Input text</textarea><br><br>
   <select name="oper">
       <option oper="symbols">symbols</option>
       <option oper="word">words</option>
       <option oper="sentences">sentences</option>
       <option oper="paragraphs">paragraphs</option>
   </select><br><br>
    <input type="submit" value="process"/>
</form>

</body>
</html>
