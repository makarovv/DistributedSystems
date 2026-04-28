public class App {
    public static int FrankfurtSoccerTeams(Clubs clubs) {
        int count = 0;
        for (Teams t : clubs.getAllTeams()) {
            if (t.getSport().equals("Football") && ((String) t.getName()).contains("Frankfurt")) {
                count++;
            }
        }
        return count;
        
    }

    public static void main(String[] args) throws Exception {
        Clubs Footballclubs = new Clubs();
        Footballclubs.addTeam("Manchester United", "Football", "Premier League");
        Footballclubs.addTeam("Frankfurt Eintracht", "Football", "Bundesliga");

        Clubs Basketballclubs = new Clubs();
        Basketballclubs.addTeam("Los Angeles Lakers", "Basketball", "NBA");
        Basketballclubs.addTeam("Chicago Bulls", "Basketball", "NBA");

        System.out.println("Number of Frankfurt soccer teams: " + FrankfurtSoccerTeams(Footballclubs));
    }
}
