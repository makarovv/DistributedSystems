import java.io.*;
import java.net.*;

public class ClubProxy{
    //vars
    private String proxyObj;
    private String host = "localhost";
    private int port = 7896;

    /*private String teamName;
    private Teams[] teams = new Teams[0];
    private String sport;
    private String league; */

    //Constructor
    public ClubProxy(String proxyObj, String host, int port){
        this.proxyObj = proxyObj;
        this.host = host;
        this.port = port; 
    }

    //methods
    public Teams search_Team(String teamName){
        return (Teams) sendCall("search_Team", new Object[]{teamName});
    }

    public void addTeam(String teamName, String sport, String league){
        sendCall("addTeam", new Object[]{teamName, sport, league});
    }

    public Teams[] getAllTeams() {
        return (Teams[]) sendCall("getAllTeams", new Object[]{});
    }

    public String returnClubName(){
        return (String) sendCall("returnClubName", new Object[]{});
    }


    // networking helper method
    private Object sendCall(String methodName, Object[] args) {
        try (Socket s = new Socket(host, port);
             ObjectOutputStream out = new ObjectOutputStream(s.getOutputStream());
             ObjectInputStream  in  = new ObjectInputStream(s.getInputStream())) {

            out.writeObject(new Message(proxyObj, methodName, args));
            out.flush();

            return in.readObject();

        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException("RMI call failed", e);
        }
    }
}
