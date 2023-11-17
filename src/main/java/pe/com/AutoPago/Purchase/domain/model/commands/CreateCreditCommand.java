package pe.com.AutoPago.Purchase.domain.model.commands;

public record CreateCreditCommand(String currency, Long vehiclePrice, Long feeNumber, Long initialFeeAmount, String url, String gracePeriodType, Long gracePeriodFeeNumber, String interestRateType, Long interestRatePercentage, Long notarialCost, Long registerCost, Long gps, Long ports, Long administrationBills, Long lifeInsurancePercentage, Long riskInsurancePercentage, Long cok, String initialDate, String finalDate) {
}
