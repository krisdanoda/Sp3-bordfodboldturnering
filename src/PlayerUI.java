public class PlayerUI {
    public static void playerMenu(){
        boolean closeSignup=true ;
        if(closeSignup){
            System.out.println("Der er lukket for tilmelding");
        }
        else{
            int input=0 ;
            input=UI.getUserInputInt("1. Opret nyt hold\n2. Tilmeld spiller til eksisterende hold") ;
            if(input==1){
                //tilmeld nyt hold
            }
            else if(input==2){
                //Tilføj spiller til eksisterende
            }
        }
    }
}
