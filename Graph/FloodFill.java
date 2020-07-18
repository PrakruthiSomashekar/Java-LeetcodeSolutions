package Graph;

public class FloodFill {

    public static void main(String[] args) {
        FloodFill f = new FloodFill();
        int[][] image = {{1,1,1},{1,1,0},{1,0,1}};
        image = f.floodFill(image,1,1,2);
        for(int i=0; i<image.length; i++)
            for(int j=0; j<image[0].length; j++)
                System.out.print(image[i][j]+"\t");
            System.out.println();
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int old = image[sr][sc];
        change(image,sr,sc,newColor,old);
        return image;
    }

    private void change(int[][] image, int sr, int sc, int newColor, int old) {
        if(sr>=image.length || sr<0 || sc>=image[0].length || sc<0 || image[sr][sc] == newColor)
            return;
        if(image[sr][sc] == old)
            image[sr][sc] = newColor;
        else return;
        change(image,sr+1,sc,newColor,old);
        change(image,sr-1,sc,newColor,old);
        change(image,sr,sc+1,newColor,old);
        change(image,sr,sc-1,newColor,old);
    }
}
