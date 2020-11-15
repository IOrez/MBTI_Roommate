module.exports = function(app,db){
    var express = require('express');
    var router = express.Router();
   
    router.post('/',function(req,res,next){
        var values = {
            "id":req.body.id,
            "otherid":req.body.otherid,
        };
        db.query(`DELETE FROM Request WHERE rid='${values.id}' AND otherid='${values.otherid}'`,function( error, results, fields) {
            if(error){
                console.log("error ocurred", error);
                res.send({"success":false,"reason":"unknown error"});
            }
            else{
                res.send({"success":true});
            }
        });
    });
    return router;
};