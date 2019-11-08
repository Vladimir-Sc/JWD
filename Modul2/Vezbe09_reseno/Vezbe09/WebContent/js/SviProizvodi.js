$(document).ready(function() {
	$("input.minus").click(function() {
		var polje = $(this).next();
		if (parseInt(polje.val()) <= 1) {
			polje.val(1);
		} else {
			polje.val(parseInt(polje.val()) - 1);
		}

		return false;
	});
	$("input.plus").click(function() {
		var polje = $(this).prev();
		polje.val(parseInt(polje.val()) + 1);

		return false;
	});
});