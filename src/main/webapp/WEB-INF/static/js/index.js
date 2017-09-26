/**
 * Created by xudas on 2017/9/9.
 */
password = /[0-9a-zA-Z]{6,15}/;
username = /[0-9a-zA-Z]{5,15}/;

const root = new Vue({
    el: '#card2',
    data: {
        isFirst: isFirst,
        isLogining: false,
        isReging: false,
        isForgeting: false,
        pageD: [true, false, false],
        isFlipped: false,
        title: '你好哇',
        name: 'Admin',
        selected: [-1, -1],
        src: 'welcome',
        login: {
            username: '',
            password: ''
        },
        tooltips: [
            [],
            ['用户名需要6到15个字符，只能有字母与数字', '密码需要6到15个字符，只能有字母与数字', '两次要一样哟']
        ],
        reg: {
            username: '',
            password: '',
            password2: ''
        },
        tabs: [{name: '欢迎界面', src: 'welcome'}],
        // ETL 配置
        selectTab: 0,
        menu: [],
        user: user,
        moals: {},
        user_paras:{}
    },
    computed: {
        regUsernameOk: function () {
            return username.exec(this.reg.username) !== null
        },
        regPasswordSame: function () {
            return this.reg.password === this.reg.password2;
        },
        regPasswordOk: function () {
            return password.exec(this.reg.password) !== null
        },
        canReg: function () {
            return this.regPasswordSame && this.regPasswordOk && !this.isReging
        },
        canLogin: function () {
            return username.exec(this.login.username) !== null && password.exec(this.login.password) !== null && !this.isLogining
        }
    },
    methods: {
        inputEnterPress: function (index) {
            inputs = document.querySelectorAll("#card  form:not([style='display: none;']) input");
            if (index === inputs.length - 1) {
                bs = document.querySelectorAll("#card form:not([style='display: none;']) button");
                bs[bs.length - 1].click();
            } else {
                inputs[index + 1].focus();
            }
        },
        signFlip: function (t) {
            this.isFlipped = !this.isFlipped;
            for (let i = 0; i < 3; i++) {
                Vue.set(this.pageD, i, i === t ? !this.isFlipped : this.isFlipped);
            }
        },
        menuClick: function (...index) {
            let item = this.menu[index[0]];
            for (let i = 1; i < index.length; i++) {
                item = item.items[index[i]]
            }
            if (item.type !== undefined) {
                switch (item.type) {
                    case 'add_a':
                        $('#addA_Model').modal({backdrop: 'static', keyboard: false});
                        break;
                    case 'remove_a':
                        $('#removeA_Model').modal({backdrop: 'static', keyboard: false});
                        break;
                }
            } else if (item.items !== undefined && item.items !== null) {
                item.isOpen = !item.isOpen;
            } else {
                let i = this.getIndex(item.name);
                if (i === -1) {
                    this.tabs.push(item);
                    this.selectTab = this.tabs.length - 1;
                } else {
                    this.selectTab = i;
                }
            }
        },
        submit: function (type) {
            let that = this;
            switch (type) {
                case 'login':
                    this.isLogining = true;
                    $.post("/login", this.login, function (data, status) {
                        console.log(data);
                        that.isLogining = false;
                        switch (data.status) {
                            case 0:
                                that.isFirst = false;
                                that.user = data.user;
                                //todo 如果是新用户的话，要求完善一些些个人信息
                                break;
                            case 400:
                                alert("用户名不存在呢，是不是打错了呀");
                                break;
                            case 500:
                                alert("密码错误了呢，是不是打错了呀");
                                break;
                            case -1:
                                alert("出现了奇妙错误呢，你可真是小我的幸运星呀");
                                break;
                        }
                    });
                    break;
                case 'reg':
                    this.isReging = true;
                    $.post("/reg", this.reg, function (data, status) {
                        console.log(data);
                        this.isReging = false;
                        switch (data.status) {
                            case 0:
                                that.signFlip(0);
                                break;
                            case 401:
                                alert("用户名已经存在了呢，换一个吧");
                                break;
                            case -1:
                                alert("出现了奇妙错误呢，你可真是小我的幸运星呀");
                                break;
                        }
                    });
                    break
            }
        },
        closeTab: function (i) {
            if (this.tabs.length === 1) return;
            console.log(this.tabs.length);
            console.log(i);
            console.log(this.selectTab);
            if (this.selectTab === (this.tabs.length - 1)) {
                this.selectTab -= 1;
            }
            Vue.delete(this.tabs, i)
        },
        tabClick: function (i) {
            this.selectTab = i
        },
        getIndex: function (name) {
            for (let i = 0; i < this.tabs.length; i++) {
                if (name === this.tabs[i].name) {
                    return i;
                }
            }
            return -1;
        },
        flip: function () {
            this.isFirst = !this.isFirst;
        },
        loadInfo: function () {
            this.menu = [
                {
                    name: '智能数据分析',
                    items: [],
                    isOpen: false
                }, {
                    name: '多维度BI可视化',
                    isOpen: false,
                    items: [
                        {name: '通用可视化'},
                        {name: '定制可视化'},
                        {name: '多维分析可视化'},
                        {name: '时空数据可视化'},
                        {name: '可视化BI仪表盘'}
                    ]
                }, {
                    name: '平台配置',
                    isOpen: false,
                    items: [
                        {name: 'ETL 策略配置',},
                        {name: '模型算法配置', src: 'moal_config'},
                        {name: '图件样式配置', isMe: false},
                    ]
                },
            ];
            var that = this;
            $.post("/api/moals", {'username': this.user.loginname}, function (data, status) {
                data = data['moals'];
                for (let model in data) {
                    let temp = [];
                    for (let al in data[model]) {
                        data[model][al].name = data[model][al].algorithm;
                        $.post("/api/get_para_by_model_id", {'modelId':data[model][al].modelId }, function (da, status) {
                            da=da['para']
                            data[model][al].paraWeight=parseJson(da.paraWeightsStr)
                            data[model][al].id=da.id;
                        })
                        temp.push(data[model][al])
                    }
                    that.menu[0].items.push({
                        name: model,
                        isOpen: false,
                        items: temp
                    })
                }
                that.moals = data;
                $.post("/api/user_paras", {'username': that.user.loginname}, function (data, status) {
                    data=data['paras']
                    console.log(data)
                    for(let key in data){
                        let p=data[key];
                        console.log(p);
                        if(that.user_paras[p.modelId]===undefined){
                            that.user_paras[p.modelId]=[]
                        }
                        p.paraWeight=parseJson(p.paraWeightsStr)
                        that.user_paras[p.modelId].push(p)
                    }
                })

            })
        },
        logout:function () {
            let that=this
            $.get("/logout",function (data,status) {
                window.location.reload()
            })
        }
    }
});
window.root=root;
function parseJson(str) {
    str=str.replace(/[“”]/g,'"').replace(/，/g,',');
    console.log(str)
    return JSON.parse(str);
}