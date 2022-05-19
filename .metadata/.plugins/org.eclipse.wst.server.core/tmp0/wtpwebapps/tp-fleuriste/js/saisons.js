$(function() {
	getSaisons();
	$("#bAjoutSaisons").on("click", ajouterSaisons);
});



function getSaisons() {
	$("#errorSaisons").css("display", "none");
	$.get("http://localhost:8080/tp-fleuriste/rs/saisons", affichersaisons);
}


function ajouterSaisons() {

	var data = {
		libelle: $("#libelleSaisons").val(),
	}
	$.ajax({
		type: 'post',
		url: 'http://localhost:8080/tp-fleuriste/rs/saisons',
		data: JSON.stringify(data),
		contentType: "application/json;charset=utf-8",
		success: function() {
			$("#libelleSaisons").val("");
			getSaisons();
		}
	})
	.fail(function() {
		$("#errorSaisons").css("display", "block");
		$("#errorSaisons").html("Une erreur est survenue lors de l'ajout");
	})

}


function affichersaisons(saisons) {
	var data = "";
	saisons.forEach(function(s) {
		var tr = "<tr>";
		tr += "<td>" + s.id + "</td>";
		tr += "<td><input type='text' id='libelle" + s.id + "' value=" + s.libelle + " /></td>";
		tr += "<td class='centre'><button onclick='modifSaisons(" + s.id + ")' type='button' class='glyphicon glyphicon-edit vert'></button></td>";
		tr += "<td class='centre'><button onclick='suppSaisons(" + s.id + ")' type='button' class='glyphicon glyphicon-remove rouge'></button></td>";

		tr += "</tr>";

		data += tr;
	})
	$("#tbodyliste").html(data);
}



function suppSaisons(id){
	$.ajax({
		type : 'delete',
		url : 'http://localhost:8080/tp-fleuriste/rs/saisons/' + id,
		success : function(){
			getSaisons();
		}
	})
	.fail(function(){
		$("#errorSaisons").css("display", "block");
		$("#errorSaisons").html("Une erreur est survenue lors de la suppression");
	})
}



function modifSaisons(id){
	
	var data = {
		libelle: $("#libelle" + id).val(),
	}
	

	$.ajax({
		type : 'put',
		url : 'http://localhost:8080/tp-fleuriste/rs/saisons/'+id,
		data : JSON.stringify(data),
		contentType : "application/json;charset=utf-8",
		success : function(){
			getSaisons();
		}
	})
	.fail(function(){
		getSaisons();
		$("#errorSaisons").css("display", "block");
		$("#errorSaisons").html("Une erreur est survenue lors de la modification");
	})
	
}