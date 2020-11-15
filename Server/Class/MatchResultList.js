
const MatchScore = require("./MatchScore");
const ProfileData = require('./ProfileData');
const UserNode = require('./UserNode');
module.exports = class MatchResultList{
    constructor(){

    }

    makeList(userData,req,res){
        const mySQL  = require('../Module/db');
        var db = mySQL.init();
        var table = new MatchScore();
        var nodes = [];
        var profileNodes = [];
        var maxiumSize = 3;
        db.query(`SELECT * FROM User WHERE pdormitory = ${userData.pdormitory} and NOT id='${userData.id}' and isMatched=0 and id NOT IN(SELECT otherid FROM DenyMatch WHERE id ='${userData.id}')`, function( error, results, fields) {
            if (error)
                console.log("error ocurred", error);
            else{
                console.log(results);
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
                        results[i].hasMatchBefore,
                        results[i].isMatched
                    );
                    var score = table.getTotalScore(userData,otherData);
                    console.log(`score: ${score}`);
                    nodes.push(new UserNode(score,otherData));
                }

                nodes.sort(function(obj1,obj2){
                    return obj2.score - obj1.score;
                });

                let limit = (nodes.length < 20 ) ? nodes.length : 20;
                for(var i = limit;i;--i){
                    var j = Math.floor(Math.random()*i);
                    var tmp = nodes[i-1];
                    nodes[i-1] = nodes[j];
                    nodes[j] = tmp;
                }
                limit = (nodes.length < maxiumSize ) ? nodes.length : maxiumSize;
                for(var i = 0;i<limit;++i)
                    profileNodes.push(nodes[i].profileData);

                var items="{";
                items+=`"success":"true","Users":[{`
                for(var i =0; i<profileNodes.length;++i){
                    var obj =
                        '"id":'+ `"${profileNodes[i].id}",`+
                        '"password":'+`"${profileNodes[i].password}",`+
                        '"pname":'+`"${profileNodes[i].pname}",`+
                        '"pgender":'+`${profileNodes[i].pgender},`+
                        '"pmbti":'+`${profileNodes[i].pmbti},`+
                        '"pdormitory":'+`${profileNodes[i].pdormitory},`+
                        '"univ":'+`${profileNodes[i].univ},`+
                        '"email":'+`"${profileNodes[i].email}",`+
                        '"psmoke":'+`${profileNodes[i].psmoke},`+
                        '"pcomment":'+`"${profileNodes[i].pcomment}",`+
                        '"page":'+`${profileNodes[i].page},`+
                        '"pcontact":'+`"${profileNodes[i].pcontact}",`+
                        '"pstime":'+`${profileNodes[i].pstime},`+
                        '"pshour":'+`${profileNodes[i].pshour},`+
                        '"hasMatchBefore":'+`${profileNodes[i].hasMatchBefore},`+
                        '"isMatched":'+`${profileNodes[i].isMatched}`+
                        "}"
                   
                    items += obj;
                    if(i+1<profileNodes.length)items+=",{";
                }
                if(profileNodes.length==0)items+="}";
                items+="]}";
                console.log(`items: ${items}`);
                items= JSON.parse(items);

                db.query(`DELETE FROM SavedMatch WHERE id = '${userData.id}'`, function( error, results, fields) {
                    if (error)
                        console.log("error ocurred", error);
                    else{
                        let list = items["Users"];
                        let values = [];
                        for(var i =0;i<list.length;++i){
                            var obj = []
                            obj.push(userData.id);
                            obj.push(list[i].id);
                            obj.push("waiting");
                            values.push(obj);
                        }
                        db.query(`INSERT INTO SavedMatch (id,otherid,status) VALUES ?`,[values],function( error, results, fields) {
                            if (error)
                                console.log("error ocurred", error);
                            else{
                                db.query(`UPDATE User SET hasMatchBefore=1 WHERE id='${userData.id}'`,function( error, results, fields) {
                                    if (error)
                                        console.log("error ocurred", error);
                                    else{
                                        console.log(items);
                                        res.send(items);
                                    }
                                });
                            }

                        });
                    }
                });
            }
        });
    }
};