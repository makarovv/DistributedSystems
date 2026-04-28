package exercise3;
public class Clubs {
    private String name;
    private Teams[] teams = new Teams[0];   

    //getter and setter for clubs
    public String getName() {
        return name;
    }
    public String setName(String name) {
        this.name = name;
        return name;
    }

    //Constructor 
    public Clubs(String name) {
        this.name = name;
    }

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
