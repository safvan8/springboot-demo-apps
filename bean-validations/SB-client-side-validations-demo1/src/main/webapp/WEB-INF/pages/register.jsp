<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">



</head>
<body>

<form action="${pageContext.request.contextPath}/appUsers/confirmRegistration/customer" method="post" enctype="multipart/form-data" onsubmit="return validateForm()">
    <h2>Register</h2>
    <p>Create your account. It's free and only takes a minute.</p>
    
    First Name : <input type="text" id="firstName" name="firstName" placeholder="First Name" required="required"><br>
    <input type="text" id="lastName" name="lastName" placeholder="Last Name" required="required"><br>
    <input type="email" id="email" name="email" placeholder="Email" required="required"><br>
    <input type="password" id="password" name="password" placeholder="Password" required="required"><br>
    <input type="password" id="confirmPassword" name="confirmPassword" placeholder="Confirm Password" required="required"><br>
    <input type="text" id="address" name="address" placeholder="Address" required="required"><br>
    <input type="tel" id="phoneNumber" name="phoneNumber" placeholder="Phone Number (e.g. +91XXXXXXXXXX)" required="required"><br>
    <input type="file" id="image" name="image" placeholder="Upload Profile Picture"><br>
    <input type="date" id="dateOfBirth" name="dateOfBirth" required="required"><br>
    
    <select id="gender" name="gender" required="required">
        <option value="">Select Gender</option>
        <option value="male">Male</option>
        <option value="female">Female</option>
        <option value="other">Other</option>
    </select><br>
    
    <input type="text" id="country" name="country" placeholder="Country" required="required"><br>
    
    <label>
        <input type="checkbox" id="termsAccepted" name="termsAccepted" required="required"> I accept the <a href="#">Terms of Use</a> & <a href="#">Privacy Policy</a>
    </label><br>
    
    <button type="submit">Register Now</button>
</form>

<p>Already have an account? <a href="#">Sign in</a></p>

<script>
    function validateForm() {
        var firstName = document.getElementById('firstName').value;
        var lastName = document.getElementById('lastName').value;
        var email = document.getElementById('email').value;
        var password = document.getElementById('password').value;
        var confirmPassword = document.getElementById('confirmPassword').value;
        var address = document.getElementById('address').value;
        var phoneNumber = document.getElementById('phoneNumber').value;
        var image = document.getElementById('image').value; // validate file type and size if needed
        var dateOfBirth = document.getElementById('dateOfBirth').value;
        var gender = document.getElementById('gender').value;
        var country = document.getElementById('country').value;
        var termsAccepted = document.getElementById('termsAccepted').checked;

        // Simple validation for each field
        if (firstName.trim() === '') {
            alert('Please enter First Name');
            return false;
        }

        if (lastName.trim() === '') {
            alert('Please enter Last Name');
            return false;
        }

        if (email.trim() === '' || !validateEmail(email)) {
            alert('Please enter a valid Email');
            return false;
        }

        if (password.trim() === '' || password.length < 8) {
            alert('Password must be at least 8 characters');
            return false;
        }

        if (password !== confirmPassword) {
            alert('Passwords do not match');
            return false;
        }

        if (address.trim() === '') {
            alert('Please enter Address');
            return false;
        }

        if (!validatePhoneNumber(phoneNumber)) {
            alert('Please enter a valid Phone Number starting with +91');
            return false;
        }

        if (image.trim() !== '') {
            // Perform validation for file type and size if needed
        }

        if (dateOfBirth.trim() === '' || !validateDate(dateOfBirth)) {
            alert('Please enter a valid Date of Birth');
            return false;
        }

        if (gender.trim() === '') {
            alert('Please select Gender');
            return false;
        }

        if (country.trim() === '') {
            alert('Please enter Country');
            return false;
        }

        if (!termsAccepted) {
            alert('Please accept the Terms of Use and Privacy Policy');
            return false;
        }

        return true;
    }

    function validateEmail(email) {
        var re = /\S+@\S+\.\S+/;
        return re.test(email);
    }

    function validatePhoneNumber(phoneNumber) {
        var re = /^\+91\d{10}$/;
        return re.test(phoneNumber);
    }

    function validateDate(date) {
        var currentDate = new Date();
        var selectedDate = new Date(date);
        return selectedDate < currentDate;
    }
</script>

</body>
</html>