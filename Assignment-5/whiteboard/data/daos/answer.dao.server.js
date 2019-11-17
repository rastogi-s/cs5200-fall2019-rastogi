const answerModel = require('../models/answer/answer.model.server');
createAnswer = (answer) => answerModel.create(answer);
findAllAnswers = () => answerModel.find();
findAnswerById = answerId => answerModel.findById(answerId);
updateAnswer = (answerId, answer) => answerModel.update({_id: answerId}, {$set: answer});
deleteAnswer = answerId => answerModel.deleteOne({_id: answerId});
deleteAllAnswers = () => answerModel.deleteMany({});
findAnswersByStudent = studentId => answerModel.find({student: studentId});
findAnswersByQuestion = questionId => answerModel.find({question: questionId});
answerQuestion = (studentId, questionId, answer) => {
    answer['student'] = studentId;
    answer['question'] = questionId;
    createAnswer(answer);
};

module.exports = {
    createAnswer, findAllAnswers, findAnswerById, updateAnswer, deleteAnswer, deleteAllAnswers, findAnswersByQuestion,
    findAnswersByStudent, answerQuestion
};
