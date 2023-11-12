package pe.com.AutoPago.Purchase.interfaces.rest.transform;

import pe.com.AutoPago.Purchase.domain.model.entities.Purchase;
import pe.com.AutoPago.Purchase.interfaces.rest.resources.PurchaseResource;

public class PurchaseResourceFromEntityAssembler {
    public static PurchaseResource toResourceFromEntity(Purchase entity) {
        return new PurchaseResource(entity.getId(), entity.getSalePrice(), entity.getInitialPercentage(), entity.getInterestRate(), entity.getRateType(), entity.getPaymentsNumber(), entity.getNotarialCost(), entity.getRegistrationCost(), entity.getGps(), entity.getPortage(), entity.getAdministrationCost(), entity.getCreditLifeInsurancePercentage(), entity.getRiskInsurancePercentage());
    }
}
