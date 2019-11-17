const studentModel = require('../models/student/student.model.server');
createStudent = student => studentModel.create(student);
findAllStudents = () => studentModel.find();
findStudentById = studentId => studentModel.findById(studentId);
updateStudent = (studentId, student) => studentModel.update({_id: studentId}, {$set: student});
deleteStudent = studentId => studentModel.deleteOne({_id: studentId});
deleteAllStudents = () => studentModel.deleteMany({});
module.exports = {
    createStudent, findAllStudents, findStudentById, updateStudent, deleteStudent, deleteAllStudents
};
