import java.util.Scanner;
public class Player {
    private int score;
    private static int numPieces;
    private static String name;
    private int order;
    private static int numPlayers;
    static Scanner s = new Scanner(System.in);
                
    public static String makeName(){
        System.out.println("Whats your name");
        name = s.nextLine();
        return name;
    }
    
    public Player(String name, int order){
        this.name = name;
        this.order = order;
    }
    public String getName(){
        return name;
    }
    public int getOrder(){
        return order;
    }
    public static void nimming(){
        System.out.println("How many players: ");
        numPlayers = s.nextInt();
        s.nextLine();
        if(numPlayers == 2){
            System.out.println("Player 1: ");
            String p1 = makeName();
            
            System.out.println("Player 2: ");
            String p2 = makeName();
            String[] nList = {p1,p2};
            System.out.println(p1 +" "+p2);
            numPieces = (int)(Math.random()*40)+10;
            System.out.println(numPlayers+" "+numPieces);
            int x = 0;
            while(numPieces>1){
                System.out.println("How many do you want to take away "+nList[x%2]+"?: ");
                int take = s.nextInt();
                if(take < (numPieces/2)+1 && numPieces-take > 0){
                    numPieces = numPieces - take;
                    x++;
                    System.out.println("You now have "+numPieces+" pieces");
                }
                else{
                    System.out.println("Bad input");
                }
            }
            System.out.println(nList[(x-1)%2]+" wins!");
        }
        else if(numPlayers == 1){
            System.out.println("cool this works");
        }
        else{
            System.out.println("bad input");
            nimming();
        }
        
    }

    public static void main(String[] args) {
        nimming();
    }
}
