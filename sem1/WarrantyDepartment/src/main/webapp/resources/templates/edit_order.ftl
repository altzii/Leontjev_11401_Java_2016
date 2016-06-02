<#include "main_template.ftl"/>

<#macro info_row>
</#macro>

<#macro m_body>
<div class="box-body" xmlns="http://www.w3.org/1999/html">
    <div class="col-md-3" style="width: 100%; padding-left: 25%; padding-right: 25%; padding-top: 15px">
        <!-- Profile Image -->
        <h2 align="center">Заявка №${order.id}</h2>

        <div class="box box-primary">
            <div class="box-body box-profile" style="box-shadow: 0 1px 1px rgba(0, 0, 0, 0.34); ">
                <@form.form commandName="order_form" action="/operator/edit/orders/${order.id}" acceptCharset="UTF-8"  method="post">
                    <ul class="list-group list-group-unbordered">
                        <li class="list-group-item">
                            <b>Клиент</b>
                            <@form.select path="clientId" id="clientId" name="clientId" class="form-control">
                                <#if clients??>
                                    <#list clients as client>
                                        <option  <#if order.client.id == client.id> selected </#if>
                                                                                    value="${client.id}">${client.name}</option>
                                    </#list>
                                </#if>
                            </@form.select>
                            <p align="center"><@form.errors path="clientId" cssStyle="color: #ab2020;" /></p>

                            <b>Тип устройства</b>
                            <@form.select path="deviceTypeId" id="deviceTypeId" name="deviceTypeId" class="form-control">
                                <#if device_types??>
                                    <#list device_types as device_type>
                                        <option  <#if order.deviceType.id == device_type.id> selected </#if>
                                                                                             value="${device_type.id}">${device_type.name}</option>
                                    </#list>
                                </#if>
                            </@form.select>
                            <p align="center"><@form.errors path="deviceTypeId" cssStyle="color: #ab2020;" /></p>

                            <b>Производитель</b>
                            <@form.select path="brandId" id="brandId" name="brandId" class="form-control">
                                <#if brands??>
                                    <#list brands as brand>
                                        <option  <#if order.brand.id == brand.id> selected </#if>
                                                                                  value="${brand.id}">${brand.name}</option>
                                    </#list>
                                </#if>
                            </@form.select>
                            <p align="center"><@form.errors path="brandId" cssStyle="color: #ab2020;" /></p>

                            <b>Модель</b>
                            <@form.input type="text"  value="${order.model}" name="model" path="model" class="form-control"
                            placeholder="${order.model}"/>
                            <p align="center"><@form.errors path="model" cssStyle="color: #ab2020;" /></p>

                            <b>Дата покупки</b>
                            <@form.input path="purchaseDate" type="date" class="form-control" id="purchaseDate"
                            name="purchaseDate"/>
                            <p align="center"><@form.errors path="purchaseDate" cssStyle="color: #ab2020;" /></p>

                            <b>Дата сдачи в АСЦ</b>

                            <#if !order.sentDate??>
                                <@form.input path="sentDate" type="date" class="form-control" id="sentDate"
                                name="sentDate"/>
                            <#else>
                                <@form.input path="sentDate" value="${order.sentDate}" type="date" class="form-control" id="sentDate"
                                name="sentDate"/>
                            </#if>

                            <p align="center"><@form.errors path="sentDate" cssStyle="color: #ab2020;" /></p>

                            <b>Неисправность<span class="required">*</span></b>
                            <@form.input type="text" value="${order.defect}" name="defect" path="defect" class="form-control"/>
                            <p align="center"><@form.errors path="defect" cssStyle="color: #ab2020;" /></p>

                            <b>Сервисный центр</b>
                            <@form.select path="serviceCenterId" id="serviceCenterId" name="serviceCenterId" class="form-control">
                                <#if service_centers??>
                                    <option <#if !order.serviceCenter??> selected </#if> value="-1">Не назначен
                                    </option>

                                    <#list service_centers as service_center>
                                        <option  <#if (order.serviceCenter??) && (order.serviceCenter.id == service_center.id)>
                                                selected     </#if>
                                                value="${service_center.id}">${service_center.name}</option>
                                    </#list>
                                </#if>
                            </@form.select>
                            <p align="center"><@form.errors path="serviceCenterId" cssStyle="color: #ab2020;" /></p>
                            <b>Статус</b>
                            <@form.select path="statusId" id="statusId" name="statusId" class="form-control">
                                <#if statuses??>
                                    <#list statuses as status>
                                        <option  <#if order.status.id == status.id> selected </#if>
                                                                                    value="${status.id}">${status.name}</option>
                                    </#list>
                                </#if>
                            </@form.select>
                            <p align="center"><@form.errors path="statusId" cssStyle="color: #ab2020;" /></p>
                        </li>
                    </ul>
                    <button type="submit" class="btn btn-primary btn-block">Обновить данные заказа</button>
                </@form.form>
            </div><!-- /.box-body -->
        </div><!-- /.box -->
    </div>
</div>
</#macro>

<#macro m_body_header>
<div class="box-header" style="padding: 10px 10px 0px 0px;">
    <a href="/operator/orders">
        <button class="btn btn-default" style="padding: 4px 8px; margin: -2px; float: right;"><i
                class="fa fa-back"></i> Назад к заявкам
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

<@main title="Редактирование заявки №${order.id}"/>