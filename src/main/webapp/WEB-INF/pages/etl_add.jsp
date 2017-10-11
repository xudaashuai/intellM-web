<%--
  Created by IntelliJ IDEA.
  User: 徐大帅
  Date: 2017/9/27
  Time: 16:10
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
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
    <link href="${pageContext.request.contextPath}/css/input.css" rel="stylesheet">
    <script src="${pageContext.request.contextPath}/js/vue.js"></script>
</head>

<script>
    window.ch = function () {
        let options = $('#tables_select')[0].selectedOptions
        let t = []
        console.log(options)
        for (let i = 0; i < options.length; i++) {
            t[i] = {
                name: options[i].value,
            }
        }
        Vue.set(window.root.$data, 'tables', t)
        console.log(123)
        $.post('/api/get', {}, function (data, status) {

        })

    }
</script>
<body>

<div class="main-div" id="root_div">
    <!-- 模态框 -->
    <div class="modal fade bs-example-modal-lg" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel"
         id="addSourceModal">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                            aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title">添加数据源</h4>
                </div>
                <div class="modal-body">
                    <div class="form-modal">
                        <!-- todo 完成数据源添加表单 -->
                        <div class="form-item" :class="{'has-error':source.type==-1}">
                            <p>数据源种类</p>
                            <select class="form-control" v-model="source.type">
                                <option disabled selected>请选择数据源种类</option>
                                <option value="1">图片</option>
                            </select>
                        </div>
                        <div class="form-item" :class="{'has-error':!urlOk}">
                            <p>url</p>
                            <input type="text" class="form-control" v-model="source.url">
                        </div>
                        <div class="form-item" :class="{'has-error':!usernameOk}">
                            <p>username</p>
                            <input type="text" class="form-control" v-model="source.username">
                        </div>
                        <div class="form-item" :class="{'has-error':!passwordOk}">
                            <p>password</p>
                            <input class="form-control" type="text" v-model="source.password">
                        </div>
                        <div class="form-item" :class="{'has-error':source.extract==-1}">
                            <p>数据源用途</p>
                            <select class="form-control" id="message-text" v-model="source.extract">
                                <option disabled selected>请选择用途</option>
                                <option value="0">抽取数据源</option>
                                <option value="1">加载数据源</option>
                            </select>
                        </div>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-primary" @click="testDatabase" style="float: left"
                            :disabled="isTesting">{{isTesting?'正在测试':'测试连接'}}
                    </button>
                    <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                    <button type="button" class="btn btn-primary" @click="submitSource">确定</button>
                </div>
            </div><!-- /.modal-content -->
        </div>
    </div>
    <img src @error="load"/>
    <div class="form-box">
        <h2>开始吧</h2>
        <div class="xhx"></div>
        <div class="form-item">
            <h4>策略名称</h4>
            <input type="text" class="form-control" v-model="strategy['strategyname']">
        </div>
        <div class="form-item">
            <h4>抽取数据源</h4>
            <select class="form-control" v-model="strategy['extractresource']" @change="changeData">
                <option disabled="disabled" selected>请选择数据源</option>
                <option v-for="item in datasources" v-if="item.extract==0" :value="item.id">{{item.url}}</option>
            </select>
        </div>
        <div class="form-item">
            <h5>没有数据源的话</h5>
            <button class="btn btn-primary" @click="addSource">添加数据源吧</button>
        </div>
        <div class="form-item" @click="changeTables">
            <h4>选择你的表</h4>
            <select  multiple class="form-control" v-model="selectedTables" @change="changeTables">
                <option v-for="item,key in tables" :value="key">{{key}}</option>
            </select>
        </div>
        <div class="form-item" v-for="item in selectedTables">
            <h4>选择{{item}}的字段</h4>
            <select  multiple class="form-control" v-model="selectedColumns[item]">
                <option value="0" v-for="column in tables[item]" :value="column" >{{column}}</option>
            </select>
        </div>
        <div class="form-item">
            <h4>加载数据源</h4>
            <select class="form-control" v-model="strategy['loadresource']">
                <option disabled="disabled" selected>请选择数据源</option>
                <option v-for="item in datasources" v-if="item.extract==1" :value="item.id">{{item.url}}</option>
            </select>
        </div>
        <div class="form-item">
            <h4>结果储存形式</h4>
            <input type="text" class="form-control" v-model="strategy['loaddetails']">
        </div>
        <div class="form-item">
            <h4>执行周期</h4>
            <select class="form-control" v-model="strategy['executioncycle']">
                <option disabled="disabled" selected>请选择执行周期</option>
                <option value="0">1 option</option>
                <option value="1">2 option</option>
                <option value="2">3 option</option>
                <option value="3">4 option</option>
                <option value="4">5 option</option>
            </select>
        </div>
        <div class="form-item">
            <button class="btn btn-danger" @click="deleteStrategy" v-if="type==='update'">确定
            </button>
            <div></div>
            <button class="btn btn-primary" @click="addStrategy" :disabled="!canSubmitETL">确定
            </button>
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
