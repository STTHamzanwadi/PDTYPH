package org.sipt.yph.jee.ui.opryayasan;

import com.vaadin.ui.Panel;

public class ViewPanel extends Panel{
	public ViewPanel() {
		setSizeFull();
		setContent(new MainView());
	}

}
