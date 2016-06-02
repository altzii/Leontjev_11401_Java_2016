<#include "main_template.ftl"/>

<#macro info_row>
</#macro>


<#macro m_body_header>
<div class="box-header">
    <input id="search" type="text" name="search" class="form-control" oninput="sortOrders()"
           style="width: 25%; display: initial; margin-left: 10px" placeholder="Поиск">

    <select id="sort" name="sort" onchange="sortOrders()" class="form-control"
            style="width: 15%; display: inline; float: left">
        <option selected disabled>Сортировать по</option>
        <option value="id_asc">Номеру (возр.)</option>
        <option value="id_desc">Номеру (убыв.)</option>
        <option value="client_asc">Клиенту (возр.)</option>
        <option value="client_desc">Клиенту (убыв.)</option>
        <option value="status_asc">Статусу (возр.)</option>
        <option value="status_desc">Статусу (убыв.)</option>
    </select>

    <a href="/operator/orders/add">
        <button class="btn btn-default" style="padding: 4px 8px; margin: -2px; float: right;"><i
                class="fa fa-plus"></i> Добавить
        </button>
    </a>
</div>
</#macro>



<#macro m_body>

<div class="box-body">
    <div id="heh"></div>
    <table id="example2" class="table table-bordered table-hover">
        <thead>
        <tr>
            <th>Номер</th>
            <th>Дата заявки</th>
            <th>Тип устройства</th>
            <th>Производитель</th>
            <th>Модель</th>
            <th>Неисправность</th>
            <th>Клиент</th>
            <th>Статус</th>
            <th>Действие</th>
        </tr>
        </thead>
        <tbody id="orders">
            <#if orders??>
                <#list orders as order>
                <tr>
                    <td>${order.id}</td>
                    <td>${order.orderDate}</td>
                    <td>${order.deviceType.name}</td>
                    <td>${order.brand.name}</td>
                    <td>${order.model}</td>
                    <td>${order.defect}</td>
                    <td>${order.client.name}</td>
                    <td>${order.status.name}</td>
                    <td>


                        <a href="/operator/orders/${order.id}" <i class="fa fa-eye"></i>

                        <@security.authorize access="hasRole('ROLE_ADMIN')">
                            <form id="deleteOrder${order.id}" method="post" action="/admin/delete/orders/${order.id}">
                            </form>


                            <a href="#" style="padding-left: 4px;"
                               onclick="confirmDelete(${order.id});">
                                <i class="fa fa-trash-o"></i>
                            </a>
                        </@security.authorize>
                        <a style="padding-left: 4px;" href="/operator/edit/orders/${order.id}"><i
                                class="fa fa-edit"></i></a>

                    </td>
                </tr>
                </#list>
            </#if>
        </tbody>
    </table>
</div>


<script type="application/javascript">
    sortOrders = function () {
        $.ajax({
            global: false,
            url: "/operator/orders_sort",
            data: {"sort": $("#sort").val(), "search": $("#search").val()},
            dataType: "json",
            async: false,
            success: function (response_data) {
                orders = $("#orders");
                if (response_data.length > 0) {
                    orders.html("");
                    for (var i = 0; i < response_data.length; i++) {

                        orders.append("<tr><td>" + response_data[i].id + "</td><td>" +
                                response_data[i].orderDate + "</td><td>" + response_data[i].deviceType.name +
                                "</td><td>" + response_data[i].brand.name + "</td><td>" + response_data[i].model
                                + "</td><td>" + response_data[i].defect + "</td>"
                                + "</td><td>" + response_data[i].client.name + "</td>"
                                + "</td><td>" + response_data[i].status.name + "</td>"
                                + "</td><td id='order" + response_data[i].id + "'></td></tr>");

                        $('#order' + response_data[i].id).html("<a href='/operator/orders/" + response_data[i].id + "' <i class='fa fa-eye'></i>" +
                                "  <form id='deleteOrder" + response_data[i].id + "' method=\"post\" action='/admin/delete/orders/" + response_data[i].id + "'> </form></a>" +
                                "<a href='' style='padding-left: 4px;' onclick='confirmDelete(" + response_data[i].id + ");'> <i class='fa fa-trash-o'></i> </a>" +
                                "<a style='padding-left: 4px;' href='/operator/edit/orders/" + response_data[i].id + "'><i class='fa fa-edit'></i></a>");


                    }
                }
                else {
                    orders.html("");
                }
            }
        })
        ;
    };

    function confirmDelete(id) {
        if (confirm("Вы подтверждаете удаление?")) {
            var form = document.getElementById('deleteOrder' + id);
            form.submit();
        } else {
            return false;
        }
    }
</script>



</#macro>


<#macro box>
<div class="box">
    <@m_body_header/>
    <@m_body/>
</div>
</#macro>

<@main title="Заявки клиентов"/>