package calculadora;

/*
Name: Weverton Ryan Ribeiro da Mata 
Describe: Project for school
*/

public class TelinhaCalculadora extends javax.swing.JFrame {

    static int p = 0;
    String textox;
    Double resultado;

    public TelinhaCalculadora() {
        initComponents();
    }

    public static Double AddSub(String e) {
        Double numero1 = MulDiv(e), numero2;
        char caractere = e.charAt(p);
        if (caractere == ')') {
            p = p + 1;
            return numero1;
        }
        if (p < e.length() && numero1 != null) {
            if (caractere == '+') {
                p = p + 1;
                numero2 = AddSub(e);
                if (numero2 != null) {
                    return numero1 + numero2;
                }
            } else if (caractere == '-') {
                numero2 = AddSub(e);
                if (numero2 != null) {
                    return numero1 + numero2;
                }
            }
        }
        return numero1;
    }

    public static Double MulDiv(String e) {
        Double numero1 = Out(e), numero2;
        char caractere = e.charAt(p);
        if (caractere == ')') {
            return numero1;
        }
        if (p < e.length() && numero1 != null) {
            if (caractere == '*') {
                p = p + 1;
                numero2 = MulDiv(e);
                if (numero2 != null) {
                    return numero1 * numero2;
                }
            } else if (caractere == '÷') {
                p = p + 1;
                numero2 = MulDiv(e);
                if (numero2 != null) {
                    return numero1 / numero2;
                }
            }
        }
        return numero1;
    }

    public static Double Out(String e) {
        Double numero1 = Paren(e), numero2;
        char caractere = e.charAt(p);
        if (caractere == ')') {
            return numero1;
        }
        if (p < e.length() && numero1 != null) {
            switch (caractere) {
                case '√':
                    p = p + 1;
                    numero2 = Out(e);
                    if (numero2 != null) {
                        return numero1 * Math.sqrt(numero2);
                    }   break;
                case '^':
                    p = p + 1;
                    numero2 = Out(e);
                    if (numero2 != null) {
                        return Math.pow(numero1, numero2);
                    }   break;
                case '%':
                    p = p + 1;
                    numero2 = Out(e);
                    if (numero2 == null) {
                        return numero1 / 100;
                    } else if (numero2 != null) {
                        return (numero1 * numero2 / 100);
                    }   break;
                default:
                    break;
            }
        } else if (caractere == '√') {
            p = p + 1;
            numero2 = Out(e);
            if (numero2 != null) {
                return Math.sqrt(numero2);
            }
        } else if (caractere == '-') {
            p = p + 1;
            numero2 = Out(e);
            if (numero2 != null) {
                String negativo = "-";
                String contatenei = negativo + numero2;
                Double vai = new Double(contatenei);
                return vai;
            }
        }
        return numero1;
    }

    public static Double Paren(String e) {
        Double numero1 = Num(e);
        char caractere = e.charAt(p);
        if (caractere == '(') {
            p = p + 1;
            return AddSub(e);
        }
        return numero1;
    }

    public static Double Num(String e) {
        String texto = "";
        Double numero = null;
        boolean temPontinho = false;
        boolean temNumero = false;
        char caractere = e.charAt(p);
        while (Character.isDigit(caractere) || caractere == '.') {
            if (temPontinho == false && caractere == '.') {
                texto = texto + caractere;
                temPontinho = true;
            } else {
                if (Character.isDigit(caractere)) {
                    texto = texto + caractere;
                }
            }
            p = p + 1;
            caractere = e.charAt(p);
            temNumero = true;
        }
        if (temNumero) {
            numero = new Double(texto);
        } else {
            if (temPontinho) {
                numero = new Double(texto);
            }
        }
        return numero;
    }

