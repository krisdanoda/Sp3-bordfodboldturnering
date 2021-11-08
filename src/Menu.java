public class Menu {
    public static void menu() {

        int input=0 ;
        int inputA=0 ;
        input=UI.getUserInputInt("1. Admin\n2. Spiller") ;
        if(input==1){
            //Admin stuff
            inputA=UI.getUserInputInt("Adgangskode:");
            if(inputA==1234){
                System.out.println("Admin");
            }

        }
        else if(input==2){
        //Spiller stuff
            PlayerUI.playerMenu();
        }

    }

}
