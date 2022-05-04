package advanced.java.ua.univer.practice6.startegy.cards.CardDealingStrategyImpl;

import advanced.java.ua.univer.practice6.startegy.cards.Card;
import advanced.java.ua.univer.practice6.startegy.cards.CardDealingStrategies;
import advanced.java.ua.univer.practice6.startegy.cards.CardDealingStrategy;
import advanced.java.ua.univer.practice6.startegy.cards.Deck;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;

public class ClassicPokerStrategy implements CardDealingStrategy {
    private final int PLAYER_CARDS_AMOUNT = 5;
    Map<String, List<Card>> stack;

    @Override
    public Map<String, List<Card>> dealStacks(Deck deck, int players) {
        stack = new HashMap<>();
        for (int i = 1; i <= players; i++) {
            stack.put("Player " + i, new ArrayList<>());
        }
        for(int i =0; i < PLAYER_CARDS_AMOUNT; i++){
            for(int j = 1; j <= players; j++){
                stack.get("Player " + j).add(deck.dealCard());
            }
        }
        stack.put("Remaining", deck.restCards());
        CardDealingStrategies.logger.log(Level.INFO, " Game start with deck:" + stack);
        return stack;
    }
}
