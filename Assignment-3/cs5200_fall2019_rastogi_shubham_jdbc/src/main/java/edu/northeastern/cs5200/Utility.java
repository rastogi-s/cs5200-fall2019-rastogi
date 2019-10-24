package edu.northeastern.cs5200;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import edu.northeastern.cs5200.daos.DeveloperDao;
import edu.northeastern.cs5200.daos.PageDao;
import edu.northeastern.cs5200.daos.PersonDao;
import edu.northeastern.cs5200.daos.WebsiteDao;
import edu.northeastern.cs5200.models.Address;
import edu.northeastern.cs5200.models.Developer;
import edu.northeastern.cs5200.models.HeadingWidget;
import edu.northeastern.cs5200.models.HtmlWidget;
import edu.northeastern.cs5200.models.ImageWidget;
import edu.northeastern.cs5200.models.Page;
import edu.northeastern.cs5200.models.Person;
import edu.northeastern.cs5200.models.Phone;
import edu.northeastern.cs5200.models.User;
import edu.northeastern.cs5200.models.Website;
import edu.northeastern.cs5200.models.Widget;
import edu.northeastern.cs5200.models.WidgetType;
import edu.northeastern.cs5200.models.YouTubeWidget;

/**
 * The Class Utility.
 */
public class Utility {
	
	/** The connection. */
	private static Connection connection;

