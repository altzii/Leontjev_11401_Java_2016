<#include "main_template.ftl"/>

<#macro info_row>
</#macro>


<#macro m_body_header>
<div class="box-header">
    <h3 class="box-title">Производители техники</h3>
    <a href="/operator/brands/add">
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
            <#if brands??>
                <#list brands as brand>
                <tr>
                    <td>${brand.name}</td>
                    <td>
                        <form id="deleteBrand${brand.id}" method="post"
                              action="/operator/delete/brands/${brand.id}">
                        </form>

                        <script>
                            function confirmDelete() {
                                if (confirm("Вы подтверждаете удаление?")) {
                                    document.getElementById('deleteDeviceType${brand.id}').submit();
                                } else {
                                    return false;
                                }
                            }
                        </script>

                        <a href="#" style="padding-left: 4px;"
                           onclick="confirmDelete();">
                            <i class="fa fa-trash-o"></i>
                        </a>
                        <a style="padding-left: 4px;" href="/operator/edit/brands/${brand.id}"><i
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

<@main title="Производители техники"/>