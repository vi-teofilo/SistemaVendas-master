/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.foursys.vendas.view;

import br.com.foursys.vendas.controller.VendasController;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;

public class VendasPrincipal extends javax.swing.JFrame {

    VendasController vendaController = new VendasController(VendasPrincipal.this);

    public VendasPrincipal() {
        initComponents();
        setLocationRelativeTo(null);
        this.vendaController.carregarComboCliente();
        this.vendaController.carregarComboFuncionario();
        this.vendaController.carregarComboProduto();
        this.vendaController.bloqueioInicial();
        setVisible(true);
    }

    public JTable getTabelaPagamento() {
        return tabelaPagamento;
    }

    public void setTabelaPagamento(JTable tabelaPagamento) {
        this.tabelaPagamento = tabelaPagamento;
    }

    public JTable getTabelaProduto() {
        return tabelaProduto;
    }

    public JTextField getJtfDescontoPagamento() {
        return jtfDescontoPagamento;
    }

    public void setJtfDescontoPagamento(JTextField jtfDescontoFormaDePagamento) {
        this.jtfDescontoPagamento = jtfDescontoFormaDePagamento;
    }

    public void setTabelaProduto(JTable tabelaProduto) {
        this.tabelaProduto = tabelaProduto;
    }

    public VendasController getVendaController() {
        return vendaController;
    }

    public void setVendaController(VendasController vendaController) {
        this.vendaController = vendaController;
    }

    public JButton getJbtAdicionarProduto() {
        return jbtAdicionarProduto;
    }

    public void setJbtAdicionarProduto(JButton jbtAdicionarProduto) {
        this.jbtAdicionarProduto = jbtAdicionarProduto;
    }

    public JButton getJbtCancelar() {
        return jbtCancelar;
    }

    public void setJbtCancelar(JButton jbtCancelar) {
        this.jbtCancelar = jbtCancelar;
    }

    public JButton getJbtConfirmar() {
        return jbtConfirmar;
    }

    public void setJbtConfirmar(JButton jbtConfirmar) {
        this.jbtConfirmar = jbtConfirmar;
    }

    public JButton getJbtExcluirFormaDePagamento() {
        return jbtExcluirFormaDePagamento;
    }

    public void setJbtExcluirFormaDePagamento(JButton jbtExcluirFormaDePagamento) {
        this.jbtExcluirFormaDePagamento = jbtExcluirFormaDePagamento;
    }

    public JButton getJbtExcluirProduto() {
        return jbtExcluirProduto;
    }

    public void setJbtExcluirProduto(JButton jbtExcluirProduto) {
        this.jbtExcluirProduto = jbtExcluirProduto;
    }

    public JButton getJbtIncluirFormaDePagamento() {
        return jbtIncluirFormaDePagamento;
    }

    public void setJbtIncluirFormaDePagamento(JButton jbtIncluirFormaDePagamento) {
        this.jbtIncluirFormaDePagamento = jbtIncluirFormaDePagamento;
    }

    public JButton getJbtIniciarVenda() {
        return jbtIniciarVenda;
    }

    public void setJbtIniciarVenda(JButton jbtIniciarVenda) {
        this.jbtIniciarVenda = jbtIniciarVenda;
    }

    public JButton getJbtSair() {
        return jbtSair;
    }

    public void setJbtSair(JButton jbtSair) {
        this.jbtSair = jbtSair;
    }

    public JComboBox<String> getJcbCliente() {
        return jcbCliente;
    }

    public void setJcbCliente(JComboBox<String> jcbCliente) {
        this.jcbCliente = jcbCliente;
    }

    public JComboBox<String> getJcbFormaDePagamento() {
        return jcbFormaDePagamento;
    }

    public void setJcbFormaDePagamento(JComboBox<String> jcbFormaDePagamento) {
        this.jcbFormaDePagamento = jcbFormaDePagamento;
    }

    public JComboBox<String> getJcbFuncionario() {
        return jcbFuncionario;
    }

    public void setJcbFuncionario(JComboBox<String> jcbFuncionario) {
        this.jcbFuncionario = jcbFuncionario;
    }

    public JComboBox<String> getJcbProduto() {
        return jcbProduto;
    }

    public void setJcbProduto(JComboBox<String> jcbProduto) {
        this.jcbProduto = jcbProduto;
    }

   

    public JTextField getJtfDescontoProduto() {
        return jtfDescontoProduto;
    }

    public void setJtfDescontoProduto(JTextField jtfDescontoProduto) {
        this.jtfDescontoProduto = jtfDescontoProduto;
    }

    public JTextField getJtfQuantidade() {
        return jtfQuantidade;
    }

    public void setJtfQuantidade(JTextField jtfQuantidade) {
        this.jtfQuantidade = jtfQuantidade;
    }

   

