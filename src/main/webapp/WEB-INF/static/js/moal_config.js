const moal_config = new Vue({
    el: '#root_div',
    data: {
        model_id: "-1",
        algorithm_id: "-1",
        operation_type: "-1",
        para_id:-1,
        moals: window.parent.root.moals,
        para:window.parent.root.user_paras,
        user:window.parent.root.user,
        loadingPara:false,
        input_para:{},
    },
    computed: {
        algorithm_i:function () {
            return this.moals[this.model_id][parseInt(this.algorithm_id)].modelId
        },
        canSubmit: function () {
            if (this.operation_type == 1) {
                return this.totalWeight==100;
            } else if (this.operation_type == 2) {
                return this.para_id!=-1;
            }else if (this.operation_type == 3) {
                if (this.para_id == -1)
                    return false;
                return this.totalWeight==100;

            }
            return true;
        },
        totalWeight:function () {
            let t=0;
            for(let key in this.input_para){
                t+=parseInt(this.input_para[key])
            }
            return t;
        },
        paraId:function () {
            return this.para[this.algorithm_i][parseInt(this.para_id)].id
        },
        selectPara:function () {
            return this.para[this.algorithm_i][parseInt(this.para_id)]
        }
    },
    methods: {
        submit: function () {
            let url,data;
            if(this.operation_type==1){
                url='/api/add_para'
                data= {
                    para: JSON.stringify(this.input_para),
                    id: this.user.userId,
                    alId: this.algorithm_i
                }
            }else if(this.operation_type==2){
                url='/api/remove_para'
                data= {
                    paraId:this.paraId,
                    id:this.user.userId
                }
            }else if(this.operation_type==3){
                url='/api/update_para'
                data= {
                    para: JSON.stringify(this.input_para),
                    id: this.user.userId,
                    paraId: this.paraId,
                    alId:this.algorithm_i
                }
            }
            console.log(url,data)
            $.post(url,data,function (data,status) {
                if(data.status){
                    let that=this
                    window.parent.root.loadInfo(function () {
                        that.moals=window.parent.root.moals
                        that.para = window.parent.root.user_paras
                        that.user=window.parent.root.user
                        console.log(that.moals)
                        alert('成功了')
                        window.location.reload()
                    })
                }
            })
        },
        onload: function () {
        },
        changeOperation:function () {
            this.model_id="-1"
            this.algorithm_id="-1";
            this.para_id="-1";
        },
        changeModel:function () {
            this.algorithm_id="-1";
            this.para_id="-1";
        },
        changeAlgorithm:function () {
            this.para_id="-1";
            if (this.algorithm_id!=-1&&this.operation_type==1){
                let p = this.moals[this.model_id][parseInt(this.algorithm_id)].paraWeight
                console.log(this.moals[this.model_id][parseInt(this.algorithm_id)])
                this.input_para=p
            }
        },
        changePara:function () {

            if (this.algorithm_id!=-1&&this.operation_type==3){
                let p = this.para[this.algorithm_i][parseInt(this.para_id)].paraWeight
                this.input_para=p
            }
        }
    }
});
window.root=moal_config;