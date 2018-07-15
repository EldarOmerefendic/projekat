function login() {
	var username = document.getElementById("username").value;
	var password = document.getElementById("userpass").value
	var xhr;

	if (!username) {
		alert("Korisnicko ime ne moze biti prazno.");
		return;
	}
	if (!password) {
		alert("Password ne moze biti prazan.");
		return;
	}

	xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function () {
		if (xhr.readyState != 4 || !xhr.responseText) {
			return;
		}

		if (xhr.status === 200) {
			// console.log(xhr.responseText);	-- comment out when needed for debugging
			var response = JSON.parse(xhr.responseText);
			if (response != null && response["status"] == 1) {
				window.location = "admin/home"
			} else {
				alert("Dogodila se greska");
			}
			return;
		} else {
			var error = "Dogodila se greska";
			if (xhr != null && xhr.responseText != null) {
				var response = JSON.parse(xhr.responseText);
				if (response != null && response["message"] != null) {
					error = response["message"];
				}
			}
			alert(error);
			return;
		}
	};

	xhr.open("POST", "http://localhost:8080/projekat/login");
	xhr.setRequestHeader("Content-Type", "application/json");
	xhr.send(JSON.stringify({
		username: username,
		password: password
	}));
}