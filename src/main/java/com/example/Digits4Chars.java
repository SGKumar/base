public class Digits4Chars {

  private static int countDecodings(String enc) {
    /*if(enc.length() == 0 || enc.length() == 1) {
      return 1;
    }*/
    return countDecodings(enc, 0, enc.length());
  }

  private static int countDecodings(String enc, int start, int chars) {
    if(enc.charAt(start) == '0') {
      return 0;
    }
    if(chars == 0 || chars == 1) {
      return 1;
    }

    int tot1 = countDecodings(enc, start+1, chars-1);
    int tot2 = 0;
    if((enc.charAt(start) == '1') || (enc.charAt(start) == '2' && enc.charAt(start+1) <= '6')) {
      tot2 = countDecodings(enc, start+2, chars-2);
    }

    return tot1 + tot2;    
  }

  public static void main(String[] args) {
    System.out.println("Hello Coin Digits4Chars ");
    final String str = "11106";//"06"; //"0"; //"226"; 
    System.out.println("Decs for " + str + " is: " + countDecodings(str));
  }

}