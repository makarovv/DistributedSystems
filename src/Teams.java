public class Teams {
    private String name;
    private String sport;
    private String league;

    //getters and setters
    public String getName() {
        return name;
    }
    public String getSport() {
        return sport;
    }
    public String getLeague() {
        return league;
    }
    public String setName(String name) {
        this.name = name;
        return name;
    }
    public String setSport(String sport) {
        this.sport = sport;
        return sport;
    }
    // also works for changing the League of a team
    public String setLeague(String league) {
        this.league = league;
        return league;
    }

}
