 class Solution {
    public boolean checkIfInstanceOf(Object obj, Class<?> classFunction) {
        if (obj == null || classFunction == null) {
            return false;
        }

        // Check using inheritance
        if (classFunction.isInstance(obj)) {
            return true;
        }

        // Handle primitive wrapper cases
        if (classFunction == Number.class && obj instanceof Number) {
            return true;
        }
        if (classFunction == String.class && obj instanceof String) {
            return true;
        }
        if (classFunction == Boolean.class && obj instanceof Boolean) {
            return true;
        }
        if (classFunction == Character.class && obj instanceof Character) {
            return true;
        }

        return false;
    }
}
