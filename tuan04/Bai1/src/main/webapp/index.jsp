<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>JSP - Hello World</title>
</head>
<style>
  .input {
    padding-left: 10px;
    height: 25px
  }

  .container {
    display: flex;
    justify-content: center;
    align-items: center
  }
</style>
<body class="container">
<form method="post" action="signup" style="display: flex; flex-direction: column; gap: 14px; padding: 40px; border: 1px solid #b5b4b4; border-radius: 10px">
  <h1 style="text-align: center">User Registration Form</h1>
  <div>
    <input class="input" type="text" name="firstName" placeholder="First Name">
    <input class="input" type="text" name="lastName" placeholder="Last Name">
  </div>
  <input class="input" type="email" name="email" placeholder="Your Email">
  <input class="input" type="email" name="reEmail" placeholder="Re-enter Email">
  <input class="input" type="text" name="password" placeholder="New Password">
  <label>Birthday</label>
  <input class="input" type="date" name="birthday">
  <div style="display: flex; gap: 12px">
    <div class="container">
      <input class="input" type="radio" id="female" name="gender" value="Female">
      <label for="female">Female</label>
    </div>
    <div class="container">
      <input class="input" type="radio" id="male" name="gender" value="Male">
      <label for="male">Male</label>
    </div>
  </div>

  <button type="submit" style="height: 40px;  background-color: #315a9d; color: white; border: 0; cursor: pointer">Sign Up</button>
</form>
</div>

</body>
</html>