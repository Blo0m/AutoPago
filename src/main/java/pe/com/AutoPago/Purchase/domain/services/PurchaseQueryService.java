package pe.com.AutoPago.Purchase.domain.services;

import pe.com.AutoPago.Purchase.domain.model.entities.Purchase;
import pe.com.AutoPago.Purchase.domain.model.queries.GetAllPurchasesQuery;
import pe.com.AutoPago.Purchase.domain.model.queries.GetPurchaseByIdQuery;

import java.util.List;
import java.util.Optional;

public interface PurchaseQueryService {
    List<Purchase> handle(GetAllPurchasesQuery query);

    Optional<Purchase> handle(GetPurchaseByIdQuery query);
}
