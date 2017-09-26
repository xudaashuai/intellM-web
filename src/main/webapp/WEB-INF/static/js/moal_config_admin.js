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
    },
    computed: {
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
            return !containSpecial(this.model_name) && this.model_name.length > 2 && this.model_name.length < 32
        },
        algorithmNameOk: function () {
            return !containSpecial(this.algorithm_name) && this.algorithm_name.length < 32
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
            if(this.operation_type==3){
                let weights=this.input_para
                console.log(weights)
                for(let key in weights){
                    if (weights[key]===undefined||weights[key].length===0){
                        weights[key]="0";
                    }
                }
                let t= JSON.stringify(weights)
                console.log(t)
                // todo 添加算法
            }
            console.log(this.operation_type)
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
        }
    }
});
window.root = moal_config;

function containSpecial(s) {
    var containSpecial = /[(\ )(\~)(\!)(\@)(\#)(\$)(\%)(\^)(\&)(\*)(\()(\))(\-)(\_)(\+)(\=)(\[)(\])(\{)(\})(\|)(\\)(\;)(\:)(\')(\")(\,)(\.)(\/)(\<)(\>)(\?)(\)]+/
    return ( containSpecial.test(s) );
}