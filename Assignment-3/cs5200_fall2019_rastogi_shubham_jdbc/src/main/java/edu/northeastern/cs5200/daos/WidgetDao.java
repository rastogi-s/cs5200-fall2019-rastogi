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

public class WidgetDao implements WidgetImpl {

	private static WidgetDao instance;
	private Connection connection;
	private ResultSet resultSet;
//	private final String CREATE_WIDGET = "INSERT INTO `widget`(`id`,`name`,`width`,`height`,`css_class`,`css_style`,`text`,`order`,`heading_size`, `html`,`youtube_url`, `youtube_sharable`,`youtube_expandable`,`image_src`,`dtype`,`page_id`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	private final String CREATE_HEADING_WIDGET = "INSERT INTO `widget`(`id`,`name`,`width`,`height`,`css_class`,`css_style`,`text`,`order`,`heading_size`, `dtype`,`page_id`) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
	private final String CREATE_HTML_WIDGET = "INSERT INTO `widget`(`id`,`name`,`width`,`height`,`css_class`,`css_style`,`text`,`order`, `html`,`dtype`,`page_id`) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
	private final String CREATE_IMAGE_WIDGET = "INSERT INTO `widget`(`id`,`name`,`width`,`height`,`css_class`,`css_style`,`text`,`order`,`image_src`,`dtype`,`page_id`) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
	private final String CREATE_YOUTUBE_WIDGET = "INSERT INTO `widget`(`id`,`name`,`width`,`height`,`css_class`,`css_style`,`text`,`order`,`youtube_url`, `youtube_sharable`,`youtube_expandable`,`dtype`,`page_id`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
	private final String FIND_ALL_WIDGETS = "SELECT *  FROM `widget`";
	private final String FIND_WIDGETS_FOR_PAGE = "SELECT *  FROM `widget` WHERE `page_id` = ?";
	private final String FIND_WIDGET_BY_ID = "SELECT *  FROM `widget` WHERE `id` = ?";
	private final String DELETE_WIDGET = "DELETE FROM `widget` WHERE `id` = ?";
	private final String UPDATE_HEADING_WIDGET = "UPDATE  `widget` SET  `name` = ?,`width` = ?,`height` = ?,`css_class` = ?,`css_style`= ?,`text` = ?,`order` =?,`heading_size` =?, `dtype` =?,`page_id` =? WHERE `id`= ?";
	private final String UPDATE_HTML_WIDGET = "UPDATE  `widget` SET `name` = ?,`width` = ?,`height` = ?,`css_class` = ?,`css_style`= ?,`text` = ?,`order` =?, `html` =?,`dtype` =?,`page_id` =? WHERE `id`= ?";
	private final String UPDATE_IMAGE_WIDGET = "UPDATE  `widget`SET  `name` = ?,`width` = ?,`height` = ?,`css_class` = ?,`css_style`= ?,`text` = ?,`order` =?, `image_src` =?,`dtype` =?,`page_id` =? WHERE `id`= ?";
	private final String UPDATE_YOUTUBE_WIDGET = "UPDATE  SET `name` = ?,`width` = ?,`height` = ?,`css_class` = ?,`css_style`= ?,`text` = ?,`order` =?, `youtube_url` =?, `youtube_sharable` = ?,`youtube_expandable` =?,`dtype` = ?,`page_id` =? WHERE `id`= ?";

	private WidgetDao() {
	}

	public static WidgetDao getInstance() {
		if (instance == null)
			instance = new WidgetDao();
		return instance;
	}

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
