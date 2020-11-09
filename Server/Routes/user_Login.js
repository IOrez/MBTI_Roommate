module.exports = function(app,db){
    var express = require('express');
    var router = express.Router();

    router.post('/',function(req,res,next){
        var id = req.body.id;
        var password = req.body.password;
        console.log(id);
        console.log(password);
        db.query('SELECT * FROM User WHERE id = ?', [id], function( error, results, fields) {
            if (error){
                console.log("error ocurred", error);
                res.send({"success":false,"reason":"unknown error"});
            } 
            else{
                console.log(results);
                if(results.length > 0) {
                    if(results[0].password == password)
                        res.send({
                            "success":true,
                            "id":results[0].id,
                            "password":results[0].password,
                            "pname":results[0].pname,
                            "pgender":results[0].pgender,
                            "pmbti":results[0].pmbti,
                            "pdormitory":results[0].pdormitory,
                            "univ":results[0].univ,
                            "email":results[0].email,
                            "psmoke":results[0].psmoke,
                            "pcomment":results[0].pcomment,
                            "page":results[0].page,
                            "pcontact":results[0].pcontact,
                            "pstime":results[0].pstime,
                            "pshour":results[0].pshour,
                            "hasMatchBefore":results[0].hasMatchBefore
                        });
                    else
                        res.send({"success":false,"reason":"id or password not correct!"});
                }
                else
                    res.send(JSON.stringify({"success":false,"reason":"id or password not correct!"}));
            }
        })
    });
    return router;
};