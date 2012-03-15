$(function() {
	$("#dialog-confirm").dialog({
		autoOpen : false,
		resizable : false,
		height : 140,
		modal : true,
		buttons : {
			"Delete intervention" : function() {
				$(this).dialog("close");
				window.location.href = $("#delete").href;
			},
			Cancel : function() {
				$(this).dialog("close");
			}
		}
	});

	$("#delete").click(function() {
		$("#dialog-confirm").dialog("open");
		return false;
	});
});