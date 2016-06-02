<#include "main_template.ftl"/>

<#macro info_row>
</#macro>

<#macro m_body>
<div class="box-body" xmlns="http://www.w3.org/1999/html">
    <div class="col-md-3" style="width: 100%; padding-left: 25%; padding-right: 25%; padding-top: 15px">

        <#if !not_found??>
            <h2 align="center">Статус</h2>

            <div class="box box-primary">
                <div class="box-body box-profile" style="box-shadow: 0 1px 1px rgba(0, 0, 0, 0.34); ">
                    <@form.form commandName="status_form" action="/operator/edit/statuses/${status.id}" acceptCharset="UTF-8" method="post">
                        <ul class="list-group list-group-unbordered">
                            <li class="list-group-item">
                                <b>Название</b>
                                <@form.input type="text"  value="${status.name}" name="name" path="name" class="form-control"/>
                                <p align="center"><@form.errors path="name" cssStyle="color: #ab2020;" /></p>
                            </li>
                        </ul>
                        <button type="submit" class="btn btn-primary btn-block">Обновить данные статуса</button>
                    </@form.form>
                </div><!-- /.box-body -->
            </div><!-- /.box -->
        <#else>
            <h3 align="center">Такого статуса не существует</h3>
        </#if>
    </div>
</div>
</#macro>

<#macro m_body_header>
<div class="box-header" style="padding: 10px 10px 0px 0px;">
    <a href="/operator/statuses">
        <button class="btn btn-default" style="padding: 4px 8px; margin: -2px; float: right;"><i
                class="fa fa-back"></i> Назад к статусам
        </button>
    </a>
</div>
</#macro>

<#macro box>

<div class="box">
    <@m_body_header/>
    <@m_body/>
</div>

</#macro>

<@main title="Редактирование статуса"/>