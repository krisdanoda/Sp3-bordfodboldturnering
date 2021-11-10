public class Menu {
    public static int count2=0;
    public static void menu(Tournament tournament) {
        int input=0 ;

        while(count2==0) {
            input = UI.getUserInputInt("1. Admin\n2. Spiller\n3. Afslut");
            if (input == 1) {
                //Admin Menu
                UI.adminTournamentMainMenu();
            } else if (input == 2) {
                //Spiller menu
                count2++ ;
                PlayerUI.playerMenu(tournament);
            }
            else if (input == 3){
                count2=9;
            }
        }
    }

}
