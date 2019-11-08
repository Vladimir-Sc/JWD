$(document).ready(function() {
	// keširanje varijabli (ako ih je potrebno više puta koristi na ovoj stranici: svaki put kada se pokuša izmena)
	var poljeNaziv = $("input[name=naziv]");

	// ovaj blok koda će se izvršiti odmah
	var id = window.location.search.slice(1).split('&')[0].split('=')[1]; // čitanje vrednosti prvog parametra GET zahteva na ovu stranicu (id-a u ovom slučaju)
	// pravljenje JSON objekta: parovi "ključ: vrednost; ključevi odgovaraju nazivima parametara koje očekuje servlet
	var parametri = {
			"id": id	
	}
	console.log(parametri);
	// GET zahtev: navodi se relativna staza do servlet-a, zatim parametri (ako postoje) i na kraju funkcija koja će da obradi odgovor tek kada on stigne
	$.get("PrikaziKategorijuServlet", parametri, function(odgovor) {
		// ova funkcija će se izvršiti tek kada stigne odgovor
		console.log(odgovor); // primetiti u konzoli da se ova poruka ispisuje tek onda kada stigne odgovor
		if (odgovor.status == "uspeh") {
			poljeNaziv.val(odgovor.kategorija.naziv); // popunjavanje polja postojećom vrednošću naziva kategorije
		}
	});
	console.log("poslato!"); // primetiti u konzoli da se prvo ispiše ova poruka (ova naredba se izvršava pre tela funkcije koja obrađuje odgovor)

	// forma se ne kešira jer je potrebno samo jednom zakačiti funkciju koja će reagovati na submit
	$("form[name=izmena]").submit(function() {
		// ova funkcija će se izvršiti samo ukoliko se klikne na submit
		// čitanje vrednosti iz polja
		var naziv = poljeNaziv.val();

		// pravljenje JSON objekta: parovi "ključ: vrednost; ključevi odgovaraju nazivima parametara koje očekuje servlet
		var parametri = {
				"id": id, 
				"naziv": naziv
		}
		console.log(parametri);
		$.post("IzmeniKategorijuServlet", parametri, function(odgovor) {
			// ova funkcija će se izvršiti tek kada stigne odgovor
			console.log(odgovor); // primetiti u konzoli da se ova poruka ispisuje tek onda kada stigne odgovor
			if (odgovor.status == "uspeh") {
				 // kada se pravi AJAX aplikacija, frontend inicira redirekciju
				window.location.replace("SveKategorije.html");
			} else {
				alert("Neuspešna izmena!");
			}
		});
		console.log("poslato!"); // primetiti u konzoli da se prvo ispiše ova poruka (ova naredba se izvršava pre tela funkcije koja obrađuje odgovor)
		
		return false;
	});
	// forma se ne kešira jer je potrebno samo jednom zakačiti funkciju koja će reagovati na submit
	$("form[name=brisanje]").submit(function() {
		// ova funkcija će se izvršiti samo ukoliko se klikne na submit

		// pravljenje JSON objekta: parovi "ključ: vrednost; ključevi odgovaraju nazivima parametara koje očekuje servlet
		var parametri = {
				"id": id, 
		}
		console.log(parametri);
		$.post("ObrisiKategorijuServlet", parametri, function(odgovor) {
			// ova funkcija će se izvršiti tek kada stigne odgovor
			console.log(odgovor); // primetiti u konzoli da se ova poruka ispisuje tek onda kada stigne odgovor
			if (odgovor.status == "uspeh") {
				 // kada se pravi AJAX aplikacija, frontend inicira redirekciju
				window.location.replace("SveKategorije.html");
			} else {
				alert("Neuspešno brisanje!");
			}
		});
		console.log("poslato!"); // primetiti u konzoli da se prvo ispiše ova poruka (ova naredba se izvršava pre tela funkcije koja obrađuje odgovor)
		
		return false;
	});
});