principal_amount = 1000000.00
monthly_emi = 15000.00
annual_interest_rate = 0.12


monthly_interest_rate = annual_interest_rate / 12


num_emis = 0
while principal_amount > 0:
    interest_payment = principal_amount * monthly_interest_rate
    principal_payment = monthly_emi - interest_payment
    principal_amount -= principal_payment
    num_emis += 1

print("Number of EMIs required to complete the loan:", num_emis)
