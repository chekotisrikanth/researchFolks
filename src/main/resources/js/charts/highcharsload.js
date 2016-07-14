function getStringForId (pubRef) {
	
	//var pubRef1s = parseInt(pubRef) ;
	var str;
	switch (pubRef) {
		case "1" : 
			str="OPEN" ;			
			break;
		case "2" : 
			str="REVIWER_PENDING";
			break;
		case "3" : 
			str="REVIWER_COMMENTS" ;
		break;
		case "4" : 
			str="PUBLISHER_PENDING" ;
			break;
		case "5" :
			str="PUBLISHED"	 
			break;
		default :  
			str="Yet To Add Status"	;
	}
	
	return str;
}



function loadPubReportsGraph(pubValues,year) {
	console.log(pubValues);
	
	console.log("its about to load");
	var seriesDataList=[];
	var seriedData={}
	$(pubValues).each(function(index,object){
		
		 console.log(object);
		for(i in object) {
			 seriedData={};
			seriedData.name= getStringForId(i);
			seriedData.data=object[i];
			seriesDataList.push(seriedData);
		}
		
		
	});
	console.log(seriesDataList);
	try{
		//MaterialCharts.bar("#bar-chart-example", exampleBarChartData)
		$('#bar-chart-example').highcharts({
	        chart: {
	            type: 'column'
	        },
	        title: {
	            text: 'Year Wise Reports Analysis'
	        },
	        subtitle: {
	            text: year
	        },
	        xAxis: {
	            categories: [
	                'Jan',
	                'Feb',
	                'Mar',
	                'Apr',
	                'May',
	                'Jun',
	                'Jul',
	                'Aug',
	                'Sep',
	                'Oct',
	                'Nov',
	                'Dec'
	            ],
	            crosshair: true
	        },
	        yAxis: {
	            min: 0,
	            title: {
	                text: 'Count'
	            }
	        },
	        tooltip: {
	            headerFormat: '<span style="font-size:10px">{point.key}</span><table>',
	            pointFormat: '<tr><td style="color:{series.color};padding:0">{series.name}: </td>' +
	                '<td style="padding:0"><b>{point.y}</b></td></tr>',
	            footerFormat: '</table>',
	            shared: true,
	            useHTML: true
	        },
	        plotOptions: {
	            column: {
	                pointPadding: 0.2,
	                borderWidth: 0
	            }
	        },
	        series: seriesDataList/*[{
	            name: 'Published',
	            data: pubValues

	        }, {
	            name: 'New York',
	            data: [83.6, 78.8, 98.5, 93.4, 106.0, 84.5, 105.0, 104.3, 91.2, 83.5, 106.6, 92.3]

	        }, {
	            name: 'London',
	            data: [48.9, 38.8, 39.3, 41.4, 47.0, 48.3, 59.0, 59.6, 52.4, 65.2, 59.3, 51.2]

	        }, {
	            name: 'Berlin',
	            data: [42.4, 33.2, 34.5, 39.7, 52.6, 75.5, 57.4, 60.4, 47.6, 39.1, 46.8, 51.1]

	        }]*/
	    });
	
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