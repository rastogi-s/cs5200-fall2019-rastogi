const studentDao = require('./student.dao.server');
const questionDao = require('./question.dao.server');
const answerDao = require('./answer.dao.server');
const content = require('../content.data.server');


truncateDatabase = () => {
    return Promise.all([
        answerDao.deleteAllAnswers(),
        questionDao.deleteAllQuestions(),
        studentDao.deleteAllStudents(),
    ]);
};

populateDatabase = () => {

    const studentCreate = () => content.listOfStudents.forEach((student) => {
        studentDao.createStudent(student);
    });

    const questionsCreate = () => content.listOfQuestions.forEach((question) => {
        questionDao.createQuestion(question);
    });

    const answerCreate = () => content.listOfAnswers.forEach((answer) => {
        answerDao.createAnswer(answer);
    });

    return Promise.all([studentCreate(),questionsCreate(),answerCreate()]);

};


module.exports = {
    truncateDatabase, populateDatabase
};

