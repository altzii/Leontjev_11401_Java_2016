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
            <th>Редактировать</th>
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
                        <form method="post" action="/operator/delete/clients/${client.id}">
                            <button onclick="return confirm('Вы уверене, что хотите удалить этого клиента?')"
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

<@main title="Клиенты"/>