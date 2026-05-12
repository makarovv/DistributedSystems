import java.io.Serializable;

public class Message implements Serializable {
    private String methodName;
    private String proxyObj;
    private String[] params = new String[0];

    //Constructor
    public Message(String proxyObj, String methodName, String[] params){
        this.proxyObj = proxyObj;
        this.methodName = methodName;
        this.params = params;
    }

    public String getproxyObj(){
         return proxyObj;
        }

    public String getMethodName(){
        return methodName;
    }
    public Object[] getParams(){
        return params;
    }
}
