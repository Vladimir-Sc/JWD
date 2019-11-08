$(document).ready(function() {
	var poljeKorisnickoIme = $("input[name=korisnickoIme]");
	var poljeLozinka = $("input[name=lozinka]");

	var pasusUpozorenje = $("p.upozorenje");
	pasusUpozorenje.hide();

	$("form[name=prijava]").submit(function() {
		var korisnickoIme = poljeKorisnickoIme.val();
		var lozinka = poljeLozinka.val();
		
		if (korisnickoIme == "" || lozinka == "") {
			pasusUpozorenje.text("Niste popunili sva polja!");
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