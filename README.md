# Workshop24

## Indexes
- find value in a column more quickly
- by default, mysql looks through a column sequentially
    - okay for smalltables, but might have issues when scaling
    - speed it up by using an index
    - pros - **select** takes **less** time
    - cons - **updating** takes **more** time

- Primary key is already Indexed, others need to be created manually
    ```
    CREATE INDEX last_name_idx
    ON customers(last_name);
    ```
- Multi value indexes
    ```
    CREATE INDEX first_name_last_name_idx
    ON customers(first_name, last_name)
    ```
    - Indexes should be created in order of importance, and can be used only in that order.
- To see which columns have been indexes, use SHOW INDEXES
    ```
    SHOW INDEXES FROM customers
    ```
- Deleting indexes
    ```
    ALTER TABLE customers
    DROP INDEX last_name_idx;
    ```
- Example usage
    ```
    SELECT * FROM customers
    WHERE last_name = 'cw';
    ```
## Locks
### Pessimistic locks
- "Assume the worst"
    ```
    SELECT * from users where id=123 FOR UPDATE;
    ```
- locks the data when it is being read, no other user can modify 
until first transaction is completed
- Best practice - to lock the minimum amount of rows
- prevent data conflicts
    - banking transactions, order processing
    ```
    SELECT XXX FOR UPDATE NOWAIT
    ```
    - fails immediately if selected data is locked
### Optimistic Locks
- "Assume no conflicts will happen"
- no locking, when the user wants to update, check if there have been any changes since last read.
    - if there have been changes, the update will fail and the user will have to retry the operation
- use version numbers or timestamps
    ```
    UPDATE orders
    SET customer_name = 'John Doe', version = version + 1
    WHERE order_id = 123 AND version = 1;
    ```
- use when performance is priority and low likelihood of conflicts

## User defined session variables
- Tied to current session
- Temporarily store values
    ```
    SET @BananaCount = 20;
    SELECT @NewBanana := 5;
    -- Perform operations and assignment
    SELECT @TotalBanana := @BananaCount +@NewBanana;
    -- Print
    SELECT @TotalBanana;
    ```
## Conditional updates
- To be added
## Transactions
- Operations must either be fully complete or not done at all (Atomicity)
- At end of transaction - Either **Commit** or **Rollback**
- Multiple transactions can occur independently and concurrently (Isolation) - operations are not visible to others
- Must be ACID
    - Atomicity
    - Consistency
    - Isolation
    - Durability

### Isolation levels
```
@Transactional(isolation=Isolation.SERIALIZABLE)
public void transfer(String fromAcct, String toAcct, double amount){}
```
- READ_UNCOMMITTED,READ_COMMITTED,REPEATABLE_READ,SERIALIZABLE



