package pe.com.AutoPago.Purchase.domain.services;

import pe.com.AutoPago.Purchase.domain.model.commands.CreatePurchaseCommand;

public interface PurchaseCommandService {
    Long handle(CreatePurchaseCommand command);
}
