let sports: string[] = ["badminton","cricket","football"];

for(let sport of sports){
	if(sport == 'badminton'){
		console.log("This is my favorite -> "+sport);
	}else{
		console.log(sport);
	}
}

sports.push("Hockey");
sports.push("Fooseball");


for(let sport of sports){
	console.log(sport);
}

