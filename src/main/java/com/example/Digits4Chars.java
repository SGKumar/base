public class Digits4Chars {

  private static int countDecodingsRec(String enc) {
    /*if(enc.length() == 0 || enc.length() == 1) {
      return 1;
    }*/
    return countDecodingsRec(enc, 0, enc.length());
  }

  private static int countDecodingsRec(String enc, int start, int chars) {
    if(chars != 0 && enc.charAt(start) == '0') {
      return 0;
    }
    if(chars == 0 || chars == 1) {
      return 1;
    }

    int tot1 = countDecodingsRec(enc, start+1, chars-1);
    int tot2 = 0;
    if((enc.charAt(start) == '1') || (enc.charAt(start) == '2' && enc.charAt(start+1) <= '6')) {
      tot2 = countDecodingsRec(enc, start+2, chars-2);
    }

    return tot1 + tot2;    
  }

  private static int countDecodings(String enc) {
    if(enc.length() != 0 && enc.charAt(0) == '0') {
      return 0;
    }
    if(enc.length() == 0) {
      return 1;
    }

    int[] decodings = new int[enc.length()+1];
    decodings[0] = 1;
    decodings[1] = 1;

    for(int i = 1; i < enc.length(); i++) {
      if(enc.charAt(i-1) == '1' || (enc.charAt(i-1) == '2' && enc.charAt(i) <= '6')) {
        decodings[i+1] = decodings[i-1] + decodings[i];
      }
      else if(enc.charAt(i-1) > '2' && enc.charAt(i) == '0') {
        break;
      }
      else {
        decodings[i+1] = decodings[i];
      }

    }

    return decodings[enc.length()];
  }


  public static void main(String[] args) {
    System.out.println("Hello Coin Digits4Chars ");

    final String[] strs = {"12", "123", "12305", "13205", "13215", "06", "0", "226", "1234", "11106" };
    for(String str : strs) {
      System.out.println("Rec  Decs for: " + str + " is: " + countDecodingsRec(str));
      System.out.println("Iter Decs for: " + str + " is: " + countDecodings(str));
    }
  }

}