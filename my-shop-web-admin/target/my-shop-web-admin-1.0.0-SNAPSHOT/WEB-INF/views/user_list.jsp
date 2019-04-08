<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="sys" tagdir="/WEB-INF/tags/sys" %>
<!DOCTYPE html>
<html>
<head>
    <title>我的商城 | 用户管理</title>
    <%-- 包含css --%>
    <jsp:include page="../includes/header.jsp" />
</head>
<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">
    <%-- 顶部导航条 --%>
    <jsp:include page="../includes/nav.jsp" />
    <%-- 左侧菜单 --%>
    <jsp:include page="../includes/menu.jsp" />

    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>
                用户管理
                <small></small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> 首页</a></li>
                <li class="active">用户管理</li>
            </ol>
        </section>

        <!-- Main content -->
        <section class="content">
            <!-- /.row -->
            <div class="row">
                <div class="col-xs-12">
                    <c:if test="${baseResult != null}">
                        <div class="alert alert-${baseResult.status == 200 ? "success" : "danger"} alert-dismissible">
                            <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
                                ${baseResult.message}
                        </div>
                    </c:if>
                    <div class="box box-info box-info-search" style="display: none;">
                        <div class="box-header">
                            <h3 class="box-title">高级搜索</h3>

                            <div class="row" STYLE="padding-top: 20PX">
                                <form:form cssClass="form-horizontal" action="/user/search" method="post" modelAttribute="tbUser">
                                    <div class="row">
                                        <div class="box-body">

                                        <div class="col-xs-12 col-sm-3">
                                            <div class="form-group">
                                                <label for="username" class="col-sm-4 control-label">姓名</label>

                                                <div class="col-sm-8">
                                                    <form:input path="username" cssClass="form-control" placeholder="姓名"/>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-xs-12 col-sm-3">
                                            <div class="form-group">
                                                <label for="email" class="col-sm-4 control-label">邮箱</label>

                                                <div class="col-sm-8">
                                                    <form:input path="email" cssClass="form-control" placeholder="邮箱"/>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-xs-12 col-sm-3">
                                            <div class="form-group">
                                                <label for="phone" class="col-sm-4 control-label">手机</label>

                                                <div class="col-sm-8">
                                                    <form:input path="phone" cssClass="form-control" placeholder="手机"/>
                                                </div>
                                            </div>
                                        </div>

                                        <div class="col-xs-12 col-sm-3">
                                            <div class="row">
                                                <div class="col-xs-12">
                                                    <button type="submit" class="btn btn-info">搜索</button>
                                                </div>
                                            </div>
                                        </div>
                                        </div>
                                    </div>

                                </form:form>
                            </div>
                        </div>
                    </div>
                    <div class="box">
                        <div class="box-header">
                            <h3 class="box-title">用户列表</h3>

                            <div class="row" style="padding-top: 20px">
                                <div class="col-xs-12">
                                    <a href="/user/form" type="button" class="btn btn-sm btn-default"><i class="fa fa-plus"></i> 新增</a>&nbsp;
                                    <button href="#" type="button" class="btn btn-sm btn-default" onclick="App.deleteMulti('/user/delete')"><i class="fa fa-trash-o"></i> 删除</button>&nbsp;
                                    <a href="#" type="button" class="btn btn-sm btn-default"><i class="fa fa-download"></i> 导入</a>&nbsp;
                                    <a href="#" type="button" class="btn btn-sm btn-default"><i class="fa fa-upload"></i> 导出</a>&nbsp;
                                    <button type="button" class="btn btn-sm btn-primary" onclick="$('.box-info-search').css('display') == 'none' ? $('.box-info-search').show('fast') : $('.box-info-search').hide('fast')"><i class="fa fa-search"></i> 搜索</button>
                                </div>
                            </div>
                        </div>

                        <!-- /.box-header -->
                        <div class="box-body table-responsive no-padding">
                            <table class="table table-hover">
                                <thead>
                                    <tr>
                                        <th><input type="checkbox" class="minimal icheck_master"></th>
                                        <th>ID</th>
                                        <th>用户名</th>
                                        <th>手机号</th>
                                        <th>邮箱</th>
                                        <th>创建时间</th>
                                        <th>更新时间</th>
                                        <th>操作</th>
                                    </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${tbUsers}" var="tbUser">
                                    <tr>
                                        <td><input id="${tbUser.id}" type="checkbox" class="minimal"></td>
                                        <td>${tbUser.id}</td>
                                        <td>${tbUser.username}</td>
                                        <td>${tbUser.phone}</td>
                                        <td>${tbUser.email}</td>
                                        <td><fmt:formatDate value="${tbUser.created}" pattern="yyyy-MM-dd HH:mm:ss"/> </td>
                                        <td><fmt:formatDate value="${tbUser.updated}" pattern="yyyy-MM-dd HH:mm:ss"/> </td>
                                        <td>
                                            <a href="#" type="button" class="btn btn-sm btn-default"><i class="fa fa-search"></i> 查看</a>&nbsp;
                                            <a href="#" type="button" class="btn btn-sm btn-primary"><i class="fa fa-edit"></i> 编辑</a>&nbsp;
                                            <a href="#" type="button" class="btn btn-sm btn-danger"><i class="fa fa-trash-o"></i> 删除</a>
                                        </td>
                                    </tr>
                                </tbody>
                                </c:forEach>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </section>
    </div>
    <%-- 导入版权信息 --%>
    <jsp:include page="../includes/copyright.jsp" />
</div>

<%-- 导入footer.jsp 内含js--%>
<jsp:include page="../includes/footer.jsp"/>

<%-- 自定义模态框 --%>
<sys:modal/>
<%--<script>--%>
<%--    // 定义一个存放 ID 得数组--%>
<%--    var idArray = new Array();--%>
<%--    /**--%>
<%--     * 批量删除--%>
<%--     */--%>
<%--    function deleteMulti() {--%>
<%--        // 将选中元素得 ID 放入数组中--%>
<%--        var _checkbox = App.getCheckBox();--%>
<%--        _checkbox.each(function () {--%>
<%--            var _id = $(this).attr("id");--%>
<%--            if (_id != null && _id != "undefine" && $(this).is(":checked")) {--%>
<%--                idArray.push(_id);--%>
<%--            }--%>
<%--        });--%>

<%--        if (idArray.length === 0) {--%>
<%--            $("#modal-message").html("您还没有选中任何数据项, 请至少选中一项");--%>
<%--        } else {--%>
<%--            $("#modal-message").html("您确定删除数据项嘛?");--%>
<%--        }--%>

<%--        $("#modal-default").modal("show");--%>
<%--    }--%>

<%--    $(function () {--%>
<%--        $("#btnModalOK").bind("click", function () {--%>
<%--            del(idArray, "/user/delete");--%>
<%--        });--%>

<%--        function del(idArray, url) {--%>
<%--            if (idArray.length === 0) {--%>
<%--                $("#modal-default").modal("hide");--%>
<%--            }--%>

<%--            else {--%>
<%--                $.ajax({--%>
<%--                    "url": url,--%>
<%--                    "type": "POST",--%>
<%--                    "data": {"ids" : idArray.toString()},--%>
<%--                    "dataType": "JSON",--%>
<%--                    "success": function (data) {--%>
<%--                        console.log(data);--%>
<%--                    }--%>
<%--                })--%>
<%--            }--%>
<%--        }--%>
<%--    });--%>
<%--</script>--%>
</body>
</html>