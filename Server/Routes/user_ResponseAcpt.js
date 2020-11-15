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
                                        db.query(`SELECT * FROM User WHERE User.id='${req.body.otherid}'`,function( error, results, fields) {
                                            if(error){
                                                console.log("error ocurred", error);
                                                res.send({"success":false,"reason":"unknown error"});
                                            }
                                            else{
                                                var msg = {
                                                    "success":true,
                                                    "id":results[0].id,
                                                    "password":results[0].password,
                                                    "pname":results[0].pname,
                                                    "pgender":results[0].pgender,
                                                    "pmbti":results[0].pmbti,
                                                    "pdormitory":results[0].pdormitory,
                                                    "univ":results[0].univ,
                                                    "pmajor":results[0].pmajor,
                                                    "email":results[0].email,
                                                    "psmoke":results[0].psmoke,
                                                    "pcomment":results[0].pcomment,
                                                    "page":results[0].page,
                                                    "pcontact":results[0].pcontact,
                                                    "pstime":results[0].pstime,
                                                    "pshour":results[0].pshour,
                                                    "hasMatchBefore":results[0].hasMatchBefore,
                                                    "isMatched":results[0].isMatched,
                                                    "roommate":{}
                                                };
                                                res.send(msg);
                                            }
                                        });
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