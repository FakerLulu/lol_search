window.onload=function(){
	let submitButton = document.getElementById('submit');
	let championsLoader = getChampionName();
	let championData;
	championsLoader.then((champsData)=>{
		championData = champsData;
		submitButton.addEventListener("click",summonerSearch);
	});

	function summonerSearch(){ 
		let summonerName = document.getElementById('summonerId').value.replace(/\s/gi, '');
		let count = document.getElementById('matchCount').value;
		
	    let address = './api/summonerMatches/?summonerName='+encodeURI(summonerName)+"&count="+count;
	    let xhttp = new XMLHttpRequest;
			xhttp.open('GET', address);
			xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
			xhttp.onreadystatechange = () => {
				if (xhttp.readyState === 4) {
					if (xhttp.status === 200) {
						let container = document.getElementsByClassName('smnInfo')[0];
						let matchList = document.getElementsByClassName('match-list')[0];
						let summonerData = JSON.parse(xhttp.response);
	                    container.innerHTML= "<img src=\'http://ddragon.leagueoflegends.com/cdn/10.4.1/img/profileicon/"+summonerData.profileIconId+".png'+\' alt=\'\' class=\'img-thumbnail\'>"
	                    						+"소환사 : "+decodeURI(summonerData.name)+"<br>"+
	                    						"레벨 : "+summonerData.summonerLevel+"<br>";
	                    let addMatches="";
	                    for(matchNum in summonerData.matches){
	                    	let thisGame = summonerData.matches[matchNum];
	                    	let date = new Date(thisGame.gameCreation+(1000*thisGame.gameDuration));
	                    	let smnPlayerId = getSummonerPlayerId(decodeURI(summonerData.name),thisGame.participantIdentities);
	                    	let playerTeam = getSummonerTeam(smnPlayerId,thisGame.participants);
	                    	
	                    	
	                    	addMatches+= "<li class=\"list-group-item\">"+"<h5>번호 "+matchNum+"    "+
	                    	thisGame.teams[playerTeam/100].win+"</h5>"+
	                    	"게임 시간 : "+date.getFullYear()+"."+(date.getMonth()+1)+"."+date.getDate()
	                    	+" "+date.getHours()+":"+date.getMinutes()+"<br>"+
	                    	"사용 챔피언 : "+findChamps(thisGame.champion)+"<br>"+
	                    	"게임 종류 : 시즌"+IsWhatSeason(thisGame.seasonId)+", "+IsWhatTypeGame(thisGame.queueId)+
	                    	"</li>"
	                    	
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
	
	function getChampionName(){ 
		//http://ddragon.leagueoflegends.com/cdn/[[롤 클라이언트 버전]].1/data/en_US/champion.json에서 갱신
		return new Promise((resolve) => {
			let address = './json/champion.json';
		    let xhttp = new XMLHttpRequest;
				xhttp.open('GET', address);
				xhttp.setRequestHeader("Content-type", "application/json");
				xhttp.onreadystatechange = () => {
					if (xhttp.readyState === 4) {
						if (xhttp.status === 200) {
							return resolve(JSON.parse(xhttp.response).data);
						} else {
							// location.href = location.origin + "/" +
							// location.pathname.split("/")[1] + "/error";
						}
					}
				};
	
				xhttp.send();
				xhttp.onreadystatechange();
		});
	    
	
	}
	
	function getSummonerPlayerId(name, participantInfo){
		for(player in participantInfo){
			if(participantInfo[player].player.summonerName === name){
				return player;
			}
		}		
	}
	
	function getSummonerTeam(id, participants){
		return participants[id].teamId;
	}
	
	
	function findChamps(number){
		const champsNo =number.toString();
		for(name in championData){
			if(championData[name].key===champsNo){
				return championData[name].name;
			}
		}
		
	}
	
	function IsWhatTypeGame(queueNo){
		// 주소 : https://developer.riotgames.com/game-constants.html
		switch(queueNo){
		case 900 : return "소환사의 협곡, URF모드";break;
		case 450 : return "칼바람나락, 무작위 총력전";break;
		case 400 : return "소환사의 협곡, 5 vs 5 교차선택";break;
		case 420 : return "소환사의 협곡, 솔로 랭크";break;
		case 430 : return "소환사의 협곡, 5 vs 5 비공개 픽";break;
		case 440 : return "소환사의 협곡, 5 vs 5 자유랭크";break;
		case 830 : return "소환사의 협곡, 입문봇";break;
		case 840 : return "소환사의 협곡, 초급봇";break;
		case 850 : return "소환사의 협곡, 중급봇";break;
				
		}	
	}
	
	function IsWhatSeason(seosonNo){
		// 주소 : https://developer.riotgames.com/game-constants.html
		switch(seosonNo){
		case 0 : return "프리시즌 3";break;
		case 1 : return "시즌 3";break;
		case 2 : return "프리시즌 4";break;
		case 3 : return "시즌 4";break;
		case 4 : return "프리시즌 5";break;
		case 5 : return "시즌 5";break;
		case 6 : return "프리시즌 6";break;
		case 7 : return "시즌 6";break;
		case 8 : return "프리시즌 7";break;
		case 9 : return "시즌 7";break;
		case 10 : return "프리시즌 8";break;
		case 11 : return "시즌 8";break;
		case 12 : return "프리시즌 9";break;
		case 13 : return "시즌 9";break;
		}
	}

}
