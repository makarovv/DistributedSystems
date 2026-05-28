# Exercise 2 (preliminary)
Continuing task 2 of sheet 1, implement a class *Car* with the private attributes colour, horsepower and weight. The class should contain the following methods:
* Constructor with three parameters that initializes the three attributes with the corresponding parameter values
* 'print' that is displaying the values of the three attributes on the screen.
Additionally, create an interface Display that contains just a method 'print', let the classes Publication and Car implement the interface.
Write an appropriate main that can test the functionality of ur classes.

# Exercise 3 (preliminary)
Realize a simple management system for sports Clubs and their Teams. Implement two classes Clubs and Teams:
### Clubs
* Search for a team with a particular name. Assume there is only one obj with that name at most. The method returns the corresponding team obj
* Add a new team to the club. Three params: name, sport, league. The team obj is the created and added to the collection of teams of the corresponding club.
* Return the set of all teams in a club. (collection of objects, not a number of objs!)
* Return the name of the club

### Teams
* Return the name
* Return the sport
* Return the league
* Change the league

# Exercise 4 (assessed)
## Realize a remote method invocation by using plain TCP sockets (without any middleware)

Extend the client-server code example so that the client can invoke methods on the server and a corresponding return value is delivered to the client. Therefore, extend the management system from the last exercise. Use *two* Club objs on the server. Create a class ClubProxy tht is used only within the client. This class provides methods with the same signatures as the Club class methods. For each Clubs obj on the server, a corresponding obj of the class ClubProxy should exist on the client. Clubs objs only exist on the server side and must not be used on the client.

The client should be bale to invoke the four methods defined in ex3 on the Club objs. THe client does so by invoking the method on the corresponding proxy obj. The proxy obj then forwards the request to the server. On the server the method then gets invoked on the corresponding Club obj and the return value is sent back to the proxy obj. 

To realize this solution you need to transport the info abt the obj, the method invoked and any parameters by means of TCP Sockets. Similarly the return value must also be transported the same way.  Solve that by implementing a Message class. A message obj should contain different attributes for different pieces of necessary information for the method invocation. This obj can be de-/serialized using the 'ObjectOutputStream' class. The serialized obj can then be transported via TCP Socket just like the return value. The use of a message obj is not needed for the transportation of the return value!

# Exercise 5 (assessed)
Extend the management system for Sports clubs from exercise sheet 3 to create a client-server based system using Java RMI.
Transform the objects of the classes Club and Team into remote objects. All Club and team objs exist only on the server side! Each Club has a separate club obj. Similar to exercise 3, Clubs has two attributes: name and a set of team Objs. This set should represent the teams that belong to the club and should not be simply represented by a number. Each team has three private attributes: name, sport and league in which the team competes. 

### Club class methods that can be invoked from the client
* Search for a team by name. Assume at most one obj with that name can exist. Return a refference to the team obj
* Add a new team to the club. Three params: name, sport and league. Creates a corresponding Team obj and adds it onto the set of teams of the club.
* Return the set of all team objs of the club. Return value has to be a collection of references to the team objs and not just a number.
* Return the club name.

### Team class methods that can be invoked from the client
* Return the name
* Return the sport
* Return the league
* Change the league

Implement a client that is calling all methods of the objects on the server in a sensible manner. The client should be able to calculate based on the methods above the total number of all teams with sport "football" of the club with the name "Frankfurt". The nameservice has to be started by means of the rmiregistry command.