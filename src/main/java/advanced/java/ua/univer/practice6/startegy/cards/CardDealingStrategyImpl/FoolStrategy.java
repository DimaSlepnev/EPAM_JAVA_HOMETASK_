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

public class FoolStrategy implements CardDealingStrategy {
    private final int PLAYER_CARDS_AMOUNT = 6;
    private final int TRUMP_CART_AMOUNT = 1;
    Map<String, List<Card>> stack;

    @Override
    public Map<String, List<Card>> dealStacks(Deck deck, int players) {
        stack = new HashMap<>();
        List<Card> trumpCart = new ArrayList<>();
        List<Card> rem = new ArrayList<>();
        for (int i = 1; i <= players; i++) {
            stack.put("Player " + i, new ArrayList<>());
        }
        for(int i =0; i < PLAYER_CARDS_AMOUNT; i++){
            for(int j = 1; j <= players; j++){
                stack.get("Player " + j).add(deck.dealCard());
            }
        }
        stack.put("Remaining", rem );
        stack.put("Trump card", trumpCart);
        for(int i =0; i < TRUMP_CART_AMOUNT; i++){
            stack.get("Trump card").add(deck.dealCard());
        }
        stack.put("Remaining", deck.restCards());
        CardDealingStrategies.logger.log(Level.INFO, " Game start with deck:" + stack);
        return stack;
    }
}
