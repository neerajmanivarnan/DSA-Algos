var reviews = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10];
var total = 0;
for (var i = 0; i < reviews.length; i++) {
    total += reviews[i];
}
console.log("The sum is ".concat(total, " and the average is ").concat(total / 10));
