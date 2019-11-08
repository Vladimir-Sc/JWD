$(document).ready(function() {
	var poljeKorisnickoIme = $("input[name=korisnickoIme]");
	var poljeLozinka = $("input[name=lozinka]");
	var poljePonovljenaLozinka = $("input[name=ponovljenaLozinka]");

	$("form[name=registracija]").submit(function() {
		var korisnickoIme = poljeKorisnickoIme.val();
		var lozinka = poljeLozinka.val();
		var ponovljenaLozinka = poljePonovljenaLozinka.val();

		var parametri = {
				"korisnickoIme": korisnickoIme, 
				"lozinka": lozinka, 
				"ponovljenaLozinka": ponovljenaLozinka
		}
		console.log(parametri);
		$.post("RegistracijaServlet", parametri, function(odgovor) {
			console.log(odgovor);
			if (odgovor.status == "uspeh") {
				window.location.replace("Prijava.html");
			} else {
				alert("Neuspešna registracija!");
			}
		});
		console.log("poslato!");
		
		return false;
	});
});