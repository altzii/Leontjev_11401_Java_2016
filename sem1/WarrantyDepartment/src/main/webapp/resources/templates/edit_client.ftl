<#include "main_template.ftl"/>

<#macro info_row>
</#macro>

<#macro m_body>
<div class="box-body" xmlns="http://www.w3.org/1999/html">
    <div class="col-md-3" style="width: 100%; padding-left: 25%; padding-right: 25%; padding-top: 15px">

        <#if !not_found??>
            <h1 align="center">Клиент №${client.id}</h1>

            <div class="box box-primary">
                <div class="box-body box-profile" style="box-shadow: 0 1px 1px rgba(0, 0, 0, 0.34); ">
                    <@form.form commandName="client_form" action="/operator/edit/clients/${client.id}" acceptCharset="UTF-8" method="post">
                        <ul class="list-group list-group-unbordered">
                            <li class="list-group-item">
                                <b>Имя</b>
                                <@form.input type="text"  value="${client.name}" name="name" path="name" class="form-control"/>
                                <p align="center"><@form.errors path="name" cssStyle="color: #ab2020;" /></p>

                                <b>Адрес</b>
                                <@form.input path="address" value="${client.address}" type="text" class="form-control" id="address"
                                name="address"/>
                                <p align="center"><@form.errors path="address" cssStyle="color: #ab2020;" /></p>

                                <b>Телефон</b>
                                <@form.input path="phone" value="${client.phone}" type="text" class="form-control" id="phone"
                                name="phone"/>
                                <p align="center"><@form.errors path="phone" cssStyle="color: #ab2020;" /></p>
                            </li>
                        </ul>
                        <button type="submit" class="btn btn-primary btn-block">Обновить данные клиента</button>
                    </@form.form>
                </div><!-- /.box-body -->
            </div><!-- /.box -->
        <#else>
            <h3 align="center">Такого клиента не существует</h3>
        </#if>
    </div>
</div>
</#macro>

<#macro m_body_header>
<div class="box-header" style="padding: 10px 10px 0px 0px;">
    <a href="/operator/clients">
        <button class="btn btn-default" style="padding: 4px 8px; margin: -2px; float: right;"><i
                class="fa fa-back"></i> Назад к клиентам
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

<@main title="Редактирование клиента"/>