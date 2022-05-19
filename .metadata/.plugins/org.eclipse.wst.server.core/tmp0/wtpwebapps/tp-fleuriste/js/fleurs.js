$(function() {
	getFleurs();
	getSaisons();
	$("#bAjoutFleur").on("click", ajouterFleur);
});

function getFleurs() {
	$.get("http://localhost:8080/tp-fleuriste/rs/fleurs", afficherFleurs);
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
function afficherFleurs(fleurs) {
	var data = "";
	$("#nbFleur").html(fleurs.length);
	fleurs.forEach(function(f) {
		var tr = "<tr>";
		tr += "<td>" + f.id + "</td>";
		tr += "<td><button onclick='afficheFleur(" + f.id + ")' type='button' class='btn btn-link'>" + f.nom + "</button></td>";
		tr += "<td>" + f.tarif + "</td>";
		tr += "<td>" + f.quantite + "</td>";
		tr += "<td>" + f.saison.libelle + "</td>";
		tr += "<td class='centre'><button onclick='modifFleur(" + f.id + ")' type='button' class='btn btn-xs btn-success'>Modifier</button></td>";
		tr += "<td class='centre'><button onclick='suppFleur(" + f.id + ")' type='button' class='btn btn-xs btn-danger'>Supprimer</button></td>";
		tr += "</tr>";

		data += tr;
	})
	$("#tbodyliste").html(data);
}

function ajouterFleur() {

	var data = {
		nom: $("#nomFleur").val(),
		tarif: $("#tarifFleur").val(),
		quantite: $("#quantiteFleur").val(),
		description: $("#infoFleur").val(),
		image: $("#urlImageFleur").val(),
		couleur: $("#couleurFleur").val(),
		saison: {
			id: $("#saison").val()
		},
	}


	$.ajax({
		type: 'post',
		url: 'http://localhost:8080/tp-fleuriste/rs/fleurs',
		data: JSON.stringify(data),
		contentType: "application/json;charset=utf-8",
		success: function() {
			window.location = "fleurs.html";
		}
	})
		.fail(function() {
			$("#errorFleurs").css("display", "block");
			$("#errorFleurs").html("Une erreur est survenue lors de l'ajout");
		})
}

function afficheFleur(id) {
	window.location = "fleur-detail.html?id=" + id;
}

function modifFleur(id) {
	window.location = "modiffleur.html?id=" + id;
}

function suppFleur(id) {
	$.ajax({
		type: 'delete',
		url: 'http://localhost:8080/tp-fleuriste/rs/fleurs/' + id,
		success: function() {
			getFleurs();
		}
	})
		.fail(function() {
			$("#errorFleurs").css("display", "block");
			$("#errorFleurs").html("Une erreur est survenue lors de la suppression");
		})
}