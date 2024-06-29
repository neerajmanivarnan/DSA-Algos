import java.util.Arrays;

public class mergeSort{
    public static void main(String[] args) {
        int[] arr = {9,8,7,6,5,5,5,4,3,2,1};
        int[] newA = sort(arr);
        System.out.println(Arrays.toString(newA));
    }


    public static int[] sort(int[] arr){

        if(arr.length == 1){
            return arr;
        }

        int mid = arr.length/2;

        int[] left = sort(Arrays.copyOfRange(arr, 0, mid));
        int[] right = sort(Arrays.copyOfRange(arr, mid, arr.length));
        
        return merge(left,right);


    }


    private static int[] merge(int[] first, int[] second) {
        int i=0;
        int j=0;
        int k=0;

        int[] mix = new int[first.length+second.length];

        while(i<first.length && j<second.length){
            if(first[i]<second[j]){
                mix[k] = first[i];
                i++;
            }else{
                mix[k] = second[j];
                j++;
            }

            k++;
        }

        while(i<first.length){
            mix[k] = first[i];
            i++;
            k++;

        }

        while (j<second.length) {
            mix[k] = second[j];
            j++;
            k++;
            
        }


        return mix;
    }


}
