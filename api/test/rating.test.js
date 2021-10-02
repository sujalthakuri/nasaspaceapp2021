const Rating = require('../models/ratingModel');
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

describe('Rating Test', () => {
// the code below is for insert testing
 it('Game Add', () => {
 const rate = {
    'username' : "sujal",
    'date' : "",
    'game_id' : "1001",
    'rating' : "",

 };

 return Rating.create(rate)
 .then((returned) => {
 expect(returned.username).toEqual('sujal');
 });
 });


it('Update Testing', async () => {
    return Rating.findOneAndUpdate({username :Object('sujal')},
   {$set : {username:'singh'}})
    .then((returned)=>{
    expect(returned.username).toEqual('sujal')
    })
   
   });

 
   // the code below is for delete testing
 it('Delete Test', async () => {
 const status = await Rating.deleteMany();
 expect(status.ok).toBe(1);
});
   
   })