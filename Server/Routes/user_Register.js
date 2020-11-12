module.exports = function(app,db){
    var express = require('express');
    var router = express.Router();

    router.post('/User/Register',function(req,res,next){

        db.query('SELECT * FROM User WHERE id = ?', [id], function( error, results, fields) {
            if (error){
                console.log("error ocurred", error);
                res.send({"success":false,"reason":"unknown error"});
            } 
            else{
                console.log(results);
                if(results.length > 0)
                    res.send({"success":false,"reason":"duplicated id!"});
                else{
                    var User = {
                        "id": req.body.id,
                        "password":User.password,
                        "pname":req.body.pname,
                        "pgender":req.body.pgender,
                        "pmbti":req.body.pmbti,
                        "pdormitory":req.body.pdormitory,
                        "univ":req.body.univ,
                        "email":req.body.email,
                        "psmoke":req.body.psmoke,
                        "pcomment":req.body.pcomment,
                        "page":req.body.page,
                        "pcontact":req.body.pcontact,
                        "pstime":req.body.pstime,
                        "pshour":req.body.pshour,
                        "hasMatchBefore":false
                    }
                    db.query('INSERT INTO User SET ?', User, function( error, results, fields) {
                        if (error){
                            console.log("error ocurred", error);
                            res.send({"success":false,"reason":"register error!!"});
                        }else{
                            res.send({
                                "success":true,
                                "id":User.id,
                                "password":User.password,
                                "pname":User.pname,
                                "pgender":User.pgender,
                                "pmbti":User.pmbti,
                                "pdormitory":User.pdormitory,
                                "univ":User.univ,
                                "email":User.email,
                                "psmoke":User.psmoke,
                                "pcomment":User.pcomment,
                                "page":User.page,
                                "pcontact":User.pcontact,
                                "pstime":User.pstime,
                                "pshour":User.pshour,
                                "hasMatchBefore":User.hasMatchBefore
                            });
                        }
                    });
                }
            }
        })
    });
    return router;
};