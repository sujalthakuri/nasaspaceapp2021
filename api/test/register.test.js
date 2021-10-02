const User = require('../models/customer_model');
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

describe('Register Test', () => {
// the code below is for insert testing
 it('Register', () => {
 const user = {
 'first_name': 'test',
 'last_name': 'test',
 'username' : "test",
 'password' : 'password',
 'dob' : '12/02/2005',
 'gender' : "Male",
 'genre' : 'Sports',
 'platform' : "PS4",
 'role' : "Admin"
 };

 return User.create(user)
 .then((returned) => {
 expect(returned.first_name).toEqual('test');
 });
 });


it('Update Testing', async () => {
    return User.findOneAndUpdate({first_name :Object('test')},
   {$set : {first_name:'John'}})
    .then((returned)=>{
    expect(returned.first_name).toEqual('test')
    })
   
   });

 
   // the code below is for delete testing
 it('Delete Test', async () => {
 const status = await User.deleteMany();
 expect(status.ok).toBe(1);
});
   
   })