# Transaction
Rest Api Transaction Simulation

The project has been made with tne next framework:
Spring Boot
and the next plugin development:
Maven

Instructions
1. Download or clone the project from this url https://github.com/Diriangen/Transaction
2. Import your local project, from transations folder in your Eclipse IDE like General => projects from folder or archive.
3. The IDE must update all dependencies by maven.
4. Right click in your import project and select run as java aplication then select SpringBootTransactionAplication to start the aplication.
5. Open your api client to test the http api rest methods, (Postman in my case).
6. First you need to know all existing accounts, you can do it with the next get method: http://localhost:8080/transaction/getAllAccounts
7. You must select two account numbers to realize one transaction.
8. To realize one transaction you can use the next post method: http://localhost:8080/transaction/transfer
with the next argument wrote in the body raw in format JSON like the next example:
{
"fromAccount": 3000,
"toAccount": 2000,
"amount": 100
}
9. To Know all transactions for a given account you can use the next method: http://localhost:8080/transaction/getAllTransactionsByAccount
with number account like argument in the body raw in format text.
10.To know all sent transactions for a given account you can use the next method:
http://localhost:8080/transaction/getAllSentTransactions
with number account like argument in the body raw in format text.
11. To know all receive transactions for a given account you can use the next method:
http://localhost:8080/transaction/getAllRecieveTransactions
with number account like argument in the body raw in format text.
12. To know the account balance you can use the next method:
http://localhost:8080/transaction/getAccountBalance
with number account like argument in the body raw in format text.



