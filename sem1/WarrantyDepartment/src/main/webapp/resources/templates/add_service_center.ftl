<#include "main_template.ftl"/>

<#macro info_row>
</#macro>


<#macro m_body_header>

<a href="/operator/service_centers">
    <div class="box-header">
        <button class="btn btn-default" style="padding: 4px 8px; margin: -2px; float: right;"><i
                class="fa fa-back"></i> Назад к сервисным центрам
        </button>
    </div>
</a>
</#macro>

<#macro m_body>
<div class="box-body">
    <div class="col-md-6" style="width:100%; padding-left: 22%; padding-right: 22%; margin-bottom: 50px">
        <div class="box box-primary" style="box-shadow: 0 1px 1px rgba(0, 0, 0, 0.25)">
            <div class="box-header with-border">
                <h3 class="box-title">Добавить сервисный центр</h3>
            </div><!-- /.box-header -->
            <!-- form start -->
            <form role="form" action="/operator/service_centers/add" method="post">
                <div class="box-body">
                    <div class="form-group">
                        <label for="name">Сервисный центр</label>
                        <input required="required" type="text" maxlength="100" class="form-control" id="name"
                               name="name"
                               placeholder="Введите наименование">
                        <br>
                        <input required="required" type="text" maxlength="100" class="form-control" id="phone"
                               name="phone"
                               placeholder="Введите телефон">
                        <br>
                        <input required="required" type="text" maxlength="100" class="form-control" id="address"
                               name="address"
                               placeholder="Введите адрес">
                    </div>
                </div><!-- /.box-body -->
                <div class="box-footer">
                    <button type="submit" class="btn btn-primary">Добавить</button>
                </div>
            </form>
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

<@main title="Управление сервисными центрами"/>