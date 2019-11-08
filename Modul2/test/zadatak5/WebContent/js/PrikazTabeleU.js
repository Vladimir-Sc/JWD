$(document).ready(function() {
	
	
	
	$.get("PrikazTabeleU", function(odgovor) {
		console.log(odgovor);
		if (odgovor.status == "uspeh") {
			var table = $("table");

			table.find("tr:gt(0)").remove();
			for (var it in odgovor.korisnici) {
				var itKorisnik = odgovor.korisnici[it];
				table.append('<tr><td>' + itKorisnik.imePrezime + '</td>'
						+ '<td>' + itKorisnik.brKm + '</td>'
						+ '<td>' + itKorisnik.vremeMin + '</td>'
						+ '<td>' + itKorisnik.tipUcesnika + '</td>'
						+ '<td>' + itKorisnik.zavrsioTrku + '</td>'
						+ '<td>' + itKorisnik.napomena + '</td>'
						+ '<td>' + itKorisnik.tipUcesca.naziv + '</td>'
						+ '</tr>');
			}
		}
	});
	console.log("poslato!");
}); 