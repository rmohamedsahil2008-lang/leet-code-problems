class Solution {
    public boolean isNumber(String s) {
        if (s == null || s.trim().isEmpty()) {
            return false;
        }

        try {
            Double.parseDouble(s);
            char last = s.charAt(s.length() - 1);
            return Character.isDigit(last) || last == '.';
        } catch (NumberFormatException e) {
            return false;
        }
    }
}