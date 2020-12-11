module.exports = class ScoreTable{
    #MBTI_INDEX;
    #mbtiTable;
    #smoke_dependency;
    #mbti_dependency;
    constructor(){
        this.#MBTI_INDEX = ["INFP","ENFP","INFJ","ENFJ","INTJ","ENTJ","INTP","ENTP","ISFP","ESFP","ISTP","ESTP","ISFJ","ESFJ","ISTJ","ESTJ"];
        this.#mbtiTable = require('./mbti');
        this.#smoke_dependency = 1.2;
        this.#mbti_dependency = 1.5;
    }
    getSleepScore(userData, otherData){
        var ustime = userData.pstime;
        var ostime = otherData.pstime;
        var score = ustime - ostime + userData.pshour;
        return score;
    }
    getTotalScore(userData, otherData){
        var score = 0;
        //const mbtiTable = require('./mbti');
        //const MBTI_INDEX = ["INFP","ENFP","INFJ","ENFJ","INTJ","ENTJ","INTP","ENTP","ISFP","ESFP","ISTP","ESTP","ISFJ","ESFJ","ISTJ","ESTJ"];
        //const mbti_dependency = 1.5;
        // const smoke_dependency = 1.2;
        //const sleep_dependency = 1.4;
        score += this.#mbtiTable["mbtiInfo"][this.#MBTI_INDEX[userData.pmbti]][this.#MBTI_INDEX[otherData.pmbti]] *this.#mbti_dependency;
        score += userData.psmoke*otherData.psmoke*this.#smoke_dependency;
       //score += this.getSleepScore(userData,otherData)*this.sleep_dependency;
        return score;
    }
}