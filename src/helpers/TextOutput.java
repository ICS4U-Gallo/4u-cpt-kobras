package helpers;

public class TextOutput {
    public static String s;
    public static void formatString() {
        int count = 40;
        while(count < s.length()) {
            count = s.indexOf(" ",count );
            if(count == -1) {
                return;
            }
            s = s.substring(0,count) + "\n" + s.substring(count);
            count+= 40;
        }
    }
//    public static void setString(String s) {
//        int counter = 0;
//
//        while (counter > s.length()) {
//            counter++;
//            if(counter % 50 )
//        }
//    }

}
