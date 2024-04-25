package edu.sjsu;

public class NameChecker {
    /**
     * Checks if a given string is a valid name following these rules:
     * - Between 2 to 40 characters
     * - Contains only alphabetic characters, non-consecutive hyphens, or a single quote
     * - Cannot start with a hyphen or single quote
     * 
     * @param input Name to check
     * @return True if input is a valid name, else false
     */
    public static boolean check(String input) {
        if (input.length() < 2 || input.length() > 40)
            return false;

        // check first character is letter
        char ch = input.charAt(0);
        if (!Character.isLetter(ch))
            return false;
        
        char prevch = ch;
        boolean hasQuote = false;

        for (int i = 1; i < input.length(); i++)
        {
            ch = input.charAt(i);
            // check for consecutive hyphen
            if (ch == '-' && prevch == '-')
                return false;
            // check for single quote
            if (ch == '\'')
            {
                if (hasQuote)
                    return false;
                hasQuote = true;
            }
            // check for invalid characters
            if (!Character.isLetter(ch) && ch != '\'' && ch != '-')
                return false;
            prevch = ch;
        }
            
        return true;
    }
}
