import java.util.StringTokenizer;

public class SplitString {
    public static void main(String[] args) {
        String str = "Raju|25|30000|Tester:raju@gmail.com;Mum,Maharashtra";

        StringTokenizer st = new StringTokenizer(str, "|;:");
        int count = st.countTokens();

        for(int i = 0; i< count; i++){
            System.out.println(st.nextToken());
        }
        
        
    }
}
