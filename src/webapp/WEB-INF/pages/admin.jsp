<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<form>
    <fieldset>
        <legend>User list</legend>
        <c:forEach var="user" items="${users}">
        <p>
            <label>Name</label>
            <input type="text" name="name" value="<c:out value="${user.username}"/>">
            <label>Password</label>
            <input type="password" name="password" value="<c:out value="${user.password}"/>">
            <label>Role</label>
            <input type="text" name="role" value="<c:out value="${user.roles}"/>">
            <button formaction="/delete " formmethod="post" name="update" value="del">
                Delete
            </button>
            <button formaction="/update " formmethod="post" name="update" value="upd">
                Update
            </button>
        <p>
        </c:forEach>
    </fieldset>
    <p>
        <label>Name</label><input type="text" name="nameToAdd">
        <label>password</label><input type="password" name="passwordToAdd">
        <label>role</label><input type="text" name="roleToAdd">
        <button formaction="/add" formmethod="post" name="update" value="addUser">Add User</button>
    </p>

</form>
<jsp:include page="logoutFooter.jsp"/>
</body>
</html>