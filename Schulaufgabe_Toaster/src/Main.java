import java.util.Scanner;

public class Main{
public static void main (String [] args){
    Scanner Sc = new Scanner(System.in);
    int Eingabe;
                                                                                //Fußgesteuerte Schleife zum abfangen fehlerhafter Zahleingaben
    do {
        System.out.println("0 Für einen Gewöhnlichen Toaster");
        System.out.println("1 Für einen SuperToaster");
        Eingabe = Sc.nextInt();                                             //Konsoleneingabe
        switch (Eingabe) {
            case 0 -> {
                Toaster Test = new Toaster();
                Test.Toastcontroller();
            }
            case 1 -> {
                SuperToaster ST = new SuperToaster();
                ST.Toastcontroller();
            }
        }
    }while((Eingabe!=0)||(Eingabe!=1));
}
}

