function loadPubReportsGraph(pubValues,year) {
	console.log(pubValues);
	var exampleBarChartData = {
		"datasets": {
			"values": pubValues,
			"labels": [
				"Jan", 
				"Feb", 
				"Mar", 
				"Apr",
				"May",
				"Jun",
				"Jul",
				"Aug",
				"Sep",
				"Oct",
				"Nov", 
				"Dec"
			],
			"color": "blue"
		},
		"title": "Reports Published - "+year,
		"noY": true,
		"height": "300px",
		"width": "450px",
		"background": "#FFFFFF",
		"shadowDepth": "1"
	};
	console.log("its about to load");
	try{
		MaterialCharts.bar("#bar-chart-example", exampleBarChartData)

	}catch(e) {
		console.log(e);
	}
	

}

$(document).ready(function() {
	var exampleBarChartData = {
		"datasets": {
			"values": [5, 10, 30, 50, 20, 30, 50, 70, 20, 10, 50, 25],
			"labels": [
				"Jan", 
				"Feb", 
				"Mar", 
				"Apr",
				"May",
				"Jun",
				"Jul",
				"Aug",
				"Sep",
				"Oct",
				"Nov", 
				"Dec"
			],
			"color": "blue"
		},
		"title": "Reports Sold - 2016",
		"noY": true,
		"height": "300px",
		"width": "450px",
		"background": "#FFFFFF",
		"shadowDepth": "1"
	};

	//MaterialCharts.bar("#bar-chart-sold", exampleBarChartData)

});