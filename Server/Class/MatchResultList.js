
const MatchScore = require("./MatchScore");
const ProfileData = require('./ProfileData');
const UserNode = require('./UserNode');
module.exports = class MatchResultList{
    constructor(app,db){
        this.app = app;
        this.db = db;
        this.table = new MatchScore();
        this.nodes = []
        this.profileNodes = []
        this.maxiumSize = 3
    }

    makeList(userData){
        db.query('SELECT * FROM User WHERE pdormitory = ?', [userData.pdormitory], function( error, results, fields) {
            if (error)
                console.log("error ocurred", error);
            else{
                for(var i = 0;i<results.length;++i){
                    var otherData = new ProfileData(
                        results[i].id,
                        results[i].password,
                        results[i].pname,
                        results[i].pgender,
                        results[i].pmbti,
                        results[i].pdormitory,
                        results[i].univ,
                        results[i].email,
                        results[i].psmoke,
                        results[i].pcomment,
                        results[i].page,
                        results[i].pcontact,
                        results[i].pstime,
                        results[i].pshour,
                        results[i].hasMatchBefore
                    );
                    var score = this.table.getTotalScore(userData,otherData);
                    this.nodes.add(new UserNode(score,otherData));
                }

                this.nodes.sort(function(obj1,obj2){
                    return obj2.score - obj1.score;
                });

                let limit = (this.nodes.length < 20 ) ? this.nodes.length : 20;
                for(var i = limit;i;--i){
                    j = Math.floor(Math.random()*i);
                    tmp = this.nodes[i-1];
                    this.nodes[i-1] = this.nodes[j];
                    this.nodes[j] = tmp;
                }
                limit = (this.nodes.length < this.maxiumSize ) ? this.nodes.length : this.maxiumSize;
                for(var i = 0;i<limit;++i)
                    this.profileNodes.add(this.nodes[i].profileData);
            }
        })
    }
};