<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<form>
    <fieldset>
        <legend>User list</legend>
        <c:forEach var="user" items="${users}">
        <p>
            <label>ID: <em>*</em></label>
            <input type="text" id="id<c:out value="${user.id}"/>" value="<c:out value="${user.id}"/>" readonly>
            <label>Name</label>
            <input type="text" name="name<c:out value="${user.id}"/>" value="<c:out value="${user.name}"/>">
            <label>Password</label>
            <input type="password" name="password<c:out value="${user.id}"/>" value="<c:out value="${user.password}"/>">
            <label>Role</label>
            <input type="text" name="role<c:out value="${user.id}"/>" value="<c:out value="${user.role}"/>">
            <button formaction="/delete " formmethod="post" name="update" value="del<c:out value="${user.id}"/>">
                Delete
            </button>
            <button formaction="/update " formmethod="post" name="update" value="upd<c:out value="${user.id}"/>">
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

</body>
</html>