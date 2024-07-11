<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

<style>
.error {
    color: red;
    font-size: 0.9em;
}
</style>

</head>
<body>

    <form:form action="${pageContext.request.contextPath}/register/new_user" 
    method="post" modelAttribute="userDTO" enctype="multipart/form-data">
          <h2>Register</h2>
        <p>Create your account. It's free and only takes a minute.</p>

        <form:label path="firstName">First Name:</form:label>
        <form:input path="firstName" placeholder="First Name" required="required"/><br>
        <form:errors path="firstName" cssClass="error"/><br>

        <form:label path="lastName">Last Name:</form:label>
        <form:input path="lastName" placeholder="Last Name" required="required"/><br>
        <form:errors path="lastName" cssClass="error"/><br>

        <form:label path="email">Email:</form:label>
        <form:input path="email" type="email" placeholder="Email" required="required"/><br>
        <form:errors path="email" cssClass="error"/><br>

        <form:label path="password">Password:</form:label>
        <form:password path="password" placeholder="Password" required="required"/><br>
        <form:errors path="password" cssClass="error"/><br>

        <form:label path="confirmPassword">Confirm Password:</form:label>
        <form:password path="confirmPassword" placeholder="Confirm Password" required="required"/><br>
        <form:errors path="confirmPassword" cssClass="error"/><br>

        <form:label path="address">Address:</form:label>
        <form:input path="address" placeholder="Address" required="required"/><br>
        <form:errors path="address" cssClass="error"/><br>

        <form:label path="phoneNumber">Phone Number:</form:label>
        <form:input path="phoneNumber" placeholder="Phone Number (e.g. +91XXXXXXXXXX)" required="required"/><br>
        <form:errors path="phoneNumber" cssClass="error"/><br>

        <form:label path="image">Upload Profile Picture:</form:label>
        <form:input path="image" type="file" placeholder="Upload Profile Picture"/><br>
        <form:errors path="image" cssClass="error"/><br>

        <form:label path="dateOfBirth">Date of Birth:</form:label>
        <form:input path="dateOfBirth" type="date" required="required"/><br>
        <form:errors path="dateOfBirth" cssClass="error"/><br>

        <form:label path="gender">Gender:</form:label>
        <form:select path="gender" required="required">
            <form:option value="">Select Gender</form:option>
            <form:option value="male">Male</form:option>
            <form:option value="female">Female</form:option>
            <form:option value="other">Other</form:option>
        </form:select><br>
        <form:errors path="gender" cssClass="error"/><br>

        <form:label path="country">Country:</form:label>
        <form:input path="country" placeholder="Country" required="required"/><br>
        <form:errors path="country" cssClass="error"/><br>

        <form:checkbox path="termsAccepted" required="required"/> I accept the <a href="#">Terms of Use</a> & <a href="#">Privacy Policy</a><br>
        <form:errors path="termsAccepted" cssClass="error"/><br>

        <button type="submit">Register Now</button>
    </form:form>

    <p>
        Already have an account? <a href="#">Sign in</a>
    </p>


</body>
</html>
