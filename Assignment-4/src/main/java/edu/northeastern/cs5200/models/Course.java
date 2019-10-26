package edu.northeastern.cs5200.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

/**
 * The Class Course.
 */
@Entity
public class Course {

	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	/** The label. */
	private String label;

	/** The faculty. */
	@ManyToOne
	private Faculty author;

	/**
	 * Instantiates a new course.
	 */
	public Course() {
		super();
	}

	/**
	 * Instantiates a new course.
	 *
	 * @param label  the label
	 * @param author the author
	 */
	public Course(String label, Faculty author) {
		super();
		this.label = label;
		this.author = author;
	}

	/** The modules. */
	@OneToMany(mappedBy = "course", fetch = FetchType.EAGER)
	private List<Module> modules;

	/** The sections. */
	@OneToMany(mappedBy = "course")
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Section> sections;

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Gets the faculty.
	 *
	 * @return the faculty
	 */
	public Faculty getAuthor() {
		return author;
	}

	/**
	 * Sets the faculty.
	 *
	 * @param author the new author
	 */
	public void setAuthor(Faculty author) {
		this.author = author;
		if (author.getAuthoredCourses() == null) {
			author.addAuthoredCourse(this);
		} else if (!author.getAuthoredCourses().contains(this)) {
			author.getAuthoredCourses().add(this);
		}
	}

	/**
	 * Gets the modules.
	 *
	 * @return the modules
	 */
	public List<Module> getModules() {
		return modules;
	}

	/**
	 * Sets the modules.
	 *
	 * @param modules the new modules
	 */
	public void setModules(List<Module> modules) {
		this.modules = modules;
	}

	/**
	 * Gets the label.
	 *
	 * @return the label
	 */
	public String getLabel() {
		return label;
	}

	/**
	 * Sets the label.
	 *
	 * @param label the new label
	 */
	public void setLabel(String label) {
		this.label = label;
	}

	/**
	 * Adds the module.
	 *
	 * @param module the module
	 */
	public void addModule(Module module) {
		if (modules == null)
			modules = new ArrayList<>();
		modules.add(module);
		if (module.getCourse() != this)
			module.setCourse(this);

	}

	/**
	 * Adds the section.
	 *
	 * @param section the section
	 */
	public void addSection(Section section) {
		if (sections == null)
			sections = new ArrayList<>();
		sections.add(section);
		if (section.getCourse() != this)
			section.setCourse(this);

	}

	/**
	 * Gets the sections.
	 *
	 * @return the sections
	 */
	public List<Section> getSections() {
		return sections;
	}

	/**
	 * Sets the sections.
	 *
	 * @param sections the new sections
	 */
	public void setSections(List<Section> sections) {
		this.sections = sections;
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result + id;
		result = prime * result + ((label == null) ? 0 : label.hashCode());
		result = prime * result + ((modules == null) ? 0 : modules.hashCode());
		result = prime * result + ((sections == null) ? 0 : sections.hashCode());
		return result;
	}

	/**
	 * Equals.
	 *
	 * @param obj the obj
	 * @return true, if successful
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Course other = (Course) obj;
		if (author == null) {
			if (other.author != null)
				return false;
		} else if (!author.equals(other.author))
			return false;
		if (id != other.id)
			return false;
		if (label == null) {
			if (other.label != null)
				return false;
		} else if (!label.equals(other.label))
			return false;
		if (modules == null) {
			if (other.modules != null)
				return false;
		} else if (!modules.equals(other.modules))
			return false;
		if (sections == null) {
			if (other.sections != null)
				return false;
		} else if (!sections.equals(other.sections))
			return false;
		return true;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "Course [id=" + id + ", label=" + label + ", faculty=" + author + ", modules=" + modules + ", sections="
				+ sections + "]";
	}

}
