package sanam.math;

public class CircleAndRectangleOverlap {

    static void main() {
        CircleAndRectangleOverlap circleAndRectangleOverlap = new CircleAndRectangleOverlap();
        // Input: radius = 1, xCenter = 0, yCenter = 0, x1 = 1, y1 = -1, x2 = 3, y2 = 1
        boolean result = circleAndRectangleOverlap.checkOverlap(1,0,0,1,-1,3,1);
        System.out.println(result);
    }

    public boolean checkOverlap(int radius, int xCenter, int yCenter, int x1, int y1, int x2, int y2) {
        int xi;
        int yi;

        if(x1 > xCenter){
            xi = x1;
        }else if(x2 < xCenter){
            xi = x2;
        }else{
            xi = xCenter;
        }

        if(y1 > yCenter){
            yi = y1;
        }else if(y2 < yCenter){
            yi = y2;
        }else{
            yi = yCenter;
        }

        double d = Math.sqrt(Math.pow(xi-xCenter,2) + Math.pow(yi-yCenter,2));
        return d <= radius;

    }
}
