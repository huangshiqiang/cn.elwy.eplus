jQuery(function($) {
      //拖动支持
         $('#external-events div.external-event').each(function() {

    		// create an Event Object (http://arshaw.com/fullcalendar/docs/event_data/Event_Object/)
    		// it doesn't need to have a start or end
    		var eventObject = {
    			title: $.trim($(this).text()) // use the element's text as the event title
    		};

    		// store the Event Object in the DOM element so we can get to it later
    		$(this).data('eventObject', eventObject);

    		// make the event draggable using jQuery UI
    		$(this).draggable({
    			zIndex: 999,
    			revert: true,      // will cause the event to go back to its
    			revertDuration: 0  //  original position after the drag
    		});
    		
    	}); 
        
        var date = new Date();
    	var d = date.getDate();
    	var m = date.getMonth();
    	var y = date.getFullYear();

    	var calendar = $('#calendar').fullCalendar({
    		
    		//isRTL: true,
    		 buttonHtml: {
    			prev: '<i class="ace-icon fa fa-chevron-left"></i>',
    			next: '<i class="ace-icon fa fa-chevron-right"></i>'
    		}, 
    	
    		 header: {
    			left: 'prev,next today',
    			center: 'title',
    			right: 'month,agendaWeek,agendaDay'
    		}, 
    		 events: [
    		  {
    			title: 'All Day Event',
    			start: new Date(y, m, 1),
    			className: 'label-important'
    		  },
    		  {
    			title: 'Long Event',
    			start: moment().subtract(5, 'days').format('YYYY-MM-DD'),
    			end: moment().subtract(1, 'days').format('YYYY-MM-DD'),
    			className: 'label-success'
    		  },
    		  {
    			title: 'Some Event',
    			start: new Date(y, m, d-3, 16, 0),
    			allDay: false,
    			className: 'label-info'
    		  }
    		]
    		, 
    		editable: true,
    		droppable: true,  // this allows things to be dropped onto the calendar !!!
    		 drop: function(date, allDay) { // this function is called when something is dropped
    		
    			// retrieve the dropped element's stored Event Object
    			var originalEventObject = $(this).data('eventObject');
    			var $extraEventClass = $(this).attr('data-class');
    			
    			
    			// we need to copy it, so that multiple events don't have a reference to the same object
    			var copiedEventObject = $.extend({}, originalEventObject);
    			
    			// assign it the date that was reported
    			copiedEventObject.start = date;
    			copiedEventObject.allDay = allDay;
    			if($extraEventClass) copiedEventObject['className'] = [$extraEventClass];
    			
    			// render the event on the calendar
    			// the last `true` argument determines if the event "sticks" (http://arshaw.com/fullcalendar/docs/event_rendering/renderEvent/)
    			$('#calendar').fullCalendar('renderEvent', copiedEventObject, true);
    			
    			// is the "remove after drop" checkbox checked?
    			if ($('#drop-remove').is(':checked')) {
    				// if so, remove the element from the "Draggable Events" list
    				$(this).remove();
    			}
    		}
    		, 
    		selectable: true,
    		selectHelper: true,
    		select: function(start, end, allDay) {
    			YssLayer.openDialog("新增事件",$('#form_id'),"800","250");
    			calendar.fullCalendar('unselect');
    		}
    		,
    		 eventClick: function(calEvent, jsEvent, view) {

    			 YssLayer.openDialog("修改事件",$('#form_update'),"800","250"); 

    		} 
    		
    	});
    })