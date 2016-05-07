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
            <th>ID</th>
            <th>Наименование</th>
            <th>Редактировать</th>
        </tr>
        </thead>
        <tbody>
            <#if brands??>
                <#list brands as brand>
                <tr>
                    <td>${brand.id}</td>
                    <td>${brand.name}</td>
                    <td>
                        <form method="post" action="/operator/delete/brands/${brand.id}">

                            <button onclick="return confirm('Вы уверене, что хотите удалить этого производителя техники?')"
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

<@main title="Производители техники"/>