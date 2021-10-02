const mongoose = require('mongoose')

const Question = mongoose.model('Question',{

    questionBank : {
        type:String,
        required : true
    },
    
    question : {
        type: String,
        required : true
    },

    option1 : {
        type : String,
        required : true
    },

    option2 : {
        type : String,
        required : true
    },

    option3 : {
        type : String,
        required : true
    },
    option4 : {
        type : String,
        required : true
    },
    
    correctAnswer : {
        type : String,
        required : true
    },
    
    image :{
        type : String,
        required : true
    },
    information : {
        type:String,
        required:true
    },
    youtubeLink : {
        type : String,
        required:true
    },
    nasaLink :{
        type : String,
        required : true
    }

})

module.exports = Question