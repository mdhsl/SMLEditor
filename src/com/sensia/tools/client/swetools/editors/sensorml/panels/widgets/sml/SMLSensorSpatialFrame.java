package com.sensia.tools.client.swetools.editors.sensorml.panels.widgets.sml;

import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.sensia.tools.client.swetools.editors.sensorml.panels.widgets.AbstractSensorElementWidget;
import com.sensia.tools.client.swetools.editors.sensorml.panels.widgets.ISensorWidget;
import com.sensia.tools.client.swetools.editors.sensorml.panels.widgets.ISensorWidget.TAG_DEF;
import com.sensia.tools.client.swetools.editors.sensorml.panels.widgets.ISensorWidget.TAG_TYPE;
import com.sensia.tools.client.swetools.editors.sensorml.panels.widgets.base.SensorGenericVerticalContainerWidget;

public class SMLSensorSpatialFrame extends SensorGenericVerticalContainerWidget{

	private HorizontalPanel labelPanel;
	private HorizontalPanel descriptionPanel;
	
	private String id = "";
	
	public SMLSensorSpatialFrame() {
		super("SpatialFrame", TAG_DEF.SML, TAG_TYPE.ELEMENT);
		
		labelPanel = new HorizontalPanel();
		labelPanel.add(new HTML("Spatial Frame"));
		descriptionPanel = new HorizontalPanel();
		
		descriptionPanel.setVisible(false);
		
		container.add(labelPanel);
		container.add(descriptionPanel);
	}

	@Override
	protected void addSensorWidget(ISensorWidget widget) {
		if(widget.getType() == TAG_TYPE.ATTRIBUTE && widget.getName().equals("id")) {
			id = widget.getValue("id", true);
			labelPanel.add(new HTML("&nbsp;("+id+")"));
		} else if(widget.getDef() == TAG_DEF.SWE) {
			if(widget.getName().equals("label")) {
				labelPanel.clear();
				labelPanel.add(widget.getPanel());
				if(!id.isEmpty()) {
					labelPanel.add(new HTML("&nbsp;("+id+")"));
				}
			} else if(widget.getName().equals("description")) {
				descriptionPanel.add(widget.getPanel());
				descriptionPanel.setVisible(true);
			}
		} else {
			super.addSensorWidget(widget);
		}
		
	}

	@Override
	protected AbstractSensorElementWidget newInstance() {
		return new SMLSensorSpatialFrame();
	}

}
