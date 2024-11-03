public class Algorithms1 {
    public static void main(String[] args){
        // 1. Cutting The Logs
        int length[] = {1,2,3,4,5,6,7,8,9,10}; // Example array for log lengths
        int prices[] = {1,5,8,9,10,17,17,20,24,30}; // Example array for prices

        // The length of the sample test arrays containing the random numbers and strings to be generated
        int[] arrlengths = {5,10,15,20,25,50,100};

        System.out.println("1. Cutting The Logs");
        System.out.println("--------------------------------");
        System.out.println("Input Size\tExecution Time(ms)");
        System.out.println("--------------------------------");

        // Measure the running times of the algorithm for each input size
        for (int i = 0; i < arrlengths.length; i++) {
            // Placing random log lengths into the array whose length is specified above
            int[] inchArr = generateRandomArray(arrlengths[i]);

            long totalTime = 0; // Starting execution time
            for (int j = 0; j < inchArr.length; j++){
                long startTime = System.currentTimeMillis(); // Time before function starts
                maxOfTwoArr(length, prices, inchArr[j]); // Using the algorithm
                long endTime = System.currentTimeMillis(); // Time after function starts
                long executionTime = endTime - startTime;
                totalTime += executionTime; // Sum to find total execution time
            }
            System.out.println(arrlengths[i] + "\t\t\t" + totalTime+ " ms");
        }

        //2. Longest Common Strings
        String exampleString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"; // Sample string to compare
        System.out.println("2. Longest Common Strings");
        System.out.println("--------------------------------");
        System.out.println("Input Size\tExecution Time(ms)");
        System.out.println("--------------------------------");

        // Measure the running times of the second algorithm for each input size
        for (int x = 0; x < arrlengths.length; x++) {
            // Create a string array containing random uppercase letters
            String[] strArr = generateRandomUppercaseStrings(arrlengths[x],10);

            long totalTime = 0;
            for (int y = 0; y < strArr.length; y++){
                long startTime = System.currentTimeMillis(); //Time before function starts
                LCS(exampleString,strArr[y],exampleString.length(),strArr[y].length()); // Using the algorithm
                long endTime = System.currentTimeMillis(); //Time after function starts
                long executionTime = endTime - startTime;
                totalTime += executionTime; // Sum to find total execution time
            }
            System.out.println(arrlengths[x] + "\t\t\t" + totalTime+ " ms");
        }
    }

    // Recursive function for rod-cutting problem
    public static int maxOfTwoArr(int[] lengths, int[] prices, int inch) {
        // Base case check - return 0 if arrays are empty or inch is negative
        if (lengths.length == 0 || prices.length == 0 || inch <= 0)
            return 0;

        int maxValue = Integer.MIN_VALUE;

        //Loop through the array, checking all possible cuttings
        for (int i = 0; i < lengths.length; i++) {
            // If length is less than or equal to inches
            if (lengths[i] <= inch) {
                //Calculate current revenue and update maxValue
                int currentRevenue = prices[i] + maxOfTwoArr(lengths, prices, inch - lengths[i]);
                maxValue = Math.max(maxValue, currentRevenue);
            }
        }
        return maxValue; // Return the highest revenue
    }

    // Recursive function to find the longest common substring between two strings
    public static int LCS(String x, String y,int m, int n){
        // Base case check - If the length of a string is 0, LCS is 0
        if( m == 0 || n == 0)
            return 0;

        // If characters match, continue recursively to check the previous character
        if(x.charAt(m-1) == y.charAt(n-1))
            return 1 + LCS(x, y, m - 1, n - 1);

        // If not matched, continue by moving to the previous character for both strings
        else
            return Math.max(LCS(x, y, m - 1, n),LCS(x, y, m, n - 1));
    }

    // Helper function to create a random integer array of a certain length
    public static int[] generateRandomArray(int length) {
        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            arr[i] = (int) (Math.random() * 26) + 5; // Generating a random integer between 5 and 30 (inclusive)
        }
        return arr;
    }

    // Helper function to create a string array containing random uppercase letters of a certain length and a certain character length
    public static String[] generateRandomUppercaseStrings(int arrayLength, int stringLength) {
        String[] randomStrings = new String[arrayLength];
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"; // Character set to use for random letter selection

        //Creating a string array of the specified length
        for (int i = 0; i < arrayLength; i++) {
            StringBuilder randomString = new StringBuilder();

            // Loop for the specified number of characters
            for (int j = 0; j < stringLength; j++) {
                int randomIndex = (int) (Math.random() * characters.length()); // Selecting a random index from the character set

                // Taking the character at the selected index and adding it to StringBuilder
                char randomChar = characters.charAt(randomIndex);
                randomString.append(randomChar);
            }
            randomStrings[i] = randomString.toString();
        }
        return randomStrings; // Returning the created random string array
    }
}