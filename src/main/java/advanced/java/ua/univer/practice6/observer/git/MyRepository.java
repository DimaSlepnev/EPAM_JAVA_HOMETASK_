package advanced.java.ua.univer.practice6.observer.git;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

public class MyRepository implements Repository {
    List<WebHook> observers = new ArrayList<>();
    List<Event> eventList = new ArrayList<>();

    @Override
    public void addWebHook(WebHook webHook) {
        observers.add(webHook);
    }

    @Override
    public Commit commit(String branch, String author, String[] changes) {
        Commit commit = new Commit(author, changes);
        for (int i = 0; i < observers.size(); i++) {
            if (observers.get(i).type() == Event.Type.COMMIT && observers.get(i).branch().compareTo(branch) == 0) {
                Event event = new Event(Event.Type.COMMIT, branch, List.of(commit));
                observers.get(i).onEvent(event);
                eventList.add(event);
                GitRepoObservers.logger.log(Level.INFO, "add " + event + " to events list");
            }
        }
        return commit;
    }

    @Override
    public void merge(String sourceBranch, String targetBranch) {
        List<Commit> commits = new ArrayList<>();
        WebHook source = null;
        WebHook target = null;
        for (WebHook webHook : observers) {
            if (webHook.branch().equals(sourceBranch) && webHook.type() == Event.Type.COMMIT) {
                source = webHook;
            } else if (webHook.branch().equals(targetBranch) && webHook.type() == Event.Type.MERGE) {
                target = webHook;
            }
        }
        if (source != null && target != null) {
            for (var event : source.caughtEvents())
                commits.addAll(event.commits());
            if (commits.size() != 0)
                target.onEvent(new Event(Event.Type.MERGE, targetBranch, commits));
            observers.set(observers.indexOf(source), new MyWebHook(source.branch(), source.type()));
        }
    }
}
