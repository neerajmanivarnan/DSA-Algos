import java.util.*;


// } Driver Code Ends
//User function Template for Java


class Solution
{
    void bitonicGenerator(long arr[], int n)
    {
	List<Integer> odd = new List<>();
	List<Integer> even = new List<>();

	for(int num:arr){
		if(num%2 == 0 )even.add(num);
		else odd.add(num);
	}

       Collections.sort(even); 
       odd.sort(Collections.reverseOrder());


    }
}


