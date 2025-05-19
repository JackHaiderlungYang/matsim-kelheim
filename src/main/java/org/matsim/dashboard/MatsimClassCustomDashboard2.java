package org.matsim.dashboard;


import org.matsim.contrib.drt.extension.dashboards.DrtAnalysisPostProcessing;
import org.matsim.contrib.drt.run.DrtConfigGroup;
import org.matsim.core.config.ConfigGroup;
import org.matsim.simwrapper.Dashboard;
import org.matsim.simwrapper.Data;
import org.matsim.simwrapper.Header;
import org.matsim.simwrapper.Layout;
import org.matsim.simwrapper.viz.*;
import tech.tablesaw.plotly.components.Axis;
import tech.tablesaw.plotly.traces.BarTrace;
import tech.tablesaw.plotly.traces.ScatterTrace;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * General DRT dashboard for one specific service.
 */
public class MatsimClassCustomDashboard2 implements Dashboard {

//	private final String crs;
//	private final URL matsimConfigContext;

//	private final DrtConfigGroup drtConfigGroup;
//	private final int lastIteration;

//	public MatsimClassCustomDashboard2(DrtConfigGroup drtConfigGroup, URL matsimConfigContext, String crs, int lastIteration) {
//		this.drtConfigGroup = drtConfigGroup;
//		this.matsimConfigContext = matsimConfigContext;
//		this.crs = crs;
//		this.lastIteration = lastIteration;
//	}

	public MatsimClassCustomDashboard2() {
	}

//	@Override
//	public String context() {
//		return drtConfigGroup.getMode().replace("drt", "").replace("Drt", "");
//	}

	@Override
	public void configure(Header header, Layout layout) {

		header.title = "Custom MATSim class dashboard";
		header.description = "This is an example on how to create custom simwrapper dashboard";

		layout.row("Spatial demand distribution")
			.el(Hexagons.class, (viz, data) -> {
				viz.title = "Spatial demand distribution";
				viz.description = "Origins and destinations of all trips.";
				viz.projection = "EPSG:25832";
				viz.file = "./kelheim-v3.1-1pct-iter_1.output_trips.csv.gz";
				viz.addAggregation("OD", "origins", "start_x", "start_y");
				viz.addAggregation("OD2", "departures", "end_x", "end_y");

				viz.center = data.context().getCenter();
				viz.zoom = data.context().mapZoomLevel;
				viz.height = 7d;
			});


	}
}
