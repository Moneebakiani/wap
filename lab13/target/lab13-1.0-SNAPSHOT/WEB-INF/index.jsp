<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Quiz</title>
</head>
<body>
<h1>The Number Quiz</h1>
<p>Your Current Score is
    ${score}
</p>
<p>Guess the next number in sequence</p>
<p>${question}</p>
<form action="hello-servlet" method="post">
    <label>Your answer:</label>
    <input type="text" name="answer"><br/><br/>
    <button>Submit</button>
</form>
</body>
</html>