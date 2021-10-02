const jwt = require('jsonwebtoken')
const Customer = require('../models/customer_model')

module.exports.verifyUser = function(req,res,next){
    try{
        const token = req.headers.authorization.split(" ")[1]
        const data = jwt.verify(token,'secretkey')
        
    }
    catch{
        console.log("No Login Found!")                
    }

}