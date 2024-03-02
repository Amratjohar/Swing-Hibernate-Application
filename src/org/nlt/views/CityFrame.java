package org.nlt.views;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.hibernate.Query;
import org.nlt.model.Cities;
import org.nlt.model.States;
import static org.nlt.views.PInterface.ses;

public class CityFrame extends javax.swing.JFrame implements PInterface
{
    private Cities city;
    private int cid;
    
    public CityFrame()
    {
        initComponents();
        setTableData();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        nameTextfield = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        StateComboBox = new javax.swing.JComboBox<>();
        jPanel5 = new javax.swing.JPanel();
        submitButton = new javax.swing.JButton();
        updateButton = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        deleteButton = new javax.swing.JButton();
        resetButton = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        cityTable = new javax.swing.JTable();

        jButton2.setText("UPDATE");

        jButton3.setText("jButton3");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setLayout(new java.awt.GridLayout(2, 0, 0, 10));

        jPanel2.setLayout(new java.awt.GridLayout(3, 2, 10, 10));

        jLabel1.setText("ENTER CITY");
        jPanel2.add(jLabel1);

        nameTextfield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameTextfieldActionPerformed(evt);
            }
        });
        jPanel2.add(nameTextfield);

        jLabel2.setText("SELECT STATE");
        jPanel2.add(jLabel2);

        StateComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StateComboBoxActionPerformed(evt);
            }
        });
        jPanel2.add(StateComboBox);

        jPanel5.setLayout(new java.awt.GridLayout(1, 2, 10, 0));

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

        jPanel2.add(jPanel5);

        jPanel4.setLayout(new java.awt.GridLayout(1, 2, 10, 0));

        deleteButton.setText("DELETE");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });
        jPanel4.add(deleteButton);

        resetButton.setText("RESET");
        resetButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetButtonActionPerformed(evt);
            }
        });
        jPanel4.add(resetButton);

        jPanel2.add(jPanel4);

        jPanel1.add(jPanel2);

        jPanel3.setLayout(new java.awt.GridLayout(1, 1));

        cityTable.setModel(new javax.swing.table.DefaultTableModel(
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
        cityTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cityTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(cityTable);

        jPanel3.add(jScrollPane1);

        jPanel1.add(jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 549, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 307, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void submitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitButtonActionPerformed
        try 
        {
            String name=nameTextfield.getText().toUpperCase();
            String stateName=StateComboBox.getSelectedItem().toString();
            
            if (name.isEmpty() || stateName.equalsIgnoreCase("SELECT")) 
            {
               JOptionPane.showMessageDialog(this, "Invalid Entry", "CityFrame", JOptionPane.ERROR_MESSAGE);
            } 
            else 
            {
            ses.beginTransaction();
            
            Cities city=new Cities();
            city.setName(name);
            city.setCreated(new Date());
            city.setModified(new Date());
            city.setStatus(1);
            States state=stateMap.values().stream().filter(P->P.getName().equals(stateName)).findAny().orElse(null);
            city.setState(state);
            
            ses.save(city);
            ses.getTransaction().commit();
            setTableData();
            PInterface.setCityMap();
            personFrame.setCityComboBox();
  JOptionPane.showMessageDialog(this, "Record Submitted Successfully", "CityFrame", JOptionPane.INFORMATION_MESSAGE);
            resetData();
        }
        }
        catch (Exception e) 
        {
          JOptionPane.showMessageDialog(this, e, "CityFrame", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_submitButtonActionPerformed

    private void StateComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StateComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_StateComboBoxActionPerformed

    private void cityTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cityTableMouseClicked
        try 
        {
          cid=Integer.parseInt(cityTable.getValueAt(cityTable.getSelectedRow(),0).toString());
          city=cityMap.get(cid);
          nameTextfield.setText(city.getName());
        }
        catch (Exception ex) 
        {
            System.out.println(ex);
        }
    }//GEN-LAST:event_cityTableMouseClicked

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
      try 
        {
            if (city==null) //it means we did not select record for update
            {
                JOptionPane.showMessageDialog(this, "Please select record to update", "Error Message", JOptionPane.INFORMATION_MESSAGE);
            } 
            else 
            {
                String name=nameTextfield.getText();
                if (name.isEmpty())
                {
                 JOptionPane.showMessageDialog(this, "Please select State name to update", "Update Message", JOptionPane.INFORMATION_MESSAGE);
                } 
                else 
                {
                 city.setStatus(0);
                 
                 ses.beginTransaction();
                 ses.save(city);
                 ses.getTransaction().commit();
                 
                 setTableData();
                 PInterface.setCityMap();
                 personFrame.setCityComboBox();
         JOptionPane.showMessageDialog(this, "Record Deleted Successfully", "CityFrame", JOptionPane.INFORMATION_MESSAGE);
                 resetData();
                }
            }
        } 
        catch (Exception ex)
        {
            JOptionPane.showMessageDialog(this, ex, "StateFrame", JOptionPane.ERROR_MESSAGE);
        }    }//GEN-LAST:event_deleteButtonActionPerformed
 
    private void resetButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetButtonActionPerformed
        resetData();
    }//GEN-LAST:event_resetButtonActionPerformed

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
        //stateMap.values().stream().forEach(P->System.out.println(P.getName()));
        try 
        {
            if(city==null) //it means we did not select record for update
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
                 city.setName(name);
                 
                 ses.beginTransaction();
                 ses.update(city);
                 ses.getTransaction().commit();
                 
                   setTableData();
                   PInterface.setCityMap();
                   personFrame.setCityComboBox();
         JOptionPane.showMessageDialog(this, "Record Updated Successfully", "CityFrame", JOptionPane.INFORMATION_MESSAGE);
                 resetData();
                }
            }
        } 
        catch (Exception ex)
        {
            JOptionPane.showMessageDialog(this, ex, "StateFrame", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_updateButtonActionPerformed

    private void nameTextfieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameTextfieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameTextfieldActionPerformed
    
    public void setStateCombo()
    {
        Collection<States> stateValues=stateMap.values();
        StateComboBox.removeAllItems();
        StateComboBox.addItem("SELECT");
        for(States state:stateValues)
        {
            StateComboBox.addItem(state.getName());
        }
    }
    
    public void setTableData()
    {
        String [] cols={"ID","NAME","STATE"};
        
        ses.beginTransaction();
        
        Query query = ses.createQuery("from Cities where status=1");
        List<Cities> cityList=query.list();
        
        String [][] data=new String[cityList.size()][cols.length];
        
        int i=0;
        for (Cities city: cityList)
        {
            data[i][0]=city.getId()+"";
            data[i][1]=city.getName();
            data[i][2]=city.getState().getName();
            i++;
        }
        ses.getTransaction().commit();
        
        DefaultTableModel model=new DefaultTableModel(data, cols);
        cityTable.setModel(model);
    }
    
   public void setStateComboBox()
   {
       try 
       {
           Collection<States> stateValues=stateMap.values();
           StateComboBox.removeAllItems();
           StateComboBox.addItem("SELECT");
           for (States state : stateValues) 
           {
               StateComboBox.addItem(state.getName());
           }
       } 
       catch (Exception e) 
       {
           JOptionPane.showMessageDialog(this, e, "PersonFrame", JOptionPane.ERROR_MESSAGE);
       }
   }
       
       private void resetData()
       {
           nameTextfield.setText("");
           StateComboBox.setSelectedItem("SELECT");
       }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> StateComboBox;
    private javax.swing.JTable cityTable;
    private javax.swing.JButton deleteButton;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nameTextfield;
    private javax.swing.JButton resetButton;
    private javax.swing.JButton submitButton;
    private javax.swing.JButton updateButton;
    // End of variables declaration//GEN-END:variables
}