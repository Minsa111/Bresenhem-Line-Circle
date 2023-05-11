import java.util.ArrayList;

public class BresenhamLine {

    public static ArrayList<Integer> getLine(int x0, int y0, int x1, int y1) {
        ArrayList<Integer> line = new ArrayList<>();
        int dx = Math.abs(x1 - x0);
        int dy = Math.abs(y1 - y0);
        int m = dy > dx ? 1 : 0;
        int p = m == 1 ? 2 * dx - dy : 2 * dy - dx;
        int x = x0;
        int y = y0;
        int xInc = x1 > x0 ? 1 : -1;
        int yInc = y1 > y0 ? 1 : -1;
        while (x != x1 || y != y1) {
            line.add(x);
            line.add(y);
            if (m == 0) {
                if (p < 0) {
                    p += 2 * dy;
                } else {
                    y += yInc;
                    p += 2 * dy - 2 * dx;
                }
                x += xInc;
            } else {
                if (p < 0) {
                    p += 2 * dx;
                } else {
                    x += xInc;
                    p += 2 * dx - 2 * dy;
                }
                y += yInc;
            }
        }
        line.add(x);
        line.add(y);
        return line;
    }

    public static void main(String[] args) {
        int x0 = 10, y0 = 10;
        int x1 = 17, y1 = 16;

        ArrayList<Integer> line = getLine(x0, y0, x1, y1);
        for (int i = 0; i < line.size(); i += 2) {
            int x = line.get(i);
            int y = line.get(i + 1);
            System.out.println("(" + x + ", " + y + ")");
        }


        int [][]draw = new int[y1+3][x1+3];
        for (int i = 0; i < draw.length; i++) {
            for (int j = 0; j < draw[i].length; j++) {
                draw[i][j] = 0;
            }
        }

        for (int i = 0, j=1; i < line.size(); i+=2, j+=2) {
            draw[line.get(j)][line.get(i)] = 1;
        }

        for (int i = 0; i < draw.length; i++) {
            for (int j = 0; j < draw[i].length; j++) {
                System.out.print( draw[i][j] + " " );
            }
            System.out.println("\t|\t" + i );
        }
    }
}
