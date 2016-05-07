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
            <th>Редактировать</th>
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
                        <form method="post" action="/operator/delete/service_centers/${service_center      .id}">

                            <button onclick="return confirm('Вы уверене, что хотите удалить этот сервисный центр?')"
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

<@main title="Сервисные центры"/>