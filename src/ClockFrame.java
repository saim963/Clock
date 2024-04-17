package src;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ClockFrame extends JFrame {
    SimpleDateFormat timeFormat;
    SimpleDateFormat dayFormat;
    SimpleDateFormat dateFormat;
    JLabel timeLabel;
    JLabel dayLabel;
    JLabel dateLabel;
    String time;
    String day;
    String date;
    ClockFrame(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("MyClock");
        this.setLayout(new FlowLayout());
        setPreferredSize(new Dimension(300, 200));
//        this.setResizable(false);

        timeFormat = new SimpleDateFormat("HH:mm:ss");
        timeLabel = new JLabel();
        timeLabel.setFont(new Font("Monospaced", Font.PLAIN, 30));

        dayFormat = new SimpleDateFormat("EEEE");
        dayLabel = new JLabel();
        dayLabel.setFont(new Font("Ink Free", Font.PLAIN, 30));

        dateFormat = new SimpleDateFormat("MMM d, ''yy");
        dateLabel = new JLabel();
        dateLabel.setFont(new Font("Monospaced", Font.PLAIN, 30));

        add(timeLabel);
        add(dayLabel);
        add(dateLabel);

        pack();
        setVisible(true);

        startClock();
    }
    private void startClock(){
        new Thread(()->{
            while(true){
                time = timeFormat.format(Calendar.getInstance().getTime());
                timeLabel.setText(time);

                day = dayFormat.format(Calendar.getInstance().getTime());
                dayLabel.setText(day);

                date = dateFormat.format(Calendar.getInstance().getTime());
                dateLabel.setText(date);
                try{
                    Thread.sleep(1000);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
//Thread used for two reasons ->
//1. Responsiveness and Smooth UI Updates and 2. Infinite Loop for Continuous Time Updates