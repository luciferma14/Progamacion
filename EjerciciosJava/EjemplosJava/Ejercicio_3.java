import java.lang.Math;

public class Ejercicio_3 
{
    public static void main(String[] args)
    {

        double a1 = 1;
        double b1 = 5;
        double c1 = 6;
        
            if (a1!=0) 
            {
            
            double d1 = b1*b1-4*a1+c1; //Discriminante (d)

            double parte1_1 = -b1/(2*a1);

            double d1_2 = Math.abs(d1);

            double parte2_1 = Math.sqrt(d1) /(2*a1);

            String x1_1 = "", x2_1 = "";

            if (d1<0) 
            {
                System.out.println("Imaginarias y diferentes");

                x1_1+= parte1_1+"+"+parte2_1;

                x2_1+= parte1_1+"-"+parte2_1;

            } else if (d1==0) 
            {
                System.out.println("Únicas o iguales");

                x1_1+= parte1_1;

                x2_1+= parte1_1;

            } else 
            {
                System.out.println("Reales y diferentes");

                x1_1+= parte1_1+parte2_1;

                x2_1+= parte1_1+parte2_1;

            }
                System.out.println("x1_1="+x1_1);

                System.out.println("x2_1="+x2_1);               


        double a2 = 1;
        double b2 = 0;
        double c2 = 1;
        
            if (a2!=0) 
            {
            
            double d2 = b2*b2-4*a2+c2; //Discriminante (d)

            double parte1_2 = -b2/(2*a2);

            double d2_2 = Math.abs(d2);

            double parte2_2 = Math.sqrt(d2) /(2*a2);

             String x1_2 = "", x2_2 = "";

            if (d2<0) 
            {
                System.out.println("Imaginarias y diferentes");

                x1_2+= parte1_2+"+"+parte2_2;

                x2_2+= parte1_2+"-"+parte2_2;

            } else if (d2==0) 
            {
                System.out.println("Únicas o iguales");

                x1_2+= parte1_2;

                x2_2+= parte1_2;

            } else 
            {
                System.out.println("Reales y diferentes");

                x1_2+= parte1_1+parte2_2;

                x2_2+= parte1_1+parte2_2;

            }   
                System.out.println("x1_2="+x1_2);

                System.out.println("x2_2="+x2_2);



        double a3 = 1;
        double b3 = -4;
        double c3 = 4;
        
            if (a3!=0) 
            {
            
            double d3 = b3*b3-4*a3+c3; //Discriminante (d)

            double parte1_3 = -b3/(2*a3);

            double d3_2 = Math.abs(d3);

            double parte2_3 = Math.sqrt(d3) /(2*a3);

             String x1_3 = "", x2_3 = "";

            if (d3<0) 
            {
                System.out.println("Imaginarias y diferentes");

                x1_3+= parte1_3+"+"+parte2_3;

                x2_3+= parte1_3+"-"+parte2_3;

            } else if (d3==0) 
            {
                System.out.println("Únicas o iguales");

                x1_3+= parte1_3;

                x2_3+= parte1_3;

            } else 
            {
                System.out.println("Reales y diferentes");

                x1_3+= parte1_1+parte2_3;
                
                x2_3+= parte1_1+parte2_3;

            }
                System.out.println("x1_3="+x1_3);

                System.out.println("x2_3="+x2_3);
         


        } else 
        {
            System.out.println("Ecuaciones No Cuadráticas");
        }
    }
            }
        }  

}
