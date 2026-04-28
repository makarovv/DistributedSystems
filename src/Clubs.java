public class Clubs {
    private String name;
    private Teams[] teams = new Teams[0];   

    // methods
    public Teams search_Team (String name) {
        for (Teams t : teams) {
            if (t.getName().equals(name)) {
                return t;
            }
        }
        return null;
    }

    public void addTeam(String name, String sport, String league) {
        //create a net team and set its values
        Teams newTeam = new Teams();
        newTeam.setName(name);
        newTeam.setSport(sport);
        newTeam.setLeague(league);

        // Add the new team to the array
        Teams[] newTeamArray = new Teams[teams.length + 1];
        System.arraycopy(teams, 0, newTeamArray, 0, teams.length);
        newTeamArray[teams.length] = newTeam;
        teams = newTeamArray;
    }

    public Teams[] getAllTeams() {
        return teams;
    }

    public String returnClubName () {
        return name;
    }   
}
