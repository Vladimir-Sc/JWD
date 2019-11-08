function validacija() {
	var naziv = document.forms["izmena"].naziv.value;

	if (naziv == "") {
		window.alert("Niste popunili naziv!");
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

function potvrdaOBrisanju() {
	return confirm("Da li ste sigurni?");
}