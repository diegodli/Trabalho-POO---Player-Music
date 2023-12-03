package view;

import Exception.UsuarioExistenteException;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

import models.Usuario;
import models.UsuarioComum;
import models.UsuarioPremium;
import repository.VectorUsuario;


import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import java.awt.Color;



public class TelaCriarConta extends javax.swing.JFrame {

    private VectorUsuario repositorioUsuarios;

    public TelaCriarConta () {
    this.repositorioUsuarios = new VectorUsuario();
    initComponents();
    }

    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField1.setPreferredSize(new java.awt.Dimension(250, 30)); 

        tipoUsuarioComboBox = new JComboBox<>();
        tipoUsuarioComboBox.setModel(new DefaultComboBoxModel<>(new String[]{"Comum", "Premium"}));
        tipoUsuarioComboBox.setSelectedIndex(0); // Define a seleção inicial
        tipoUsuarioComboBox.setPreferredSize(new java.awt.Dimension(250, 30));

       
    
        jLabel2 = new javax.swing.JLabel();

        avisoLabel = new JLabel();
        avisoLabel.setForeground(Color.RED);
        avisoLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 5, 0)); // Adiciona uma borda inferior

        jLabel3 = new javax.swing.JLabel();
        jPasswordField1 = new JPasswordField();

        jCheckBoxMostrarSenha = new javax.swing.JCheckBox("Mostrar Senha");
        jPasswordField1.setEchoChar('\u2022');

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);


        jCheckBoxMostrarSenha.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCheckBoxMostrarSenhaItemStateChanged(evt);
            }
        });

        btnCadastrar = new javax.swing.JButton();

        btnVoltar = new javax.swing.JButton();
        

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Usuário");


        jTextField1.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                try {
                    verificarNomeUsuario();}
                catch (UsuarioExistenteException uee) {
                    avisoLabel.setText(uee.getMessage());
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                try {
                    verificarNomeUsuario();}
                catch (UsuarioExistenteException uee) {
                    avisoLabel.setText(uee.getMessage());
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
               try {
                    verificarNomeUsuario();}
                catch (UsuarioExistenteException uee) {
                    avisoLabel.setText(uee.getMessage());
                }
            }
        });

        

       

        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                new PrimeiraTela().setVisible(true);
                dispose();
            }
        });

        btnCadastrar.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
               cadastrarUsuario();
            }
        });


        jLabel2.setText("Plano");

        jLabel3.setText("Senha");

        btnVoltar.setText("Voltar");

       


        btnCadastrar.setText("Cadastrar");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnVoltar)
                    .addComponent(jLabel2)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(tipoUsuarioComboBox)
                        .addComponent(btnCadastrar)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1)
                            .addComponent(avisoLabel)
                            .addComponent(jTextField1)
                            .addComponent(jLabel3)
                            .addComponent(jPasswordField1)
                            .addComponent(jCheckBoxMostrarSenha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            )))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(btnVoltar)
                .addGap(30, 30, 30)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(avisoLabel)
                .addGap(24, 24, 24)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tipoUsuarioComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPasswordField1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(jCheckBoxMostrarSenha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                
                .addComponent(btnCadastrar)
                .addGap(14, 14, 14))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);

        repositorioUsuarios.desserializarUsuarios();
    }

   
    private void verificarNomeUsuario() throws UsuarioExistenteException {
        String username = jTextField1.getText();
        Usuario usuario = repositorioUsuarios.buscarUsuario(username);
        
        if (usuario != null) {
            btnCadastrar.setEnabled(false);
            throw new UsuarioExistenteException(username);
        } else {
            avisoLabel.setText("");
            btnCadastrar.setEnabled(true);
            
        }
    }

    private void jCheckBoxMostrarSenhaItemStateChanged(java.awt.event.ItemEvent evt) {
        if (jCheckBoxMostrarSenha.isSelected()) {
            jPasswordField1.setEchoChar((char) 0); // Mostrar a senha
        } else {
            jPasswordField1.setEchoChar('\u2022'); // Ocultar a senha com bolinhas
        }
    }
   
    private void cadastrarUsuario() {
        
        String username = jTextField1.getText();
        if ("".equals(username)) {
            JOptionPane.showMessageDialog(null, "Digite um nome de usuário");
        }
        else {
            String password = new String (jPasswordField1.getPassword());
            if ("".equals(password)) {
                JOptionPane.showMessageDialog(null, "Digite uma senha");
            }
            else {
               String tipoUsuario = (String) tipoUsuarioComboBox.getSelectedItem();
                Usuario novoUsuario = null;
                if ("Comum".equals(tipoUsuario)) {
                     novoUsuario = new UsuarioComum(username, password);

                } else if ("Premium".equals(tipoUsuario)) {
                    novoUsuario = new UsuarioPremium(username, password);

                }

                repositorioUsuarios.cadastrarUsuario(novoUsuario);
                new PaginaInicial(novoUsuario).setVisible(true);
                dispose();
            }
        }
        
        

           
    }


                                  

   
    
    /*public static void main(String args[]) {
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaCriarConta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaCriarConta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaCriarConta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaCriarConta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaCriarConta().setVisible(true);
            }
        });
    }    */
    
    private javax.swing.JButton btnVoltar;
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
   
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JPasswordField jPasswordField1;
   
    private JComboBox<String> tipoUsuarioComboBox;
    private JLabel avisoLabel;

    private javax.swing.JCheckBox jCheckBoxMostrarSenha;
             
}
