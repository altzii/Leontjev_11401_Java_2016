<#include "main_template.ftl"/>

<#macro info_row>
</#macro>


<#macro m_body_header>
<div class="box-header">
    <h3 class="box-title">Сервисные центры</h3>
    <a href="/operator/service_centers/add">
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
            <th>Название</th>
            <th>Телефон</th>
            <th>Адрес</th>
            <th>Действия</th>
        </tr>
        </thead>
        <tbody>
            <#if service_centers??>
                <#list service_centers as service_center>
                <tr>
                    <td>${service_center.name}</td>
                    <td>${service_center.phone}</td>
                    <td>${service_center.address}</td>
                    <td>
                        <a href="/operator/service_centers/${service_center.id}" <i class="fa fa-eye"></i>

                        <form id="deleteServiceCenter${service_center.id}" method="post"
                              action="/operator/delete/service_centers/${service_center.id}">
                        </form>

                        <script>
                            function confirmDelete() {
                                if (confirm("Вы подтверждаете удаление?")) {
                                    document.getElementById('deleteServiceCenter${service_center.id}').submit();
                                } else {
                                    return false;
                                }
                            }
                        </script>

                        <a href="#" style="padding-left: 4px;"
                           onclick="confirmDelete();">
                            <i class="fa fa-trash-o"></i>
                        </a>
                        <a style="padding-left: 4px;" href="/operator/edit/service_centers/${service_center.id}"><i
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

<@main title="Сервисные центры"/>