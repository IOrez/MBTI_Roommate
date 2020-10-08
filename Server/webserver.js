const express = require('express');
const app = express();
const bodyParser = require('body-parser');
const mySQL  = require('./Module/db');

app.use(bodyParser.urlencoded({extended: true}));
app.use(bodyParser.json());

app.use(function(req,res,next){
	res.header("Access-Control-Allow-Origin", "*");
  res.header("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");
	next();
});

var dbConnection = mySQL.init();

app.use('/User/Login',require('./Routes/user_Login')(app,dbConnection));
//app.use('/User/Register',require('./Routes/user_Register')(app,dbConnection));
//app.use('/Find',require('./Routes/Find')(app,dbConnection));


app.listen(5000,function(req,res){
    console.log('connected!!');
});