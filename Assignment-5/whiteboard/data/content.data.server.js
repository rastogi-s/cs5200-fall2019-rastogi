const alice = {
    _id: 123,
    username: 'alice',
    password: 'alice',
    firstName: 'Alice',
    lastName: 'Wonderland',
    gradYear: 2020,
    scholarship: 15000
};

const bob = {
    _id: 234,
    username: 'bob',
    password: 'bob',
    firstName: 'Bob',
    lastName: 'Hope',
    gradYear: 2021,
    scholarship: 12000
};

const listOfStudents = [alice, bob];

const question1 = {
    _id: 321,
    question: 'Is the following schema valid?',
    points: 10,
    questionType: 'TRUE_FALSE',
    trueFalse: {
        is_true: false
    }
};

const question2 = {
    _id: 432,
    question: 'DAO stands for Dynamic Access Object.',
    points: 10,
    questionType: 'TRUE_FALSE',
    trueFalse: {
        is_true: false
    }
};

const question3 = {
    _id: 543,
    question: 'What does JPA stand for?',
    points: 10,
    questionType: 'MULTIPLE_CHOICE',
    multipleChoice: {
        choices: 'Java Persistence API,Java Persisted Application,JavaScript Persistence API,JSON Persistent Associations',
        correct:1
    }
};

const question4 = {
    _id: 654,
    question: 'What does ORM stand for?',
    points: 10,
    questionType: 'MULTIPLE_CHOICE',
    multipleChoice: {
        choices: 'Object Relational Model,Object Relative Markup,Object Reflexive Model,Object Relational Mapping',
        correct:1
    }
};


const listOfQuestions = [question1,question2,question3,question4];


const answer1 = {
    _id: 123,
    trueFalseAnswer: true,
    student: alice._id,
    question: question1._id
};

const answer2 = {
    _id: 234,
    trueFalseAnswer: false,
    student: alice._id,
    question: question2._id
};

const answer3= {
    _id: 345,
    multipleChoice:1,
    student: alice._id,
    question: question3._id
};

const answer4 = {
    _id: 456,
    multipleChoice:2,
    student: alice._id,
    question: question4._id
};

const answer5 = {
    _id: 567,
    trueFalseAnswer: false,
    student: bob._id,
    question: question1._id
};

const answer6 = {
    _id: 678,
    trueFalseAnswer: true,
    student: bob._id,
    question: question2._id
};

const answer7= {
    _id: 789,
    multipleChoice:3,
    student: bob._id,
    question: question3._id
};

const answer8 = {
    _id: 890,
    multipleChoice:4,
    student: bob._id,
    question: question4._id
};


const listOfAnswers = [answer1,answer2,answer3,answer4,answer5,answer6,answer7,answer8];

module.exports = {
    alice, bob, listOfStudents, listOfQuestions, listOfAnswers
};
