package br.com.alura.loja.orcamento;

import java.math.BigDecimal;

public class OrcamentoProxy implements Orcavel{

    private BigDecimal valor;
    private Orcamento orcamento;

    public OrcamentoProxy(Orcamento orcamento) {
        this.orcamento = orcamento;
    }

    @Override
    public BigDecimal getValor() {
        // Só vai chamar se não houver nenhuma requisição repetida já solicitada
        if (valor == null){
            this.valor = orcamento.getValor();
        }
        return this.valor;
    }
}
