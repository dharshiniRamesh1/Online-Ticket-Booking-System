import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TicketBookingApp {
    private JTextField nameField;
    private JTextField seatField;
    private JTextField dateField;
    private JTextField fromField;
    private JTextField toField;
    private JTextArea historyTextArea;

    public TicketBookingApp() {
        // Initialize Swing components
        JFrame frame = new JFrame("Ticket Booking App");
        JPanel panel = new JPanel();
        nameField = new JTextField(10);
        seatField = new JTextField(10);
        dateField = new JTextField(10);
        fromField = new JTextField(10);
        toField = new JTextField(10);
        JButton bookButton = new JButton("Book Ticket");
        JButton historyButton = new JButton("View History");
        historyTextArea = new JTextArea(10, 30);

        // Add components to the panel
        panel.add(new JLabel("Name:"));
        panel.add(nameField);
        panel.add(new JLabel("Seat:"));
        panel.add(seatField);
        panel.add(new JLabel("Date:"));
        panel.add(dateField);
        panel.add(new JLabel("From:"));
        panel.add(fromField);
        panel.add(new JLabel("To:"));
        panel.add(toField);
        panel.add(bookButton);
        panel.add(historyButton);

        // Add panel to frame
        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        // Event listeners
        bookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Gather user input
                String name = nameField.getText();
                String seat = seatField.getText();
                String date = dateField.getText();
                String from = fromField.getText();
                String to = toField.getText();

                // Generate ticket ID
                String ticketId = "T" + (int)(Math.random() * 10000);

                // Add ticket details to history
                String ticketDetails = String.format("%s %s %s %s %s %s %s%n",
                        ticketId, name, seat, date, from, to, "Booked");
                historyTextArea.append(ticketDetails);

                // Display alert
                JOptionPane.showMessageDialog(frame, "Ticket with ID " + ticketId + " has been booked successfully.");
            }
        });

        historyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Display ticket history
                JOptionPane.showMessageDialog(frame, new JScrollPane(historyTextArea), "Ticket History", JOptionPane.INFORMATION_MESSAGE);
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TicketBookingApp();
            }
        });
    }
}
