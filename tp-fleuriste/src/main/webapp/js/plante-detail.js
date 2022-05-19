$(function() {
	let searchParams = new URLSearchParams(window.location.search);
	let id = searchParams.get('id')
	if (id == null){
		window.location = "plante.html";
	}
	else{
		getAffPlante(id);
	}
});



function getAffPlante(id) {
    $("#errorPlante").css("display", "none");
    $.get("http://localhost:8080/tp-fleuriste/rs/plantes/" + id, affichePlante);
}




function affichePlante(plante) {

    console.log(plante);
    $("#id").val(plante.id);
    $("#nomPlante").val(plante.nom);
    $('#nomPlante').prop('readonly', true);
    $("#tarifPlante").val(plante.tarif);
    $('#tarifPlante').prop('readonly', true);
    $("#quantitePlante").val(plante.quantite);
    $('#quantitePlante').prop('readonly', true);
    $("#infoPlante").val(plante.description);
    $('#infoPlante').prop('readonly', true);
    $("#urlImagePlante").val(plante.image);
    $('#urlImagePlante').prop('readonly', true);
    $("#bAjoutPlante").hide();
}
