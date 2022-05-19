$(function() {
	let searchParams = new URLSearchParams(window.location.search);
	let id = searchParams.get('id')
	if (id == null){
		window.location = "fleur.html";
	}
	else{
		getAffFleur(id);
	}
});



function getAffFleur(id) {
    $("#errorFleur").css("display", "none");
    $.get("http://localhost:8080/tp-fleuriste/rs/fleurs/" + id, afficheFleur);
}




function afficheFleur(Fleur) {

    console.log(Fleur);
    $("#id").val(Fleur.id);
    $("#nomFleur").val(Fleur.nom);
    $('#nomFleur').prop('readonly', true);
    $("#tarifFleur").val(Fleur.tarif);
    $('#tarifFleur').prop('readonly', true);
    $("#quantiteFleur").val(Fleur.quantite);
    $('#quantiteFleur').prop('readonly', true);
    $("#infoFleur").val(Fleur.description);
    $('#infoFleur').prop('readonly', true);
    /*$("#urlImageFleur").val(Fleur.image);
    $('#urlImageFleur').prop('readonly', true);
    */
    $("#couleurFleur").val(Fleur.couleur);
    $('#couleurFleur').prop('readonly', true);
    $("#bAjoutFleur").hide();
}
