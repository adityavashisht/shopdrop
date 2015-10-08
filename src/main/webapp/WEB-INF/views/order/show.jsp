<jsp:include page="../template/header.jsp"/>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="container">
    <h3>Order Page</h3>

    <p>${name}</p>

    <table class="table table-bordered">
        <c:forEach var="product" items="products">
            <tr>
                <td>${product.id}</td>
                <td>${product.name}</td>
                <td>${product.price}</td>
                <td>${product.createDate}</td>
            </tr>

        </c:forEach>
    </table>




</div>


<jsp:include page="../template/header.jsp"/>