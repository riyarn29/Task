ERROR 2024-04-10 09:14:33 [http-nio-8080-exec-23]
  c.s.dlp.service.StatementProcessorService - Processing failed

java.util.ConcurrentModificationException
  at java.util.ArrayList$Itr.checkForComodification(ArrayList.java:911)
  at java.util.ArrayList$Itr.next(ArrayList.java:861)
  at c.s.dlp.service.StatementProcessorService
       .filterTransactions(StatementProcessorService.java:142)
  at c.s.dlp.service.StatementProcessorService
       .processStatement(StatementProcessorService.java:98)
  at c.s.dlp.controller.StatementController
       .upload(StatementController.java:67)


//Answer the following three questions:
//1.	What is the exact cause of ConcurrentModificationException in Java?

 //Ans. ConcurrentModificationException occurs when a collection(e.g ArrayList) is modified after creating an iterator object.

//2.	What code pattern at line 142 most likely triggered this error?

//Ans. i think an element from the ArrayList was removed while iterating the elements from the list using a for each loop

//3.	Provide the minimal code change (one or two lines) that resolves this safely.

    //  Ans. instead of calling transaction.remove() method we can call iterator.remove()

 // Iterator<Transaction> itr   =     transactions.iterator();
// while(itr.hasNext()){
//Transaction tx  = itr.next();
//if(tx.isInvalid()){
//itr.remove();
//}
//}
