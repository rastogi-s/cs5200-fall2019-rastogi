package edu.northeastern.cs5200.daos;

import java.util.Collection;

import edu.northeastern.cs5200.models.Widget;

/**
 * The Interface WidgetImpl.
 */
public interface WidgetImpl {

	/**
	 * Creates the widget for page. Inserts properties in widget instance parameter
	 * into the Widget table. The widget's pageId foreign key refer to Page table
	 * primary key id whose value is equal to the pageId parameter
	 *
	 * 
	 * @param pageId the page id
	 * @param widget the widget
	 */
	void createWidgetForPage(int pageId, Widget widget);

	/**
	 * Find all widgets. Returns all records from Widget table as a Collection of
	 * Widget instances
	 *
	 * 
	 * @return the collection
	 */
	Collection<Widget> findAllWidgets();

	/**
	 * Find widget by id. Returns a record from Widget table whose id field is equal
	 * to the widgetId parameter
	 *
	 * 
	 * @param widgetId the widget id
	 * @return the widget
	 */
	Widget findWidgetById(int widgetId);

	/**
	 * Find widgets for page. Returns all records from Widget table as a Collection
	 * of Widget instances whose pageId is equal to the pageId parameter
	 *
	 * 
	 * @param pageId the page id
	 * @return the collection
	 */
	Collection<Widget> findWidgetsForPage(int pageId);

	/**
	 * Update widget. Updates record in Widget table whose id field is equal to
	 * widgetId parameter. New record field values are set to the values in the
	 * widget instance parameter
	 *
	 * 
	 * @param widgetId the widget id
	 * @param widget   the widget
	 * @return the int
	 */
	int updateWidget(int widgetId, Widget widget);

	/**
	 * Delete widget. Deletes record from Widget table whose id field is equal to
	 * widgetId parameter
	 *
	 * 
	 * @param widgetId the widget id
	 * @return the int
	 */
	int deleteWidget(int widgetId);

}
