<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE>
<html lang="ru">
<head>
    <title>Employee</title>
</head>
<body>

<c:out value="Текущий пользователь ${requestScope.employee.name}"/>
<br>
<br>
<table>
    <th>Имя</th>
    <th>Зарплата</th>
    <tr>
        <td><c:out value="${requestScope.employee.name}"/></td>
        <td><c:out value="${empty requestScope.employee.salary ? 0 : requestScope.employee.salary}"/></td>
    </tr>
</table>
<footer>
    <p><a href="logout">Logout</a></p>
</footer>
</body>
</html>
