<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>JNDI操作界面</title>
</head>
<body>
<h1>JNDI操作界面</h1>
<form action="JNDIOP" method="post">
    <label for="bindName">绑定名字：</label>
    <input id="bindName" type="text" name="bindName">
    <label for="bindValue">绑定值：</label>
    <input id="bindValue" type="text" name="bindValue">
    <br/><br/>
    <button type="submit" name="op" value="bind">绑定</button>
    <button type="submit" name="op" value="lookUp">查询</button>
    <button type="submit" name="op" value="rebind">重新绑定</button>
    <button type="submit" name="op" value="unbind">取消绑定</button>
</form>
</body>
</html>
