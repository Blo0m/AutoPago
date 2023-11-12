package pe.com.AutoPago.Purchase.domain.model.commands;

public record CreatePurchaseCommand(Long salePrice, Long initialPercentage, Long interestRate, String rateType, Long paymentsNumber, Long notarialCost, Long registrationCost, Long gps, Long portage, Long administrationCost, Long creditLifeInsurancePercentage, Long riskInsurancePercentage) {
}
