<#include "main_template.ftl"/>

<#macro info_row>
</#macro>


<#macro m_body_header>
<div class="box-header">
    <a href="/user/orders/">
        <button class="btn btn-default" style="padding: 4px 8px; margin: -2px; float: right;"><i
                class="fa fa-back"></i> Назад к моим заявкам
        </button>
    </a>
</div>
</#macro>

<#macro m_body>
<div class="box-body">
    <div class="col-md-6" style="width:100%; padding-left: 22%; padding-right: 22%; margin-bottom: 50px">
        <div class="box box-primary" style="box-shadow: 0 1px 1px rgba(0, 0, 0, 0.25)">
            <div class="box-header with-border">
                <h3 class="box-title">Добавить заявку</h3>
            </div><!-- /.box-header -->
            <!-- form start -->
            <@form.form commandName="order_form" action="/user/orders/add" acceptCharset="UTF-8"  method="post">
                <div class="box-body">
                    <div class="form-group">
                        <label for="device_type">Тип устройства</label>
                        <@form.select path="deviceTypeId" id="deviceTypeId" name="deviceTypeId" class="form-control">
                            <#if device_types??>
                                <#list device_types as device_type>
                                    <option value="${device_type.id}">${device_type.name}</option>
                                </#list>
                            </#if>
                        </@form.select>
                        <br>
                        <p align="center"><@form.errors path="deviceTypeId" cssStyle="color: #ab2020;" /></p>
                        <label for="device_type">Производитель</label>
                        <@form.select path="brandId" id="brandId" name="brandId" class="form-control">
                            <#if brands??>
                                <#list brands as brand>
                                    <option value="${brand.id}">${brand.name}</option>
                                </#list>
                            </#if>
                        </@form.select>
                        <br>
                        <p align="center"><@form.errors path="brandId" cssStyle="color: #ab2020;" /></p>
                        <label for="model">Модель</label>
                        <@form.input path="model" type="text" maxlength="100" class="form-control" id="model"
                        name="model"/>
                        <br>
                        <label for="defect">Неисправность<span class="required">*</span></label>                        <@form.input path="defect" type="text" class="form-control" id="defect"
                        name="defect"/>
                        <br>
                        <p align="center"><@form.errors path="defect" cssStyle="color: #ab2020;" /></p>
                        <label for="purchaseDate">Дата покупки</label>
                        <@form.input path="purchaseDate" type="date" class="form-control" id="purchaseDate"
                        name="purchaseDate"/>
                        <br>
                        <p align="center"><@form.errors path="purchaseDate" cssStyle="color: #ab2020;"/></p>
                    </div>
                </div><!-- /.box-body -->
                <div class="box-footer">
                    <button type="submit" class="btn btn-primary">Оставить заявку</button>
                </div>
            </@form.form>
        </div>
    </div>
</div>

<script>
</script>
</#macro>

<#macro box>
<div class="box">
    <@m_body_header/>
    <@m_body/>
</div>
</#macro>

<@main title="Оставить заявку"/>