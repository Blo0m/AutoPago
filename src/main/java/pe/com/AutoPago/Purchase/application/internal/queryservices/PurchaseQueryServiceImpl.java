package pe.com.AutoPago.Purchase.application.internal.queryservices;

import org.springframework.stereotype.Service;
import pe.com.AutoPago.Purchase.domain.model.entities.Purchase;
import pe.com.AutoPago.Purchase.domain.model.queries.GetAllPurchasesQuery;
import pe.com.AutoPago.Purchase.domain.model.queries.GetPurchaseByIdQuery;
import pe.com.AutoPago.Purchase.domain.services.PurchaseQueryService;
import pe.com.AutoPago.Purchase.infrastructure.persistence.jpa.repositories.PurchaseRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PurchaseQueryServiceImpl implements PurchaseQueryService {
    private final PurchaseRepository purchaseRepository;

    public PurchaseQueryServiceImpl(PurchaseRepository purchaseRepository) {
        this.purchaseRepository = purchaseRepository;
    }

    @Override
    public List<Purchase> handle(GetAllPurchasesQuery query) {
        return this.purchaseRepository.findAll();
    }

    @Override
    public Optional<Purchase> handle(GetPurchaseByIdQuery query) {
        return this.purchaseRepository.findById(query.id());
    }
}
