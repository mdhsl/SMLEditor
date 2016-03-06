package com.sensia.tools.client.swetools.editors.sensorml.panels.widgets.sml;

import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Panel;
import com.sensia.tools.client.swetools.editors.sensorml.SensorConstants;
import com.sensia.tools.client.swetools.editors.sensorml.panels.widgets.AbstractSensorElementWidget;
import com.sensia.tools.client.swetools.editors.sensorml.panels.widgets.ISensorWidget;
import com.sensia.tools.client.swetools.editors.sensorml.panels.widgets.ISensorWidget.MODE;
import com.sensia.tools.client.swetools.editors.sensorml.panels.widgets.ISensorWidget.TAG_DEF;
import com.sensia.tools.client.swetools.editors.sensorml.panels.widgets.ISensorWidget.TAG_TYPE;

public class SMLKeywordsWidget extends AbstractSensorElementWidget {

	private HorizontalPanel container;
	private HTML codeSpace;
	private HTML keywords;
	private HTML separator;
	
	public SMLKeywordsWidget() {
		super("KeywordList", TAG_DEF.SML, TAG_TYPE.ELEMENT);
		
		container = new HorizontalPanel();
		codeSpace = new HTML();
		keywords = new HTML();
		separator = new HTML(":"+SensorConstants.HTML_SPACE);
		
		container.add(new HTML("Keywords &nbsp;"));
		container.add(codeSpace);
		container.add(separator);
		container.add(keywords);
		
		codeSpace.setVisible(false);
	}

	@Override
	public Panel getPanel() {
		return container;
	}

	@Override
	protected void activeMode(MODE mode) {
		
	}

	@Override
	protected void addSensorWidget(ISensorWidget widget) {
		if(widget.getType() == TAG_TYPE.ELEMENT && widget.getName().equals("codeSpace")) {
			codeSpace.setVisible(true);
			codeSpace.setHTML("("+widget.getValue("href")+")");
		} else if(widget.getName().equals("keyword")) {
			keywords.setHTML(keywords.getHTML()+"&nbsp;&nbsp;"+widget.getValue("keyword"));
		}
	}

	@Override
	protected AbstractSensorElementWidget newInstance() {
		return new SMLKeywordsWidget();
	}

}