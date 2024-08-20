var sports = ["badminton", "cricket", "football"];
for (var _i = 0, sports_1 = sports; _i < sports_1.length; _i++) {
    var sport = sports_1[_i];
    if (sport == 'badminton') {
        console.log("This is my favorite -> " + sport);
    }
    else {
        console.log(sport);
    }
}
sports.push("Hockey");
sports.push("Fooseball");
for (var _a = 0, sports_2 = sports; _a < sports_2.length; _a++) {
    var sport = sports_2[_a];
    console.log(sport);
}
