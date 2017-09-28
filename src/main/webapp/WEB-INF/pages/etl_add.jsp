<%--
  Created by IntelliJ IDEA.
  User: 徐大帅
  Date: 2017/9/27
  Time: 16:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>添加ETL策略</title>

    <!-- 新 Bootstrap 核心 CSS 文件 -->
    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
    <link href="${pageContext.request.contextPath}/css/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/login.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/animate.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/main.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/flat-ui.css" rel="stylesheet">

    <link href="${pageContext.request.contextPath}/css/moal_config.css" rel="stylesheet">

    <script src="${pageContext.request.contextPath}/js/vue.js"></script>
</head>
<body>

<div class="main-div" id="root_div">
    <img src @error="onload"/>
    <div class="form-box">
        <h2>开始吧</h2>
        <div class="xhx"></div>
        <div class="form-item">
            <h4>策略名称</h4>
            <input type="text" class="form-control">
        </div>
        <div class="form-item">
            <h4>抽取数据源</h4>
            <select  class="form-control">
                <option disabled="disabled">请选择数据源</option>
            </select>
        </div>
        <div class="form-item">
            <h4>没有数据源的话</h4>
            <button class="btn btn-primary">添加数据源吧</button>
        </div>

        <div class="form-item">
            <h4>选一张表吧</h4>
            <select  class="form-control">
                <option disabled="disabled">请选择表</option>
            </select>
        </div>
        <div class="form-item">
            <h4>选字段啦</h4>
            <select data-toggle="select" multiple class="form-control multiselect multiselect-default mrs mbm">
                <option value="0">1 option</option>
                <option value="1">2 option</option>
                <option value="2">3 option</option>
                <option value="3">4 option</option>
                <option value="4">5 option</option>
            </select>
        </div>
        <div class="form-item">
            <h4>抽取数据源</h4>
            <select  class="form-control">
                <option disabled="disabled">请选择数据源</option>
            </select>
        </div>
    </div>
</div>

<script src="${pageContext.request.contextPath}/js/jquery-3.2.1.min.js"></script>
<script src="${pageContext.request.contextPath}/js/flat-ui.js"></script>

<script src="${pageContext.request.contextPath}/js/etl_add.js"></script>
<script>
    // Custom Selects

    // Custom Selects
    if ($('[data-toggle="select"]').length) {
        $('[data-toggle="select"]').select2();
    }

</script>
</body>
</html>
