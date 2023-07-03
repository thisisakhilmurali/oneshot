public class RemoveVowelFromString {
    public static void main(String[] args) {

        String demoString = "akhil murali";
        int lengthOfString = demoString.length();

        StringBuilder stringBuilder = new StringBuilder(demoString);

        for(int index = lengthOfString - 1; index >= 0; index--) {
            if(isVowel(stringBuilder.charAt(index))) {
                stringBuilder.deleteCharAt(index);
            }
        }

        System.out.print("Resultant String: " + stringBuilder.toString());

    }

    private static boolean isVowel(char ch) {
        ch = Character.toLowerCase(ch);
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }
}