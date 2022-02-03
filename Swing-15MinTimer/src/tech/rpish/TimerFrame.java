package tech.rpish;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TimerFrame extends JFrame {
    private JPanel timerFramePanel;
    private JLabel timeLabel;
    private JButton controlButton;
    private boolean isStarted = false;
    private boolean isFinished = false;
    private CountDownTimer countDownTimer = new CountDownTimer();
    private Timer timer = new Timer(1000, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            isFinished = countDownTimer.passOneSecond();
            if (isFinished) {
                timer.stop();
                countDownTimer.reset();
                isStarted = !isStarted;
                isFinished = !isFinished;
                controlButton.setText("Start");
            }
            refreshLabelContent();
        }
    });

    public void refreshLabelContent() {
        timeLabel.setText(countDownTimer.getTime());
    }

    TimerFrame() {
        timeLabel.setText(countDownTimer.getTime());
        controlButton.setText("Start");
        timeLabel.setFont(new Font("Ink Free", Font.PLAIN, 70));
        controlButton.setFont(new Font("Ink Free", Font.PLAIN, 30));

        this.setContentPane(timerFramePanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400, 400);
        this.setVisible(true);

        controlButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                isStarted = !isStarted;
                if (isStarted) {
                    timer.start();
                    controlButton.setText("Learning");
                } else {
                    timer.stop();
                    countDownTimer.reset();
                    refreshLabelContent();
                    controlButton.setText("Start");
                }
            }
        });
    }
}
