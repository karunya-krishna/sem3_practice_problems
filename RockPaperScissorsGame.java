import java.util.Random;
import java.util.Scanner;

public class RockPaperScissorsGame {
    static String playRound(String playerMove, String computerMove) {
        if (playerMove.equals(computerMove)) return "Draw";
        if ((playerMove.equals("Rock") && computerMove.equals("Scissors")) ||
            (playerMove.equals("Paper") && computerMove.equals("Rock")) ||
            (playerMove.equals("Scissors") && computerMove.equals("Paper"))) return "Player Wins";
        return "Computer Wins";
    }
    static String normalizeMove(String move) {
        move = move.trim().toLowerCase();
        if (move.equals("rock")) return "Rock";
        if (move.equals("paper")) return "Paper";
        if (move.equals("scissors")) return "Scissors";
        return "";
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        String[] moves = {"Rock", "Paper", "Scissors"};
        int rounds = 5, wins = 0, losses = 0, draws = 0;
        String[][] table = new String[rounds][4];
        for (int i = 0; i < rounds; i++) {
            System.out.print("Enter your move (Rock/Paper/Scissors): ");
            String playerMove = normalizeMove(scanner.nextLine());
            while (playerMove.isEmpty()) {
                System.out.print("Invalid move. Enter Rock/Paper/Scissors: ");
                playerMove = normalizeMove(scanner.nextLine());
            }
            String computerMove = moves[random.nextInt(3)];
            String result = playRound(playerMove, computerMove);
            table[i] = new String[]{String.valueOf(i + 1), playerMove, computerMove, result};
            if (result.equals("Player Wins")) wins++;
            else if (result.equals("Computer Wins")) losses++;
            else draws++;
        }
        System.out.println("\nFinal Summary");
        System.out.printf("%-8s %-15s %-15s %-15s%n", "Round", "Player Move", "Computer Move", "Result");
        for (String[] row : table) System.out.printf("%-8s %-15s %-15s %-15s%n", row[0], row[1], row[2], row[3]);
        System.out.printf("Wins: %d | Losses: %d | Draws: %d | Win %% = %.1f%%%n", wins, losses, draws, wins * 100.0 / rounds);
        scanner.close();
    }
}
