<#include "main_template.ftl"/>

<#macro info_row>
</#macro>


<#macro m_body_header>
<div class="box-header">
    <h3 class="box-title">Типы устройств</h3>
    <a href="/operator/device_types/add">
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
            <th>Наименование</th>
            <th>Редактировать</th>
        </tr>
        </thead>
        <tbody>
            <#if device_types??>
                <#list device_types as device_type>
                <tr>
                    <td>${device_type.id}</td>
                    <td>${device_type.name}</td>
                    <td>
                        <form method="post" action="/operator/delete/device_types/${device_type.id}">
                            <button onclick="return confirm('Вы уверены, что хотите удалить этот тип устройства?')"
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

<@main title="Типы устройств"/>