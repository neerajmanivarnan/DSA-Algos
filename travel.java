public class travel{

  public static void main(String[] args) {
    int[][] result = {{1,2,3},{4,5,6},{7,8,9}};

    int x= 0;
    int y = 0;
    int dx = 1;
    int dy = 0;

    int rows = result.length;
    int cols = result[0].length;

    int total = rows*cols;

    for(int i = 0 ; i< cols;i++){

        System.out.println(result[y][x]);
        if(!(x < x+ dx && x+dx < cols) || !(y < rows) ){
          x = 0 ;
          y = y+1;
          continue;
        }

        x += dx;
    }



  }

}
