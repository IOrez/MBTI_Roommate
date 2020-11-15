module.exports = function(app,db){
    var express = require('express');
    var router = express.Router();
   
    router.post('/',function(req,res,next){
        var values = {
            "id":req.body.id,
        };
        db.query(`SELECT * FROM DenyMatch,User WHERE DenyMatch.did='${values.id}' AND DenyMatch.otherid=User.id`,function( error, results, fields) {
            if(error){
                console.log("error ocurred", error);
                res.send({"success":false,"reason":"unknown error"});
            }
            else{
                var items="{";
                items+=`"success":"true","Users":[{`
                for(var i =0; i<results.length;++i){
                    var obj =
                        '"id":'+ `"${results[i].id}",`+
                        '"password":'+`"${results[i].password}",`+
                        '"pname":'+`"${results[i].pname}",`+
                        '"pgender":'+`${results[i].pgender},`+
                        '"pmbti":'+`${results[i].pmbti},`+
                        '"pdormitory":'+`${results[i].pdormitory},`+
                        '"univ":'+`${results[i].univ},`+
                        '"pmajor":'+`${results[i].pmajor},`+
                        '"email":'+`"${results[i].email}",`+
                        '"psmoke":'+`${results[i].psmoke},`+
                        '"pcomment":'+`"${results[i].pcomment}",`+
                        '"page":'+`${results[i].page},`+
                        '"pcontact":'+`"${results[i].pcontact}",`+
                        '"pstime":'+`${results[i].pstime},`+
                        '"pshour":'+`${results[i].pshour},`+
                        '"hasMatchBefore":'+`${results[i].hasMatchBefore},`+
                        '"isMatched":'+`${results[i].isMatched}`+
                        "}"
                   
                    items += obj;
                    if(i+1<results.length)items+=",{";
                }
                if(results.length==0)items+="}";
                items+="]}";

                items= JSON.parse(items);

                console.log(items);
                res.send(items);

            }
        });
    });
    return router;
};