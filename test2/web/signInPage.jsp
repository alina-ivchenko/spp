<%@ page import="main.java.Drawer" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Регистрация</title>
    <link rel="stylesheet" href="css/registrationPageStyles.css">

    <script src="js/jquery-3.3.1.min.js"></script>
    <script>
        function provideCorrectInputs() {
            if ($("#password1").val() !== $("#password2").val())
                alert("Повторно пароль введён неверно");
            else
                $("#mainSendForm").submit();
        }
    </script>
    <%out.print(Drawer.drawCommonHeadLinks());%>

</head>
<body>

<%
    out.print(Drawer.drawHeader("Регистрация"));
%>

<form method="post"
      id="mainSendForm"
      name="mainSendForm"
      action="saver">
    <input name="Login" type="text" value="Логин">
    <span>Введите пароль:</span>
    <input name="Password_Hash" id="password1" type="password" value="password">

    <span>Введите пароль повторно</span>
    <input type="password" id="password2" value="password">

    <span>Введите почту</span>
    <input name="Email" type="email">

    <!-- Вспомогательные -->
    <input name="task" type="text" style="display: none;" value="sign_in">
    <input name="objectType" type="text" style="display: none;" value="User">

    <button type="button" onclick="provideCorrectInputs()">Зарегистрироваться</button>
</form>
<%
    out.print(Drawer.drawFooter());
%>
</body>
</html>
