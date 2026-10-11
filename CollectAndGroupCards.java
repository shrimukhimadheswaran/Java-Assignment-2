
import java.util.*;

class Card {
    char symbol;
    int number;

    Card(char symbol, int number) {
        this.symbol = symbol;
        this.number = number;
    }
}

public class CollectAndGroupCards {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        TreeMap<Character, ArrayList<Card>> map =
                new TreeMap<>();

        System.out.println("Enter Number of Cards :");
        int n = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            System.out.println("Enter card " + i + ":");
            char symbol = sc.next().charAt(0);
            int number = sc.nextInt();

            Card card = new Card(symbol, number);

            map.putIfAbsent(symbol, new ArrayList<Card>());
            map.get(symbol).add(card);
        }

        System.out.println("Distinct Symbols are :");
        for (char symbol : map.keySet()) {
            System.out.print(symbol + " ");
        }
        System.out.println();

        for (char symbol : map.keySet()) {
            ArrayList<Card> cards = map.get(symbol);
            int sum = 0;

            System.out.println("Cards in " + symbol + " Symbol");

            for (Card card : cards) {
                System.out.println(card.symbol + " " + card.number);
                sum += card.number;
            }

            System.out.println("Number of cards : " + cards.size());
            System.out.println("Sum of Numbers : " + sum);
        }

        sc.close();
    }
}
