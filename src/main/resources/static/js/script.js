$(document).ready(function() {
	$('.modal').modal();
	Materialize.updateTextFields();
	$('.carousel').carousel();
	$('select').material_select();
	$('.carousel.carousel-slider').carousel({fullWidth: true});
	
	$("#logout").click(function(){
		window.location.replace('/login');
	});
	
	$('#funcionarioCpf').mask('000.000.000-00', {reverse: true});
});
