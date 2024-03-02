package org.nlt.views;

import java.io.File;
import java.sql.Connection;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;
import org.hibernate.Query;
import org.nlt.model.Cities;
import org.nlt.model.Persons;
import org.nlt.model.States;
import static org.nlt.views.PInterface.stateMap;

public class PersonFrame extends javax.swing.JFrame implements PInterface
{
//       private boolean cityComboFlag;
     private boolean stateComboFlag;
     private Persons person; 

     public PersonFrame() 
     {
        initComponents();
        setStateComboBox();
        setCityComboBox();
        setTableData();
     } 
     
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        nameTextfield = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        ageTextfield = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        phoneTextfield = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        stateComboBox = new javax.swing.JComboBox<>();
        stateNewButton = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        cityComboBox = new javax.swing.JComboBox<>();
        newCityButton = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        submitButton = new javax.swing.JButton();
        updateButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        resetButton = new javax.swing.JButton();
        reporAlltButton = new javax.swing.JButton();
        reportParticularButton = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        personTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new java.awt.GridLayout(2, 0, 0, 10));

        jPanel2.setLayout(new java.awt.GridLayout(6, 2, 10, 10));

        jLabel1.setText("ENTER NAME");
        jPanel2.add(jLabel1);
        jPanel2.add(nameTextfield);

        jLabel2.setText("ENTER AGE");
        jPanel2.add(jLabel2);

        ageTextfield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ageTextfieldActionPerformed(evt);
            }
        });
        jPanel2.add(ageTextfield);

        jLabel3.setText("ENTER PHONE");
        jPanel2.add(jLabel3);
        jPanel2.add(phoneTextfield);

        jLabel4.setText("SELECT STATE");
        jPanel2.add(jLabel4);

        jPanel6.setLayout(new java.awt.BorderLayout(5, 0));

        stateComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stateComboBoxActionPerformed(evt);
            }
        });
        jPanel6.add(stateComboBox, java.awt.BorderLayout.CENTER);

        stateNewButton.setText("NEW");
        stateNewButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stateNewButtonActionPerformed(evt);
            }
        });
        jPanel6.add(stateNewButton, java.awt.BorderLayout.LINE_END);

        jPanel2.add(jPanel6);

        jLabel5.setText("SELECT CITY");
        jPanel2.add(jLabel5);

        jPanel7.setLayout(new java.awt.BorderLayout(5, 0));

        cityComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cityComboBoxActionPerformed(evt);
            }
        });
        jPanel7.add(cityComboBox, java.awt.BorderLayout.CENTER);

        newCityButton.setText("NEW");
        newCityButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newCityButtonActionPerformed(evt);
            }
        });
        jPanel7.add(newCityButton, java.awt.BorderLayout.LINE_END);

        jPanel2.add(jPanel7);

        jPanel4.setLayout(new java.awt.GridLayout(1, 3, 10, 0));

        submitButton.setText("SUBMIT");
        submitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitButtonActionPerformed(evt);
            }
        });
        jPanel4.add(submitButton);

        updateButton.setText("UPDATE");
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });
        jPanel4.add(updateButton);

        deleteButton.setText("DELETE");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });
        jPanel4.add(deleteButton);

        jPanel2.add(jPanel4);

        jPanel5.setLayout(new java.awt.GridLayout(1, 3, 10, 0));

        resetButton.setText("RESET");
        resetButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetButtonActionPerformed(evt);
            }
        });
        jPanel5.add(resetButton);

        reporAlltButton.setText("REPORT");
        reporAlltButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reporAlltButtonActionPerformed(evt);
            }
        });
        jPanel5.add(reporAlltButton);

        reportParticularButton.setText("REPORT PARTICULAR");
        reportParticularButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reportParticularButtonActionPerformed(evt);
            }
        });
        jPanel5.add(reportParticularButton);

        jPanel2.add(jPanel5);

        jPanel1.add(jPanel2);

        jPanel3.setLayout(new java.awt.GridLayout(1, 1));

        personTable.setModel(new javax.swing.table.DefaultTableModel(
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
        personTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                personTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(personTable);

        jPanel3.add(jScrollPane1);

        jPanel1.add(jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 441, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void resetButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetButtonActionPerformed
      resetData();
    }//GEN-LAST:event_resetButtonActionPerformed

    private void stateComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stateComboBoxActionPerformed
        try 
        {
            if (stateComboFlag==true)
            {
                cityComboBox.removeAllItems();
                String stateName=stateComboBox.getSelectedItem().toString();
                if (!stateName.equals("SELECT"))
                {
   States state= stateMap.values().stream().filter(P->P.getName().equals(stateName)).findAny().orElse(null);
                   if (state!=null)
                    {
  List<Cities> cityList= cityMap.values().stream().filter(P->P.getState() == state).collect(Collectors.toList());
                        cityComboBox.addItem("SELECT");
                         
                        for (Cities city : cityList)
                        {
                            cityComboBox.addItem(city.getName());
                        }
                    }
                }
            } 
        }
        catch (Exception e) 
        {
             JOptionPane.showMessageDialog(this, e, "Error Message", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_stateComboBoxActionPerformed

    private void stateNewButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stateNewButtonActionPerformed
        stateFrame.setVisible(true);
        stateFrame.setTableData();
    }//GEN-LAST:event_stateNewButtonActionPerformed

    private void newCityButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newCityButtonActionPerformed
        cityFrame.setVisible(true);
        cityFrame.setStateComboBox();
        cityFrame.setTableData();
    }//GEN-LAST:event_newCityButtonActionPerformed

    private void cityComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cityComboBoxActionPerformed
             
    }//GEN-LAST:event_cityComboBoxActionPerformed

    private void personTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_personTableMouseClicked
        try 
        { 
            
            int pid=Integer.parseInt( personTable.getValueAt(personTable.getSelectedRow(), 0).toString());
            person=personMap.get(pid);
            nameTextfield.setText(personTable.getValueAt(personTable.getSelectedRow(), 1).toString());
            ageTextfield.setText(personTable.getValueAt(personTable.getSelectedRow(), 2).toString());
            phoneTextfield.setText(personTable.getValueAt(personTable.getSelectedRow(),3).toString());
            stateComboBox.setSelectedItem(person.getCity().getState().getName());
            cityComboBox.setSelectedItem(person.getCity().getName());
            
        }
        catch (Exception e) 
        {
            JOptionPane.showMessageDialog(this, e, "PersonFrame", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_personTableMouseClicked

    private void ageTextfieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ageTextfieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ageTextfieldActionPerformed

    private void submitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitButtonActionPerformed
        try 
        {
            String name = nameTextfield.getText().toUpperCase();
            String age = ageTextfield.getText();
            String phone = phoneTextfield.getText();
            String cityName = cityComboBox.getSelectedItem().toString();
            
            if (name.isEmpty() || age.isEmpty() || phone.isEmpty() || cityName.equals("SELECT")) 
            {
                JOptionPane.showMessageDialog(this, "Invalid Entry", "PersonFrame", JOptionPane.ERROR_MESSAGE);
            } 
            else 
            {
                Persons person = new Persons();
                person.setAge(Integer.parseInt(age));
                person.setCity(cityMap.values().stream().filter(P -> P.getName().equals(cityName)).findAny().orElse(null));
                person.setCreated(new Date());
                person.setModified(new Date());
                person.setName(name);
                person.setPhone(Long.parseLong(phone));
                person.setStatus(1);
                ses.save(person);
                JOptionPane.showMessageDialog(this, "Record Submitted", "PersonFrame", JOptionPane.INFORMATION_MESSAGE);
                resetData();
                PInterface.setPersonMap();
                personFrame.setTableData();
            }
        } 
        catch (Exception ex)
        {
            JOptionPane.showMessageDialog(this, ex, "Error Message", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_submitButtonActionPerformed

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
       try 
        {
            if (person==null)
            {
                JOptionPane.showMessageDialog(this,"Invalid Entry","PersonFrame", JOptionPane.ERROR_MESSAGE);
            }
            else
            {
                String name = nameTextfield.getText().toUpperCase();
                String age = ageTextfield.getText();
                String phone = phoneTextfield.getText();
                String cityName = cityComboBox.getSelectedItem().toString();

                if (name.isEmpty() || age.isEmpty() || phone.isEmpty() || cityName.equals("SELECT")) 
                {
                    JOptionPane.showMessageDialog(this, "Invalid Entry", "PersonFrame", JOptionPane.ERROR_MESSAGE);
                } 
                else 
                {
                    person.setAge(Integer.parseInt(age));
                    person.setCity(cityMap.values().stream().filter(P -> P.getName().equals(cityName)).findAny().orElse(null));
                    person.setModified(new Date());
                    person.setName(name);
                    person.setPhone(Long.parseLong(phone));
                    
                    ses.beginTransaction();
                    ses.update(person);
                    ses.getTransaction().commit();
                    
                    JOptionPane.showMessageDialog(this, "Record Updated", "PersonFrame", JOptionPane.INFORMATION_MESSAGE);
                    setTableData();
                    PInterface.setPersonMap();
                    resetData();
                }
            }
        }
        catch (Exception e) 
        {
           JOptionPane.showMessageDialog(this, e, "Error Message", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_updateButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        try 
        {
            if (person==null)
            {
                JOptionPane.showMessageDialog(this, "Invalid Entry", "PersonFrame", JOptionPane.ERROR_MESSAGE);
            }
            else
            {
                String name = nameTextfield.getText().toUpperCase();
                String age = ageTextfield.getText();
                String phone = phoneTextfield.getText();
                String cityName = cityComboBox.getSelectedItem().toString();


                if (name.isEmpty() || age.isEmpty() || phone.isEmpty() || cityName.equals("SELECT")) 
                {
                    JOptionPane.showMessageDialog(this, "Invalid Entry", "PersonFrame", JOptionPane.ERROR_MESSAGE);
                } 
                else 
                {
                    person.setStatus(0);
                    
                    ses.beginTransaction();
                    ses.save(person);
                    ses.getTransaction().commit();
                    
                    JOptionPane.showMessageDialog(this, "Record Updated", "PersonFrame", JOptionPane.INFORMATION_MESSAGE);
                    setTableData();
                    PInterface.setPersonMap();
                    resetData();
                }
            }
        }
        catch (Exception e) 
        {
           JOptionPane.showMessageDialog(this, e, "Error Message", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void reporAlltButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reporAlltButtonActionPerformed
         try
        {
          File f=new File(".");
          String reportPath=f.getCanonicalPath()+File.separator+"build"+File.separator+"classes"+File.separator+"org"+File.separator+"nlt"+File.separator+"reports"+File.separator+"personreport1.jrxml";
            Connection con=ses.connection();
            
            JasperDesign jd=JRXmlLoader.load(reportPath);
            String sql="SELECT\n" +
            "     persons.`id` AS persons_id,\n" +
            "     persons.`age` AS persons_age,\n" +
            "     persons.`created` AS persons_created,\n" +
            "     persons.`modified` AS persons_modified,\n" +
            "     persons.`name` AS persons_name,\n" +
            "     persons.`phone` AS persons_phone,\n" +
            "     persons.`status` AS persons_status,\n" +
            "     persons.`city_id` AS persons_city_id,\n" +
            "     states.`name` AS states_name,\n" +
            "     cities.`name` AS cities_name\n" +
            "FROM\n" +
            "     `states` states INNER JOIN `cities` cities ON states.`id` = cities.`state_id`\n" +
            "     INNER JOIN `persons` persons ON cities.`id` = persons.`city_id` where  persons.`status`=1" ;
            //System.out.println(sql);
            
            JRDesignQuery query=new JRDesignQuery();
            query.setText(sql);
            jd.setQuery(query);
            
            JasperReport jr=JasperCompileManager.compileReport(jd);
            JasperPrint jp=JasperFillManager.fillReport(jr, null,con);
            
           //current path+username.pdf
//            String pdfFileName = f.getCanonicalPath()+File.separator + "reportsAll.pdf";
//             JasperExportManager.exportReportToPdfFile(jp,pdfFileName);
             JasperViewer.viewReport(jp,false);
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(this, ex,"Project2",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_reporAlltButtonActionPerformed

    private void reportParticularButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reportParticularButtonActionPerformed
        try
        {
            if (person==null)
            {
                JOptionPane.showMessageDialog(this, "Please Select Record", "PersonFrame", JOptionPane.ERROR_MESSAGE);
            }
            else 
            {
              File f=new File(".");
          String reportPath=f.getCanonicalPath()+File.separator+"build"+File.separator+"classes"+File.separator+"org"+File.separator+"nlt"+File.separator+"reports"+File.separator+"personreport1.jrxml";
            Connection con=ses.connection();
            
            JasperDesign jd=JRXmlLoader.load(reportPath);
            String sql="SELECT\n" +
            "     persons.`id` AS persons_id,\n" +
            "     persons.`age` AS persons_age,\n" +
            "     persons.`created` AS persons_created,\n" +
            "     persons.`modified` AS persons_modified,\n" +
            "     persons.`name` AS persons_name,\n" +
            "     persons.`phone` AS persons_phone,\n" +
            "     persons.`status` AS persons_status,\n" +
            "     persons.`city_id` AS persons_city_id,\n" +
            "     states.`name` AS states_name,\n" +
            "     cities.`name` AS cities_name\n" +
            "FROM\n" +
            "     `states` states INNER JOIN `cities` cities ON states.`id` = cities.`state_id`\n" +
            "     INNER JOIN `persons` persons ON cities.`id` = persons.`city_id` where  persons.`status`=1 and  persons.`id`="+person.getId() ;
            //System.out.println(sql);
            
            JRDesignQuery query=new JRDesignQuery();
            query.setText(sql);
            jd.setQuery(query);
            
            JasperReport jr=JasperCompileManager.compileReport(jd);
            JasperPrint jp=JasperFillManager.fillReport(jr, null,con);
            
           //current path+username.pdf
//            String pdfFileName = f.getCanonicalPath()+File.separator + "reportsAll.pdf";
//             JasperExportManager.exportReportToPdfFile(jp,pdfFileName);
             JasperViewer.viewReport(jp,false);  
            }
        }
         catch(Exception ex)
        {
            JOptionPane.showMessageDialog(this, ex,"Project2",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_reportParticularButtonActionPerformed

    public void setStateComboBox()
   {
       try 
       {
           stateComboFlag = false;
           Collection<States> stateValues=stateMap.values();
           stateComboBox.removeAllItems();
           stateComboBox.addItem("SELECT");
           for (States state : stateValues) 
           {
               stateComboBox.addItem(state.getName());
           }
           stateComboFlag = true;
       } 
       catch (Exception e) 
       {
           JOptionPane.showMessageDialog(this, e, "PersonFrame", JOptionPane.ERROR_MESSAGE);
       }
   }
   
   public void setCityComboBox()
   {
       try 
       {
//           cityComboFlag=false;
           Collection<Cities> cityValues=cityMap.values();
           cityComboBox.removeAllItems();
           cityComboBox.addItem("SELECT");
           for (Cities city : cityValues) 
           {
               cityComboBox.addItem(city.getName());
           }
//           cityComboFlag=true;
       } 
       catch (Exception e) 
       {
           JOptionPane.showMessageDialog(this, e, "PersonFrame", JOptionPane.ERROR_MESSAGE);
       }
   }

    private void setTableData() 
    {
        String[] cols={"ID","NAME","AGE","PHONE","CITY","STATE"};
        ses.beginTransaction();
        
        Query query = ses.createQuery("from Persons where status=1");
        List<Persons> personList=query.list();
        
        String [][] data=new String[personList.size()][cols.length];
       
        int i=0;
        for (Persons person: personList)
        {
            data[i][0]= person.getId()+"";
            data[i][1]= person.getName();
            data[i][2]= person.getAge()+"";
            data[i][3]= person.getPhone()+"";
            data[i][4] = person.getCity().getName();
            data[i][5] = person.getCity().getState().getName();
            i++;
        }
        
        ses.getTransaction().commit();
        DefaultTableModel model=new DefaultTableModel(data, cols);
        personTable.setModel(model);
    }

    private void resetData()
    {
        nameTextfield.setText("");
        ageTextfield.setText("");
        phoneTextfield.setText("");
        person=null;
        cityComboBox.removeAllItems();
        cityComboBox.addItem("SELECT");
        stateComboFlag=false;
        stateComboBox.setSelectedItem("SELECT");
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField ageTextfield;
    private javax.swing.JComboBox<String> cityComboBox;
    private javax.swing.JButton deleteButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nameTextfield;
    private javax.swing.JButton newCityButton;
    private javax.swing.JTable personTable;
    private javax.swing.JTextField phoneTextfield;
    private javax.swing.JButton reporAlltButton;
    private javax.swing.JButton reportParticularButton;
    private javax.swing.JButton resetButton;
    private javax.swing.JComboBox<String> stateComboBox;
    private javax.swing.JButton stateNewButton;
    private javax.swing.JButton submitButton;
    private javax.swing.JButton updateButton;
    // End of variables declaration//GEN-END:variables
}