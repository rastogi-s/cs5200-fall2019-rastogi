package edu.northeastern.cs5200.daos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

import edu.northeastern.cs5200.Utility;
import edu.northeastern.cs5200.models.HeadingWidget;
import edu.northeastern.cs5200.models.HtmlWidget;
import edu.northeastern.cs5200.models.ImageWidget;
import edu.northeastern.cs5200.models.Widget;
import edu.northeastern.cs5200.models.WidgetType;
import edu.northeastern.cs5200.models.YouTubeWidget;

/**
 * The Class WidgetDao.
 */
public class WidgetDao implements WidgetImpl {

	/** The instance. */
	private static WidgetDao instance;
	
	/** The connection. */
	private Connection connection;
	
	/** The result set. */
	private ResultSet resultSet;

/** The create heading widget. */
	private final String CREATE_HEADING_WIDGET = "INSERT INTO `widget`(`id`,`name`,`width`,`height`,`css_class`,`css_style`,`text`,`order`,`heading_size`, `dtype`,`page_id`) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
	
	/** The create html widget. */
	private final String CREATE_HTML_WIDGET = "INSERT INTO `widget`(`id`,`name`,`width`,`height`,`css_class`,`css_style`,`text`,`order`, `html`,`dtype`,`page_id`) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
	
	/** The create image widget. */
	private final String CREATE_IMAGE_WIDGET = "INSERT INTO `widget`(`id`,`name`,`width`,`height`,`css_class`,`css_style`,`text`,`order`,`image_src`,`dtype`,`page_id`) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
	
	/** The create youtube widget. */
	private final String CREATE_YOUTUBE_WIDGET = "INSERT INTO `widget`(`id`,`name`,`width`,`height`,`css_class`,`css_style`,`text`,`order`,`youtube_url`, `youtube_sharable`,`youtube_expandable`,`dtype`,`page_id`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
	
	/** The find all widgets. */
	private final String FIND_ALL_WIDGETS = "SELECT *  FROM `widget`";
	
	/** The find widgets for page. */
	private final String FIND_WIDGETS_FOR_PAGE = "SELECT *  FROM `widget` WHERE `page_id` = ?";
	
	/** The find widget by id. */
	private final String FIND_WIDGET_BY_ID = "SELECT *  FROM `widget` WHERE `id` = ?";
	
	/** The delete widget. */
	private final String DELETE_WIDGET = "DELETE FROM `widget` WHERE `id` = ?";
	
	/** The update heading widget. */
	private final String UPDATE_HEADING_WIDGET = "UPDATE  `widget` SET  `name` = ?,`width` = ?,`height` = ?,`css_class` = ?,`css_style`= ?,`text` = ?,`order` =?,`heading_size` =?, `dtype` =?,`page_id` =? WHERE `id`= ?";
	
	/** The update html widget. */
	private final String UPDATE_HTML_WIDGET = "UPDATE  `widget` SET `name` = ?,`width` = ?,`height` = ?,`css_class` = ?,`css_style`= ?,`text` = ?,`order` =?, `html` =?,`dtype` =?,`page_id` =? WHERE `id`= ?";
	
	/** The update image widget. */
	private final String UPDATE_IMAGE_WIDGET = "UPDATE  `widget`SET  `name` = ?,`width` = ?,`height` = ?,`css_class` = ?,`css_style`= ?,`text` = ?,`order` =?, `image_src` =?,`dtype` =?,`page_id` =? WHERE `id`= ?";
	
	/** The update youtube widget. */
	private final String UPDATE_YOUTUBE_WIDGET = "UPDATE  SET `name` = ?,`width` = ?,`height` = ?,`css_class` = ?,`css_style`= ?,`text` = ?,`order` =?, `youtube_url` =?, `youtube_sharable` = ?,`youtube_expandable` =?,`dtype` = ?,`page_id` =? WHERE `id`= ?";

	/**
	 * Instantiates a new widget dao.
	 */
	private WidgetDao() {
	}

	/**
	 * Gets the single instance of WidgetDao.
	 *
	 * @return single instance of WidgetDao
	 */
	public static WidgetDao getInstance() {
		if (instance == null)
			instance = new WidgetDao();
		return instance;
	}

