import static java.lang.Math.*;

public class Preference {

    private final int quietTime; private final int music;
    private final int reading; private final int chatting;


    public Preference(int pQuietTime, int pMusic, int pReading, int pChatting) {
        quietTime = getInfo(pQuietTime);
        music = getInfo(pMusic);
        reading = getInfo(pReading);
        chatting = getInfo(pChatting);
    }
    private int getInfo(int info) {
        final int value;
        if(info < 0) value = 0;
        else value = min(info, 10);
        return value;
    }

    public int preferenceCalc(Preference preference) {
        int diffQuiteTime = abs(quietTime - preference.quietTime);
        int diffMusic = abs(music - preference.music);
        int diffReading = abs(reading - preference.reading);
        int diffChatting = abs(chatting - preference.chatting);

        return (diffQuiteTime + diffMusic + diffReading + diffChatting);
    }
}
