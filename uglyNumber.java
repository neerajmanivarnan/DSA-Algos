class uglyNumber {

	public static void main(String rags[]){
		nthUglyNumber(10);

	}

    public static void nthUglyNumber(int n) {
        int arr[] = new int[n];

        for(int i=1,j=0;j<n;i++){
            if(isUgly(i)) {
                arr[j] = i;
                j++;
            }
        }

	for(int k:arr){
		System.out.println(k);
	}
        //return arr[n-1];

    }

    public static boolean isUgly(int n) {
        if(n <=0 ) return false;

        if(n == 1) return true;

        if(n%2 == 0){
            return isUgly(n/2);
        }else if(n%3 == 0){
            return isUgly(n/3);
        }else if(n%5 == 0){
            return isUgly(n/5);
        }else{
            return false;
        }
    }
}
