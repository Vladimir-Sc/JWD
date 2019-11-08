$(document).ready(function() {
	// ovaj blok koda će se izvršiti odmah
	// GET zahtev: navodi se relativna staza do servlet-a, zatim parametri (ako postoje) i na kraju funkcija koja će da obradi odgovor tek kada on stigne
	$.get("SveKategorijeServlet", function(odgovor) {
		// ova funkcija će se izvršiti tek kada stigne odgovor
		console.log(odgovor); // primetiti u konzoli da se ova poruka ispisuje tek onda kada stigne odgovor
		if (odgovor.status == "uspeh") {
			var tabela = $("table");

			tabela.find("tr:gt(0)").remove(); // uklanjanje svih redova iz tabele osim prvog
			// dodavanje novih redova u tabelu
			for (var it in odgovor.kategorije) { // kroz JSON listu se iterira po indeksima
				var itKategorija = odgovor.kategorije[it];
				tabela.append('<tr><td><a href="PrikaziKategoriju.html?id=' + itKategorija.id + '">' + itKategorija.naziv + '</a></td></tr>');
			}
		}
	});
	console.log("poslato!"); // primetiti u konzoli da se prvo ispiše ova poruka (ova naredba se izvršava pre tela funkcije koja obrađuje odgovor)
});