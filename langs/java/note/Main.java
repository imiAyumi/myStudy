package langs.java.studyGuideSe11Gold.note;

import langs.java.studyGuideSe11Gold.note.sample.Factory;
import langs.java.studyGuideSe11Gold.note.sample.Sample;

public class Main {
    public static void main(String[] args) {
        Sample sample = Factory.createSample();
        sample.execute();
    }
}