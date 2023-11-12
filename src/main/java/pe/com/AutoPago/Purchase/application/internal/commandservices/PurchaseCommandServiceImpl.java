package pe.com.AutoPago.Purchase.application.internal.commandservices;

import org.springframework.stereotype.Service;
import pe.com.AutoPago.Purchase.domain.model.commands.CreatePurchaseCommand;
import pe.com.AutoPago.Purchase.domain.model.entities.Purchase;
import pe.com.AutoPago.Purchase.domain.model.queries.GetPurchaseByIdQuery;
import pe.com.AutoPago.Purchase.domain.services.PurchaseCommandService;
import pe.com.AutoPago.Purchase.infrastructure.persistence.jpa.repositories.PurchaseRepository;

@Service
public class PurchaseCommandServiceImpl implements PurchaseCommandService {
    private final PurchaseRepository purchaseRepository;

    public PurchaseCommandServiceImpl(PurchaseRepository purchaseRepository) {
        this.purchaseRepository = purchaseRepository;
    }


    @Override
    public Long handle(CreatePurchaseCommand command) {
        var purchase = new Purchase(command.salePrice(), command.initialPercentage(), command.interestRate(), command.rateType(), command.paymentsNumber(), command.notarialCost(), command.registrationCost(), command.gps(), command.portage(), command.administrationCost(), command.creditLifeInsurancePercentage(), command.riskInsurancePercentage());
        purchaseRepository.save(purchase);
        return purchase.getId();
    }
}
