public List<LoanAccount> getOverdueLoans(List<LoanAccount> accounts) {

        //FIX 1 : in case the account list is null it will prevent the null pointer excpetion

        if(accounts==null){
       return new ArrayList<>();
        }

       //FIX 2 : initializing the result list so that null pointer exception does not occur when  we call result.add(account)
 
       List<LoanAccount> result = new ArrayList<>();

    for (LoanAccount account : accounts) {
        
      //FIX 3 : adding a condition as it is mentioned  duedate can be null for            restructed accounts

            if(account.getDueDate()!= null
             && account.getDueDate().before(new Date())) {

            if (account.getOutstandingBalance() > 0) {
                result.add(account);
            }
        }
    }
    return result;
}

// LoanAccount fields:
// Date dueDate          — may be null for restructured accounts
// double outstandingBalance
// String accountId      — always non-null
