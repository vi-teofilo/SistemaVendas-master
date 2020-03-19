/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.foursys.vendas.view;

import br.com.foursys.vendas.controller.ConfirmaContasPagarController;
import br.com.foursys.vendas.model.Compra;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author pbido
 */
public class ConfirmarContasPagar extends javax.swing.JFrame {

    ConfirmaContasPagarController controller = new ConfirmaContasPagarController(ConfirmarContasPagar.this);

    public ConfirmarContasPagar(Compra compra) {
        initComponents();
        setLocationRelativeTo(null);
        this.controller.carregaDadosCompra(compra);
        this.controller.carregaContaPagar();
        setVisible(true);
    }

    public ConfirmaContasPagarController getController() {
        return controller;
    }

    public void setController(ConfirmaContasPagarController controller) {
        this.controller = controller;
    }

    public JButton getJbtConfirmar() {
        return jbtConfirmar;
    }

    public void setJbtConfirmar(JButton jbtConfirmar) {
        this.jbtConfirmar = jbtConfirmar;
    }

    public JComboBox getJcbPagamento() {
        return jcbPagamento;
    }

    public void setJcbPagamento(JComboBox jcbPagamento) {
        this.jcbPagamento = jcbPagamento;
    }

    public JComboBox getJcbVencimento() {
        return jcbVencimento;
    }

    public void setJcbVencimento(JComboBox jcbVencimento) {
        this.jcbVencimento = jcbVencimento;
    }

    public JLabel getJlbDataCompra() {
        return jlbDataCompra;
    }

    public void setJlbDataCompra(JLabel jlbDataCompra) {
        this.jlbDataCompra = jlbDataCompra;
    }

    public JLabel getJlbDataVencimento() {
        return jlbDataVencimento;
    }

    public void setJlbDataVencimento(JLabel jlbDataVencimento) {
        this.jlbDataVencimento = jlbDataVencimento;
    }

    public JLabel getJlbFormaPagamento() {
        return jlbFormaPagamento;
    }

    public void setJlbFormaPagamento(JLabel jlbFormaPagamento) {
        this.jlbFormaPagamento = jlbFormaPagamento;
    }

    public JLabel getJlbFormaPgtoText() {
        return jlbFormaPgtoText;
    }

    public void setJlbFormaPgtoText(JLabel jlbFormaPgtoText) {
        this.jlbFormaPgtoText = jlbFormaPgtoText;
    }

    public JLabel getJlbFornecedor() {
        return jlbFornecedor;
    }

    public void setJlbFornecedor(JLabel jlbFornecedor) {
        this.jlbFornecedor = jlbFornecedor;
    }

    public JLabel getJlbFornecedorText() {
        return jlbFornecedorText;
    }

    public void setJlbFornecedorText(JLabel jlbFornecedorText) {
        this.jlbFornecedorText = jlbFornecedorText;
    }

    public JLabel getJlbFuncionario() {
        return jlbFuncionario;
    }

    public void setJlbFuncionario(JLabel jlbFuncionario) {
        this.jlbFuncionario = jlbFuncionario;
    }

    public JLabel getJlbFuncionarioText() {
        return jlbFuncionarioText;
    }

    public void setJlbFuncionarioText(JLabel jlbFuncionarioText) {
        this.jlbFuncionarioText = jlbFuncionarioText;
    }

    public JLabel getJlbPagamento() {
        return jlbPagamento;
    }

    public void setJlbPagamento(JLabel jlbPagamento) {
        this.jlbPagamento = jlbPagamento;
    }

    public JLabel getJlbValorCompra() {
        return jlbValorCompra;
    }

    public void setJlbValorCompra(JLabel jlbValorCompra) {
        this.jlbValorCompra = jlbValorCompra;
    }

    public JLabel getJlbValorCompraText() {
        return jlbValorCompraText;
    }

    public void setJlbValorCompraText(JLabel jlbValorCompraText) {
        this.jlbValorCompraText = jlbValorCompraText;
    }

    public JLabel getJlbVencimento() {
        return jlbVencimento;
    }

    public void setJlbVencimento(JLabel jlbVencimento) {
        this.jlbVencimento = jlbVencimento;
    }

    public JPanel getJpnCompra() {
        return jpnCompra;
    }

    public void setJpnCompra(JPanel jpnCompra) {
        this.jpnCompra = jpnCompra;
    }

    public JPanel getJpnContasPagar() {
        return jpnContasPagar;
    }

    public void setJpnContasPagar(JPanel jpnContasPagar) {
        this.jpnContasPagar = jpnContasPagar;
    }

    public JFormattedTextField getJtfDataCompra() {
        return jtfDataCompra;
    }

    public void setJtfDataCompra(JFormattedTextField jtfDataCompra) {
        this.jtfDataCompra = jtfDataCompra;
    }

    public JFormattedTextField getJtfDataVencimento() {
        return jtfDataVencimento;
    }

