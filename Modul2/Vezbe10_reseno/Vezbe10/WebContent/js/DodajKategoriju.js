$(document).ready(function() {
	// keširanje varijabli (ako ih je potrebno više puta koristi na ovoj stranici: svaki put kada se pokuša dodavanje)
	var poljeNaziv = $("input[name=naziv]");

	// forma se ne kešira jer je potrebno samo jednom zakačiti funkciju koja će reagovati na submit
	$("form[name=dodavanje]").submit(function() {
		// ova funkcija će se izvršiti samo ukoliko se klikne na submit
		// čitanje vrednosti iz polja
		var naziv = poljeNaziv.val();

		// pravljenje JSON objekta: parovi "ključ: vrednost; ključevi odgovaraju nazivima parametara koje očekuje servlet
		var parametri = {
				"naziv": naziv
		}
		console.log(parametri);
		// POST zahtev: navodi se relativna staza do servlet-a, zatim parametri (ako postoje) i na kraju funkcija koja će da obradi odgovor tek kada on stigne
		$.post("DodajKategorijuServlet", parametri, function(odgovor) {
			// ova funkcija će se izvršiti tek kada stigne odgovor
			console.log(odgovor); // primetiti u konzoli da se ova poruka ispisuje tek onda kada stigne odgovor
			if (odgovor.status == "uspeh") {
				 // kada se pravi AJAX aplikacija, frontend inicira redirekciju
				window.location.replace("SveKategorije.html");
			} else {
				alert("Neuspešno dodavanje!");
			}
		});
		console.log("poslato!"); // primetiti u konzoli da se prvo ispiše ova poruka (ova naredba se izvršava pre tela funkcije koja obrađuje odgovor)
		
		return false;
	});
});