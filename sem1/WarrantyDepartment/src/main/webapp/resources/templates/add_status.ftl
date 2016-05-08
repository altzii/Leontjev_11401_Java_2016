<#include "main_template.ftl"/>

<#macro info_row>
</#macro>


<#macro m_body_header>
<div class="box-header">
    <a href="/operator/statuses">
        <button class="btn btn-default" style="padding: 4px 8px; margin: -2px; float: right;"><i
                class="fa fa-back"></i> Назад к статусам
        </button>
    </a>
</div>

</#macro>

<#macro m_body>
<div class="box-body">
    <div class="col-md-6" style="width:100%; padding-left: 22%; padding-right: 22%; margin-bottom: 50px">
        <div class="box box-primary" style="box-shadow: 0 1px 1px rgba(0, 0, 0, 0.25)">
            <div class="box-header with-border">
                <h3 class="box-title">Добавить статус</h3>
            </div><!-- /.box-header -->
            <!-- form start -->
            <@form.form commandName="status_form" action="/operator/statuses/add" acceptCharset="UTF-8" method="post">
                <div class="box-body">
                    <div class="form-group">
                        <label for="name">Статус</label>
                        <@form.input path="name" type="text" maxlength="100" class="form-control" id="name"
                        name="name"
                        placeholder="Введите название"/>
                    </div>
                    <p align="center"><@form.errors path="name" cssStyle="color: #ab2020;"/></p>
                </div><!-- /.box-body -->
                <div class="box-footer">
                    <button type="submit" class="btn btn-primary">Добавить</button>
                </div>
            </@form.form>
        </div>
    </div>
</div>
</#macro>

<#macro box>
<div class="box">
    <@m_body_header/>
    <@m_body/>
</div>
</#macro>

<@main title="Управление статусами"/>