package edu.northeastern.cs5200.daos;

import java.sql.Connection;
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
	private final String UPDATE_WIDGET = "UPDATE `widget` SET `name`= ?,`width` = ?,`height`=?, `css_class`=?, `text`=?,`order`= ?,`heading_size` = ?,`html` = ?,`youtube_url` = ?,`youtube_sharable` = ?,`youtube_expandable` = ?,`image_src` = ?,`dtype` = ?,`page_id` = ? WHERE `id` = ?";
	private final String DELETE_WIDGET = "DELETE FROM `widget` WHERE `id` = ?";

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
			PreparedStatement prepStatement = addParamsToPreparedStatement(widget, pageId);
			if (prepStatement != null) {
				prepStatement.execute();
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	private void commonParamsForWidget(Widget widget, PreparedStatement prepStatement) throws SQLException {
		prepStatement.setInt(1, widget.getId());
		prepStatement.setString(2, widget.getName());
		prepStatement.setInt(3, widget.getWidth());
		prepStatement.setInt(4, widget.getHeight());
		prepStatement.setString(5, widget.getCssClass());
		prepStatement.setString(6, widget.getCssStyle());
		prepStatement.setString(7, widget.getText());
		prepStatement.setInt(8, widget.getOrder());
	}

	private PreparedStatement addParamsToPreparedStatement(Widget widget, int pageId)
			throws ClassNotFoundException, SQLException {
		if (widget instanceof HtmlWidget) {
			return addParamsToPreparedStatementForHtmlWidget((HtmlWidget) widget, pageId);
		} else if (widget instanceof HeadingWidget) {
			return addParamsToPreparedStatementForHeadingWidget((HeadingWidget) widget, pageId);
		} else if (widget instanceof YouTubeWidget) {
			return addParamsToPreparedStatementForYouTubeWidget((YouTubeWidget) widget, pageId);
		} else if (widget instanceof ImageWidget) {
			return addParamsToPreparedStatementForImageWidget((ImageWidget) widget, pageId);
		}
		return null;
	}

	private PreparedStatement addParamsToPreparedStatementForHtmlWidget(HtmlWidget widget, int pageId)
			throws ClassNotFoundException, SQLException {
		connection = edu.northeastern.cs5200.Connection.getConnection();
		PreparedStatement prepStatement = connection.prepareStatement(CREATE_HTML_WIDGET);
		commonParamsForWidget(widget, prepStatement);
		prepStatement.setString(9, widget.getHtml());
		prepStatement.setString(10, WidgetType.HTML.toString().toLowerCase());
		prepStatement.setInt(11, pageId);
		return prepStatement;
	}

	private PreparedStatement addParamsToPreparedStatementForHeadingWidget(HeadingWidget widget, int pageId)
			throws ClassNotFoundException, SQLException {
		connection = edu.northeastern.cs5200.Connection.getConnection();
		PreparedStatement prepStatement = connection.prepareStatement(CREATE_HEADING_WIDGET);
		commonParamsForWidget(widget, prepStatement);
		prepStatement.setInt(9, widget.getSize());
		prepStatement.setString(10, WidgetType.HEADING.toString().toLowerCase());
		prepStatement.setInt(11, pageId);
		return prepStatement;

	}

	private PreparedStatement addParamsToPreparedStatementForImageWidget(ImageWidget widget, int pageId)
			throws ClassNotFoundException, SQLException {
		connection = edu.northeastern.cs5200.Connection.getConnection();
		PreparedStatement prepStatement = connection.prepareStatement(CREATE_IMAGE_WIDGET);
		commonParamsForWidget(widget, prepStatement);
		prepStatement.setString(9, widget.getSrc());
		prepStatement.setString(10, WidgetType.IMAGE.toString().toLowerCase());
		prepStatement.setInt(11, pageId);
		return prepStatement;

	}

	private PreparedStatement addParamsToPreparedStatementForYouTubeWidget(YouTubeWidget widget, int pageId)
			throws SQLException, ClassNotFoundException {
		connection = edu.northeastern.cs5200.Connection.getConnection();
		PreparedStatement prepStatement = connection.prepareStatement(CREATE_YOUTUBE_WIDGET);
		commonParamsForWidget(widget, prepStatement);
		prepStatement.setString(9, widget.getUrl());
		prepStatement.setBoolean(10, widget.isShareble());
		prepStatement.setBoolean(11, widget.isExpandable());
		prepStatement.setString(12, WidgetType.YOUTUBE.toString().toLowerCase());
		prepStatement.setInt(13, pageId);
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
