$(document).ready(function() {
	//Ejecuta cada minuto
	setInterval('getImeca()',60000);
});

function getImeca(){
	$('#load').show();
	$.ajax({
	    type: 'POST',
	    url: 'json/getImeca',
	    contentType: 'application/json; charset=utf-8',
	    dataType: 'json',
	    success: function (json) {
	        $('#simat').val(json.datos);
	        $('#load').hide();
	    },
	});
}