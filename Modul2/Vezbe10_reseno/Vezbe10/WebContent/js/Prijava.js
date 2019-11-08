$(document).ready(function() {
	// keširanje varijabli (ako ih je potrebno više puta koristi na ovoj stranici: svaki put kada se pokuša prijava)
	var poljeKorisnickoIme = $("input[name=korisnickoIme]");
	var poljeLozinka = $("input[name=lozinka]");

	// forma se ne kešira jer je potrebno samo jednom zakačiti funkciju koja će reagovati na submit
	$("form[name=prijava]").submit(function() {
		// ova funkcija će se izvršiti samo ukoliko se klikne na submit
		// čitanje vrednosti iz polja
		var korisnickoIme = poljeKorisnickoIme.val();
		var lozinka = poljeLozinka.val();

		// pravljenje JSON objekta: parovi "ključ: vrednost; ključevi odgovaraju nazivima parametara koje očekuje servlet
		var parametri = {
			"korisnickoIme": korisnickoIme, 
			"lozinka": lozinka
		}
		console.log(parametri);
		// POST zahtev: navodi se relativna staza do servlet-a, zatim parametri (ako postoje) i na kraju funkcija koja će da obradi odgovor tek kada on stigne
		$.post("PrijavaServlet", parametri, function(odgovor) {
			// ova funkcija će se izvršiti tek kada stigne odgovor
			console.log(odgovor); // primetiti u konzoli da se ova poruka ispisuje tek onda kada stigne odgovor
			if (odgovor.status == "uspeh") {
				 // kada se pravi AJAX aplikacija, frontend inicira redirekciju
				window.location.replace("Pocetna.html");
			} else {
				alert("Neuspešna prijava!");
			}
		});
		console.log("poslato!"); // primetiti u konzoli da se prvo ispiše ova poruka (ova naredba se izvršava pre tela funkcije koja obrađuje odgovor)

		return false; // sprečiti da klik na link osveži stranicu
	});
});