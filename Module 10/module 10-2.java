//colby king module 10 assignment//
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class FanApp {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Fan Info");
        frame.setSize(300, 250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        JLabel idLabel = new JLabel("ID:");
        idLabel.setBounds(20, 20, 80, 25);
        frame.add(idLabel);

        JTextField idField = new JTextField();
        idField.setBounds(100, 20, 150, 25);
        frame.add(idField);

        JLabel firstLabel = new JLabel("First Name:");
        firstLabel.setBounds(20, 50, 80, 25);
        frame.add(firstLabel);

        JTextField firstField = new JTextField();
        firstField.setBounds(100, 50, 150, 25);
        frame.add(firstField);

        JLabel lastLabel = new JLabel("Last Name:");
        lastLabel.setBounds(20, 80, 80, 25);
        frame.add(lastLabel);

        JTextField lastField = new JTextField();
        lastField.setBounds(100, 80, 150, 25);
        frame.add(lastField);

        JLabel teamLabel = new JLabel("Team:");
        teamLabel.setBounds(20, 110, 80, 25);
        frame.add(teamLabel);

        JTextField teamField = new JTextField();
        teamField.setBounds(100, 110, 150, 25);
        frame.add(teamField);

        JButton displayBtn = new JButton("Display");
        displayBtn.setBounds(30, 150, 100, 30);
        frame.add(displayBtn);

        JButton updateBtn = new JButton("Update");
        updateBtn.setBounds(150, 150, 100, 30);
        frame.add(updateBtn);

        displayBtn.addActionListener(e -> {
            try {
                Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/databasedb", "student1", "pass");
                String sql = "SELECT firstname, lastname, favoriteteam FROM fans WHERE ID = ?";
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setInt(1, Integer.parseInt(idField.getText()));
                ResultSet rs = stmt.executeQuery();
                if (rs.next()) {
                    firstField.setText(rs.getString("firstname"));
                    lastField.setText(rs.getString("lastname"));
                    teamField.setText(rs.getString("favoriteteam"));
                } else {
                    JOptionPane.showMessageDialog(frame, "Fan not found.");
                }
                conn.close();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(frame, "Error: " + ex.getMessage());
            }
        });

        updateBtn.addActionListener(e -> {
            try {
                Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/databasedb", "student1", "pass");
                String sql = "UPDATE fans SET firstname=?, lastname=?, favoriteteam=? WHERE ID=?";
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setString(1, firstField.getText());
                stmt.setString(2, lastField.getText());
                stmt.setString(3, teamField.getText());
                stmt.setInt(4, Integer.parseInt(idField.getText()));
                int rows = stmt.executeUpdate();
                if (rows > 0) {
                    JOptionPane.showMessageDialog(frame, "Fan updated!");
                } else {
                    JOptionPane.showMessageDialog(frame, "Update failed.");
                }
                conn.close();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(frame, "Error: " + ex.getMessage());
            }
        });

        frame.setVisible(true);
    }
}