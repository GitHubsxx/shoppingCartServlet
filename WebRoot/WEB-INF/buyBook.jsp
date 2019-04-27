 <%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <html>
    <head>
        <title>购物车显示页面</title>
    </head>
    <body>
    <h1>购物车显示页面</h1>

    <%--empty函数是判断集合中有没有元素--%>
    <%--如果购物车是没有任何购物项的--%>
    <c:if test="${empty(cart.bookMap)}">
        <h1>您还没有购买过任何的书籍呀！</h1>
    </c:if>

    <%--如果购物车有购物项，就应该把购物项的信息显示给用户--%>
    <c:if test="${!empty(cart.bookMap)}">

        <table border="1px">
            <tr>
                <td>书籍编号</td>
                <td>名称</td>
                <td>数量</td>
                <td>小计</td>
                <td>操作</td>
            </tr>
            <c:forEach items="${cart.bookMap}" var="me">
                <tr>
                    <td>${me.key}</td>
                    <td>${me.value.book.name}</td>
                    <td>${me.value.quantity}</td>
                    <td>${me.value.price}</td>
                    <td><a href="${pageContext.request.contextPath}/buyBook?bookid=${me.key}">添加</a></td>
                </tr>
            </c:forEach>
            <tr>
                <td colspan="2"><a href="#">清空购物车</a></td>

                <td colspan="2">合计：</td>
                <td>${cart.price}</td>
            </tr>

        </table>

    </c:if>

  </table>
  </body>
 </html>