<%@ page contentType="text/html;charset=UTF-8" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Calculator</title>
    <link rel="stylesheet" href="resources/main.css">
</head>
<body>
<header>
    <h2>Charlo's Calculator</h2>
</header>
<main>
    <h5>Simple calculations</h5>
    <span id="instructions-paragraph"><em>(Enter the numbers to add and/or multiply. Enjoy :D)</em></span>
    <hr>
    <jsp:include page="pages/form.jsp"/>
</main>
<jsp:include page="pages/validators.html"/>
<script src="resources/main.js"></script>
</body>
</html>