	/**
	 * Creates the widget for page.
	 *
	 * @param pageId the page id
	 * @param widget the widget
	 */
	@Override
	public void createWidgetForPage(int pageId, Widget widget) {
		try {
			PreparedStatement prepStatement = addParamsToPreparedStatement(widget, pageId, true);
			if (prepStatement != null) {
				prepStatement.execute();
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Common params for widget.
	 *
	 * @param widget the widget
	 * @param prepStatement the prep statement
	 * @param createMode the create mode
	 * @throws SQLException the SQL exception
	 */
	private void commonParamsForWidget(Widget widget, PreparedStatement prepStatement, boolean createMode)
			throws SQLException {

		int count = 1;
		if (createMode)
			prepStatement.setInt(count++, widget.getId());
		prepStatement.setString(count++, widget.getName());
		prepStatement.setInt(count++, widget.getWidth());
		prepStatement.setInt(count++, widget.getHeight());
		prepStatement.setString(count++, widget.getCssClass());
		prepStatement.setString(count++, widget.getCssStyle());
		prepStatement.setString(count++, widget.getText());
		prepStatement.setInt(count++, widget.getOrder());
	}

	/**
	 * Adds the params to prepared statement.
	 *
	 * @param widget the widget
	 * @param pageId the page id
	 * @param createMode the create mode
	 * @return the prepared statement
	 * @throws ClassNotFoundException the class not found exception
	 * @throws SQLException the SQL exception
	 */
	private PreparedStatement addParamsToPreparedStatement(Widget widget, int pageId, boolean createMode)
			throws ClassNotFoundException, SQLException {
		PreparedStatement prep = null;
		if (widget instanceof HtmlWidget) {
			prep = addParamsToPreparedStatementForHtmlWidget((HtmlWidget) widget, pageId, createMode);
			

		} else if (widget instanceof HeadingWidget) {
			prep = addParamsToPreparedStatementForHeadingWidget((HeadingWidget) widget, pageId, createMode);

		} else if (widget instanceof YouTubeWidget) {
			prep = addParamsToPreparedStatementForYouTubeWidget((YouTubeWidget) widget, pageId, createMode);

		} else if (widget instanceof ImageWidget) {
			prep = addParamsToPreparedStatementForImageWidget((ImageWidget) widget, pageId, createMode);

		}
		return prep;
	}

	/**
	 * Adds the params to prepared statement for html widget.
	 *
	 * @param widget the widget
	 * @param pageId the page id
	 * @param createMode the create mode
	 * @return the prepared statement
	 * @throws ClassNotFoundException the class not found exception
	 * @throws SQLException the SQL exception
	 */
	private PreparedStatement addParamsToPreparedStatementForHtmlWidget(HtmlWidget widget, int pageId,
			boolean createMode) throws ClassNotFoundException, SQLException {
		connection = edu.northeastern.cs5200.Connection.getConnection();
		PreparedStatement prepStatement = connection
				.prepareStatement(createMode ? CREATE_HTML_WIDGET : UPDATE_HTML_WIDGET);
		commonParamsForWidget(widget, prepStatement, createMode);
		prepStatement.setString(createMode ? 9 : 8, widget.getHtml());
		prepStatement.setString(createMode ? 10 : 9, WidgetType.HTML.toString().toLowerCase());
		prepStatement.setInt(createMode ? 11 : 10, pageId);
		if(!createMode) {
			prepStatement.setInt(11, widget.getId());

		}

		return prepStatement;
	}

	/**
	 * Adds the params to prepared statement for heading widget.
	 *
	 * @param widget the widget
	 * @param pageId the page id
	 * @param createMode the create mode
	 * @return the prepared statement
	 * @throws ClassNotFoundException the class not found exception
	 * @throws SQLException the SQL exception
	 */
	private PreparedStatement addParamsToPreparedStatementForHeadingWidget(HeadingWidget widget, int pageId,
			boolean createMode) throws ClassNotFoundException, SQLException {
		connection = edu.northeastern.cs5200.Connection.getConnection();
		PreparedStatement prepStatement = connection
				.prepareStatement(createMode ? CREATE_HEADING_WIDGET : UPDATE_HEADING_WIDGET);
		commonParamsForWidget(widget, prepStatement, createMode);
		prepStatement.setInt(createMode ? 9 : 8, widget.getSize());
		prepStatement.setString(createMode ? 10 : 9, WidgetType.HEADING.toString().toLowerCase());
		prepStatement.setInt(createMode ? 11 : 10, pageId);
		if(!createMode) {
			prepStatement.setInt(11, widget.getId());

		}
		return prepStatement;

	}

	/**
	 * Adds the params to prepared statement for image widget.
	 *
	 * @param widget the widget
	 * @param pageId the page id
	 * @param createMode the create mode
	 * @return the prepared statement
	 * @throws ClassNotFoundException the class not found exception
	 * @throws SQLException the SQL exception
	 */
	private PreparedStatement addParamsToPreparedStatementForImageWidget(ImageWidget widget, int pageId,
			boolean createMode) throws ClassNotFoundException, SQLException {
		connection = edu.northeastern.cs5200.Connection.getConnection();
		PreparedStatement prepStatement = connection
				.prepareStatement(createMode ? CREATE_IMAGE_WIDGET : UPDATE_IMAGE_WIDGET);
		commonParamsForWidget(widget, prepStatement, createMode);

		prepStatement.setString(createMode ? 9 : 8, widget.getSrc());
		prepStatement.setString(createMode ? 10 : 9, WidgetType.IMAGE.toString().toLowerCase());
		prepStatement.setInt(createMode ? 11 : 10, pageId);
		if(!createMode) {
			prepStatement.setInt(11, widget.getId());

		}

		return prepStatement;

	}

	/**
	 * Adds the params to prepared statement for you tube widget.
	 *
	 * @param widget the widget
	 * @param pageId the page id
	 * @param createMode the create mode
	 * @return the prepared statement
	 * @throws SQLException the SQL exception
	 * @throws ClassNotFoundException the class not found exception
	 */
	private PreparedStatement addParamsToPreparedStatementForYouTubeWidget(YouTubeWidget widget, int pageId,
			boolean createMode) throws SQLException, ClassNotFoundException {
		connection = edu.northeastern.cs5200.Connection.getConnection();
		PreparedStatement prepStatement = connection
				.prepareStatement(createMode ? CREATE_YOUTUBE_WIDGET : UPDATE_YOUTUBE_WIDGET);
		commonParamsForWidget(widget, prepStatement,createMode);
		prepStatement.setString(createMode ? 9 : 8, widget.getUrl());
		prepStatement.setBoolean(createMode ? 10 : 9, widget.isShareble());
		prepStatement.setBoolean(createMode ? 11 : 10, widget.isExpandable());
		prepStatement.setString(createMode ? 12 : 11, WidgetType.YOUTUBE.toString().toLowerCase());
		prepStatement.setInt(createMode ? 13 : 12, pageId);
		if(!createMode) {
			prepStatement.setInt(13, widget.getId());

		}
		return prepStatement;
	}

	/**
	 * Find all widgets.
	 *
	 * @return the collection
	 */
	@Override
	public Collection<Widget> findAllWidgets() {
		try {
			connection = edu.northeastern.cs5200.Connection.getConnection();
			PreparedStatement prepStatement = connection.prepareStatement(FIND_ALL_WIDGETS);
			resultSet = prepStatement.executeQuery();

			return Utility.getCollectionOfWidgets(resultSet);

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	/**
	 * Find widget by id.
	 *
	 * @param widgetId the widget id
	 * @return the widget
	 */
	@Override
	public Widget findWidgetById(int widgetId) {
		try {
			connection = edu.northeastern.cs5200.Connection.getConnection();
			PreparedStatement prepStatement = connection.prepareStatement(FIND_WIDGET_BY_ID);
			prepStatement.setInt(1, widgetId);
			resultSet = prepStatement.executeQuery();
			Collection<Widget> widget = Utility.getCollectionOfWidgets(resultSet);
			return widget != null && !widget.isEmpty() ? (Widget) widget.toArray()[0] : null;
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	/**
	 * Find widgets for page.
	 *
	 * @param pageId the page id
	 * @return the collection
	 */
	@Override
	public Collection<Widget> findWidgetsForPage(int pageId) {
		try {
			connection = edu.northeastern.cs5200.Connection.getConnection();
			PreparedStatement prepStatement = connection.prepareStatement(FIND_WIDGETS_FOR_PAGE);
			prepStatement.setInt(1, pageId);
			resultSet = prepStatement.executeQuery();
			return Utility.getCollectionOfWidgets(resultSet);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	/**
	 * Update widget.
	 *
	 * @param widgetId the widget id
	 * @param widget the widget
	 * @return the int
	 */
	@Override
	public int updateWidget(int widgetId, Widget widget) {
		try {
			widget.setId(widgetId);
			PreparedStatement prepStatement = addParamsToPreparedStatement(widget, widget.getPage().getId(), false);
			if (prepStatement != null) {
				return prepStatement.executeUpdate();
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		return 0;
	}

	/**
	 * Delete widget.
	 *
	 * @param widgetId the widget id
	 * @return the int
	 */
	@Override
	public int deleteWidget(int widgetId) {
		try {
			connection = edu.northeastern.cs5200.Connection.getConnection();
			PreparedStatement prepStatement = connection.prepareStatement(DELETE_WIDGET);
			prepStatement.setInt(1, widgetId);
			return prepStatement.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

}
