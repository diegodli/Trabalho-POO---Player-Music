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
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        btnEntrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Usuário");

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        btnEntrar.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                realizarLogin();
            }
        });

        jLabel2.setText("Senha");

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
                            .addComponent(jTextField2, javax.swing.GroupLayout.DEFAULT_SIZE, 282, Short.MAX_VALUE))))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
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
    }// </editor-fold>                        

    private void realizarLogin() {
        String username = jTextField1.getText();
        String password = jTextField2.getText();

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
            
            if (repositorioUsuarios.existe(username)) {
                JOptionPane.showMessageDialog(null, "Senha Incorreta");
            }
            else {
                JOptionPane.showMessageDialog(null, "Criando uma nova conta para o usuário...");

                // Criar uma nova conta com o usuário e senha fornecidos
                if (password.equals("premium")) {
                    // Criar usuário premium
                    usuario = new UsuarioPremium(username, password);
                } else {
                    // Criar usuário comum
                    usuario = new UsuarioComum(username, password);
                }

                // Adicionar o novo usuário ao repositório
                repositorioUsuarios.cadastrarUsuario(usuario);
                repositorioUsuarios.serializarUsuarios();

                // Redirecionar para a tela de página inicial
                new PaginaInicial(usuario).setVisible(true);

                // Fechar o frame de login após o login bem-sucedido
                dispose();
            }
        }
    }
    


    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {                                            
   
    }                                           

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {  
    }  
    public static void main(String args[]) {
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaLogin().setVisible(true);
            }
        });
    }                   
    private javax.swing.JButton btnEntrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;                
}
