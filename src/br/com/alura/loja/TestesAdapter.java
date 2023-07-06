package br.com.alura.loja;

import br.com.alura.loja.http.JavaHttpClient;
import br.com.alura.loja.orcamento.ItemOrcamento;
import br.com.alura.loja.orcamento.Orcamento;
import br.com.alura.loja.orcamento.RegistroDeOrcamento;

import java.math.BigDecimal;
import java.math.BigInteger;

public class TestesAdapter {
    public static void main(String[] args) {
        Orcamento orcamento = new Orcamento();
        orcamento.adicionarItem(new ItemOrcamento(new BigDecimal("10")));
        orcamento.aprovar();
        orcamento.finalizar();

        // Chamada com erro por conta de API fictícia
        RegistroDeOrcamento registro = new RegistroDeOrcamento(new JavaHttpClient());
        registro.registra(orcamento);
    }
}
