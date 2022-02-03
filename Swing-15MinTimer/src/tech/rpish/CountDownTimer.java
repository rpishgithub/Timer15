package tech.rpish;

public class CountDownTimer {
    private int seconds;
    private int minutes;
    private String seconds_string;
    private String minutes_string;

    private void refreshString() {
        seconds_string = String.format("%02d", seconds);
        minutes_string = String.format("%02d", minutes);
    }

    public CountDownTimer() {
        minutes = 15;
        seconds = 0;
        refreshString();
    }

    public String getTime() {
        return minutes_string + ":" + seconds_string;
    }

    public void reset() {
        minutes = 15;
        seconds = 0;
        refreshString();
    }

    /*
    * return true: count down finished
    * return false: not yet
    * */
    public Boolean passOneSecond() {
        if (minutes == 0 && seconds == 0) {
            //Time Out
            AudioPlayer.playAudio();
            reset();
            return true;
        }

        if (seconds == 0) {
            seconds = 59;
            minutes -= 1;
        } else {
            seconds -= 1;
        }
        refreshString();
        return false;
    }
}
