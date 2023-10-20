/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p0215a;

class ExcDemo5 { 
    public static void main(String[] args)
    {
    int numer[] = {4, 8, 16, 32, 64, 128, 256, 512};
    int denom[] = {2, 0, 4, 4, 0, 8};
    try {
            for (int i=0; i<numer.length; i++){
                try {
                    System.out.println(numer[i] + " / " +
                            denom[i] + " = " +
                            numer[i]/denom[i]);
                }
                catch (ArithmeticException obj) {
                    System.out.println("Can't divide by zero");
                }
            }
    }
    catch(ArrayIndexOutOfBoundsException obj) {
        System.out.println("No matching element found.");
    }
    }
}