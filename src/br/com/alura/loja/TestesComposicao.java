package br.com.alura.loja;

import br.com.alura.loja.orcamento.ItemOrcamento;
import br.com.alura.loja.orcamento.Orcamento;
import br.com.alura.loja.orcamento.OrcamentoProxy;

import java.math.BigDecimal;

// Padrão composite
public class TestesComposicao {
    public static void main(String[] args) {
        Orcamento antigo = new Orcamento();
        antigo.adicionarItem(new ItemOrcamento(new BigDecimal("200")));
        antigo.reprovar();

        Orcamento novo = new Orcamento();
        novo.adicionarItem(new ItemOrcamento(new BigDecimal("500")));

        /* Só é possível adicionar um orçamento antigo em um novo porque
        eles estão ligados pela interface. O getValor de ambas é criado
        na interface e reescrito na classe, e os itens da lista são do tipo
        da inteface, não da classe Orçamento */
        novo.adicionarItem(antigo);

        OrcamentoProxy proxy = new OrcamentoProxy(novo);

        // Teste do padrão Proxy. A lentidão para a primeira consulta permanece, mas não há mais para a segunda
        System.out.println(proxy.getValor());
        System.out.println(proxy.getValor());
        System.out.println(proxy.getValor());
        System.out.println(proxy.getValor());
        System.out.println(proxy.getValor());
        System.out.println(proxy.getValor());
    }
}
