package pe.com.AutoPago.Purchase.interfaces.rest.transform;

import pe.com.AutoPago.Purchase.domain.model.commands.CreatePurchaseCommand;
import pe.com.AutoPago.Purchase.interfaces.rest.resources.CreatePurchaseResource;

public class CreatePurchaseCommandFromResourceAssembler {
    public static CreatePurchaseCommand toCommandFromResource(CreatePurchaseResource resource){
        return new CreatePurchaseCommand(resource.salePrice(), resource.initialPercentage(), resource.interestRate(), resource.rateType(), resource.paymentsNumber(), resource.notarialCost(), resource.registrationCost(), resource.gps(), resource.portage(), resource.administrationCost(), resource.creditLifeInsurancePercentage(), resource.riskInsurancePercentage());
    }
}
