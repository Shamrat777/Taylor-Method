/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tylor;


import java.text.DecimalFormat;
import java.util.Scanner;

/**
 *
 * @author Shamrat
 */



public class Tylor {

    /**
     * @param args the command line arguments
     */

    public static void main(String[] args) {
        DecimalFormat df=new DecimalFormat("#.######");
        DecimalFormat df1=new DecimalFormat("#.##");
        methods m_obj=new methods();
        
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter The Lower Range of X");
        double x_low=sc.nextDouble();
        System.out.println("Enter The Upper Range of X");
        double x_up=sc.nextDouble();
        System.out.println("Input the given step size of 'h' ");
        double h =sc.nextDouble();
        System.out.println("Enter The Value Of 'Xo' ");
        double Xo=sc.nextDouble();
        System.out.println("Enter The Value Of 'Yo' ");
        double Yo=sc.nextDouble();
        double step=Xo+h;
        double X_past=0;
        double X_present=0;
        
        for(int i=1;step<=x_up;i++){
         double X1=Double.parseDouble(df.format(m_obj.function(Yo, h, m_obj.Yi(Xo, Yo), m_obj.Yii(Xo, Yo), m_obj.Yiii(Xo, Yo), m_obj.Yiv(Xo, Yo))));
          X_present=X1;
          System.out.printf("%n%n");
          System.out.println("ITERATION NO: "+i);
          System.out.println("The value of Y"+"("+step+") is: "+X1);
          Xo=step;
          Yo=X1;
          step=step+h;
          
          
          if(i==1){
          double relative_error=Double.parseDouble(df1.format(((1-X1)/X1)*100));
            System.out.println("The Approximate Relative Error :"+Math.abs(relative_error));
          }
          else{
          double relative_error=Double.parseDouble(df1.format(((X_present-X_past)/X_past)*100));
              
              
            System.out.println("The Approximate Relative Error :"+Math.abs(relative_error));
          
          }
          X_past=X1;
          
          
          
          
        }
        }
    }
    

