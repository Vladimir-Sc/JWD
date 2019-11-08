function validacija() {
	var naziv = document.forms["dodavanje"].naziv.value;
	var cena = document.forms["dodavanje"].cena.value;

	if (naziv == "") {
		window.alert("Niste popunili naziv!");
		return false;
	}
	if (isNaN(cena) || cena <= 0) {
		window.alert("Cena mora biti pozitivan broj!");
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