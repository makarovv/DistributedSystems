
import java.rmi.Naming;

public class DateClient {
  public static void main (String[] args) throws Exception {
    if (args.length != 1)
      throw new IllegalArgumentException ("Syntax: DateClient <hostname>");
          
    try {
          
      DateServer dateServer = (DateServer) Naming.lookup
        ("rmi://" + args[0] + "/myObject");
      //Date when = dateServer.getDate ();
      //System.out.println ("Date: " + when);

      Clubs fc = new Clubs("Eintracht Frankfurt");
      Clubs bc = new Clubs("Golden Gate Warriors");

      
        
    } catch (Exception e) {
		System.out.println("DateClient: " + e.getMessage());
	    e.printStackTrace();
	}
    
  }
}
