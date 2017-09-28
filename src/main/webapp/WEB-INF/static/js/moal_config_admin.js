const moal_config = new Vue({
    el: '#root_div',
    data: {
        model_id: "-1",
        algorithm_id: "-1",
        operation_type: "-1",
        para_id: -1,
        moals: window.parent.root.moals,
        para: window.parent.root.user_paras,
        loadingPara: false,
        input_para: {},
        model_name: '',
        algorithm_name: '',
        modelParaInput: [],
        para_name:'',
        user:window.parent.root.user
    },
    computed: {
        algorithm_i:function () {
            return this.moals[this.model_id][parseInt(this.algorithm_id)].modelId
        },
        canSubmit: function () {
            if (this.operation_type == 1) {
                return this.modelParaInput.length>=1;
            } else if (this.operation_type == 2) {
                return this.model_id != -1;
            } else if (this.operation_type == 3) {
                return this.totalWeight == 100;
            } else if (this.operation_type == 4) {
                return this.algorithm_id != -1;
            } else if (this.operation_type == 5) {
                return this.totalWeight == 100;
            }
            return false;
        },
        totalWeight: function () {
            let t = 0;
            for (let key in this.input_para) {
                if(this.input_para[key]===undefined||this.input_para[key].length===0)continue;
                t += parseInt(this.input_para[key])
            }
            return t;
        },
        modelNameOk: function () {

            let t= (!containSpecial(this.model_name)) && this.model_name.length > 0 && this.model_name.length < 32
            console.log(t)
            if (t){
                for(let key in this.moals){
                    if(this.model_name==key)
                        return false
                }
            }else{
                return false
            }
            return true

        },
        algorithmNameOk: function () {
            let t= (!containSpecial(this.algorithm_name))&& this.algorithm_name.length > 0 && this.algorithm_name.length < 32
            console.log(t)

            if (t){
                for(let key in this.moals[this.model_id]){
                    if(this.algorithm_name==this.moals[this.model_id][key].algorithm)
                        return false
                }
            }else{
                return false
            }
            return true
        },
    },
    methods: {
        nameOk: function (s) {
            return !containSpecial(s) && s.length > 0 && s.length < 32
        },
        canAddPara: function (s) {
            if (!this.nameOk(s)) return false
            for (let i = 0; i < this.modelParaInput.length; i++) {
                if (this.modelParaInput[i] == s) return false
            }
            return true;
        },
        weightOk: function (str) {
            if (str===undefined||str.length===0)return true;
            let t;
            try {
                t = parseInt(str)
            } catch (e) {
                return false;
            }
            return t >= 0 && t <= 100
        },
        submit: function () {
            let url,data;
            if(this.operation_type==3){
                let weights=this.input_para
                console.log(weights)
                for(let key in weights){
                    if (weights[key]===undefined||weights[key].length===0){
                        weights[key]="0";
                    }
                }
                let t= JSON.stringify(weights)
                data = {
                    para:t,
                    modelId:this.moals[this.model_id][0].modelPos,
                    userId:this.user.userId,
                    modelName:this.model_id,
                    algorithmName:this.algorithm_name
                }
                url="/api/add_al"
            }else if(this.operation_type==4){
                url="/api/remove_al"
                data= {alId:this.algorithm_i}
            }else if(this.operation_type==5){
                url="/api/update_al"
                let al=this.moals[this.model_id][parseInt(this.algorithm_id)]
                let weights=this.input_para
                console.log(weights)
                for(let key in weights){
                    if (weights[key]===undefined||weights[key].length===0){
                        weights[key]="0";
                    }
                }
                let t= JSON.stringify(weights)
                data={
                    modelId:al.modelId,
                    userId:this.user.userId,
                    id:al.id,
                    paraWeights:t
                }
            }else{
                return;
            }
            $.post(url,data,function (data,status) {
                if(status=='success'){
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
        changeOperation: function () {
            this.model_id = "-1"
            this.algorithm_id = "-1";
            this.para_id = "-1";
        },
        changeModel: function () {
            this.algorithm_id = "-1";
            this.para_id = "-1";
            if (this.model_id!=-1){
                if(this.operation_type==6){
                    this.modelParaInput = this.moals[this.model_id][0]
                }
            }
        },
        changeAlgorithm: function () {
            this.para_id = "-1";
            if (this.algorithm_id != -1) {
                if(this.operation_type == 5) {
                    let p = this.moals[this.model_id][parseInt(this.algorithm_id)].paraWeight
                    this.input_para = p
                }else if(this.operation_type == 3){
                    let weights = this.moals[this.model_id][0].paraWeight
                    this.input_para = weights
                }
            }
        },
        changePara: function () {

        },
        modelRemovePara: function (index) {
            this.modelParaInput.splice(index,1)
        },
        modelAddPara: function (s) {
            this.modelParaInput.push(s)
            this.para_name=''
        }
    }
});
window.root = moal_config;

function containSpecial(s) {
    var containSpecial = /[(\ )(\~)(\!)(\@)(\#)(\$)(\%)(\^)(\&)(\*)(\()(\))(\-)(\_)(\+)(\=)(\[)(\])(\{)(\})(\|)(\\)(\;)(\:)(\')(\")(\,)(\.)(\/)(\<)(\>)(\?)(\)]+/
    return ( containSpecial.test(s) );
}