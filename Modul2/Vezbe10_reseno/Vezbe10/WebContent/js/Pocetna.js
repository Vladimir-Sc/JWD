$(document).ready(function() {
	// keširanje varijabli (ako ih je potrebno više puta koristi na ovoj stranici: jednom na početku i jednom pri odjavi)
	var linkoviPrijavljen = $("a.prijavljen");
	var linkoviOdjavljen = $("a.odjavljen");

	// ovaj blok koda će se izvršiti odmah
	// GET zahtev: navodi se relativna staza do servlet-a, zatim parametri (ako postoje) i na kraju funkcija koja će da obradi odgovor tek kada on stigne
	$.get("PocetnaServlet", function(odgovor) {
		// ova funkcija će se izvršiti tek kada stigne odgovor
		console.log(odgovor); // primetiti u konzoli da se ova poruka ispisuje tek onda kada stigne odgovor
		if (odgovor.prijavljen) {
			linkoviPrijavljen.show();
			linkoviOdjavljen.hide();
		} else {
			linkoviPrijavljen.hide();
			linkoviOdjavljen.show();
		}
	});
	console.log("poslato!") // primetiti u konzoli da se prvo ispiše ova poruka (ova naredba se izvršava pre tela funkcije koja obrađuje odgovor)
	
	// link se ne kešira jer je potrebno samo jednom zakačiti funkciju koja će reagovati na click
	$("#linkOdjava").click(function(odgovor) {
		// ova funkcija će se izvršiti samo ukoliko se klikne na link
		// POST zahtev: navodi se relativna staza do servlet-a, zatim parametri (ako postoje) i na kraju funkcija koja će da obradi odgovor tek kada on stigne
		$.post("OdjavaServlet", function(odgovor) {
			// ova funkcija će se izvršiti tek kada stigne odgovor
			console.log(odgovor); // primetiti u konzoli da se ova poruka ispisuje tek onda kada stigne odgovor
			if (odgovor.status == "uspeh") {
				linkoviPrijavljen.hide();
				linkoviOdjavljen.show();
			} else {
				alert("Neuspešna odjava!");
			}
		});
		console.log("poslato!"); // primetiti u konzoli da se prvo ispiše ova poruka (ova naredba se izvršava pre tela funkcije koja obrađuje odgovor)

		return false; // sprečiti da klik na link osveži stranicu
	});
});