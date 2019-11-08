$(document).ready(function() {
	var poljeNaziv = $("input[name=naziv]");
	var poljeCena = $("input[name=cena]");
	var selectKategorijaID = $("select[name=kategorijaID]");

	var id = window.location.search.slice(1).split('&')[0].split('=')[1];

	var parametri = {
			"id": id	
	}
	console.log(parametri);
	$.get("PrikaziProizvodServlet", parametri, function(odgovor) {
		console.log(odgovor);
		if (odgovor.status == "uspeh") {
			poljeNaziv.val(odgovor.proizvod.naziv);
			poljeCena.val(odgovor.proizvod.cena);
			
			selectKategorijaID.empty();
			for (var it in odgovor.kategorije) {
				var itKategorija = odgovor.kategorije[it];
				if (itKategorija.id == odgovor.proizvod.kategorija.id) {
					selectKategorijaID.append('<option value="' + itKategorija.id + '" selected>' + itKategorija.naziv + '</option>');
				} else {
					selectKategorijaID.append('<option value="' + itKategorija.id + '">' + itKategorija.naziv + '</option>');
				}
			}
		}
	});
	console.log("poslato!");

	$("form[name=izmena]").submit(function() {
		var naziv = poljeNaziv.val();
		var cena = poljeCena.val();
		var kategorijaID = selectKategorijaID.val();

		var parametri = {
				"id": id, 
				"naziv": naziv, 
				"cena": cena, 
				"kategorijaID": kategorijaID
		}
		$.post("IzmeniProizvodServlet", parametri, function(odgovor) {
			console.log(odgovor);
			if (odgovor.status == "uspeh") {
				window.location.replace("SviProizvodi.html");
			} else {
				alert("Neuspešna izmena!")
			}
		});
		console.log("poslato!")
		
		return false;
	});
	$("form[name=brisanje]").submit(function() {
		var parametri = {
				"id": id
		}
		$.post("ObrisiProizvodServlet", parametri, function(odgovor) {
			console.log(odgovor);
			if (odgovor.status == "uspeh") {
				window.location.replace("SviProizvodi.html");
			} else {
				alert("Neuspešno brisanje!")
			}
		});
		console.log("poslato!")
		
		return false;
	});
});