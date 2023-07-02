---
Problem statement:

You need to write a Java program that reads a CSV file containing a list of bank transactions and performs the following operations:
		1. Read the CSV file and create a list of "Transaction' objects, where each object represents a transaction in the file.
		2. Calculate the total balance of the account by summing up all the transaction amounts.
		3. Find the transaction with the highest amount.
		4. Find the transaction with the lowest amount.
		5. Find the average transaction amount.
		6. Handle errors gracefully by catching and handling any exceptions that may occur during file reading or transaction processing.

Your implementation should conform to the following requirements:
1. The program should use Exception Handling to handle any potential errors during file	reading or transaction processing.
2. The program should use the "CsvToBean" class from the 'opencsv'" library to read the CSV file.
3. The program should use appropriate exception handling techniques, such as try-catch blocks, to catch and handle any exceptions that may occur.
4. The program should have a clean and user-friendly interface.

Your task is to complete the methods defined in the file below:
1. ../src/main/java/com/tasks/problem/TransactionService.java

Notes:
1. Ensure that the structure and datatype of the components are followed as specified in the comments to ensure that the code is evaluated correctly.
2. Use Test App & Submit option often so you will be guided by test error messages.
3. When you delete or edit something you shouldn’t have, test messages will give an error accordingly
4. You will receive a congratulations message upon successful completion of the task.
5. You can add a helper method in the same service class or a helper class in the same/other package.
6. You need to provide complete implementation to all the public service methods in TransactionService.java