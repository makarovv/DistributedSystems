

public class TCPClient {
  public static void main (String args[]) {
      // args[0]: Message, currently disabled, only input is the Servername
      // args[1]: Server
      String host = args.length > 0 ? args[0] : "localhost";
      int serverPort = 7896;

      // init two clubproxy clone objs
      ClubProxy football = new ClubProxy("football", host, serverPort);
      ClubProxy basketball = new ClubProxy("basketball", host, serverPort);
      
	  // add some teams
      football.addTeam("Eintracht", "Football", "Bundesliga");
      football.addTeam("Levski FC", "Football", "European League");
      basketball.addTeam("LA Lakers", "Basketball", "NBA");
	  
      System.out.println("Club name: "+ football.returnClubName());
      
	  // for every team t in football grab all the teams and system print em
      for (Teams t : football.getAllTeams()){
          System.out.println(" - " + t);
      }
      
	  // init found teams and search for a football team and then system print
      Teams found = football.search_Team("Eintracht");
      System.out.println("Search 'Eintracht' : " + found);
      
	  // same thing with a basketball team
      System.out.println("Basketball teams: ");
      for(Teams t : basketball.getAllTeams()){
          System.out.println(" - " + t);
      }

  }// main
}// class