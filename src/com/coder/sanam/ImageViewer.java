package com.coder.sanam;

import java.awt.*;
import java.io.*;
import javax.swing.*;


public class ImageViewer {

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            var frame = new ImageViewerFrame();
            frame.setTitle("Image Viewer");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}

    class ImageViewerFrame extends JFrame {
    public ImageViewerFrame() {
        // Set frame properties
        setTitle("Image Viewer");
        setSize(300, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Add components
        var label = new JLabel();
        add(label);

        // Load an image
        var chooser = new JFileChooser();
        chooser.setCurrentDirectory(new File("."));

        // Show file chooser dialog
        var result = chooser.showOpenDialog(this);

        // If an image file is selected, display it
        if (result == JFileChooser.APPROVE_OPTION) {
            var name = chooser.getSelectedFile().getPath();
            label.setIcon(new ImageIcon(name));
        }
    }
}

