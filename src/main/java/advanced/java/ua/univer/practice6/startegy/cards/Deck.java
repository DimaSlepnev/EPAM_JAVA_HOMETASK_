package advanced.java.ua.univer.practice6.startegy.cards;

import java.util.List;

public interface Deck{
    Card dealCard();
    List<Card> restCards();
    int size();
}
