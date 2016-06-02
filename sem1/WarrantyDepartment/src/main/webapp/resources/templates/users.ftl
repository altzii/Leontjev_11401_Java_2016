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
            <th>Логин</th>
            <th>email</th>
            <th>Роль</th>
            <th>Действия</th>
        </tr>
        </thead>
        <tbody>
            <#if users??>
                <#list users as user>
                <tr>
                    <td>${user.login}</td>
                    <td>${user.email}</td>
                    <td>${user.role}</td>
                    <td>
                        <a href="/operator/users/${user.id}" <i class="fa fa-eye"></i>

                        <form id="deleteUser${user.id}" method="post"
                              action="/admin/delete/users/${user.id}">
                        </form>

                        <script>
                            function confirmDelete() {
                                if (confirm("Вы подтверждаете удаление?")) {
                                    document.getElementById('deleteUser${user.id}').submit();
                                } else {
                                    return false;
                                }
                            }
                        </script>

                        <a href="#" style="padding-left: 4px;"
                           onclick="confirmDelete();">
                            <i class="fa fa-trash-o"></i>
                        </a>
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