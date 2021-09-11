import java.util.HashMap;
import java.util.Map;

public class StringProbs {

  private static Character firstNonRepeat(String s) {
    
    Map<Character, Integer> repeats = new HashMap<>();
    Map<Character, Integer> noRepeats = new HashMap<>();

    for(int i = 0; i < s.length(); i++) {
      if(!repeats.containsKey(s.charAt(i)) && !noRepeats.containsKey(s.charAt(i))) {
        noRepeats.put(s.charAt(i), i);
      }
      else if(noRepeats.containsKey(s.charAt(i))) {
        noRepeats.remove(s.charAt(i));
        repeats.put(s.charAt(i), i);
      }
    }

    if(noRepeats.isEmpty()) {
      return null;
    }
    int min = s.length(), pos = 0;
    Character ret = null;
    for(Character c : noRepeats.keySet()) {
      pos = noRepeats.get(c);
      if(pos < min) {
        ret = c; 
      }
      min = Math.min(min, pos);
    }
    return ret;
  }

  private static boolean oneEditAway(String st1, String st2) {
    if(st1 == null || st2 == null || st1.isEmpty() || st2.isEmpty()) {
      return false;
    }
    String s1 = (st1.length() <= st2.length())?st1:st2;
    String s2 = (st1.length() > st2.length())?st1:st2;
    if(s2.length() > s1.length() + 1) {
      return false;
    }

    int edits = 0;
    for(int i = 0, j = 0; i < s1.length() && j < s2.length() && edits < 2; i++, j++) {
      if(s1.charAt(i) != s2.charAt(j)) {
        edits++;
        if(s1.length() < s2.length()) {
          j++;
        }
      }
    }
    
    return (edits < 2);
  }

  public static void main(String[] args) {
    charRepeats();
    isOneAway();
  }

  private static void isOneAway() {
    System.out.println("true abcde abcd " + oneEditAway("abcde", "abcd"));  // should return true
    System.out.println("true a a " + oneEditAway("a", "a"));  // should return true
    System.out.println("true abcdef abqdef " + oneEditAway("abcdef", "abqdef"));  // should return true
    System.out.println("true abcdef abccef " + oneEditAway("abcdef", "abccef"));  // should return true
    System.out.println("true abcdef abcde " + oneEditAway("abcdef", "abcde"));  // should return true
    System.out.println("false aaa abc " + oneEditAway("aaa", "abc"));  // should return true
    System.out.println("false abcde abc " + oneEditAway("abcde", "abc"));  // should return true
    System.out.println("false abc abcde " + oneEditAway("abc", "abcde"));  // should return true
    System.out.println("false abc bcc " + oneEditAway("abc", "bcc"));  // should return true
  }

  private static void charRepeats() {
    System.out.println("firstNonRepeat(\"abcab\") = " + firstNonRepeat("abcab")); // should return 'c'
    System.out.println("firstNonRepeat(\"abab\") = " + firstNonRepeat("abab")); // should return null
    System.out.println("firstNonRepeat(\"aabbbc\") = " + firstNonRepeat("aabbbc")); // should return 'c'
    System.out.println("firstNonRepeat(\"aabbdbc\") = " + firstNonRepeat("aabbdbc")); // should return 'd'
  }

}