    public JLabel getJlbValorTotal() {
        return jlbValorTotal;
    }

    public void setJlbValorTotal(JLabel jlbValorTotal) {
        this.jlbValorTotal = jlbValorTotal;
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jcbCliente = new javax.swing.JComboBox<String>();
        jcbFuncionario = new javax.swing.JComboBox<String>();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jtfDescontoProduto = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jcbProduto = new javax.swing.JComboBox<String>();
        jbtAdicionarProduto = new javax.swing.JButton();
        jbtExcluirProduto = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelaProduto = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jcbFormaDePagamento = new javax.swing.JComboBox<String>();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabelaPagamento = new javax.swing.JTable();
        jbtIncluirFormaDePagamento = new javax.swing.JButton();
        jbtExcluirFormaDePagamento = new javax.swing.JButton();
        jtfDescontoPagamento = new javax.swing.JTextField();
        jtfQuantidade = new javax.swing.JTextField();
        jbtConfirmar = new javax.swing.JButton();
        jbtCancelar = new javax.swing.JButton();
        jbtSair = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jlbValorTotal = new javax.swing.JLabel();
        jbtIniciarVenda = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Controle de Vendas");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Dados Cliente "));

        jLabel1.setText("Cliente: ");

        jLabel15.setText("Funcionário:");

        jcbCliente.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-Selecione um Cliente-" }));
        jcbCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbClienteActionPerformed(evt);
            }
        });

        jcbFuncionario.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-Selecione um funcionário-" }));
        jcbFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbFuncionarioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(40, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel15))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jcbCliente, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jcbFuncionario, 0, 698, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jcbCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15)
                    .addComponent(jcbFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Produtos"));

        jLabel2.setText("Descrição:");

        jLabel5.setText("Quantidade:");

        jtfDescontoProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfDescontoProdutoActionPerformed(evt);
            }
        });
        jtfDescontoProduto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtfDescontoProdutoKeyReleased(evt);
            }
        });

        jLabel7.setText("Desconto:");

        jcbProduto.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-Selecione um Produto-" }));
        jcbProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbProdutoActionPerformed(evt);
            }
        });

        jbtAdicionarProduto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/foursys/vendas/img/salvar.png"))); // NOI18N
        jbtAdicionarProduto.setText("Adicionar Produto");
        jbtAdicionarProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtAdicionarProdutoActionPerformed(evt);
            }
        });

        jbtExcluirProduto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/foursys/vendas/img/excluir.png"))); // NOI18N
        jbtExcluirProduto.setText("Remover Produto");
        jbtExcluirProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtExcluirProdutoActionPerformed(evt);
            }
        });

        tabelaProduto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Descrição", "Quantidade", "Valor Unitário", "Desconto", "Valor Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tabelaProduto);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Formas de Pagamento "));

        jLabel3.setText("Forma de Pagamento:");

        jcbFormaDePagamento.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-Selecione uma forma de pagamento-", "1-Dinheiro", "2-Débito", "3-Crédito", "4-Cheque" }));

        jLabel8.setText("Desconto:");

        tabelaPagamento.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Forma de pagamento"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tabelaPagamento);

        jbtIncluirFormaDePagamento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/foursys/vendas/img/salvar.png"))); // NOI18N
        jbtIncluirFormaDePagamento.setText("Incluir Forma de Pagamento");
        jbtIncluirFormaDePagamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtIncluirFormaDePagamentoActionPerformed(evt);
            }
        });

        jbtExcluirFormaDePagamento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/foursys/vendas/img/cancelar.png"))); // NOI18N
        jbtExcluirFormaDePagamento.setText("Remover Forma de Pagamento");
        jbtExcluirFormaDePagamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtExcluirFormaDePagamentoActionPerformed(evt);
            }
        });

        jtfDescontoPagamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfDescontoPagamentoActionPerformed(evt);
            }
        });
        jtfDescontoPagamento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtfDescontoPagamentoKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jbtIncluirFormaDePagamento, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jbtExcluirFormaDePagamento, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jcbFormaDePagamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfDescontoPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 574, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcbFormaDePagamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jtfDescontoPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtIncluirFormaDePagamento, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtExcluirFormaDePagamento, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jtfQuantidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfQuantidadeActionPerformed(evt);
            }
        });
        jtfQuantidade.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtfQuantidadeKeyReleased(evt);
            }
        });

        jbtConfirmar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/foursys/vendas/img/venda.gif"))); // NOI18N
        jbtConfirmar.setText("Confirmar");
        jbtConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtConfirmarActionPerformed(evt);
            }
        });

        jbtCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/foursys/vendas/img/cancelar.png"))); // NOI18N
        jbtCancelar.setText("Cancelar");
        jbtCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtCancelarActionPerformed(evt);
            }
        });

        jbtSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/foursys/vendas/img/sair.png"))); // NOI18N
        jbtSair.setText("Sair");
        jbtSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtSairActionPerformed(evt);
            }
        });

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED), "Valor Total", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        jlbValorTotal.setText("0.0");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlbValorTotal)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlbValorTotal)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jcbProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfDescontoProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                            .addComponent(jbtAdicionarProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
                            .addComponent(jbtExcluirProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jbtSair, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jbtCancelar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jbtConfirmar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
                                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jcbProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jtfQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(jtfDescontoProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtAdicionarProduto)
                    .addComponent(jbtExcluirProduto))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbtConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jbtCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbtSair, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(49, Short.MAX_VALUE))
        );

        jbtIniciarVenda.setText("INICIAR VENDA");
        jbtIniciarVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtIniciarVendaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtIniciarVenda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbtIniciarVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtIniciarVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtIniciarVendaActionPerformed
        this.vendaController.acaoBotaoIniciarVenda();
    }//GEN-LAST:event_jbtIniciarVendaActionPerformed

    private void jbtAdicionarProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtAdicionarProdutoActionPerformed
        this.vendaController.inserirProduto();
    }//GEN-LAST:event_jbtAdicionarProdutoActionPerformed

    private void jbtCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtCancelarActionPerformed
        this.vendaController.acaoBotaoCancelar();
    }//GEN-LAST:event_jbtCancelarActionPerformed

    private void jbtSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtSairActionPerformed
        dispose();
    }//GEN-LAST:event_jbtSairActionPerformed

    private void jcbClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbClienteActionPerformed
        this.vendaController.liberarIniciarVenda();
    }//GEN-LAST:event_jcbClienteActionPerformed

    private void jcbFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbFuncionarioActionPerformed
        this.vendaController.liberarIniciarVenda();
    }//GEN-LAST:event_jcbFuncionarioActionPerformed

    private void jcbProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbProdutoActionPerformed
      
    }//GEN-LAST:event_jcbProdutoActionPerformed

    private void jtfQuantidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfQuantidadeActionPerformed
       
    }//GEN-LAST:event_jtfQuantidadeActionPerformed

    private void jtfDescontoProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfDescontoProdutoActionPerformed
       
    }//GEN-LAST:event_jtfDescontoProdutoActionPerformed

    private void jtfQuantidadeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfQuantidadeKeyReleased
       ;
    }//GEN-LAST:event_jtfQuantidadeKeyReleased

    private void jtfDescontoProdutoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfDescontoProdutoKeyReleased
        
    }//GEN-LAST:event_jtfDescontoProdutoKeyReleased

    private void jbtIncluirFormaDePagamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtIncluirFormaDePagamentoActionPerformed
       this.vendaController.inserirFormaPagamento();  
    }//GEN-LAST:event_jbtIncluirFormaDePagamentoActionPerformed

    private void jtfDescontoPagamentoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfDescontoPagamentoKeyReleased
        this.vendaController.inserirFormaPagamento();
    }//GEN-LAST:event_jtfDescontoPagamentoKeyReleased

    private void jbtExcluirFormaDePagamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtExcluirFormaDePagamentoActionPerformed
       this.vendaController.removerFormaPagamento();
    }//GEN-LAST:event_jbtExcluirFormaDePagamentoActionPerformed

    private void jbtExcluirProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtExcluirProdutoActionPerformed
         this.vendaController.excluirProduto();
    }//GEN-LAST:event_jbtExcluirProdutoActionPerformed

    private void jbtConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtConfirmarActionPerformed
        this.vendaController.salvar();
    }//GEN-LAST:event_jbtConfirmarActionPerformed

    private void jtfDescontoPagamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfDescontoPagamentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfDescontoPagamentoActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton jbtAdicionarProduto;
    private javax.swing.JButton jbtCancelar;
    private javax.swing.JButton jbtConfirmar;
    private javax.swing.JButton jbtExcluirFormaDePagamento;
    private javax.swing.JButton jbtExcluirProduto;
    private javax.swing.JButton jbtIncluirFormaDePagamento;
    private javax.swing.JButton jbtIniciarVenda;
    private javax.swing.JButton jbtSair;
    private javax.swing.JComboBox<String> jcbCliente;
    private javax.swing.JComboBox<String> jcbFormaDePagamento;
    private javax.swing.JComboBox<String> jcbFuncionario;
    private javax.swing.JComboBox<String> jcbProduto;
    private javax.swing.JLabel jlbValorTotal;
    private javax.swing.JTextField jtfDescontoPagamento;
    private javax.swing.JTextField jtfDescontoProduto;
    private javax.swing.JTextField jtfQuantidade;
    private javax.swing.JTable tabelaPagamento;
    private javax.swing.JTable tabelaProduto;
    // End of variables declaration//GEN-END:variables

}
