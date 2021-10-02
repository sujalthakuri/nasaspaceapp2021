const Game = require('../models/gameModel');
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

describe('Game Test', () => {
// the code below is for insert testing
 it('Game Add', () => {
 const game = {
    'gname' : "Test Game",
    'gdesc' : "Test Game",
    'gprice' : "100",

 };

 return Game.create(game)
 .then((returned) => {
 expect(returned.gname).toEqual('Test Game');
 });
 });


it('Update Testing', async () => {
    return Game.findOneAndUpdate({gname :Object('Test Game')},
   {$set : {gname:'John'}})
    .then((returned)=>{
    expect(returned.gname).toEqual('Test Game')
    })
   
   });

 
   // the code below is for delete testing
 it('Delete Test', async () => {
 const status = await Game.deleteMany();
 expect(status.ok).toBe(1);
});
   
   })