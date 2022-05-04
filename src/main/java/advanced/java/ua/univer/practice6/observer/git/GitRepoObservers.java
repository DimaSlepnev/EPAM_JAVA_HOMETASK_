package advanced.java.ua.univer.practice6.observer.git;


import advanced.java.ua.univer.practice6.decorator.Decorators;

import java.io.IOException;
import java.util.logging.*;

public class GitRepoObservers {
    public static Logger logger = Logger.getLogger(GitRepoObservers.class.getSimpleName());

    static {
        try {
            Handler fh = new FileHandler("resources/advanced/practice6/Observe.log");
            fh.setFormatter(new SimpleFormatter());
            logger.addHandler(fh);
            logger.setLevel(Level.ALL);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Repository newRepository(){
        return new MyRepository();
    }

    public static WebHook mergeToBranchWebHook(String branchName){
        return new MyWebHook(branchName, Event.Type.MERGE);
    }

    public static WebHook commitToBranchWebHook(String branchName){
        return new MyWebHook(branchName, Event.Type.COMMIT);
    }


}
