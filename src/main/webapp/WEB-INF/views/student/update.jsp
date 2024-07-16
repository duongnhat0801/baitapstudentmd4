<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Update Student</title>
</head>
<body>
<h1>Update Student</h1>
<form action="/student/update" method="post">
    <input type="hidden" name="id" value="${student.id}">
    <div>
        <label for="name">Name:</label>
        <input type="text" id="name" name="name" value="${student.name}">
    </div>
    <div>
        <label for="address">Address:</label>
        <input type="text" id="address" name="address" value="${student.address}">
    </div>
    <div>
        <label for="score">Score:</label>
        <input type="number" id="score" name="score" value="${student.score}">
    </div>
    <button type="submit">Update</button>
</form>
</body>
</html>
