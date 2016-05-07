<#include "main_template.ftl"/>

<#macro info_row>
</#macro>


<#macro m_body_header>
<div class="box-header">
    <h3 class="box-title">Управление пользователями</h3>
    <a href="/admin/users/add">
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
            <th>ID</th>
            <th>Логин</th>
            <th>email</th>
            <th>Роль</th>
            <th>Редактировать</th>
        </tr>
        </thead>
        <tbody>
            <#if users??>
                <#list users as user>
                <tr>
                    <td>${user.id}</td>
                    <td>${user.login}</td>
                    <td>${user.email}</td>
                    <td>${user.role}</td>
                    <td>
                        <form method="post" action="/admin/delete/users/${user.id}">
                            <button onclick="return confirm('Вы уверене, что хотите удалить этого пользователя?')"
                                    class="btn btn-default" style="padding: 4px 8px; margin: -2px;" type="submit"><i
                                    class="fa fa-trash-o"></i> Удалить
                            </button>
                        </form>
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

<@main title="Пользователи"/>