const mongoose = require('mongoose');
const quizSchema = require('./quiz-widget.schema.server');
module.exports = mongoose.model('QuizWidgetModel', quizSchema);