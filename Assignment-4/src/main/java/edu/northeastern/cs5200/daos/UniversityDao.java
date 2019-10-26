package edu.northeastern.cs5200.daos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.northeastern.cs5200.repositories.AnswerRepository;
import edu.northeastern.cs5200.repositories.CourseRepository;
import edu.northeastern.cs5200.repositories.EnrollmentRepository;
import edu.northeastern.cs5200.repositories.FacultyRepository;
import edu.northeastern.cs5200.repositories.HeadingWidgetRepository;
import edu.northeastern.cs5200.repositories.ImageWidgetRepository;
import edu.northeastern.cs5200.repositories.LessonRepository;
import edu.northeastern.cs5200.repositories.ListWidgetRepository;
import edu.northeastern.cs5200.repositories.ModuleRepository;
import edu.northeastern.cs5200.repositories.MultipleChoiceRepository;
import edu.northeastern.cs5200.repositories.ParagraphWidgetRepository;
import edu.northeastern.cs5200.repositories.PersonRepository;
import edu.northeastern.cs5200.repositories.QuestionRepository;
import edu.northeastern.cs5200.repositories.QuizWidgetRepository;
import edu.northeastern.cs5200.repositories.SectionRepository;
import edu.northeastern.cs5200.repositories.StudentRepository;
import edu.northeastern.cs5200.repositories.TopicRepository;
import edu.northeastern.cs5200.repositories.TrueFalseRepository;
import edu.northeastern.cs5200.repositories.WidgetRepository;
import edu.northeastern.cs5200.repositories.YouTubeWidgetRepository;

/**
 * The Class UniversityDao.
 */
@Repository
public class UniversityDao {

	/** The answer repository. */
	@Autowired
	private AnswerRepository answerRepository;

	/** The course repository. */
	@Autowired
	private CourseRepository courseRepository;

	/** The enrollment repository. */
	@Autowired
	private EnrollmentRepository enrollmentRepository;

	/** The faculty repository. */
	@Autowired
	private FacultyRepository facultyRepository;

	/** The heading widget repository. */
	@Autowired
	private HeadingWidgetRepository headingWidgetRepository;

	/** The image widget repository. */
	@Autowired
	private ImageWidgetRepository imageWidgetRepository;

	/** The lesson repository. */
	@Autowired
	private LessonRepository lessonRepository;

	/** The list widget repository. */
	@Autowired
	private ListWidgetRepository listWidgetRepository;

	/** The module repository. */
	@Autowired
	private ModuleRepository moduleRepository;

	/** The multiple choice repository. */
	@Autowired
	private MultipleChoiceRepository multipleChoiceRepository;

	/** The paragraph widget repository. */
	@Autowired
	private ParagraphWidgetRepository paragraphWidgetRepository;

	/** The person repository. */
	@Autowired
	private PersonRepository personRepository;

	/** The question repository. */
	@Autowired
	private QuestionRepository questionRepository;

	/** The quiz widget repository. */
	@Autowired
	private QuizWidgetRepository quizWidgetRepository;

	/** The section repository. */
	@Autowired
	private SectionRepository sectionRepository;

	/** The student repository. */
	@Autowired
	private StudentRepository studentRepository;

	/** The topic repository. */
	@Autowired
	private TopicRepository topicRepository;

	/** The true false repository. */
	@Autowired
	private TrueFalseRepository trueFalseRepository;

	/** The widget repository. */
	@Autowired
	private WidgetRepository widgetRepository;

	/** The you tube widget repository. */
	@Autowired
	private YouTubeWidgetRepository youTubeWidgetRepository;

	/**
	 * Truncate database.
	 */
	public void truncateDatabase() {
		answerRepository.deleteAll();
		enrollmentRepository.deleteAll();
		headingWidgetRepository.deleteAll();
		imageWidgetRepository.deleteAll();
		listWidgetRepository.deleteAll();
		multipleChoiceRepository.deleteAll();
		paragraphWidgetRepository.deleteAll();
		trueFalseRepository.deleteAll();
		questionRepository.deleteAll();
		quizWidgetRepository.deleteAll();
		youTubeWidgetRepository.deleteAll();
		widgetRepository.deleteAll();
		topicRepository.deleteAll();
		lessonRepository.deleteAll();
		moduleRepository.deleteAll();
		sectionRepository.deleteAll();
		courseRepository.deleteAll();
		facultyRepository.deleteAll();
		studentRepository.deleteAll();
		personRepository.deleteAll();

	}
}
