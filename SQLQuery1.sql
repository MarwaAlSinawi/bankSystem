use BankSystem;
select * from  account;
select * from  customer;
Select * from credit_card;
Select * from loan;
Select * from account_transaction;



UPDATE account_transaction 
SET 
    account_id = 6
WHERE
    id = 3;