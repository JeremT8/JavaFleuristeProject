$(function() {
	let searchParams = new URLSearchParams(window.location.search);
	let id = searchParams.get('id')
	if (id == null){
		window.location = "bouquets.html";
	}
	else{
		getModifBouquet(id);
		getSaisons();
		getStyles();
		
	}
	
	$("#bEnvoyer").on ("click", modifBouquet);
});


function getModifBouquet(id) {
    $("#errorBouquets").css("display", "none");
    $.get("http://localhost:8080/tp-fleuriste/rs/bouquets/" + id, modifBouquet);
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




function modifBouquet(bouquet) {

	var data = {
		nom: $("#nomBouquet").val(bouquet.nom),
		tarif: $("#tarifBouquet").val(bouquet.tarif),
		quantite: $("#quantiteBouquet").val(bouquet.quantite),
		description: $("#infoBouquet").val(bouquet.description),
		image: $("#urlImageBouquet").val(bouquet.image),
		couleur: $("#couleurBouquet").val(bouquet.couleur),
		saison: {
			id: $("#saison").val(bouquet.saison)
		},
		style: {
			id: $("#style").val(bouquet.style)
		},
	}
	

	$.ajax({
		type: 'put',
		url: 'http://localhost:8080/tp-fleuriste/rs/plantes' + $("#id").val(),
		data: JSON.stringify(data),
		contentType: "application/json;charset=utf-8",
		success: function() {
			window.location = "bouquets.html";
		}
	})
	.fail(function() {
		$("#errorBouquets").css("display", "block");
		$("#errorBouquets").html("Une erreur est survenue lors de la modification");
	})
	
	console.log(data);
}