    public void setJtfDataVencimento(JFormattedTextField jtfDataVencimento) {
        this.jtfDataVencimento = jtfDataVencimento;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpnContasPagar = new javax.swing.JPanel();
        jlbDataCompra = new javax.swing.JLabel();
        jtfDataCompra = new javax.swing.JFormattedTextField();
        jlbDataVencimento = new javax.swing.JLabel();
        jtfDataVencimento = new javax.swing.JFormattedTextField();
        jlbPagamento = new javax.swing.JLabel();
        jcbPagamento = new javax.swing.JComboBox();
        jlbVencimento = new javax.swing.JLabel();
        jcbVencimento = new javax.swing.JComboBox();
        jpnCompra = new javax.swing.JPanel();
        jlbValorCompraText = new javax.swing.JLabel();
        jlbFormaPgtoText = new javax.swing.JLabel();
        jlbFuncionarioText = new javax.swing.JLabel();
        jlbFornecedorText = new javax.swing.JLabel();
        jlbValorCompra = new javax.swing.JLabel();
        jlbFormaPagamento = new javax.swing.JLabel();
        jlbFuncionario = new javax.swing.JLabel();
        jlbFornecedor = new javax.swing.JLabel();
        jbtConfirmar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Lançamento de Contas a Pagar");

        jpnContasPagar.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Contas a Pagar", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        jlbDataCompra.setText("Data da Compra:");

        try {
            jtfDataCompra.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jtfDataCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfDataCompraActionPerformed(evt);
            }
        });

        jlbDataVencimento.setText("Data de Vencimento:");

        try {
            jtfDataVencimento.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jlbPagamento.setText("Pagamento:");

        jcbPagamento.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-", "Sim", "Não" }));

        jlbVencimento.setText("Vencimento:");

        jcbVencimento.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-", "Sim", "Não" }));

        javax.swing.GroupLayout jpnContasPagarLayout = new javax.swing.GroupLayout(jpnContasPagar);
        jpnContasPagar.setLayout(jpnContasPagarLayout);
        jpnContasPagarLayout.setHorizontalGroup(
            jpnContasPagarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnContasPagarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpnContasPagarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jlbPagamento)
                    .addComponent(jlbDataCompra))
                .addGap(18, 18, 18)
                .addGroup(jpnContasPagarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jtfDataCompra)
                    .addComponent(jcbPagamento, 0, 65, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jpnContasPagarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jlbVencimento)
                    .addComponent(jlbDataVencimento))
                .addGap(18, 18, 18)
                .addGroup(jpnContasPagarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jtfDataVencimento)
                    .addComponent(jcbVencimento, 0, 65, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpnContasPagarLayout.setVerticalGroup(
            jpnContasPagarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnContasPagarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpnContasPagarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbDataCompra)
                    .addComponent(jtfDataCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlbDataVencimento)
                    .addComponent(jtfDataVencimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpnContasPagarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbPagamento)
                    .addComponent(jcbPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlbVencimento)
                    .addComponent(jcbVencimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jpnCompra.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Dados da Compra", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        jlbValorCompraText.setText("Valor da Compra:");

        jlbFormaPgtoText.setText("Forma de Pagamento:");

        jlbFuncionarioText.setText("Funcionário:");

        jlbFornecedorText.setText("Fornecedor:");

        javax.swing.GroupLayout jpnCompraLayout = new javax.swing.GroupLayout(jpnCompra);
        jpnCompra.setLayout(jpnCompraLayout);
        jpnCompraLayout.setHorizontalGroup(
            jpnCompraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnCompraLayout.createSequentialGroup()
                .addGroup(jpnCompraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpnCompraLayout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jlbValorCompraText))
                    .addGroup(jpnCompraLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jlbFormaPgtoText))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnCompraLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jpnCompraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlbFuncionarioText, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jlbFornecedorText, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpnCompraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlbValorCompra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jlbFormaPagamento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jlbFuncionario, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 275, Short.MAX_VALUE)
                    .addComponent(jlbFornecedor, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jpnCompraLayout.setVerticalGroup(
            jpnCompraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnCompraLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpnCompraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jpnCompraLayout.createSequentialGroup()
                        .addGroup(jpnCompraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jpnCompraLayout.createSequentialGroup()
                                .addGroup(jpnCompraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jlbValorCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jlbValorCompraText))
                                .addGap(25, 25, 25))
                            .addGroup(jpnCompraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jlbFormaPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jlbFormaPgtoText)))
                        .addGap(25, 25, 25))
                    .addGroup(jpnCompraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jlbFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jlbFuncionarioText)))
                .addGroup(jpnCompraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jlbFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlbFornecedorText))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jbtConfirmar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/foursys/vendas/img/salvar.png"))); // NOI18N
        jbtConfirmar.setText("Confirmar");
        jbtConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtConfirmarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jpnCompra, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpnContasPagar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jbtConfirmar)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpnContasPagar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jpnCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jbtConfirmar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtConfirmarActionPerformed
        this.controller.acaoBotaoConfirmar();
    }//GEN-LAST:event_jbtConfirmarActionPerformed

    private void jtfDataCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfDataCompraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfDataCompraActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jbtConfirmar;
    private javax.swing.JComboBox jcbPagamento;
    private javax.swing.JComboBox jcbVencimento;
    private javax.swing.JLabel jlbDataCompra;
    private javax.swing.JLabel jlbDataVencimento;
    private javax.swing.JLabel jlbFormaPagamento;
    private javax.swing.JLabel jlbFormaPgtoText;
    private javax.swing.JLabel jlbFornecedor;
    private javax.swing.JLabel jlbFornecedorText;
    private javax.swing.JLabel jlbFuncionario;
    private javax.swing.JLabel jlbFuncionarioText;
    private javax.swing.JLabel jlbPagamento;
    private javax.swing.JLabel jlbValorCompra;
    private javax.swing.JLabel jlbValorCompraText;
    private javax.swing.JLabel jlbVencimento;
    private javax.swing.JPanel jpnCompra;
    private javax.swing.JPanel jpnContasPagar;
    private javax.swing.JFormattedTextField jtfDataCompra;
    private javax.swing.JFormattedTextField jtfDataVencimento;
    // End of variables declaration//GEN-END:variables
}
