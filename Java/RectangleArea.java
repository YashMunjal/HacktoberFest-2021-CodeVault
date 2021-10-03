public class RectangleArea {
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {

        /*
        Case where 1 rectangle engulfs the other
         */
        if (ax2 > bx2 && ax1 < bx1 && ay2 > by2 && ay1 < by1) {
            return (ax2 - ax1) * (ay2 - ay1);
        } else if (ax2 <= bx2 && ax1 >= bx1 && ay2 <= by2 && ay1 >= by1) {
            return (bx2 - bx1) * (by2 - by1);
        }

        /*
        Case where no shared region
         */

        int i = (ax2 - ax1) * (ay2 - ay1) + (bx2 - bx1) * (by2 - by1);
        if ((ax2 <= bx1 || ax1 >= bx2) || (ay1 >= by2 || ay2 <= by1)) {
            return i;
        }

        /*
        Case where there is shared region
         */

        int xupperbound = Math.min(ax2, bx2);
        int xlowerbound = Math.max(ax1, bx1);

        int yupperbound = Math.min(ay2, by2);
        int ylowerbound = Math.max(ay1, by1);

        int areashared = (xupperbound - xlowerbound) * (yupperbound - ylowerbound);

        return i - areashared;
    }
}