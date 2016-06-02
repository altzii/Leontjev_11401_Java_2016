<#include "main_template.ftl"/>

<#macro info_row>
</#macro>


<#macro m_body_header>
<div class="box-header">
    <h3 class="box-title">Управление клиентами</h3>
    <a href="/operator/clients/add">
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
            <th>Клиент</th>
            <th>Номер</th>
            <th>Адрес</th>
            <th>Действия</th>
        </tr>
        </thead>
        <tbody>
            <#if clients??>
                <#list clients as client>
                <tr>
                    <td>${client.name}</td>
                    <td>${client.phone}</td>
                    <td>${client.address}</td>
                    <td>
                        <a href="/operator/clients/${client.id}" <i class="fa fa-eye"></i>

                        <@security.authorize access="hasRole('ROLE_ADMIN')">
                            <form id="deleteClient${client.id}" method="post"
                                  action="/operator/delete/clients/${client.id}">
                            </form>

                            <script>
                                function confirmDelete() {
                                    if (confirm("Вы подтверждаете удаление?")) {
                                        document.getElementById('deleteClient${client.id}').submit();
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
                        <a style="padding-left: 4px;" href="/operator/edit/clients/${client.id}"><i
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

<@main title="Клиенты"/>