package lab08.Ex3;
import javax.swing.*;



import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Sky extends JFrame {
    private List<StarFactory> stars = new ArrayList<>();

    public void placeStar(StarFactory star) {
        stars.add(star);
        
    }

    @Override
    public void paint(Graphics graphics) {
        for (StarFactory star : stars) {
            star.draw(graphics);
        }
    }
}