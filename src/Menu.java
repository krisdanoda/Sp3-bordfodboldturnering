public class Menu {
    public static void menu(Tournament tournament, Knockout knockout) {
        int input=0 ;
        input=UI.getUserInputInt("1. Admin\n2. Spiller") ;
        if(input==1){
            //Admin Menu
            UI.adminTournamentMainMenu(knockout);
        }
        else if(input==2){
        //Spiller menu
            PlayerUI.playerMenu(tournament);
        }

    }

}
