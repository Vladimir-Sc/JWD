$(document).ready(function() {
	var tabela = $("table");
	var celijaCena = $("td#cena");

	$.get("PrikaziKorpuServlet", function(odgovor) {
		console.log(odgovor);
		if (odgovor.status == "uspeh") {
			var tabela = $("table");

			tabela.find("tr").not(':first').not(':last').remove();
			for (var redniBrojStavke in odgovor.korpa.stavke) {
				var itStavka = odgovor.korpa.stavke[redniBrojStavke];
				$(
					'<tr>' + 
						'<td><a href="PrikaziProizvod.html?id=' + itStavka.proizvod.id + '">' + itStavka.proizvod.naziv + '</a></td>' + 
						'<td>' + itStavka.proizvod.cena + '</td>' + 
						'<td><a href="PrikaziKategoriju.html?id=' + itStavka.proizvod.kategorija.id + '">' + itStavka.proizvod.kategorija.naziv + '</a></td>' + 
						'<td>' + itStavka.komada + '</td>' + 
						'<td class="cena">' + itStavka.cena + '</td>' + 
						'<td><form class="uklanjanje"><input type="submit" value="Ukloni"/></form>' + 
						'</td>' + 
					'</tr>'
				).insertBefore(tabela.find("tr:last"));		
			}
			celijaCena.text(odgovor.korpa.cena);
		} else if (odgovor.prijavljen == false) {
			window.location.replace("Prijava.html");
		}
	});
	console.log("poslato!");

	tabela.submit("form.uklanjanje", function(event) {
		var forma = $(event.target);

		var red = forma.closest("tr");
		var redniBrojStavke = red.index() - 1;

		var parametri = {
				"redniBrojStavke": redniBrojStavke
		}
		console.log(parametri);
		$.post("UkloniIzKorpeServlet", parametri, function(odgovor) {	
			console.log(odgovor);
			if (odgovor.status == "uspeh") {	
				var cenaStavke = parseFloat(forma.closest("td").siblings("td.cena").text());
				celijaCena.text(parseFloat(celijaCena.text()) - cenaStavke);
			
				red.remove();
			} else {
				alert("Neuspešno uklanjanje!")
			}
		});
		return false;
	});
	$("form[name=praznjenje]").submit(function() {
		$.post("IsprazniKorpuServlet", function(odgovor) {
			console.log(odgovor);
			if (odgovor.status == "uspeh") {
				tabela.find("tr").not(":first").not(":last").remove();
				celijaCena.text("0");
			} else {
				alert("Neuspešno pražnjenje!")
			}
		});
		console.log("poslato!")
		
		return false;
	});
});