import java.util.Scanner;


public class Toaster  {

    private  String Farbe;
    private String[]Farbsortiment = new String[6];
    public int Anzahl_Toast;
    public int Schaechte;
    protected int Toastzeit;
    private int Toast_Zustand;
    Scanner sc = new Scanner(System.in);
    private int Eingabe;

                                                                                //Konstruktor zum Erstellen des Toasters
                                                                                 // Mit Ein- und Ausgabe
    public Toaster(){
        sortiment_befuellen();
        do{
        System.out.println("Welche Farbe hat der Toaster?");
        for(int j=0;Farbsortiment.length>j;j++){
            System.out.println(j+" "+Farbsortiment[j]);
        }
        Eingabe = sc.nextInt();
    }while((Eingabe<0)||(Eingabe>Farbsortiment.length-1));
        this.Farbe=Farbsortiment[Eingabe];
        do{
            System.out.println("Wie viele Schaechte hat der Toaster? (max.4)");
            Eingabe = sc.nextInt();
        }while((Eingabe<0)||(Eingabe>4));
        this.Schaechte=Eingabe;
        do{
            System.out.println("Wie lange soll das Toast in Sekunden getoastet werden ?");
            Eingabe = sc.nextInt();
        }while(Eingabe>100||Eingabe<0);
        this.Toastzeit=Eingabe;

        this.Toast_Zustand=0;

    }
                                                                                //Handhabt alle Methoden der Toasterklasse
    public void Toastcontroller(){

        System.out.println("0 Zeiteinstellung ändern");
        System.out.println("1 Toast einlegen");
        System.out.println("2 Zustand des Toasts");
        System.out.println("3 Toaster umlackieren");
        System.out.println("4 Toast toasten");
        System.out.println("5 Programm Beenden");
        switch (sc.nextInt()){
            case 0:
                toast_zeiteinstellen();
                Toastcontroller();
                break;
            case 1:
                toast_einlegen();
                Toastcontroller();
                break;
            case 2:
                System.out.println("\n");
               System.out.println("ungetoastet");
                Toastcontroller();
               break;
            case 3:
               toast_umlackieren();
                Toastcontroller();
                break;
            case 4:
                toast_toasten();
                Toastcontroller();
                break;
            case 5:
                break;
            default:
                break;
        }
}
    public void toast_toasten(){
            System.out.println("\n");
        if(Anzahl_Toast!=0){
            System.out.println("Toast ist am toasten");
            toast_auswerfen();                                   //Aufruf der Methode zum Auswerfen des Toast
            toast_zustand();                                       //Ruft Methode für den Zustand des Toastes
            System.out.println("\n");
        }else{
            System.out.println("Bitte legen Sie vorher ein Toast ein");
            Toastcontroller();
        }
    }
                                                                //Methode zum neueinstellen der Zeit
    public void toast_zeiteinstellen(){
        System.out.println("\n");
        System.out.println("Bitte gebe eine Zeit an");
        int i =sc.nextInt();
        setToastzeit(i);
        System.out.println("\n");
    }
                                                                //Methode zum Auswerfen des Toast wird nur von toast_toasten gerufen
   public void toast_auswerfen(){
        setAnzahl_Toast(0);
        System.out.println("Toast wird ausgeworfen");
    }
                                                                //Methode zum einlegen des Toasts
    public void toast_einlegen(){
        System.out.println("\n");
        if (Anzahl_Toast<Schaechte){
            setAnzahl_Toast(getAnzahl_Toast()+1);
            System.out.println("Eingelegt  "+Schaechte+"/"+Anzahl_Toast);
        }else{
            System.out.println("Alle Plätze belegt");
        }
        System.out.println("\n");
    }
                                                                        //Methode zum abändern der Farbe
    public void toast_umlackieren(){
        System.out.println("\n");
        System.out.println("Bitte gebe die gewünschte Farbe ein");
        setFarbe(sc.next());
        System.out.println("\n");
    }


    public void toast_zustand(){
                                                                         //Verzweigung zur Abfrage des Toast Zustandes
        if(Toastzeit==0){
            System.out.println("Zustand: ungetoastet");
        }else if (Toastzeit<15&&Toastzeit>0){
            System.out.println("Zustand: leicht getoastet");
        }else if(Toastzeit>15&&Toastzeit<31){
            System.out.println("Zustand: stark getoastet");
        }else if(Toastzeit>30){
            System.out.println("Zustand: verbrannt");
        }else{
            System.out.println("Leider keine gültige Zeitangabe");
        }
        }
                                                                                //Methode zum Befüllen des Array-Farbsortiments
    public void sortiment_befuellen(){
        Farbsortiment[0]="Rot";
        Farbsortiment[1]="Gelb";
        Farbsortiment[2]="Grün";
        Farbsortiment[3]="Blau";
        Farbsortiment[4]="Schwarz";
        Farbsortiment[5]="Weiß";
    }

                                                           //Getter und Setter um auf Attribute eines Objekts zuzugreifen
                                                            // Nur zum Testen

    public void setFarbe(String farbe) {
        Farbe = farbe;
    }

    public int getAnzahl_Toast() {
        return Anzahl_Toast;
    }

    public void setAnzahl_Toast(int anzahl_Toast) {
        Anzahl_Toast = anzahl_Toast;
    }

    public int getToastzeit() {
        return Toastzeit;
    }

    public void setToastzeit(int toastzeit) {
        Toastzeit = toastzeit;
    }

}
