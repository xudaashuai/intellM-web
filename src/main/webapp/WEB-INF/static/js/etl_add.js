const etl_add = new Vue({
    el: '#root_div',
    data: {
        tables: {},
        source: {
            url: '',
            password: '',
            username: '',
            type: -1,
            extract: -1,
        },
        isTesting: false,
        isSubmitSourceing: false,
        user: window.parent.root.user,
        datasources: window.parent.root.datasources,
        strategy: {},
        type: window.parent.root.strategyOpType,
        selectedTables:[],
        selectedColumns:{}
    },
    computed: {
        urlOk: function () {
            let urlRe = /^jdbc\:(mysql)\:\/\/[0-9a-zA-Z]([-.\w]*[0-9a-zA-Z])*(:(0-9)*)*(\/?)([a-zA-Z0-9\-\.\?\,\'\/\\\+&amp;%\$#_]*)?$/g;
            return urlRe.exec(this.source.url) !== null
        },
        passwordOk: function () {
            return this.source.password.length > 0;
        },
        usernameOk: function () {
            return this.source.username.length > 0;
        },
        canSubmitSource: function () {
            return this.urlOk && this.passwordOk && this.usernameOk && this.source.type != -1 && this.source.extract != -1;
        },
        canSubmitETL:function () {
            let t = ['strategyname','extractresource','extratdetails',
                'extratdetails','loaddetails','executioncycle']
            for (let i in t){
                if(this.strategy[t[i]]==undefined||this.strategy[t[i]]==null||this.strategy[t[i]].length<=0){
                    return false;
                }
            }
            return true;
        },
        extratdetails:function () {
            let t={}
            for(let i in this.selectedTables){
                let name = this.selectedTables[i]
                t[name]=this.selectedColumns[name]
            }
            return JSON.stringify(t);
        }
    },
    methods: {
        load:function () {
            if (window.parent.root.strategyOpType === 'add'){
            }else{
                this.strategy = window.parent.root.strategy

                let that=this;
                $.post('/api/get_tables',{
                    dataId:parseInt(this.strategy.extractresource)
                },function (data,status) {
                    if (data.status){
                        for(let i=0;i<data.tables.length;i++) {
                            Vue.set(that.tables,data.tables[i],null)

                            Vue.set(that.selectedColumns,data.tables[i],[])
                        }
                        for (let item in window.parent.root.strategy.ed){
                            Vue.set(that.selectedColumns,item,window.parent.root.strategy.ed[item])
                            that.selectedTables.push(item)
                        }
                    }else{
                        console.log('数据库无法连接')
                    }
                })

                this.changeTables()
            }
        },
        testDatabase: function () {
            this.isTesting = true;
            let that = this;
            $.post('/api/test_database', this.source, function (data, status) {
                that.isTesting = false;
                if (data['status'] === 1) {
                    alert('成功啦')
                } else {
                    alert(data['error'])
                }
            })
        },
        changeTables:function () {
            t = this.selectedTables
            console.log(123)
            for(let i in t){
                if (window.root.$data.tables[t[i]]===null){
                    $.post('/api/get_columns',{dataId: parseInt(window.root.strategy.extractresource),tableName:t[i]},function (data,status) {
                        if (data['status'])
                            Vue.set(window.root.$data.tables,t[i],data['columns'])
                        else
                            console.log('获取行失败')

                    })
                }
            }
        },
        addSource: function () {
            $('#addSourceModal').modal({
                keyboard: false, backdrop: 'static'
            })
        },
        changeData:function () {
          let that=this;
          $.post('/api/get_tables',{
              dataId:parseInt(this.strategy.extractresource)
          },function (data,status) {
              if (data.status){
                  for(let i=0;i<data.tables.length;i++) {
                      Vue.set(that.tables,data.tables[i],null)

                      Vue.set(that.selectedColumns,data.tables[i],[])
                  }
              }else{
                  console.log('数据库无法连接')
              }
          })
        },
        submitSource: function () {
            let d = this.source;
            d['loginname'] = this.user.loginname;
            d['extract'] = parseInt(d['extract']);
            d['type'] = parseInt(d['type']);
            console.log(d);
            let that = this;
            $.post('/api/add_datasource', d, function (data, status) {
                if (status === "success") {
                    alert("添加成功啦");
                    $('#addSourceModal').modal('hide');
                    window.parent.root.load('datasources', function () {
                        that.datasources = window.parent.root.datasources
                    })
                } else {
                    alert('好像出错啦')
                }
            })
        },
        addStrategy: function () {
            if (this.type === 'add') {
                $.post('/api/add_etl', {
                    strategyname: this.strategy.strategyname,
                    extractresource: parseInt(this.strategy.extractresource),
                    extratdetails: this.extratdetails,
                    loadresource: parseInt(this.strategy.extratdetails),
                    loaddetails: this.strategy.loaddetails,
                    executioncycle: this.strategy.executioncycle,
                    loginname: this.user.loginname
                }, function (data, status) {
                    if (data['status']) {
                        alert('添加成功');
                        window.parent.root.load('strategys')
                    } else {
                        alert('出错啦')
                    }
                })
            }else{
                $.post('/api/update_etl', {
                    id:this.strategy.id,
                    strategyname: this.strategy.strategyname,
                    extractresource: parseInt(this.strategy.extractresource),
                    extratdetails: this.extratdetails,
                    loadresource: parseInt(this.strategy.loadresource),
                    loaddetails: this.strategy.loaddetails,
                    executioncycle: this.strategy.executioncycle,
                    loginname: this.user.loginname,
                }, function (data, status) {
                    if (data['status']) {
                        alert('修改成功');
                        window.parent.root.load('strategys')
                    } else {
                        alert('出错啦')
                    }
                })
            }
        },
        deleteStrategy:function () {
            $.post('/api/remove_etl', {id:this.strategy.id,loginname: this.user.loginname}, function (data,status) {
                if(data['status']){
                    alert('删除成功')
                    window.parent.root.load('strategys')
                    window.parent.root.closeOpen();
                }
            });
        }
    }
});
window.root = etl_add;