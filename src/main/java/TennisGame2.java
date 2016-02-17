
public class TennisGame2 implements TennisGame
{
    public int P1point = 0;
    public int P2point = 0;
    
    public String P1res = "";
    public String P2res = "";
    private String player1Name;
    private String player2Name;
    String score;

    public TennisGame2(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    private String getLiteral(int score){
        if(score == 1)
            return "Fifteen";
        if(score == 2)
            return "Thirty";
        if(score == 3)
            return "Forty";
        return "Love";
    }

    public String getScore(){
        if(firstHasTieWithSecond(P1point, P2point)){
            return getTiedScore();
        }
        setRegularScore();
        if(firstHasAdvantageOverSecond(P1point, P2point) || firstHasAdvantageOverSecond(P2point, P1point)){
            return getAdvantageScore();
        }
        if(firstWonGameOverSecond(P1point, P2point) || firstWonGameOverSecond(P2point, P1point)){
            return getWonScore();
        }

        return score;
    }

    private String getWonScore() {
        return firstWonGameOverSecond(P1point, P2point) ? "Win for " + player1Name : "Win for " + player2Name;
    }

    private static boolean firstWonGameOverSecond(int p1point, int p2point) {
        return p1point >=4 && p2point >=0 && (p1point - p2point)>=2;
    }

    private String getAdvantageScore() {
        return firstHasAdvantageOverSecond(P1point, P2point) ? "Advantage " + player1Name : "Advantage " + player2Name;
    }

    private static boolean firstHasAdvantageOverSecond(int p1point, int p2point) {
        return p1point >= 4 && p1point - p2point == 1;
    }

    private void setRegularScore() {
        if(!firstHasTieWithSecond(P1point, P2point) && !firstHasDeuceWithSecond(P1point, P2point))
            score = getLiteral(P1point) + "-" + getLiteral(P2point);
    }

    private String getTiedScore() {
        return (P1point > 2 ? "Deuce" : getLiteral(P1point) + "-All");
    }

    private static boolean firstHasDeuceWithSecond(int p1point, int p2point) {
        return p1point == p2point && p1point >=3;
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
        P1point++;
    }
    
    public void P2Score(){
        P2point++;
    }

    public void wonPoint(String player) {
        if (player == "player1")
            P1Score();
        else
            P2Score();
    }
}