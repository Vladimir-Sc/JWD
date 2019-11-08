$(document).ready(function() {
	var selectKategorijaID = $("select[name=kategorijaID]");

	// ovaj blok koda će se izvršiti odmah
	// GET zahtev: navodi se relativna staza do servlet-a, zatim parametri (ako postoje) i na kraju funkcija koja će da obradi odgovor tek kada on stigne
	$.get("PrikaziDodavanjeProizvodaServlet", function(odgovor) {
		// ova funkcija će se izvršiti tek kada stigne odgovor
		console.log(odgovor); // primetiti u konzoli da se ova poruka ispisuje tek onda kada stigne odgovor
		if (odgovor.status == "uspeh") {
			selectKategorijaID.empty(); // uklanjanje svih podelemenata select-a
			// dodavanje novih option-a u select
			for (var it in odgovor.kategorije) {
				var itKategorija = odgovor.kategorije[it];
				selectKategorijaID.append('<option value="' + itKategorija.id + '">' + itKategorija.naziv + '</option>');
			}
		}
	});
	console.log("poslato!"); // primetiti u konzoli da se prvo ispiše ova poruka (ova naredba se izvršava pre tela funkcije koja obrađuje odgovor)

	var poljeNaziv = $("input[name=naziv]");
	var poljeCena= $("input[name=cena]");
	$("form[name=dodavanje]").submit(function() {
		var naziv = poljeNaziv.val();
		var cena = poljeCena.val();
		var kategorijaID = selectKategorijaID.val();

		var parametri = {
				"naziv": naziv, 
				"cena": cena, 
				"kategorijaID": kategorijaID
		}
		$.post("DodajProizvodServlet", parametri, function(odgovor) {
			console.log(odgovor);
			if (odgovor.status == "uspeh") {
				window.location.replace("SviProizvodi.html");
			} else {
				alert("Dodavanje neuspešno!")
			}
		});
		console.log("poslato!")
		
		return false;
	});
});