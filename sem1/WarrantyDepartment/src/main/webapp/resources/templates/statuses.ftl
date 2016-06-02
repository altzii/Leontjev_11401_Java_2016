<#include "main_template.ftl"/>

<#macro info_row>
</#macro>


<#macro m_body_header>
<div class="box-header">
    <h3 class="box-title">Статусы</h3>
    <a href="/operator/statuses/add">
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
            <th>Статус</th>
            <th>Действия</th>
        </tr>
        </thead>
        <tbody>
            <#if statuses??>
                <#list statuses as status>
                <tr>
                    <td>${status.name}</td>
                    <td>
                        <form id="deleteStatus${status.id}" method="post"
                              action="/operator/delete/statuses/${status.id}">
                        </form>

                        <script>
                            function confirmDelete() {
                                if (confirm("Вы подтверждаете удаление?")) {
                                    document.getElementById('deleteStatus${status.id}').submit();
                                } else {
                                    return false;
                                }
                            }
                        </script>

                        <a href="#" style="padding-left: 4px;"
                           onclick="confirmDelete();">
                            <i class="fa fa-trash-o"></i>
                        </a>
                        <a style="padding-left: 4px;" href="/operator/edit/statuses/${status.id}"><i
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

<@main title="Статусы"/>