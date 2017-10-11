<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<%--
  Created by IntelliJ IDEA.
  User: xudas
  Date: 2017/6/3
  Time: 20:22
  To change this template use File | Settings | File Templates.
--%>

<%@ page isELIgnored="false"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>Demo</title>

    <!-- 新 Bootstrap 核心 CSS 文件 -->
    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
    <link href="${pageContext.request.contextPath}/css/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/login.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/animate.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/main.css" rel="stylesheet">

    <script src="${pageContext.request.contextPath}/js/vue.js"></script>
</head>
<script>
    let t=${user};
    if (t===false){
        isFirst=true;
        user=null;
    }else{
        user=t;
        isFirst=false
    }
</script>
<body>
<div id="card2" :class="[{'flipped':!isFirst},'card']">
    <transition name="fade">
        <div class="demo form-bg front" v-if="isFirst">
            <div class="container">
                <div class="row">
                    <div class="form col-md-offset-3 col-md-6">
                        <div id="card" :class="[{'flipped':isFlipped},'card']">
                            <transition name="fade">
                                <form v-show="pageD[0]!=isFlipped"
                                      :class="['form-horizontal' ,pageD[0]?'front':'back']">
                                    <span class="heading">{{title}}</span>
                                    <div class="form-group">
                                        <input type="text"
                                               class="form-control" placeholder="用户名" name="login_username"
                                               tabindex="1" v-model="login.username"
                                               @keypress.enter="inputEnterPress(0)"
                                               autocomplete="false">
                                        <span class="glyphicon glyphicon-user"
                                              title="" data-placement="top" data-toggle="tooltip"
                                              :data-original-title="tooltips[0][0]"></span>
                                    </div>
                                    <div class="form-group help">
                                        <input type="password" class="form-control" placeholder="密　码"
                                               v-model="login.password"
                                               name="login_password"
                                               tabindex="2"
                                               @keypress.enter="inputEnterPress(1)"
                                               autocomplete="off">
                                        <span class="glyphicon glyphicon-lock"
                                              data-placement="top" data-toggle="tooltip"
                                              :data-original-title="tooltips[0][1]"></span>
                                    </div>
                                    <div class="form-group">
                                        <div style="float: right">
                                            <button class="btn btn-link" type="button" @click="signFlip(2)">忘记密码
                                            </button>
                                            <button class="btn btn-link" type="button" @click="signFlip(1)">注册</button>
                                            <button type="button" tabindex="3" class="btn btn-default"
                                                    data-placement="top" data-toggle="tooltip"
                                                    :data-original-title="tooltips[0][1]"
                                                    :disabled="!canLogin" id="login" @click="submit('login')">{{isLogining?'登录中':'登录'}}
                                            </button>
                                        </div>
                                    </div>
                                </form>
                            </transition>
                            <transition name="fade">
                                <form v-show="pageD[1]!=isFlipped"
                                      :class="['form-horizontal' ,pageD[1]?'front':'back']">
                                    <span class="heading">注册</span>
                                    <div class="form-group">
                                        <input type="text" class="form-control" placeholder="用户名" name="reg_username"
                                               v-model="reg.username"
                                               tabindex="1"
                                               @keypress.enter="inputEnterPress(0)"
                                               autocomplete="false">
                                        <span class="glyphicon glyphicon-user" :class="{'input-warn':!regUsernameOk}"
                                              title="" data-placement="top" data-toggle="tooltip"
                                              :data-original-title="tooltips[1][0]"></span>
                                    </div>
                                    <div class="form-group">
                                        <input type="password" class="form-control"
                                               placeholder="密　码" v-model="reg.password"
                                               name="reg_password"
                                               @keypress.enter="inputEnterPress(1)"
                                               tabindex="2" onkeyup="" accesskey="p"
                                               autocomplete="off">
                                        <span class="glyphicon glyphicon-lock"
                                              :class="{'input-warn':!regPasswordOk}"
                                              title="" data-placement="top" data-toggle="tooltip"
                                              :data-original-title="tooltips[1][1]"></span>
                                    </div>
                                    <div class="form-group">
                                        <input type="password" class="form-control"
                                               placeholder="重复密码" v-model="reg.password2"
                                               name="reg_password2"
                                               tabindex="3" accesskey="p"
                                               @keypress.enter="inputEnterPress(2)"
                                               autocomplete="off">

                                        <span class="glyphicon glyphicon-lock" :class="{'input-warn':!regPasswordSame}"
                                              title="" data-placement="top" data-toggle="tooltip"
                                              :data-original-title="tooltips[1][2]"></span>
                                    </div>
                                    <div class="form-group">
                                        <div style="float: right">
                                            <button class="btn btn-link" type="button" @click="signFlip(0)">登录</button>
                                            <button type="button" tabindex="4" class="btn btn-default"
                                                    :class="{'disabled':!canReg}"
                                                    :disabled="!canReg" @click="submit('reg')">{{isReging?'注册中':'注册'}}
                                            </button>
                                        </div>
                                    </div>
                                </form>
                            </transition>
                            <transition name="fade">
                                <form v-show="pageD[2]!=isFlipped"
                                      :class="['form-horizontal' ,pageD[2]?'front':'back']">
                                    <span class="heading">忘记密码了</span>
                                    <!--todo -->
                                    <div class="form-group">
                                        <input type="text" class="form-control" placeholder="用户名" name="forget_username"
                                               tabindex="1"
                                               @keypress.enter="inputEnterPress(0)"
                                               accesskey="n" autocomplete="false">
                                        <span class="glyphicon glyphicon-user"></span>
                                    </div>
                                    <div class="form-group">
                                        <div style="float: right">
                                            <button class="btn btn-link" type="button" @click="signFlip(0)">登录</button>
                                            <button class="btn btn-link" type="button" @click="signFlip(1)">注册</button>
                                            <button type="button" tabindex="2" class="btn btn-default"
                                                    @click="submit('forget')">{{isForgeting?'修改中':'修改'}}
                                            </button>
                                        </div>
                                    </div>
                                </form>
                            </transition>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </transition>
    <transition name="fade">
        <div v-if="!isFirst" class="main back" >
            <img src @error='loadInfo'>
            <div class="left">
                <div class="nav-header">
                    <img class="nav-header-img" src="http://www.bootcss.com/p/flat-ui/images/demo/logo-mask.png">
                    <h5 class="nav-header-name">{{user.name}}</h5>
                </div>
                <div class="nav-items">
                    <div v-for="(item,index) in menu" class="nav-item">
                        <div class="item-content" @click.stop="menuClick(index)">
                            <p :index="index" @click.stop="menuClick(index)">{{item.name}}</p>
                            <div v-if="item.items!==undefined&&item.items!==null" class="span-btn" @click.stop="menuClick(index)">
                                <span class="glyphicon glyphicon-chevron-down" @click.stop="menuClick(index)"></span>
                            </div>
                        </div>
                        <transition name="fade">
                            <div v-if="item.isOpen" class="nav-items nav-item-items">
                                <div v-for="(item,index2) in item.items" class="nav-item nav-item-item">
                                    <div class="item-content" @click.stop="menuClick(index,index2)">
                                        <p @click.stop="menuClick(index,index2)">{{item.name}}</p>
                                        <div v-if="item.items!==undefined&&item.items!==null" class="span-btn" @click.stop="menuClick(index,index2)">
                                            <span class="glyphicon glyphicon-chevron-down" @click.stop="menuClick(index,index2)"></span>
                                        </div>
                                    </div>
                                    <transition name="fade">
                                        <div v-if="item.isOpen" class="nav-items nav-item-items">
                                            <div v-for="(item,index3) in item.items" class="nav-item nav-item-item">
                                                <div class="item-content" @click.stop="menuClick(index,index2,index3)">
                                                    <p @click.stop="menuClick(index,index2,index3)">{{item.name}}</p>
                                                    <div v-if="item.items!==undefined&&item.items!==null" class="span-btn"  @click.stop="menuClick(index,index2,index3)">
                                                        <span class="glyphicon glyphicon-chevron-down" @click.stop="menuClick(index,index2,index3)"></span>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </transition>
                                </div>
                            </div>
                        </transition>
                    </div>
                </div>
                <div class="nav-footer">
                    <button class="btn btn-link" @click="logout">退出</button>
                </div>
            </div>
            <div class="right">

                <ul id="tab-nav" class="nav nav-tabs">
                    <li v-for="(tab,i) in tabs" :class="{'active':i===selectTab}">
                        <a @click="tabClick(i)">
                            {{tab.name}}
                        </a>
                        <span class="glyphicon glyphicon-remove" @click.stop="closeTab(i)">
                        </span>
                    </li>
                </ul>
                <div id="tab-content" class="tab-content">
                    <div v-for="(tab,i) in tabs"
                         :class="['tab-pane fade in',{'active':i===selectTab}]" :id="tab.name">
                        <iframe class="frame" :src="tab.src"></iframe>
                    </div>
                </div>
            </div>
        </div>
    </transition>
</div>

<script src="${pageContext.request.contextPath}/js/jquery-3.2.1.min.js"></script>
<script src="${pageContext.request.contextPath}/js/flat-ui.js"></script>
<script>
    $(function () {
        $('[data-toggle=tooltip]').tooltip();
    });
</script>

<script src="${pageContext.request.contextPath}/js/index.js"></script>
</body>

</html>