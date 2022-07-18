package crawler;

import javax.swing.JOptionPane;


import javax.swing.table.DefaultTableModel;

public class JTable extends javax.swing.JFrame {

    /**
     * Creates new form table
     */
    public JTable() {
        initComponents();
    }
    private void retrieve()
    {
        DefaultTableModel dm = new DBUpdater().getData();

        jTable1.setModel(dm);
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        retrieveBtn = new javax.swing.JButton();
        Delete = new javax.swing.JButton();
        clearBtn = new javax.swing.JButton();
   

       

        jLabel1.setText("INDEXED WEB PAGES");


        jTable1.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {

                },
                new String [] {

                }
        ));

        jScrollPane1.setViewportView(jTable1);

        retrieveBtn.setText("Retrieve");
        retrieveBtn.addActionListener(evt -> retrieveBtnActionPerformed(evt));


        Delete.setText("Delete");
        Delete.addActionListener(evt -> DeleteActionPerformed(evt));

        clearBtn.setText("Clear");
        clearBtn.addActionListener(evt -> clearBtnActionPerformed());


        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addComponent(retrieveBtn))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(338, 338, 338)
                                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(Delete))
                                        .addGroup(layout.createSequentialGroup()
                                                .addContainerGap(27, Short.MAX_VALUE)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(clearBtn)
                                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 741, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addContainerGap(32, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(retrieveBtn)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Delete))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(clearBtn)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 454, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>
   // RETRIEVE BUTTON CLICKED
    private void retrieveBtnActionPerformed(java.awt.event.ActionEvent evt) {
        retrieve();

    }
    //DELETE
    private void DeleteActionPerformed(java.awt.event.ActionEvent evt) {
        String[] options = {"Yes", "No"};
        int answ = JOptionPane.showOptionDialog(null, "Sure To Delete??", "Delete Confirm", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1]);

        if (answ == 0) {
            int index = jTable1.getSelectedRow();
            String id = jTable1.getValueAt(index, 0).toString();

            if (new DBUpdater().delete(id)) {
                JOptionPane.showMessageDialog(null, "Deleted Updated");

                retrieve();
            } else
            {
                JOptionPane.showMessageDialog(null, "Not Deleted");
            }

        }
    }
    //CLEAR BUTTON CLICKED
    private void clearBtnActionPerformed() {
        jTable1.setModel(new DefaultTableModel());
    }

    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify
    private javax.swing.JButton retrieveBtn;
    private javax.swing.JButton Delete;
    private javax.swing.JButton clearBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration
}

