<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>菜品类型管理 - ${seo.mainName}</title>
    <jsp:include page="../../common/link.jsp"/>
</head>
<body class="hold-transition skin-blue sidebar-mini">
<section class="content">
    <div class="row">
        <div class="col-xs-12">
            <div class="box">
                <div class="box-header">
                    <h3 class="box-title">菜品类型管理</h3>
                </div>
                <!-- /.box-header -->
                <div class="box-body">
                    <div id="GoodsTypeTableToolbar">
                        <button class="btn btn-primary" type="button" onclick="GoodsType.openAddGoodsType()">新增</button>
                        <button class="btn btn-primary"  type="button" onclick="GoodsType.openGoodsTypeDetail()">修改</button>
                        <button class="btn btn-primary"  type="button" onclick="GoodsType.delete()">删除</button>
                    </div>
                    <table id="GoodsTypeTable"></table>
                </div>
                <!-- /.box-body -->
            </div>
            <!-- /.box -->

        </div>
        <!-- /.col -->
    </div>
    <!-- /.row -->
</section>
<!-- Site wrapper -->
<jsp:include page="../../common/script.jsp"/>
<script src="/static/app/js/admin/goods_type/goods_type.js?v=0.1"></script>
</body>
</html>