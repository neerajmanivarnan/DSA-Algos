

let reviews: number[] = [1,2,3,4,5,6,7,8,9,10];

let total: number = 0;

for(let i=0;i<reviews.length;i++){
	total+=reviews[i];
}

console.log(`The sum is ${total} and the average is ${total/10}`);
