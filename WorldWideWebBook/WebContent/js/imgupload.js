function getExtension(filename) {
	var extension = filename.split('.').pop();
	return extension;
}
function readURL(input, img) {

	if (input.files && input.files[0]) {
		var ext = $.trim(getExtension(input.files[0].name));

		if (ext === "jpg" || ext === "jpeg" || ext === "png" || ext === "gif"
				|| ext === "bmp") {
			var reader = new FileReader();

			reader.onload = function(e) {

				img.attr('src', e.target.result);
			}

			reader.readAsDataURL(input.files[0]);
		}
	}
}

$(document).ready(function() {

	$("input").change(function(e) {

		var img = $(e.target).closest('div').children('img');
		readURL(this, img);

	});

	$(document).on('click', '.full-size', function(e) {
		showFullSize(e);
	});
	$(document).on('click', 'img', function(e) {

		var img = $(e.target);
		var uploader = img.closest('div').children('input');

		uploader.click();

	});

	$(document).on('click', '.delete-image', function(e) {
		var img = $(e.target).closest('div').children('img');
		var input = $(e.target).closest('div').children('input');
		img.attr('src', 'img/generic.png');
		input.val("");

	});
});

function showFullSize(e) {

	var img = $(e.target).closest('div').children('img');

	var modal = $('#modal01');
	modal.children('img').attr('src', img.attr('src'));
	modal.css('display', 'block');
}
