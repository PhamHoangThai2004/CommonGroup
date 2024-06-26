/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view;

import net.miginfocom.swing.MigLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.ImageIcon;
import javamodel.ModelMenu;
import view.swing.MenuItem;

public class MenuAdmin extends javax.swing.JPanel {

    public void addEvent(EventMenuSelected event) {
        this.event = event;
        // Phần controller 
    }

    public void setEnableMenu(boolean enableMenu) {
        this.enableMenu = enableMenu;
    }

    private final MigLayout layout = null;
    private EventMenuSelected event; // Phần controller
    private boolean enableMenu = true;
    
    public MenuAdmin() {
        initComponents();
    }
    
    // Khởi tạo data cho menu
    public void initMenuItem() {
        addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/Icons/MenuBar/menu.png")), "Quản lý sản phẩm"));
        addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/Icons/MenuBar/staff.png")), "Quản lý nhân sự"));
        addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/Icons/MenuBar/analytics.png")), "Báo cáo doanh thu"));
        addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/Icons/MenuBar/bill.png")), "Thống kê hóa đơn"));
        addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/Icons/MenuBar/inventory.png")), "Thống kê nhập kho"));
        addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/Icons/MenuBar/customer.png")), "Thông tin khách hàng"));
        addMenu(new ModelMenu(null, ""));
        addMenu(new ModelMenu(null, "Thông tin cá nhân"));
        addMenu(new ModelMenu(null, ""));
        addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/Icons/MenuBar/user.png")), "Tài Khoản"));
        addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/Icons/MenuBar/logout.png")), "Đăng Xuất"));
    }
    
    //Add Panel MenuIteam vào Panel Menu
    private void addMenu(ModelMenu menu) {
        panel.add(new MenuItem(menu, getEventMenu(), event, panel.getComponentCount()), "h 40!");
    }
    
    // Phần controller 
    private EventMenu getEventMenu() {
        return new EventMenu() {
            @Override
            public boolean menuPress(Component com, boolean open) {
                if (enableMenu) {
                    if (open) {
                        new MenuAnimation(layout, com).openMenu();
                    } else {
                        new MenuAnimation(layout, com).closeMenu();
                    }
                    return true;
                }
                return false;
            }
        };
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        logo = new javax.swing.JLabel();
        panel = new javax.swing.JPanel();

        logo.setBackground(new java.awt.Color(204, 204, 204));
        logo.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        logo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/businessman.png"))); // NOI18N
        logo.setText("<html>Royal Administrator<br> Restaurant ★★★★★</html>");

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 454, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(logo, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
            .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        GradientPaint gp= new GradientPaint(0, 0, Color.decode("#928199"), 0, getHeight(), Color.decode("#847589"));
        g2.setPaint(gp);
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 15, 15);
        g2.fillRect(0, 0, getWidth(), getHeight());
        super.paintComponent(g);
    }
    
    public static void main(String[] args) {
        new MenuAdmin().setVisible(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel logo;
    private javax.swing.JPanel panel;
    // End of variables declaration//GEN-END:variables
}
