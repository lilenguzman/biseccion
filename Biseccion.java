/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biseccion;

import java.util.Scanner;

/**
 *
 * @author LILEN
 */
public class Biseccion {

    public static double funcion(double a) {
        //funcion f(x)=x^3-2*x-1. funcion continua para poder aplicar bolzano
        double x = (Math.pow(a, 3)) - 2 * a - 1;
        return x;
    }

    public static void main(String[] args) {
        //metodo de bissecion para la funcion f(x)=x^3-2*x-1
        Scanner sc = new Scanner(System.in);
        double r,funA, funB,i,d;
        System.out.println("Ingrese el extremo iquierdo del intervalo"
                + "\nObsevacion: usar coma y no punto");
        double a = sc.nextDouble();
        i=a;

        System.out.println("Ingrese el extremo derecho del intervalo"
                + "\nObsevacion: usar coma y no punto");
        double b = sc.nextDouble();
        d=b;

        System.out.println("Ingrese el error de calculo");
        double e = sc.nextDouble();
        funA = funcion(a);
        funB = funcion(b);

        if (funA * funB < 0) {//me fijo si cumple con bolzano
            do {
                r = (a + b)/2;
                
                if (funcion(a) * funcion(r) < 0) {
                    b = r;//obtengo los nuevos puntos del intervalo. ahora es [a,r]
                } else {
                    a = r;//obtengo los nuevos puntos del intervalo. ahora es [r,b]
                }
            } while ((Math.abs(funcion(r))) > e);//corta cuando r sea una raiz apoximada
//de f(x) con error menor a e  
            System.out.println("La raiz aproximada de f(x) en el intervalo ["+i+","+d+"] es:"+r);
        } else {
            System.out.println("No se puede aplicar Bolzano en el intervalo "
                    + "seleccionado");
        }

        

    }

}
