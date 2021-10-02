const mongoose = require('mongoose')

mongoose.connect('mongodb://127.0.0.1:27017/nasaspaceapp2021',{
    useCreateIndex:true,
    useNewUrlParser:true,
    useUnifiedTopology : true
})