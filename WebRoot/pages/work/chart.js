Ext.chart.Chart.CHART_URL = '../../ext3/resources/charts.swf';  

Ext.onReady(function() {   //定义ColumnModel  
	//Ext是一个Ajax框架，用javascript编写
          var store = new Ext.data.JsonStore({
          	url: 'selectDetectionData.jsp',  
            fields: ['time', 'T', 'PH', 'ORP', 'LS', 'DO'],  
            root: 'datalist',
            method: 'post',
			autoLoad: true });
          
       store.load();   
             
       new Ext.Panel({  
       title: 'T、PH、LS、DO实时曲线图',  
       renderTo: 'container1',  
       width: 375,  
       height: 250,  
       layout: 'fit',  
       autoShow : true, 

       items: {  
            xtype:'linechart',  
            store: store,  
            xField: 'time', 
        	yAxis:new Ext.chart.NumericAxis({
				labelRenderer:Ext.util.Format.numberRenderer('0.00')
			}),

            listeners: {  
                 itemclick: function(o) {  
                        var rec = store.getAt(o.index);  
                        Ext.example.msg('选择提示', '你选择了-{0}.', rec.get('name'));  
                 }  
            },
            series: [{
            	type: 'line',
            	displayName: 'T',
            	yField: 'T',
            	style: {
            		color:0x6600FF
            	}
            },{
            	type: 'line',
            	displayName: 'PH',
            	yField: 'PH',
            	style: {
            		color: 0xFF3399
            	}
            },{
            	type: 'line',
            	displayName: 'LS',
            	yField: 'LS',
            	style: {
            		color: 0x00BB00
            	}
            },{
            	type: 'line',
            	displayName: 'DO',
            	yField: 'DO',
            	style: {
            		color: 0xFF9966
            	}
            }]
	       }  
	   }); 
       
       new Ext.Panel({  
       title: 'ORP实时曲线图',  
       renderTo: 'container2',  
       width: 374,  
       height: 250,  
       layout: 'fit',  
       items: {  
            xtype:'linechart',  
            store: store,  
            xField: 'time',
        	yAxis:new Ext.chart.NumericAxis({
				displayName:'ORP',
				color:'0x00CCFF',
				labelRenderer:Ext.util.Format.numberRenderer('0.00')
			}),
            listeners: {  
                 itemclick: function(o) {  
                        var rec = store.getAt(o.index);  
                        Ext.example.msg('选择提示', '你选择了-{0}.', rec.get('name'));  
                 }  
            },
            series: [{
            	type: 'line',
            	displayName: 'ORP',
            	yField: 'ORP',
            	style: {
            		color:0x00CCFF
            	}
            }]
	       }  
	   });
       
	function refreshData() {
		store.reload();
	}
    Ext.TaskMgr.start({
		run: refreshData,
		interval: 5000
	});
});

 

