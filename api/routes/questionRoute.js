const express = require('express')
const router = express.Router()
const Question = require('../models/question')


router.post('/add_question', function(req,res){
    console.log("Working")
    const question = req.body.question
    const option1 = req.body.option1
    const option2 = req.body.option2
    const option3 = req.body.option3
    const option4 = req.body.option4
    const correctAnswer = req.body.correctAnswer
    const questionBank = req.body.questionBank

    const data = new Question({
        question : question,
        option1 : option1,
        option2 : option2,
        option3 : option3,
        option4 : option4,
        correctAnswer : correctAnswer,
        questionBank : questionBank
    })
    data.save()
    .then(function(result){
        res.status(200).json({success: true})
    })
    .catch(function(err){
        res.status(201).json({message : err})
    })
})


router.get('/load_question/',function(req,res){
    const questionBank = req.body.questionBank
    Feedback.find({questionBank:questionBank})
    .then(function(data){
        res.status(200).json({success:true, data :data})
    })
    .catch(function(e){

        res.status(500).json({message : e})
    })

})

module.exports = router
