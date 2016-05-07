<#include "main_template.ftl"/>

<#macro m_body>
</#macro>

<#macro m_body_header>
</#macro>

<#macro info_row>
    <#include "modules/info_row.ftl"/>
</#macro>

<#macro box>

    <@m_body_header/>
    <@m_body/>

</#macro>

<@main title="Главная страница"/>