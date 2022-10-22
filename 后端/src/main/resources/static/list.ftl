<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>员工管理</title>
    <#include "/common/link.ftl">
    </script>

</head>
<body class="hold-transition skin-black sidebar-mini">
<div class="wrapper">
    <span id="time" style="display: none">${time}</span>
    <#include "/common/navbar.ftl">
    <!--菜单回显-->
    <#assign currentMenu="employee"/>
    <#include "/common/menu.ftl">
    <div class="content-wrapper">
        <section class="content-header">
            <h1>员工管理</h1>
        </section>
        <section class="content">
            <div class="box">
                <!--高级查询--->
                <div style="margin: 10px;">
                    <form class="form-inline" id="searchForm" action="/employee/list" method="post">
                        <input type="hidden" name="currentPage" id="currentPage" value="1">
                        <div class="form-group">
                            <label for="keyword">关键字:</label>
                            <input type="text" class="form-control" value="${qo.keyword}" name="keyword"
                                   placeholder="请输入姓名/邮箱">
                        </div>
                        <div class="form-group">
                            <label for="dept"> 部门:</label>
                            <select class="form-control" id="dept" name="deptId">
                                <option value="">全部</option>
                                <#list departments as department>
                                    <option value="${department.id}" ${(department.id == qo.deptId) ?
                                    string('selected', '')}>${department.name}</option>
                                </#list>
                            </select>
                        </div>
                        <button type="submit" class="btn btn-primary"><span class="glyphicon glyphicon-search"></span>
                            查询
                        </button>
                        <a href="/employee/input" class="btn btn-success btn-input">
                            <span class="glyphicon glyphicon-plus"></span> 添加
                        </a>
                        <a href="/employee/exportXls" class="btn btn-warning">
                            <span class="glyphicon glyphicon-download"></span> 导出
                        </a>
                        <a href="#" class="btn btn-warning btn-import">
                            <span class="glyphicon glyphicon-upload"></span> 导入
                        </a>
                    </form>
                </div>
                <div class="box-body table-responsive ">
                    <table class="table table-hover table-bordered table-striped">
                        <thead>
                        <tr>
                            <th><input type="checkbox" id="allCb"></th>
                            <th>编号</th>
                            <th>用户名</th>
                            <th>真实姓名</th>
                            <th>邮箱</th>
                            <th>年龄</th>
                            <th>管理员</th>
                            <th>部门</th>
                            <th>操作</th>
                        </tr>
                        </thead>
                        <tbody>

                        <#list pageInfo.list as employee>
                            <tr>
                                <td><input type="checkbox" class="cb"></td>
                                <td>${employee_index + pageInfo.startRow}</td>
                                <td>${employee.username}</td>
                                <td>${employee.name}</td>
                                <td>${employee.email}</td>
                                <td>${employee.age}</td>
                                <td>${(employee?? && employee.admin) ? string('是', '否')}</td>
                                <td>${employee.department.name}</td>
                                <td>
                                    <a href="/employee/input?id=${employee.id}"
                                       class="btn btn-info btn-xs btn_redirect">
                                        <span class="glyphicon glyphicon-pencil"></span> 编辑
                                    </a>
                                    <a data-url="/employee/delete?id=${employee.id}"
                                       class="btn btn-danger btn-xs btn-delete">
                                        <span class="glyphicon glyphicon-trash"></span> 删除
                                    </a>
                                </td>
                            </tr>
                        </#list>

                        </tbody>
                    </table>
                    <!-- 分页 -->
                    <#include "/common/page.ftl">
                </div>

            </div>
        </section>
    </div>
    <#include "/common/footer.ftl">
</div>
</body>
</html>