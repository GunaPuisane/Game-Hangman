
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Guna
 */
public class Karatavas extends javax.swing.JFrame {

    public String [] vardi = {"oboja", "desa", "aka", "indiānis", "saldējums",
    "kaktuss", "zaķis", "lācis", "robots","sikspārnis"};
    public int dzivibas = 5;
    public char minejums;
    public String vards;
    //definet kur saglabat izmantotos burtus
    String izmantotieBurti;
    String izmantotieBurtiNoformeti;
    
    String imageName = ""+dzivibas ;

    public Karatavas() {
        initComponents();
    uzsaktSpeli();
        jButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               minejums();
            }
        });
        
         jButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               speletVelreiz();
            }
        });
        
    }
    private void uzsaktSpeli(){
        this.dzivibas =5;
        izmantotieBurti="";
        
 
        this.jLabel6.setText("");
        this.jLabel5.setText("");
        this.jButton1.setVisible(true);
        //spēlēt vēlreiz poga ir neredzama
        this.jButton2.setVisible(false);
        //paziņojuma lauks neredzams
        this.jLabel3.setVisible(false);
        //Ierakstam, cik dzīvību
        this.jLabel4.setText("Dzīvības: " + dzivibas);
        //nezināmo vārdu iztīram
        this.jLabel2.setText("");
        
        //nejauši tiek izvēlēts vārds no saraksta
    int random = java.util.concurrent.ThreadLocalRandom.current().nextInt(0, vardi.length);
    this.vards = vardi[random];
    
    for (int i=0;i<this.vards.length();i++)
    {
        this.jLabel2.setText(this.jLabel2.getText()+ "*");
    }
    }
    private void speletVelreiz(){
       this.jLabel6.setIcon(null);
       uzsaktSpeli();
    }
    private void minejums(){
        //vai ievadītā varda garums ir lielāks par nulli
        if (this.jTextField1.getText().length() > 0)
        {
            //tekstu parveršam mazajos burtos
           String lo = this.jTextField1.getText().toLowerCase();

            //uztadam to kā minejumu un pārvēršam par char tipu
            this.minejums = lo.charAt(0);
            int atrasanasVieta = this.vards.indexOf(minejums);
           
            if(atrasanasVieta <0)
            {
               String burtiNoformeti ="";
                if(this.izmantotieBurti.indexOf(this.minejums)==-1){
                    this.izmantotieBurti = this.izmantotieBurti + this.minejums;
                   //attēlot komantu
                    for (int i=0; i<this.izmantotieBurti.length(); i++)
                    {
                        burtiNoformeti = burtiNoformeti + this.izmantotieBurti.charAt(i) + ", ";
                    }
                    burtiNoformeti = burtiNoformeti.substring(0, burtiNoformeti.length()-2);
                }
                this.jLabel3.setText("Burts " + this.minejums + " nav šajā vārdā!");
                this.jLabel3.setVisible(true);
                this.jLabel5.setText("Tavi izmantotie burti: " + burtiNoformeti );
                //smaazina dzīvibu skaitu
                this.dzivibas--;
                //attēlojam dzīvību tekstu
                this.jLabel4.setText("Dzīvības: " + this.dzivibas);
                //uztaisam bildi
                imageName = "image"+dzivibas;
          ImageIcon icon= new ImageIcon(getClass().getResource("Images/" + imageName + ".png"));
          this.jLabel6.setIcon(icon);
              
            
            }
            else 
            {
                while(atrasanasVieta >=0)
                {
                    String jaunsVards = this.jLabel2.getText();
                    //no sakuma lidz atrasanas vietai
                    jaunsVards = jaunsVards.substring(0, atrasanasVieta)
                            +this.minejums
                            +jaunsVards.substring(atrasanasVieta+1);
                    this.jLabel2.setText(jaunsVards);

                    //atjaunojam atrassanas vietu uz nakamo
                    atrasanasVieta = this.vards.indexOf(this.minejums, atrasanasVieta+1);
                }
              this.jLabel3.setText("");
              this.jLabel3.setVisible(false);
            }
            //notīram ievadlauku un minējumu
            this.jTextField1.setText("");
            this.minejums = '0';
            
            
            
            if (dzivibas == 0)
            {
                 this.jLabel3.setText("Dzīvības ir beigušās.  Pareizais vārds bija " + vards);
                 //paslējp pogu
                 this.jLabel3.setVisible(true);
                 this.jButton1.setVisible(false);
                   //spēlēt vēlreiz poga ir redzama
                this.jButton2.setVisible(true);
                
            }
            //ja vards atminets, tad paziņojums, textam izmantot equals. 
            if (this.jLabel2.getText().equals(this.vards))
            {
                this.jLabel3.setText("Apsveicam! Esi uzminējs vārdu "+ vards);
                this.jLabel3.setVisible(true);
                this.jButton1.setVisible(false);
                //spēlēt vēlreiz poga ir redzama
                this.jButton2.setVisible(true);
                 
            }
        }
    }
  
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel1.setText("Uzminiet vārdu");

        jLabel2.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        jLabel2.setText("****");
        jLabel2.setAlignmentX(0.5F);

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jButton1.setText("Minēt");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel3.setText("Paziņojums");

        jLabel4.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel4.setText("Dzīvības: X");
        jLabel4.setAlignmentX(0.5F);

        jButton2.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jButton2.setText("SPĒLĒT VĒLREIZ");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel5.setText("jLabel5");

        jLabel6.setText("jLabel6");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(90, 90, 90)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(84, 84, 84)
                                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 577, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 409, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(90, 90, 90)
                                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 594, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField1))
                        .addGap(49, 49, 49)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(63, 63, 63)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 512, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(66, Short.MAX_VALUE))
        );

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
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Karatavas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Karatavas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Karatavas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Karatavas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Karatavas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
