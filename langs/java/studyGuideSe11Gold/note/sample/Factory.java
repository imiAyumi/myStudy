package langs.java.studyGuideSe11Gold.note.sample;

import java.util.ArrayList;
import java.util.List;

public class Factory {
    public static Sample createSample() {
        return () -> System.out.println("lambda hello");
    }

    public static Test creatTest() {
        return (a, b) -> {
            List<String> list = new ArrayList<>();
            list.add(a);
            list.add(b);
            return list;
        };
    }

    // class SampleImpl implements Sample {
    // @Override
    // public void execute() {
    // System.out.println("sampleImple hello");
    // }
    // }
}