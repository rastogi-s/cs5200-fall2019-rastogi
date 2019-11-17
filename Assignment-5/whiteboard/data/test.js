let mocha = require('mocha');
let describe = mocha.describe;
let it = mocha.it;
let chai = require('chai');
let assert = chai.assert;

const universityDao = require('../data/daos/university.dao.server');
const studentDao = require('../data/daos/student.dao.server');
const answerDao = require('../data/daos/answer.dao.server');
const questionDao = require('../data/daos/question.dao.server');
const db = require('./db');

describe('Establish connection to database before running tests', function () {
    this.timeout(4000);
    before(function (done) {
        db.connectToDatabase(done);
    });

    describe('Run truncate all and populate tasks', () => {
        before((done) => {
            universityDao.truncateDatabase().then((resolve, reject) => {
                if (resolve) {
                    console.log('truncated data successfully');
                    universityDao.populateDatabase().then((resolve, reject) => {
                            if (resolve) {
                                console.log('populated data successfully');
                                done();
                            } else {
                                console.log('Error-> failed due to populate error');
                                done();
                            }
                        }
                    )
                } else {
                    console.log('failed due to truncate error');
                    done();
                }
            });
        });

        it('Test student initial count', function (done) {
            studentDao.findAllStudents().then((students) => {
                assert.equal(students.length, 2);
            }).then(() => {
                done();
            }).catch(console.log);
        });

        it('Test question initial count', function (done) {
            questionDao.findAllQuestions().then((question) => {
                assert.equal(question.length, 4);
            }).then(() => {
                done();
            }).catch(console.log);
        });

        it('Test answers initial count', function (done) {
            answerDao.findAllAnswers().then((answers) => {
                assert.equal(answers.length, 8);
            }).then(() => {
                done();
            }).catch(console.log);
        });

        it('Delete Answer', function (done) {

            studentDao.findAllStudents().then((students) => {
                const stud = students.filter(student => student.firstName === 'Bob');
                questionDao.findAllQuestions().then((questions) => {
                    const ques = questions.filter(q => q.question === 'What does ORM stand for?');
                    answerDao.findAllAnswers().then((answers) => {
                        const ans = answers.filter((answer) =>
                            answer.student === stud[0]._id && answer.question === ques[0]._id
                        );
                        answerDao.deleteAnswer(ans[0]).then(() => {
                            answerDao.findAllAnswers().then((answers) => {
                                assert.equal(answers.length, 7);
                            }).then(() => {
                                answerDao.findAnswersByStudent(234).then((answers) => {
                                    assert.equal(answers.length, 3);
                                }).then(() => {
                                    done();
                                })

                            })
                        })
                    })
                });

            }).catch(console.log);


        });

        it('Delete Question', function (done) {

            questionDao.findAllQuestions().then((questions) => {
                const ques = questions.filter(q => q.question === 'Is the following schema valid?');
                questionDao.deleteQuestion(ques[0]).then(() => {
                    questionDao.findAllQuestions().then((questionsAfterDeletion) => {
                        assert.equal(questionsAfterDeletion.length, 3);
                    }).then(() => {
                        done();
                    })

                })
            }).catch(console.log);

        });

        it('Delete Student', function (done) {

            studentDao.findAllStudents().then((students) => {
                const stud = students.filter(student => student.firstName === 'Bob');
                studentDao.deleteStudent(stud[0]).then(() => {
                    studentDao.findAllStudents().then((studentAfterDeletion) => {
                        assert.equal(studentAfterDeletion.length, 1);
                    }).then(() => {
                        done();
                    })

                })
            }).catch(console.log);

        });

    });


    after((done) => {
        db.dropConnection(done);
    })

});


