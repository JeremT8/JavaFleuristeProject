$(function() {
	let searchParams = new URLSearchParams(window.location.search);
	let id = searchParams.get('id')
	if (id == null){
		window.location = "plantes.html";
	}
	else{
		getModifPlante(id);
		
	}
	
	$("#bEnvoyer").on ("click", modifPlante);
});


function getModifPlante(id) {
    $("#errorPlantes").css("display", "none");
    $.get("http://localhost:8080/tp-fleuriste/rs/plantes/" + id, modifPlante);
}







function modifPlante(plante) {

	var data = {
		nom: $("#nomPlante").val(plante.nom),
		tarif: $("#tarifPlante").val(plante.tarif),
		quantite: $("#quantitePlante").val(plante.quantite),
		description: $("#infoPlante").val(plante.description),
		image: $("#urlImagePlante").val(plante.image),
	}
	

	$.ajax({
		type: 'put',
		url: 'http://localhost:8080/tp-fleuriste/rs/plantes' + $("#id").val(),
		data: JSON.stringify(data),
		contentType: "application/json;charset=utf-8",
		success: function() {
			window.location = "plantes.html";
		}
	})
	.fail(function() {
		$("#errorPlantes").css("display", "block");
		$("#errorPlantes").html("Une erreur est survenue lors de la modification");
	})
	
	console.log(data);
}










