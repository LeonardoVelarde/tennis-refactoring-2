
public class TennisGame2 implements TennisGame
{
    public int P1point = 0;
    public int P2point = 0;
    
    public String P1res = "";
    public String P2res = "";
    private String player1Name;
    private String player2Name;

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
        String score = "";
        score = getTiedScore(score);
        score = getRegularScore(score);
        score = getAdvantageScore(score);
        score = getWonScore(score);

        return score;
    }

    private String getWonScore(String score) {
        if (firstWonGameOverSecond(P1point, P2point))
        {
            score = "Win for player1";
        }
        if (firstWonGameOverSecond(P2point, P1point))
        {
            score = "Win for player2";
        }
        return score;
    }

    private static boolean firstWonGameOverSecond(int p1point, int p2point) {
        return p1point >=4 && p2point >=0 && (p1point - p2point)>=2;
    }

    private String getAdvantageScore(String score) {
        if (firstHasAdvantageOverSecond(P1point, P2point))
        {
            score = "Advantage player1";
        }

        if (firstHasAdvantageOverSecond(P2point, P1point))
        {
            score = "Advantage player2";
        }
        return score;
    }

    private static boolean firstHasAdvantageOverSecond(int p1point, int p2point) {
        return p1point > p2point && p2point >= 3;
    }

    private String getRegularScore(String score) {

        if(firstHasNormalTieWithSecond(P1point, P2point) || firstHasDeuceWithSecond(P1point, P2point))
            return score;
        return getLiteral(P1point) + "-" + getLiteral(P2point);
    }

    private String getTiedScore(String score) {
        if (firstHasNormalTieWithSecond(P1point, P2point))
        {
            score = getLiteral(P1point);
            score += "-All";
        }
        if (firstHasDeuceWithSecond(P1point, P2point))
            score = "Deuce";
        return score;
    }

    private static boolean firstHasDeuceWithSecond(int p1point, int p2point) {
        return p1point == p2point && p1point >=3;
    }

    private static boolean firstHasNormalTieWithSecond(int p1point, int p2point) {
        return p1point == p2point && p1point < 3;
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