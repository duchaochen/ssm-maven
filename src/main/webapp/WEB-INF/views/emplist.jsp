<%@ page contentType="text/html;charset=UTF-8" language="java"  pageEncoding="UTF-8" %>

<%
    request.setAttribute("pagePath",request.getContextPath());
%>
<html>
<head>
    <title>员工列表</title>
    <script type="text/javascript" src="${pagePath}/static/js/jquery-1.12.4.min.js"></script>
    <link rel="stylesheet" href="${pagePath}/static/bootstrap-3.3.7-dist/css/bootstrap.min.css"/>
    <script type="text/javascript" src="${pagePath}/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
</head>
<body>
    <div class="container">
            <%--按钮--%>
        <div class="row">
            <%--站4格偏移8格--%>
            <div class="col-md-4 col-md-offset-8">
                <button type="button" class="btn btn-primary">添加</button>
            </div>
        </div>
            <%--内容--%>
        <div class="row">
            <div class="col-md-12">
                <table class="table table-hover">
                    <thead>
                        <tr>
                            <th>员工ID</th>
                            <th>员工名称</th>
                            <th>员工性别</th>
                            <th>员工邮箱</th>
                            <th>所属部门</th>
                            <th>操作</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>员工ID</td>
                            <td>员工名称</td>
                            <td>员工性别</td>
                            <td>员工邮箱</td>
                            <td>所属部门</td>
                            <td><button type="button" class="btn btn-primary">Primary</button>
                            <button type="button" class="btn btn-danger">Danger</button></td>
                        </tr>
                    </tbody>
                </table>
            </div>
        </div>
            <%--分页--%>
        <div class="row">
            <%--显示前面--%>
            <div class="col-md-6">

            </div>
                <%--分页显示--%>
            <div class="col-md-6">

            </div>
        </div>
    </div>
</body>
</html>
