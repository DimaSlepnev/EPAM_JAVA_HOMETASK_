package advanced.java.ua.univer.practice6.startegy.cards;

import java.util.List;
import java.util.Map;

public interface CardDealingStrategy {
    Map<String, List<Card>> dealStacks(Deck deck, int players);
}
