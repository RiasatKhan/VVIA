/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package riasatbrowser;

import javax.swing.*;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
public class RiasatBrowser
{
    public static void main(String[] args)
    {
        BrowserFile browser = new BrowserFile();
        browser.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}




class BrowserFile extends JFrame
{
    private JTextField addressBar;
    private JEditorPane display;

    public BrowserFile()
    {
        super("Riasat Browser");

        addressBar = new JTextField("https://");
        addressBar.setCaretPosition(addressBar.getDocument().getLength());
        addressBar.addActionListener(
                new ActionListener()
                {
                    public void actionPerformed(ActionEvent event)
                    {
                        loadSite(event.getActionCommand());
                    }
                }
        );
        add(addressBar, BorderLayout.NORTH);
        display = new JEditorPane();
        display.setEditable(false);
        display.addHyperlinkListener(
                new HyperlinkListener()
                {
                    public void hyperlinkUpdate(HyperlinkEvent event)
                    {
                        if(event.getEventType()== HyperlinkEvent.EventType.ACTIVATED)
                        {
                            loadSite(event.getURL().toString());
                        }
                    }
                }
        );
        add(new JScrollPane(display), BorderLayout.CENTER);
        setSize(500,300);
        setVisible(true);
    }

    private void loadSite(String userText)
    {
        try
        {
            display.setPage(userText);
            addressBar.setText(userText);
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }

}
