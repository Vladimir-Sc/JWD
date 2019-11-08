function promenaBoje() {
	var zaglavlje = document.getElementById("zaglavlje");
	zaglavlje.style.color = "hsl(" + Math.random()*360 + ", 100%, 50%)";

	return false;
}