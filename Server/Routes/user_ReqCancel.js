const { userManager } = require('../Global/global');

module.exports = function(app,db){
    var express = require('express');
    var router = express.Router();
   
    router.post('/',function(req,res,next){
        userManager = require('../Global/global').userManager;
        userManager.reqCancel(req,res,db);
    });
    return router;
};