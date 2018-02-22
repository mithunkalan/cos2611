import java.text.DecimalFormat;

public class HelloWorld {

    public static double f(double a){
   //     return Math.pow(a,3)+ 4*Math.pow(a,2)-10;
        return Math.cos(a)-a;
    }

    public static double fdash(double a){
        //return 3*Math.pow(a,2)+ 8*a;
        return -Math.sin(a)-1;
    }


    public static void bisection(double a, double b,double tol, int maxiter){
        DecimalFormat df5 = new DecimalFormat("#0.00000");
        DecimalFormat df9 = new DecimalFormat("#.000000000");
        int i=1;
        double fa = f(a);
        while (i < maxiter){
            double p = a + (b-a)/2;
            System.out.print(i +"\t"+ df9.format(a)+"\t"+ df9.format(b)+"\t"+ df9.format(p) +"\t");
            double fp = f(p);
            if (fp == 0 || (b-a)/2<tol){
                System.out.println(p);
                i=maxiter;
            }
            i++;
            if (fa*fp>0) {
                a=p;
                fa=fp;
            } else {
                b=p;
            }
            System.out.println(df5.format(fp));
            if (i == maxiter) System.out.println("end");
        }
    }



//    public static void fixedpoint(double p0, double tol, int maxiter){
//        DecimalFormat df5 = new DecimalFormat("#0.00000");
//        DecimalFormat df9 = new DecimalFormat("#.000000000");
//
//        int i=1;
//        double fa = f(p0);
//        while (i < maxiter){
//
//            double p = a + (b-a)/2;
//            System.out.print(i +"\t"+ df9.format(a)+"\t"+ df9.format(b)+"\t"+ df9.format(p) +"\t");
//
//            double fp = f(p);
//            if (fp == 0 || (b-a)/2<tol){
//                System.out.println(p);
//                i=maxiter;
//            }
//            i++;
//            if (fa*fp>0) {
//                a=p;
//                fa=fp;
//            } else {
//                b=p;
//            }
//            System.out.println(df5.format(fp));
//
//            if (i == maxiter) System.out.println("end");
//
//        }
//
//
//    }


    public static void newtonraphson(double p0, double tol, int maxiter){
        DecimalFormat df5 = new DecimalFormat("#0.00000");
        DecimalFormat df9 = new DecimalFormat("#.000000000");
        int i=1;

        while (i < maxiter){
            double p = p0-f(p0)/fdash(p0);
            System.out.print(i +"\t");

            if (p - p0 <tol){
                System.out.println(p);
              //  i=maxiter;
            }
            i++;
            p0=p;
            System.out.println(p0);
            if (i == maxiter) System.out.println("end");
        }
    }




    public static void main(String [] args){
        System.out.println("Hello World!");
        //bisection(1,2,.0001,14);
        newtonraphson(Math.PI/4,.01,15);
        return ;
    }
}
