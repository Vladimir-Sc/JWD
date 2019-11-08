$(document).ready(function() {
	// ovaj blok koda će se izvršiti odmah
	// GET zahtev: navodi se relativna staza do servlet-a, zatim parametri (ako postoje) i na kraju funkcija koja će da obradi odgovor tek kada on stigne
	$.get("SviProizvodiServlet", function(odgovor) {
		// ova funkcija će se izvršiti tek kada stigne odgovor
		console.log(odgovor); // primetiti u konzoli da se ova poruka ispisuje tek onda kada stigne odgovor
		if (odgovor.status == "uspeh") {
			var tabela = $("table");

			tabela.find("tr:gt(0)").remove(); // uklanjanje svih redova iz tabele osim prvog
			// dodavanje novih redova u tabelu
			for (var it in odgovor.proizvodi) { // kroz JSON listu se iterira po indeksima
				var itProizvod = odgovor.proizvodi[it];
				tabela.append(
					'<tr>' + 
						'<td><a href="PrikaziProizvod.html?id=' + itProizvod.id + '">' + itProizvod.naziv + '</a></td>' + 
						'<td>' + itProizvod.cena + '</td>' + 
						'<td><a href="PrikaziKategoriju.html?id=' + itProizvod.kategorija.id + '">' + itProizvod.kategorija.naziv + '</a></td>' + 
						'<td>' + 
							'<form class="korpa">' + 
								'<input type="hidden" name="proizvodID" value="' + itProizvod.id + '"/>' + 
								'<input type="text" name="komada" value="1"/>' + 
								'<input type="submit" value="U korpu"/>' + 
							'</form>' + 
						'</td>' + 
					'</tr>'
				);
			}
		}
	});
	console.log("poslato!"); // primetiti u konzoli da se prvo ispiše ova poruka (ova naredba se izvršava pre tela funkcije koja obrađuje odgovor)

	// pre nego što se tabela proizvoda popuni, forme za dodavanje u korpu ne postoje
	// funkcija koja će reagovati na submit formi za dodavanje u korpu se kači za prvog njihovog roditelja koji postoji u momentu učitavanja HTML dokumenta, a to je tabela
	// tabela se ne kešira jer je potrebno samo jednom zakačiti funkciju koja će reagovati na submit
	$("table").submit("form.korpa", function(event) {
		// ova funkcija će se izvršiti samo ukoliko se klikne na submit formi za dodavanje u korpu
		// kada se funkcija koja obrađuje događaj registuje na ovaj način, elementu se ne može pristupati preko this, već preko event.target
		var forma = $(event.target);
		// čitanje vrednosti iz polja
		var proizvodID = forma.find("input[name=proizvodID]").val();
		var komada = forma.find("input[name=komada]").val();

		var parametri = {
				"proizvodID": proizvodID, 
				"komada": komada
		}
		console.log(parametri);
		$.post("DodajUKorpuServlet", parametri, function(odgovor) {
			// ova funkcija će se izvršiti tek kada stigne odgovor
			console.log(odgovor); // primetiti u konzoli da se ova poruka ispisuje tek onda kada stigne odgovor
			if (odgovor.status == "uspeh") {
				 // kada se pravi AJAX aplikacija, frontend inicira redirekciju
				window.location.replace("PrikaziKorpu.html");
			} else if (odgovor.prijavljen == false) {
				window.location.replace("Prijava.html");
			} else {
				alert("Neuspešno dodavanje u korpu!");
			}
		});
		console.log("poslato!"); // primetiti u konzoli da se prvo ispiše ova poruka (ova naredba se izvršava pre tela funkcije koja obrađuje odgovor)

		return false;
	});
});