    public void atualizaHistorico(String texto) {
        String textoHistorico = jTextArea_Historico.getText();
        if (textoHistorico.equals("")) {
            jTextArea_Historico.setText(texto);
        } else {
            String[] linhas = textoHistorico.split("\n");
            int limite = 5;
            if (linhas.length < limite) {
                jTextArea_Historico.setText(textoHistorico + "\n" + texto);
            } else {
                String textoAtualizado = "";
                for (int i = 0; i < limite - 1; i++) {
                    linhas[i] = linhas[i + 1];
                    textoAtualizado = textoAtualizado + linhas[i] + "\n";
                }
                textoAtualizado = textoAtualizado + texto;
                jTextArea_Historico.setText(textoAtualizado);
            }
        }
        jTextField_Calculo.setText("");
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jTextArea_Historico = new javax.swing.JTextArea();
        jTextField_Calculo = new javax.swing.JTextField();
        jTextField_a = new javax.swing.JTextField();
        jTextField_b = new javax.swing.JTextField();
        jTextField_c = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton15 = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();
        jButton17 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        jButton18 = new javax.swing.JButton();
        jButton19 = new javax.swing.JButton();
        jButton20 = new javax.swing.JButton();
        jButton21 = new javax.swing.JButton();
        jButton22 = new javax.swing.JButton();
        jButton23 = new javax.swing.JButton();
        jButton24 = new javax.swing.JButton();
        jButton25 = new javax.swing.JButton();
        jButton27 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Calculadora do Poder");
        setResizable(false);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextArea_Historico.setEditable(false);
        jTextArea_Historico.setColumns(20);
        jTextArea_Historico.setForeground(new java.awt.Color(39, 36, 36));
        jTextArea_Historico.setRows(5);
        jTextArea_Historico.setAutoscrolls(false);
        jTextArea_Historico.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jTextArea_Historico.setDisabledTextColor(new java.awt.Color(44, 41, 38));
        jTextArea_Historico.setEnabled(false);
        jPanel1.add(jTextArea_Historico, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 408, -1));
        jTextArea_Historico.getAccessibleContext().setAccessibleParent(this);

