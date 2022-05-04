package advanced.java.ua.univer.practice6.observer.git;

import java.util.ArrayList;
import java.util.List;

public class MyWebHook implements WebHook{
    private String branch;
    private Event.Type type;
    private List<Event> caughtEvents;

    public MyWebHook(String branch, Event.Type type) {
        this.branch = branch;
        this.type = type;
        this.caughtEvents = new ArrayList<>();
    }

    @Override
    public String branch() {
        return branch;
    }

    @Override
    public Event.Type type() {
        return type;
    }

    @Override
    public List<Event> caughtEvents() {
        return caughtEvents;
    }

    @Override
    public void onEvent(Event event) {
        caughtEvents.add(event);
    }
}
