import java.util.Scanner;
public class Player {
    private static int s1;
    private static int s2;
    private static int numPieces;
    private static String name;
    private static int numPlayers;
    static Scanner s = new Scanner(System.in);
    public static String makeName(){
        System.out.println("Whats your name");
        name = s.nextLine();
        return name;
    }
    public static void pvp(String[] nList){
        numPieces = (int)(Math.random()*40)+10;
        System.out.println(numPlayers+" "+numPieces);
        int x = (int)(Math.random()*2);
        System.out.println(x);
        System.out.println("You have "+numPieces+" pieces");
        while(numPieces>1){
            if(nList.length>1){
                System.out.println("How many do you want to take away "+nList[x%2]+"?: ");
            }
            else{
                System.out.println("How many do you want to take away "+nList[0]+"?: ");
            }
            int take = s.nextInt();
            s.nextLine();
            if(take < (numPieces/2)+1 && numPieces-take > 0 && take>0){
                numPieces -= take;
                x++;
                System.out.println("You now have "+numPieces+" left");
            }
            else{
                System.out.println("Bad input");
            }
            if(nList.length>1){
                int cTake = (int)(Math.random()*numPieces);
                numPieces -= cTake;
                System.out.println("The computer took "+cTake+" pieces");
                System.out.println("There are now "+numPieces+" left");
            }
        }
        System.out.println(nList[(x-1)%2]+" wins!");
        if(nList[(x-1)%2]==nList[0]){
            s1++;
        }
        else{
            s2++;
        }
        if(nList.length>1){
            System.out.println(nList[0]+": "+s1+"\n"+nList[1]+": "+s2);
        }
        else{
            System.out.println(nList[0]+": "+s1+"\ncomputer: "+s2);
        }
        System.out.println("Play again?(y/n): ");
        String pa = s.nextLine();
        if(pa.indexOf("y")!=-1){
            pvp(nList);
        }
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
            pvp(nList);
        }
        else if(numPlayers == 1){
            System.out.println("Player 1: ");
            String p1 = makeName();
            String[] nList = {p1};
            pvp(nList);
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
