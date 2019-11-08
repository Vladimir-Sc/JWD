$(document).ready(function() {
	var poljeKorisnickoIme = $("input[name=imeprezime]");
	var poljeKM = $("input[name=kmpredjeni]");
	var poljeVreme = $("input[name=vrememin]");
	var poljeZavrs = $("input[name=zavtrka]");
	var poljeTipUcesnika = $("input[name=tipUcesnika]");
	var poljeNapomena = $('textarea#napomena');
	var poljeTipUcesca = $("#selTip");
	
	$("form[name=prikaz]").submit(function() {
		var korisnickoIme = poljeKorisnickoIme.val();
		var kilometri = poljeKM.val();
		var vreme = poljeVreme.val();
		var zavrseno = poljeZavrs.val();
		var tipUcesnika = poljeTipUcesnika.val();
		var napomena = poljeNapomena.val();
		var tipUcesca = poljeTipUcesca.val();

		var parametri = {
				
				
				 "korisnickoIme" : korisnickoIme,
				 "kilometri" : kilometri,
				 "vreme": vreme,
				 "zavrseno" : zavrseno,
				 "tipUcesnika" : tipUcesnika,
				 "napomena" : napomena,
				 "tipUcesca" : tipUcesca
				
				
		}
		console.log(parametri);
		$.post("PrikazUcesnikaAjax", parametri, function(odgovor) {
			console.log(odgovor);
			if (odgovor.status == "uspeh") {
				window.location.replace("PrikazUcesnikaAjax.html");
			} else {
				alert("Neuspešna registracija!");
			}
		});
		console.log("poslato!");
		
		return false;
	});
});
