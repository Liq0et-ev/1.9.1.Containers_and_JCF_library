// Vladislav Ebert 241RDB316 7.gruppa

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

class Prece {
    String nosaukums;
    double cena;
    int daudzums;

    Prece(String n, double c, int d) {
        nosaukums = n;
        cena = c;
        daudzums = d;
    }

    static Prece inputPrece(Scanner sc) {
        System.out.print("nosaukums: ");
        String n = sc.next();
        System.out.print("cena: ");
        double c = sc.nextDouble();
        System.out.println("daudzums: ");
        int d = sc.nextInt();
        return new Prece(n, c, d);
    }

    void outputPrece() {
        System.out.printf("%-20s%-10.2f%-10d\n", nosaukums, cena, daudzums);
    }
    double totalPrice(){
        return cena * daudzums;
    }
}

public class Main {
    public static Scanner sc;

    public static void main(String[] args) {
        HashMap<String, LinkedList<Prece>> pasutijumi =
                new HashMap<String, LinkedList<Prece>>();

        sc = new Scanner(System.in);
        String cmd = "";

        while (!cmd.equals("done")) {
            System.out.print("command:> ");
            cmd = sc.next();
            switch (cmd) {
                case "add":
                    add(pasutijumi);
                    break;

                case "print":
                    print(pasutijumi);
                    break;

                case "sum":
                    sum(pasutijumi);
                    break;

                case "inc":
                    inc(pasutijumi);
                    break;

                case "del":
                    del(pasutijumi);
                    break;

                case "done":
                    System.out.println("good bye");
                    break;

                default:
                    System.out.println("unknown command");
                    break;
            }
        }

        sc.close();
    }

    public static void add(HashMap<String, LinkedList<Prece>> pasutijumi) {
        LinkedList<Prece> grozs;

        System.out.print("klienta ID: ");
        String id = sc.next();
        Prece p = Prece.inputPrece(sc);
        grozs = pasutijumi.get(id);
        if (grozs != null) {
            grozs.add(p);
        } else {
            grozs = new LinkedList<Prece>();
            grozs.add(p);
            pasutijumi.put(id, grozs);
        }
    }


    public static void print(HashMap<String, LinkedList<Prece>> pasutijumi) {
        LinkedList<Prece> grozs;

        for (String id : pasutijumi.keySet()) {
            System.out.println("ID: " + id);
            grozs = pasutijumi.get(id);
            String str = String.format(
                    "%-20s%-10s%-10s", "nosaukums", "cena", "daudzums");
            System.out.println(str);
            for (Prece prece : grozs) {
                prece.outputPrece();
            }
        }
        System.out.println();
    }

    public static void sum(HashMap<String, LinkedList<Prece>> pasutijumi) {
        System.out.println("klienta ID");
        String id = sc.next();
        LinkedList<Prece> grozs = pasutijumi.get(id);
        //boolean exist == true;

        if (grozs != null) {
            double totalSum = 0;
            for (Prece prece : grozs) {
                totalSum += prece.totalPrice();
            }
            System.out.println(totalSum);

        } else {
            System.out.println("Uknown client");
        }


    }

    public static void inc(HashMap<String, LinkedList<Prece>> pasutijumi) {
        System.out.println("klienta ID");
        String id = sc.next();
        LinkedList<Prece> grozs = pasutijumi.get(id);

        if (grozs == null) {
            System.out.println("unknown client");
            return;
        }

        System.out.println("Preces nosaukums:");
        String nosaukums = sc.next();
        boolean found = false;

        for (Prece prece : grozs) {
            if (prece.nosaukums.equals(nosaukums)) {
                prece.daudzums += 1;
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("not found");
        }
    }

        public static void del(HashMap < String, LinkedList < Prece >> pasutijumi){
            System.out.println("klienta ID");
            String id = sc.next();
            LinkedList<Prece> grozs = pasutijumi.get(id);

            if (grozs == null) {
                System.out.println("unknown client");
                return;
            }

            System.out.println("Preces nosaukums:");
            String nosaukums = sc.next();
            boolean found = false;

            for (int i = 0; i < grozs.size(); i++) {
                if (grozs.get(i).nosaukums.equals(nosaukums)) {
                    grozs.remove(i);
                    found = true;
                    break;
                }
            }

            if (!found) {
                System.out.println("not found");
            }
        }
    }

