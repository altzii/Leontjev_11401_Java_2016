<#include "main_template.ftl"/>

<#macro info_row>
</#macro>

<#macro m_body_header>

    <div class="box-header" style="padding: 10px 10px 0px 0px;">
        <a href="/operator/orders">
        <button class="btn btn-default" style="padding: 4px 8px; margin: -2px; float: right;"><i
                class="fa fa-back"></i> Назад к заявкам
        </button>
        </a>
    </div>

</#macro>

<#macro m_body>
<div class="box-body">
    <h1 align="center">Заявка №${order.id}</h1>

    <table class="table table-striped">
        <tbody>
        <tr>
            <td><b>Дата заявки</b></td>
            <td>${order.orderDate}</td>
        </tr>
        <tr>
            <td><b>Клиент</b></td>
            <td>${order.client.name}</td>
        </tr>
        <tr>
            <td><b>Адрес клиента</b></td>
            <td>${order.client.address}</td>
        </tr>
        <tr>
            <td><b>Телефон клиента</b></td>
            <td>${order.client.phone}</td>
        </tr>
        <tr>
            <td><b>Дата покупки клиентом</b></td>
            <td>${order.purchaseDate}</td>
        </tr>
        <tr>
            <td><b>Тип устройства</b></td>
            <td>${order.deviceType.name}</td>
        </tr>
        <tr>
            <td><b>Производитель</b></td>
            <td>${order.brand.name}</td>
        </tr>
        <tr>
            <td><b>Модель</b></td>
            <td>${order.model}</td>
        </tr>
        <tr>
            <td><b>Неисправность</b></td>
            <td>${order.defect}</td>
        </tr>

            <#if order.serviceCenter??>
            <tr>
                <td><b>Отправлен в АСЦ</b></td>
                <#if order.sentDate??>
                <td>${order.sentDate}</td>
                <#else>
                <td>Дата не задана</td>
                </#if>
            </tr>
            <tr>
                <td><b>Адрес АСЦ</b></td>
                <td>${order.serviceCenter.address}</td>
            </tr>
            <tr>
                <td><b>Телефон АСЦ</b></td>
                <td>${order.serviceCenter.phone}</td>
            </tr>
            </#if>

        <tr>
            <td><b>Статус</b></td>
            <td>${order.status.name}</td>
        </tr>
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

<@main title="Заявка №${order.id}"/>