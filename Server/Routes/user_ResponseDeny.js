module.exports = function(app,db){
    var express = require('express');
    var router = express.Router();
   
    router.post('/',function(req,res,next){
        var values = {
            "id":req.body.id,
            "otherid":req.body.otherid,
        };
        db.query(`DELETE FROM Request WHERE rid='${values.otherid}' AND otherid='${values.id}'`,function( error, results, fields) {
            if(error){
                console.log("error ocurred", error);
                res.send({"success":false,"reason":"unknown error"});
            }
            else{
                db.query(`INSERT INTO DenyMatch (did,otherid) VALUES ?`,[[[req.body.otherid,req.body.id]]],function( error, results, fields) {
                    if (error){
                        console.log("error ocurred", error);
                        res.send({"success":false,"reason":"unknown error"});
                    } 
                    else{
                        db.query(`INSERT INTO DenyMatch (did,otherid) VALUES ?`,[[[req.body.id,req.body.otherid]]],function( error, results, fields) {
                            if (error){
                                console.log("error ocurred", error);
                                res.send({"success":false,"reason":"이미 차단하였습니다."});
                            } 
                            else{
                                 res.send({"success":true});
                            }
                        })
                    }
                })
            }
        });
    });
    return router;
};