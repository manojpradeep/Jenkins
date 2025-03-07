class MiddleCharacter {
public static String getMiddleCharacter(String str) {
if (str == null || str.isEmpty()) {
return "Invalid input";
}
int len = str.length();
int mid = len / 2;
return (len % 2 == 0) ? str.substring(mid - 1, mid + 1) : String.valueOf(str.charAt(mid));
}
public static void main(String[] args) {
String input = "Jenkins";  // Example input
System.out.println("Middle character(s): " + getMiddleCharacter(input));
}
}
