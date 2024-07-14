-- Update account_id for each card type
UPDATE card SET account_id = 1 WHERE name = 'DEBIT CARD';
UPDATE card SET account_id = 2 WHERE name = 'CREDIT CARD';
UPDATE card SET account_id = 3 WHERE name = 'PREPAID CARD';
UPDATE card SET account_id = 4 WHERE name = 'VIRTUAL CARD';
UPDATE card SET account_id = 5 WHERE name = 'REWARD CARD';
