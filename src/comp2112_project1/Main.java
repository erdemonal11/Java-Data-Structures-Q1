package comp2112_project1;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        System.out.println("Enter the coefficient and power of the first polynomial (type 0 to end)");
        int userNumberForFirstPolynomial = -1;
        MyLinkedList list1 = new MyLinkedList();

        while (userNumberForFirstPolynomial != 0) {
            int coeff1 = scn.nextInt();
            if(coeff1==0){
                break;
            }
            int power1 = scn.nextInt();
            Node n = new Node(coeff1, power1);
            list1.order(n);
            
        }
        System.out.println("Enter the coefficient and power of the second polynomial (type 0 to end)");
        int userNumberForSecondPolynomial = -1;
        MyLinkedList list2 = new MyLinkedList();

        while (userNumberForSecondPolynomial != 0) {
            int coeff2 = scn.nextInt();
            if(coeff2==0){
                break;
            }
            int power2 = scn.nextInt();
            Node n2 = new Node(coeff2, power2);
            list2.order(n2);
            
        }

        int usernumber = 0;

        while (usernumber != 5) {
            System.out.println("please enter which one do you want to do" + "\n" + "1- Add two polynomials "
                    + "\n" + "2- multiply two polynomials" + "\n" + "3-print a polynomial" + "\n"
                    + "4-remove a node with a given power polynomial" + "\n" + "5-Exit");
            usernumber = scn.nextInt();
            switch (usernumber) {
                case 1:
                    System.out.println(list1.add(list2) + "\n");
                    break;
                case 2:
                    System.out.println(list1.product(list2)+ "\n");
                    break;
                case 3:
                    System.out.println(list1.toString());
                    System.out.println(list2.toString()+ "\n");
                    break;
                case 4:
                    System.out.println("please enter the power that you want to delete");
                    int deletePower = scn.nextInt();
                    if (list1.contains(deletePower) && list2.contains(deletePower)) {
                        list1.delete(deletePower);
                        list2.delete(deletePower);
                        System.out.println("polynomials are deleted from both list"+"\n");
                    } else {
                        System.out.println("polynomial does not exits in both list"+"\n");
                    }
                    break;
                case 5:
                    System.out.println("goodbye");
                    break;
                default:
                    System.out.println("you entered invalid value"+ "\n");
            }

        }
    }

}
