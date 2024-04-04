package com.swapcode.accounts.dto;


import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
@Schema(
        name = "Account",
        description = "Schema to hold Account information"
)
public class AccountsDto {

    @Schema(
            description = "AccountNumber of the Bank account", example = "3456782723"
    )
    @NotEmpty(message = "AccountNumber can not be Null or empty")
    @Pattern(regexp = "($|[0-9]{10})",message = "AccountNumber must be 10 digits")
    private Long accountNumber;

    @Schema(
            description = "AccountType of the Bank account",example = "Saving"
    )
    @NotEmpty(message = "AccountType can not be Null or empty")
    private String accountType;

//    @Schema(
//            description = "BranchAddress of the Bank", example = "123 Kothrud"
//    )
    @NotEmpty(message = "BranchAddress can not be Null or empty")
    private String branchAddress;

}
