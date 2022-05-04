package advanced.java.ua.univer.practice6.factory.plot;

import advanced.java.ua.univer.practice6.decorator.Decorators;

import java.io.IOException;
import java.util.logging.*;

class PlotFactories implements PlotFactory {
    public static Logger logger = Logger.getLogger(Decorators.class.getSimpleName());

    static {
        try {
            Handler fh = new FileHandler("resources/advanced/practice6/plotFactories.log");
            fh.setFormatter(new SimpleFormatter());
            logger.addHandler(fh);
            logger.setLevel(Level.ALL);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void createLog(String plot) {
        logger.log(Level.INFO, "This unique plot sounds like: " + plot);
    }

    public PlotFactory classicDisneyPlotFactory(Character hero, Character beloved, Character villain) {
        return () -> new Plot() {
            String plot = hero.name() + " is great. " + hero.name() + " and " + beloved.name() + " love each other. " + villain.name() + " interferes with their happiness but loses in the end.";

            @Override
            public String toString() {
                createLog(plot);
                return plot;
            }
        };
    }

    public PlotFactory contemporaryDisneyPlotFactory(Character hero, EpicCrisis epicCrisis, Character funnyFriend) {
        return () -> new Plot() {
            String plot = hero.name() + " feels a bit awkward and uncomfortable. But personal issues fades, when a big trouble comes - " + epicCrisis.name() + ". " + hero.name() + " stands up against it, but with no success at first.But putting self together and help of friends, including spectacular funny " + funnyFriend.name() + " restore the spirit and " + hero.name() + " overcomes the crisis and gains gratitude and respect";

            @Override
            public String toString() {
                createLog(plot);
                return plot;
            }
        };
    }

    public PlotFactory marvelPlotFactory(Character[] heroes, EpicCrisis epicCrisis, Character villain) {
        StringBuilder plot = new StringBuilder(epicCrisis.name() + " threatens the world. But ");
        for (int i = 0; i < heroes.length; i++) {
            plot.append("brave " + heroes[i].name());
            if (i != heroes.length - 1) {
                plot.append(", ");
            }
        }
        plot.append(" on guard. So, no way that intrigues of " + villain.name() + " overcome the willpower of inflexible heroes");
        return () -> new Plot() {
            @Override
            public String toString() {
                createLog(plot.toString());
                return plot.toString();
            }
        };
    }

    @Override
    public Plot plot() {
        return null;
    }
}
