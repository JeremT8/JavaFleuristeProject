$(function() {
	let searchParams = new URLSearchParams(window.location.search);
	let id = searchParams.get('id')
	if (id == null){
		window.location = "fleurs.html";
	}
	else{
		getModifFleur(id);
		getSaisons();
		getStyles();
		
	}
	
	$("#bEnvoyer").on ("click", modifFleur);
});


function getModifFleur(id) {
    $("#errorFleurs").css("display", "none");
    $.get("http://localhost:8080/tp-fleuriste/rs/fleurs/" + id, modifFleur);
}




function getSaisons() {
	$.get("http://localhost:8080/tp-fleuriste/rs/saisons", function(saisons) {

		var data = "";
		saisons.forEach(function(s) {
			data += "<option value=" + s.id + ">" + s.libelle + "</option>";
		});

		$("#saison").html(data);

	});
}

function getStyles() {
	$.get("http://localhost:8080/tp-fleuriste/rs/styles", function(styles) {

		var data = "";
		styles.forEach(function(s) {
			data += "<option value=" + s.id + ">" + s.libelle + "</option>";
		});

		$("#style").html(data);

	});
}




function modifFleur(fleur) {

	var data = {
		nom: $("#nomFleur").val(fleur.nom),
		tarif: $("#tarifFleur").val(fleur.tarif),
		quantite: $("#quantiteFleur").val(fleur.quantite),
		description: $("#infoFleur").val(fleur.description),
		image: $("#urlImageFleur").val(fleur.image),
		couleur: $("#couleurFleur").val(fleur.couleur),
		saison: {
			id: $("#saison").val(fleur.saison)
		},
		style: {
			id: $("#style").val(fleur.style)
		},
	}
	

	$.ajax({
		type: 'put',
		url: 'http://localhost:8080/tp-fleuriste/rs/plantes' + $("#id").val(),
		data: JSON.stringify(data),
		contentType: "application/json;charset=utf-8",
		success: function() {
			window.location = "fleurs.html";
		}
	})
	.fail(function() {
		$("#errorFleurs").css("display", "block");
		$("#errorFleurs").html("Une erreur est survenue lors de la modification");
	})
	
	console.log(data);
}










