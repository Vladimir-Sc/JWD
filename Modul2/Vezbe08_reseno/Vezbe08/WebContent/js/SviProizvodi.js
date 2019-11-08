function klikNaMinus(dugme) {
	var polje = dugme.nextSibling.nextSibling;
	if (parseInt(polje.value) <= 1) {
		polje.value = 1;
	} else {
		polje.value = parseInt(polje.value) - 1;
	}
	
	return false;
}

function klikNaPlus(dugme) {
	var polje = dugme.previousSibling.previousSibling;
	polje.value = parseInt(polje.value) + 1;

	return false;
}