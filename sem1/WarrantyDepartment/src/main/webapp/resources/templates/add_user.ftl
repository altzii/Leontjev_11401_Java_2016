<#include "main_template.ftl"/>

<#macro info_row>
</#macro>


<#macro m_body_header>
<div class="box-header">
    <a href="/admin/users/">
        <button class="btn btn-default" style="padding: 4px 8px; margin: -2px; float: right;"><i
                class="fa fa-back"></i> Назад к пользователям
        </button>
    </a>
</div>
</#macro>

<#macro m_body>
<div class="box-body">
    <div class="col-md-6" style="width:100%; padding-left: 22%; padding-right: 22%; margin-bottom: 50px">
        <div class="box box-primary" style="box-shadow: 0 1px 1px rgba(0, 0, 0, 0.25)">
            <div class="box-header with-border">
                <h3 class="box-title">Добавить пользователя</h3>
            </div><!-- /.box-header -->
            <!-- form start -->

            <@form.form commandName="user_form" action="/admin/users/add" acceptCharset="UTF-8"  method="post">
                <div class="box-body">
                    <div class="form-group">
                        <label for="name">Пользователь</label>
                        <@form.input path="login" type="text" maxlength="100" class="form-control" id="login"
                        name="login"
                        placeholder="Введите логин"/>
                        <br>
                        <p align="center"><@form.errors path="login" cssStyle="color: #ab2020;" /></p>
                        <@form.input path="email" type="email" maxlength="100" class="form-control" id="email"
                        name="email"
                        placeholder="Введите email"/>
                        <br>
                        <p align="center"><@form.errors path="email" cssStyle="color: #ab2020;" /></p>
                        <@form.input path="password" type="password" maxlength="100" class="form-control" id="password"
                        name="password"
                        placeholder="Введите пароль"/>
                        <br>
                        <p align="center"><@form.errors path="password" cssStyle="color: #ab2020;" /></p>
                        <@form.select path="role" id="role" name="role" class="form-control">
                            <option>ROLE_ADMIN</option>
                            <option>ROLE_OPERATOR</option>
                        </@form.select>
                        <p align="center"><@form.errors path="role" cssStyle="color: #ab2020;" /></p>
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
    $("#email").attr('required', '');
    $("#password").attr('required', '');
    $("#login").attr('required', '');
    $("#address").attr('required', '');
</script>
</#macro>



<#macro box>
<div class="box">
    <@m_body_header/>
    <@m_body/>
</div>
</#macro>

<@main title="Управление пользователями"/>