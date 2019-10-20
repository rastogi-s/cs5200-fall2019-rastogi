package edu.northeastern.cs5200;

import java.sql.Date;

import edu.northeastern.cs5200.daos.AddressDao;
import edu.northeastern.cs5200.daos.DeveloperDao;
import edu.northeastern.cs5200.daos.PageDao;
import edu.northeastern.cs5200.daos.PhoneDao;
import edu.northeastern.cs5200.daos.PriviledgeDao;
import edu.northeastern.cs5200.daos.RoleDao;
import edu.northeastern.cs5200.daos.UserDao;
import edu.northeastern.cs5200.daos.WebsiteDao;
import edu.northeastern.cs5200.daos.WidgetDao;
import edu.northeastern.cs5200.models.Address;
import edu.northeastern.cs5200.models.Developer;
import edu.northeastern.cs5200.models.HeadingWidget;
import edu.northeastern.cs5200.models.HtmlWidget;
import edu.northeastern.cs5200.models.ImageWidget;
import edu.northeastern.cs5200.models.Page;
import edu.northeastern.cs5200.models.Phone;
import edu.northeastern.cs5200.models.Priviledge;
import edu.northeastern.cs5200.models.Role;
import edu.northeastern.cs5200.models.User;
import edu.northeastern.cs5200.models.Website;
import edu.northeastern.cs5200.models.Widget;
import edu.northeastern.cs5200.models.YouTubeWidget;

public class hw_jdbc_rastogi_shubham {

	private static DeveloperDao developerDAO = DeveloperDao.getInstance();
	private static UserDao userDAO = UserDao.getInstance();
	private static WebsiteDao websiteDAO = WebsiteDao.getInstance();
	private static PageDao pageDAO = PageDao.getInstance();
	private static RoleDao roleDAO = RoleDao.getInstance();
	private static PriviledgeDao priviledgeDAO = PriviledgeDao.getInstance();
	private static WidgetDao widgetDAO = WidgetDao.getInstance();
	private static PhoneDao phoneDAO = PhoneDao.getInstance();
	private static AddressDao addressDAO = AddressDao.getInstance();

	/**
	 * Create the following developers and users. Insert into the correct tables
	 * depending on the type
	 * 
	 */

	/**
	 * Create the following web sites for the developers above. For both the created
	 * field and updated field, use the date your assignment will be graded, e.g.,
	 * do not hardcode it
	 */

	/**
	 * Create the following pages for the web sites above. Use the semester's start
	 * date for the created field. Use the assignment's due date for the updated
	 * field.
	 * 
	 */

	/**
	 * Create the following widgets for the pages shown.
	 * 
	 */

