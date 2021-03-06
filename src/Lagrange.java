public class Lagrange extends Polynomial {


     Lagrange(Point[] points){
        int len = points.length;
        Polynomial p1 = new Polynomial();
        p1.addMon(-1,0);
        p1.addMon(1,1);

        for (int i = 0; i < len; i++) {
            double k=1;
            Polynomial p2 = new Polynomial();
            p2.addMon(1,0);

            for (int j = 0; j < i; j++) {
                p1.change(-points[j].getX());
                p2.multiplication(p1);
            }
            for (int j = i+1; j < len; j++) {
                p1.change(-points[j].getX());
                p2.multiplication(p1);
            }
            for (int j = 0; j < i; j++){
                k/= points[i].getX() - points[j].getX();
            }
            for (int j = i+1; j < len ; j++) {
                k/=points[i].getX()-points[j].getX();
            }

            k *= points[i].getY();
            p2.multiply(k);
            addition(p2);
        }
        deleteZeros();
    }

    @Override
    public void print() {
        System.out.print("Lagrange polynomial");
        super.print();
    }
}
