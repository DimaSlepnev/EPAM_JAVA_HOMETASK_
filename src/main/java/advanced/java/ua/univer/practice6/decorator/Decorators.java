package advanced.java.ua.univer.practice6.decorator;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.*;

public class Decorators {
    public static Logger logger = Logger.getLogger(Decorators.class.getSimpleName());

    static {
        try {
            Handler fh = new FileHandler("resources/advanced/practice6/decorator.log");
            fh.setFormatter(new SimpleFormatter());
            logger.addHandler(fh);
            logger.setLevel(Level.ALL);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<String> evenIndexElementsSubList(List<String> sourceList) {
        List<String> evenList = new ArrayList<>();
        logger.log(Level.INFO, "Full list: " + List.of(sourceList));
        for (int i = 0; i < sourceList.size(); i++) {
            if (i % 2 == 0) {
                evenList.add(sourceList.get(i));
            }
        }
        logger.log(Level.INFO, "List with even indexes: " + List.of(evenList));
        return evenList;
    }

}
