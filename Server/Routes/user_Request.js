module.exports = function(app,db){
    var express = require('express');
    var router = express.Router();
   
    router.post('/',function(req,res,next){
        var values = {
            "rid":req.body.id,
            "otherid":req.body.otherid,
            "status":"waiting"
        };
        console.log(values);
        db.query(`SELECT * FROM Request WHERE rid='${values.rid}' AND otherid='${values.otherid}'`,function( error, results, fields) {
            if(error){
                console.log("error ocurred", error);
                res.send({"success":false,"reason":"unknown error"});
            }
            else{
                if(results.length>0){
                    res.send({"success":false,"reason":"이미 요청하였습니다."});
                }
                else{
                    db.query(`SELECT * FROM User WHERE id='${values.otherid}'`,function( error, Users, fields) {
                        if (error){
                            console.log("error ocurred", error);
                            res.send({"success":false,"reason":"unknown error"});
                        } 
                        else{
                            if(Users[0].isMatched==1){
                                res.send({"success":false,"reason":"이미 매칭된 상대가 존재합니다."});
                            }else{
                                db.query(`INSERT INTO Request SET ?`,values,function( error, results, fields) {
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
                   
                }
            }
        });
    });
    return router;
};