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
            <th>Наименование</th>
            <th>Действия</th>
        </tr>
        </thead>
        <tbody>
            <#if device_types??>
                <#list device_types as device_type>
                <tr>

                    <td>${device_type.name}</td>
                    <td>
                        <form id="deleteDeviceType${device_type.id}" method="post"
                              action="/operator/delete/device_types/${device_type.id}">
                        </form>

                        <script>
                            function confirmDelete() {
                                if (confirm("Вы подтверждаете удаление?")) {
                                    document.getElementById('deleteDeviceType${device_type.id}').submit();
                                } else {
                                    return false;
                                }
                            }
                        </script>

                        <a href="#" style="padding-left: 4px;"
                           onclick="confirmDelete();">
                            <i class="fa fa-trash-o"></i>
                        </a>
                        <a style="padding-left: 4px;" href="/operator/edit/device_types/${device_type.id}"><i
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

<@main title="Типы устройств"/>