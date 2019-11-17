const mongoose = require('mongoose');
const studentSchema = mongoose.Schema({
    _id:{type:Number, required:true},
    username: String,
    password: String,
    firstName: String,
    lastName: String,
    gradYear:Number,
    scholarship:Number
}, {collection: 'student'});
module.exports = studentSchema;
