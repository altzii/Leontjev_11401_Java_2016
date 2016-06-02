<#include "main_template.ftl"/>

<#macro info_row>
</#macro>

<#macro m_body_header>

<div class="box-header" style="padding: 10px 10px 0px 0px;">
    <a href="/operator/service_centers">
        <button class="btn btn-default" style="padding: 4px 8px; margin: -2px; float: right;"><i
                class="fa fa-back"></i> К списку сервисных центров
        </button>
    </a>
</div>

</#macro>

<#macro m_body>
<div class="box-body">
    <#if !not_found??>
        <h3 align="center">Сервисный центр №${service_center.id}</h3>

        <table class="table table-striped">
            <tbody>

            <tr>
                <td><b>Название</b></td>
                <td>${service_center.name}</td>
            </tr>
            <tr>
                <td><b>Адрес</b></td>
                <td>${service_center.address}</td>
            </tr>
            <tr>
                <td><b>Телефон</b></td>
                <td>${service_center.phone}</td>
            </tr>
        </table>

        <div class="box-footer" align="right">
            <a href="/operator/edit/service_centers/${service_center.id}">
                <button class="btn btn-primary">Редактировать</button>
            </a>
        </div>
    <#else>
        <h3 align="center">Такого сервисного центра не существует</h3>
    </#if>
</div>
</#macro>



<#macro box>
<div class="box">
    <@m_body_header/>
    <@m_body/>
</div>
</#macro>

<@main title="Просмотр сервисного центра"/>