        jTextField_Calculo.setAutoscrolls(false);
        jTextField_Calculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_CalculoActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField_Calculo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 408, -1));

        jTextField_a.setAutoscrolls(false);
        jTextField_a.setDisabledTextColor(new java.awt.Color(44, 41, 38));
        jTextField_a.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_aActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField_a, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 313, 46, -1));

        jTextField_b.setAutoscrolls(false);
        jTextField_b.setDisabledTextColor(new java.awt.Color(44, 41, 38));
        jTextField_b.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_bActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField_b, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 312, 46, -1));

        jTextField_c.setAutoscrolls(false);
        jTextField_c.setDisabledTextColor(new java.awt.Color(44, 41, 38));
        jTextField_c.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_cActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField_c, new org.netbeans.lib.awtextra.AbsoluteConstraints(229, 312, 46, -1));

        jLabel1.setFont(new java.awt.Font("Ubuntu", 1, 17)); // NOI18N
        jLabel1.setText("  x²  +");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(52, 312, 46, -1));

        jLabel2.setFont(new java.awt.Font("Ubuntu", 1, 17)); // NOI18N
        jLabel2.setText("    =    0");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(281, 311, 70, -1));

        jLabel3.setFont(new java.awt.Font("Ubuntu", 1, 17)); // NOI18N
        jLabel3.setText("x   + ");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(168, 311, -1, -1));

        jButton15.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jButton15.setText("×");
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton15, new org.netbeans.lib.awtextra.AbsoluteConstraints(168, 216, 46, -1));

        jButton16.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jButton16.setText("÷");
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton16, new org.netbeans.lib.awtextra.AbsoluteConstraints(168, 264, 46, -1));

        jButton17.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jButton17.setText("=");
        jButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton17ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton17, new org.netbeans.lib.awtextra.AbsoluteConstraints(229, 264, 180, -1));

        jButton1.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jButton1.setText("1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 46, -1));

        jButton2.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jButton2.setText("2");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(52, 120, 46, -1));

        jButton3.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jButton3.setText("3");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 120, 46, -1));

        jButton4.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jButton4.setText("4");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 168, 46, -1));

        jButton5.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jButton5.setText("5");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(52, 168, 46, -1));

        jButton6.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jButton6.setText("6");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 168, 46, -1));

        jButton7.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jButton7.setText("7");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 216, 46, -1));

        jButton8.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jButton8.setText("8");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(52, 216, 46, -1));

        jButton9.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jButton9.setText("9");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton9, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 216, 46, -1));

        jButton10.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jButton10.setText("0");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton10, new org.netbeans.lib.awtextra.AbsoluteConstraints(52, 264, 46, -1));

        jButton11.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jButton11.setText("%");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 264, 46, -1));

        jButton12.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jButton12.setText(".");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton12, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 264, 46, -1));

        jButton13.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jButton13.setText("+");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton13, new org.netbeans.lib.awtextra.AbsoluteConstraints(168, 120, 46, -1));

        jButton14.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jButton14.setText("-");
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton14, new org.netbeans.lib.awtextra.AbsoluteConstraints(168, 168, 46, -1));

        jButton18.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jButton18.setText("CE");
        jButton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton18ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton18, new org.netbeans.lib.awtextra.AbsoluteConstraints(229, 120, 55, -1));

        jButton19.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jButton19.setText("C");
        jButton19.setToolTipText("Aqui limpa tudo, zé! =)");
        jButton19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton19ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton19, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 120, 118, -1));

        jButton20.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jButton20.setText("(");
        jButton20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton20ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton20, new org.netbeans.lib.awtextra.AbsoluteConstraints(229, 168, 55, -1));

        jButton21.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jButton21.setText(")");
        jButton21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton21ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton21, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 168, 55, -1));

        jButton22.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jButton22.setText("a^b");
        jButton22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton22ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton22, new org.netbeans.lib.awtextra.AbsoluteConstraints(229, 216, 55, -1));

        jButton23.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jButton23.setText("√");
        jButton23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton23ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton23, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 216, 55, -1));

        jButton24.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jButton24.setText("f(x)");
        jButton24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton24ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton24, new org.netbeans.lib.awtextra.AbsoluteConstraints(351, 168, 57, -1));

        jButton25.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jButton25.setText("g(x)");
        jButton25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton25ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton25, new org.netbeans.lib.awtextra.AbsoluteConstraints(351, 216, -1, -1));

        jButton27.setText("Δ");
        jButton27.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton27ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton27, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 310, 60, -1));

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
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String textoCalculo = jTextField_Calculo.getText();
        textoCalculo = textoCalculo + "1";
        jTextField_Calculo.setText(textoCalculo);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        String textoCalculo = jTextField_Calculo.getText();
        textoCalculo = textoCalculo + "2";
        jTextField_Calculo.setText(textoCalculo);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        String textoCalculo = jTextField_Calculo.getText();
        textoCalculo = textoCalculo + "3";
        jTextField_Calculo.setText(textoCalculo);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        String textoCalculo = jTextField_Calculo.getText();
        textoCalculo = textoCalculo + "4";
        jTextField_Calculo.setText(textoCalculo);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        String textoCalculo = jTextField_Calculo.getText();
        textoCalculo = textoCalculo + "5";
        jTextField_Calculo.setText(textoCalculo);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        String textoCalculo = jTextField_Calculo.getText();
        textoCalculo = textoCalculo + "6";
        jTextField_Calculo.setText(textoCalculo);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        String textoCalculo = jTextField_Calculo.getText();
        textoCalculo = textoCalculo + "7";
        jTextField_Calculo.setText(textoCalculo);
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        String textoCalculo = jTextField_Calculo.getText();
        textoCalculo = textoCalculo + "8";
        jTextField_Calculo.setText(textoCalculo);
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        String textoCalculo = jTextField_Calculo.getText();
        textoCalculo = textoCalculo + "9";
        jTextField_Calculo.setText(textoCalculo);
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        String textoCalculo = jTextField_Calculo.getText();
        textoCalculo = textoCalculo + "0";
        jTextField_Calculo.setText(textoCalculo);
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        String textoCalculo = jTextField_Calculo.getText();
        textoCalculo = textoCalculo + "%";
        jTextField_Calculo.setText(textoCalculo);
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        String textoCalculo = jTextField_Calculo.getText();
        textoCalculo = textoCalculo + ".";
        jTextField_Calculo.setText(textoCalculo);
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        String textoCalculo = jTextField_Calculo.getText();
        textoCalculo = textoCalculo + "+";
        jTextField_Calculo.setText(textoCalculo);
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        String textoCalculo = jTextField_Calculo.getText();
        textoCalculo = textoCalculo + "-";
        jTextField_Calculo.setText(textoCalculo);
    }//GEN-LAST:event_jButton14ActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        String textoCalculo = jTextField_Calculo.getText();
        textoCalculo = textoCalculo + "*";
        jTextField_Calculo.setText(textoCalculo);
    }//GEN-LAST:event_jButton15ActionPerformed

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
        String textoCalculo = jTextField_Calculo.getText();
        textoCalculo = textoCalculo + "÷";
        jTextField_Calculo.setText(textoCalculo);
    }//GEN-LAST:event_jButton16ActionPerformed

    private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton17ActionPerformed
        textox = jTextField_Calculo.getText();
        p = 0;
        textox = textox.replace(",", ".");
        resultado = AddSub(textox.replace(" ", "") + "\0");
        if (resultado == null) {
            jTextArea_Historico.setText("A expressão " + textox + " está mal formada! =/");
        } else {
            atualizaHistorico(textox + " = " + resultado);
        }
    }//GEN-LAST:event_jButton17ActionPerformed

    private void jButton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton18ActionPerformed
        String textoCalculo = jTextField_Calculo.getText();
        if (!textoCalculo.trim().equals("")) {
            jTextField_Calculo.setText(textoCalculo.substring(0, textoCalculo.length() - 1));
        }
    }//GEN-LAST:event_jButton18ActionPerformed

    private void jButton19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton19ActionPerformed
        jTextField_Calculo.setText("");
        jTextArea_Historico.setText("");
    }//GEN-LAST:event_jButton19ActionPerformed

    private void jButton20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton20ActionPerformed
        String textoCalculo = jTextField_Calculo.getText();
        textoCalculo = textoCalculo + "(";
        jTextField_Calculo.setText(textoCalculo);
    }//GEN-LAST:event_jButton20ActionPerformed

    private void jButton21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton21ActionPerformed
        String textoCalculo = jTextField_Calculo.getText();
        textoCalculo = textoCalculo + ")";
        jTextField_Calculo.setText(textoCalculo);
    }//GEN-LAST:event_jButton21ActionPerformed

    private void jButton22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton22ActionPerformed
        String textoCalculo = jTextField_Calculo.getText();
        textoCalculo = textoCalculo + "^";
        jTextField_Calculo.setText(textoCalculo);
    }//GEN-LAST:event_jButton22ActionPerformed

    private void jButton23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton23ActionPerformed
        String textoCalculo = jTextField_Calculo.getText();
        textoCalculo = textoCalculo + "√";
        jTextField_Calculo.setText(textoCalculo);
    }//GEN-LAST:event_jButton23ActionPerformed

    private void jButton24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton24ActionPerformed
        double x = new Double(jTextField_Calculo.getText());
        double resul = 4 * x - 8;
        String imprimituto = "F(" + x + ") -> 4(" + x + ") - 8 = " + resul;
        atualizaHistorico(imprimituto);
    }//GEN-LAST:event_jButton24ActionPerformed

    private void jButton25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton25ActionPerformed
        double x = new Double(jTextField_Calculo.getText());
        double resul = Math.pow(x, 2) + 2 * x - 3;
        String imprimituto = "G(" + x + ") -> 2(" + x + ") - 3 = " + resul;
        atualizaHistorico(imprimituto);
    }//GEN-LAST:event_jButton25ActionPerformed

    private void jTextField_cActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_cActionPerformed
        // Tela C
    }//GEN-LAST:event_jTextField_cActionPerformed

    private void jTextField_aActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_aActionPerformed
        // Tela A
    }//GEN-LAST:event_jTextField_aActionPerformed

    private void jTextField_bActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_bActionPerformed
        // Tela B
    }//GEN-LAST:event_jTextField_bActionPerformed

    private void jButton27ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton27ActionPerformed
        if (!jTextField_a.getText().equals("") || !jTextField_b.getText().equals("") || !jTextField_c.getText().equals("")) {
            String textoBaskara;
            double a = new Double(jTextField_a.getText().equals("") ? "0.0" : jTextField_a.getText());
            double b = new Double(jTextField_b.getText().equals("") ? "0.0" : jTextField_b.getText());
            double c = new Double(jTextField_c.getText().equals("") ? "0.0" : jTextField_c.getText());

            if (a == 0) {
                textoBaskara = a + "x² + " + b + "x + " + c + " = 0 nem é equação do segundo grau!";
            } else {
                double delta = Math.pow(b, 2) - 4 * a * c;
                if (delta < 0.0) {
                    textoBaskara = "Não existem raízes reais para " + a + "x² + " + b + "x + " + c + " = 0";
                } else {
                    double x1 = (-b - Math.sqrt(delta)) / (2 * a);
                    double x2 = (-b + Math.sqrt(delta)) / (2 * a);
                    textoBaskara = "Δ = " + delta + ", x' = " + x1 + " e x\" = " + x2 + " para " + a + "x² + " + b + "x + " + c + " = 0";
                }
            }
            jTextField_a.setText("");
            jTextField_b.setText("");
            jTextField_c.setText("");
            atualizaHistorico(textoBaskara);
        }
    }//GEN-LAST:event_jButton27ActionPerformed

    private void jTextField_CalculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_CalculoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_CalculoActionPerformed

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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelinhaCalculadora.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new TelinhaCalculadora().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton20;
    private javax.swing.JButton jButton21;
    private javax.swing.JButton jButton22;
    private javax.swing.JButton jButton23;
    private javax.swing.JButton jButton24;
    private javax.swing.JButton jButton25;
    private javax.swing.JButton jButton27;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextArea jTextArea_Historico;
    private javax.swing.JTextField jTextField_Calculo;
    private javax.swing.JTextField jTextField_a;
    private javax.swing.JTextField jTextField_b;
    private javax.swing.JTextField jTextField_c;
    // End of variables declaration//GEN-END:variables
}
