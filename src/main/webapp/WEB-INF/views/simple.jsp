<%--
  Created by IntelliJ IDEA.
  User: vashishta
  Date: 10/13/15
  Time: 5:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <script src="/ui/jquery/jquery.js"></script>
</head>
<body>

<h2>Hello I am a simple page</h2>

<div class="firstDiv">
<h3>Some value</h3>
</div>

<div>
    <button type="button" id="firstButton">First Button</button>
</div>

<script>
    $(function() {

       $(".firstDiv").click(function(event) {
          alert("First Div was clicked");
       })

        $("#firstButton").on("click", function() {
           console.log("First Button was clicked");
        });



    });
</script>
</body>
</html>
