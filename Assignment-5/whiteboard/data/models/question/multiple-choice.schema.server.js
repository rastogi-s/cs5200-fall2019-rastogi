const mongoose = require('mongoose');
const multipleChoiceSchema = mongoose.Schema({
    choices: String,
    correct: Number
},{ _id : false });

module.exports = multipleChoiceSchema;
