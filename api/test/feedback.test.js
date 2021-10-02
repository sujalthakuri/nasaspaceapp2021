const Feedback = require('../models/feedbackModel');
const mongoose = require('mongoose');

// use the new name of the database
const url = 'mongodb://localhost:27017/test';

beforeAll(async () => {
 await mongoose.connect(url, {
 useNewUrlParser: true,
 useCreateIndex: true
 });
});
afterAll(async () => {
 await mongoose.connection.close();
});

describe('Feedback Test', () => {
// the code below is for insert testing
 it('Game Add', () => {
 const feed = {
    'username' : "John",
    'date' : "",
    'game_id' : "1000",
    'coment' : "dami",

 };

 return Feedback.create(feed)
 .then((returned) => {
 expect(returned.username).toEqual('John');
 });
 });


it('Update Testing', async () => {
    return Feedback.findOneAndUpdate({username :Object('John')},
   {$set : {username:'sujal'}})
    .then((returned)=>{
    expect(returned.username).toEqual('John')
    })
   
   });

 
   // the code below is for delete testing
 it('Delete Test', async () => {
 const status = await Feedback.deleteMany();
 expect(status.ok).toBe(1);
});
   
   })