import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

class Main {
    public static void main(String[] args) {
        // Create a new scanner for user input
        Scanner scanner = new Scanner(System.in);

        // Create a new random number generator
        Random rand = new Random();

        // Default choices
        List<String> choices = Arrays.asList("rock", "paper", "scissors");

        // Score Management
        Map<String, Integer> scores = new HashMap<>();
        try {
            File file = new File("rating.txt");
            Scanner fileScanner = new Scanner(file);

            while (fileScanner.hasNext()) {
                String name = fileScanner.next();
                int score = fileScanner.nextInt();
                scores.put(name, score);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }

        System.out.println("Enter your name:");
        String userName = scanner.nextLine();
        System.out.println("Hello, " + userName);

        int userScore = scores.getOrDefault(userName, 0);

        System.out.println("Enter game options:");
        String gameOptionsInput = scanner.nextLine();
        if (!gameOptionsInput.isBlank()) {
            choices = Arrays.asList(gameOptionsInput.split(","));
        }
        System.out.println("Okay, let's start");

        while (true) {
            // Get the user's choice
            String userChoice = scanner.nextLine().toLowerCase();

            // Check if the user wants to exit
            if (userChoice.equals("!exit")) {
                System.out.println("Bye!");
                break;
            }

            // Check user's rating
            if (userChoice.equals("!rating")) {
                System.out.println("Your rating: " + userScore);
                continue;
            }

            // Check if the user's choice is valid
            if (!choices.contains(userChoice)) {
                System.out.println("Invalid input");
                continue;
            }

            // Determine the computer's choice
            List<String> shuffledChoices = new ArrayList<>(choices);
            Collections.shuffle(shuffledChoices);
            String computerChoice = choices.get(rand.nextInt(choices.size()));


            // Determine index positions of user and computer choices
            int userChoiceIndex = choices.indexOf(userChoice);
            int computerChoiceIndex = choices.indexOf(computerChoice);

            // Determine the winning range
            int winningHalfStart = (userChoiceIndex + 1) % choices.size();
            int winningHalfEnd = (userChoiceIndex + choices.size() / 2) % choices.size();

            // Check if user wins, loses or draws
            if (userChoiceIndex == computerChoiceIndex) {
                System.out.println("There is a draw (" + computerChoice + ")");
                userScore += 50;
            } else {
                List<String> tempChoices = new ArrayList<>(choices);
                Collections.rotate(tempChoices, -userChoiceIndex);

                if (tempChoices.indexOf(computerChoice) <= tempChoices.size() / 2) {
                    System.out.println("Sorry, but the computer chose " + computerChoice);
                    // The computer won
                } else {
                    System.out.println("Well done. The computer chose " + computerChoice + " and failed");
                    userScore += 100;
                    // The user won
                }

            }
        }
    }

}