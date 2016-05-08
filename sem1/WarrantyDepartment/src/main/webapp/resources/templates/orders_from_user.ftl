<#include "main_template.ftl"/>

<#macro info_row>
</#macro>


<#macro m_body_header>
<div class="box-header">
    <h3 class="box-title">Мои заявки</h3>
    <a href="/user/orders/add">
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
            <th>Тип устройства</th>
            <th>Производитель</th>
            <th>Модель</th>
            <th>Неисправность</th>
            <th>Дата заявки</th>
            <th>Статус</th>

        </tr>
        </thead>
        <tbody>
            <#if orders??>
                <#list orders as order>
                <tr>
                    <td>${order.id}</td>
                    <td>${order.deviceType.name}</td>
                    <td>${order.brand.name}</td>
                    <td>${order.model}</td>
                    <td>${order.defect}</td>
                    <td>${order.orderDate}</td>
                    <td>${order.status.name}</td>
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

<@main title="Мои заявки"/>