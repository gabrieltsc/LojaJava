package br.com.alura.loja;

import br.com.alura.loja.pedido.GeraPedido;
import br.com.alura.loja.pedido.GeraPedidoHandler;
import br.com.alura.loja.pedido.acao.EnviarEmailPedido;
import br.com.alura.loja.pedido.acao.LogDePedido;
import br.com.alura.loja.pedido.acao.SalvarPedidoNoBancoDeDados;

import java.math.BigDecimal;
import java.util.Arrays;

public class TestesPedidos {

    public static void main(String[] args) {
        String cliente = "Rodrigo";
        BigDecimal valorOrcamento = new BigDecimal("745.99");
        int quantidadeItens = 3;

        GeraPedido gerador = new GeraPedido(cliente, valorOrcamento, quantidadeItens);
        GeraPedidoHandler handler = new GeraPedidoHandler(Arrays.asList(
                new SalvarPedidoNoBancoDeDados(),
                new EnviarEmailPedido(),
                new LogDePedido()));

        handler.execute(gerador);

        // Exemplo sem o padrão Facade (Note como tudo está junto na execução)
        /*
        Conta minhaConta = new Conta();
        Conta outra = new Conta();

        BigDecimal valorTransferencia = new BigDecimal("100");
        Transferencia transferencia = new Transferencia();
        transferencia.validarConta(minhaConta);
        transferencia.validarConta(outra);
        transferencia.checarSaldo(minhaConta, valorTransferencia);

        transferencia.executar(minhaConta, outra, valorTransferencia); // Só essa parte deve ser necessária na main
        */
    }
}
