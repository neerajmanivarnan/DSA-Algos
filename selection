public class selection{
    public static void main(String[] args) {
    
        int[] arr = {34543,6567676,34324234,543534,534534,67567867,34324324,4543546,435,2342,564565,234324324,5676756,32432432,2343242,765765767,324334234,2342343,46456,432423};
        sort(arr);
        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
        
    }

    private static void sort(int[] arr) {
        int index ;
        int temp;
        long starTime = System.nanoTime();
        
        for(int i=0;i<arr.length;i++){
            index = i;
            for(int j=i+1;j<arr.length;j++){
                if(arr[j]<arr[index]){
                    index = j;
                }
            }
            temp = arr[i];
            arr[i] = arr[index];
            arr[index] = temp;     
        }

        long endTime = System.nanoTime();

        System.out.println("this is time" + (endTime-starTime));
    }



}