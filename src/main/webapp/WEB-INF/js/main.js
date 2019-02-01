
// api 호출 예제 => https://kr.api.riotgames.com/lol/summoner/v4/summoners/by-name/%ED%8C%9D%ED%8C%9D%EA%B0%A4%EB%9F%AD%EC%8B%9C%ED%8C%9D?api_key=RGAPI-d39bcc21-f5ec-4dc0-9f84-f8c5434636ea
let submitButton = document.getElementById('submit');

submitButton.addEventListener("click",summonerSearch);



function summonerSearch(){ 
	let summonerName = document.getElementById('summonerId').value.replace(/\s/gi, '');
	let count = document.getElementById('matchCount').value;
	
    let address = 'http://localhost:8080/lolStatus/api/summonerMatches/?summonerName='+encodeURI(summonerName)+"&count="+count;
    let xhttp = new XMLHttpRequest;
		xhttp.open('GET', address);
		xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
		xhttp.onreadystatechange = () => {
			if (xhttp.readyState === 4) {
				if (xhttp.status === 200) {
					console.log(xhttp.response);
					let container = document.getElementsByClassName('smnInfo')[0];
					let matchList = document.getElementsByClassName('match-list')[0];
					JSON.parse(xhttp.response);
                    container.innerHTML= "소환사 : "+decodeURI(summonerData.name)+"<br>"+
                    						"레벨 : "+summonerData.summonerLevel+"<br>";
                    let addMatches="";
                    for(matchNum in summonerData.matches){
                    	addMatches+= "<li class=\"list-group-item\">"+"<h5>번호 "+matchNum+"</h5> 사용 챔피언 : "+summonerData.matches[matchNum].champion+"</li>"
                    }
                    matchList.innerHTML = addMatches;
				} else {
					// location.href = location.origin + "/" +
					// location.pathname.split("/")[1] + "/error";
				}
			}
		};

		xhttp.send();
		xhttp.onreadystatechange();

}

/*function getChampionName(name){ 

    let address = 'http://ddragon.leagueoflegends.com/cdn/6.24.1/data/en_US/champion.json';
    let xhttp = new XMLHttpRequest;
		xhttp.open('GET', address);
		xhttp.setRequestHeader("Content-type", "application/json");
		xhttp.onreadystatechange = () => {
			if (xhttp.readyState === 4) {
				if (xhttp.status === 200) {
					const chmpions = JSON.parse(xhttp.response).data;
					let men = chmpions.filter(function (chmpions) { return chmpions.key == 56 });
					console.log(men[0].name);
				} else {
					// location.href = location.origin + "/" +
					// location.pathname.split("/")[1] + "/error";
				}
			}
		};

		xhttp.send();
		xhttp.onreadystatechange();

}*/