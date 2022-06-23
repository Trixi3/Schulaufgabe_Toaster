public class SuperToaster extends Toaster {

    private int Temperatur;

    public SuperToaster(){

        System.out.println("SuperToaster");

    }
    @Override
    public void Toastcontroller(){
        super.Toastcontroller();


    }
    @Override                                                                  //Überschreiben der Methode von Toaster
    public void toast_toasten() {
        if(Anzahl_Toast!=0) {
            System.out.println("Toast ist am toasten");
            temperatur_messen();                                                                              // Einfügen der Messmethode
            toast_auswerfen();                                                                            //Aufruf der Methode zum Auswerfen des Toast
            toast_zustand();                                                                            //Aufruf Methode Toast-Zustand von Toaster-Klasse
            toast_cooldown();
        }else{System.out.println("Bitte lege zuerst einen Toast ein");
            Toastcontroller();
        }
    }
                                                                                                    //Methode zum Messen
    public int temperatur_messen(){
                                                                                                    // pro s steigt die Temperatur um 8°
        int CurrentTemp = this.Temperatur;
        int i=0;
        getToastzeit();
        while(getToastzeit()>i){
            Temperatur += 8;
            System.out.println(Temperatur+"°C");
            i++;
            if (Temperatur>500){
                toast_exception();
                return CurrentTemp;
            }
        }
        return CurrentTemp;
    }
    public void toast_cooldown(){                                                           //Methode zum Abkühlen nach Toastvorgang
        int CurrentTemp= this.Temperatur;
        while (CurrentTemp>15){
            Temperatur-=5;
            System.out.println(Temperatur+"°C");
            CurrentTemp=Temperatur;
        }
    }
                                                                                                //wird gerufen wenn die Temperatur über 500°C schreitet
    public void toast_exception(){
    System.out.println("Toaster ist überhitzt");
    }

}
