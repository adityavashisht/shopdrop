<jsp:include page="../template/header.jsp"/>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div class="container">
    <h3 class="page-header">Item Page</h3>



    <form:form method="post" id="itemForm" cssClass="form-horizontal" modelAttribute="itemForm">
        <form:hidden path="item.id"/>


        <div class="form-group">
            <label for="forName" class="col-sm-2 control-label">Name</label>

            <div class="col-sm-6">

                <form:input path="item.name" cssClass="form-control" id="forName" placeholder="Item Name"/>

                <form:errors path="item.name" id="error"/>

            </div>
        </div>


        <div class="form-group" style="margin-top:25px;">
            <label for="forPrice" class="col-sm-2 control-label">Price</label>

            <div class="col-sm-6">

                <form:input path="item.price" cssClass="form-control" id="forPrice" placeholder="Item Price"/>
                    <%--<input type="text" class="form-control" id="forName" placeholder="Item Name">--%>
            </div>
        </div>


        <div class="row">
            <div class="col-md-3">

            </div>

            <div class="col-md-4">
                <input type="submit" class="btn btn-success" value="Save">
            </div>
        </div>

    </form:form>


</div>


<jsp:include page="../template/header.jsp"/>