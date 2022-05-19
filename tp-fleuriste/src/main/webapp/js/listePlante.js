$(function() {
	getPlantes();
});

function getPlantes() {
	$("#errorBouquet").css("display", "none");
	$.get("http://localhost:8080/tp-fleuriste/rs/plantes", afficherPlantes);
}

function afficherPlantes(Plantes) {
	var data = "";
	Plantes.forEach(function(b) {
		var content = "";
		content += "<div class='card' style='width: 46%;'>";
		content += " <img class='card-img-top ' src=" + b.image + " >";
		content += "<div class='card-body'>";
		content += "<h5 class='card-title'><a href=''>" + b.nom + "</a></h5>";
		content += " <p class='card-text'>" + b.description + "</p>";
		content += " <p class='card-text tarif-card'>"+ b.tarif + "€" + "</p>";
		content += " </div>";
		content += " </div>";

		data += content;
	})

	$("#content").html(data);
}









