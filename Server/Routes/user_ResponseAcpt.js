module.exports = function(app,db){
    var express = require('express');
    var router = express.Router();
   
    router.post('/',function(req,res,next){
        var values = {
            "id":req.body.id,
            "otherid":req.body.otherid,
        };
        db.query(`DELETE FROM Request WHERE rid='${values.id}' OR rid='${values.otherid}'`,function( error, results, fields) {
            if(error){
                console.log("error ocurred", error);
                res.send({"success":false,"reason":"unknown error"});
            }
            else{
                db.query(`INSERT INTO Matched (mid,otherid) VALUES ?`,[[[req.body.id,req.body.otherid]]],function( error, results, fields) {
                    if (error){
                        console.log("error ocurred", error);
                        res.send({"success":false,"reason":"unknown error"});
                    } 
                    else{
                        db.query(`INSERT INTO Matched (mid,otherid) VALUES ?`,[[[req.body.otherid,req.body.id]]],function( error, results, fields) {
                            if (error){
                                console.log("error ocurred", error);
                                res.send({"success":false,"reason":"unknown error"});
                            } 
                            else{
                                db.query(`UPDATE User SET isMatched=1 WHERE id='${req.body.id}'OR id='${req.body.otherid}'`,function( error, results, fields) {
                                    if (error){
                                        console.log("error ocurred", error);
                                        res.send({"success":false,"reason":"unknown error"});
                                    } 
                                    else{
                                         res.send({"success":true});
                                    }
                                })
                            }
                        })
                    }
                })
            }
        });
    });
    return router;
};