	/**
	 * Gets the collection of persons.
	 *
	 * @param res the res
	 * @return the collection of persons
	 */
	public static Collection<Person> getCollectionOfPersons(ResultSet res) {

		Collection<Person> persons = new ArrayList<>();
		try {
			while (res.next()) {
				Person newPerson;

				newPerson = new Person(res.getInt("id"), res.getString("first_name"), res.getString("last_name"),
						res.getString("username"), res.getString("password"), res.getString("email"),
						res.getDate("dob"));

				persons.add(newPerson);

			}

			return persons;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;

	}

	/**
	 * Gets the collection of developers.
	 *
	 * @param resultSet the result set
	 * @return the collection of developers
	 */
	public static Collection<Developer> getCollectionOfDevelopers(ResultSet resultSet) {
		Collection<Developer> developers = new ArrayList<>();
		try {
			while (resultSet.next()) {
				Developer newDeveloper;

				newDeveloper = new Developer(resultSet.getString("developer_key"), resultSet.getInt("id"),
						resultSet.getString("first_name"), resultSet.getString("last_name"),
						resultSet.getString("username"), resultSet.getString("password"), resultSet.getString("email"),
						resultSet.getDate("dob"));

				developers.add(newDeveloper);

			}

			return developers;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Gets the collection of users.
	 *
	 * @param resultSet the result set
	 * @return the collection of users
	 */
	public static Collection<User> getCollectionOfUsers(ResultSet resultSet) {
		Collection<User> users = new ArrayList<>();
		try {
			while (resultSet.next()) {
				User newUser;

				newUser = new User(resultSet.getInt("id"), resultSet.getString("first_name"),
						resultSet.getString("last_name"), resultSet.getString("username"),
						resultSet.getString("password"), resultSet.getString("email"), resultSet.getDate("dob"),
						resultSet.getBoolean("user_agreement"));

				users.add(newUser);

			}

			return users;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Gets the collection of websites.
	 *
	 * @param resultSet the result set
	 * @return the collection of websites
	 */
	public static Collection<Website> getCollectionOfWebsites(ResultSet resultSet) {
		Collection<Website> websites = new ArrayList<>();
		try {
			while (resultSet.next()) {
				Website website;

				website = new Website(resultSet.getInt("id"), resultSet.getString("name"),
						resultSet.getString("description"), resultSet.getDate("created"), resultSet.getDate("updated"),
						resultSet.getInt("visits"));
				if (resultSet.getInt("creator_id") > 0) {
					DeveloperDao dDao = DeveloperDao.getInstance();
					Developer creator = dDao.findDeveloperById(resultSet.getInt("creator_id"));
					website.setCreator(creator);
				}
				websites.add(website);

			}

			return websites;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Fetch role id.
	 *
	 * @param role the role
	 * @return the int
	 */
	public static int fetchRoleId(String role) {
		final String FIND_ROLE_ID = "SELECT `id` FROM `role` WHERE `name` = ? ";
		try {
			connection = edu.northeastern.cs5200.Connection.getConnection();
			PreparedStatement prepStatement = connection.prepareStatement(FIND_ROLE_ID);
			prepStatement.setString(1, role);
			ResultSet resultSet = prepStatement.executeQuery();
			return Utility.getRoleId(resultSet);

		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return -1;
	}

	/**
	 * Gets the role id.
	 *
	 * @param resultSet the result set
	 * @return the role id
	 */
	private static int getRoleId(ResultSet resultSet) {
		try {
			if (resultSet.next()) {
				return resultSet.getInt("id");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;
	}

	/**
	 * Gets the collection of pages.
	 *
	 * @param resultSet the result set
	 * @return the collection of pages
	 */
	public static Collection<Page> getCollectionOfPages(ResultSet resultSet) {
		Collection<Page> pages = new ArrayList<>();
		try {
			while (resultSet.next()) {
				Page page;

				page = new Page(resultSet.getInt("id"), resultSet.getString("title"),
						resultSet.getString("description"), resultSet.getDate("created"), resultSet.getDate("updated"),
						resultSet.getInt("views"));
				if (resultSet.getInt("wid") > 0) {
					WebsiteDao wDao = WebsiteDao.getInstance();
					Website website = wDao.findWebsiteById(resultSet.getInt("wid"));
					page.setWebsite(website);
				}
				pages.add(page);

			}

			return pages;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Gets the collection of widgets.
	 *
	 * @param resultSet the result set
	 * @return the collection of widgets
	 */
	public static Collection<Widget> getCollectionOfWidgets(ResultSet resultSet) {
		Collection<Widget> widgets = new ArrayList<>();
		try {
			while (resultSet.next()) {
				Widget widget;

				widget = getWidgetObject(resultSet);
				if (widget == null)
					continue;
				if (resultSet.getInt("page_id") > 0) {
					PageDao pDao = PageDao.getInstance();
					Page page = pDao.findPageById(resultSet.getInt("page_id"));
					widget.setPage(page);
				}

				widgets.add(widget);

			}

			return widgets;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Gets the widget object.
	 *
	 * @param resultSet the result set
	 * @return the widget object
	 * @throws SQLException the SQL exception
	 */
	private static Widget getWidgetObject(ResultSet resultSet) throws SQLException {
		String dtype = resultSet.getString("dtype");
		if (dtype != null && !dtype.isBlank()) {
			if (dtype.equals(WidgetType.HEADING.toString().toLowerCase())) {
				return new HeadingWidget(resultSet.getInt("id"), resultSet.getString("name"), resultSet.getInt("width"),
						resultSet.getInt("height"), resultSet.getString("css_class"), resultSet.getString("css_style"),
						resultSet.getString("text"), resultSet.getInt("order"), resultSet.getInt("heading_size"));
			} else if (dtype.equals(WidgetType.HTML.toString().toLowerCase())) {
				return new HtmlWidget(resultSet.getInt("id"), resultSet.getString("name"), resultSet.getInt("width"),
						resultSet.getInt("height"), resultSet.getString("css_class"), resultSet.getString("css_style"),
						resultSet.getString("text"), resultSet.getInt("order"), resultSet.getString("html"));
			} else if (dtype.equals(WidgetType.IMAGE.toString().toLowerCase())) {
				return new ImageWidget(resultSet.getInt("id"), resultSet.getString("name"), resultSet.getInt("width"),
						resultSet.getInt("height"), resultSet.getString("css_class"), resultSet.getString("css_style"),
						resultSet.getString("text"), resultSet.getInt("order"), resultSet.getString("image_src"));
			} else if (dtype.equals(WidgetType.YOUTUBE.toString().toLowerCase())) {
				return new YouTubeWidget(resultSet.getInt("id"), resultSet.getString("name"), resultSet.getInt("width"),
						resultSet.getInt("height"), resultSet.getString("css_class"), resultSet.getString("css_style"),
						resultSet.getString("text"), resultSet.getInt("order"), resultSet.getString("youtube_url"),
						resultSet.getBoolean("youtube_sharable"), resultSet.getBoolean("youtube_expandable"));
			}
		}
		return null;
	}

	/**
	 * Gets the collection of phone.
	 *
	 * @param resultSet the result set
	 * @return the collection of phone
	 */
	public static Collection<Phone> getCollectionOfPhone(ResultSet resultSet) {
		Collection<Phone> phones = new ArrayList<>();
		try {
			while (resultSet.next()) {
				Phone phone;

				phone = new Phone(resultSet.getInt("id"), resultSet.getString("phone"),
						resultSet.getBoolean("primary"));
				if (resultSet.getInt("pid") > 0) {
					PersonDao personDao = PersonDao.getInstance();
					Person person = personDao.findPersonById(resultSet.getInt("pid"));
					phone.setPerson(person);
				}
				phones.add(phone);

			}

			return phones;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Gets the collection of address.
	 *
	 * @param resultSet the result set
	 * @return the collection of address
	 */
	public static Collection<Address> getCollectionOfAddress(ResultSet resultSet) {
		Collection<Address> addresses = new ArrayList<>();
		try {
			while (resultSet.next()) {
				Address address;

				address = new Address(resultSet.getInt("id"), resultSet.getString("street1"),
						resultSet.getString("street2"), resultSet.getString("city"), resultSet.getString("state"),
						resultSet.getString("zip"), resultSet.getBoolean("primary"));
				if (resultSet.getInt("pid") > 0) {
					PersonDao personDao = PersonDao.getInstance();
					Person person = personDao.findPersonById(resultSet.getInt("pid"));
					address.setPerson(person);
				}
				addresses.add(address);

			}

			return addresses;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * Display user.
	 *
	 * @param s the user
	 */
	public static void displayUser(User s) {
		System.out.println(s);
	}
	
	/**
	 * Display developer.
	 *
	 * @param d the developer
	 */
	public static void displayDeveloper(Developer d) {
		System.out.println(d);
	}


}
