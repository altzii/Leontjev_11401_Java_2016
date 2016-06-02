<#include "main_template.ftl"/>

<#macro info_row>
</#macro>

<#macro m_body_header>
    <@security.authorize access="hasRole('ROLE_ADMIN')">
    <div class="box-header" style="padding: 10px 10px 0px 0px;">
        <a href="/admin/users">
            <button class="btn btn-default" style="padding: 4px 8px; margin: -2px; float: right;"><i
                    class="fa fa-back"></i> Назад к пользователям
            </button>
        </a>
    </div>
    </@security.authorize>
</#macro>

<#macro m_body>
<div class="box-body">
    <#if !not_found??>
        <h3 align="center">Пользователь №${user.id}</h3>

        <table class="table table-striped">
            <tbody>
            <tr>
                <td><b>ID</b></td>
                <td>${user.id}</td>
            </tr>
            <tr>
                <td><b>Логин</b></td>
                <td>${user.login}</td>
            </tr>
            <tr>
                <td><b>email</b></td>
                <td>${user.email}</td>
            </tr>
                <#if user.client??>
                <tr>
                    <td><b>Клиент</b></td>
                    <td><a href="/operator/clients/${user.client.id}">${user.client.name}</a></td>
                </tr>
                </#if>
        </table>
    <#else>
        <h3 align="center">Такого пользователя не существует</h3>
    </#if>
</div>
</#macro>

<#macro box>
<div class="box">
    <@m_body_header/>
    <@m_body/>
</div>
</#macro>

<@main title="Пользователь"/>