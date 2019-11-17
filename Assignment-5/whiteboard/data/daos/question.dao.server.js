const questionModel = require('../models/question/question.model.server');
createQuestion = question => questionModel.create(question);
findAllQuestions = () => questionModel.find();
findQuestionById = questionId => questionModel.findById(questionId);
updateQuestion = (questionId, question) => questionModel.update({_id: questionId}, {$set: question});
deleteQuestion = questionId => questionModel.deleteOne({_id: questionId});
deleteAllQuestions = () => questionModel.deleteMany({});

module.exports = {
    createQuestion,
    findAllQuestions,
    findQuestionById,
    updateQuestion,
    deleteQuestion,
    deleteAllQuestions
};
