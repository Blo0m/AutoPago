package pe.com.AutoPago.Purchase.interfaces.rest;


import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.com.AutoPago.Purchase.domain.model.queries.GetAllPurchasesQuery;
import pe.com.AutoPago.Purchase.domain.model.queries.GetPurchaseByIdQuery;
import pe.com.AutoPago.Purchase.domain.services.PurchaseCommandService;
import pe.com.AutoPago.Purchase.domain.services.PurchaseQueryService;
import pe.com.AutoPago.Purchase.interfaces.rest.resources.CreatePurchaseResource;
import pe.com.AutoPago.Purchase.interfaces.rest.resources.PurchaseResource;
import pe.com.AutoPago.Purchase.interfaces.rest.transform.CreatePurchaseCommandFromResourceAssembler;
import pe.com.AutoPago.Purchase.interfaces.rest.transform.PurchaseResourceFromEntityAssembler;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api.v1/purchases", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Purchases", description = "Purchases Management Endpoints")
public class PurchaseController {
    private final PurchaseQueryService purchaseQueryService;
    private final PurchaseCommandService purchaseCommandService;

    public PurchaseController(PurchaseQueryService purchaseQueryService, PurchaseCommandService purchaseCommandService) {
        this.purchaseQueryService = purchaseQueryService;
        this.purchaseCommandService = purchaseCommandService;
    }

    @PostMapping
    public ResponseEntity<PurchaseResource> createPurchase(@RequestBody CreatePurchaseResource resource){
        var createPurchaseCommand = CreatePurchaseCommandFromResourceAssembler.toCommandFromResource(resource);

        var purchaseId = purchaseCommandService.handle(createPurchaseCommand);

        if(purchaseId == 0L) {
            return ResponseEntity.badRequest().build();
        }

        var getPurchaseIdByQuery = new GetPurchaseByIdQuery(purchaseId);
        var purchase = purchaseQueryService.handle(getPurchaseIdByQuery);

        if(purchase.isEmpty()){
            return ResponseEntity.badRequest().build();
        }

        var purchaseResource = PurchaseResourceFromEntityAssembler.toResourceFromEntity(purchase.get());
        return new ResponseEntity<>(purchaseResource, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<PurchaseResource>> getAllPurchases() {
        var getAllPurchasesQuery = new GetAllPurchasesQuery();
        var purchases = purchaseQueryService.handle(getAllPurchasesQuery);
        var purchasesResources= purchases.stream().map(PurchaseResourceFromEntityAssembler::toResourceFromEntity).collect(Collectors.toList());
        return ResponseEntity.ok(purchasesResources);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PurchaseResource> getPurchaseById(@PathVariable Long id) {
        var getPurchaseByIdQuery = new GetPurchaseByIdQuery(id);
        var purchase = purchaseQueryService.handle(getPurchaseByIdQuery);
        if(purchase.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        var purchaseResource = PurchaseResourceFromEntityAssembler.toResourceFromEntity(purchase.get());
        return ResponseEntity.ok(purchaseResource);
    }
}
