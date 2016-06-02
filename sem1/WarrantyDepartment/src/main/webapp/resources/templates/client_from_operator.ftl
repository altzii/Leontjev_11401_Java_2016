<#include "main_template.ftl"/>

<#macro info_row>
</#macro>

<#macro m_body_header>

<div class="box-header" style="padding: 10px 10px 0px 0px;">
    <a href="/operator/clients">
        <button class="btn btn-default" style="padding: 4px 8px; margin: -2px; float: right;"><i
                class="fa fa-back"></i> К списку клиентов
        </button>
    </a>
</div>

</#macro>

<#macro m_body>
<div class="box-body">
    <#if !not_found??>
        <h3 align="center">Клиент №${client.id}</h3>

        <table class="table table-striped">
            <tbody>

            <tr>
                <td><b>Клиент</b></td>
                <td>${client.name}</td>
            </tr>
            <tr>
                <td><b>Адрес клиента</b></td>
                <td>${client.address}</td>
            </tr>
            <tr>
                <td><b>Телефон клиента</b></td>
                <td>${client.phone}</td>
            </tr>
            <tr>
                <td><b>Имеется аккаунт</b></td>
                <td><#if client.user??>Да<#else>Нет</#if></td>
            </tr>

                <#if client.user??>
                <tr>
                    <td><b>Логин</b></td>
                    <td><a href="/operator/users/${client.user.id}">${client.user.login}</a></td>
                </tr>
                </#if>
        </table>
        <div class="box-footer" align="right">
            <a href="/operator/edit/clients/${client.id}">
                <button class="btn btn-primary">Редактировать</button>
            </a>
        </div>
    <#else>
        <h3 align="center">Такого клиента не существует</h3>
    </#if>
</div>
</#macro>



<#macro box>
<div class="box">
    <@m_body_header/>
    <@m_body/>
</div>
</#macro>

<@main title="Просмотр клиента"/>