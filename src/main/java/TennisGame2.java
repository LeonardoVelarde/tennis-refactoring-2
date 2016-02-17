
public class TennisGame2 implements TennisGame
{
    public int player1points = 0;
    public int player2points = 0;

    private String player1Name;
    private String player2Name;
    String[] pointLiterals = {"Love", "Fifteen", "Thirty", "Forty"};

    public TennisGame2(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    private String getLiteral(int score){
        return pointLiterals[score];
    }

    public String getScore(){
        if(firstHasTieWithSecond(player1points, player2points)){
            return getTiedScore();
        }
        if(firstHasAdvantageOverSecond(player1points, player2points) || firstHasAdvantageOverSecond(player2points, player1points)){
            return getAdvantageScore();
        }
        if(firstWonGameOverSecond(player1points, player2points) || firstWonGameOverSecond(player2points, player1points)){
            return getWonScore();
        }

        return getRegularScore();
    }

    private String getWonScore() {
        return firstWonGameOverSecond(player1points, player2points) ? "Win for " + player1Name : "Win for " + player2Name;
    }

    private static boolean firstWonGameOverSecond(int p1point, int p2point) {
        return p1point >=4 && p2point >=0 && (p1point - p2point)>=2;
    }

    private String getAdvantageScore() {
        return firstHasAdvantageOverSecond(player1points, player2points) ? "Advantage " + player1Name : "Advantage " + player2Name;
    }

    private static boolean firstHasAdvantageOverSecond(int p1point, int p2point) {
        return p1point >= 4 && p1point - p2point == 1;
    }

    private String getRegularScore() {
        return getLiteral(player1points) + "-" + getLiteral(player2points);
    }

    private String getTiedScore() {
        return (player1points > 2 ? "Deuce" : getLiteral(player1points) + "-All");
    }

    private static boolean firstHasTieWithSecond(int p1point, int p2point) {
        return p1point == p2point;
    }

    public void SetP1Score(int number){
        
        for (int i = 0; i < number; i++)
        {
            P1Score();
        }
            
    }
    
    public void SetP2Score(int number){
        
        for (int i = 0; i < number; i++)
        {
            P2Score();
        }
            
    }
    
    public void P1Score(){
        player1points++;
    }
    
    public void P2Score(){
        player2points++;
    }

    public void wonPoint(String player) {
        if (player == "player1")
            P1Score();
        else
            P2Score();
    }
}