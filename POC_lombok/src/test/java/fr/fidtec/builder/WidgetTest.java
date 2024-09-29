package fr.fidtec.builder;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class WidgetTest {

	@Test
	public void WidgetBuilderSimpleTest() {
		Widget testWidget = Widget.builder()
				  .name("foo")
				  .id(1)
				  .build();

		assertEquals("foo", testWidget.getName());
		assertEquals(1, testWidget.getId());
	}
	
	@Test
	public void WidgetBuilderTest() {
		
		Widget.WidgetBuilder widgetBuilder = new Widget(null, 0).toBuilder();
		Widget newWidget = widgetBuilder.id(2).build();
		assertEquals(2, newWidget.getId());
		
		Widget testWidget = Widget.builder()
				  .name("foo")
				  .id(1)
				  .build();

		assertEquals("foo", testWidget.getName());
		assertEquals(1, testWidget.getId());
	}
}
