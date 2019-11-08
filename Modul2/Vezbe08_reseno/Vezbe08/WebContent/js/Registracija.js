function validacija() {
	var korisnickoIme = document.forms["registracija"].korisnickoIme.value;
	var lozinka = document.forms["registracija"].lozinka.value;
	var ponovljenaLozinka = document.forms["registracija"].ponovljenaLozinka.value;

	if (korisnickoIme == "" || lozinka == "" || ponovljenaLozinka == "") {
		window.alert("Niste popunili sva polja!");
		return false;
	}
	if (lozinka != ponovljenaLozinka) {
		window.alert("Lozinke se ne podudaraju!");
		return false;
	}
	if (korisnickoIme.match("^[a-zA-Z0-9]+$") == null) {
		window.alert("Korisničko ime sme da sadrži samo alfanumeričke karaktere!");
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