module.exports = function(app,db){
    var express = require('express');
    var router = express.Router();
   
    router.post('/',function(req,res,next){
        var values = {
            "did":req.body.id,
            "otherid":req.body.otherid,
        };
        db.query(`SELECT * FROM DenyMatch WHERE did='${values.id}' AND otherid='${values.otherid}'`,function( error, results, fields) {
            if(error){
                console.log("error ocurred", error);
                res.send({"success":false,"reason":"unknown error"});
            }
            else{
                if(results.length>0){
                    res.send({"success":false,"reason":"이미 차단하였습니다."});
                }
                else{
                    db.query(`INSERT INTO DenyMatch SET ?`,values,function( error, results, fields) {
                        if (error){
                            console.log("error ocurred", error);
                            res.send({"success":false,"reason":"unknown error"});
                        } 
                        else{
                             res.send({"success":true});
                        }
                    })
                }
            }
        });
    });
    return router;
};