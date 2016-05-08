<#include "main_template.ftl"/>

<#macro info_row>
</#macro>


<#macro m_body_header>
<div class="box-header">
    <h3 class="box-title">Заявки клиентов</h3>
    <a href="/operator/orders/add">
        <button class="btn btn-default" style="padding: 4px 8px; margin: -2px; float: right;"><i
                class="fa fa-plus"></i> Добавить
        </button>
    </a>
</div>
</#macro>



<#macro m_body>

<div class="box-body">
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
        <tbody>
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

                            <script>
                                function confirmDelete() {
                                    if (confirm("Вы подтверждаете удаление?")) {
                                        document.getElementById('deleteOrder${order.id}').submit();
                                    } else {
                                        return false;
                                    }
                                }

                            </script>

                            <a href="#" style="padding-left: 4px;"
                               onclick="confirmDelete();">
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







</#macro>


<#macro box>
<div class="box">
    <@m_body_header/>
    <@m_body/>
</div>
</#macro>

<@main title="Заявки клиентов"/>