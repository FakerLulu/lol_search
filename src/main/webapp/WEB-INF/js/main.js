
// api 호출 예제 => https://kr.api.riotgames.com/lol/summoner/v4/summoners/by-name/%ED%8C%9D%ED%8C%9D%EA%B0%A4%EB%9F%AD%EC%8B%9C%ED%8C%9D?api_key=RGAPI-d39bcc21-f5ec-4dc0-9f84-f8c5434636ea


    let address = 'https://kr.api.riotgames.com/lol/summoner/v4/summoners/by-name/%ED%8C%9D%ED%8C%9D%EA%B0%A4%EB%9F%AD%EC%8B%9C%ED%8C%9D?api_key=RGAPI-35599e02-2c9a-4851-a559-de69a9c33ee8';
    let xhttp = new XMLHttpRequest;
		xhttp.open('GET', address);
		xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
		xhttp.onreadystatechange = () => {
			if (xhttp.readyState === 4) {
				if (xhttp.status === 200) {
					console.log(xhttp.response);
					let container = document.getElementsByClassName('container')[0];
                    container.innerHTML=xhttp.responseText;
				} else {
					// location.href = location.origin + "/" +
					// location.pathname.split("/")[1] + "/error";
				}
			}
		};

		xhttp.send();
		xhttp.onreadystatechange();
