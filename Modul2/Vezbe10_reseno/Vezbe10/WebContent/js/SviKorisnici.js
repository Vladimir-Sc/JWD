$(document).ready(function() {
	$.get("SviKorisniciServlet", function(odgovor) {
		console.log(odgovor);
		if (odgovor.status == "uspeh") {
			var table = $("table");

			table.find("tr:gt(0)").remove();
			for (var it in odgovor.korisnici) {
				var itKorisnik = odgovor.korisnici[it];
				table.append('<tr><td><a href="PrikaziKorisnika.html?korisnickoIme=' + itKorisnik.korisnickoIme + '>' + itKorisnik.korisnickoIme + '</a></td></tr>');
			}
		}
	});
	console.log("poslato!");
});