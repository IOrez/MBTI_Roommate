module.exports = function(app,db){
    var express = require('express');
    var router = express.Router();

    router.post('/',function(req,res,next){
        var id = req.body.userid;
        var password = req.body.password;
        db.query('SELECT * FROM User WHERE uid = ?', [id], function( error, results, fields) {
            if (error){
                console.log("error ocurred", error);
                res.send({'success':false,'reason':'unknown error'});
            } 
            else{
                if(results.length > 0) {
                    if(results[0].password == password)
                        res.send({
                            'success':true,
                            'uid':results[0].uid,
                            'uname':results[0].upassword,
                            'uuniv':results[0].uuniv,
                            'uemail':results[0].uemail,
                            'profileid':results[0].profileid
                        });
                    else
                        res.send({'success':false,'reason':'id or password not correct!'});
                }
                else
                    res.send({'success':false,'reason':'id or password not correct!'});
            }
        })
    });
    return router;
};