	public static void main(String[] args) {
		Developer alice = new Developer("4321rewq", 12, "Alice", "Wonder", "alice", "alice", "alice@wonder.com", null);
		Developer bob = new Developer("5432trew", 23, "Bob", "Marley", "bob", "bob", "bob@marley.com", null);
		Developer charlie = new Developer("4321rewq", 34, "Charles", "Garcia", "charlie", "charlie", "chuch@garcia.com",
				null);
		developerDAO.createDeveloper(alice);
		developerDAO.createDeveloper(bob);
		developerDAO.createDeveloper(charlie);
		System.out.println(developerDAO.findAllDevelopers());
		System.out.println(developerDAO.findDeveloperById(12));
		System.out.println(developerDAO.findDeveloperByCredentials("bob", "bob"));
		System.out.println(developerDAO.findDeveloperByUsername("charlie"));

		User dan = new User(45, "Dan", "Martin", "dan", "dan", "dan@martin.com", null);
		User ed = new User(56, "Ed", "Karaz", "ed", "ed", "ed@kar.com", null);
		userDAO.createUser(dan);
		userDAO.createUser(ed);
		System.out.println(userDAO.findAllUsers());
		System.out.println(userDAO.findUserById(45));
		System.out.println(userDAO.findUserByCredentials("ed", "ed"));
		System.out.println(userDAO.findUserByUsername("dan"));

		Date curr = new Date(System.currentTimeMillis());
		Website facebook = new Website(123, "Facebook", "an online social media and social networking service", curr,
				curr, 1234234);
		Website twitter = new Website(234, "Twitter", "an online news and social networking service", curr, curr,
				4321543);
		Website wikipedia = new Website(345, "Wikipedia", "a free online encyclopedia", curr, curr, 3456654);
		Website cnn = new Website(456, "CNN", "an American basic cable and satellite television news channel", curr,
				curr, 6543345);
		Website cnet = new Website(567, "CNET",
				"an American media website that publishes reviews, news, articles, blogs, podcasts and videos on technology and consumer electronics",
				curr, curr, 5433455);
		Website gizmodo = new Website(678, "Gizmodo",
				"a design, technology, science and science fiction website that also writes articles on politics", curr,
				curr, 4322345);
		/** facebook */
		websiteDAO.createWebsiteForDeveloper(alice.getId(), facebook);
		roleDAO.assignWebsiteRole(alice.getId(), facebook.getId(),
				Utility.fetchRoleId(Role.OWNER.toString().toLowerCase()));
		priviledgeDAO.assignWebsitePriviledge(alice.getId(), facebook.getId(),
				Priviledge.CREATE.toString().toLowerCase());
		priviledgeDAO.assignWebsitePriviledge(alice.getId(), facebook.getId(),
				Priviledge.UPDATE.toString().toLowerCase());
		priviledgeDAO.assignWebsitePriviledge(alice.getId(), facebook.getId(),
				Priviledge.DELETE.toString().toLowerCase());
		priviledgeDAO.assignWebsitePriviledge(alice.getId(), facebook.getId(),
				Priviledge.READ.toString().toLowerCase());

		roleDAO.assignWebsiteRole(bob.getId(), facebook.getId(),
				Utility.fetchRoleId(Role.EDITOR.toString().toLowerCase()));
		priviledgeDAO.assignWebsitePriviledge(bob.getId(), facebook.getId(),
				Priviledge.UPDATE.toString().toLowerCase());
		priviledgeDAO.assignWebsitePriviledge(bob.getId(), facebook.getId(), Priviledge.READ.toString().toLowerCase());

		roleDAO.assignWebsiteRole(charlie.getId(), facebook.getId(),
				Utility.fetchRoleId(Role.ADMIN.toString().toLowerCase()));
		priviledgeDAO.assignWebsitePriviledge(charlie.getId(), facebook.getId(),
				Priviledge.CREATE.toString().toLowerCase());
		priviledgeDAO.assignWebsitePriviledge(charlie.getId(), facebook.getId(),
				Priviledge.UPDATE.toString().toLowerCase());
		priviledgeDAO.assignWebsitePriviledge(charlie.getId(), facebook.getId(),
				Priviledge.DELETE.toString().toLowerCase());
		priviledgeDAO.assignWebsitePriviledge(charlie.getId(), facebook.getId(),
				Priviledge.READ.toString().toLowerCase());

		/** twitter */
		websiteDAO.createWebsiteForDeveloper(bob.getId(), twitter);
		roleDAO.assignWebsiteRole(bob.getId(), twitter.getId(),
				Utility.fetchRoleId(Role.OWNER.toString().toLowerCase()));
		priviledgeDAO.assignWebsitePriviledge(bob.getId(), twitter.getId(), Priviledge.CREATE.toString().toLowerCase());
		priviledgeDAO.assignWebsitePriviledge(bob.getId(), twitter.getId(), Priviledge.UPDATE.toString().toLowerCase());
		priviledgeDAO.assignWebsitePriviledge(bob.getId(), twitter.getId(), Priviledge.DELETE.toString().toLowerCase());
		priviledgeDAO.assignWebsitePriviledge(bob.getId(), twitter.getId(), Priviledge.READ.toString().toLowerCase());

		roleDAO.assignWebsiteRole(charlie.getId(), twitter.getId(),
				Utility.fetchRoleId(Role.EDITOR.toString().toLowerCase()));
		priviledgeDAO.assignWebsitePriviledge(charlie.getId(), twitter.getId(),
				Priviledge.UPDATE.toString().toLowerCase());
		priviledgeDAO.assignWebsitePriviledge(charlie.getId(), twitter.getId(),
				Priviledge.READ.toString().toLowerCase());

		roleDAO.assignWebsiteRole(alice.getId(), twitter.getId(),
				Utility.fetchRoleId(Role.ADMIN.toString().toLowerCase()));
		priviledgeDAO.assignWebsitePriviledge(alice.getId(), twitter.getId(),
				Priviledge.CREATE.toString().toLowerCase());
		priviledgeDAO.assignWebsitePriviledge(alice.getId(), twitter.getId(),
				Priviledge.UPDATE.toString().toLowerCase());
		priviledgeDAO.assignWebsitePriviledge(alice.getId(), twitter.getId(),
				Priviledge.DELETE.toString().toLowerCase());
		priviledgeDAO.assignWebsitePriviledge(alice.getId(), twitter.getId(), Priviledge.READ.toString().toLowerCase());

		/** wikipedia */
		websiteDAO.createWebsiteForDeveloper(charlie.getId(), wikipedia);
		roleDAO.assignWebsiteRole(charlie.getId(), wikipedia.getId(),
				Utility.fetchRoleId(Role.OWNER.toString().toLowerCase()));
		priviledgeDAO.assignWebsitePriviledge(charlie.getId(), wikipedia.getId(),
				Priviledge.CREATE.toString().toLowerCase());
		priviledgeDAO.assignWebsitePriviledge(charlie.getId(), wikipedia.getId(),
				Priviledge.UPDATE.toString().toLowerCase());
		priviledgeDAO.assignWebsitePriviledge(charlie.getId(), wikipedia.getId(),
				Priviledge.DELETE.toString().toLowerCase());
		priviledgeDAO.assignWebsitePriviledge(charlie.getId(), wikipedia.getId(),
				Priviledge.READ.toString().toLowerCase());

		roleDAO.assignWebsiteRole(alice.getId(), wikipedia.getId(),
				Utility.fetchRoleId(Role.EDITOR.toString().toLowerCase()));
		priviledgeDAO.assignWebsitePriviledge(alice.getId(), wikipedia.getId(),
				Priviledge.UPDATE.toString().toLowerCase());
		priviledgeDAO.assignWebsitePriviledge(alice.getId(), wikipedia.getId(),
				Priviledge.READ.toString().toLowerCase());

		roleDAO.assignWebsiteRole(bob.getId(), wikipedia.getId(),
				Utility.fetchRoleId(Role.ADMIN.toString().toLowerCase()));
		priviledgeDAO.assignWebsitePriviledge(bob.getId(), wikipedia.getId(),
				Priviledge.CREATE.toString().toLowerCase());
		priviledgeDAO.assignWebsitePriviledge(bob.getId(), wikipedia.getId(),
				Priviledge.UPDATE.toString().toLowerCase());
		priviledgeDAO.assignWebsitePriviledge(bob.getId(), wikipedia.getId(),
				Priviledge.DELETE.toString().toLowerCase());
		priviledgeDAO.assignWebsitePriviledge(bob.getId(), wikipedia.getId(), Priviledge.READ.toString().toLowerCase());

		/** cnn */
		websiteDAO.createWebsiteForDeveloper(alice.getId(), cnn);
		roleDAO.assignWebsiteRole(alice.getId(), cnn.getId(), Utility.fetchRoleId(Role.OWNER.toString().toLowerCase()));
		priviledgeDAO.assignWebsitePriviledge(alice.getId(), cnn.getId(), Priviledge.CREATE.toString().toLowerCase());
		priviledgeDAO.assignWebsitePriviledge(alice.getId(), cnn.getId(), Priviledge.UPDATE.toString().toLowerCase());
		priviledgeDAO.assignWebsitePriviledge(alice.getId(), cnn.getId(), Priviledge.DELETE.toString().toLowerCase());
		priviledgeDAO.assignWebsitePriviledge(alice.getId(), cnn.getId(), Priviledge.READ.toString().toLowerCase());

		roleDAO.assignWebsiteRole(bob.getId(), cnn.getId(), Utility.fetchRoleId(Role.EDITOR.toString().toLowerCase()));
		priviledgeDAO.assignWebsitePriviledge(bob.getId(), cnn.getId(), Priviledge.UPDATE.toString().toLowerCase());
		priviledgeDAO.assignWebsitePriviledge(bob.getId(), cnn.getId(), Priviledge.READ.toString().toLowerCase());

		roleDAO.assignWebsiteRole(charlie.getId(), cnn.getId(),
				Utility.fetchRoleId(Role.ADMIN.toString().toLowerCase()));
		priviledgeDAO.assignWebsitePriviledge(charlie.getId(), cnn.getId(), Priviledge.CREATE.toString().toLowerCase());
		priviledgeDAO.assignWebsitePriviledge(charlie.getId(), cnn.getId(), Priviledge.UPDATE.toString().toLowerCase());
		priviledgeDAO.assignWebsitePriviledge(charlie.getId(), cnn.getId(), Priviledge.DELETE.toString().toLowerCase());
		priviledgeDAO.assignWebsitePriviledge(charlie.getId(), cnn.getId(), Priviledge.READ.toString().toLowerCase());

		/** cnet */

		websiteDAO.createWebsiteForDeveloper(bob.getId(), cnet);
		roleDAO.assignWebsiteRole(bob.getId(), cnet.getId(), Utility.fetchRoleId(Role.OWNER.toString().toLowerCase()));
		priviledgeDAO.assignWebsitePriviledge(bob.getId(), cnet.getId(), Priviledge.CREATE.toString().toLowerCase());
		priviledgeDAO.assignWebsitePriviledge(bob.getId(), cnet.getId(), Priviledge.UPDATE.toString().toLowerCase());
		priviledgeDAO.assignWebsitePriviledge(bob.getId(), cnet.getId(), Priviledge.DELETE.toString().toLowerCase());
		priviledgeDAO.assignWebsitePriviledge(bob.getId(), cnet.getId(), Priviledge.READ.toString().toLowerCase());

		roleDAO.assignWebsiteRole(charlie.getId(), cnet.getId(),
				Utility.fetchRoleId(Role.EDITOR.toString().toLowerCase()));
		priviledgeDAO.assignWebsitePriviledge(charlie.getId(), cnet.getId(),
				Priviledge.UPDATE.toString().toLowerCase());
		priviledgeDAO.assignWebsitePriviledge(charlie.getId(), cnet.getId(), Priviledge.READ.toString().toLowerCase());

		roleDAO.assignWebsiteRole(alice.getId(), cnet.getId(),
				Utility.fetchRoleId(Role.ADMIN.toString().toLowerCase()));
		priviledgeDAO.assignWebsitePriviledge(alice.getId(), cnet.getId(), Priviledge.CREATE.toString().toLowerCase());
		priviledgeDAO.assignWebsitePriviledge(alice.getId(), cnet.getId(), Priviledge.UPDATE.toString().toLowerCase());
		priviledgeDAO.assignWebsitePriviledge(alice.getId(), cnet.getId(), Priviledge.DELETE.toString().toLowerCase());
		priviledgeDAO.assignWebsitePriviledge(alice.getId(), cnet.getId(), Priviledge.READ.toString().toLowerCase());

		/** gizmodo */

		websiteDAO.createWebsiteForDeveloper(charlie.getId(), gizmodo);
		roleDAO.assignWebsiteRole(charlie.getId(), cnet.getId(),
				Utility.fetchRoleId(Role.OWNER.toString().toLowerCase()));
		priviledgeDAO.assignWebsitePriviledge(charlie.getId(), gizmodo.getId(),
				Priviledge.CREATE.toString().toLowerCase());
		priviledgeDAO.assignWebsitePriviledge(charlie.getId(), gizmodo.getId(),
				Priviledge.UPDATE.toString().toLowerCase());
		priviledgeDAO.assignWebsitePriviledge(charlie.getId(), gizmodo.getId(),
				Priviledge.DELETE.toString().toLowerCase());
		priviledgeDAO.assignWebsitePriviledge(charlie.getId(), gizmodo.getId(),
				Priviledge.READ.toString().toLowerCase());

		roleDAO.assignWebsiteRole(alice.getId(), gizmodo.getId(),
				Utility.fetchRoleId(Role.EDITOR.toString().toLowerCase()));
		priviledgeDAO.assignWebsitePriviledge(alice.getId(), gizmodo.getId(),
				Priviledge.UPDATE.toString().toLowerCase());
		priviledgeDAO.assignWebsitePriviledge(alice.getId(), gizmodo.getId(), Priviledge.READ.toString().toLowerCase());

		roleDAO.assignWebsiteRole(bob.getId(), gizmodo.getId(),
				Utility.fetchRoleId(Role.ADMIN.toString().toLowerCase()));
		priviledgeDAO.assignWebsitePriviledge(bob.getId(), gizmodo.getId(), Priviledge.CREATE.toString().toLowerCase());
		priviledgeDAO.assignWebsitePriviledge(bob.getId(), gizmodo.getId(), Priviledge.UPDATE.toString().toLowerCase());
		priviledgeDAO.assignWebsitePriviledge(bob.getId(), gizmodo.getId(), Priviledge.DELETE.toString().toLowerCase());
		priviledgeDAO.assignWebsitePriviledge(bob.getId(), gizmodo.getId(), Priviledge.READ.toString().toLowerCase());

		Date created = Date.valueOf("2019-09-04");
		Date updated = Date.valueOf("2019-10-20");

		Page home = new Page(123, "Home", "Landing page", created, updated, 123434);
		Page about = new Page(234, "About", "Website description", created, updated, 234545);
		Page contact = new Page(345, "Contact", "Addresses, phones, and contact info", created, updated, 345656);
		Page preferences = new Page(456, "Preferences", "Where users can configure their preferences", created, updated,
				456776);
		Page profile = new Page(567, "Profile", "Users can configure their personal information", created, updated,
				567878);

		/** CNET home page */
		pageDAO.createPageForWebsite(cnet.getId(), home);
		roleDAO.assignPageRole(alice.getId(), home.getId(), Utility.fetchRoleId(Role.EDITOR.toString().toLowerCase())); // Editor
		priviledgeDAO.assignPagePriviledge(alice.getId(), home.getId(), Priviledge.READ.toString().toLowerCase()); // read
		priviledgeDAO.assignPagePriviledge(alice.getId(), home.getId(), Priviledge.UPDATE.toString().toLowerCase()); // update

		roleDAO.assignPageRole(bob.getId(), home.getId(), Utility.fetchRoleId(Role.REVIEWER.toString().toLowerCase())); // Reviewer
		priviledgeDAO.assignPagePriviledge(bob.getId(), home.getId(), Priviledge.READ.toString().toLowerCase()); // read

		roleDAO.assignPageRole(charlie.getId(), home.getId(),
				Utility.fetchRoleId(Role.WRITER.toString().toLowerCase())); // Writer
		priviledgeDAO.assignPagePriviledge(charlie.getId(), home.getId(), Priviledge.READ.toString().toLowerCase()); // read
		priviledgeDAO.assignPagePriviledge(charlie.getId(), home.getId(), Priviledge.UPDATE.toString().toLowerCase()); // update
		priviledgeDAO.assignPagePriviledge(charlie.getId(), home.getId(), Priviledge.CREATE.toString().toLowerCase()); // create

		/** Gizmodo about page */
		pageDAO.createPageForWebsite(gizmodo.getId(), about);
		roleDAO.assignPageRole(bob.getId(), about.getId(), Utility.fetchRoleId(Role.EDITOR.toString().toLowerCase())); // Editor
		priviledgeDAO.assignPagePriviledge(bob.getId(), about.getId(), Priviledge.READ.toString().toLowerCase()); // read
		priviledgeDAO.assignPagePriviledge(bob.getId(), about.getId(), Priviledge.UPDATE.toString().toLowerCase()); // update

		roleDAO.assignPageRole(charlie.getId(), about.getId(),
				Utility.fetchRoleId(Role.REVIEWER.toString().toLowerCase())); // Reviewer
		priviledgeDAO.assignPagePriviledge(charlie.getId(), about.getId(), Priviledge.READ.toString().toLowerCase()); // read

		roleDAO.assignPageRole(alice.getId(), about.getId(), Utility.fetchRoleId(Role.WRITER.toString().toLowerCase())); // Writer
		priviledgeDAO.assignPagePriviledge(alice.getId(), about.getId(), Priviledge.READ.toString().toLowerCase()); // read
		priviledgeDAO.assignPagePriviledge(alice.getId(), about.getId(), Priviledge.UPDATE.toString().toLowerCase()); // update
		priviledgeDAO.assignPagePriviledge(alice.getId(), about.getId(), Priviledge.CREATE.toString().toLowerCase()); // create

		/** Wikipedia contact page */
		pageDAO.createPageForWebsite(wikipedia.getId(), contact);
		roleDAO.assignPageRole(charlie.getId(), contact.getId(),
				Utility.fetchRoleId(Role.EDITOR.toString().toLowerCase())); // Editor
		priviledgeDAO.assignPagePriviledge(charlie.getId(), contact.getId(), Priviledge.READ.toString().toLowerCase()); // read
		priviledgeDAO.assignPagePriviledge(charlie.getId(), contact.getId(),
				Priviledge.UPDATE.toString().toLowerCase()); // update

		roleDAO.assignPageRole(alice.getId(), contact.getId(),
				Utility.fetchRoleId(Role.REVIEWER.toString().toLowerCase())); // Reviewer
		priviledgeDAO.assignPagePriviledge(alice.getId(), contact.getId(), Priviledge.READ.toString().toLowerCase()); // read

		roleDAO.assignPageRole(bob.getId(), contact.getId(), Utility.fetchRoleId(Role.WRITER.toString().toLowerCase())); // Writer
		priviledgeDAO.assignPagePriviledge(bob.getId(), contact.getId(), Priviledge.READ.toString().toLowerCase()); // read
		priviledgeDAO.assignPagePriviledge(bob.getId(), contact.getId(), Priviledge.UPDATE.toString().toLowerCase()); // update
		priviledgeDAO.assignPagePriviledge(bob.getId(), contact.getId(), Priviledge.CREATE.toString().toLowerCase()); // create

		/** CNN preferences page */
		pageDAO.createPageForWebsite(cnn.getId(), preferences);
		roleDAO.assignPageRole(alice.getId(), preferences.getId(),
				Utility.fetchRoleId(Role.EDITOR.toString().toLowerCase())); // Editor
		priviledgeDAO.assignPagePriviledge(alice.getId(), preferences.getId(),
				Priviledge.READ.toString().toLowerCase()); // read
		priviledgeDAO.assignPagePriviledge(alice.getId(), preferences.getId(),
				Priviledge.UPDATE.toString().toLowerCase()); // update

		roleDAO.assignPageRole(bob.getId(), preferences.getId(),
				Utility.fetchRoleId(Role.REVIEWER.toString().toLowerCase())); // Reviewer
		priviledgeDAO.assignPagePriviledge(bob.getId(), preferences.getId(), Priviledge.READ.toString().toLowerCase()); // read

		roleDAO.assignPageRole(charlie.getId(), preferences.getId(),
				Utility.fetchRoleId(Role.WRITER.toString().toLowerCase())); // Writer
		priviledgeDAO.assignPagePriviledge(charlie.getId(), preferences.getId(),
				Priviledge.READ.toString().toLowerCase()); // read
		priviledgeDAO.assignPagePriviledge(charlie.getId(), preferences.getId(),
				Priviledge.UPDATE.toString().toLowerCase()); // update
		priviledgeDAO.assignPagePriviledge(charlie.getId(), preferences.getId(),
				Priviledge.CREATE.toString().toLowerCase()); // create

		/** CNET profile page */
		pageDAO.createPageForWebsite(cnet.getId(), profile);
		roleDAO.assignPageRole(bob.getId(), profile.getId(), Utility.fetchRoleId(Role.EDITOR.toString().toLowerCase())); // Editor
		priviledgeDAO.assignPagePriviledge(bob.getId(), profile.getId(), Priviledge.READ.toString().toLowerCase()); // read
		priviledgeDAO.assignPagePriviledge(bob.getId(), profile.getId(), Priviledge.UPDATE.toString().toLowerCase()); // update

		roleDAO.assignPageRole(charlie.getId(), profile.getId(),
				Utility.fetchRoleId(Role.REVIEWER.toString().toLowerCase())); // Reviewer
		priviledgeDAO.assignPagePriviledge(charlie.getId(), profile.getId(), Priviledge.READ.toString().toLowerCase()); // read

		roleDAO.assignPageRole(alice.getId(), profile.getId(),
				Utility.fetchRoleId(Role.WRITER.toString().toLowerCase())); // Writer
		priviledgeDAO.assignPagePriviledge(alice.getId(), profile.getId(), Priviledge.READ.toString().toLowerCase()); // read
		priviledgeDAO.assignPagePriviledge(alice.getId(), profile.getId(), Priviledge.UPDATE.toString().toLowerCase()); // update
		priviledgeDAO.assignPagePriviledge(alice.getId(), profile.getId(), Priviledge.CREATE.toString().toLowerCase()); // create

		/** widgets */
		Widget head123 = new HeadingWidget(1, "head123", 0, 0, null, null, "Welcome", 0, 0);
		Widget post234 = new HtmlWidget(2, "post234", 0, 0, null, null, "<p>Lorem</p>", 0, null);
		Widget head345 = new HeadingWidget(3, "head345", 0, 0, null, null, "Hi", 1, 0);
		Widget intro456 = new HtmlWidget(4, "intro456", 0, 0, null, null, "<h1>Hi</h1>", 2, null);
		Widget image345 = new ImageWidget(5, "image345", 50, 100, null, null, null, 3, "/img/567.png");
		Widget video456 = new YouTubeWidget(6, "video456", 400, 300, null, null, null, 0,
				"https://youtu.be/h67VX51QXiQ", false, false);

		widgetDAO.createWidgetForPage(home.getId(), head123);
		widgetDAO.createWidgetForPage(about.getId(), post234);
		widgetDAO.createWidgetForPage(contact.getId(), head345);
		widgetDAO.createWidgetForPage(contact.getId(), intro456);
		widgetDAO.createWidgetForPage(contact.getId(), image345);
		widgetDAO.createWidgetForPage(preferences.getId(), video456);

		/** Add phone records */

		Phone alicePhonePrimary = new Phone("123-234-3456", true);
		Phone alicePhone = new Phone("234-345-4566", false);

		Phone bobPhonePrimary = new Phone("345-456-5677", true);

		Phone charliePhonePrimary = new Phone("321-432-5435", true);
		Phone charliePhone1 = new Phone("432-432-5433", false);
		Phone charliePhone2 = new Phone("543-543-6544", false);

		phoneDAO.addPhoneToPerson(alicePhonePrimary, alice.getId());
		phoneDAO.addPhoneToPerson(alicePhone, alice.getId());
		phoneDAO.addPhoneToPerson(bobPhonePrimary, bob.getId());
		phoneDAO.addPhoneToPerson(charliePhonePrimary, charlie.getId());
		phoneDAO.addPhoneToPerson(charliePhone1, charlie.getId());
		phoneDAO.addPhoneToPerson(charliePhone2, charlie.getId());

		/** Add address records */

		Address aliceAddressPrimary = new Address("123 Adam St.", null, "Alton", null, "01234", true);
		Address aliceAddress = new Address("234 Birch St.", null, "Boston", null, "02345", false);

		Address bobAddressPrimary = new Address("345 Charles St.", null, "Chelms", null, "03455", true);
		Address bobAddress1 = new Address("456 Down St.", null, "Dalton", null, "04566", false);
		Address bobAddress2 = new Address("543 East St.", null, "Everett", null, "01112", false);

		Address charlieAddressPrimary = new Address("654 Frank St.", null, "Foulton", null, "04322", true);

		addressDAO.addAddressToPerson(aliceAddressPrimary, alice.getId());
		addressDAO.addAddressToPerson(aliceAddress, alice.getId());
		addressDAO.addAddressToPerson(bobAddressPrimary, bob.getId());
		addressDAO.addAddressToPerson(bobAddress1, bob.getId());
		addressDAO.addAddressToPerson(bobAddress2, bob.getId());
		addressDAO.addAddressToPerson(charlieAddressPrimary, charlie.getId());

		/** Implement Updates */

		// 1. Update developer - Update Charlie's primary phone number to 333-444-5555

		phoneDAO.updatePrimaryPhone(charlie.getId(), new Phone("333-444-5555", true));

		// 2. Update widget - Update the relative order of widget head345 on the page so
		// that it's new order is 3. Note that the other widget's order needs to update
		// as well
		
		

		// 3. Update page - Append 'CNET - ' to the beginning of all CNET's page titles
		for (Page page : pageDAO.findPagesForWebsite(cnet.getId())) {
			page.setTitle("CNET" + page.getTitle());
			pageDAO.updatePage(page.getId(), page);
		}

		// 4. Update roles - Swap Charlie's and Bob's role in CNET's Home page
		int charlieRoleId = -1,bobRoleId=-1,pId = -1;
		for(Page page:pageDAO.findPagesForWebsite(cnet.getId())) {
			if(page.getTitle().toLowerCase().contains("home")) {
				pId = page.getId();
				charlieRoleId = roleDAO.findPageRoleIdWebsiteDeveloper(pId,charlie.getId());
				bobRoleId = roleDAO.findPageRoleIdWebsiteDeveloper(pId,bob.getId());
				
				System.out.println(charlieRoleId + "," +bobRoleId +","+pId );
			}
			
		}
		
		roleDAO.swapRoles(charlie.getId(), charlieRoleId, bob.getId(), bobRoleId, pId);

		/** Implement Deletes */

		// 1. Delete developer - Delete Alice's primary address
		for (Address address : addressDAO.findAllAddresssForPerson(alice.getId())) {
			if (address.isPrimary())
				addressDAO.deleteAddress(address.getId());
		}

		// 2. Delete widget - Remove the last widget in the Contact page.
		// The last widget is the one with the highest value in the order field
		int highest = Integer.MIN_VALUE, widgetId = -1;
		for (Widget widget : widgetDAO.findWidgetsForPage(contact.getId())) {
			if (widget.getOrder() > highest) {
				widgetId = widget.getId();
				highest = widget.getOrder();
			}
		}

		widgetDAO.deleteWidget(widgetId);

		// 3. Delete page - Remove the last updated page in Wikipedia
		int pageId = -1;
		Date date = new Date(0);

		for (Page page : pageDAO.findPagesForWebsite(wikipedia.getId())) {
			if (date.compareTo(page.getUpdated()) < 0) {
				System.out.println(date.compareTo(page.getUpdated()));
				date = page.getUpdated();
				pageId = page.getId();
			}
		}
		
		for(Widget widget:widgetDAO.findWidgetsForPage(pageId)) {
			widgetDAO.deleteWidget(widget.getId());
		}

		priviledgeDAO.deletePagePriviledgeForPage(pageId);
		roleDAO.deletePageRoleForPage(pageId);
		pageDAO.deletePage(pageId);

		// 4. Delete website - Remove the CNET web site, as well as all related
		// roles and privileges relating developers to the Website and Pages

		for (Page page : pageDAO.findPagesForWebsite(cnet.getId())) {
			for(Widget widget:widgetDAO.findWidgetsForPage(page.getId())) {
				widgetDAO.deleteWidget(widget.getId());
			}
			priviledgeDAO.deletePagePriviledgeForPage(page.getId());
			roleDAO.deletePageRoleForPage(page.getId());
			pageDAO.deletePage(page.getId());
		}
		
		priviledgeDAO.deleteWebsitePriviledgeForWebiste(cnet.getId());
		roleDAO.deleteWebisteRoleForWebsite(cnet.getId());
		websiteDAO.deleteWebsite(cnet.getId());
	}

}
