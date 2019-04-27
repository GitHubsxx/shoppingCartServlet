<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>显示所有的书籍</title>
</head>
<body>

<%--Servlet传递过来的是一个Map对象，要显示所有的书籍，就需要遍历Map集合（EL表达式和JSTL标签合用）--%>
<table border="1px">
    <tr>
        <td>书籍编号</td>
        <td>名称</td>
        <td>作者</td>
        <td>详细信息</td>
        <td>价格</td>
    </tr>

    <c:forEach items="${books}" var="me">
        <tr>
            <td>${me.key}</td>
            <td>${me.value.name}</td>
            <td>${me.value.author}</td>
            <td>${me.value.description}</td>
            <td>${me.value.price}</td>
        </tr>
    </c:forEach>


</table>

</body>
</html>