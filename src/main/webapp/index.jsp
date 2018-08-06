<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>

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
            <table id="employeeTable" class="table table-hover">
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

                </tbody>
            </table>
        </div>
    </div>
    <%--分页--%>
    <div class="row">
        <%--显示前面--%>
        <div class="col-md-6" id="page_info_area">

        </div>
        <%--分页显示--%>
        <div class="col-md-6">
            <nav aria-label="Page navigation">
                <ul id="pagination" class="pagination">

                </ul>
            </nav>
        </div>
    </div>
</div>
</body>
<script type="text/javascript">
    var pagination;
    /**
     * 当前页码，默认为1
     */
    var pageIndex =1;
    /**
     * 总页码
     */
    var pages;
    /**
     * 1.封装一个pageload方法加载员工信息,由于要分页所以封装的方法需要一个页码参数
     * 2.首先需要在页面加载之后加载数据需要使用到$(function(){});
     */
    $(function(){
        //默认获取第一页
        pageload(pageIndex);

        pagination = $("#pagination");
        /**
         * 页码绑定事件
         */
        pagination.on("click",".page_li",function () {
            pageIndex = $(this).attr("pageIndex");
            pageload(pageIndex);
        });
        /**
         * 首页事件绑定
         */
        pagination.on("click",".firstPage",function () {
            pageload(1);
        });
        /**
         * 上一页
         */
        pagination.on("click",".previous",function () {
            if(pageIndex > 1) {
                pageload(pageIndex - 1);
            }
        });
        /**
         * 下一页
         */
        pagination.on("click",".next",function () {
            if(pageIndex < pages) {
                pageload(pageIndex + 1);
            }
        });
        /**
         * 尾页事件绑定
         */
        pagination.on("click",".lastPage",function () {
            pageload(pages);
        });
    });
    /**
     * 加载事件
     */
    function pageload(pageIndex) {
        $.ajax({
            url:"${pagePath}/employee/list",
            data:{
                pageIndex : pageIndex,
                time : new Date().getDate()
            },
            type:"GET",
            success : function (result) {
                console.log(result)

                if(200 === result.code) {
                    //添加内容
                    loadTable(result.maps.pageInfo.list);
                    //添加分页信息显示
                    page_info_show(result.maps.pageInfo);
                    //添加分页
                    paginationFun(result.maps.pageInfo);
                }
            }
        });
    }

    /**
     * 显示table
     */
    function loadTable(employeeList) {
        //给table加上一个id，这里好获取对象
        var employeeTable = $("#employeeTable");
        //清空列表
        employeeTable.empty();
        $.each(employeeList,function (index, item) {
            var tr = $("<tr></tr>");
            //将下面的td全部都添加到tr中
            $("<td></td>").append(item.empId).appendTo(tr);
            $("<td></td>").append(item.empName).appendTo(tr);
            $("<td></td>").append(item.gender).appendTo(tr);
            $("<td></td>").append(item.email).appendTo(tr);
            $("<td></td>").append(item.department.deptName).appendTo(tr);
            //创建修改和删除按钮
            var btn_eidt_employee = $('<button type="button" class="btn btn-primary eidt_employee">修改</button>');
            var btn_del_employee = $('<button type="button" class="btn btn-danger del_employee">删除</button>');
            $("<td></td>").append(btn_eidt_employee).append(btn_del_employee).appendTo(tr);
            //在将tr添加到tbody中
            employeeTable.append(tr);
        });
    }

    /**
     * 显示分页详细信息
     */
    function page_info_show(pageInfo) {
        var page_info_area = $("#page_info_area");
        page_info_area.empty();
        page_info_area.append("当前"+pageInfo.pageNum+"页,总"+
            pageInfo.pages+"页,总"+
            pageInfo.total+"条记录");
        pages = pageInfo.pages;
        pageIndex = pageInfo.pageNum;
    }
    /**
     * 分页方法
     */
    function paginationFun(pageInfo) {
        //添加时都需要先清空一下
        pagination.empty();

        //首页
        firstPageFun();

        //将上一页控件添加到分页ul中
        previousPageFun();

        //分页插件中间部分
        page_lis(pageInfo);

        //下一页
        nextPageFun();

        //尾页
        lastPageFun();
    }
    /**
     * 首页
     */
    function firstPageFun() {
        var firstPage = $('<li class="firstPage" ><a href="#">首页</a></li>');
        if(1 === pageIndex) {
            firstPage.addClass("disabled")
        }
        firstPage.appendTo(pagination);
    }
    /**
     * 上一页加载
     */
    function previousPageFun() {
        //上一页
        var previous = $('<li class="previous"><a href="#" aria-label="Previous" ><span aria-hidden="true">&laquo;</span></a></li>');
        //如果没有上一页了,将上一页按钮禁用
        if(1 === pageIndex) {
            previous.addClass("disabled");
        }
        previous.appendTo(pagination);
    }
    /**
     * 分页控件中间部分
     * @param pageInfo
     */
    function page_lis(pageInfo) {
        $.each(pageInfo.navigatepageNums,function (index, item) {
            //class="page_li" pageIndex="'+item+'"为了后期绑定事件使用
            var li = $('<li class="page_li" pageIndex="'+item+'"><a href="#">'+item+'</a></li>');
            //点击到当前页需要选中
            if(item === pageIndex) {
                li.addClass("active");
            }
            li.appendTo(pagination);
        });
    }
    /**
     * 下一页绑定
     */
    function nextPageFun() {
        var next = $('<li class="next"><a href="#" aria-label="Next"><span aria-hidden="true">&raquo;</span></a></li>');
        //如果是最后一页，将下一页的按钮禁用
        if(pages === pageIndex) {
            next.addClass("disabled");
        }
        next.appendTo(pagination);
    }
    /**
     * 尾页
     */
    function lastPageFun() {
        var lastPage = $('<li class="lastPage" ><a href="#">尾页</a></li>');
        if(pages === pageIndex) {
            lastPage.addClass("disabled")
        }
        lastPage.appendTo(pagination);
    }
</script>
</html>