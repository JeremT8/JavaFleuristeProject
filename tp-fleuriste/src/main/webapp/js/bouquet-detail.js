$(function() {
	let searchParams = new URLSearchParams(window.location.search);
	let id = searchParams.get('id')
	if (id == null){
		window.location = "bouquet.html";
	}
	else{
		getAffBouquets(id);
	}
});



function getAffBouquets(id) {
    $("#errorBouquets").css("display", "none");
    $.get("http://localhost:8080/tp-fleuriste/rs/bouquets/" + id, afficheBouquets);
}




function afficheBouquets(bouquet) {

    console.log(bouquet);
    $("#id").val(bouquet.id);
    $("#nomBouquet").val(bouquet.nom);
    $('#nomBouquet').prop('readonly', true);
    $("#tarifBouquet").val(bouquet.tarif);
    $('#tarifBouquet').prop('readonly', true);
    $("#quantiteBouquet").val(bouquet.quantite);
    $('#quantiteBouquet').prop('readonly', true);
    $("#infoBouquet").val(bouquet.description);
    $('#infoBouquet').prop('readonly', true);
     $("#couleurBouquet").val(bouquet.couleur);
    $('#couleurBouquet').prop('readonly', true);
    $("#urlImageBouquet").val(bouquet.image);
    $('#urlImageBouquet').prop('readonly', true);
    $("#bAjoutBouquet").hide();
}
