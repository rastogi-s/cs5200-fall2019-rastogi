const mongoose = require('mongoose');
const quizWidgetSchema = mongoose.Schema({
    questions: [{
        type: mongoose.Schema.Types.Number,
        ref: 'QuestionModel'
    }]
}, {collection: 'quiz-widgets'});
module.exports =  quizWidgetSchema;
