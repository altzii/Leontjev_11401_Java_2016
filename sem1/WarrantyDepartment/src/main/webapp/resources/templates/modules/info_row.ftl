<!-- Small boxes (Stat box) -->
<div class="row">
    <div class="col-lg-3 col-xs-6">
        <!-- small box -->
        <div class="small-box bg-aqua">
            <div class="inner">
                <h3>${new_orders_size}</h3>
                <p>новые заявки</p>
            </div>
            <div class="icon">
                <i class="ion ion-bag"></i>
            </div>
            <a href="/operator/orders" class="small-box-footer">Подробнее <i class="fa fa-arrow-circle-right"></i></a>
        </div>
    </div><!-- ./col -->
    <div class="col-lg-3 col-xs-6">
        <!-- small box -->
        <div class="small-box bg-green">
            <div class="inner">
                <h3>${orders_size}</h3>
                <p>число заявок</p>
            </div>
            <div class="icon">
                <i class="ion ion-stats-bars"></i>
            </div>
            <a href="/operator/orders" class="small-box-footer">Подробнее <i class="fa fa-arrow-circle-right"></i></a>
        </div>
    </div><!-- ./col -->
    <div class="col-lg-3 col-xs-6">
        <!-- small box -->
        <div class="small-box bg-yellow">
            <div class="inner">
                <h3>${clients_size}</h3>
                <p>клиенты</p>
            </div>
            <div class="icon">
                <i class="ion ion-person-add"></i>
            </div>
            <a href="/operator/clients" class="small-box-footer">Подробнее <i class="fa fa-arrow-circle-right"></i></a>
        </div>
    </div><!-- ./col -->
    <div class="col-lg-3 col-xs-6">
        <!-- small box -->
        <div class="small-box bg-red">
            <div class="inner">
                <h3>${operators_size}</h3>
                <p>операторы</p>
            </div>
            <div class="icon">
                <i class="ion ion-pie-graph"></i>
            </div>
            <a href="/admin/users" class="small-box-footer">Подробнее <i class="fa fa-arrow-circle-right"></i></a>
        </div>
    </div><!-- ./col -->
</div><!-- /.row -->