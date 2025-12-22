class DeckOfCards {

    // This method creates a complete deck of cards using suits and ranks
    static String[] createDeck(String[] suits, String[] ranks) {

        // Total number of cards in the deck
        int totalCards = suits.length * ranks.length;

        // Array to store all cards
        String[] deck = new String[totalCards];
        int index = 0;

        // Combining each rank with each suit
        for (String suit : suits) {
            for (String rank : ranks) {
                deck[index++] = rank + " of " + suit;
            }
        }

        // Returning the created deck
        return deck;
    }

    // This method shuffles the deck of cards randomly
    static void shuffleDeck(String[] deck) {

        int n = deck.length;

        // Loop to shuffle cards
        for (int i = 0; i < n; i++) {

            // Generate random index between i and n
            int randomIndex = i + (int) (Math.random() * (n - i));

            // Swap current card with random card
            String temp = deck[i];
            deck[i] = deck[randomIndex];
            deck[randomIndex] = temp;
        }
    }

    // This method distributes cards to given number of players
    static String[][] distributeCards(String[] deck, int players, int cardsEach) {

        // Check if enough cards are available
        if (players * cardsEach > deck.length)
            return null;

        // 2D array to store players and their cards
        String[][] result = new String[players][cardsEach];
        int index = 0;

        // Distributing cards one by one to each player
        for (int i = 0; i < players; i++) {
            for (int j = 0; j < cardsEach; j++) {
                result[i][j] = deck[index++];
            }
        }

        return result;
    }

    // This method prints the cards of each player
    static void printPlayers(String[][] players) {

        for (int i = 0; i < players.length; i++) {
            System.out.println("Player " + (i + 1) + ":");

            // Printing cards of current player
            for (String card : players[i]) {
                System.out.println("  " + card);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        // Defining suits and ranks
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        String[] ranks = {"2","3","4","5","6","7","8","9","10",
                          "Jack","Queen","King","Ace"};

        // Creating and shuffling the deck
        String[] deck = createDeck(suits, ranks);
        shuffleDeck(deck);

        // Distributing 5 cards to 4 players
        String[][] players = distributeCards(deck, 4, 5);

        // Printing result
        if (players != null) {
            printPlayers(players);
        } else {
            System.out.println("Not enough cards to distribute");
        }
    }
}
