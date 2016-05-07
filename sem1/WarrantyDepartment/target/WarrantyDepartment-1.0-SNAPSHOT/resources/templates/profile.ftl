<#include "main_template.ftl"/>

<#macro info_row>
</#macro>

<#macro m_body>
<div class="box-body" xmlns="http://www.w3.org/1999/html">
    <div class="col-md-3" style="width: 100%; padding-left: 25%; padding-right: 25%; padding-top: 15px">
        <!-- Profile Image -->
        <div class="box box-primary">
            <div class="box-body box-profile" style="box-shadow: 0 1px 1px rgba(0, 0, 0, 0.34); ">
                <img class="profile-user-img img-responsive img-circle" src="/resources/dist/img/avatar5.png"
                     alt="User profile picture">
                <h3 class="profile-username text-center">${user.login}</h3>
                <p class="text-muted text-center">${user.role}</p>

                <@form.form commandName="profile_form" action="/profile/update" acceptCharset="UTF-8"  method="post">
                    <ul class="list-group list-group-unbordered">
                        <li class="list-group-item">
                            <b>Логин</b> <input type="text"  <#if user.client??>disabled</#if> name="login"
                                                class="form-control"
                                                placeholder="${user.login}"">
                        </li>
                        <li class="list-group-item">
                            <b>email</b> <input type="email" <#if user.client??>disabled</#if> name="email"
                                                class="form-control"
                                                placeholder="${user.email}">
                        </li>
                        <#if user.client??>
                            <li class="list-group-item">
                                <b>ФИО</b> <@form.input type="text" value="${user.client.name}" name="name" path="name" class="form-control"
                            placeholder="${user.client.name}"/>
                                <p align="center"><@form.errors path="name" cssStyle="color: #ab2020;" /></p>
                            </li>


                            <li class="list-group-item">
                                <b>Номер
                                    телефона</b> <@form.input type="text" value="${user.client.phone}" name="phone"  path="phone" class="form-control"
                            placeholder="${user.client.phone}"/>
                                <p align="center"><@form.errors path="phone" cssStyle="color: #ab2020;" /></p>

                            </li>
                            <li class="list-group-item">
                                <b>Адрес</b> <@form.input type="text"  value="${user.client.address}" name="address" path="address" class="form-control"
                            placeholder="${user.client.address}"/>
                                <p align="center"><@form.errors path="address" cssStyle="color: #ab2020;" /></p>
                            </li>

                        </#if>
                    </ul>
                    <button type="submit" class="btn btn-primary btn-block">Обновить данные</button>
                </@form.form>
            </div><!-- /.box-body -->
        </div><!-- /.box -->
    </div>
</div>
</#macro>

<#macro m_body_header>
</#macro>

<#macro box>

<div class="box">
    <@m_body/>
</div>

</#macro>

<@main title="Профиль"/>