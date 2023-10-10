<!DOCTYPE html>
<html>
<head>
  <title>Form Result</title>
</head>
<body>
    <h1>Form Submission Result</h1>
    <p>Name: <%= request.getParameter("name") %></p>
    <p>Email: <%= request.getParameter("email") %></p>
</body>
</html>
