$(document).ready(function() {
	var korisnickoIme = window.location.search.slice(1).split('&')[0].split('=')[1];
	
	var parametri = {
			"korisnickoIme": korisnickoIme
	}
	console.log(parametri);
	$.get("PrikaziKorisnikaServlet", parametri, function(odgovor) {
		console.log(odgovor);
		if (odgovor.status == "uspeh") {
			$("input").val(odgovor.korisnik.korisnickoIme);
		}
	});
	console.log("poslato!");
});