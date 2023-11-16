package pe.com.AutoPago.Purchase.interfaces.rest.resources;

public record CreateCreditResource(String currency, Long vehiclePrice, Long feeNumber, Long initialFeeAmount, String url, String gracePeriodType, Long gracePeriodFeeNumber, String interestRateType, Long interestRatePercentage, Long notarialCost, Long registerCost, Long gps, Long ports, Long administrationBills, Long lifeInsurancePercentage, Long riskInsurancePercentage, String initialDate, String finalDate) {
}
