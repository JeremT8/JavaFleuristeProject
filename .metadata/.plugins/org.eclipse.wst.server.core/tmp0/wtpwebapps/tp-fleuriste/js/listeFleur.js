$(function() {
	getFleurs();
});

function getFleurs() {
	$("#errorFleur").css("display", "none");
	$.get("http://localhost:8080/tp-fleuriste/rs/fleurs", afficherFleurs);
}

function afficherFleurs(fleurs) {
	var data = "";
	fleurs.forEach(function(f) {
		var content = "";
		content += "<div class='card' style='width: 46%;'>";
		content += " <img class='card-img-top ' src=" + f.image + " >";
		content += "<div class='card-body'>";
		content += "<h5 class='card-title'><a href=''>" + f.nom + "</a></h5>";
		content += " <p class='card-text'>" + f.description + "</p>";
		content += " <p class='card-text tarif-card'>"+ f.tarif + "€" + "</p>";
		content += " </div>";
		content += " </div>";

		data += content;
	})

	$("#content").html(data);
}









