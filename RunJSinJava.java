
import java.io.FileReader;
import java.util.*;
import javax.script.*;
 
public class RunJSinJava {
    public static void main(String[] args) {
        try {
            ScriptEngineManager mgr = new ScriptEngineManager();
            List<ScriptEngineFactory> list = mgr.getEngineFactories();
            list.forEach(sef -> System.out.println(sef.getEngineName()));
 
 
            
            // ScriptEngine engine = mgr.getEngineByName("JavaScript");
            // engine.eval("print('Hello Everybody!')");
 
            ScriptEngine engine = mgr.getEngineByName("graal.js");
            engine.eval(new FileReader("Demo.js"));



 
            Invocable inv = (Invocable) engine;
            inv.invokeFunction("abc");
            inv.invokeFunction("add", 10, 20);
            String name = (String)
            inv.invokeFunction("greet", "Wissen","Technology");
 
            System.out.println("Welcome to " + name);
 
 
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
 

/*

    <dependency>
	  <groupId>org.graalvm.js</groupId>
	  <artifactId>js</artifactId>
	  <version>22.0.0</version>
	</dependency>  
	<dependency>
	  <groupId>org.graalvm.js</groupId>
	  <artifactId>js-scriptengine</artifactId>
	  <version>22.0.0</version>
	</dependency>
 */