package com.example.cardapiobackend;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/pedidos")
@CrossOrigin(origins = "*")
public class PedidoController {

    @PostMapping
    public String receberPedido(@RequestBody List<ItemPedidoDTO> itens) {
        System.out.println("====== NOVO PEDIDO CHEGOU ======");

        double total = 0;
        for (ItemPedidoDTO item : itens) {
            System.out.println("Item: " + item.getNome() + " | Preço: R$ " + item.getPreco());
            total += item.getPreco();
        }
        String totalFormatado = String.format("%.2f", total);

        System.out.println("TOTAL DO PEDIDO: R$ " + total);
        System.out.println("=================================");

        return "Pedido recebido no backend Java! Total: R$ " + total;
    }
}