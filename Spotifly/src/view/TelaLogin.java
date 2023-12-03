package view;
import javax.swing.JOptionPane;

import models.Usuario;
import models.UsuarioComum;
import models.UsuarioPremium;
import repository.VectorUsuario;


public class TelaLogin extends javax.swing.JFrame {

    private VectorUsuario repositorioUsuarios;

    public TelaLogin() {
        this.repositorioUsuarios = new VectorUsuario();
        initComponents();
    }

    public TelaLogin(VectorUsuario repVectorUsuario) {
        initComponents();
        this.repositorioUsuarios = repVectorUsuario;
    }

    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();

        btnVoltar = new javax.swing.JButton();
        
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jPasswordField1 = new javax.swing.JPasswordField();
        jPasswordField1.setEchoChar('\u2022');
        jLabel2 = new javax.swing.JLabel();
        btnEntrar = new javax.swing.JButton();
        jCheckBoxMostrarSenha = new javax.swing.JCheckBox("Mostrar Senha");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                new PrimeiraTela().setVisible(true);
                dispose();
            }
        });

        jLabel1.setText("Usuário");

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jPasswordField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPasswordField1ActionPerformed(evt);
            }
        });

        jCheckBoxMostrarSenha.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCheckBoxMostrarSenhaItemStateChanged(evt);
            }
        });

        btnEntrar.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                realizarLogin();
            }
        });


        jLabel2.setText("Senha");

        btnVoltar.setText("Voltar");

        btnEntrar.setText("Entrar");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(btnEntrar)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1)
                            .addComponent(jTextField1)
                            .addComponent(jPasswordField1, javax.swing.GroupLayout.DEFAULT_SIZE, 282, Short.MAX_VALUE)
                            .addComponent(jCheckBoxMostrarSenha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnVoltar)
                            )))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(btnVoltar)
                .addGap(50, 50, 50)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(jCheckBoxMostrarSenha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEntrar)
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
    }// </editor-fold>                        

    private void realizarLogin() {
        String username = jTextField1.getText();
        String password = new String(jPasswordField1.getPassword());


        System.out.println("Username: " + username);
        System.out.println("Password: " + password);
    
        repositorioUsuarios.desserializarUsuarios();
        Usuario usuario = repositorioUsuarios.buscarUsuario(username);
    
        if (usuario != null && usuario.getPassword().equals(password)) {
            // Login bem-sucedido
            if (usuario instanceof UsuarioPremium) {
                System.out.println("Login bem-sucedido");
                JOptionPane.showMessageDialog(null, "Login bem-sucedido como usuário premium!");
                // Faça a lógica específica para usuários premium, se necessário
                 new PaginaInicial(usuario).setVisible(true);
                 
                 dispose();
            } else {
                // Usuário comum
                JOptionPane.showMessageDialog(null, "Login bem-sucedido como usuário comum!");
                // Faça a lógica específica para usuários comuns, se necessário
                
                new PaginaInicial(usuario).setVisible(true);
                 
                dispose();
            }
        } else {
            System.out.println("Login falhou");
            
            JOptionPane.showMessageDialog(null, "Usuário e/ou Senha não correspondem");
            }
            

    }

    private void jCheckBoxMostrarSenhaItemStateChanged(java.awt.event.ItemEvent evt) {
        if (jCheckBoxMostrarSenha.isSelected()) {
            jPasswordField1.setEchoChar((char) 0); // Mostrar a senha
        } else {
            jPasswordField1.setEchoChar('\u2022'); // Ocultar a senha com bolinhas
        }
    }
    

    
    
    


    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {                                            
   
    }                                           

    private void jPasswordField1ActionPerformed(java.awt.event.ActionEvent evt) {  

    }
             
    private javax.swing.JButton btnEntrar;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JCheckBox jCheckBoxMostrarSenha;
             
}
