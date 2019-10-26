package edu.northeastern.cs5200.daos;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.northeastern.cs5200.models.Student;
import edu.northeastern.cs5200.repositories.StudentRepository;

/**
 * The Class StudentDao.
 */
@Repository
public class StudentDao {

	/** The student repository. */
	@Autowired
	private StudentRepository studentRepository;

	/**
	 * Creates the student.
	 *
	 * @param student the student
	 * @return the student
	 */
	public Student createStudent(Student student) {
		return studentRepository.save(student);
	}

	/**
	 * Find all students.
	 *
	 * @return the list
	 */
	public List<Student> findAllStudents() {
		Iterable<Student> iter = studentRepository.findAll();
		List<Student> listOfStudent = new ArrayList<>();
		for (Student student : iter) {
			listOfStudent.add(student);
		}

		return listOfStudent;
	}

}
