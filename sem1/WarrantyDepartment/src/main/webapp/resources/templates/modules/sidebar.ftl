<#assign security=JspTaglibs["http://www.springframework.org/security/tags"]/>

<aside class="main-sidebar">
    <!-- sidebar: style can be found in sidebar.less -->
    <div class="slimScrollDiv" style="position: relative; overflow: hidden; width: auto; height: 314px;">
        <section class="sidebar" style="height: 314px; overflow: hidden; width: auto;">
            <!-- Sidebar user panel -->
            <div class="user-panel">
                <div class="pull-left image">
                    <img src="/resources/dist/img/avatar5.png" class="img-circle img-responsive" alt="User Image">
                </div>
                <div class="pull-left info">
                    <p>${username}</p>
                    <a href="#"><i class="fa fa-circle text-success"></i> Онлайн</a>
                </div>
            </div>

            <!-- sidebar menu: : style can be found in sidebar.less -->
            <ul class="sidebar-menu">

                <li class="header">МЕНЮ</li>

            <@security.authorize access="hasAnyRole('ROLE_ADMIN','ROLE_OPERATOR')">
                <li class="treeview">
                    <a href="#">
                        <i class="fa fa-folder"></i> <span>Справочники</span>
                        <i class="fa fa-angle-left pull-right"></i>
                    </a>
                    <ul class="treeview-menu">
                        <li><a href="/operator/clients"><i class="fa fa-group "></i> Клиенты</a></li>
                        <li><a href="/operator/service_centers"><i class="fa fa-wrench"></i> Сервисные центры</a>
                        </li>
                        <li><a href="/operator/device_types"><i class="fa fa-laptop"></i> Типы устройств</a></li>
                        <li><a href="/operator/brands"><i class="fa fa-gear"></i> Производители</a></li>
                        <li><a href="/operator/statuses"><i class="fa fa-check-square-o"></i> Статусы заказов</a>
                        </li>
                <@security.authorize access="hasRole('ROLE_ADMIN')">
                        <li><a href="/admin/users"><i class="fa fa-circle-o"></i> Пользователи</a></li>
                </@security.authorize>
                    </ul>
                </li>
                <!--  <li class="treeview">
                   <a href="#">
                       <i class="fa fa-calendar"></i> <span>Заявки клиентов</span>
                       <i class="fa fa-angle-left pull-right"></i>
                   </a>
                  <ul class="treeview-menu">
                       <li><a href="#"><i class="fa fa-file-o"></i> Новые</a></li>
                       <li><a href="#"><i class="fa fa-table"></i> Все в работе</a></li>
                       <li><a href="#"><i class="fa fa-cogs"></i> На ремоне в АСЦ</a></li>
                       <li><a href="#"><i class="fa fa-check-square-o"></i> Закрытые</a>
                       </li>
                   </ul>
                </li>
                -->
                <li><a href="/operator/orders"><i class="fa  fa-area-chart"></i> <span>Заявки клиентов</span></a></li>
            </@security.authorize>
            <@security.authorize access="hasRole('ROLE_USER')">
                <li><a href="/user/orders"><i class="fa  fa-bar-chart-o"></i> <span>Мои заявки</span></a></li>
                <li><a href="/user/orders/add"><i class="fa  fa-file-text-o"></i> <span>Оставить заявку</span></a></li>
            </@security.authorize>
            </ul>
        </section>
        <div class="slimScrollBar"
             style="width: 3px; position: absolute; top: 0px; opacity: 0.4; display: none; border-radius: 7px; z-index: 99; right: 1px; height: 314px; background: rgba(0, 0, 0, 0.2);"></div>
        <div class="slimScrollRail"
             style="width: 3px; height: 100%; position: absolute; top: 0px; display: none; border-radius: 7px; opacity: 0.2; z-index: 90; right: 1px; background: rgb(51, 51, 51);"></div>
    </div>
    <!-- /.sidebar -->
</aside>