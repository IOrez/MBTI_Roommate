
const ProfileData = require('../Class/ProfileData');
module.exports = function(app,db){
    var express = require('express');
    var router = express.Router();

    router.post('/',function(req,res,next){
        console.log(req.body);
        console.log("------------------------------------------");
    
        var profileNodes = [];
        db.query(`SELECT * FROM User WHERE pdormitory='${req.body.pdormitory}' AND pname='${req.body.pname}'`, function( error, results, fields) {
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
                        results[i].pmajor,
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
                    profileNodes.push(otherData);
                }

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
                        '"pmajor":'+`${profileNodes[i].pmajor},`+
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

                console.log(items);
                res.send(items);
            }
        });

    });
    return router;
};