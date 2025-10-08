Title: [ES FISCAL] Show customer TIN and validation for all Spanish users
Goal: Guarantee TIN visibility and compliance for Spanish merchants

Business context:
- Applies to AEAT and non-AEAT merchants.
- Linked to regulation: transactions > €3000 must have TIN.

Business Rules:
R1. Customer TIN visible on Customer Info Screen.
R2. Block transaction if total > €3000 and TIN missing.
R3. Validation triggered on payment, split, and tips screens.

Examples:
- Total = 3200, no TIN → error “Customer TIN required…”
- Total = 2999 → allowed
- Tips +400 after 2900 → triggers validation

Open questions:
- Refunds > 3000?
- Gift cards?
- Multi-currency rounding?

