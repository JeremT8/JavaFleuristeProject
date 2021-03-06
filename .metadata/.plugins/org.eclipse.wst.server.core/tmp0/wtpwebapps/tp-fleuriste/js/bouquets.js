$(function() {
	getBouquets();
	getSaisons();
	getStyles();
	$("#bAjoutBouquet").on("click", ajouterBouquet);
});

function getBouquets() {
	$.get("http://localhost:8080/tp-fleuriste/rs/bouquets", afficherBouquets);
}

function getSaisons() {
	$.get("http://localhost:8080/tp-fleuriste/rs/saisons", function(saisons) {

		var data = "";
		saisons.forEach(function(ss) {
			data += "<option value=" + ss.id + ">" + ss.libelle + "</option>";
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


function afficherBouquets(bouquets) {
	var data = "";
	$("#nbBouquet").html(bouquets.length);
	bouquets.forEach(function(b) {
		var tr = "<tr>";
		tr += "<td>" + b.id + "</td>";
		tr += "<td><button onclick='afficheBouquet(" + b.id + ")' type='button' class='btn btn-link'>" + b.nom + "</button></td>";
		tr += "<td>" + b.tarif + "</td>";
		tr += "<td>" + b.quantite + "</td>";
		tr += "<td>" + b.saison.libelle + "</td>";
		tr += "<td>" + b.style.libelle + "</td>";
		tr += "<td class='centre'><button onclick='modifBouquet(" + b.id + ")' type='button' class='btn btn-xs btn-success'>Modifier</button></td>";
		tr += "<td class='centre'><button onclick='suppBouquet(" + b.id + ")' type='button' class='btn btn-xs btn-danger'>Supprimer</button></td>";
		tr += "</tr>";
		
		data += tr;
	})
	
	$("#tbodyliste").html(data);
	
	
}

function ajouterBouquet() {

	var data = {
		nom: $("#nomBouquet").val(),
		tarif: $("#tarifBouquet").val(),
		quantite: $("#quantiteBouquet").val(),
		description: $("#infoBouquet").val(),
		image: $("#urlImageBouquet").val(),
		couleur: $("#couleurBouquet").val(),
		saison: {
			id: $("#saison").val()
		},
		style: {
			id: $("#style").val()
		},
	}


	$.ajax({
		type: 'post',
		url: 'http://localhost:8080/tp-fleuriste/rs/bouquets',
		data: JSON.stringify(data),
		contentType: "application/json;charset=utf-8",
		success: function() {
			window.location = "bouquets.html";
		}
	})
		.fail(function() {
			$("#errorBouquets").css("display", "block");
			$("#errorBouquets").html("Une erreur est survenue lors de l'ajout");
		})
}

function afficheBouquet(id) {
	window.location = "bouquet-detail.html?id=" + id;
}

function modifBouquet(id) {
	window.location = "modifbouquet.html?id=" + id;
}

function suppBouquet(id) {
	$.ajax({
		type: 'delete',
		url: 'http://localhost:8080/tp-fleuriste/rs/bouquets/' + id,
		success: function() {
			getBouquets();
		}
	})
		.fail(function() {
			$("#errorBouquets").css("display", "block");
			$("#errorBouquets").html("Une erreur est survenue lors de la suppression");
		})
}