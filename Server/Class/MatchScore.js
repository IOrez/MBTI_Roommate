module.exports = class MatchScore{
    constructor(){
        this.MBTI_INDEX = ["INFP","ENFP","INFJ","ENFJ","INTJ","ENTJ","INTP","ENTP","ISFP","ESFP","ISTP","ESTP","ISFJ","ESFJ","ISTJ","ESTJ"];
        this.mbti_dependency = 1.5;
        this.smoke_dependency = 1.2;
        this.sleep_dependency = 1.4;
        this.scoreTable = require('./mbti');
    }
    getSleepScore(userData, otherData){
        var ustime = userData.pstime;
        var ostime = otherData.pstime;
        var score = ustime - ostime + userData.pshour;
        return score;
    }
    getTotalScore(userData, otherData){
        var score = 0;
        score += this.scoreTable[this.MBTI_INDEX[userData.pmbti]][this.MBTI_INDEX[otherData.pmbti]] * this.mbti_dependency;
        score += userData.psmoke*otherData.psmoke*this.smoke_dependency;
        score += this.getSleepScore(userData,otherData)*this.sleep_dependency;
        return score;
    }
}