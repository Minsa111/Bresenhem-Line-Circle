import java.util.ArrayList;

public class BresenhamCircle {

    public static int maxX = 0, maxY = 0 ;
    public static int minX = 0, minY = 0;
    static ArrayList<Integer> db_X = new ArrayList<>();
    static ArrayList<Integer> db_Y = new ArrayList<>();


    public static void drawCircle(int xc, int yc, int r) {
        int x = 0, y = r;
        int pk = 3 - 2 * r;
        while (x < y) {
            drawSymmetricPoints( xc, yc, x, y );
            x++;
            if (pk < 0) {
                pk += 4 * x + 6;
            } else {
                y--;
                pk += 4 * (x - y) + 10;
            }
        }
        if (x == y) {
            drawSymmetricPoints( xc, yc, x, y );
        }
    }
    private static void drawSymmetricPoints(int xc, int yc, int x, int y) {

        drawPixel( xc + x, yc + y );
        drawPixel( xc - x, yc + y );
        drawPixel( xc + x, yc - y );
        drawPixel( xc - x, yc - y );
        drawPixel( xc + y, yc + x );
        drawPixel( xc - y, yc + x );
        drawPixel( xc + y, yc - x );
        drawPixel( xc - y, yc - x );
    }

    private static void drawPixel(int x, int y) {
        System.out.println( "(" + x + ", " + y + ")" );
        db_X.add( x );
        db_Y.add( y );
        if (x > maxX) {
            maxX = x;
        } else if (x < minX) {
            minX = x;
        }

        if (y > maxY) {
            maxY = y;
        } else if (y < minY) {
            minY = y;
        }
    }

    public static void main(String[] args) {
        drawCircle( 0, 0, 4 );

        for (int i=0 ;i<db_X.size(); i++){
            db_X.set( i, db_X.get( i )+ Math.abs(minX) );
            db_Y.set( i, db_Y.get( i )+ Math.abs(minY) );
            if (db_X.get( i )> maxX) {
                maxX = db_X.get(i);
            } else if (db_X.get( i ) < minX) {
                minX = db_X.get( i );
            }

            if (db_Y.get( i ) > maxY) {
                maxY = db_Y.get( i );
            } else if (db_Y.get( i ) < minY) {
                minY = db_Y.get( i );
            }
        }

        int [][]draw = new int[maxY+2][maxX+2];
        for (int i = 0; i < draw.length; i++) {
            for (int j = 0; j < draw[i].length; j++) {
                draw[i][j] = 0;
            }
        }

        for (int i = 0; i <db_X.size() ; i++) {
            draw[db_Y.get( i )][db_X.get( i )] = 1;
        }

        for (int i = 0 ,count = minY; i < draw.length; i++ ,count++) {
            for (int j = 0; j < draw[i].length; j++) {
                System.out.print( draw[i][j] + " " );
            }
            System.out.println("\t|\t" + count );
        }
        System.out.println();
        for (int i = 0 ,count = minX; i < draw.length; i++ ,count++) {
            System.out.print( count + " " );
        }
    }
}
