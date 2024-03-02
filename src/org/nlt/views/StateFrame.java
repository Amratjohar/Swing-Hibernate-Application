package org.nlt.views;

import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.hibernate.Query;
import org.nlt.model.States;

public class StateFrame extends javax.swing.JFrame implements PInterface
{
    public States states;
       

    public StateFrame() {
        initComponents();
        setTableData();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton3 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        nameTextfield = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        submitButton = new javax.swing.JButton();
        updateButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        resetButton = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        stateTable = new javax.swing.JTable();

        jButton3.setText("jButton3");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setLayout(new java.awt.GridLayout(2, 0, 0, 10));

        jPanel2.setLayout(new java.awt.GridLayout(2, 0, 0, 10));

        jPanel4.setLayout(new java.awt.GridLayout(1, 1));
        jPanel4.add(nameTextfield);

        jPanel2.add(jPanel4);

        jPanel5.setLayout(new java.awt.GridLayout(1, 4, 5, 0));

        submitButton.setText("SUBMIT");
        submitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitButtonActionPerformed(evt);
            }
        });
        jPanel5.add(submitButton);

        updateButton.setText("UPDATE");
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });
        jPanel5.add(updateButton);

        deleteButton.setText("DELETE");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });
        jPanel5.add(deleteButton);

        resetButton.setText("RESET");
        resetButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetButtonActionPerformed(evt);
            }
        });
        jPanel5.add(resetButton);

        jPanel2.add(jPanel5);

        jPanel1.add(jPanel2);

        jPanel3.setLayout(new java.awt.GridLayout(1, 1));

        stateTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        stateTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                stateTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(stateTable);

        jPanel3.add(jScrollPane1);

        jPanel1.add(jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 376, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 274, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void submitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitButtonActionPerformed
        ses.beginTransaction();
         
        states.setCreated(new Date());
        states.setModified(new Date());
        states.setName(nameTextfield.getText().toUpperCase());
        states.setStatus(1);
        
        ses.save(states);
       
        ses.getTransaction().commit();
        setTableData();
        JOptionPane.showMessageDialog(this, "Record Submitted", "StateFrame", JOptionPane.INFORMATION_MESSAGE);
        resetData();
        PInterface.setStatesMap();
        personFrame.setStateComboBox();
    }//GEN-LAST:event_submitButtonActionPerformed
      
    private void stateTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stateTableMouseClicked
        try 
        {
           int sid=Integer.parseInt( stateTable.getValueAt(stateTable.getSelectedRow(), 0).toString());
            states=stateMap.get(sid);
            nameTextfield.setText(states.getName());
        }
        catch (Exception ex) 
        {
         JOptionPane.showMessageDialog(this, ex, "StateFrame", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_stateTableMouseClicked

    private void resetButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetButtonActionPerformed
        resetData();
    }//GEN-LAST:event_resetButtonActionPerformed

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
        try 
        {
            if (states==null) //it means we did not select record for update
            {
                JOptionPane.showMessageDialog(this, "Please select record to update", "Error Message", JOptionPane.INFORMATION_MESSAGE);
            } 
            else 
            {
                String name=nameTextfield.getText().toUpperCase();
                if (name.isEmpty())
                {
                 JOptionPane.showMessageDialog(this, "Please select State name to update", "Update Message", JOptionPane.INFORMATION_MESSAGE);
                } 
                else 
                {
                 states.setName(name);
                 ses.beginTransaction();
                 ses.save(states);
                 ses.getTransaction().commit();
                 setTableData();
                 resetData();
                }
            }
        } 
        catch (Exception ex)
        {
            JOptionPane.showMessageDialog(this, ex, "StateFrame", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_updateButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
         try 
        {
            if (states==null) //it means we did not select record for update
            {
                JOptionPane.showMessageDialog(this, "Please select record to update", "Error Message", JOptionPane.INFORMATION_MESSAGE);
            } 
            else 
            {
                 states.setStatus(0);
                 ses.beginTransaction();
                 ses.save(states);
                 ses.getTransaction().commit();
                PInterface.setStatesMap();//refresh map
                setTableData();
                resetData();
                JOptionPane.showMessageDialog(this, "Record Deleted Successfully", "PersonFrame", JOptionPane.INFORMATION_MESSAGE);
                personFrame.setStateComboBox();
            }
        } 
        catch (Exception ex)
        {
            JOptionPane.showMessageDialog(this, ex, "StateFrame", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_deleteButtonActionPerformed

    public void setTableData() 
    {
        String [] cols={"ID","NAME"};
        ses.beginTransaction();
        
       Query query = ses.createQuery("from States where status=1");
        List<States> stateList=query.list();
        
        String [][] data=new String[stateList.size()][cols.length];
        
        int i=0;
        for (States state: stateList)
        {
            data[i][0]=state.getId()+"";
            data[i][1]=state.getName();
            i++;
        }
        ses.getTransaction().commit();
        
        DefaultTableModel model=new DefaultTableModel(data, cols);
        stateTable.setModel(model);
    }

    private void resetData() 
    {
        nameTextfield.setText("");
        states=null;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton deleteButton;
    private javax.swing.JButton jButton3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nameTextfield;
    private javax.swing.JButton resetButton;
    private javax.swing.JTable stateTable;
    private javax.swing.JButton submitButton;
    private javax.swing.JButton updateButton;
    // End of variables declaration//GEN-END:variables
}