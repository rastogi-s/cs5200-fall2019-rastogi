package edu.northeastern.cs5200;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import edu.northeastern.cs5200.daos.CourseDao;
import edu.northeastern.cs5200.daos.EnrollmentDao;
import edu.northeastern.cs5200.daos.FacultyDao;
import edu.northeastern.cs5200.daos.PersonDao;
import edu.northeastern.cs5200.daos.SectionDao;
import edu.northeastern.cs5200.daos.StudentDao;
import edu.northeastern.cs5200.daos.UniversityDao;
import edu.northeastern.cs5200.models.Course;
import edu.northeastern.cs5200.models.Faculty;
import edu.northeastern.cs5200.models.Section;
import edu.northeastern.cs5200.models.Student;

// TODO: Auto-generated Javadoc
/**
 * The Class TestSuite.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestSuite {

	/** The university dao. */
	@Autowired
	private UniversityDao universityDao;

	/** The faculty dao. */
	@Autowired
	private FacultyDao facultyDao;

	/** The person dao. */
	@Autowired
	private PersonDao personDao;

	/** The student dao. */
	@Autowired
	private StudentDao studentDao;

	/** The course dao. */
	@Autowired
	private CourseDao courseDao;

	/** The section dao. */
	@Autowired
	private SectionDao sectionDao;

	/** The enrollment dao. */
	@Autowired
	private EnrollmentDao enrollmentDao;

	/** The alan. */
	private Faculty alan;

	/** The ada. */
	private Faculty ada;

	/** The cs 1234. */
	private Course cs1234;

	/** The cs 2345. */
	private Course cs2345;

	/** The cs 3456. */
	private Course cs3456;

	/** The cs 4567. */
	private Course cs4567;

	/** The sec 4321. */
	private Section sec4321;

	/** The sec 5432. */
	private Section sec5432;

	/** The sec 6543. */
	private Section sec6543;

	/** The sec 7654. */
	private Section sec7654;

	/** The alice. */
	private Student alice;

	/** The bob. */
	private Student bob;

	/** The charlie. */
	private Student charlie;

	/** The dan. */
	private Student dan;

	/** The edward. */
	private Student edward;

	/** The frank. */
	private Student frank;

	/** The gregory. */
	private Student gregory;

	/**
	 * Sets the up.
	 */
	@Before
	public void setUp() {
		// delete add data
		universityDao.truncateDatabase();

		// create faculties
		alan = new Faculty("Alan", "Turin", "alan", "password", "123A", true);
		ada = new Faculty("Ada", "Lovelace", "ada", "password", "123B", true);
		alan = facultyDao.createFaculty(alan);
		ada = facultyDao.createFaculty(ada);

		// create students
		alice = new Student("Alice", "Wonderland", "alice", "password", 2020, 12000);
		bob = new Student("Bob", "Hope", "bob", "password", 2021, 23000);
		charlie = new Student("Charlie", "Brown", "charlie", "password", 2019, 21000);
		dan = new Student("Dan", "Craig", "dan", "password", 2019, 0);
		edward = new Student("Edward", "Scissorhands", "edward", "password", 2022, 11000);
		frank = new Student("Frank", "Herbert", "frank", "password", 2018, 0);
		gregory = new Student("Gregory", "Peck", "gregory", "password", 2023, 10000);

		alice = studentDao.createStudent(alice);
		bob = studentDao.createStudent(bob);
		charlie = studentDao.createStudent(charlie);
		dan = studentDao.createStudent(dan);
		edward = studentDao.createStudent(edward);
		frank = studentDao.createStudent(frank);
		gregory = studentDao.createStudent(gregory);

		// create courses
		cs1234 = new Course("CS1234", alan);
		cs2345 = new Course("CS2345", alan);
		cs3456 = new Course("CS3456", ada);
		cs4567 = new Course("CS4567", ada);

		courseDao.createCourse(cs1234);
		courseDao.createCourse(cs2345);
		courseDao.createCourse(cs3456);
		courseDao.createCourse(cs4567);

		// create sections
		sec4321 = new Section("SEC4321", 50, cs1234);
		sec5432 = new Section("SEC5432", 50, cs1234);
		sec6543 = new Section("SEC6543", 50, cs2345);
		sec7654 = new Section("SEC7654", 50, cs3456);

		sec4321 = sectionDao.createSection(sec4321);
		sec5432 = sectionDao.createSection(sec5432);
		sec6543 = sectionDao.createSection(sec6543);
		sec7654 = sectionDao.createSection(sec7654);

		// enroll students in sections
		enrollmentDao.enrollStudentInSection(alice, sec4321);
		enrollmentDao.enrollStudentInSection(alice, sec5432);
		enrollmentDao.enrollStudentInSection(bob, sec5432);
		enrollmentDao.enrollStudentInSection(charlie, sec6543);

	}

	/**
	 * Validate total person.
	 */
	@Test
	public void validateTotalPerson() {
		assertEquals(9, personDao.findAllUsers().size());
	}

	/**
	 * Validate total faculty.
	 */
	@Test
	public void validateTotalFaculty() {
		assertEquals(2, facultyDao.findAllFaculty().size());
	}

	/**
	 * Validate total student.
	 */
	@Test
	public void validateTotalStudent() {
		assertEquals(7, studentDao.findAllStudents().size());
	}

	/**
	 * Validate total course.
	 */
	@Test
	public void validateTotalCourse() {
		assertEquals(4, courseDao.findAllCourses().size());
	}

	/**
	 * Validate total section.
	 */
	@Test
	public void validateTotalSection() {
		assertEquals(4, sectionDao.findAllSections().size());
	}

	/**
	 * Validate course authorship.
	 */
	@Test
	public void validateCourseAuthorship() {
		assertEquals(2, facultyDao.findCoursesForAuthor(alan).size());
		assertEquals(2, facultyDao.findCoursesForAuthor(ada).size());
	}

	/**
	 * Validate section per course.
	 */
	@Test
	public void validateSectionPerCourse() {
		assertEquals(2, sectionDao.findSectionForCourse(cs1234).size());
		assertEquals(1, sectionDao.findSectionForCourse(cs2345).size());
		assertEquals(1, sectionDao.findSectionForCourse(cs3456).size());
		assertEquals(0, sectionDao.findSectionForCourse(cs4567).size());
	}

	/**
	 * Validate section enrollments.
	 */
	@Test
	public void validateSectionEnrollments() {
		assertEquals(1, enrollmentDao.findStudentsInSection(sec4321).size());
		assertEquals(2, enrollmentDao.findStudentsInSection(sec5432).size());
		assertEquals(1, enrollmentDao.findStudentsInSection(sec6543).size());
		assertEquals(0, enrollmentDao.findStudentsInSection(sec7654).size());
	}

	/**
	 * Validate student enrollments.
	 */
	@Test
	public void validateStudentEnrollments() {
		assertEquals(2, enrollmentDao.findSectionsForStudent(alice).size());
		assertEquals(0, enrollmentDao.findSectionsForStudent(dan).size());
		assertEquals(1, enrollmentDao.findSectionsForStudent(charlie).size());
		assertEquals(1, enrollmentDao.findSectionsForStudent(bob).size());
		assertEquals(0, enrollmentDao.findSectionsForStudent(edward).size());
		assertEquals(0, enrollmentDao.findSectionsForStudent(frank).size());
		assertEquals(0, enrollmentDao.findSectionsForStudent(gregory).size());

	}

	/**
	 * Validate section seats.
	 */
	@Test
	public void validateSectionSeats() {
		assertEquals(49, sec4321.getSeats());
		assertEquals(48, sec5432.getSeats());
		assertEquals(49, sec6543.getSeats());
		assertEquals(50, sec7654.getSeats());

	}
}
