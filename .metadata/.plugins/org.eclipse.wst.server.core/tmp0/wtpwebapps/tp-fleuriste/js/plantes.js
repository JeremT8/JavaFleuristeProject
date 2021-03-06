$(function() {
	getPlantes();
	getSaisons();
	$("#bAjoutPlante").on("click", ajouterPlante);
});

function getPlantes() {
	$.get("http://localhost:8080/tp-fleuriste/rs/plantes", afficherPlantes);
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
function afficherPlantes(plantes) {
	var data = "";
	$("#nbPlante").html(plantes.length);
	plantes.forEach(function(f) {
		var tr = "<tr>";
		tr += "<td>" + f.id + "</td>";
		tr += "<td><button onclick='affichePlante(" + f.id + ")' type='button' class='btn btn-link'>" + f.nom + "</button></td>";
		tr += "<td>" + f.tarif + "</td>";
		tr += "<td>" + f.quantite + "</td>";
		tr += "<td class='centre'><button onclick='modifPlante(" + f.id + ")' type='button' class='btn btn-xs btn-success'>Modifier</button></td>";
		tr += "<td class='centre'><button onclick='suppPlante(" + f.id + ")' type='button' class='btn btn-xs btn-danger'>Supprimer</button></td>";
		tr += "</tr>";

		data += tr;
	})
	$("#tbodyliste").html(data);
}

function ajouterPlante() {

	var data = {
		nom: $("#nomPlante").val(),
		tarif: $("#tarifPlante").val(),
		quantite: $("#quantitePlante").val(),
		description: $("#infoPlante").val(),
		image: $("#urlImagePlante").val(),
	}


	$.ajax({
		type: 'post',
		url: 'http://localhost:8080/tp-fleuriste/rs/plantes',
		data: JSON.stringify(data),
		contentType: "application/json;charset=utf-8",
		success: function() {
			window.location = "plantes.html";
		}
	})
		.fail(function() {
			$("#errorPlantes").css("display", "block");
			$("#errorPlantes").html("Une erreur est survenue lors de l'ajout");
		})
}

function affichePlante(id) {
	window.location = "plante-detail.html?id=" + id;
}

function modifPlante(id) {
	window.location = "modifplante.html?id=" + id;
}

function suppPlante(id) {
	$.ajax({
		type: 'delete',
		url: 'http://localhost:8080/tp-fleuriste/rs/plantes/' + id,
		success: function() {
			getPlantes();
		}
	})
		.fail(function() {
			$("#errorPlantes").css("display", "block");
			$("#errorPlantes").html("Une erreur est survenue lors de la suppression");
		})
}