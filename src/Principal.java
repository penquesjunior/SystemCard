import java.util.Collections;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.printf("Digite o limite do cartão: ");
        double limite = sc.nextDouble();
        CartaoDeCredito cartaoDeCredito = new CartaoDeCredito(limite);

        int sair = 1;
        while(sair != 0){
            System.out.printf("Digite o item a ser comprado: ");
            String descricao = sc.next();
            System.out.printf("Digite o valor da Compra: ");
            double valorCompra = sc.nextDouble();

            Compra compra = new Compra(descricao,valorCompra);
            boolean compraRealizada = cartaoDeCredito.lancaCompra(compra);


            if(compraRealizada){
                System.out.println("Compra realizada!");
                System.out.println("Saldo atualizado do cartão: " + cartaoDeCredito.getSaldo());
                System.out.println("Digite 0 para sair ou 1 para continuar");
                sair = sc.nextInt();
            }else{
                System.out.println("Saldo Insuficiente!");
                sair =0;
            }
        }
        System.out.println("************************");
        System.out.println("COMPRAS REALIZADAS:\n");
        Collections.sort(cartaoDeCredito.getCompras());
        for(Compra c: cartaoDeCredito.getCompras()){
            System.out.println(c.getDescricao() + " - " + c.getValor());
        }
        System.out.println("************************");

        System.out.println("\nSaldo do cartão: " + cartaoDeCredito.getSaldo());

    }
}
