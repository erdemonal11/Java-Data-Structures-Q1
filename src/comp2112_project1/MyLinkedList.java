/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comp2112_project1;

/**
 *
 * @author emre
 */
public class MyLinkedList {

    Node first, last, temp;

    public MyLinkedList() {
        first = null;
        last = null;
    }

    public String order(Node n) {

        if (first == null) { //if list is empty
            first = n;
            last = n;
            temp = first;
            return "";
        }

        if (n.power > first.power) { //if degree of node is greater than the current one
            n.next = first;
            first = n;
            temp = first;
            return "";
        }

        if (n.power == first.power) { //if degree's are same
            first.coeff += n.coeff;
        }

        if (n.power < first.power) { //if degree of node is less than the current node
            while (first.next != null) { // one more search operation
                if (n.power > first.power && n.power < first.next.power) { //if the node's degree is between the first and next of the first
                    n.next = first.next;
                    first.next = n;
                    break;
                }
                if (n.power == first.power) {
                    first.coeff += n.coeff;
                    first = temp;
                    return "";

                }

                if (n.power < first.power && n.power > first.next.power) {
                    n.next = first.next;
                    first.next = n;
                    break;
                }
                first = first.next;

            }
            if (n.power == first.power) { //if firs.next is null and you have to add two polynomials at the and of the list.
                first.coeff += n.coeff;
                first = temp;
                return "";
            }
            first.next = n; //if the node's power less than the other ones
            last = n;

        }
        first = temp; // assign the first again to the first node that we have in the beggining

        return ""; // and of the method

    }

    public String add(MyLinkedList list) {
        this.temp = this.first;
        list.temp = list.first;
        String str = ""; // using String cause of don't want to lose the original list
        while (this.first != null && list.first != null) {//hold the value of first list and compare it with second list's polynomials
            if (this.first.power > list.first.power) {
                str += this.first.toString();
                this.first = this.first.next;
                if (this.first == null) {
                    break;
                }
            }

            else if (this.first.power == list.first.power) {
                str += this.first.coeff + list.first.coeff + "x" + "^" + this.first.power + " ";
                if (this.first.next == null) {
                    
                    
                   
                }
                this.first = this.first.next;
                list.first = list.first.next;

            }

            else //(this.first.power < list.first.power) 
            {
                str += list.first.toString();
                list.first = list.first.next;
                if (list.first == null) {
                    break;
                }
            }
    }
        
        //if there's left element after the addition above print the remainings
        while (first != null) {
            str += this.first.toString();
            this.first = this.first.next;
        }
        //if there's left element after the second list print them into string
        while (list.first != null) {
            str += list.first.toString();
            list.first = list.first.next;
        }

        this.first = this.temp; //assign the first nodes again
        list.first = list.temp;
        return str;
    }

    public String product(MyLinkedList list) {
        this.temp = this.first;
        list.temp = list.first;
        MyLinkedList templist = new MyLinkedList(); 
        Node tempnode;
        String str = "";
        String str2 = "";

        while (this.first != null) {//starting from the first element of first list and multiply it with other elements in lis2 one by one
            while (list.first != null) {

                tempnode = new Node(this.first.coeff * list.first.coeff, this.first.power + list.first.power);
                templist.order(tempnode);

                list.first = list.first.next;
            }
            str2 += templist.toString();
            list.first = list.temp;
            this.first = this.first.next;
        }

        this.first = this.temp;
        list.first = list.temp;

        return templist.toString();
    }

    @Override
    public String toString() {
        Node tempfirst = first;
        String str = "";
        while (first != null) {
            str += first.toString();
            if (first.next != null && first.next.coeff > 0) {
                str += "+";
            }
            first = first.next;
        }
        first = tempfirst;
        return str;
    }

    public boolean delete(int userpower) {
        temp = this.first;

        if (temp.power == userpower) { //Check the first node cause we'll search from the next of first
            if (temp.next == null) {
                first = null;
                last = null;
                return true;
            } else {
                first = first.next;
                return true;
            }
        }

        while (temp.next != null) {
            if (temp.next.power == userpower) {
                if (temp.next != null) {
                    temp.next = temp.next.next;
                    return true;
                }
            }
            temp = temp.next;
        }

        return false;
    }

    public boolean contains(int power) { //used for deleting operationn
        temp = first;
        if (temp == null) {
            return false;
        }

        while (temp != null) {
            if (temp.power == power) {
                return true;
            }
            temp = temp.next;
        }

        return false;
    }

}
