const moal_config = new Vue({
    el: '#root_div',
    data: {
        model_id: "-1",
        algorithm_id: "-1",
        operation_type: "-1",
        para_id:-1,
        moals: window.parent.root.moals,
        para:window.parent.root.user_paras,
        loadingPara:false,
        input_para:{},
    },
    computed: {
        canSubmit: function () {
            if (this.operation_type == 1) {
                return this.totalWeight==100;
            } else if (this.operation_type == 2) {
                if (this.para_id === -1 || this.para[this.algorithm_id] === undefined || this.para[this.algorithm_id].length === 0)
                    return false;

                if (document.getElementById(this.para_id) === null) {
                    return false;
                }
                return this.model_id != -1 && this.algorithm_id != -1 && this.operation_type != -1;
            }
            return true;
        },
        totalWeight:function () {
            let t=0;
            for(let key in this.input_para){
                t+=parseInt(this.input_para[key])
            }
            return t;
        }
    },
    methods: {
        submit: function () {

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
                this.input_para=p
            }
        },
        changePara:function () {

        }
    }
});
window.root=moal_config;