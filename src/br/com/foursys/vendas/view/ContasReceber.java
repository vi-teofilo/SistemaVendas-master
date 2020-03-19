/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.foursys.vendas.view;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author pbido
 */
public class ContasReceber extends javax.swing.JFrame {

    /**
     * Creates new form ContasPagar
     */
    public ContasReceber() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpnContasPagar = new javax.swing.JPanel();
        jlbDataLancamento = new javax.swing.JLabel();
        jtfDataLancamento = new javax.swing.JFormattedTextField();
        jlbDataVencimento = new javax.swing.JLabel();
        jtfDataVencimento = new javax.swing.JFormattedTextField();
        jlbPagamento = new javax.swing.JLabel();
        jcbPagamento = new javax.swing.JComboBox();
        jlbVencimento = new javax.swing.JLabel();
        jcbVencimento = new javax.swing.JComboBox();
        jpnCompra = new javax.swing.JPanel();
        jlbValorVenda = new javax.swing.JLabel();
        jlbFormaPgtoText = new javax.swing.JLabel();
        jlbFuncionarioText = new javax.swing.JLabel();
        jlbFornecedorText = new javax.swing.JLabel();
        jlbValorCompra = new javax.swing.JLabel();
        jlbFormaPagamento = new javax.swing.JLabel();
        jlbFuncionario = new javax.swing.JLabel();
        jlbFornecedor = new javax.swing.JLabel();
        jbtConfirmar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Lançamento de Contas a Receber");

        jpnContasPagar.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Contas a Receber", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        jlbDataLancamento.setText("Data de Lançamento:");

        try {
            jtfDataLancamento.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

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
                    .addComponent(jlbDataLancamento))
                .addGap(18, 18, 18)
                .addGroup(jpnContasPagarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jtfDataLancamento)
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
                    .addComponent(jlbDataLancamento)
                    .addComponent(jtfDataLancamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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

        jpnCompra.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Dados da Venda", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        jlbValorVenda.setText("Valor da Venda:");

        jlbFormaPgtoText.setText("Forma de Pagamento:");

        jlbFuncionarioText.setText("Funcionário:");

        jlbFornecedorText.setText("Cliente:");

        jlbValorCompra.setText("R$ 37986,77");

        jlbFormaPagamento.setText("Crédito");

        jlbFuncionario.setText("Pedro Henrique");

        jlbFornecedor.setText("José");

        javax.swing.GroupLayout jpnCompraLayout = new javax.swing.GroupLayout(jpnCompra);
        jpnCompra.setLayout(jpnCompraLayout);
        jpnCompraLayout.setHorizontalGroup(
            jpnCompraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnCompraLayout.createSequentialGroup()
                .addGroup(jpnCompraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpnCompraLayout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jlbValorVenda))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnCompraLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jpnCompraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlbFornecedorText, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jlbFuncionarioText, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jlbFormaPgtoText, javax.swing.GroupLayout.Alignment.TRAILING))))
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
                .addGroup(jpnCompraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbValorCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlbValorVenda))
                .addGap(9, 9, 9)
                .addGroup(jpnCompraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbFormaPgtoText)
                    .addComponent(jlbFormaPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpnCompraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbFuncionarioText)
                    .addComponent(jlbFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpnCompraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbFornecedorText)
                    .addComponent(jlbFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jbtConfirmar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/foursys/vendas/img/salvar.png"))); // NOI18N
        jbtConfirmar.setText("Confirmar");

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

    public JLabel getJlbDataLancamento() {
        return jlbDataLancamento;
    }

    public void setJlbDataLancamento(JLabel jlbDataLancamento) {
        this.jlbDataLancamento = jlbDataLancamento;
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

    public JLabel getJlbValorVenda() {
        return jlbValorVenda;
    }

    public void setJlbValorVenda(JLabel jlbValorVenda) {
        this.jlbValorVenda = jlbValorVenda;
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

    public JFormattedTextField getJtfDataLancamento() {
        return jtfDataLancamento;
    }

    public void setJtfDataLancamento(JFormattedTextField jtfDataLancamento) {
        this.jtfDataLancamento = jtfDataLancamento;
    }

    public JFormattedTextField getJtfDataVencimento() {
        return jtfDataVencimento;
    }

    public void setJtfDataVencimento(JFormattedTextField jtfDataVencimento) {
        this.jtfDataVencimento = jtfDataVencimento;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jbtConfirmar;
    private javax.swing.JComboBox jcbPagamento;
    private javax.swing.JComboBox jcbVencimento;
    private javax.swing.JLabel jlbDataLancamento;
    private javax.swing.JLabel jlbDataVencimento;
    private javax.swing.JLabel jlbFormaPagamento;
    private javax.swing.JLabel jlbFormaPgtoText;
    private javax.swing.JLabel jlbFornecedor;
    private javax.swing.JLabel jlbFornecedorText;
    private javax.swing.JLabel jlbFuncionario;
    private javax.swing.JLabel jlbFuncionarioText;
    private javax.swing.JLabel jlbPagamento;
    private javax.swing.JLabel jlbValorCompra;
    private javax.swing.JLabel jlbValorVenda;
    private javax.swing.JLabel jlbVencimento;
    private javax.swing.JPanel jpnCompra;
    private javax.swing.JPanel jpnContasPagar;
    private javax.swing.JFormattedTextField jtfDataLancamento;
    private javax.swing.JFormattedTextField jtfDataVencimento;
    // End of variables declaration//GEN-END:variables
}