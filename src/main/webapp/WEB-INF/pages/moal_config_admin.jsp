<%--
  Created by IntelliJ IDEA.
  User: 徐大帅
  Date: 2017/9/21
  Time: 19:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>模型算法配置</title>

    <!-- 新 Bootstrap 核心 CSS 文件 -->
    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
    <link href="/css/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="/css/flat-ui.css" rel="stylesheet">
    <link href="/css/animate.css" rel="stylesheet">
    <link href="/css/moal_config.css" rel="stylesheet">
    <script src="/js/vue.js"></script>
</head>
<script>
    var t = 1;
</script>
<body>
<div class="main-div" id="root_div">
    <img src @error="onload"/>
    <div class="form-box">
        <h2>请选择你的修改操作</h2>
        <div class="xhx"></div>

        <div class="form-item">
            <h4>操作</h4>
            <select name="op_select" class="form-control" v-model="operation_type" @change="changeOperation">
                <option value="-1" selected="selected">请选择您的操作</option>
                <option value="1">添加模型</option>
                <option value="2">删除模型</option>
                <option value="3">添加算法</option>
                <option value="4">删除算法</option>
                <option value="5">修改算法</option>
            </select>
        </div>
        <transition name="fade">
            <div v-if="operation_type!=-1">
                <transition name="fade">
                    <div v-if="operation_type==1">
                        <!-- 添加模型-->
                        <div class="form-item"
                             :class="{'has-error':!nameOk(model_name)}">
                            <h4>模型名称</h4>
                            <input :value="value" :name="key" class="form-control" type="text"
                                   v-model="model_name">
                        </div>
                        <div v-if="nameOk(model_name)">
                            <h3>参数列表</h3>
                            <div class="xhx"></div>
                            <div class="form-item" v-for="(para_name,index) in modelParaInput">
                                <h4>{{para_name}}</h4>
                                <button @click="modelRemovePara(index)" class="btn btn-danger">删除参数</button>
                            </div>
                            <div  class="form-item">
                                <input :value="value" :name="key" class="form-control" type="text"
                                       v-model="para_name">
                                <button @click="modelAddPara(para_name)" class="btn btn-primary" :disabled="!canAddPara(para_name)">添加参数</button>
                            </div>

                            <div class="form-item">
                                <div></div>
                                <button class="btn btn-primary" @click="submit" :disabled="!canSubmit">确定</button>
                            </div>
                        </div>
                    </div>
                    <div v-else>
                        <div class="form-item">
                            <h4>模型</h4>
                            <select class="form-control" v-model="model_id" @change="changeModel">
                                <option value="-1" selected="selected">请选择模型</option>
                                <option v-for="(value,key) in moals" :value="key">{{key}}</option>
                            </select>
                        </div>
                        <!-- 删除模型 -->
                        <div class="form-item" v-if="operation_type==2">
                            <div></div>
                            <button class="btn btn-danger" @click="submit" :disabled="canSubmit">确定</button>
                        </div>
                        <div v-else-if="model_id!=-1">
                            <!-- 添加算法 -->
                            <div v-if="operation_type==3">
                                <div class="form-item"
                                     :class="{'has-error':!nameOk(algorithm_name)}">
                                    <h4>算法名称</h4>
                                    <input class="form-control" type="text"
                                           v-model="algorithm_name">
                                </div>
                                <div v-if="nameOk(algorithm_name)">
                                    <h3>算法参数表</h3>
                                    <div class="xhx"></div>
                                    <div class="form-item "
                                         :class="{'has-error':!weightOk(input_para[key])}"
                                         v-for="(value,key) in moals[model_id][0].paraWeight">
                                        <h4>{{key}}</h4>
                                        <input :value="value" :name="key" class="form-control"
                                               type="number"
                                               v-model="input_para[key]">
                                    </div>
                                    <div class="form-item" :class="{'has-error':totalWeight!=100}">
                                        <h4>总计（需要为100）</h4>
                                        <input class="form-control" :value="totalWeight" type="number"
                                               disabled="disabled">
                                    </div>
                                    <div class="form-item">
                                        <div></div>
                                        <button class="btn btn-primary" :disabled="!canSubmit" @click="submit">确定</button>
                                    </div>
                                </div>
                            </div>
                            <div v-else>
                                <div class="form-item">
                                    <h4>算法</h4>
                                    <select class="form-control" v-model="algorithm_id" @change="changeAlgorithm">
                                        <option value="-1" selected="selected">请选择算法</option>
                                        <option v-for="item in moals[model_id]" :value="item.modelId">{{item.algorithm}}
                                        </option>
                                    </select>
                                </div>
                                <transition name="fade">
                                    <div v-if="algorithm_id!=-1">
                                        <transition name="fade">
                                            <div v-if="operation_type==5">
                                                <!-- 修改算法 -->
                                                <h3>算法参数列表</h3>
                                                <div class="xhx"></div>
                                                <div>
                                                    <div class="form-item"
                                                         :class="{'has-error':!weightOk(input_para[key])}"
                                                         v-for="(value,key) in moals[model_id][parseInt(algorithm_id)].paraWeight">
                                                        <h4>{{key}}</h4>
                                                        <input :value="value" :name="key" class="form-control"
                                                               type="number"
                                                               v-model="input_para[key]">
                                                    </div>
                                                    <div class="form-item">
                                                        <h4>总计（需要为100）</h4>
                                                        <input class="form-control" :value="totalWeight" type="number"
                                                               disabled="disabled">
                                                    </div>
                                                    <div class="form-item">
                                                        <div></div>
                                                        <button class="btn" @click="submit"
                                                                :disabled="!canSubmit">确定
                                                        </button>
                                                    </div>
                                                </div>
                                            </div>
                                            <div v-else-if="operation_type==4" class="form-item">
                                                <div></div>
                                                <div>
                                                    <button class="btn btn-danger" @click="submit" :disabled="!canSubmit">确定</button>
                                                </div>
                                            </div>
                                        </transition>
                                    </div>
                                </transition>
                            </div>
                        </div>
                    </div>
                </transition>
            </div>
        </transition>
    </div>
</div>
<script src="/js/jquery-3.2.1.min.js"></script>
<script src="/js/flat-ui.js"></script>

<script src="/js/moal_config_admin.js"></script>
</body>
</html>