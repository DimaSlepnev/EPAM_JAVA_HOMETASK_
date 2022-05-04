package advanced.java.ua.univer.practice6.startegy.cards;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MyDeck implements Deck {

    LinkedList<Card> cards;

    public MyDeck(final int cardsAmount) {
        this.cards = new LinkedList<>();
        for (int i = 0; i < cardsAmount; i++) {
            cards.push(new MyCard(i));
        }
    }

    @Override
    public Card dealCard() {
        return cards.size() == 0 ? null : cards.pop();
    }

    @Override
    public List<Card> restCards() {
        final ArrayList<Card> rest = new ArrayList<>(this.cards);
        cards.clear();
        return rest;
    }

    @Override
    public int size() {
        return cards.size();
    }


}
