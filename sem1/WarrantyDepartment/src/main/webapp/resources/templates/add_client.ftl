<#include "main_template.ftl"/>

<#macro info_row>
</#macro>


<#macro m_body_header>
<div class="box-header">
    <a href="/operator/clients">
        <button class="btn btn-default" style="padding: 4px 8px; margin: -2px; float: right;"><i
                class="fa fa-back"></i> Назад к клиентам
        </button>
    </a>
</div>
</#macro>

<#macro m_body>
<div class="box-body">
    <div class="col-md-6" style="width:100%; padding-left: 22%; padding-right: 22%; margin-bottom: 50px">
        <div class="box box-primary" style="box-shadow: 0 1px 1px rgba(0, 0, 0, 0.25)">
            <div class="box-header with-border">
                <h3 class="box-title">Добавить клиента</h3>
            </div><!-- /.box-header -->
            <!-- form start -->
            <@form.form commandName="client_form" action="/operator/clients/add" acceptCharset="UTF-8"  method="post">
                <div class="box-body">
                    <div class="form-group">
                        <label for="name">Клиент</label>
                        <@form.input path="name" type="text" maxlength="100" class="form-control" id="name"
                        name="name"
                        placeholder="Введите ФИО"/>
                        <br>
                        <p align="center"><@form.errors path="name" cssStyle="color: #ab2020;" /></p>
                        <@form.input path="phone" type="text" maxlength="100" class="form-control" id="phone"
                        name="phone"
                        placeholder="Введите номер телефона"/>
                        <br>
                        <p align="center"><@form.errors path="phone" cssStyle="color: #ab2020;" /></p>
                        <@form.input path="address" type="text" maxlength="100" class="form-control" id="address"
                        name="address"
                        placeholder="Введите адрес"/>
                        <br>
                        <p align="center"><@form.errors path="address" cssStyle="color: #ab2020;" /></p>
                    </div>
                </div><!-- /.box-body -->
                <div class="box-footer">
                    <button type="submit" class="btn btn-primary">Добавить</button>
                </div>
            </@form.form>
        </div>
    </div>
</div>

<script>
    $("#name").attr('required', '');
    $("#phone").attr('required', '');
    $("#address").attr('required', '');
</script>
</#macro>



<#macro box>
<div class="box">
    <@m_body_header/>
    <@m_body/>
</div>
</#macro>

<@main title="Управление клиентами"/>