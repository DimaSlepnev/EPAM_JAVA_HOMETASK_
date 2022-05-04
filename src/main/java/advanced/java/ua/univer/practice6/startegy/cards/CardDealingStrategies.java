package advanced.java.ua.univer.practice6.startegy.cards;

import advanced.java.ua.univer.practice6.observer.git.GitRepoObservers;
import advanced.java.ua.univer.practice6.startegy.cards.CardDealingStrategyImpl.BridgeStrategy;
import advanced.java.ua.univer.practice6.startegy.cards.CardDealingStrategyImpl.ClassicPokerStrategy;
import advanced.java.ua.univer.practice6.startegy.cards.CardDealingStrategyImpl.FoolStrategy;
import advanced.java.ua.univer.practice6.startegy.cards.CardDealingStrategyImpl.TexasStrategy;

import java.io.IOException;
import java.util.logging.*;

public class CardDealingStrategies {
    public static Logger logger = Logger.getLogger(CardDealingStrategies.class.getSimpleName());

    static {
        try {
            Handler fh = new FileHandler("resources/advanced/practice6/Strategy.log");
            fh.setFormatter(new SimpleFormatter());
            logger.addHandler(fh);
            logger.setLevel(Level.ALL);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static CardDealingStrategy texasHoldemCardDealingStrategy() {
        return new TexasStrategy();
    }

    public static CardDealingStrategy classicPokerCardDealingStrategy() {
        return new ClassicPokerStrategy();
    }

    public static CardDealingStrategy bridgeCardDealingStrategy(){
        return new BridgeStrategy();
    }

    public static CardDealingStrategy foolCardDealingStrategy(){
        return new FoolStrategy();
    }

}
