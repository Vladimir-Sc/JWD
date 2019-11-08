$(document).ready(function() {
	var poljeKorisnickoIme = $("input[name=korisnickoIme]");
	var poljeLozinka = $("input[name=lozinka]");
	var poljePonovljenaLozinka = $("input[name=ponovljenaLozinka]");

	var pasusUpozorenje = $("p.upozorenje");
	pasusUpozorenje.hide();

	$("form[name=registracija]").submit(function() {
		var korisnickoIme = poljeKorisnickoIme.val();
		var lozinka = poljeLozinka.val();
		var ponovljenaLozinka = poljePonovljenaLozinka.val();
		
		if (korisnickoIme == "" || lozinka == "" || ponovljenaLozinka == "") {
			pasusUpozorenje.text("Niste popunili sva polja!");
			pasusUpozorenje.slideDown();
			return false;
		}
		if (lozinka != ponovljenaLozinka) {
			pasusUpozorenje.text("Lozinke se ne podudaraju!");
			pasusUpozorenje.slideDown();
			return false;
		}
		if (korisnickoIme.match("^[a-zA-Z0-9]+$") == null) {
			pasusUpozorenje.text("Korisniko ime može da sadrži samo alfanumeričke karaktere!");
			pasusUpozorenje.slideDown();
			return false;
		}
		
		return true;
	});

	var polja = $("input[type=text], input[type=password]");
	polja.focus(function() {
		pasusUpozorenje.slideUp();	
		$(this).removeClass("nevalidan");
	});
	polja.blur(function() {
		var polje = $(this);
		if (polje.val() == "") {
			polje.addClass("nevalidan");
		}
	});
});