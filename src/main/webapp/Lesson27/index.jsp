<%--
  Created by IntelliJ IDEA.
  User: Mihail
  Date: 06.06.2023
  Time: 22:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>

    <div class="container">
        <div class="row">

            <table class="table">
                <thead>
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">Brand</th>
                    <th scope="col">Transmission</th>
                    <th scope="col">Production Year</th>
                    <th scope="col">Action</th>
                </tr>
                </thead>
                <tbody>

                <c:forEach items="${cars}" var="car" varStatus="loop">
                    <form action="/HomeworkForWeb_war/home" method="post">
                        <tr>
                            <th scope="row">${loop.count}</th>
                            <td>${car.brand}</td>
                            <td>${car.transmission}</td>
                            <td>${car.productionYear}</td>
                            <input type="hidden" name="brand" value="${car.uuid}"/>
                            <td><input type="submit" value="delete"></td>
                        </tr>
                    </form>
                </c:forEach>

                </tbody>
            </table>

        </div>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</body>
</html>
