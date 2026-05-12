import java.io.*;
import java.net.*;

public class ClubProxy{
    //vars
    private String objectId;
    private String host = "localhost";
    private String port = "7896";

    /*private String teamName;
    private Teams[] teams = new Teams[0];
    private String sport;
    private String league; */

    //Constructor
    public ClubProxy(String objectId, String host, String port){
        this.objectId = objectId;
        this.host = host;
        this.port = port; 
    }

    //methods
    public Teams search_Teams(String teamName){
        return (Teams) sendCall("search_Teams",new Object[]);
    }

    public void addTeam(String teamName, String sport, String league){

    }

    public Teams[] getAllTeams() {

    }

    public String returnClubName(){

    }

    private Object sendCall(String methodName, Object[] args) {
        try (Socket s = new Socket("localhost", 7896);
             ObjectOutputStream out = new ObjectOutputStream(s.getOutputStream());
             ObjectInputStream  in  = new ObjectInputStream(s.getInputStream())) {

            out.writeObject(new Message(proxyObj, methodName, args));
            out.flush();

            Object result = in.readObject();
            if (result instanceof Throwable t)
                throw new RuntimeException("remote error", t);
            return result;
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException("RMI call failed", e);
        }
    }
}
