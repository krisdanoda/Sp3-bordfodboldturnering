public class Menu {
    private PlayerUI playerUI;
    private Tournament tournament;
    private Knockout knockout;

    public Menu(Tournament tournament, Knockout knockout) {
        this.playerUI = new PlayerUI(tournament);
    }

    public void menu() {
        int input=0 ;
        input=UI.getUserInputInt("1. Admin\n2. Spiller") ;
        if(input==1){
            //Admin Menu
            UI.adminTournamentMainMenu(knockout);
        }
        else if(input==2){
        //Spiller menu
            playerUI.playerMenu();
        }

    }

}
