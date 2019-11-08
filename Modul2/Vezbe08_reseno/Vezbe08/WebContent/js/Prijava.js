function validacija() {
	var korisnickoIme = document.forms["prijava"].korisnickoIme.value;
	var lozinka = document.forms["prijava"].lozinka.value;

	if (korisnickoIme == "" || lozinka == "") {
		window.alert("Niste popunili sva polja!");
		return false;
	}

	return true;
}

function izlazakIzPolja(polje) {
	var celija = polje.parentNode;
	var sledecaCelija = celija.nextSibling;

	if (polje.value == "") {
		sledecaCelija.innerHTML = "Popuniti polje!";
	}
}

function ulazakUPolje(polje) {
	var celija = polje.parentNode;
	var sledecaCelija = celija.nextSibling;

	sledecaCelija.innerHTML = "";
}
