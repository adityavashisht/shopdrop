<jsp:include page="../template/header.jsp"/>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<div class="container">

    <h2 class="page-header">Items</h2>

    <table class="table table-condensed table-bordered table-striped table-hover">
        <thead>
        <tr>
            <th>Name</th>
            <th>Price</th>
            <th>Date</th>
        </tr>
        </thead>
        <tbody id="itemBody">


        </tbody>
    </table>

    <h2>Item</h2>

    <form id="itemForm" name="itemForm" class="form-horizontal">
        <input type="hidden" id="itemId" name="id">
        <input type="text" name="name" id="itemName" class="form-control" value=""/>
        <input type="text" name="price" id="itemPrice" class="form-control" value=""/>
        <input type="text" name="createDate" id="itemDate" class="form-control" value=""/>


        <button type="button" id="clickMe" class="btn btn-success">Save Item</button>


    </form>


</div>


<jsp:include page="../template/footer.jsp"/>


<script>

    /**
     * On page load execute this function
     */
    $(function () {

        // Reload the item list, fetch first time
        reloadItemList();

        // On clicking the button, save the item in the form
        $("#clickMe").click(function (event) {

            var formData = {};
            formData.name = $("#itemName").val();
            formData.price = $("#itemPrice").val();
            formData.id = $("#itemId").val();

            event.preventDefault();

            $.ajax({
                method: "POST",

                contentType: "application/json",

                data: JSON.stringify(formData),

                url: '<c:url value="/app/restItem"/>',

                success: function (data) {

                    reloadItemList();



                },

                error: function (data) {

                }

            });

        });

    });

    function itemSelector() {

        $(".itemSelect").click(function(event) {
            event.preventDefault();

            var item = $(this).attr('itemId');


            var id = item;
            var name = $(this).text();

            var nextTd = $(this).parent().next();

            var price = nextTd.text();

            var create = nextTd.next().text();



            $("#itemId").val(id);
            $("#itemName").val(name);
            $("#itemPrice").val(price);
            $("#itemDate").val(create);

            <%--var URL = '<c:url value="/app/restItem/"/>' + item;--%>

            <%--$.ajax({--%>
                <%--method: "GET",--%>
                <%--url: URL,--%>
                <%--success: function (data) {--%>
                    <%--var id = data.id;--%>
                    <%--var name = data.name;--%>
                    <%--var price = data.price;--%>
                    <%--var create = data.createDate;--%>

                    <%--$("#itemId").val(id);--%>
                    <%--$("#itemName").val(name);--%>
                    <%--$("#itemPrice").val(price);--%>
                    <%--$("#itemDate").val(create);--%>


                <%--},--%>
                <%--error : function(data) {--%>
                <%--}--%>
            <%--});--%>


        });
    }


    function reloadItemList() {
        $.ajax({
            method: "GET",
            url: '<c:url value="/app/restItem/all"/>',

            contentType: "application/json",

            success: function (data) {

                $("#itemBody").empty();

                var itemRows = '';

                $.each(data, function (i, value) {

                    var row = '<tr><td><a class="itemSelect" href="#!" itemId="'+ value.id + '">' + value.name + '</a></td>';
                    row += '<td>' + value.price + '</td>';

                    row += '<td>' + value.createDate + '</td></tr>';
                    itemRows += row;

                });

                $("#itemBody").append(itemRows);

                itemSelector();


            },

            error: function (data) {

            }

        });
    }
</script>
