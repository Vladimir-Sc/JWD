$(document).ready(function() {
	var poljeNaziv = $("input[name=naziv]");

	var pasusUpozorenje = $("p.upozorenje");
	pasusUpozorenje.hide();

	$("form[name=izmena]").submit(function() {
		var naziv = poljeNaziv.val();
		
		if (naziv == "") {
			pasusUpozorenje.text("Niste popunili sva polja!");
			pasusUpozorenje.slideDown();
			return false;
		}
		
		return true;
	});
	$("form[name=brisanje]").submit(function() {	
		return confirm("Da li ste sigurni?")
	});

	var polja = $("input[type=text]");
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